package com.yofc.admin.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class WeXinMessageProperty {

    @Value("${cbServer.wexin.message.remoteUrl}")
    private String remoteUrl;

    @Value("${cbServer.wexin.message.remoteUrl4Dept}")
    private String remoteUrl4Dept;

    @Value("${cbServer.wexin.message.readTimeout}")
    private Integer readTimeout;

    @Value("${cbServer.wexin.message.connectTimeout}")
    private Integer connectTimeout;

    @Value("${cbServer.wexin.message.debug}")
    private Boolean debug;

    @Value("${cbServer.weburl}")
    private String weburl;

    public String getRemoteUrl() {
        return remoteUrl;
    }

    public void setRemoteUrl(String remoteUrl) {
        this.remoteUrl = remoteUrl;
    }

    public String getRemoteUrl4Dept() {
        return remoteUrl4Dept;
    }

    public void setRemoteUrl4Dept(String remoteUrl4Dept) {
        this.remoteUrl4Dept = remoteUrl4Dept;
    }

    public Integer getReadTimeout() {
        return readTimeout;
    }

    public void setReadTimeout(Integer readTimeout) {
        this.readTimeout = readTimeout;
    }

    public Integer getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(Integer connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public Boolean getDebug() {
        return debug;
    }

    public void setDebug(Boolean debug) {
        this.debug = debug;
    }

    public String getWeburl() {
        return weburl;
    }

    public void setWeburl(String weburl) {
        this.weburl = weburl;
    }
}
