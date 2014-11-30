<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
	<body>
		<c:if test="${not empty errors}">
				<table>
			<c:forEach items="${errors}" var="error">
				<tr>
					<td>
						${error}
					</td>
				</tr>
			</c:forEach>
			</table>
		</c:if>
		<c:url  value="/signup" var="logoutUrl" />
		<form:form action="${logoutUrl}" method="post" modelAttribute="account" >
			<table>
				<tr>
					<td>Accountname:</td><td><form:input path="name"/></td>
				</tr>
				<tr>
					<td>Passwort:</td><td><form:password path="password" id="firstPassword"/></td>
				</tr>
				<tr>
					<td>Passwort wiederholen:</td><td><input type="password" id="secondPassword"/></td>
				</tr>
				<tr>
					<td>E-Mail:</td><td><form:input path="mail"/></td>
				</tr>
				<tr>
					<td>&nbsp;</td><td><button type="submit" name="save" value="speichern">Registrieren</button></td>
				</tr>
			</table>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form:form>
	</body>
</html>