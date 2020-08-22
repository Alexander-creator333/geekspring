<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
<body>
<form:form action="addProduct" modelAttribute="product">
    <h2>
        Title: <form:input path="title"/>
        </p>
        Cost: <form:input path="cost"/>
        </p>
        <input type="submit" value="Submit"/></h2>
</form:form>
</body>
</html>