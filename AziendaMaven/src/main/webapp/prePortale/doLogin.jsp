<%@page import="it.alfa.rossella.DipendenteBean"%>
<%@page import="it.alfa.rossella.ClienteBean"%>
<%@page import="it.alfa.rossella.AdminBean"%>
<%@page import="it.alfa.rossella.UtenteBean"%>
<%@page import="it.alfa.rossella.servizi.Servizi"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<jsp:useBean id="utente" class="it.alfa.rossella.UtenteBean" scope="request"></jsp:useBean>
<jsp:setProperty property="*" name="utente" />

<jsp:useBean id="admin" class="it.alfa.rossella.AdminBean" scope="session"></jsp:useBean>
<jsp:useBean id="cliente" class="it.alfa.rossella.ClienteBean" scope="session"></jsp:useBean>
<jsp:useBean id="dipendente" class="it.alfa.rossella.DipendenteBean" scope="session"></jsp:useBean>

<jsp:useBean id="message" class="utility.MessageBean" scope="request"></jsp:useBean>

<%
 	Servizi s = new Servizi();
	 	
	 if(utente.isValidLogin()== true){
		//l'utente è valido
			String passDaCodificare = utente.getPassword();
			String passCodificata= s.convertiPass(passDaCodificare);
			utente.setPassword(passCodificata);
	
			if(s.trovaUtenteUserPass(utente.getUsername(), utente.getPassword())) {
		    	//Qui ti serve un metodo che riempia i campi di utentebean ancora vuoti (nome, cognome, ruolo) andando a prendere da DB
				UtenteBean utemp = s.getUtente(utente.getUsername(), utente.getPassword());	
		  		utente.setIdUtente(utemp.getIdUtente()); 	
		    	utente.setNome(utemp.getNome());
		    	utente.setCognome(utemp.getCognome());
		    	utente.setRuolo(utemp.getRuolo());
		    	
		    	char ruolo= utente.getRuolo();
		    		switch(ruolo) {

		    		case 'a' : 
		    		//qui riempio adminbean	andando a prendere da DB
		    		AdminBean atemp = s.getAdmin(utente.getUsername());
		    		admin.setIdUtente(atemp.getIdUtente());
		    		admin.setNome(atemp.getNome());
		    		admin.setCognome(atemp.getCognome());	
		    		admin.setUsername(atemp.getUsername());	
		    		admin.setPassword(atemp.getPassword());
		    		admin.setLivelloAccesso(atemp.getLivelloAccesso());
		    			%>

<jsp:forward page="./HomePageAdmin.jsp" />

<%

					break;

		    		case 'c' :
		    			//qui riempio clientebean	andando a prendere da DB
		    		ClienteBean ctemp = s.getCliente(utente.getUsername());
		    		cliente.setIdUtente(ctemp.getIdUtente());
		    		cliente.setNome(ctemp.getNome());
		    		cliente.setCognome(ctemp.getCognome());	
		    		cliente.setUsername(ctemp.getUsername());	
		    		cliente.setPassword(ctemp.getPassword());
		    		cliente.setRagioneSociale(ctemp.getRagioneSociale());
		    		cliente.setPartitaIva(ctemp.getPartitaIva());

		    	    	%>

<jsp:forward page="HomePageCliente.jsp" />

<%

		    		break;
	    		case 'd' :
	    			//qui riempio dipendentebean	andando a prendere da DB
					DipendenteBean dtemp = s.getDipendente(utente.getUsername());
		    		dipendente.setIdUtente(dtemp.getIdUtente());
		    		dipendente.setNome(dtemp.getNome());
		    		dipendente.setCognome(dtemp.getCognome());	
		    		dipendente.setUsername(dtemp.getUsername());	
		    		dipendente.setPassword(dtemp.getPassword());
		    		dipendente.setPosizione(dtemp.getPosizione());
		    		dipendente.setStipendio(dtemp.getStipendio());
	    			
	    			
	    			
	    			
		    	    	%>

<jsp:forward page="HomePageDipendente.jsp" />

<%

		    		break;

		    		}

		    }
	 }
		    else{

		    //	message.setMessage("Username o password non corretti");

		    			%>

<jsp:forward page="login.jsp" /> 
<%
			
			}%>










