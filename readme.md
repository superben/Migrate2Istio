
# SpringCloud应用迁移到Istio

## 源码改造

**目标：**

* 去掉eureka/consul/zookeeper等注册中心的依赖
* 保留配置中心
* 禁用Feign/Ribbon的Client端负载均衡的方式 
* 迁移到Jaeger进行分布式调用链追踪

### 去除注册中心的依赖
本例中注释掉roger-framework子工程的如下依赖：

```
<!--        <dependency>-->
<!--            <groupId>org.springframework.cloud</groupId>-->
<!--            <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>-->
<!--        </dependency>-->
```

### 保留配置中心
无修改

### 调整Feign负载均衡方式
如下所示，为@FeignClient注解添加url参数：

```
@FeignClient(name = "roger-service-subject", fallback = SampleRemoteHystrixServiceImpl.class")
public interface SampleRemoteService {

    @ResponseBody
    @GetMapping(value = "/api/subject/public/sample/status", produces = {"application/json;charset=UTF-8"})
    String getStatus();
}
```

```
@FeignClient(name = "roger-service-subject", fallback = SampleRemoteHystrixServiceImpl.class, url = "${feign.subjectServiceUrl}")
public interface SampleRemoteService {

    @ResponseBody
    @GetMapping(value = "/api/subject/public/sample/status", produces = {"application/json;charset=UTF-8"})
    String getStatus();
}
```

本例中${feign.subjectServiceUrl}在配置中心的文件有如下设置，即此参数接受SUBJECT_SERVICE_URL环境变量，默认值为：localhost:8084


```
feign:
  subjectServiceUrl: ${SUBJECT_SERVICE_URL:http://localhost:8084}
```

### 调用链追踪
为使spring boot实现的微服务支持调用链追踪，需要加入如下依赖，本例中在roger-framework工程的POM.XML添加如下依赖：

```
    <dependency>
        <groupId>io.opentracing.contrib</groupId>
        <artifactId>opentracing-spring-jaeger-web-starter</artifactId>
        <version>2.0.0</version>
    </dependency>
    <dependency>
        <groupId>io.opentracing.contrib</groupId>
        <artifactId>opentracing-spring-cloud-starter</artifactId>
        <version>0.3.2</version>
    </dependency>
```
实际效果，可以看到vote-service调用subject-service时，某一条vote-service调用链可以看到subject-service调用信息，即含2条调用记录。

### 容器化相关
使用如下Dockerfile + entrypoint.sh模板进行容器化。

Dockerfile模板：

```
FROM openjdk:alpine
ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS \
    APP_SLEEP=0 \
    JAVA_OPTS="" \
    RUN_ARGS="" \
    APP_NAME_ID=""

# Add a user admin to run our application so that it doesn't need to run as root
RUN adduser -D -s /bin/sh admin
WORKDIR /home/admin
COPY entrypoint.sh \
     target/app.jar \
     /home/admin/

# Authorization
USER root
RUN chmod 755 entrypoint.sh && \
    chown -R admin:admin /home/admin

USER admin
ENTRYPOINT ["./entrypoint.sh"]
EXPOSE 8083
```

entrypoint.sh 模板：

```
#!/bin/sh -e

echo "The application will start in ${APP_SLEEP}s..." && sleep ${APP_SLEEP}
exec java -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap ${JAVA_OPTS} \
    -Djava.security.egd=file:/dev/./urandom \
    -jar "${HOME}/app.jar" ${RUN_ARGS} "$@"
```

### 部署相关

##### **环境变量**
| **Key** | **Value** |
| ------ | ------ |
| **RUN_ARGS** | --spring.profiles.active=sit |
| **CONFIG_SERVER** | http://config-server:8888 |
| **REDIS_HOST** | redis |
| **ADMIN_SERVICE_URL** | admin-service:8083 |
| **SUBJECT_SERVICE_URL** | subject-service:8084 |

**注意：以上地址使用K8s service name**

#### **测试各微服务**
前提条件：PaaS平台创建为每个待测试的微服务创建**Istio网关**

* Config server

```
curl -v config.roger.yofc.com/roger-service-admin-sit.yml
curl -v config.roger.yofc.com/roger-service-subject-sit.yml
curl -v config.roger.yofc.com/roger-service-vote-sit.yml
```

**Spring config server的 Rest API样式：**

```
    /{application}/{profile}[/{label}]
    /{application}-{profile}.yml
    /{label}/{application}-{profile}.yml
    /{application}-{profile}.properties
    /{label}/{application}-{profile}.properties
```

* Admin-service

```
curl -v admin.roger.yofc.com/api/admin/public/sample/status
curl -v admin.roger.yofc.com/api/admin/public/user/2759
```

* Subject Service

```
curl -v subject.roger.yofc.com/api/subject/public/sample/status
curl -v subject.roger.yofc.com/api/subject/public/subject/from/5
```
* Vote-service

```
curl -v vote.roger.yofc.com/api/vote/public/sample/status
curl -v vote.roger.yofc.com/api/vote/public/sample/subject/from/2
```

## Tasks
### 验证Spring Cloud Sleuth + Zipkin + Jaeger server on Istio
### [Istio Security](https://istio.io/docs/concepts/security/)
### [Istio Multicluster Deployments](https://istio.io/docs/concepts/multicluster-deployments/)
### RabbitMQ/Spring Cloud Bus/Spring Cloud Stream on Istio
### Config server solution for service mesh 

# Appendix:
## 本地Redis环境
```
docker run --name redis -p 6379:6379 -d yofc/redis:1.0
docker run -it --link redis:redis --rm redis redis-cli -h redis
```

## Docker构建命令
```
mvn package spring-boot:repackage

docker build -t yofc/roger/config:1.0 .
docker build -t yofc/roger/admin:1.0 .
docker build -t yofc/roger/subject:1.0 .
docker build -t yofc/roger/vote:1.0 .
docker build -t yofc/redis:1.0 .
```

## 导入镜像文件命令
```
docker tag yofc/redis:1.0 10.70.22.11:60080/yofc/redis:1.0
docker tag yofc/roger/vote:1.0  10.70.22.11:60080/yofc/roger/vote:1.0
docker tag yofc/roger/subject:1.0 10.70.22.11:60080/yofc/roger/subject:1.0
docker tag yofc/roger/admin:1.0 10.70.22.11:60080/yofc/roger/admin:1.0
docker tag yofc/roger/config:1.0 10.70.22.11:60080/yofc/roger/config:1.0

docker push 10.70.22.11:60080/yofc/redis:1.0
docker push 10.70.22.11:60080/yofc/roger/vote:1.0
docker push 10.70.22.11:60080/yofc/roger/subject:1.0
docker push 10.70.22.11:60080/yofc/roger/admin:1.0
docker push 10.70.22.11:60080/yofc/roger/config:1.0
```
## 安全规则
当前ASM版本在进行安全规则设置时，需要手动修改yaml文件，按如下方式添加ports.containerPort部分

```
- apiVersion: apps/v1
  kind: Deployment
  spec:
    ...
    template:
      ...
      spec:
        ...
        containers:
          - image: '10.70.22.11:60080/yofc/roger/config:2.0'
            imagePullPolicy: IfNotPresent
            name: config-server-v1
            ports:
              - containerPort: 8888

```

## Sidecar手动注射
当前ASM版本需要手动修改yaml文件，实现注射sidecar，设置sidecar.istio.io/inject值从false到true，即可

```
labels:
  ...
  sidecar.istio.io/inject: 'true'

```

## 业务应用的Metrics收集
基于Istio的业务应用采用Prometheus进行metrics的收集，但是由于Prometheus的部署方式不同，可以分为Istio原生的Helm Chart方式和Prometheus Operator方式。

### Istio原生的Helm Chart方式
如果你的Istio环境是使用官网的Helm Chart方式部署的，请使用此方式。请添加下面的annotations到你的Deployment资源。

```
prometheus.io/scrape: "true"
prometheus.io/path: "<metrics path>"
prometheus.io/port: "<metrics port>"
```

参见：[Istio环境下可以用Prometheus收集应用的Metrics吗？](https://istio.io/faq/metrics-and-logs/#prometheus-application-metrics)

样例如下：

```
apiVersion: extensions/v1beta1
kind: Deployment
metadata:
  name: metrics-demo
  namespace: default
spec:
  template:
    metadata:
      annotations:
        prometheus.io/scrape: "true"
        prometheus.io/port: "8080"
        prometheus.io/path: "/actuator/prometheus"
      ...
```

### Prometheus Operator方式
Alauda Service Mesh产品使用Prometheus Operator方式。

ServiceMonitor资源是Prometheus Operator创建的CRD，用于配置Prometheus实例收集应用的metrics。如下示例将创建一个ServiceMonitor资源。注意下列参数：

* 标签prometheus: kube-prometheus是ASM部署所设置要求的
* namespaceSelector的any: true，可以有更详尽安全的配置，请参见prometheus-operator官方文档
* 按照应用填写endpoint参数

**最佳实践：**

* 规范应用使用统一的endpoint，极大简化ServiceMonitor的配置


```
$ cat<<EOF | kubectl apply -f -
apiVersion: monitoring.coreos.com/v1
kind: ServiceMonitor
metadata:
  name: metrics-demo
  # Change this to the namespace the Prometheus instance is running in
  namespace: alauda-system
  labels:
    monitoring: services
    prometheus: kube-prometheus
spec:
  selector:
    matchLabels:
      # your target service
      app: metrics-demo 
  namespaceSelector:
    any: true
  endpoints:
    - port: http-metrics-demo
      interval: 5s
      path: /actuator/prometheus
EOF
```

参见：[prometheus-operator官方文档](https://github.com/coreos/prometheus-operator)

**注意：**
Istio原生的annotations方式在Prometheus Operator方式下，**没有作用**。ASM未来可能支持Istio原生方式。

### 如何验证应用metrics的收集
浏览器打开Prometheus UI -> Status -> Targets，搜索应用的endpoint的path串。 或

```
curl http://{Prometheus UI}/targets |grep {your endpoint's path}
```