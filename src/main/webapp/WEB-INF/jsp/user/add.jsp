<!DOCTYPE html>
<html>
<head>
  <title>Customer Support</title>
  <style>
    .error {
      color: red;
      font-weight: bold;
      display: block;
    }
  </style>
</head>
<body>
<c:url var="logoutUrl" value="/logout"/>
<form action="${logoutUrl}" method="post">
  <input type="submit" value="Logout"/>
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
<h2>Create a User</h2>
<form:form method="POST" modelAttribute="appUser">
  <form:label path="username">Username</form:label><br/>
  <form:errors path="username" cssClass="error" />
  <form:input type="text" path="username"/><br/><br/>

  <form:label path="password">Password</form:label><br/>
  <form:errors path="password" cssClass="error" />
  <form:input type="text" path="password"/><br/><br/>

  <form:label path="confirm_password">Confirm Password</form:label><br/>
  <form:errors path="confirm_password" cssClass="error" />
  <form:input type="text" path="confirm_password" /><br/><br/>

  <form:label path="full_name">Fullname</form:label><br/>
  <form:errors path="full_name" cssClass="error" />
  <form:input type="text" path="full_name"/><br/><br/>

  <form:label path="email_address">Email Address</form:label><br/>
  <form:errors path="email_address" cssClass="error" />
  <form:input type="text" path="email_address"/><br/><br/>

  <form:label path="delivery_address">Delivery Address</form:label><br/>
  <form:errors path="delivery_address" cssClass="error" />
  <form:input type="text" path="delivery_address"/><br/><br/>


  <form:label path="roles">Roles</form:label><br/>
  <form:errors path="roles" cssClass="error" />
  <form:checkbox path="roles" value="ROLE_USER"/>ROLE_USER
  <form:checkbox path="roles" value="ROLE_ADMIN"/>ROLE_ADMIN
  <br/><br/>
  <input type="submit" value="Add User"/>
</form:form>
</body>
</html>