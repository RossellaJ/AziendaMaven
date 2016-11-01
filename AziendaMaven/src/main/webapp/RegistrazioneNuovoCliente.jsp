<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- per far funzionare c:out in tutti gli elenchi(integrazione jstl -->
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ page isELIgnored="false" %>
    
	
	<jsp:useBean id="cliente" class="it.alfa.rossella.ClienteBean" scope="session"></jsp:useBean>
<!--  	<jsp:useBean id="message" class="utility.MessageBean" scope="request"></jsp:useBean>
admin?-->

 <!--        header di pagina  -->

<jsp:include page="head.jsp"></jsp:include>  
	
<!-- nav bar starts -->

<jsp:include page="NavBarAdmin.jsp"></jsp:include>



<div class="ch-container">

	<div class="row">

			<h2>
				<c:out value="${utente.nome}" />
				<c:out value="${utente.cognome}" />
			</h2>
		</div>


		<!-- left menu starts -->

		<jsp:include page="menuLateraleAdmin.jsp"></jsp:include>

		<!-- left menu ends -->
		
		

		

		</div>

	<div id="content" class="col-lg-10 col-sm-10">

			<!-- content starts -->

			<h1>Registrazione Nuovo Cliente</h1>
			<div>

				<ul class="breadcrumb">

					<li> Home : <c:out value="${admin.nome}"/></li>
			
				</ul>

			</div>

			<div class=" row">



				<!--       devo scrivere per ogni pagina   -->

					<%= message.getMessage()%> 
				
					<form action="doRegistraCliente.jsp" method="post">
					Nome : <input type="text" name="nome" /> <br> 
					Cognome : <input type="text" name="cognome" /> <br> 
					Username : <input type="text" name="username" /> <br> 
					Password : <input type="password" name="password" /> <br> 
					Ragione Sociale : <input type="text" name="ragioneSociale" /> <br> 
					Partita IVA : <input type="text" name="piva" /> <br> 
					<input type="submit" value="Registra" />
	
					</form>












			</div>
			<!-- content ends -->

		</div>
		<!--/#content.col-md-0-->


	<!--/fluid-row-->







<div>

	<hr>



	<jsp:include page="footer.jsp"></jsp:include>





</div>
<!--/.fluid-container-->



<!--      includo tutti script di sotto -->

    