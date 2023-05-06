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
<title>Quản lý hóa đơn</title>
<link rel="stylesheet"
	href="${rootpath}/public/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${rootpath}public/font/fontawesome-free-6.4.0-web/css/all.min.css">
<!-- Custom CSS -->
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
	padding: 8px;
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
	<h1><s:message code="label.bill.manage"></s:message></h1>
	<span class="box-ok">${msg}</span>
	<span class="box-error">${msgErr}</span>
	<form action="${rootpath}hoadon/nhanvien/search" method="get">
		<div class="d-flex">
			<div class="search_container">
			<input type="text" maxlength="50" name="search"
				placeholder="<s:message code="search.phonenumber"></s:message>" />
			<a type="submit" style="color: white;" class="button"><i class="fa-solid fa-magnifying-glass"></i></a>
			</div>
			 
		</div>
	</form>
	<div class="table-responsive-sm" style="overflow-x: auto;">
		<table border="1"
			class="table table-bordered table-hover table-sm table-lg">
			<tr>
				<th>ID</th>
				<th><s:message code="label.customer.name"></s:message></th>
				<th><s:message code="label.createdate"></s:message></th>
				<th><s:message code="label.phonenumber"></s:message></th>
				<th><s:message code="label.address"></s:message></th>
				<th><s:message code="label.employee.name"></s:message></th>
				<th><s:message code="label.payingmethod"></s:message></th>
				<th><s:message code="label.deliverymethod"></s:message></th>
				<th><s:message code="label.note"></s:message></th>
				<th><s:message code="label.status"></s:message></th>
				<th><s:message code="label.billdetail"></s:message></th>
				<th><s:message code="label.update"></s:message></th> 
			</tr>
			<c:forEach items="${lst}" var="hd">
				<tr>
					<td>${hd.id}</td>
					<td>${hd.khachHang.ho} ${hd.khachHang.ten}</td>
					<td><fmt:formatDate value="${hd.ngaytao}" dateStyle="MEDIUM" /></td>
					<td>${hd.sdtnhan}</td>
					<td>${hd.diachinhan}</td>
					<td>${hd.nhanVien.hovaten}</td>
					<td>${hd.thanhToan.ten}</td>
					<td>${hd.vanChuyen.ten}</td>
					<td>${hd.ghichu}</td>
					<td>${(hd.trangthai == 1)? "PAID": "UNPAID"}</td>
					<td style="text-align: center;"><a
						href="${rootpath}hoadon/nhanvien/hoadonchitiet?idhd=${hd.id}"> <i
							class="fa-solid fa-info fa-xl icon" style="color: #2562cb;"></i>
					</a></td>
					 <td style="text-align: center;"><a href="${rootpath}hoadon/nhanvien/init-update?idhd=${hd.id}"><i
							class="fa-solid fa-pen-to-square fa-xl"
							style="color: #2562cb;"></i></a></td>
				</tr>
			</c:forEach>

		</table>

	</div>
	<br>
	<div class="d-flex fixed-bottom justify-content-end">
	<a href="${rootpath}/home/nhanvien" class="button" id="trang-chu-link"><i class="fa-solid fa-house fa-xl"></i></a>
	</div>

	<!-- jQuery, Popper.js, and Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi4+NQ"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</body>
</html>