<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
<head>
    <%--    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css" />--%>
</head>

<body>
<h1>All Product</h1>

<ul>
    <c:forEach var="item" items="${products}">
        <li><h2>${item.getId()} | ${item.getTitle()} | ${item.getCost()}</h2></li>
    </c:forEach>
</ul>

</body>
</html>