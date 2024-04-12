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
<h2>Register</h2>
<form:form method="POST" modelAttribute="appUser">
  <form:label path="username">Username</form:label><br/>
  <form:errors path="username" cssClass="error" />
  <form:input type="text" path="username"/><br/><br/>
  <form:label path="password">Password</form:label><br/>
  <form:errors path="password" cssClass="error" />
  <form:input type="text" path="password"/><br/><br/>
  <form:label path="confirmpassword">Confirm Password</form:label><br/>
  <form:errors path="confirmpassword" cssClass="error" />
  <form:input type="text" path="confirmpassword" /><br/><br/>

  <form:label path="fullname">Fullname</form:label><br/>
  <form:errors path="fullname" cssClass="error" />
  <form:input type="text" path="fullname"/><br/><br/>

  <form:label path="email">EmailAddress</form:label><br/>
  <form:errors path="email" cssClass="error" />
  <form:input type="text" path="email"/><br/><br/>

  <form:label path="delivery">DeliveryAddress</form:label><br/>
  <form:errors path="delivery" cssClass="error" />
  <form:input type="text" path="delivery"/><br/><br/>
  <br/><br/>
  <input type="submit" value="Add User"/>
</form:form>
</body>
</html>