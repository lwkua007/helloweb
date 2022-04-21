<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <link rel="stylesheet" type="text/css" href="static/css/main-page.css">
    </head>
    <body>

        <div>
        <h2 class="text-box">Welcome!Admin.</h2>
        </div>

        <div class="menu-box">
            <jsp:include page="/WEB-INF/fragments/menu.jsp" />
        </div>

        <div>
            <jsp:include page="/WEB-INF/fragments/manage-menu.jsp" />
        </div>

    </body>
</html>