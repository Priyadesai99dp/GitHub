<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Customer ID</th>
					<th>Customer Name</th>
					<th>Customer Address</th>
					<th>Customer doc</th>
					<th>Customer Type</th>
					<th>Customer Balance</th>
					<th>Customer Minbal</th>
					<th>Customer Status</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${custlist }" var="c">
					<tr>
						<td>${c.id}</td>
						<td>${c.name }</td>
						<td>${c.address }</td>
						<td>${c.doc}</td>
						<td>${c.type }</td>
						<td>${c.balance }</td>
						<td>${c.minbal}</td>
						<td>${c.status }</td>
						<td><a href="update-form?id=${c.id }">edit</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>
