<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<title>Search Book</title>
</head>
<body>
	
 		
 									<b>Choose Payment Type: </b> 
									<ul>
										<li class="list-unstyled"><input type="radio" name="payment"
										value="payoff" onclick="hide()"/> Pay off<bR></li>
										<li class="list-unstyled"><input type="radio" name="payment"
										value="card" onclick="display()" checked="checked"/> Use credit card<br></li>
									</ul>
 					
 									<script>
										function display() {
  											document.getElementById("cardnam").style.display = "block";
										}

										function hide() {
  											document.getElementById("cardnam").style.display = "none";
										}
									</script>	
								
								<div id = "cardnam">
									<b>Choose a card:</b>
									<select class="select-picker" name="paymenttype">
										<sql:setDataSource var="card" user="root" password="van123" driver="com.mysql.jdbc.Driver" 
										url="jdbc:mysql://localhost:3306/bookstore"/>
										<sql:query var="data" dataSource="${card }">
											select creditcard.name,creditcard.company
															from bookstore.creditcard;
										</sql:query>
										<c:forEach items="${data.rows }" var="cardinf">
											<option>${cardinf.name } - ${cardinf.company }</option>
										</c:forEach>
									</select><br> 
								<b>Enter Card Number:</b> <input type="text"
								name="cardnumber" placeholder="enter your cardnumber"
								class="form-control" pattern="[0-9].{10,13}"><br> <br>
								</div>
 		
 		
 		
 		
 		
 		
 		
 		
 		<div id="dm">
		<h2 style="text-align: center"><i><b>Search Book</b></i></h2>
			<form action="SearchBook" method="POST" name = "searchf">
				<div class="input-group">
					<input name = "searchbarofstaff" placeholder = "enter book's name" type="text">
					<button name = "staffsearchbtn" type="submit" style="height: 34px;"></button> 
				</div>
			</form>
			<br>
		<table>
    			<thead >
      				<tr class="success table1">
       					<th>Book ID</th>
        				<th>Book Name</th>
        				<th>IDAuthor</th>
        				<th>IDPublisher</th>
        				<th>Price</th>
        				<th>Introduction</th>
      				</tr>
    			</thead>
    			<tbody>
				<c:forEach items="${listBook}" var="book">
      					<tr>
        					<td>${book.idBook }</td>
        					<td>${book.name }</td>
        					<td>${book.author.idauthor}</td>
        					<td>${book.publisher.idPublisher }</td>
        					<td>${book.price}</td>
        					<td>${book.introduction}</td>
      					</tr>
				</c:forEach>
			</tbody>
 		</table>
 		</div>
 		
</body>
</html>