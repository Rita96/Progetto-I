package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static web.Servlet1.p;

/**
 * Servlet2 permette di eseguire effettivamente il risolutore
 * dal proprio browser una volta scelto l'oggetto desiderato
 * 
 * @author Gabriele Guazzardi, Francesco Giudice, Daniele Tavazzi, Andrea Pompa
 *
 */
@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	private String domanda;
	String[] scelte;
	String[] percorso=null;
	int n, n2;
	private String scelta;
	
	
    public Servlet2() 
    {
        super();
    }
    
/**
 * doGet() esegue la pagina Execute.jsp e le passa le variabili
 * 
 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		recall();
		request.setAttribute("domanda",domanda);
		request.setAttribute("scelte",scelte);
		request.setAttribute("percorso",percorso);
		request.setAttribute("n2", n2);
		request.setAttribute("n",n);
		RequestDispatcher Dispatcher = getServletContext().getRequestDispatcher("/Execute.jsp");
		Dispatcher.forward(request, response);
		
		response.sendRedirect("Execute.jsp");
		
	}
	
	/**
	 * doPost() recupera da Execute.jsp le variabili, esegue i metodi di Struttura
	 * e ricarica eventualemente Servlet2 con i nuovi parametri
	 * 
	 * 
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int i;
		String azione = request.getParameter("azione");
		String indietro = request.getParameter("indietro");
		
		if(azione==null)
		{	
			if(indietro==null)
			{
				response.sendRedirect("Servlet2");
			}
			else {
					for(int j=0; j< n2; j++)
					{
						if(indietro.equals(percorso[j]))
						{
							p.statoPrecedente(j);
							doGet(request, response);
						}
					}
			
				}
		}
		else
		{
			switch (azione){
			
				case "Home":
					p.returnHome();
					response.sendRedirect("Servlet1");
					break;
				case "Indietro":
					if(p.percorsoEmpty())
						response.sendRedirect("Servlet2");
					else {	
						p.back();
						doGet(request, response);
					}
					break;
				default:
					for(i=0; i < n; i++)
					{
						if(azione.equals(scelte[i]))
						{
							p.esecuzione(i);
							doGet(request, response);
						}
					
					}
					
				
			}
		}
	
	}
	
	/**
	 * recall() aggiorna le domande delle scelte rispetto allo stato iniziale della struttura
	 * 
	 */
	
	public void recall()
	{
		domanda = p.mostraDomandaAttuale();
        int i;
        n = p.scelteDomandaAttualeSize();
        scelte = new String[n];
        for(i = 0; i < n; i++)
        {
        	scelte[i] = p.mostraSceltaDomandaAttuale(i);
        }
        n2 = p.getPercorso().size();
        if(n2 != 0) {
        percorso = new String[n2];
        for(i=0; i<n2; i++)
        	percorso[i] = p.getPercorso().get(i).toString();
        }
       
	}
	

}
