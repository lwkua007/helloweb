<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="static/css/main-page.css">
        <script type="text/javascript" src="static/js/page-break.js"></script>
    </head>

    <body onload="goPage(1,5);">
        <div class="title-box">
            <h1>Welcome!Admin.</h1>
        </div>

        <div class="likeSearchBox">
            <form action="controller?command=userFuzzyQuery" method="post">
                <input type="text" style="width: 200px" name="name"/>
                <button type="submit" style="background-color: transparent;padding: 0 0;margin: 0 0;"><img src="static/icons/read.svg" class="likeSearchButton"></button>
            </form>
        </div>

        <div class="menu-box">
            <jsp:include page="/WEB-INF/fragments/menu.jsp" />
        </div>

        <div class="user-title-box">
            <jsp:include page="/WEB-INF/fragments/user-sheet-title.jsp" />
        </div>

        <div class="query-box">
            <table id="customers">
                <thead>
                <c:forEach items="${users}" var="users">
                    <tr>
                        <td><c:if test="${users.isAdmin==1}">admin</c:if>
                            <c:if test="${users.isAdmin==0}">user</c:if>
                        </td>
                        <td style="width: 5%">${users.email}</td>
                        <td>${users.password}</td>
                        <td>${users.state}</td>
                        <td>${users.balance}</td>
                        <td>${users.image_count}</td>
                        <td><a href="controller?command=updateUserInfoPage&userId=${users.userId}"><button type="button">update</button></a></td>
                        <td><a href="controller?command=deleteUser&userId=${users.userId}"><button type="button">delete</button></a></td>
                    </tr>
                </c:forEach>
                </thead>
            </table>
        </div>

        <table style="position: absolute;bottom: 10%;left: 35%;width: 50%;">
            <tr><td><div id="flipButton"></div></td></tr>
        </table>
    </body>
</html>