package fr.usmb.m2isc.javaee.comptes.jpa;

import java.io.Serializable;

import javax.persistence.*;

@Embeddable
public class Position implements Serializable {

    @Id
    private int id;

    private float longitude;
    private float latitude;

    public Position() {
    }

    public Position(float longitude, float latitude) {
        super();
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }
}
