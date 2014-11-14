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
		<table>
			<tr>
				<td>Accountname:</td><td>${account.name}</td>
			</tr>
			<tr>
				<td>E-Mail:</td><td>${account.mail}</td>
			</tr>
			<tr>
				<td>&nbsp;</td><td><a href="<c:url value="/account/?edit"/>"><button>Ändern</button></a></td>
			</tr>
		</table>
	</body>
</html>