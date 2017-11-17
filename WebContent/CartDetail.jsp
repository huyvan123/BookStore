<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@page import="BookModel.Book"%>
    <%@page import="BookModel.Cart"%>
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
<title>CartDetail</title>
</head>
<body>
<br><br><Br>
	<div class="container">
	<div class="row">
		<h2 style="text-align: center"><i><b>Your Cart</b></i></h2>
	</div>
<br><br><br>
		<div class="row">
		<div class="col-sm-2"></div>
		<div class="col-sm-8">
				<table class="table table-bordered  ">
    					<thead >
      						<tr class="success">
       							 <th>Book Name</th>
        						<th>Author Name</th>
        						<th>Publisher Name</th>
        						<th>Category</th>
        						<th>Price</th>
        						<th>Quantity</th>
        						<th>Discount Percent</th>
        						<th>Introduction</th>
      						</tr>
    					</thead>
    					<tbody>
							<c:forEach items="${customer.listBook}" var="book">
      							<tr>
        							<td>${book.name }</td>
        							<td>${book.author.name.fullName }</td>
        							<td>${book.publisher.name}</td>
        							<td>${book.category }</td>
        							<td>${book.price}</td>
        							<td>${book.quantity }</td>
        							<td>${book.discount.discountPercent }</td>
        							<td>${book.introduction}</td>
        							<td><a href="ViewDetail.jsp"><button class="btn btn-primary" title="view detail"><span class="glyphicon glyphicon-circle-arrow-right"> Delete</span></button></a></td>
      							</tr>
							</c:forEach>
					    </tbody>
 				</table>
							<b>Total Price: ${customer.getTotalPrice()} VND</b>
			
		</div>
		<div class="col-sm-2"></div>
	</div>
	<div class = "row" >
		<form action="Order.jsp" method="POST" name = "getorder">
			<button class="btn btn-primary" style="margin-left: 50%;" type="submit">Purchase</button>
		</form>
	</div>
	</div>
</body>
</html>