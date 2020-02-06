package com.luigi573.mira.data;

public class Statistics {

    private int confirmedCount;
    private int suspectedCount;
    private int curedCount;
    private int deadCount;
    private long modifyTime;
    private String imgUrl;

    public Statistics(int confirmedCount, int suspectedCount, int curedCount, int deadCount, long modifyTime, String imgUrl) {
        this.confirmedCount = confirmedCount;
        this.suspectedCount = suspectedCount;
        this.curedCount = curedCount;
        this.deadCount = deadCount;
        this.modifyTime = modifyTime;
        this.imgUrl = imgUrl;
    }

    public int getConfirmedCount() {
        return confirmedCount;
    }

    public void setConfirmedCount(int confirmedCount) {
        this.confirmedCount = confirmedCount;
    }

    public int getSuspectedCount() {
        return suspectedCount;
    }

    public void setSuspectedCount(int suspectedCount) {
        this.suspectedCount = suspectedCount;
    }

    public int getCuredCount() {
        return curedCount;
    }

    public void setCuredCount(int curedCount) {
        this.curedCount = curedCount;
    }

    public int getDeadCount() {
        return deadCount;
    }

    public void setDeadCount(int deadCount) {
        this.deadCount = deadCount;
    }

    public long getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(long modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }


    @Override
    public String toString() {
        return "Statistics{" +
                "confirmedCount=" + confirmedCount +
                ", suspectedCount=" + suspectedCount +
                ", curedCount=" + curedCount +
                ", deadCount=" + deadCount +
                ", modifyTime=" + modifyTime +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}
