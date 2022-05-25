<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="static/css/main-page.css">
    </head>

    <body onload="goPage(1,4);">
        <div class="title-box">
        <h1>Share free!</h1>
        </div>

        <div class="name-search-Box">
            <form action="controller?command=imageFuzzySearch" method="post">
                <input type="text" name="name"/>
                <button type="submit"><img src="static/icons/read.svg"></button>
            </form>
        </div>

        <jsp:include page="/WEB-INF/fragments/menu.jsp" />

        <div class="search-page-box">
            <jsp:include page="/WEB-INF/fragments/search.jsp" />
        </div>

        <div id="flip-button"></div>
    </body>
</html>