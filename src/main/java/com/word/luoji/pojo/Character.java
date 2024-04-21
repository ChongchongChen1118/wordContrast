package com.word.luoji.pojo;

import lombok.Builder;

@Builder
public class Character {
private String wenzi;
private String ziti;
private float daxiao;
private String jaicu;
private String qingxie;
private int xiahuaxian;
private String shanchuxian;
private String zitiyanse;
private String gaoliang;
private String beijingyanse;

    public String getWenzi() {
        return wenzi;
    }

    public void setWenzi(String wenzi) {
        this.wenzi = wenzi;
    }

    public String getZiti() {
        return ziti;
    }

    public void setZiti(String ziti) {
        this.ziti = ziti;
    }

    public float getDaxiao() {
        return daxiao;
    }

    public void setDaxiao(float daxiao) {
        this.daxiao = daxiao;
    }

    public String getJaicu() {
        return jaicu;
    }

    public void setJaicu(String jaicu) {
        this.jaicu = jaicu;
    }

    public String getQingxie() {
        return qingxie;
    }

    public void setQingxie(String qingxie) {
        this.qingxie = qingxie;
    }

    public int getXiahuaxian() {
        return xiahuaxian;
    }

    public void setXiahuaxian(int xiahuaxian) {
        this.xiahuaxian = xiahuaxian;
    }

    public String getShanchuxian() {
        return shanchuxian;
    }

    public void setShanchuxian(String shanchuxian) {
        this.shanchuxian = shanchuxian;
    }

    public String getZitiyanse() {
        return zitiyanse;
    }

    public void setZitiyanse(String zitiyanse) {
        this.zitiyanse = zitiyanse;
    }

    public String getGaoliang() {
        return gaoliang;
    }

    public void setGaoliang(String gaoliang) {
        this.gaoliang = gaoliang;
    }

    public String getBeijingyanse() {
        return beijingyanse;
    }

    public void setBeijingyanse(String beijingyanse) {
        this.beijingyanse = beijingyanse;
    }

    @Override
    public String toString() {
        return "Character{" +
                "wenzi='" + wenzi + '\'' +
                ", ziti='" + ziti + '\'' +
                ", daxiao='" + daxiao + '\'' +
                ", jaicu=" + jaicu +
                ", qingxie=" + qingxie +
                ", xiahuaxian=" + xiahuaxian +
                ", shanchuxian=" + shanchuxian +
                ", zitiyanse=" + zitiyanse +
                ", gaoliang=" + gaoliang +
                ", beijingyanse=" + beijingyanse +
                '}';
    }
}
