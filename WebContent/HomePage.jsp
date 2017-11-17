<%@page import="BookModel.Book"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="Bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="Bootstrap/css/bootstrap-theme.min.css">
<script src="Bootstrap/js/bootstrap.min.js"> </script>
<script src="Bootstrap/js/jquery-3.2.1.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>


<title>ANAVEL BOOK</title>
</head>
<body>
	<div class = "container" style="background-color:silver; font-family: sans-serif;">
		<a href="http://localhost:8085/BookStore/sach" style="text-decoration: none;"><spen style="font-family: impact; color: #568203"><h1 ><i>ANAVEL BOOK</i></h1> </spen></a>
	 <!--Start header-->
		<nav class="navbar navbar-inverse ">
			<div class="container-fluid ">
				<div class = "navbar-header">
					<a href="http://localhost:8085/BookStore/sach" class="navbar-brand">Home</a>
				</div>
					<ul class="nav navbar-nav">
						<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle = "dropdown">View</a>
							<ul class="dropdown-menu">
								<li><a href="#">View1</a></li>
								<li><a href="#">View2</a></li>
								<li><a href="#">View2</a></li>
							</ul>
						</li>
						<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle = "dropdown">Popular</a>
							<ul class="dropdown-menu">
								<li><a href="#">Popular1</a></li>
								<li><a href="#">Popular2</a></li>
								<li><a href="#">Popular3</a></li>
							</ul>
						</li>
						<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle = "dropdown">Caregories</a>
							<ul class="dropdown-menu">
								<li><a href="#">Caregories1</a></li>
								<li><a href="#">Caregories2</a></li>
								<li><a href="#">Caregories3</a></li>
							</ul>
						</li>
					</ul>
					<ul class="nav navbar-nav navbar-right">
<!-- 					ĐĂNG NHẬP, ĐĂNG XUẤT, CART	 -->
						<% if(session.getAttribute("username") != null){ %>
							<li>
								<a href="CartDetail"><strong style="background-color: white;color: black;" >
									<i ><%= session.getAttribute("itemquantity") %>  </i>	
										</strong>
										<span class="glyphicon glyphicon-shopping-cart">Cart</span>
								</a>
								</li>
							<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"><b style="color: white;"><i><%= session.getAttribute("username") %></i></b><span class="glyphicon glyphicon-user"><span class="glyphicon glyphicon-triangle-bottom"></span></span></a>
									<ul class="dropdown-menu">
										<li>
										<button class="btn btn-default" type="submit" style="width: 160px;"><span class="glyphicon glyphicon-circle-arrow-right"> ViewDetail</span></button>
										</li>
										<li>
										<form method="POST" action="Logout">
										<button class="btn btn-default" type="submit" style="width: 160px;"><span class="glyphicon glyphicon-log-out"> LogOut</span></button>
										</form>
										</li>
									</ul>
							</li>
						<%} else{%>
							<li><a href="#"><span class="glyphicon glyphicon-shopping-cart"> Cart </span></a></li>
							<li><a href="http://localhost:8085/BookStore/Login.jsp"><span class="glyphicon glyphicon-user"></span> Đăng nhập</a></li>
							<li><a href="http://localhost:8085/BookStore/Login.jsp"><span class="glyphicon glyphicon-log-in"> Đăng ký</span></a></li>
						<%} %>
					</ul>
			</div>
		</nav>
		<!-- end header -->
		<!-- start search -->
		<div class="container-fluid">
			<form class="navbar-form navbar-right" name ="searchform" action="SearchBook" method="POST">
					<input type="text" class="form-control" placeholder="Search" name="homesearchbar">
				<div class="input-group">
					<div class="input-group-btn">
						<button class="btn btn-default" type="submit" style="height: 34px;" name="homesearchbtn">
							<i class="glyphicon glyphicon-search"></i>
						</button>
					</div>
				</div>
			</form>
		</div>
		<!-- end search -->
		<!-- Start body -->
		<div class="row">
			<!-- start left body -->
			<div class="col-sm-2" >
				<div class="panel-group" id="panelGroup">
					<div class="panel panel-success">
						<div class="panel-heading">
							<h4 class="panel-title">
								<a href="#collapse1" data-toggle ="collapse" data-parent ="#panelGroup">Ngôn tình</a>
							</h4>
						</div>
						<div id="collapse1" class="panel-collapse collapse in">
							<div class="panel-body">
								body body body body body body
								body body body
								body body body
								body body body
								body body body
							</div>
						</div>
					</div>
					<div class="panel panel-success">
						<div class="panel-heading">
							<h4 class="panel-title">
								<a href="#collapse2" data-toggle = "collapse"
								data-parent = "#panelGroup">Lịch sử</a>
							</h4>
						</div>
						<div id="collapse2" class="panel-collapse collapse">
							<div class="panel-body">
								body body body body body body
								body body body
								body body body
								body body body
								body body body
							</div>
						</div>
					</div>
					<div class="panel panel-success">
						<div class="panel-heading">
							<h4 class="panel-title">
								<a href="#collapse3" data-toggle ="collapse" data-parent = "#panelGroup">Học trò</a>
							</h4>
						</div>
						<div id="collapse3" class="panel-collapse collapse">
							<div class="panel-body">
								body body body body body body
								body body body
								body body body
								body body body
								body body body
							</div>
						</div>
					</div>
					<div class="panel panel-success">
						<div class="panel-heading">
							<h4 class="panel-title">
								<a href="#collapse4" data-toggle = "collapse" data-parent = "#panelGroup">
									Du ký
								</a>
							</h4>
						</div>
						<div id="collapse4" class="panel-collapse collapse">
							<div class="panel-body">
								body body body body body body
								body body body
								body body body
								body body body
								body body body
							</div>
						</div>
					</div>
					<div class="panel panel-success">
						<div class="panel-heading">
							<h4 class="panel-title">
								<a href="#collapse5" data-toggle = "collapse" data-parent = "#panelGroup">
									Văn học
								</a>
							</h4>
						</div>
						<div id="collapse5" class="panel-collapse collapse">
							<div class="panel-body">
								body body body body body body
								body body body
								body body body
								body body body
								body body body
							</div>
						</div>
					</div>
					<div class="panel panel-success">
						<div class="panel-heading">
							<h4 class="panel-title">
								<a href="#collapse7" data-toggle = "collapse" data-parent = "#panelGroup">
									Nghệ thuật
								</a>
							</h4>
						</div>
						<div id="collapse7" class="panel-collapse collapse">
							<div class="panel-body">
								body body body body body body
								body body body
								body body body
								body body body
								body body body
							</div>
						</div>
					</div>
					
				</div>
			</div>
			<!-- end left body -->
			
			
			
			<!-- start center body -->
			<div class="col-sm-7">
		<c:choose>
			<c:when test="${checkcenter == 2}">
				<% Book book = (Book)session.getAttribute("book"); %>
				<div style="text-align: center"><h1><b><i><%= book.getName() %></i></b></h1></div><br>
				<c:choose>
					<c:when test="${checkaddtocart == 0 }">
						<div class="alert alert-danger">
							<p><i>You have not an Account yet!</i></p>
						</div>
					</c:when>
				</c:choose>
				<div class="row">
					<div class="col-sm-5" >
						<div class = "thumbnail" style="width: 150;height: 300px;margin-left: 30px;" >
						<img alt="image" src="<%=book.getImage()  %>" style="width: 100%;height: 100%" class="img-rounded">
						</div>
					</div>
					<div class="col-sm-7" style="text-align: left;">
						<br>
						<h5><b >Author: <%=book.getAuthor().getName().getFullName() %></b></h5>
						<h3><b style="color: red;">Price: <%=book.getPrice() %> VND</b></h3>
						<form action="AddToCart" method="POST" name="addtocart">
							<select class="select select-picker" name="bookquantity" >
								<% for(int i = 1;i<book.getQuantity();i++){ %>
									<option><%= i %></option>
								<%} %>
							</select>
							<button class="btn btn-warning"><h3><b style="color: red;">Add to Cart <span class="glyphicon glyphicon-shopping-cart"></span></b></h3></button>
						</form>
					</div>
				</div>
				<div class="row">
					<ul class="nav nav-tabs">
    					<li class="active"><a data-toggle="tab" href="#bookdetail">Book Detail</a></li>
   						<li><a data-toggle="tab" href="#bookreview">Book Review</a></li>
  					</ul>
  					<div class="tab-content">
    					<div id="bookdetail" class="tab-pane fade in active">
      						<div class="col-sm-4">
								<h3><b style="text-align: center; color: blue;">Author</b></h3><br>
								<b style="text-align: center;">Author Name: <%=book.getAuthor().getName().getFullName() %></b><br>
								<b style="text-align: center;">Author <%=book.getAuthor().getAge().getFullDOB().toString() %></b><br>
								<b style="text-align: center;">Author Gender: <%=book.getAuthor().getGender() %></b><br>
								<b style="text-align: center;">Author Address: <%=book.getAuthor().getAddress().getFullAddress() %></b><br>
								<b style="text-align: center;">Author PhoneNumber: <%=book.getAuthor().getPhoneNumber() %></b><br>
								<b style="text-align: center;">Author Email: <%=book.getAuthor().getEmail() %></b><br>
								<b style="text-align: center;">Author Experience: <%=book.getAuthor().getExp() %></b><br>
								<b style="text-align: center;">Author Introduction: <%=book.getAuthor().getIntroduction() %></b><br>
							</div>
							<div class="col-sm-4">
								<h3><b style="text-align: center;color: blue;">Publisher</b></h3><br>
								<b style="text-align: center;">Publisher Name: <%=book.getPublisher().getName() %></b><br>
								<b style="text-align: center;">Publisher Address: <%=book.getPublisher().getAddress().getFullAddress() %></b><br>
								<b style="text-align: center;">Publisher PhoneNumber: <%=book.getPublisher().getPhoneNumber() %></b><br>
								<b style="text-align: center;">Publisher Website: <%=book.getPublisher().getWebSite() %></b><br>
								<b style="text-align: center;">Publisher Rank: <%=book.getPublisher().getRank() %></b><br>
								<b style="text-align: center;">Publisher Introduction: <%=book.getPublisher().getIntroduction() %></b><br>
							</div>
							<div class="col-sm-4">
								<h3><b style="text-align: center;color: blue;">Book Introduction</b></h3><br>
							</div>
    					</div>
    					<div id="bookreview" class="tab-pane fade">
								<h3><b style="text-align: center;color: blue;">Book Review</b></h3><br>
    					</div>
  					</div>
				</div>
				<%session.removeAttribute("checkcenter"); %>
			</c:when>
			<c:when test="${checkcenter == 3 }">
				<div class="alert alert-success" style="margin-left: 50%">
					<b><i>Add book to cart successful!</i></b>
				</div>
				<% session.removeAttribute("checkcenter"); %>
				<form action="HomePage.jsp">
					<button class="btn btn-warning" type="submit">Ok</button>
				</form>
			</c:when>
			<c:when test="${checkcenter == 1 }">
				<div style="text-align: center;"><h3><b>Search for key <i>"${bookname}"</i></b></h3></div><br>
				<div class="row">
					<c:forEach items="${listBook}" var="book">
  						<div class="col-md-4">
  							<form  method="POST" name = "viewdt" id="viewdt" >
  								<div class="thumbnail" style="width: 200px;height: 320px;">
									<a href="<c:url value="BookDetail"><c:param name="idbook" value="${book.idBook}"/></c:url>">
										<img src="${book.image}" alt="${book.name }" style="width: 100%;height: 80%" >
										<i class="caption">${book.name }<br> ${book.price} VNĐ</i>
									</a>
  								</div>
  							</form>
  						</div>
					</c:forEach>
				</div>
				<div>
  					<ul class="pager">
    					<li><a href="#">Previous</a></li>
   						<li><a href="#">Next</a></li>
  					</ul>
  				</div>
  				<%session.removeAttribute("checkcenter"); %>
			</c:when>
			<c:otherwise>
				<div id="slide1" class="carousel slide" data-ride="carousel">
    			<!-- Hiển thị -->
    				<ol class="carousel-indicators">
      					<li data-target="#slide1" data-slide-to="0" class="active"></li>
      					<li data-target="#slide1" data-slide-to="1"></li>
      					<li data-target="#slide1" data-slide-to="2"></li>
    				</ol>

    				<!-- Wrapper for slides -->
    				<div class="carousel-inner">
      					<div class="item active">
        					<img src="Image/sleepa.png" alt="Anavel" style="width:100%;">
      					</div>

      					<div class="item">
        					<img src="Image/chiwu2.png" alt="Chiwu" style="width:100%;">
      						</div>
      					<div class="item">
        					<img src="Image/anavel2.png" alt="Anavel" style="width:100%;">
      					</div>
    				</div>

    				<!-- Left and right controls -->
    				<a class="left carousel-control" href="#slide1" data-slide="prev">
      					<span class="glyphicon glyphicon-chevron-left"></span>
      					<span class="sr-only">Previous</span>
    				</a>
    				<a class="right carousel-control" href="#slide1" data-slide="next">
     				 	<span class="glyphicon glyphicon-chevron-right"></span>
      					<span class="sr-only">Next</span>
    				</a>
  				</div><br><br>
  				<!--show images default-->


		  			<% 
		  			
		  			if(request.getAttribute("checkv") != null){ 
		  				ArrayList<Book> list= (ArrayList<Book>)request.getAttribute("listbook"); 
		  					%>
		  						<div class="row">
		  							<%	
		  								for(Book book:list){
		  									String id = book.getIdBook()+"";
		  							%>
		  				
		  				
		  								<div class="col-md-4">
		  									<div class="thumbnail" style="width: 200px;height: 320px;">
		  										<a href="<c:url value="BookDetail"><c:param name="idbook" value="<%=id %>"/></c:url>">
		  											<img src="<%= book.getImage() %>" alt="<%= book.getName() %>" style="width: 100%;height: 80%">
		  											<i class="caption"><%= book.getName() %> <br><%=book.getPrice() %>VNĐ</i>
		  										</a>
		  									</div>
		  								</div>
		  								<%}%>
		  					
		  						</div>
		  						<div>
		  						<ul class="pager">
		  						<%if(request.getAttribute("checkv").equals("0")){ %>
		    						<li><a href="<c:url value = "/sach" ><c:param name="pre" value="pre" /> </c:url>">Previous</a></li>
		   							<li class = "disabled"><a href="#">Next</a></li>
		  						<%}else if(request.getAttribute("checkv").equals("2")){ %>
		  							<li class = "disabled"><a href='#'>Previous</a></li>
		   							<li><a href='<c:url value = "/sach"><c:param name="next" value="next"/></c:url>'>Next</a></li>
		   						<%}else{ %>	
		   							<li><a href="<c:url value = "/sach" ><c:param name="pre" value="pre" /> </c:url>">Previous</a></li>
		   							<li><a href='<c:url value = "/sach"><c:param name="next" value="next"/></c:url>'>Next</a></li>
		   						<%} %>
		  						</ul>
		  						</div>
		  					
		  		<% } else{%>
		  						
		  			<div><h1 style="text-align: center;color: black;"><b>Not found!</b></h1></div>
		  					
		  		<%} %><br><br>
		  					<div><h2 style="text-align: right;color: black;"><b>Most View</b></h2></div>
		  					<hr><br>
		  					<%  
		  						ArrayList<Book> listv= (ArrayList<Book>)request.getAttribute("listbookView"); 
		  					%>
		  						<div class="row">
		  							<%	
		  								for(Book book:listv){
		  									String id = book.getIdBook()+"";
		  							%>
		  				
		  				
		  								<div class="col-md-4">
		  									<div class="thumbnail" style="width: 200px;height: 320px;">
		  										<a href="<c:url value="BookDetail"><c:param name="idbook" value="<%=id %>"/></c:url>">
		  											<img src="<%= book.getImage() %>" alt="<%= book.getName() %>" style="width: 100%;height: 80%">
		  											<i class="caption"><%= book.getName() %> <br><%=book.getPrice() %>VNĐ</i>
		  										</a>
		  									</div>
		  								</div>
		  								<%}%>
		  					
		  						</div>
  				
  							<br><br>
  							<div><h2 style="text-align: right;color: black;"><b>Most Purchase</b></h2></div>
		  					<hr><br>
		  					<%  
		  						ArrayList<Book> listp= (ArrayList<Book>)request.getAttribute("listbookPurchase"); 
		  					%>
		  						<div class="row">
		  							<%	
		  								for(Book book:listp){
		  									String id = book.getIdBook()+"";
		  							%>
		  				
		  				
		  								<div class="col-md-4">
		  									<div class="thumbnail" style="width: 200px;height: 320px;">
		  										<a href="<c:url value="BookDetail"><c:param name="idbook" value="<%=id %>"/></c:url>">
		  											<img src="<%= book.getImage() %>" alt="<%= book.getName() %>" style="width: 100%;height: 80%">
		  											<i class="caption"><%= book.getName() %> <br><%=book.getPrice() %>VNĐ</i>
		  										</a>
		  									</div>
		  								</div>
		  								<%}%>
		  					
		  						</div>
  				
  				
  				
  				
  				
  				
			</c:otherwise>


		</c:choose>


<!-- paper -->
			</div>
			<!-- end center body -->
			<!-- start right body -->
			<div class="col-sm-3">

				<ul class="nav nav-tabs">
    				<li class="active"><a data-toggle="tab" href="#about">About</a></li>
   					 <li><a data-toggle="tab" href="#tag">Tag</a></li>
    				<li><a data-toggle="tab" href="#contact">Contact</a></li>
  				</ul>

  				<div class="tab-content">
    				<div id="about" class="tab-pane fade in active">
      					<h3 align="center">About</h3>
      					<p>
      						Me
      					</p>
    				</div>
    				<div id="tag" class="tab-pane fade">
      					<h3 align="center">Tag</h3>
      					<p>
      						<a href="#">A</a> là gì<br>
      						<a href="#">B</a> là gì<br>
      						<a href="#">C</a> là gì<br>
      						<a href="#">D</a> là gì<br>
      					</p>
    				</div>
    				<div id="contact" class="tab-pane fade">
      					<h3 align="center">Contact</h3>
      					<p>Yêu cầu quảng cáo, vui lòng liên hệ với trung tâm rau sạch <a href="E:\Mian\mian\mian\videoplayback.mp4">NamViet</a></p>
    				</div>
  				</div><br>
<!--sách phổ biến-->
  				<div class="panel panel-success" style="font-family: cursive; color: #cc6699; background-color: silver"><h3>Sách phổ biến gần đây</h3></div>

  			<div style="background-color: #ffffcc; align-content: center;">
  				<br>
  				<div class="row">
  					<div class="col-sm-6">
  						<div class="thumbnail" style="width: 100%">
  							<a href="Image/daivietsuky.jpg" target="_blank">
  								<img src="Image/daivietsuky.jpg" alt="daivietsuky" class="img-circle" style="width: 100%">
  							</a>
  						</div>
  					</div>
  					<div class="col-sm-6">
  						<div class="caption">
  							<p>Đại Việt Sử Ký Toàn Thư là cuốn nhập môn sử Việt, nếu bạn là một người yêu thích lịch sử thì hãy chọn nó</p>
  						</div>
  					</div>	
  				</div>
  				<hr>
  				<div class="row">
  					<div class="col-sm-6">
  						<div class="thumbnail" style="width: 100%">
  							<a href="Image/daomongmo.jpg" target="_blank">
  								<img src="Image/daomongmo.jpg" alt="daomongmo" class="img-circle" style="width: 100%">
  							</a>
  						</div>
  					</div>
  					<div class="col-sm-6">
  						<div class="caption">
  							<p> Đảo mộng mơ, dây là một trong những cuốn sach bán chạy nhất, đồng thời cũng là một trong những cuốn sách hay nhất của Nguyễn Nhật Ánh</p>
  						</div>
  					</div>	
  				</div>
  				<hr>
  				<div class="row">
  					<div class="col-sm-6">
  						<div class="thumbnail" style="width: 100%">
  							<a href="Image/quangodilen.jpg" target="_blank">
  								<img src="Image/quangodilen.jpg" alt="quangodilen" class="img-circle" style="width: 100%">
  							</a>
  						</div>
  					</div>
  					<div class="col-sm-6">
  						<div class="caption">
  							<p>Quán gò đi lên, đây là một trong những cuốn sach bán chạy nhất, đồng thời cũng là một trong những cuốn sách hay nhất của Nguyễn Nhật Ánh</p>
  						</div>
  					</div>	
  				</div>
				<hr>
  				<div class="row ">
  					<div class="col-sm-6">
  						<div class="thumbnail" style="width: 100%">
  							<a href="Image/cochutgidenho.jpg" target="_blank">
  								<img src="Image/cochutgidenho.jpg" alt="Có chút gì để nhớ" class="img-circle" style="width: 100%">
  							</a>
  						</div>
  					</div>
  					<div class="col-sm-6">
  						<div class="caption">
  							<p>Đây là một trong những cuốn sach bán chạy nhất, đồng thời cũng là một trong những cuốn sách hay nhất của Nguyễn Nhật Ánh</p>
  						</div>
  					</div>	
  				</div>
  			</div>

			</div>
			<!-- end right body -->
		</div>
		<!-- start footer-->
		<nav class="navbar navbar-inverse">
			<div class="row">
				<div class="col-sm-6" style="color: white" align="center">
					<h3>Ngũ sách</h3>
					<p>that a</p>
					<p>that b</p>
					<p>that c</p>
				</div>
				<div class="col-sm-6" style="color: white" align="center">
					<h3>Ngũ kinh</h3>
					<p>that a</p>
					<p>that b</p>
					<p>that c</p>
				</div>
			</div>
		</nav>
	</div>
</body>
</html>