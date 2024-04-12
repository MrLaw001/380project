<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head><title>Customer Support</title></head>
<body>
<c:url var="logoutUrl" value="/logout"/>
<form action="${logoutUrl}" method="post">
    <input type="submit" value="Logout" />
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
<h2>Book</h2>
<security:authorize access="hasRole('ADMIN')">
    <a href="<c:url value="/user" />">Manage User Accounts</a><br/><br/>
</security:authorize>

<a href="<c:url value="/user/edit" />">Edit User Info</a><br/><br/>

<a href="<c:url value="/ticket/create" />">Create a Book</a><br/><br/>
<c:choose>
    <c:when test="${fn:length(ticketDatabase) == 0}">
        <i>There are no books in the system.</i>
    </c:when>
    <c:otherwise>
        <c:forEach items="${ticketDatabase}" var="entry">
            Book ${entry.id}:
            <a href="<c:url value="/ticket/view/${entry.id}" />">
                <c:out value="${entry.subject}"/></a>
            (customer: <c:out value="${entry.customerName}"/>)
            <security:authorize access="hasRole('ADMIN') or
                principal.username=='${entry.customerName}'">
                [<a href="<c:url value="/ticket/edit/${entry.id}" />">Edit</a>]
            </security:authorize>
            <security:authorize access="hasRole('ADMIN')">
                [<a href="<c:url value="/ticket/delete/${entry.id}" />">Delete</a>]
            </security:authorize>
            <br/>
        </c:forEach>
    </c:otherwise>
</c:choose>
</body>
</html>