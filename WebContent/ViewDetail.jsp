<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="Bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="Bootstrap/css/bootstrap-theme.min.css">
<script src="Bootstrap/js/jquery-3.2.1.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Book Detail</title>
</head>
<body>
	<div class="container">
	<c:when test="${checkser == 1 or checkuser == 1}">
				
				<div style="text-align: center"><h1><b><i>${bookname }</i></b></h1></div><br>
				<c:choose>
					<c:when test="${checkuser ==1 }">
						<div class="alert alert-danger">
							<p><i>Bạn chưa đăng ký tài khoản!</i></p>
						</div>
					</c:when>
				</c:choose>
	<div class="row">
		<div class="col-sm-5" >
			<div class = "thumbnail" style="width: 150;height: 300px;margin-left: 30px;" >
			<img alt="image" src="<%=  %>" style="width: 100%;height: 100%" class="img-rounded">
			</div>
		</div>
		<div class="col-sm-7" style="text-align: left;">
			<br>
			<h5><b >Author: ${authorname}</b></h5>
			<h3><b style="color: red;">Price: ${price} VND</b></h3>
			<form action="AddToCart" method="POST" name="addtocart">
			<button class="btn btn-warning"><h3><b style="color: red;">Add to Cart <span class="glyphicon glyphicon-shopping-cart"></span></b></h3></button>
			<input type="hidden" value="${usernamecus }" name="usernamecus">
			<input type="hidden" value="${cart}" name="cartnumber">
			<input type="hidden" value="${book}" name="bookinfo">
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
							<h5><b style="text-align: center;">Author Name: ${authorname}</b></h5><br>
							<h5><b style="text-align: center;">Author Age: ${authorage }</b></h5><br>
							<h5><b style="text-align: center;">Author Gender: ${authorgender }</b></h5><br>
							<h5><b style="text-align: center;">Author Address: ${authoraddress }</b></h5><br>
							<h5><b style="text-align: center;">Author PhoneNumber: ${authorphone }</b></h5><br>
							<h5><b style="text-align: center;">Author Email: ${authoremail }</b></h5><br>
						</div>
						<div class="col-sm-4">
							<h3><b style="text-align: center;color: blue;">Publisher</b></h3><br>
							<h5><b style="text-align: center;">Publisher Name: ${publishername}</b></h5><br>
							<h5><b style="text-align: center;">Publisher Address: ${publisheraddress}</b></h5><br>
							<h5><b style="text-align: center;">Publisher PhoneNumber: ${publisherphone}</b></h5><br>
							<h5><b style="text-align: center;">Publisher Introduction: ${publisherintro}</b></h5><br>
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
			</c:when>
	</div>
</body>
</html>