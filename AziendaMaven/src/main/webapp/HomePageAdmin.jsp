<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <!-- per far funzionare c:out in tutti gli elenchi(integrazione jstl -->
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ page isELIgnored="false" %>
    

    <jsp:useBean id="admin" class="it.alfa.rossella.bean.AdminBean" scope="session"></jsp:useBean>
    
    <!--        header di pagina  -->

<jsp:include page="head.jsp"></jsp:include>



<!-- nav bar starts -->

<jsp:include page="NavBarAdmin.jsp"></jsp:include>



<div class="ch-container">

	<div class="row">



		<!-- left menu starts -->

		<jsp:include page="menuLateraleAdmin.jsp"></jsp:include>

		<!-- left menu ends -->


<!--  
		<noscript>

			<div class="alert alert-block col-md-12">

				<h4 class="alert-heading">Warning!</h4>



				<p>
					You need to have <a href="http://en.wikipedia.org/wiki/JavaScript"
						target="_blank">JavaScript</a> enabled to use this site.
				</p>

			</div>

		</noscript>
-->


		<div id="content" class="col-lg-10 col-sm-10">

			<!-- content starts -->

			<div>

				<ul class="breadcrumb">

					<li> Home : <c:out value="${admin.nome}"/></li>



				</ul>

			</div>

			<div class=" row">



				<!--       devo scrivere per ogni pagina   -->













			</div>
			<!-- content ends -->

		</div>
		<!--/#content.col-md-0-->

	</div>
	<!--/fluid-row-->









	<hr>



	<jsp:include page="footer.jsp"></jsp:include>





</div>
<!--/.fluid-container-->



<!--      includo tutti script di sotto -->

    