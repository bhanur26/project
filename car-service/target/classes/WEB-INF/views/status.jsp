<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ include file = "header.html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table class="">
<tr>

<th width="80" align="center">Request ID</th>
<th width="80"  align="center">SERVICE ID</th>


<th width="100"  align="center">status</th>

<th></th>

</tr>
<c:forEach items="${ser1List}" var="ser">
<tr>
<td width="80" align="center">${ser.requestId } </td>
<td width="80" align="center">${ser.serviceId } </td>
<td width="80" align="center">${ser.status}</td>



</tr>
</c:forEach>
</table>
</body>
</html>