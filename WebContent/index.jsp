<%@page import="Beans.Article"%>
<%@page import="Beans.Client"%>
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
    <title>Zahira-SHOP</title>
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
				
				<div class="col-sm-9 padding-right">
					<div class="features_items"><!--features_items-->
						<h2 class="title text-center">Articles</h2>
						<% ArticleDao dao = new ArticleDao();
				           Vector<Article> articles = dao.findAll(); %>
				        <% if(articles != null){
					        for (Article article : articles) {%>
						<div class="col-sm-4">
							<div class="product-image-wrapper">
								<div class="single-products">
									<div class="productinfo text-center">
										<img src="images/home/article.png" alt="" />
										<h2>$<%= article.getPrix() %></h2>
										<p><%= article.getLibelle() %></p>
										<a href="http://localhost:8081/Zahirae/article.jsp?id=<%= article.getIdArticle()%>" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Details</a>
									</div>
									<div class="product-overlay">
										<div class="overlay-content">
											<h2>$<%= article.getPrix() %></h2>
											<p><%= article.getLibelle() %></p>
											<a href="http://localhost:8081/Zahirae/article.jsp?id=<%= article.getIdArticle()%>" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Details</a>
										</div>
									</div>
								</div>
								
							</div>
						</div>
						   <%}%>
						<%}%>	
						
					</div><!--features_items-->
					<div class="category-tab"><!--category-tab-->
					</div>
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