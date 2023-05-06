<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:url value="/" var="rootPath"></c:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thông tin khách hàng</title>
</head>
<style>
body {
	background-color: #f2f2f2;
	font-family: Arial, sans-serif;
	color: #444;
}

table {
	margin: 20px auto;
	border-collapse: collapse;
	background-color: #fff;
	box-shadow: 0px 0px 8px rgba(0, 0, 0, 0.15);
}

th {
	background-color: #fdba38;
	text-align: left;
	padding: 10px;
	border-top: 1px solid #e6e6e6;
	border-bottom: 1px solid #e6e6e6;
	color: #FFFFFF;
}

td {
	padding: 10px;
	border-top: 1px solid #e6e6e6;
	border-bottom: 1px solid #e6e6e6;
}

tr:nth-child(even) td {
	background-color: #f9f9f9;
}

tr:hover td {
	background-color: #e9e9e9;
}
a {
	color: #008CBA;
	text-decoration: none;
	font-weight: bold;
}
</style>
<body>
	<h1>Thông tin chi tiết khách hàng</h1>
	<table border="1">
		<tr>
			<th>ID</th>
			<td>${kh.id}</td>
		</tr>
		<tr>
			<th>Họ</th>
			<td>${kh.ho}</td>
		</tr>
		<tr>
			<th>Tên</th>
			<td>${kh.ten}</td>
		</tr>
		<tr>
			<th>Giới tính</th>
			<td>${(kh.gioi_tinh == 1)? "Nam": "Nữ"}</td>
		</tr>
		<tr>
			<th>Ngày sinh</th>
			<td><fmt:formatDate value="${kh.ngay_sinh}" dateStyle="MEDIUM" /></td>
		</tr>
		<tr>
			<th>Điện thoại</th>
			<td>${kh.dien_thoai}</td>
		</tr>
		<tr>
			<th>Địa chỉ</th>
			<td>${kh.dia_chi}</td>
		</tr>
		<tr>
			<th>Email</th>
			<td>${kh.email}</td>
		</tr>
		<tr>
			<th>Ngày tạo</th>
			<td><fmt:formatDate value="${kh.ngay_tao}" dateStyle="MEDIUM" /></td>
		</tr>
		<tr>
			<th>Ngày cập nhật</th>
			<td><fmt:formatDate value="${kh.ngay_cap_nhat}"
					dateStyle="MEDIUM" /></td>
		</tr>
		<tr>
			<th>Trạng thái</th>
			<td>${(kh.trang_thai == 1)? "Active": "Non-Active"}</td>
		</tr>
	</table>
	<a href="${rootPath}khachhang">Trang chủ</a>
</body>
</html>