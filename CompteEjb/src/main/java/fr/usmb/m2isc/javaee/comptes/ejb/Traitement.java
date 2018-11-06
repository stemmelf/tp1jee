package fr.usmb.m2isc.javaee.comptes.ejb;

import java.util.List;

import fr.usmb.m2isc.javaee.comptes.jpa.Colis;
import fr.usmb.m2isc.javaee.comptes.jpa.Etape;
import fr.usmb.m2isc.javaee.comptes.jpa.Lieu;

public interface Traitement {

    Colis creerColis(float poids, float valeur, Lieu origine, Lieu destination, Etape etape);

    Colis getColis(int id);

    Colis passageEtape(int id, float longitude, float latitude, String emplacement, String etat);

    List<Colis> findColis(int id);

    List<Colis> findAllColis();

}