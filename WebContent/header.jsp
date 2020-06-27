<%@page import="Beans.Client"%>
<header id="header"><!--header-->
		<div class="header-middle"><!--header-middle-->
			<div class="container">
				<div class="row">
					<div class="col-sm-4">
						<div class="logo pull-left">
							<a href="http://localhost:8081/Zahirae/index.jsp"><img src="images/home/logo.png" alt="" /></a>
						</div>
					</div>
					<div class="col-sm-8">
						<div class="shop-menu pull-right">
							<ul class="nav navbar-nav">
							<% if(request.getSession().getAttribute("client")!=null){  
							Client client = (Client) request.getSession().getAttribute("client");%>
							    <li><a href="http://localhost:8081/Zahirae/index.jsp"><i class="fa fa-user"></i> <%= client.getNom() %></a></li>
								<li><a href="http://localhost:8081/Zahirae/index.jsp"><i class="fa fa-star"></i> Articles</a></li>
								<li><form action="PanierServlet">
									 <i class="fa fa-shopping-cart"><input type="submit" value="Cart"/></i>
									</form>
								</li>
								<li><form action="logout">
									 <i class="fa fa-lock"><input type="submit" value="logout"/></i>
									</form>
								</li>
							<%}else{%>
								<li><a href="http://localhost:8081/Zahirae/index.jsp"><i class="fa fa-star"></i> Articles</a></li>
								<li><a href="http://localhost:8081/Zahirae/inscription.jsp"><i class="fa fa-star"></i> Singup</a></li>
								<li><a href="http://localhost:8081/Zahirae/login.jsp"><i class="fa fa-lock"></i> Login</a></li>
							<%} %>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div><!--/header-middle-->
	
		<div class="header-bottom"><!--header-bottom-->
			<div class="container">
				<div class="row">
					<div class="col-sm-9">
						<div class="navbar-header">
							<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
								<span class="sr-only">Toggle navigation</span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
							</button>
						</div>
						<div class="mainmenu pull-left">
							<ul class="nav navbar-nav collapse navbar-collapse">
								<li><a href="http://localhost:8081/Zahirae/index.jsp">Home</a></li>
								<li class="dropdown"><a href="#" class="active">Shop<i class="fa fa-angle-down"></i></a>
                                    <ul role="menu" class="sub-menu">
                                        <li><a href="http://localhost:8081/Zahirae/index.jsp" class="active">Articles</a></li>
										<li><a href="http://localhost:8081/Zahirae/login.jsp">Login</a></li> 
                                    </ul>
                                </li> 
								<li><a href="http://localhost:8081/Zahirae/contactez-nous.jsp">Contact</a></li>
							</ul>
						</div>
					</div>
					<div class="col-sm-3">
						<div class="search_box pull-right">
							<input type="text" placeholder="Search"/>
						</div>
					</div>
				</div>
				</div>
			</div>
	</header>    