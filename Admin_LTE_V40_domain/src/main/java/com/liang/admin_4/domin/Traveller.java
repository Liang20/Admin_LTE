/**
 * @Author: Liang
 * @Date: 2019/5/18 22:28
 * @Version 1.0
 */
package com.liang.admin_4.domin;

/**
 * @author Liang
 * @date 2019/5/18 22:28
 */
public class Traveller {
    private String id;
    private String name;
    private String sex;
    private String phoneNum;
    private Integer credentialsType;   //证件类型 0身份证 1护照 2军官证
    private String credentialsTypeStr;
    private String credentialsNum;
    private Integer travellerType;
    private String travellerTypeStr;  //旅客类型(人群) 0 成人 1 儿童

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Integer getCredentialsType() {
        return credentialsType;
    }

    public void setCredentialsType(Integer credentialsType) {
        this.credentialsType = credentialsType;
    }

    public String getCredentialsTypeStr() {
        //0身份证 1护照 2军官证
        if(credentialsType != null){
            if(credentialsType == 0){
                credentialsTypeStr = "身份证";
            }else if(credentialsType == 1){
                credentialsTypeStr = "护照";
            }else if(credentialsType == 2){
                credentialsTypeStr = "军官证";
            }
        }
        return credentialsTypeStr;
    }

    public void setCredentialsTypeStr(String credentialsTypeStr) {
        this.credentialsTypeStr = credentialsTypeStr;
    }

    public String getCredentialsNum() {
        return credentialsNum;
    }

    public void setCredentialsNum(String credentialsNum) {
        this.credentialsNum = credentialsNum;
    }

    public Integer getTravellerType() {
        return travellerType;
    }

    public void setTravellerType(Integer travellerType) {
        this.travellerType = travellerType;
    }

    public String getTravellerTypeStr() {
        //旅客类型(人群) 0 成人 1 儿童
        if(travellerType != null){
            if(travellerType == 0){
                travellerTypeStr = "成人";
            }else if(travellerType == 1){
                travellerTypeStr = "儿童";
            }
        }
        return travellerTypeStr;
    }

    public void setTravellerTypeStr(String travellerTypeStr) {
        this.travellerTypeStr = travellerTypeStr;
    }

    @Override
    public String toString() {
        return "Traveller{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", credentialsType=" + credentialsType +
                ", credentialsTypeStr='" + credentialsTypeStr + '\'' +
                ", credentialsNum='" + credentialsNum + '\'' +
                ", travellerType=" + travellerType +
                ", travellerTypeStr='" + travellerTypeStr + '\'' +
                '}';
    }

}
