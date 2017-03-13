package com.tkylin.jdfx.core.dto;

/**
 * Created by tkyli on 2017/3/8.
 */
public class JdfxConfig {
    private String fxIndex;
    private String fxHhIndex;
    private String fxHhDetail;
    private String fxApi;
    private String fxHhApi;

    private String imageSavePath;
    private long timeoutMillis;

    public String getFxIndex() {
        return fxIndex;
    }

    public void setFxIndex(String fxIndex) {
        this.fxIndex = fxIndex;
    }

    public String getFxHhIndex() {
        return fxHhIndex;
    }

    public void setFxHhIndex(String fxHhIndex) {
        this.fxHhIndex = fxHhIndex;
    }

    public String getFxHhDetail() {
        return fxHhDetail;
    }

    public void setFxHhDetail(String fxHhDetail) {
        this.fxHhDetail = fxHhDetail;
    }

    public String getFxApi() {
        return fxApi;
    }

    public void setFxApi(String fxApi) {
        this.fxApi = fxApi;
    }

    public String getFxHhApi() {
        return fxHhApi;
    }

    public void setFxHhApi(String fxHhApi) {
        this.fxHhApi = fxHhApi;
    }

    public String getImageSavePath() {
        return imageSavePath;
    }

    public void setImageSavePath(String imageSavePath) {
        this.imageSavePath = imageSavePath;
    }

    public long getTimeoutMillis() {
        return timeoutMillis;
    }

    public void setTimeoutMillis(long timeoutMillis) {
        this.timeoutMillis = timeoutMillis;
    }
}
