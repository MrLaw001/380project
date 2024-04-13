<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
  <title>Customer Support</title>
</head>
<body>
<c:url var="logoutUrl" value="/logout"/>
<form action="${logoutUrl}" method="post">
  <input type="submit" value="Log out" />
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
<h2>Edit User Info </h2>
<form:form method="POST" enctype="multipart/form-data"
           modelAttribute="appUser">
  <form:label path="username">Username</form:label><br/>
  <form:input type="text" path="username"/><br/><br/>

  <form:label path="password">Password</form:label><br/>
  <form:input type="text" path="password"/><br/><br/>

  <form:label path="confirmpassword">Confirm Password</form:label><br/>
  <form:input type="text" path="confirmpassword" /><br/><br/>

  <form:label path="fullname">Fullname</form:label><br/>
  <form:input type="text" path="fullname"/><br/><br/>

  <form:label path="email">EmailAddress</form:label><br/>
  <form:input type="text" path="email"/><br/><br/>

  <form:label path="delivery">DeliveryAddress</form:label><br/>
  <form:input type="text" path="delivery"/><br/><br/>
<%--  <b>Add more attachments</b><br />--%>
<%--  <input type="file" name="attachments" multiple="multiple"/><br/><br/>--%>
  <input type="submit" value="Save"/><br/><br/>
</form:form>
<a href="<c:url value="/ticket" />">Return to book list</a>
</body>
</html>

