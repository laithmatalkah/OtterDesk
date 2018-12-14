package com.task4.otterdesk.otterdesklaith;

public class BluePrint {

    private String id;
    private String currentProcessingPhase;
    private String fileLocation;
    private Long createTime;

 public BluePrint(){};

 
    public BluePrint(String id, String currentProcessingPhase, String fileLocation, Long createTime) {
        this.id = id;
        this.currentProcessingPhase = currentProcessingPhase;
        this.fileLocation = fileLocation;
        this.createTime = createTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCurrentProcessingPhase() {
        return currentProcessingPhase;
    }

    public void setCurrentProcessingPhase(String currentProcessingPhase) {
        this.currentProcessingPhase = currentProcessingPhase;
    }

    public String getFileLocation() {
        return fileLocation;
    }

    public void setFileLocation(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
}
