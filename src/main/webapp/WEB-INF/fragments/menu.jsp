<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" type="text/css" href="static/css/menu.css">

<hr class="hr-title"/></br>
<a href="controller?command=logout">Logout</a></br>

<a href="controller?command=searchImage">Search</a></br>

<a href="controller?command=searchMyImage&userId=${user.userId}">MyImage</a></br>

<a href="controller?command=uploadImagePage">Upload</a></br>

<c:if test="${user != null and user.isAdmin == 1}">
    <a href="controller?command=addUserPage">AddUser</a></br>

    <a href="controller?command=queryUser">QueryUser</a>
</c:if>
