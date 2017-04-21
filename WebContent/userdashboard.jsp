<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"></meta>
<title>dashboard</title>
<link rel="stylesheet" href="style.css"></link>
</head>
<c:if test="${member == null}">
<jsp:include page="index.jsp"/>
</c:if>
<c:if test="${member != null}">
<body>
<div>
<table cellspacing="20px">
<tr style=" outline: 0;
  background-color: white;
  border: 0;
  align:center;
  padding: 10px 15px;
  margin-left:0%;
  margin-right:0%;
  color: #53e3a6;
  border-radius: 3px;
  cursor: pointer;
  font-size: 18px; ">
<th>
<a href="testpage.jsp">Take A Test</a>
</th>
<th>
<a href="resultpage.jsp">View your Results</a>
</th>
<th>
About Us
</th>
<th>
Contact Us
</th></tr>
</table>
</div>

</body>
</c:if>
</html>