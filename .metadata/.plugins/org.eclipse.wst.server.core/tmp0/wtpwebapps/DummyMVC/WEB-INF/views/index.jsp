<html>
<head>
<%@include file="./base.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   <!--JSTL tags-->
</head>
<body>
	<div class="container mt-3">

		<div class="row">

			<div class="col-md-12"></div>
			<h1 class="text-center mb-3">Welcome To Books App</h1>

			<table class="table table-dark">
				<thead>
					<tr>
						<th scope="col">Id</th>
						<th scope="col">Title</th>
						<th scope="col">Author</th>
						<th scope="col">Genre</th>
						<th scope="col">PublicationYear</th>
						<th scope="col">Isbn</th>
						<th scope="col">Action</th>

					</tr>
				</thead>
				<tbody>
					<c:forEach items="${books }" var="b">
						<tr>
							<th scope="row">${b.id }</th>
							<td>${b.title }</td>
							<td>${b.author }</td>
							<td>${b.genre }</td>
							<td>${b.publicationYear }</td>
							<td>${b.isbn }</td>
							<td>
							<a href="delete/${b.id }"><i class="fa-solid fa-trash"></i></a>
							<a href="update/${b.id }"><i class="fas fa-pen-nib"></i></a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<div class="container text-center">
				<a href="add-book" class="btn btn-outline-success"> Add Book </a>

			</div>

		</div>

	</div>
</body>
</html>
