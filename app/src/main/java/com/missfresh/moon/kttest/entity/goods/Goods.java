package com.missfresh.moon.kttest.entity.goods;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Goods {
    /**
     * id : 1
     * shelfLay : 2
     * layLine : 2
     * goodsName : 华北红肉火龙果【品类水果】
     * goodsNo : p-hbhrhlg-1g
     * picUrl : https://image.missfresh.cn/731945401be04d6e87cda4d08401785e.jpeg
     * codeType : 2
     * codeNo : 6000006
     * materialNo : 6000006
     * qualityType : 0
     * operationDate : 1536031350385
     * uniqueCode : 275
     */
    @Id
    private int id;
    private int shelfLay;
    private int layLine;
    private String goodsName;
    private String goodsNo;
    private String picUrl;
    private int codeType;
    private String codeNo;
    private String materialNo;
    private int qualityType;
    private long operationDate;
    private int uniqueCode;

    @Generated(hash = 333198529)
    public Goods(int id, int shelfLay, int layLine, String goodsName,
            String goodsNo, String picUrl, int codeType, String codeNo,
            String materialNo, int qualityType, long operationDate,
            int uniqueCode) {
        this.id = id;
        this.shelfLay = shelfLay;
        this.layLine = layLine;
        this.goodsName = goodsName;
        this.goodsNo = goodsNo;
        this.picUrl = picUrl;
        this.codeType = codeType;
        this.codeNo = codeNo;
        this.materialNo = materialNo;
        this.qualityType = qualityType;
        this.operationDate = operationDate;
        this.uniqueCode = uniqueCode;
    }

    @Generated(hash = 1770709345)
    public Goods() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getShelfLay() {
        return shelfLay;
    }

    public void setShelfLay(int shelfLay) {
        this.shelfLay = shelfLay;
    }

    public int getLayLine() {
        return layLine;
    }

    public void setLayLine(int layLine) {
        this.layLine = layLine;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public int getCodeType() {
        return codeType;
    }

    public void setCodeType(int codeType) {
        this.codeType = codeType;
    }

    public String getCodeNo() {
        return codeNo;
    }

    public void setCodeNo(String codeNo) {
        this.codeNo = codeNo;
    }

    public String getMaterialNo() {
        return materialNo;
    }

    public void setMaterialNo(String materialNo) {
        this.materialNo = materialNo;
    }

    public int getQualityType() {
        return qualityType;
    }

    public void setQualityType(int qualityType) {
        this.qualityType = qualityType;
    }

    public long getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(long operationDate) {
        this.operationDate = operationDate;
    }

    public int getUniqueCode() {
        return uniqueCode;
    }

    public void setUniqueCode(int uniqueCode) {
        this.uniqueCode = uniqueCode;
    }
}
