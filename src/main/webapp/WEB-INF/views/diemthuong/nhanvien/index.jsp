<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<s:url value="/" var="rootPath"></s:url>
<s:url value="/" var="rootpath"></s:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="${rootPath}public/font/fontawesome-free-6.4.0-web/css/all.min.css">
<title>Điểm thưởng khách hàng</title>
<style>
th {
	background-color: #fdba38;
	color: white;
}

a.button {
	display: inline-block;
	padding: 10px 20px;
	background-color: #0771B8;
	margin: 10px;
	color: #fff;
	text-decoration: none;
	border-radius: 5px;
	border: none;
	box-shadow: 2px 2px 4px rgba(0, 0, 0, 0.4);
	transition: background-color 0.3s ease-in-out;
}
body {
	background-color: #f2f2f2;
	font-family: Arial,Helvetica, sans-serif;
	color: #444;
}
input[type="text"] {
	padding: 5px;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
	font-size: 16px;
	margin-right: 10px;
}

button[type="submit"] {
	background-color: #4CAF50;
	color: white;
	padding: 5px 10px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	font-size: 16px;
	border-radius: 5px;
	border: none;
	box-shadow: 2px 2px 4px rgba(0, 0, 0, 0.4);
	transition: background-color 0.3s ease-in-out;
}

.search_container {
	margin-bottom: 20px;
}

button[type="submit"]:hover {
	background-color: #388E3C;
}
#trang-chu-link {
  position: fixed;
 left: 0;
  bottom: 0;

}

.dropdown:hover {
	display: inline-block;
}

.dropdown-content {
	display: none;
	position: absolute;
	background-color: #f9f9f9;
	min-width: 160px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}


.dropdown-content a:hover {
	background-color: #ddd;
}

img {
	width: 5.5rem;
}

.custom-bg {
	background-color: #fdba38;
}

.p-0 {
	padding: 0;
}

.dropdown:hover .dropdown-content {
	display: block;
}

.dropdown-item {
	float: none;
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
	text-align: left;
	cursor: pointer;
}
.link-color {
	color: white;
}
</style>
</head>
<body>
<nav
		class="nav-bar custom-bg navbar-expand-lg d-flex navbar-custom p-2 justify-content-between">
		<div class="d-flex align-items-center">
			<a class="navbar-brand ml-3 text-white" href="${rootPath}/home/nhanvien">
				<img src="${rootPath}/public/image/Artboard+1.png" alt="">
			</a>
		</div>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"><i class="fa-solid fa-bars"></i></span>
		</button>
		<div class="collapse navbar-collapse justify-content-center"
			id="navbarNavDropdown">
			<ul class="navbar-nav">
				<li class="nav-item dropdown mr-5"><a
					class="nav-link link-color font-weight-bold"
					href="${rootPath}khachhang/nhanvien"> <s:message
							code="label.customer.manage"></s:message></a>
					<div class="dropdown-content">
						<a class="dropdown-item" href="${rootPath}khachhang/nhanvien"> <s:message
								code="label.customer.info"></s:message></a> <a class="dropdown-item"
							href="${rootPath}khachhang/nhanvien/initInsert"><s:message
								code="label.customer.add"></s:message></a> <a class="dropdown-item"
							href="${rootPath}diemthuong/nhanvien"><s:message
								code="label.customer.bonus"></s:message></a>
					</div></li>
				<li class="nav-item dropdown mr-5"><a
					class="nav-link link-color font-weight-bold"
					href="${rootPath}hanghoa/nhanvien"> <s:message
							code="label.product.manage"></s:message>
				</a>
					<div class="dropdown-content">
						<a class="dropdown-item" href="${rootPath}hanghoa/nhanvien"><s:message
								code="label.product.info"></s:message></a> <a class="dropdown-item"
							href="${rootPath}hanghoa/nhanvien/initInsert"><s:message
								code="label.product.add"></s:message></a>
					</div></li>
				<li class="nav-item dropdown mr-5"><a
					class="nav-link link-color font-weight-bold"
					href="${rootPath}hoadon/nhanvien"> <s:message code="label.bill.manage"></s:message></a></li>
			</ul>

			<ul class="navbar-nav">
				<li class="nav-item dropdown mr-5 dropright"><a
					class="nav-link link-color font-weight-bold" href=""><i class="fa-solid fa-user fa-xs"></i> ${loggedInUsername}</a>
					<div class="dropdown-content">
						<a class="dropdown-item"
							href="${rootPath}nhanvien/accountdetail?idnv=${loggedInId}"><s:message
								code="label.employee.account"></s:message></a> <a
							class="dropdown-item" href="${rootPath}"><s:message
								code="label.logout"></s:message></a>
					</div></li>
			</ul>
		</div>

	</nav>
	<br>
	<h1><s:message code="label.customer.bonus"></s:message></h1>
	<%-- <nav class="navbar navbar-expand-sm">
		<form class="form-inline"
			action="${rootPath}/diemthuong/nhanvien/search" method="GET">
			<input class="form-control mr-sm-2" type="text"
				placeholder="Tên khách hàng" name="ten">
			<button class="button" type="submit">Tìm kiếm</button>
		</form>
	</nav> --%>
	<form action="${rootPath}/diemthuong/nhanvien/search" method="get">
		<div class="search_container">
			<input type="text" maxlength="50" name="search"
				placeholder="Tên khách hàng" />
			<button type="submit" style="margin-right: 3px">Tìm kiếm</button>
		</div>
	</form>
	
	<table class="table table-bordered table-hover">
		<tr>
			<th><s:message code="label.firstname"></s:message></th>
			<th><s:message code="label.lastname"></s:message></th>
			<th><s:message code="label.total"></s:message></th>
		</tr>
		<c:forEach items="${lst}" var="item">
			<tr>
				<td>${item[0]}</td>
				<td>${item[1]}</td>
				<td>${item[2]}</td>
			</tr>
		</c:forEach>
	</table>
	<div class="d-flex justify-content-end">
		<a href="${rootPath}/home/nhanvien" class="button" id="trang-chu-link"><i class="fa-solid fa-house fa-xl"></i></a>
	</div>
</body>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
</html>