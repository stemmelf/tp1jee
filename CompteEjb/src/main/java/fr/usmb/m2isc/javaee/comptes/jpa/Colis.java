package fr.usmb.m2isc.javaee.comptes.jpa;

import java.io.Serializable;

import javax.persistence.*;

@NamedQueries ({
        @NamedQuery(name="all", query="SELECT c FROM Colis c"),
        @NamedQuery(name="findWithId", query="SELECT c FROM Colis c WHERE c.id = :id ORDER BY c.id ASC")
})
@Entity
public class Colis implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private float poids;
    private float valeur;

    @Embedded
    private Lieu origine;

    @Embedded
    private Lieu destination;

    @Embedded
    private Etape etape;

    public Colis() {
    }

    public Colis(float poids, float valeur, Lieu origine, Lieu destination, Etape etape) {
        super();
        this.poids = poids;
        this.valeur = valeur;
        this.origine = origine;
        this.destination = destination;
        this.etape = etape;
    }

    public float getPoids() {
        return poids;
    }

    public void setPoids(float poids) {
        this.poids = poids;
    }

    public float getValeur() {
        return valeur;
    }

    public void setValeur(float valeur) {
        this.valeur = valeur;
    }

    public Lieu getOrigine() {
        return origine;
    }

    public void setOrigine(Lieu origine) {
        this.origine = origine;
    }

    public Lieu getDestination() {
        return destination;
    }

    public void setDestination(Lieu destination) {
        this.destination = destination;
    }

    public Etape getEtape() {
        return etape;
    }

    public void setEtape(Etape etape) {
        this.etape = etape;
    }
}
