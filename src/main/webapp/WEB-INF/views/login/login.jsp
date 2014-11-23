<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Login Page</title>
</head>
<body onload='document.loginForm.username.focus();'>
 
<h1>Herzlich Willkommen!</h1>
Bitte logge dich ein oder registriere dich!
<form name='loginForm' action="<c:url value='/login' />" method='POST'>
	<table>
		<tr>
			<td>
				Account:
			</td>
			<td>
				<input type='text' name='username'>
			</td>
		</tr>
		<tr>
			<td>
				Passwort
			</td>
			<td>
				<input type='password' name='password' />
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<c:if test="${not empty error}">
					<div class="error">${error}</div>
				</c:if>
				<c:if test="${not empty msg}">
					<div class="msg">${msg}</div>
				</c:if>
			</td>
		</tr>
		<tr>
			<td>
				<a href="<c:url value='/signup' />">Registrieren</a>
			</td>
			<td align="right">
				<input name="submit" type="submit" value="Login"/>
 				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			</td>
		</tr>
	</table>
</form>
</body>
</html>