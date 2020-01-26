<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<div>

		<table border="2">
			<tr>
				<td>Review Question id</td>
				<td>Question Content</td>
				<td>Question Subject</td>
			</tr>
			<c:forEach var="que" items="${reviewQuestion}">
				<tr>
					<td>${que.id}</td>
					<td>${que.question}</td>
					<td>${que.subject}</td>
					<td><a href="accept_question?id=${que.id}">Accept Question</a>/ <a
						href="delete/${que.id}">Delete</a></td>
			</tr>
			</c:forEach>
		</table>



</body>
</html>