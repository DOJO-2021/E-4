<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="/Qsama/css/login.css">
	<meta charset="UTF-8">
	<title>結果</title>
</head>
<body class = body>

<!-- ここからヘッダー -->
<!-- <header>
	<h1 class= "top">結果</h1>
</header> -->

<!-- ここからメイン -->
<h2><c:out value="${result.title}" /></h2>
<hr>
<p><c:out value="${result.message}" /></p>
<a href="${result.backTo}">戻る</a>

</body>
</html>