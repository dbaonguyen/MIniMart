<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/" var="rootPath"></c:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<style>
body {
  background-color: #f0f0f0;
}

.container {
  margin-top: 100px;
}

.card-header {
  background-color: #fdba38;
  color: white;
}

.card-body {
  background-color: #fff;
  border-radius: 10px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.form-control:focus {
  border-color: #fdba38;
  box-shadow: none;
}

.btn-primary {
  background-color: #fdba38;
  border-color: #fdba38;
}

.btn-primary:hover {
  background-color: #fdbc6c;
  border-color: #fdbc6c;
}
.error-message {
  color: red;
  font-weight: bold;
}

</style>


</head>
<body>
  <div class="container">
  <div class="row justify-content-center">
    <div class="col-md-6">
      <div class="card">
        <div class="card-header">
          <h2 class="text-center"><b>Login</b></h2>
        </div>
        <div class="card-body">
          <c:if test="${not empty error}">
            <div class="alert alert-danger">${error}</div>
          </c:if>
          <form method="post" action="${rootPath}">
            <div class="form-group">
              <label for="username">Username</label>
              <input type="text" class="form-control" name="username" placeholder="Enter username"
                value="${username}" required>
            </div>
            <div class="form-group">
              <label for="password">Password</label>
              <input type="password" class="form-control" name="password" placeholder="Password" required>
            </div>
            <button type="submit" class="btn btn-primary">Đăng nhập</button>
          </form>
        </div>
      </div>
    </div>
  </div>
</div>

</body>
</html>
