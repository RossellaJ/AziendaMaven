<%@page import="it.alfa.rossella.servizi.Servizi"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 
 <!--     <jsp:useBean id="message" class="utility.MessageBean" scope="request"></jsp:useBean>-->
    <jsp:useBean id="dipendente" class="it.alfa.rossella.bean.DipendenteBean" scope="session"></jsp:useBean>
    
    <% 
    Servizi s = new Servizi();
   // session.getAttribute()
    if(dipendente.isValid()==true){
    	//cliente isValid
    	if(s.trovaUtenteNomeCognome(dipendente.getNome(), dipendente.getCognome())){
    		//cliente non esiste già
    		if(s.trovaUtenteUsername(dipendente.getUsername())){
    			//username disponibile allora: Codifico password,richiamoDao per compilare Database e rimando alla pagina Registazione avvenuta con successo.jsp
    			String pass = s.convertiPass(dipendente.getPassword());
    			
    			dipendente.setPassword(pass);
    			
    			s.registraDipendente(dipendente);
    			
    			//devo riempire campi del bean dipendente
    			message.setMessage("Dipendente registrato!");
    			%>
    			
    			<jsp:forward page="HomePageAdmin.jsp"/>
    			
    			<%	
    		}else{
    			//username non disponibile
    		
				%>
    			
    			<jsp:forward page="RegistrazioneNuovoDipendente.jsp"/>
    			
    			<%	
    			
    		}
    	}else{
    		//cliente esiste
    		%>
			
			<jsp:forward page="RegistrazioneNuovoDipendente.jsp"/>
			
			<%	
    		
    	}
    	
    }else{
    	//cliente non è valido
    	%>
		
		<jsp:forward page="RegistrazioneNuovoDipendente.jsp"/>
		
		<%	
    }
    
    
    %>