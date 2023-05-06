<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<s:url value="/" var="rootPath"></s:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.box-error {
	color: red;
}

.box-ok {
	color: blue;
}
</style>
</head>
<body>
	<span class="box-ok">${msg}</span>
	<span class="box-ok">${msgS}</span>
	<span class="box-error">${msgErr}</span>
	<sf:form action="${rootPath}chungloai/insert" method="post"
		modelAttribute="cl" enctype="multipart/form-data">
		<h5>Tên chủng loại</h5>
		<sf:input path="ten" type="text" />
		<h5>Mô tả</h5>
		<sf:input path="mota" type="text" />
		<h5>Ngày tạo</h5>
		<sf:input path="ngaytao" type="date" />
		<h5>Ngày cập nhật</h5>
		<sf:input path="ngaycapnhat" type="date" />
		<h5>Trạng thái</h5>
		<sf:radiobutton path="trangthai" label="Active" value="1" />
		<sf:radiobutton path="trangthai" label="Non-Active" value="0" />
		<h5>Ảnh minh họa</h5>
		<sf:input type="file" path="anhminhhoa" />
		<sf:errors path="anhminhhoa" cssClass="box-error" />
		<input type="submit" value="Đăng ký chủng loại">



	</sf:form>
	<a href="${rootPath}">Trang chủ </a>
</body>
</html>