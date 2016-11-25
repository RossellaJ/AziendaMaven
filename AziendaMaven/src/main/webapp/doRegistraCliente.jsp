<%@page import="it.alfa.rossella.servizi.Servizi"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <jsp:useBean id="utente" class="it.alfa.rossella.bean.AdminBean" scope="session"></jsp:useBean>
    <jsp:useBean id="message" class="utility.MessageBean" scope="request"></jsp:useBean>
    <jsp:useBean id="cliente" class="it.alfa.rossella.bean.ClienteBean" scope="request"></jsp:useBean>
    
    <% 
    Servizi s = new Servizi();
    
    if(cliente.isValid()==true){
    	//cliente isValid
    	if(s.trovaUtenteNomeCognome(cliente.getNome(), cliente.getCognome())){
    		//cliente non esiste già
    		if(s.trovaUtenteUsername(cliente.getUsername())){
    			//username disponibile allora: Codifico password,richiamoDao per compilare Database e rimando alla pagina Registazione avvenuta con successo.jsp
    			String pass = s.convertiPass(cliente.getPassword());
    			
    			cliente.setPassword(pass);
    			
    			s.registraCliente(cliente);
    			message.setMessage("Cliente registrato!");
    			%>
    			
    			<jsp:forward page="HomePageAdmin.jsp"/>
    			
    			<%	
    		}else{
    			//username non disponibile
    		
				%>
    			
    			<jsp:forward page="RegistrazioneNuovoCliente.jsp"/>
    			
    			<%	
    			
    		}
    	}else{
    		//cliente esiste
    		%>
			
			<jsp:forward page="RegistrazioneNuovoCliente.jsp"/>
			
			<%	
    		
    	}
    	
    }else{
    	//cliente non è valido
    	%>
		
		<jsp:forward page="RegistrazioneNuovoCliente.jsp"/>
		
		<%	
    }
    
    
    %>