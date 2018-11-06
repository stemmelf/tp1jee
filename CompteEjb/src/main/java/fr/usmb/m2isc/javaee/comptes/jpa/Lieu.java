package fr.usmb.m2isc.javaee.comptes.jpa;

import java.io.Serializable;

import javax.persistence.*;


@Embeddable
public class Lieu implements Serializable {

    private String nom;

    @Embedded
    private Position position;

    public Lieu() {
    }

    public Lieu(float longitude, float latitude, String nom) {
        super();
        this.position = new Position(longitude, latitude);
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
