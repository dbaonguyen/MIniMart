<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:url value="/" var="rootpath"></c:url>
<c:url value="/" var="rootPath"></c:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lý hàng hóa</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="${rootpath}public/font/fontawesome-free-6.4.0-web/css/all.min.css">
</head>
<style>
body {
	background-color: #f2f2f2;
	font-family: Arial, sans-serif;
	color: #444;
}

a {
	text-decoration: none;
}

th {
	background-color: #fdba38;
	color: white;
}

.box-error {
	color: red;
}

.box-ok {
	color: blue;
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

button[type="submit"]:hover {
	background-color: #388E3C;
}

.search_container {
	margin-bottom: 20px;
}

a.button {
	display: inline-block;
	padding: 10px 20px;
	margin: 10px;
	background-color: #0771B8;
	color: #fff;
	text-decoration: none;
	border-radius: 5px;
	border: none;
	box-shadow: 2px 2px 4px rgba(0, 0, 0, 0.4);
	transition: background-color 0.3s ease-in-out;
}

a.button:hover {
	background-color: #025EA6;
	cursor: pointer;
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
<body>
	<nav
		class="nav-bar custom-bg navbar-expand-lg d-flex navbar-custom p-2 justify-content-between">
		<div class="d-flex align-items-center">
			<a class="navbar-brand ml-3 text-white" href="${rootPath}/home/admin">
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
					href="${rootPath}khachhang/admin"> <s:message
							code="label.customer.manage"></s:message></a>
					<div class="dropdown-content">
						<a class="dropdown-item" href="${rootPath}khachhang/admin"> <s:message
								code="label.customer.info"></s:message></a> <a class="dropdown-item"
							href="${rootPath}khachhang/admin/initInsert"><s:message
								code="label.customer.add"></s:message></a> <a class="dropdown-item"
							href="${rootPath}diemthuong/admin"><s:message
								code="label.customer.bonus"></s:message></a>
					</div></li>
				<li class="nav-item dropdown mr-5"><a
					class="nav-link link-color font-weight-bold"
					href="${rootPath}nhanvien"><s:message
							code="label.employee.manage"></s:message></a>
					<div class="dropdown-content">
						<a class="dropdown-item" href="${rootPath}nhanvien"><s:message
								code="label.employee.info"></s:message></a> <a class="dropdown-item"
							href="${rootPath}nhanvien/initInsert"><s:message
								code="label.employee.add"></s:message></a>
					</div></li>
				<li class="nav-item dropdown mr-5"><a
					class="nav-link link-color font-weight-bold"
					href="${rootPath}nhacc"> <s:message
							code="label.producer.manage">
						</s:message></a>
					<div class="dropdown-content">
						<a class="dropdown-item" href="${rootPath}nhacc"><s:message
								code="label.producer.info"></s:message></a> <a class="dropdown-item"
							href="${rootPath}nhacc/initInsert"><s:message
								code="label.producer.add"></s:message></a>
					</div></li>
				<li class="nav-item dropdown mr-5"><a
					class="nav-link link-color font-weight-bold"
					href="${rootPath}hanghoa/admin"> <s:message
							code="label.product.manage"></s:message>
				</a>
					<div class="dropdown-content">
						<a class="dropdown-item" href="${rootPath}hanghoa/admin"><s:message
								code="label.product.info"></s:message></a> <a class="dropdown-item"
							href="${rootPath}hanghoa/admin/initInsert"><s:message
								code="label.product.add"></s:message></a>
					</div></li>
				<li class="nav-item dropdown mr-5"><a
					class="nav-link link-color font-weight-bold"
					href="${rootPath}hoadon/admin"> <s:message
							code="label.bill.manage"></s:message></a></li>
			</ul>

			<ul class="navbar-nav">
				<li class="nav-item dropdown mr-5 dropright"><a
					class="nav-link link-color font-weight-bold" href=""><i
						class="fa-solid fa-user fa-xs"></i> ${loggedInUsername}</a>
					<div class="dropdown-content">
						<a class="dropdown-item"
							href="${rootPath}nhanvien/detail?idnv=${loggedInId}"><s:message
								code="label.employee.account"></s:message></a> <a
							class="dropdown-item" href="${rootPath}"><s:message
								code="label.logout"></s:message></a>
					</div></li>
			</ul>
		</div>

	</nav>
	<h1><s:message code="label.product.manage"></s:message></h1>
	<span class="box-ok">${msg}</span>
	<span class="box-error">${msgErr}</span>
	<form action="${rootpath}hanghoa/admin/search" method="get">
		<div class="d-flex">
			<div class="search_container">
			<input type="text" maxlength="50" name="search"
				placeholder="<s:message code="search.productname"></s:message>" />
			<a type="submit" style="color: white;" class="button"><i class="fa-solid fa-magnifying-glass"></i></a>
			</div>
			<div class="ml-auto">
				<a href="${rootpath}/hanghoa/admin/initInsert" class="button"><s:message code="label.addnew"></s:message></a>
			</div>
			 
		</div>
	</form>

	<div class="table-responsive-sm" style="overflow-x: auto;">
		<table border="1" class="table table-bordered table-hover table-sm">
			<tr>
				<th>ID</th>
				<th>Barcode</th>
				<th><s:message code="label.product.name"></s:message></th>
				<th><s:message code="label.suppliername"></s:message></th>
				<th><s:message code="label.product.amount"></s:message></th>
				<th><s:message code="label.importprice"></s:message></th>
				<th><s:message code="label.exportprice"></s:message></th>
				<th><s:message code="label.createdate"></s:message></th>
				<th><s:message code="label.updatedate"></s:message></th>
				<th><s:message code="label.update"></s:message></th>
				<th><s:message code="label.delete"></s:message></th>
			</tr>
			<c:forEach items="${lst}" var="hh">
				<tr>
					<td>${hh.id}</td>
					<td>${hh.barcode}</td>
					<td>${hh.tenhanghoa}</td>
					<td>${hh.nhaCungCap.tennhacc}</td>
					<td><fmt:formatNumber value="${hh.soluong}" type="number"></fmt:formatNumber></td>
					<td><fmt:formatNumber value="${hh.gianhap}" type="number"></fmt:formatNumber></td>
					<td><fmt:formatNumber value="${hh.giaxuat}" type="number"></fmt:formatNumber></td>
					<td><fmt:formatDate value="${hh.ngaytao}" dateStyle="MEDIUM" /></td>
					<td><fmt:formatDate value="${hh.ngaycapnhat}"
							dateStyle="MEDIUM" /></td>
					<td><a
						href="${rootpath}hanghoa/admin/init-update?idhh=${hh.id}"><i
							class="fa-solid fa-pen-to-square fa-lg" style="color: #2562cb;"></i></a></td>
					<td><a href="#"
						onclick="confirmDelete('${rootpath}hanghoa/admin/delete?idhh=${hh.id}')"><i
							class="fa-solid fa-trash-can fa-lg" style="color: #2562cb;"></i></a></td>
				</tr>
			</c:forEach>

		</table>

	</div>
	<br>
	<div class="d-flex justify-content-end align-items-end fixed-bottom">
		<a href="${rootpath}/home/admin" class="button"
			id="trang-chu-link"><i class="fa-solid fa-house fa-xl"></i></a>
	</div>
</body>
<script>
	function confirmDelete(url) {
		if (window.confirm("Bạn có chắc chắn muốn xóa sản phẩm này?")) {
			window.location.href = url;
		}
	}
</script>

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