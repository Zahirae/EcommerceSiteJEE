<%@page import="Beans.Article"%>
<%@page import="java.util.Vector"%>
<%@page import="dao.ArticleDao"%>
<%@page import="Beans.Categorie"%>
<%@page import="dao.CategoryDao"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Article Details | Zahira-SHOP</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/prettyPhoto.css" rel="stylesheet">
    <link href="css/price-range.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
	<link href="css/main.css" rel="stylesheet">
	<link href="css/responsive.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->       
    <link rel="shortcut icon" href="images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">
</head><!--/head-->

<body>
	<%@include file="header.jsp" %>
	<section>
		<div class="container">
			<div class="row">
				<div class="col-sm-3">
					<div class="left-sidebar">
						<h2>Category</h2>
						<div class="panel-group category-products" id="accordian"><!--category-productsr-->
							<div class="panel panel-default">
							<% CategoryDao daocat = new CategoryDao();
				               Vector<Categorie> categories = daocat.findAll(); %>
				            <% if(categories != null){
					        for (Categorie categorie : categories) {%>
								<div class="panel-heading">
									<h4 class="panel-title">
										<a data-toggle="collapse" data-parent="#accordian" href="#sportswear">
											<span class="badge pull-right"><i class="fa fa-plus"></i></span>
											<%= categorie.getCategorieName() %>
										</a>
									</h4>
								</div>
							 <%}%>
						    <%}%>
							</div>
						</div><!--/category-productsr-->					
						<div class="price-range"><!--price-range-->
							<h2>Price Range</h2>
							<div class="well">
								 <input type="text" class="span2" value="" data-slider-min="0" data-slider-max="600" data-slider-step="5" data-slider-value="[250,450]" id="sl2" ><br />
								 <b>$ 0</b> <b class="pull-right">$ 600</b>
							</div>
						</div><!--/price-range-->
						
						<div class="shipping text-center"><!--shipping-->
							<img src="images/home/shipping.jpg" alt="" />
						</div><!--/shipping-->
						
					</div>
				</div>
				<% ArticleDao dao = new ArticleDao();
				   Article article = dao.findByID(Integer.parseInt(request.getParameter("id"))); %>
				<div class="col-sm-9 padding-right">
					<div class="product-details"><!--product-details-->
						<div class="col-sm-5">
							<div class="view-product">
								<img src="images/home/article.png" alt="" />
							</div>
						</div>
						<div class="col-sm-7">
							<div class="product-information"><!--/product-information-->
								<img src="images/product-details/new.jpg" class="newarrival" alt="" />
								<h2><%= article.getDescription() %></h2>
								<p><%= article.getLibelle() %></p>
								<span>
									<span>US $<%= article.getPrix() %></span>
									<label>Quantity:</label>
									<input type="text" value="<%= article.getStock()%>" />
									<% if(request.getSession().getAttribute("client")!=null){%>
									<form class="btn btn-fefault cart" action="order">
										<input type="hidden" name="idArticle" value="<%= article.getIdArticle() %>">
										<input type="hidden" name="prix" value="<%= article.getPrix() %>">
										<button type="submit" >
											<i class="fa fa-shopping-cart"></i>
											Order
										</button>
									</form>
									
									<%}else{ %>
									<form class="btn btn-fefault cart" action="login">
										<button type="submit" >
											<i class="fa fa-shopping-cart"></i>
											Order
										</button>
									</form>
									<%} %>
								</span>
							</div><!--/product-information-->
						</div>
					</div><!--/product-details-->
				</div>
			</div>
		</div>
	</section>
	<%@include file="footer.jsp" %>
    <script src="js/jquery.js"></script>
	<script src="js/price-range.js"></script>
    <script src="js/jquery.scrollUp.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.prettyPhoto.js"></script>
    <script src="js/main.js"></script>
</body>
</html>