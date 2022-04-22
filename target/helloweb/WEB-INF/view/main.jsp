<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="static/css/main-page.css">
    </head>
    <body>
        <div class="title-box">
        <h1>Share free!</h1>
        </div>

        <jsp:include page="/WEB-INF/fragments/menu.jsp" />

        <div class="search-box">
            <jsp:include page="/WEB-INF/fragments/search.jsp" />
        </div>

    </body>
</html>