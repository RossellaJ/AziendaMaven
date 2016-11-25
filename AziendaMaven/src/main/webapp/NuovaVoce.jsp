<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!-- per far funzionare c:out in tutti gli elenchi(integrazione jstl -->
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ page isELIgnored="false" %>
	
<jsp:useBean id="dipendente" class="it.alfa.rossella.bean.DipendenteBean" scope="session"></jsp:useBean>	
<jsp:useBean id="voce" class="it.alfa.rossella.model.Voce" scope="session"></jsp:useBean>
<!-- deve settare i valori in bean........come si fa? -->
	<!--        header di pagina  -->

<jsp:include page="head.jsp"></jsp:include>  
	
<!-- nav bar starts -->

<jsp:include page="NavBarAdmin.jsp"></jsp:include>



<div class="ch-container">

	<div class="row">

			<h2>
				<c:out value="${dipendente.nome}" />
				<c:out value="${dipendente.cognome}" />
			</h2>
		</div>


		<!-- left menu starts -->

		<jsp:include page="menuLateraleAdmin.jsp"></jsp:include>

		<!-- left menu ends -->
		
		

		

		</div>

	<div id="content" class="col-lg-10 col-sm-10">

			<!-- content starts -->

			<h1>Nuova Voce in Rubrica</h1>
			<div>

				<ul class="breadcrumb">

					
			
				</ul>

			</div>

			<div class=" row">



				<!--       devo scrivere per ogni pagina   -->

				
				
					<form action="doNuovaVoce.jsp" method="post">
					Nome : <input type="text" name="nome" /> <br> 
					Cognome : <input type="text" name="cognome" /> <br> 
					Telefono : <input type="text" name="telefono" /> <br> 
					
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

	