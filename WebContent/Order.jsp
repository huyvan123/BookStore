<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="BookModel.Book"%>
<%@page import="BookModel.Cart"%>
<%@page import="BookModel.Customer"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="Bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="Bootstrap/css/bootstrap-theme.min.css">
<script src="Bootstrap/js/bootstrap.min.js">
	
</script>
<script src="Bootstrap/js/jquery-3.2.1.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>Order</title>
</head>
<body>
	<div class="container">
		<h2 style="text-align: center">
			<i><b>Create Order</b></i>
		</h2>
		<br>
		<c:choose>
			<c:when test="${checkOrder == 1 }">
				<div class="row">
					<div class="col-sm-3"></div>
					<div class="col-sm-6">
						<div class="alert alert-success">Order Successful!</div>
						<form action="sach" method="GET">
							<button class="btn btn-primary" style="margin-left: 50%;"
								type="submit">OK</button>
						</form>
					</div>
					<div class="col-sm-2"></div>
				</div>
			</c:when>
			<c:otherwise>
				<%
					try {
								int check = Integer.parseInt(request.getParameter("checkOrder"));
								if (check == 0) {
				%>
				<div class="alert alert-warning">ID card unavailable!</div>

				<%
					}
							} catch (Exception o) {
							}
				%>
				<form action="Order" method="POST">
					<div class="row">
						<div class="col-sm-2"></div>
						<div class="col-sm-8">
							<div class="row">
								<div class="col-sm-2">
									<input type="text" name="country" placeholder="country"
										class="form-control" pattern=".{1,}" required>
								</div>
								<div class="col-sm-2">
									<input type="text" name="city" placeholder="city"
										class="form-control" pattern=".{1,}" required>
								</div>
								<div class="col-sm-2">
									<input type="text" name="district" placeholder="district"
										class="form-control" pattern=".{1,}" required>
								</div>
								<div class="col-sm-2">
									<input type="text" name="street" placeholder="street"
										class="form-control" pattern=".{1,}" required>
								</div>
								<div class="col-sm-2">
									<input type="text" name="lane" placeholder="lane"
										class="form-control" pattern=".{1,}" required>
								</div>
								<div class="col-sm-2">
									<input type="text" name="no" placeholder="number"
										class="form-control" pattern=".{1,}" required>
								</div>
							</div>
							<br> <b>Choose Payment Type: </b>
							<ul>
								<li class="list-unstyled"><input type="radio"
									name="payment" value="payoff" onclick="hide()" /> Pay off<bR></li>
								<li class="list-unstyled"><input type="radio"
									name="payment" value="card" onclick="display()"
									checked="checked" /> Use credit card<br></li>
							</ul>

							<script>
								function display() {
									document.getElementById("cardnam").style.display = "block";
								}

								function hide() {
									document.getElementById("cardnam").style.display = "none";
								}
							</script>

							<div id="cardnam">
								<b>Choose a card:</b> <select class="select-picker"
									name="paycard">
									<sql:setDataSource var="card" user="root" password="van123"
										driver="com.mysql.jdbc.Driver"
										url="jdbc:mysql://localhost:3306/bookstore" />
									<sql:query var="data" dataSource="${card }">
											select creditcard.name,creditcard.company
															from bookstore.creditcard;
										</sql:query>
									<c:forEach items="${data.rows }" var="cardinf">
										<option>${cardinf.name } - ${cardinf.company }</option>
									</c:forEach>
								</select><br> <b>Enter Card Number:</b> <input type="text"
									name="cardnumber" placeholder="enter your cardnumber"
									class="form-control" pattern="[0-9].{10,13}"><br>
								<br>
							</div>

							<table class="table table-bordered">
								<thead>
									<tr>
										<th>Name</th>
										<th>Price</th>
										<th>Quantity</th>
										<th>DiscountPercent</th>
									</tr>
								</thead>
								<tbody>
									<%
										Customer customer = (Customer) session.getAttribute("customer");
												for (Book book : customer.getListBook()) {
									%>
									<tr>
										<td><%=book.getName()%></td>
										<td><%=book.getPrice()%></td>
										<td><%=book.getQuantity()%></td>
										<td><%=book.getDiscount().getDiscountPercent()%></td>
									</tr>
									<%
										}
									%>
								</tbody>
							</table>
							<b>Total Price: <%=customer.getTotalPrice()%></b>
						</div>
						<div class="col-sm-3"></div>
					</div>
					<div class="row">
						<button class="btn btn-primary" style="margin-left: 50%;"
							type="submit">Create Order</button>
					</div>
				</form>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>