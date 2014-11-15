<%@ page language="java" buffer="none" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form action="<c:url value='/login?logout'/>" method="POST" id="logoutForm">
Willkommen ${pageContext.request.userPrincipal.name}! <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> <input name="submit" type="submit" value="Logout"/>
</form>