<!DOCTYPE html>
<html>
<head><title>Customer Support</title></head>
<body>
<form action="${logoutUrl}" method="post">
    <input type="submit" value="Logout" />
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
<h2>Book #${bookId}: </h2>
<img src="<c:url value="/book/image/${bookId}" />" />
<a href="<c:url value="/ticket" />">Return to list tickets</a>
</body>
</html>
