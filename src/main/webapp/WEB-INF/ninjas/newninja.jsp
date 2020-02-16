<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>New Ninja</h1>


	<form:form action="/ninjas/new" method="post" modelAttribute="newninja">

		<p>
			<form:select path="dojo">
				<c:forEach items="${dojos}" var="dojo">
<%-- 					<c:if test="${dojo.ninja == null}">
 --%>
						<form:option value="${dojo.id}">
							<c:out value="${dojo.name} ${dojo.id}" />
						</form:option>
<%-- 					</c:if>
 --%>				
 				</c:forEach>
			</form:select>

		</p>

		<p>
			<form:label path="firstName">First Name</form:label>
			<form:errors path="firstName" />
			<form:input path="firstName" />
		</p>
		<p>
			<form:label path="lastName">Last Name</form:label>
			<form:errors path="lastName" />
			<form:input path="lastName" />
		</p>
		<p>
			<form:label path="age">Age</form:label>
			<form:errors path="age" />
			<form:input path="age" />
		</p>

		<input type="submit" value="Create" />
	</form:form>
</body>
</html>