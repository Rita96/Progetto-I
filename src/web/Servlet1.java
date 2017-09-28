package web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JFrame;

import elementi.Oggetto;
import elementi.Scelta;
import esecuzione.Struttura;

/**
 * 	Servlet1 permette di selezionare l'oggetto
 * 	desiderato dal proprio browser
 * 
 *	@author Gabriele Guazzardi, Francesco Giudice
 */

@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	ArrayList<Oggetto> elenco;
	String[] lista;
	String var;
	int n;
	public static Struttura p;
    
    public Servlet1() throws IOException
    {
        super();
        int i;
		p=new Struttura();
		p.letturaOggetti();	
		elenco=p.getElencoOggetti();
		n=elenco.size();
		lista = new String[n];
		for(i=0;i<n;i++)
		{
			lista[i]=elenco.get(i).getNome();
		}
		
    }

    /**
     * doGet è il primo metodo che viene lanciato, e serve per aprire la pagina Home.jsp
     * e le passa i parametri
     * 
     */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{	
		
		request.setAttribute("ele",lista);
		request.setAttribute("num",n);
		RequestDispatcher Dispatcher = getServletContext().getRequestDispatcher("/Home.jsp");
		Dispatcher.forward(request, response);

		response.sendRedirect("Home.jsp");
		
		
		
	}
	
	/**
	 * doPost prende le variabili della pagina Home.jps
	 * e le usa per aprie il file Servlet2 e per eseguire i metodi di Struttura
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		var = request.getParameter("popo");
		int i;
		if(var==null)
		{}
		else
		{
			for(i=0; i < n; i++)
			{
				if(var.equals(lista[i]))
				{
					p.sceltaOggetto(i);
					response.sendRedirect("Servlet2");
				}
			}
		}
	}

}