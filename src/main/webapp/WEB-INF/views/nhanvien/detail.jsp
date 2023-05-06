<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:url value="/" var="rootPath"></c:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thông tin nhân viên</title>
<link rel="stylesheet" href="${rootPath}public/css/bootstrap.min.css">
</head>
<style>
body {
	background-color: #f2f2f2;
	font-family: Arial, sans-serif;
	color: #444;
}

h1 {
	margin: 20px 0;
	text-align: center;
	color: #fdba38;
	text-shadow: 1px 1px #e6e6e6;
}

.card-header {
	background-color: #fdba38;
	color: #FFFFFF;
	font-weight: bold;
}

.card-footer {
	background-color: #f9f9f9;
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
</style>
<body>
	<div class="container">
		<h1>Thông tin tài khoản</h1>
		<div class="card">
			<div class="card-header">Thông tin nhân viên</div>
			<div class="card-body">
				<div class="row">
					<div class="col-md-3 font-weight-bold">ID:</div>
					<div class="col-md-9">${nv.id}</div>
				</div>
				<div class="row">
					<div class="col-md-3 font-weight-bold"><s:message code="label.name"></s:message>:</div>
					<div class="col-md-9">${nv.hovaten}</div>
				</div>
				<div class="row">
					<div class="col-md-3 font-weight-bold"><s:message code="label.sex"></s:message>:</div>
					<div class="col-md-9">${(nv.gioitinh == 1)? "Male": "Female"}</div>
				</div>
				<div class="row">
					<div class="col-md-3 font-weight-bold"><s:message code="label.role"></s:message>:</div>
					<div class="col-md-9">${nv.phanQuyen.tenquyen}</div>
				</div>
				<div class="row">
					<div class="col-md-3 font-weight-bold"><s:message code="label.DOB"></s:message>:</div>
					<div class="col-md-9"><fmt:formatDate value="${nv.ngaysinh}" dateStyle="MEDIUM" /></div>
				</div>
				<div class="row">
					<div class="col-md-3 font-weight-bold"><s:message code="label.joindate"></s:message>:</div>
					<div class="col-md-9"><fmt:formatDate value="${nv.ngayvaolam}" dateStyle="MEDIUM" /></div>
				</div>
				<div class="row">
					<div class="col-md-3 font-weight-bold"><s:message code="label.updatedate"></s:message>:</div>
					<div class="col-md-9"><fmt:formatDate value="${nv.ngaycapnhat}" dateStyle="MEDIUM" /></div>
				</div>
				<div class="row">
					<div class="col-md-3 font-weight-bold"><s:message code="label.phonenumber"></s:message>:</div>
					<div class="col-md-9">${nv.didong}</div>
				</div>
				<div class="row">
					<div class="col-md-3 font-weight-bold"><s:message code="label.familyphone"></s:message>:</div>
					<div class="col-md-9">${nv.dtgiadinh}</div>
				</div>
				<div class="row">
					<div class="col-md-3 font-weight-bold"><s:message code="label.salary"></s:message>:</div>
					<div class="col-md-9"><fmt:formatNumber value="${nv.luongcoban}" type="number"
						maxFractionDigits="0" /></div>
				</div>
				<div class="row">
					<div class="col-md-3 font-weight-bold">Email:</div>
					<div class="col-md-9">${nv.email}</div>
				</div>
				<div class="row">
					<div class="col-md-3 font-weight-bold"><s:message code="label.address"></s:message>:</div>
					<div class="col-md-9">${nv.diachi}</div>
				</div>
				<div class="row">
					<div class="col-md-3 font-weight-bold">Username:</div>
					<div class="col-md-9">${nv.username}</div>
				</div>
				<div class="row">
					<div class="col-md-3 font-weight-bold">Password:</div>
					<div class="col-md-9">${nv.password}</div>
				</div>
				<div class="row">
					<div class="col-md-3 font-weight-bold"><s:message code="label.note"></s:message>:</div>
					<div class="col-md-9">${nv.ghichu}</div>
				</div>
				<div class="row">
					<div class="col-md-3 font-weight-bold"><s:message code="label.status"></s:message>:</div>
					<div class="col-md-9">${(nv.trangthai == 1)? "Active": "Non-active"}</div>
				</div>
			</div>
		</div>
	</div>
	<div class="fixed-bottom d-flex">
		<a href="${rootPath}/home/admin" class="button">Trang chủ</a>
		<a href="${rootPath}/nhanvien/init-update?idnv=${nv.id}" class="button">Cập nhật thông tin tài khoản</a>
	</div>
</body>
<script src="${rootPath}public/js/jquery-3.6.4.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<script src="${rootPath}public/js/bootstrap.min.js"></script>
</html>