package fr.usmb.m2isc.javaee.comptes.web;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.usmb.m2isc.javaee.comptes.ejb.Traitement;
import fr.usmb.m2isc.javaee.comptes.jpa.Colis;


/**
 * Servlet utilisee pour crediter un compte.
 */
@WebServlet("/ProgressColisServlet")
public class ProgressColisServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    private Traitement ejb;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProgressColisServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        float longEtape = Float.parseFloat(request.getParameter("longEtape"));
        float latEtape = Float.parseFloat(request.getParameter("latEtape"));
        String nomEmplacementEtape = request.getParameter("nomEmplacementEtape");
        String nomEtat = request.getParameter("nomEtat");

        Colis col = ejb.passageEtape(id, longEtape, latEtape, nomEmplacementEtape, nomEtat);
        request.setAttribute("colis", col);
        request.getRequestDispatcher("/AfficherColis.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
