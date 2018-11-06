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
    @AttributeOverrides({
            @AttributeOverride(name="nom", column=@Column(name="nomOrigin")),
            @AttributeOverride(name="latitude", column=@Column(name="latOrigine")),
            @AttributeOverride(name="longitude", column=@Column(name="longOrigine"))
    })
    private Lieu origine;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="nom", column=@Column(name="nomDest")),
            @AttributeOverride(name="latitude", column=@Column(name="latDest")),
            @AttributeOverride(name="longitude", column=@Column(name="longDest"))
    })
    private Lieu destination;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="nom", column=@Column(name="nomEtape")),
            @AttributeOverride(name="etat", column=@Column(name="etatEtape")),
            @AttributeOverride(name="latitude", column=@Column(name="latEtape")),
            @AttributeOverride(name="longitude", column=@Column(name="longEtape"))
    })
    private Etape etape;

    public Colis() {
    }

    public Colis(float poids, float valeur, Lieu origine, Lieu destination, Etape etape) {
        this.poids = poids;
        this.valeur = valeur;
        this.origine = origine;
        this.destination = destination;
        this.etape = etape;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
