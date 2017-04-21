<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"></meta>
<title>Test Page</title>
</head>
<c:if test="${member == null}">
	<jsp:include page="index.jsp" />
</c:if>
<c:if test="${member != null}">
	<body>
		<jsp:useBean id="qs" class="com.onlineExamination.beans.QuestionSet"
			scope="session" />
			<c:set var="index" value="1" scope="session"/>
		<div style="margin-top: 40px; margin-left: 25%;">
			<form style="padding: 1px 0; position: relative; z-index: 0;">
				<table cellspacing="40px">
					<c:forEach items="${qs.allQuestions}" var="que">
						<tr>
							<td>${que.question}</td>
							<td>${que.marks}  Marks</td>
						</tr>
						<tr>
							<td><input type="radio" value="option1" name="useranswer" /></td>
							<td>${que.option1}</td>
						</tr>
						<tr>

							<td><input type="radio" value="option2" name="useranswer" /></td>
							<td>${que.option2}</td>
						</tr>
						<tr>

							<td><input type="radio" value="option3" name="useranswer" /></td>
							<td>${que.option3}</td>
						</tr>
						<tr>

							<td><input type="radio" value="option4" name="useranswer" /></td>
							<td>${que.option4}</td>
						</tr>  	
					</c:forEach>
					<tr>

						<td><input type="button" value="Next" name="NextButton"/></td>
						<td><input type="submit" value="Submit" name="action" /></td>

					</tr>
				</table>
			</form>
		</div>
	</body>
</c:if>
</html>