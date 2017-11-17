<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<link rel="stylesheet" type="text/css"
	href="Bootstrap/css/bootstrap-select.css">
<title>AddBook</title>
</head>
<body>

	<br>
	<div class="container">
		<sql:setDataSource var="author" driver="com.mysql.jdbc.Driver"
			user="root" password="van123"
			url="jdbc:mysql://localhost:3306/bookstore" />
		<div>
			<h1 style="text-align: center;">
				<b>ADD BOOK</b>
			</h1>
		</div>
		<c:choose>
			<c:when test="${checkbook == 1}">
				<div class="alert alert-success" style="text-align: center">
					<strong>Add Successful</strong>
				</div>
			</c:when>
			<c:when test="${checkbook == 0}">
				<div class="alert alert-danger">
					<strong>Add Fail</strong>
				</div>
			</c:when>
			<c:otherwise>
			</c:otherwise>
		</c:choose>
		<br>
		<div class="row">
			<form action="AddBook" name="addbook" method="POST">
				<div class="col-sm-3">
					<b>Quantity:</b> <input class="form-control" name="bookquantity"
						type="text" pattern=".{1,}" required placeholder="enter quantity"><br>
					<b>Category:</b> <select class="form-control" name="category" id="cc">
						<sql:query var="result" dataSource="${author }">
								select bookcategory.name
									from bookstore.bookcategory order by bookcategory.name asc;
							</sql:query>
						<c:forEach var="cate" items="${result.rows }">
							<option onclick="getname()">${cate.name }</option>
						</c:forEach>
					</select><br>
					<input type="text" class="form-control" name="bookcategory" id="cate" required>
					<script>
										function getname() {
											var c1= document.getElementById("cc").value;
											var c2= document.getElementById("cate").value;
											if(c2=="")
  											document.getElementById("cate").value = c1;
											else document.getElementById("cate").value = c2+", "+c1;
										}

									</script>	
					
					<br> <b>Discount:</b> <select class="form-control"
						name="discount">
						<sql:query var="result" dataSource="${author }">
								select discount.ID,discount.name,discount.discountPercen
										from bookstore.discount;
							</sql:query>
						<c:forEach var="disc" items="${result.rows }">
							<option>${disc.ID }: ${disc.name } - ${disc.discountPercen }</option>
						</c:forEach>
					</select>

				</div>
				<div class="col-sm-3">
					<b>Name:</b> <input class="form-control" name="bookname"
						type="text" pattern=".{1,}" required
						placeholder="enter book's name"><br>
					<div>
						<b>Author:</b><br> <select name="author" class="form-control">
							<sql:query var="result" dataSource="${author }">
									select author.ID,person.name
										from bookstore.author,bookstore.person
											where author.idPerson = person.ID;
							</sql:query>
							<c:forEach items="${result.rows }" var="kq">
								<option>${kq.ID }: ${ kq.name }</option>
							</c:forEach>
						</select>
					</div>
					<br>
					<div>
						<b>Publisher:</b> <br> <select name="publisher"
							class="form-control">
							<sql:query var="result" dataSource="${author }">
								select company.ID,company.name
										from bookstore.company;
							</sql:query>
							<c:forEach var="pub" items="${result.rows }">
								<option>${pub.ID }: ${ pub.name }</option>
							</c:forEach>
						</select>
					</div>
					<br> <b>Price:</b> <input class="form-control" name="price"
						type="text" pattern="[0-9].{3,19}" required
						placeholder="enter price"><br> <b>Introduction:</b> <input
						class="form-control" name="introduction" type="text"
						placeholder="enter introduction of this book"><br>
					<button class="btn btn-primary" name="addbookbtn" type="submit" value="cc">Add</button>
				</div>
				<br>
			</form>
			<form action="AddBook" name="chooseimage" method="POST"
				enctype="multipart/form-data">
				<div class="col-sm-3">
					<div class="thumbnail" style="width: 120px; height: 150px;">
						<img src="${message}" style="width: 100%; height: 100%;">
					</div>
					<b>Choose book's image</b> <input type="file" name = "image" required><br>
					<button class="btn btn-primary" type="submit">Set Image</button>
				</div>
			</form>
			<div class="col-sm-3">
				<div class="btn-group" style="margin-left: 20%">
					<form action="AddDiscount.jsp" method="POST" name = "addauthor">
					<button type="submit" name="adddiscount" class="btn btn-info"
						style="width: 150px;">Add Discount</button>
					</form>
					<form action="AddPublisher.jsp" method="POST" name = "addauthor">
					<button type="submit" name="addpublisher" class="btn btn-info"
						style="width: 150px;">Add Publisher</button>
					</form>
					<form action="AddBookCategory.jsp" method="POST" name = "addauthor">
					<button type="submit" name="addcategoy" class="btn btn-info"
						style="width: 150px;">Add Category</button>
					</form>
					<form action="AddAuthor.jsp" method="POST" name = "addauthor">
					<button type="submit" name="addauthor" class="btn btn-info"
						style="width: 150px;">Add Author</button>
					</form>
				</div>
			</div>
		</div>
		
	</div>
</body>
</html>