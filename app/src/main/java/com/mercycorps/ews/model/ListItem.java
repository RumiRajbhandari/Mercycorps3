package com.mercycorps.ews.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by user on 7/26/2017.
 */

public class ListItem implements Serializable {
//    @SerializedName("id")
//
//    private String id;

    @SerializedName("organization")
    private  String organization;

    @SerializedName("person")

    private String person;

    @SerializedName("mob")

    private String mob;
    @SerializedName("landline")
    private String landline;



    public ListItem(){}

    public ListItem(String organization, String person, String mob, String landline) {
//        this.id = id;
        this.person = person;
        this.organization = organization;

        this.mob = mob;
        this.landline = landline;
    }

//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getLandline() {
        return landline;
    }

    public void setLandline(String landline) {
        this.landline = landline;
    }

    public String getMob() {
        return mob;
    }

    public void setMob(String mob) {
        this.mob = mob;
    }
}
