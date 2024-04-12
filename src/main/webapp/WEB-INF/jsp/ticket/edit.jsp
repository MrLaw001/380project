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
<h2>Edit Book #${ticket.id}</h2>
<form:form method="POST" enctype="multipart/form-data"
           modelAttribute="ticketForm">
  <form:label path="subject">Book Name</form:label><br/>
  <form:input type="text" path="subject" /><br/><br/>
  <form:label path="body">Description</form:label><br/>
  <form:textarea path="body" rows="5" cols="30" /><br/><br/>
  <b>Add more attachments</b><br />
  <input type="file" name="attachments" multiple="multiple"/><br/><br/>
  <input type="submit" value="Save"/><br/><br/>
</form:form>
<a href="<c:url value="/ticket" />">Return to book list</a>
</body>
</html>

