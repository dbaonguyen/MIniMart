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
<title>Thông tin hàng hóa</title>
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
	background-color: #4caf50;
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
	<h1>Thông tin chi tiết nhân viên</h1>
	<table border="1">
		<tr>
			<th>ID</th>
			<td>${hh.id}</td>
		</tr>
		<tr>
			<th>Tên hàng hóa</th>
			<td>${hh.tenhanghoa}</td>
		</tr>
		<tr>
			<th>Chủng loại</th>
			<td>${hh.chungLoai.ten}</td>
		</tr>
		<tr>
			<th>Đơn vị tính</th>
			<td>${hh.donViTinh.tendonvi}</td>
		</tr>
		<tr>
			<th>Nhà cung cấp</th>
			<td>${hh.nhaCungCap.tennhacc}</td>
		</tr>
		<tr>
			<th>Số lượng</th>
			<td>${hh.soluong}</td>
		</tr>
		<tr>
			<th>Ngày tạo</th>
			<td><fmt:formatDate value="${hh.ngaytao}" dateStyle="MEDIUM" /></td>
		</tr>
		<tr>
			<th>Ngày cập nhật</th>
			<td><fmt:formatDate value="${hh.ngaycapnhat}" dateStyle="MEDIUM" /></td>
		</tr>
		<tr>
			<th>Ghi chú</th>
			<td>${hh.ghichu}</td>
		</tr>
	</table>
	<a href="${rootPath}hanghoa">Trang chủ</a>
</body>
</html>