package com.example.user.mercycorpsfinal.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by root on 7/25/17.
 */
public class LatLon implements Serializable {
    String gauze, river, location, basedOn;
    Double lat, lon;
    ArrayList<Contact> contacts;

    public LatLon() {
    }

    public LatLon( String location,String gauze, String river, String basedOn,  Double lon,Double lat, ArrayList<Contact> contacts) {
        this.gauze = gauze;
        this.river = river;
        this.location = location;
        this.basedOn = basedOn;
        this.lat = lat;
        this.lon = lon;
        this.contacts = contacts;
    }

    public String getGauze() {
        return gauze;
    }

    public void setGauze(String gauze) {
        this.gauze = gauze;
    }

    public String getRiver() {
        return river;
    }

    public void setRiver(String river) {
        this.river = river;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBasedOn() {
        return basedOn;
    }

    public void setBasedOn(String basedOn) {
        this.basedOn = basedOn;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        return "LatLon{" +
                "gauze='" + gauze + '\'' +
                ", river='" + river + '\'' +
                ", location='" + location + '\'' +
                ", basedOn='" + basedOn + '\'' +
                ", lat=" + lat +
                ", lon=" + lon +
                ", contacts=" + contacts +
                '}';
    }
}
