<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:url value="/" var="rootPath"></c:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="${rootPath}public/css/style.css">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="${rootPath}public/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${rootPath}public/font/fontawesome-free-6.4.0-web/css/all.min.css">
<meta charset="UTF-8">
<title>Minimart</title>
</head>
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
					href="${rootPath}hoadon/admin"> <s:message code="label.bill.manage"></s:message></a></li>
			</ul>

			<ul class="navbar-nav">
				<li class="nav-item dropdown mr-5 dropright"><a
					class="nav-link link-color font-weight-bold" href=""><i class="fa-solid fa-user fa-xs"></i> ${loggedInUsername}</a>
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


	<div class="alert alert-primary alert-dismissible fade show"
		role="alert" id="alert">
		Welcome <strong>${loggedInUser}!</strong>
		<button type="button" class="close" data-dismiss="alert"
			aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
	</div>


	<div class="container mt-5">
		<h1 class="text-center">
			<s:message code="overview"></s:message>
		</h1>
		<br>
		<div class="row">
			<div class="col-md-4 col-12">
				<div class="card border-dark mt-3">
					<div class="card-header text-white"
						style="background-color: #fdba38;">
						<h5 class="font-weight-bold text-center">
							<s:message code="label.product.name"></s:message>
						</h5>
					</div>
					<div class="card-body">
						<p class="card-text">
							<b><s:message code="label.categories.count"></s:message></b> <b
								style="color: red;">${sodanhmuc}</b>
						</p>

						<p class="card-text">
							<b> <s:message code="label.product.count"></s:message></b> <b
								style="color: red;">${sohanghoa}</b>
						</p>
						<p class="card-text">
							<b> <s:message code="label.product.hot"></s:message></b> <b
								style="color: red;">${spbc}</b>
						</p>
						<p class="card-text">
							<b> <s:message code="label.product.addmore"></s:message></b> <b
								style="color: red;">${nullmsg}</b>
							<c:forEach items="${sanphamcannhap}" var="hh">
								<ul
									class="list-group list-group-light list-group-small list-group-numbered">
									<li
										class="list-group-item rounded-3 px-3 list-group-item-action border-0 mb-2"
										style="list-style: none;"><b style="color: red;">${hh}</b></li>
								</ul>
							</c:forEach>
						</p>
					</div>
				</div>
			</div>
			<div class="col-md-4 col-12">
				<div class="card border-dark mt-3">
					<div class="card-header text-white"
						style="background-color: #fdba38">
						<h5 class="font-weight-bold text-center">
							<s:message code="label.employee.name"></s:message>
						</h5>
					</div>
					<div class="card-body">
						<p class="card-text">
							<b> <s:message code="label.employee.count"></s:message>
							</b><b style="color: red;">${sonhanvien}</b>
						</p>
						<p class="card-text">
							<b> <s:message code="label.employee.active"></s:message>
							</b><b style="color: red;">${nvtc}</b>
						</p>
					</div>
				</div>
			</div>
			<div class="col-md-4 col-12">
				<div class="card border-dark mt-3">
					<div class="card-header text-white"
						style="background-color: #fdba38">
						<h5 class="font-weight-bold text-center">
							<s:message code="label.producer.name"></s:message>
						</h5>
					</div>
					<div class="card-body">
						<p class="card-text">
							<b> <s:message code="label.producer.count"></s:message></b> <b
								style="color: red;">${sonhacc}</b>
						</p>
						<p class="card-text">
							<b> <s:message code="label.producer.bestselling"></s:message>
							</b> <b style="color: red;">${nccbanchay}</b>
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="btn-group dropup fixed-bottom justify-content-end">
  <button type="button" class="btn custom-bg dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    <i class="fa-solid fa-language fa-xl link-color"></i>
  </button>
  <div class="dropdown-menu">
   <a class="dropdown-item" href="?lang=en_US">English</a> <a
					class="dropdown-item" href="?lang=vi_VN">Tiếng việt</a>
  </div>
</div>

</body>
<script src="${rootPath}public/js/jquery-3.6.4.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<script src="${rootPath}public/js/bootstrap.min.js"></script>
<script>
	$(document).ready(function() {
		$('#alert').alert();
	});
</script>

</html>
