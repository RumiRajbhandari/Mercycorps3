package com.example.user.mercycorpsfinal.model;

import java.io.Serializable;

/**
 * Created by user on 7/26/2017.
 */

public class ListItem implements Serializable {
    String orgName,person;
    String phoneNo,mobNo;

    public ListItem(String orgName, String person, String phoneNo, String mobNo) {
        this.orgName = orgName;
        this.person = person;
        this.phoneNo = phoneNo;
        this.mobNo = mobNo;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getMobNo() {
        return mobNo;
    }

    public void setMobNo(String mobNo) {
        this.mobNo = mobNo;
    }
}
