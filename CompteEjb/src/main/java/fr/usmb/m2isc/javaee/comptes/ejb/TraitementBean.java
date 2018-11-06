package fr.usmb.m2isc.javaee.comptes.ejb;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.usmb.m2isc.javaee.comptes.jpa.Colis;
import fr.usmb.m2isc.javaee.comptes.jpa.Etape;
import fr.usmb.m2isc.javaee.comptes.jpa.Lieu;

@Stateless
@Remote
public class TraitementBean implements Traitement {

    @PersistenceContext
    private EntityManager em;

    public TraitementBean() {
    }

    @Override
    public Colis creerColis(float poids, float valeur, Lieu origine, Lieu destination, Etape etape){
        Colis col = new Colis(poids, valeur, origine, destination, etape);
        em.persist(col);
        return col;
    }

    @Override
    public Colis getColis(int id){
        return em.find(Colis.class, id);
    }

    @Override
    public Colis passageEtape(int id, float longitude, float latitude, String emplacement, String etat){
        Colis col = em.find(Colis.class, id);
        col.setEtape(new Etape(longitude, latitude, emplacement, etat));
        return col;
    }

    @Override
    public List<Colis> findColis(int id){
        Query req = em.createNamedQuery("findWithId");
        req.setParameter("id", id);
        return req.getResultList();
    }

    @Override
    public List<Colis> findAllColis(){
        Query req = em.createNamedQuery("all");
        return req.getResultList();
    }

}
