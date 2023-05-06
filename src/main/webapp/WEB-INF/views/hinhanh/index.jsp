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
	<sf:form action="${rootPath}hinhanh/insert" method="post"
		modelAttribute="ha" enctype="multipart/form-data">
		<h5>Sản phẩm</h5>
		<sf:select path="hangHoa.id">
			<sf:options items="${lsthh}" itemLabel="tenhanghoa" itemValue="id" />
		</sf:select>
		<h5>Ghi chú</h5>
		<sf:input path="ghichu" type="text" />
		<h5>STT</h5>
		<sf:input path="stt" type="number" />
		<h5>Trạng thái</h5>
		<sf:radiobutton path="trangthai" label="Unlocked" value="1" />
		<sf:radiobutton path="trangthai" label="Locked" value="0" />
		<h5>Ảnh sản phẩm</h5>
		<sf:input type="file" path="anhsanpham" />
		<sf:errors path="anhsanpham" cssClass="box-error" />
		<input type="submit" value="Đăng ký hình ảnh">



	</sf:form>
	<a href="${rootPath}">Trang chủ </a>
</body>
</html>