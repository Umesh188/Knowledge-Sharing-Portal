<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<form action="posted_answer" method="post" >
<textarea type="text" name="answer" ></textarea>
<input type="hidden" name="questionid" value=${questionid} />
<input type="submit" name="submit" value="POST">

</form>


</body>
</html>