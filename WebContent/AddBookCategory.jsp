<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"
	src="//cdn.jsdelivr.net/jquery/1/jquery.min.js"></script>
<script type="text/javascript"
	src="//cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="//cdn.jsdelivr.net/bootstrap/3/css/bootstrap.css" />

<script type="text/javascript"
	src="//cdn.jsdelivr.net/bootstrap.daterangepicker/2/daterangepicker.js"></script>
<link rel="stylesheet" type="text/css"
	href="//cdn.jsdelivr.net/bootstrap.daterangepicker/2/daterangepicker.css" />
	
<title>AddBookCategoryr</title>
</head>
<body>
	<br>
	<div class="container">

		<div style="text-align: center">
			<h2>
				<b><i>Add BookCategory</i></b>
			</h2>
		</div>
		<br>

		<c:choose>
			<c:when test="${checkadd == 1}">
				<script type="text/javascript">
					alert("Add successful");
				</script>
			</c:when>
			<c:when test="${checkadd == 0}">
				<div class="alert alert-danger">
					<strong>Add fail!</strong>
				</div>
			</c:when>
			<c:otherwise>
			</c:otherwise>
		</c:choose>

		<div class="row">
				<div class="col-sm-3">	</div>
			<form  action="AddBookCategory" method="POST">
				<div class="col-sm-3">

					<b>Name: </b> <input class="form-control" name="name" type="text" placeholder = "enter book category">
					<br>
					<div style="margin-left: 40%">
						<button class="btn btn-primary" name="add" type="submit">
						ADD</button>
					</div>
					<br><br><br>
				</div>
			</form>
				<div class="col-sm-3"></div>
			<div class = "col-sm-3">
				<div class="btn-group" style="margin-left: 20%">
					<form action="AddDiscount.jsp" method="POST" name = "addbook">
					<button type="submit" name="adddiscount" class="btn btn-info"
						style="width: 150px;">Add Discount</button>
					</form>
					<form action="AddAuthor.jsp" method="POST" name = "addbook">
					<button type="submit" name="addauthor" class="btn btn-info"
						style="width: 150px;">Add Author</button>
					</form>
					<form action="AddPublisher.jsp" method="POST" name = "addbook">
					<button type="submit" name="addcategoy" class="btn btn-info"
						style="width: 150px;">Add Publisher</button>
					</form>
					<form action="AddBook.jsp" method="POST" name = "addbook">
					<button type="submit" name="addbook" class="btn btn-info"
						style="width: 150px;">Add Book</button>
					</form>
				</div>
			</div>
		</div>

	</div>
</body>
</html>