<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

</head>
<body>

	<a href="post_question">Ask Question</a>

	<div>

		<table border="2">
			<tr>
				<td>Question id</td>
				<td>Question Content</td>
				<td>Question Subject</td>
			</tr>
			<c:forEach var="que" items="${Que}">
				<tr>
					<td>${que.id}</td>
					<td>${que.question}</td>
					<td>${que.subject}</td>

					<td>
						<ul>
							<c:if test="${not empty que.ans}">
								<c:forEach var="ans" items="${que.ans}">
									<li>${ans.answer}</li>
								</c:forEach>
							</c:if>
						</ul>
					</td>

					<td><a href="post_answer?id=${que.id}">Post Answer</a>/ <a
						href="delete/${que.id}">Delete</a></td>
				</tr>
			</c:forEach>
</body>
</html>