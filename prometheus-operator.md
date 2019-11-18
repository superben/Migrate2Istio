
#Prometheus Operator使用说明#

##部署Prometheus Operator##

* Helm 版本 2.16
* prometheus-operator char 版本 5.11.0

```
# 按默认配置安装
helm install stable/prometheus-operator

# 安装到指定的ns
helm install stable/prometheus-operator  --namespace system

# 安装到指定的ns，尝试运行
helm install stable/prometheus-operator  --namespace system --dry-run

```

部署完成后，结果如下：

```
+ kubectl get pods
NAME                                                     READY   STATUS    RESTARTS   AGE
alertmanager-ungaged-lion-prometheus-op-alertmanager-0   2/2     Running   2          10d
prometheus-ungaged-lion-prometheus-op-prometheus-0       3/3     Running   4          10d
ungaged-lion-grafana-7ffc7d6cc-cnw9t                     2/2     Running   2          10d
ungaged-lion-kube-state-metrics-6594d45889-wdg9z         1/1     Running   1          10d
ungaged-lion-prometheus-node-exporter-56xmz              1/1     Running   1          10d
ungaged-lion-prometheus-node-exporter-bkjtr              1/1     Running   1          10d
ungaged-lion-prometheus-node-exporter-tsjpx              1/1     Running   1          10d
ungaged-lion-prometheus-op-operator-8678455544-4zk42     1/1     Running   1          10d
```

###Kubernetes 1.16不兼容性###
Prometheus Operator helm charts兼容Kubernetes 1.15.5

##配置ServiceMonitor##

###检查prometheus CRD###
```
+ kubectl get prometheus
NAME                                    AGE
ungaged-lion-prometheus-op-prometheus   10d
```
###检查prometheus CRD详情###
```
+ kubectl get prometheus ungaged-lion-prometheus-op-prometheus -o yaml
apiVersion: monitoring.coreos.com/v1
kind: Prometheus
metadata:
  creationTimestamp: "2019-11-07T08:42:17Z"
  generation: 1
  labels:
    app: prometheus-operator-prometheus
    chart: prometheus-operator-5.11.0
    heritage: Tiller
    release: ungaged-lion
  name: ungaged-lion-prometheus-op-prometheus
  namespace: system
  resourceVersion: "7701"
  selfLink: /apis/monitoring.coreos.com/v1/namespaces/system/prometheuses/ungaged-lion-prometheus-op-prometheus
  uid: ba677b00-e8b1-416b-8800-eb83f2649d5b
spec:
  alerting:
    alertmanagers:
    - name: ungaged-lion-prometheus-op-alertmanager
      namespace: system
      pathPrefix: /
      port: web
  baseImage: quay.io/prometheus/prometheus
  enableAdminAPI: false
  externalUrl: http://ungaged-lion-prometheus-op-prometheus.system:9090
  listenLocal: false
  logFormat: logfmt
  logLevel: info
  paused: false
  replicas: 1
  retention: 10d
  routePrefix: /
  ruleNamespaceSelector: {}
  ruleSelector:
    matchLabels:
      app: prometheus-operator
      release: ungaged-lion
  securityContext:
    fsGroup: 2000
    runAsNonRoot: true
    runAsUser: 1000
  serviceAccountName: ungaged-lion-prometheus-op-prometheus
  serviceMonitorNamespaceSelector: {}
  serviceMonitorSelector:
    matchLabels:
      release: ungaged-lion
  version: v2.9.1
```
注意下面两部分：

```
ruleSelector:
    matchLabels:
      app: prometheus-operator
      release: ungaged-lion
```
```
serviceMonitorSelector:
    matchLabels:
      release: ungaged-lion
```
###ServiceMonitor样例###

* namespace 需要和 prometheus-operator相同，这里是system
* ServiceMonitor的labels
    * 需要匹配ruleSelector. matchLabels
* 设置匹配应用的selector
* 设置应用的endpoints

```
---
apiVersion: monitoring.coreos.com/v1
kind: ServiceMonitor
metadata:
  name: provider-demo
  # Change this to the namespace the Prometheus instance is running in
  namespace: system
  labels:
    release: ungaged-lion
    app: prometheus-operator
spec:
  selector:
    matchLabels:
      # your target service
      app: provider-demo
  namespaceSelector:
    any: true
  endpoints:
    - targetPort: 9876
      interval: 5s
      path: /actuator/prometheus
```

###验证###
打开Prometheus UI，Status -> Targets，搜索你的应用名。

前提是设置Prometheus service为NodePort。

```
http://192.168.50.10:32321/targets
```

