package com.isea533.mybatis.vo;

/**
 * Created by Administrator on 2017/5/7.
 */
public class PartitionVo {
    private int startId;
    private int EndId;
    private int batchId;
    private int type;

    public int getStartId() {
        return startId;
    }

    public void setStartId(int startId) {
        this.startId = startId;
    }

    public int getEndId() {
        return EndId;
    }

    public void setEndId(int endId) {
        EndId = endId;
    }

    public int getBatchId() {
        return batchId;
    }

    public void setBatchId(int batchId) {
        this.batchId = batchId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }


    /**
     * 构造函数  此处测试用
     * @param startId
     */
    public PartitionVo(int startId) {
        this.startId = startId;
    }
}
