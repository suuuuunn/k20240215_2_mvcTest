<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>index.jsp 입니다.</h1>

<a href="<%=request.getContextPath()%>/HomeController?name=홍길동">눌러봐</a><br/>
<a href="./HomeController?name=임꺽정">여기두 눌러봐</a> 

<form action="<%=request.getContextPath()%>/HomeController" method="post">
	<input type="text" name="name"/>
	<input type="submit" value="이것도 눌러봐"/>
</form>

</body>
</html>