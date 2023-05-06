<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/" var="rootPath"></c:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cập nhật thông tin khách hàng</title>
</head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="${rootPath}public/font/fontawesome-free-6.4.0-web/css/all.min.css">
<style type="text/css">
.box-error {
	color: red;
}

.box-ok {
	color: blue;
}

body {
	background-color: #f2f2f2;
	font-family: Arial, sans-serif;
	color: #444;
}

table {
	border-collapse: collapse;
	width: 100%;
	max-width: 600px;
	margin: auto;
	font-size: 1.2em;
	text-align: center;
}

th {
	background-color: #fdba38;
	border: 1px solid #ddd;
	padding: 10px;
	text-align: left;
	color: #FFF;
}

td {
	border: 1px solid #ddd;
	padding: 10px;
}

input[type="text"], input[type="date"], input[type="number"], input[type="email"]
	{
	width: 100%;
	padding: 10px;
	margin-bottom: 10px;
	border: 1px solid #ddd;
	border-radius: 5px;
}

input[type="submit"] {
	display: block;
	width: 100%;
	max-width: 300px;
	margin: auto;
	padding: 10px;
	background-color: #4CAF50;
	color: white;
	font-size: 1.2em;
	font-weight: bold;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	align-items: center;
	margin-top: 20px;
}

input[type="submit"]:hover {
	background-color: #388E3C;
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

tr:nth-child(9) {
	background-color: #f2f2f2;
}

td:nth-child(2) {
	display: flex;
	justify-content: space-between;
}

label {
	display: inline-block;
	background-color: #e6e6e6;
	color: #444;
	padding: 10px;
	border-radius: 5px;
	cursor: pointer;
}

input[type="radio"] {
	display: none;
}

input[type="radio"]:checked+label {
	background-color: #008CBA;
	color: white;
}

.checkbox-label {
	display: inline-block;
	margin-right: 10px;
	margin-bottom: 5px;
	font-weight: normal;
	vertical-align: middle;
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
			<a class="navbar-brand ml-3 text-white"
				href="${rootPath}/home/nhanvien"> <img
				src="${rootPath}/public/image/Artboard+1.png" alt="">
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
						<a class="dropdown-item" href="${rootPath}khachhang/nhanvien">
							<s:message code="label.customer.info"></s:message>
						</a> <a class="dropdown-item"
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
						<a class="dropdown-item" href="${rootPath}hanghoa"><s:message
								code="label.product.info"></s:message></a> <a class="dropdown-item"
							href="${rootPath}hanghoa/nhanvien/initInsert"><s:message
								code="label.product.add"></s:message></a>
					</div></li>
				<li class="nav-item dropdown mr-5"><a
					class="nav-link link-color font-weight-bold"
					href="${rootPath}hoadon/nhanvien"> <s:message
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
	<h1>Cập nhật thông tin khách hàng</h1>
	<span class="box-ok">${msg}</span>
	<span class="box-error">${msgErr}</span>
	<sf:form action="${rootPath}khachhang/nhanvien/update" method="post"
		modelAttribute="kh">
		<table border="1" class="table table-bordered table-hover">
			<tr>
				<th>Mã khách hàng</th>
				<td><sf:input type="number" path="id" readonly="true" /></td>
			</tr>
			<tr>
				<th>Họ</th>
				<td><sf:input type="text" path="ho" /></td>
				<td><sf:errors path="ho" cssClass="box-error" /></td>
			</tr>
			<tr>
				<th>Tên</th>
				<td><sf:input type="text" path="ten" /></td>
				<td><sf:errors path="ten" cssClass="box-error"></sf:errors></td>
			</tr>
			<tr>
				<th>Giới tính</th>
				<td><sf:radiobutton path="gioi_tinh" name="gioi_tinh"
						label="Male" value="1" /> <sf:radiobutton path="gioi_tinh"
						name="gioi_tinh" label="Female" value="0" /></td>
				<td><sf:errors path="gioi_tinh" cssClass="box-error"></sf:errors></td>
			</tr>
			<tr>
				<th>Ngày sinh</th>
				<td><sf:input type="date" path="ngay_sinh" /></td>
			</tr>
			<tr>
				<th>Điện thoại</th>
				<td><sf:input type="text" path="dien_thoai" /></td>
				<td><sf:errors path="dien_thoai" cssClass="box-error"></sf:errors></td>
			</tr>
			<tr>
				<th>Địa chỉ</th>
				<td><sf:input type="text" path="dia_chi" /></td>
				<td><sf:errors path="dia_chi" cssClass="box-error" /></td>
			</tr>
			<tr>
				<th>Email</th>
				<td><sf:input type="text" path="email" /></td>
				<td><sf:errors path="email" cssClass="box-error" /></td>
			</tr>
			<tr>
				<th>Ngày tạo</th>
				<td><sf:input type="date" path="ngay_tao" /></td>
			</tr>
			<tr>
				<th>Ngày cập nhật</th>
				<td><sf:input type="date" path="ngay_cap_nhat" /></td>
			</tr>
			<tr>
				<th>Trạng thái</th>
				<td><sf:radiobutton path="trang_thai" label="Active" value="1"
						name="trang_thai" /> <sf:radiobutton path="trang_thai"
						label="Non-Active" value="0" name="trang_thai" /></td>
				<td><sf:errors path="trang_thai" cssClass="box-error" /></td>
			</tr>
		</table>
		<input type="submit" value="Cập nhật thông tin khách hàng">
	</sf:form>
	<br>
	<a href="${rootPath}khachhang/nhanvien" class="button"><i class="fa-solid fa-house fa-xl"></i></a>
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