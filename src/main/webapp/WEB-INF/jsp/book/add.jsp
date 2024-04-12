<!DOCTYPE html>
<html>
<head><title>Customer Support</title></head>
<body>
<c:url var="logoutUrl" value="/logout"/>
<form action="${logoutUrl}" method="post">
    <input type="submit" value="Logout" />
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
<h2>Create a Ticket</h2>
<form:form method="POST" enctype="multipart/form-data" modelAttribute="bookForm">
    <b>Image</b><br/>
    <input type="file" name="image" accept="image/*"/><br/><br/>
    <input type="submit" value="Submit"/>
</form:form>
</body>
</html>
