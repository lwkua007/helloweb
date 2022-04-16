<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <body>
        <h2>Image list page</h2>
        <c:forEach items="${images}" var="image">
            ${image.id} ${image.name} ${image.category}<br/>
        </c:forEach>
    </body>
</html>