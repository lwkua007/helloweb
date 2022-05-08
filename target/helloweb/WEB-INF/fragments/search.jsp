<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <link rel="stylesheet" type="text/css" href="static/css/main-page.css">
</head>

<table id="customers">
    <tr>
        <th scope="col">image</th>
        <th scope="col">name</th>
        <th scope="col">category</th>
        <th scope="col">rating</th>
        <th scope="col">price</th>
        <th scope="col">buy</th>
        <th scope="col">download</th>
        <c:if test="${user != null and user.isAdmin == 1}">
            <th scope="col">delete</th>
        </c:if>

    </tr>
    <c:forEach items="${images}" var="images">
        <tr>
            <td><img style="width: 200px; height: 100px;" src="${images.location}"data-holder-rendered="true"></td>
            <td>${images.name}</td>
            <td>${images.category}</td>
            <td>${images.rating}</td>
            <td>${images.price}</td>
            <td><a href="controller?command=buy&id=${images.imageId}"><button type="button">buy</button></a></td>
            <td><a href="controller?command=download&id=${images.imageId}"><button type="button">download</button></a></td>
            <c:if test="${user != null and user.isAdmin == 1}">
                <td><a href="controller?command=delete&id=${images.imageId}"><button type="button">delete</button></a></td>
            </c:if>
        </tr>
    </c:forEach>
</table>
