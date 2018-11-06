package fr.usmb.m2isc.javaee.comptes.jpa;

import java.io.Serializable;

import javax.persistence.*;


@Embeddable
public class Etape implements Serializable {

    @Id
    private int id;

    @Embedded
    private Lieu emplacement;
    private String etat;

    public Etape() {
    }

    public Etape(float longitude, float latitude, String nomEmplacement, String etat) {
        super();
        this.emplacement = new Lieu (longitude, latitude, nomEmplacement);
        this.etat = etat;
    }

    public Lieu getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(Lieu emplacement) {
        this.emplacement = emplacement;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }
}
