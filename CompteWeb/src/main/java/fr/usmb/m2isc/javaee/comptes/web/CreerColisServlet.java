package fr.usmb.m2isc.javaee.comptes.web;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.usmb.m2isc.javaee.comptes.jpa.Lieu;
import fr.usmb.m2isc.javaee.comptes.jpa.Etape;
import fr.usmb.m2isc.javaee.comptes.ejb.Traitement;
import fr.usmb.m2isc.javaee.comptes.jpa.Colis;

/**
 * Servlet utilisee pour creer un compte.
 */
@WebServlet("/CreerColisServlet")
public class CreerColisServlet extends HttpServlet{

    private static final long serialVersionUID = 5236668439173484090L;
    @EJB
    private Traitement op;


    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreerColisServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        float poids = Float.parseFloat(request.getParameter("poids"));
        float valeur = Float.parseFloat(request.getParameter("valeur"));
        float longOrigine = Float.parseFloat(request.getParameter("longOrigine"));
        float latOrigine = Float.parseFloat(request.getParameter("latOrigine"));
        String nomOrigine = request.getParameter("nomOrigine");
        float longDest = Float.parseFloat(request.getParameter("longDest"));
        float latDest = Float.parseFloat(request.getParameter("latDest"));
        String nomDest = request.getParameter("nomDest");

        Lieu origine = new Lieu(longOrigine, latOrigine, nomOrigine);

        Lieu destination = new Lieu(longDest, latDest, nomDest);

        Etape etapeOrigine = new Etape(longOrigine, latOrigine, nomOrigine, "Cree");

        Colis col = op.creerColis(poids, valeur, origine, destination, etapeOrigine);

        request.setAttribute("colis", col);

        //response.getWriter().println("C'est fait");

        request.getRequestDispatcher("/AfficherColis.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
