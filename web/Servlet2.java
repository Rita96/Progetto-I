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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		/*scelta = request.getParameter("scelta");
		String indietro = request.getParameter("indietro");
		String home = request.getParameter("home");*/
		int i;
		String azione = request.getParameter("azione");
		String indietro = request.getParameter("indietro");
		/*if(indietro==null && p.percorsoEmpty())
				response.sendRedirect("Servlet2");
			else {
			if(indietro.equals("indietro")) {
				for(int j=0; j< n2; j++)
				{
					if(indietro.equals(percorso[j]))
					{
							p.statoPrecedente(j);
							doGet(request, response);
					}
				}
			
			}*/
			/*if(p.scelteDomandaAttualeEmpty()) {
				p.returnHome();
				response.sendRedirect("Servlet1");
			}
			else {
				response.sendRedirect("Servlet2");
			}
		}*/
		
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
		
		
		
		
			
		
		
		
		
		/*if(indietro == null) {}
		else if(indietro.equals("indietro"))
		{
			p.back();
			doGet(request, response);
		}
		
		if(scelta==null) //se siamo arrivati alla fine va indietro se non ci sono altre scelte
		{
			if(p.scelteDomandaAttualeEmpty())
			{
				p.returnHome();
				response.sendRedirect("Servlet1");
			}
		}
		else
		{
			for(i=0; i < n; i++)
			{
				if(scelta.equals(scelte[i]))
				{
					p.esecuzione(i);
					doGet(request, response);
				}
			}
		}
		if(home==null) {}
		else if(home.equals("home"))
		{
			p.returnHome();
			response.sendRedirect("Servlet1");
		}*/
	
	
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
