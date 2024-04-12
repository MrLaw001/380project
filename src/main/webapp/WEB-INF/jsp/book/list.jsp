<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product List</title>
</head>
<body>
<h1>Product List</h1>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
    </tr>
    <c:forEach items="${products}" var="product">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>
                <a href="/products/edit/${product.id}">Edit</a>
                <a href="/products/delete/${product.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="/products/add">Add Product</a>
</body>
</html>