<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form id="beerSelectionForm" method="post" action="Redirect.do">
<center>
Select beer characterstics<p>
Color:
<select name="color" id="color" size="1">
<option value="pale">pale</option>
<option value="amber">dark</option>
<option value="amber">amber</option>
<option value="light">light</option>
</select>
</p>
<br>
<br>
<input type="submit" id="submit">
</center>
</form>

</body>
</html>