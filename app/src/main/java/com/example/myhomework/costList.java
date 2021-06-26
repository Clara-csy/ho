package com.example.myhomework;

public class costList {

    private String id;
    private String Sheng;
    private String Shi;
    private String Qu;
    private String Xiangxi;


    public costList(String id, String sheng, String shi, String qu, String xiangxi) {
        super();
        this.id = id;
        Sheng = sheng;
        Shi = shi;
        Qu = qu;
        Xiangxi = xiangxi;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSheng() {
        return Sheng;
    }

    public void setSheng(String Sheng) {
        this.Sheng = Sheng;
    }

    public String getShi() {
        return Shi;
    }

    public void setShi(String Shi) {
        this.Shi = Shi;
    }
    public String getQu() {
        return Qu;
    }
    public void setQu(String Qu) {
        this.Qu = Qu;
    }

    public void setXiangxi(String Xiangxi) {
        this.Xiangxi = Xiangxi;
    }
    public String getXiangxi() {
        return Xiangxi;
    }





}