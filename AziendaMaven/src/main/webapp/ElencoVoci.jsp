<%@page import="java.util.List"%>
<%@page import="it.alfa.rossella.servizi.Servizi"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- per far funzionare c:out in tutti gli elenchi(integrazione jstl -->
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ page isELIgnored="false" %>
    
	
	<jsp:useBean id="dipendente" class="it.alfa.rossella.DipendenteBean" scope="session"></jsp:useBean>	
	<jsp:useBean id="voce" class="it.alfa.rossella.model.Voce" scope="session"></jsp:useBean>	

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

			<h1>Elenco dei contatti in Rubrica</h1>
			<div>

				<ul class="breadcrumb">

					
			
				</ul>

			</div>

			<div class=" row">

	</div>

				<!--       devo scrivere per ogni pagina   -->
			
				<div class="box-content">
    
  				  <table class="table table-striped table-bordered bootstrap-datatable datatable responsive">

			
					<thead>
						<tr>
							<th>n.</th>
							<th>nome</th>
							<th>cognome</th>
							<th>telefono</th>
							<th>Actions</th>
						</tr>
					</thead>
	
					<%
						Servizi s = new Servizi();
						String tel = voce.getTel();
				//		List listaVoci = s.getVoci();
				//		session.setAttribute("lista", listaVoci);
					%>
					<c:set var="i" value="1" scope="page" />
	
					<c:forEach items="${lista}" var="u">
	
						<tr>
							<td><c:out value="${i}" /></td>
							<td><c:out value="${u.nome}" /></td>
							<td><c:out value="${u.cognome}" /></td>
							<td><c:out value="${u.telefono}" /></td>
							
							 
							
							<td class="center">
				            <a class="btn btn-info" href="#">
				                <i class="glyphicon glyphicon-edit icon-white"></i>
				                Update </a>
				            <a class="btn btn-danger" href="#">
				                <i class="glyphicon glyphicon-trash icon-white"></i>
				                Delete </a>
					   	 	</td>
						</tr>
						<c:set var="i" value="${i + 1}" scope="page" />
					</c:forEach>
			</table>
			<ul class="pagination pagination-centered">
				<li><a href="#">Previous</a></li>
				<li class="active"><a href="#">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#">4</a></li>
				<li><a href="#">Next</a></li>
			</ul>


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

