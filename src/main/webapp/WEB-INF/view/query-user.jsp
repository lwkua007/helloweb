<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="static/css/main-page.css">
        <script type="text/javascript" src="static/js/page-break.js"></script>
    </head>

    <body onload="goPage(1,8);">
        <div class="title-box">
            <h1>Welcome!Admin.</h1>
        </div>

        <div class="name-search-Box">
            <form action="controller?command=userFuzzyQuery" method="post">
                <input type="text" name="name"/>
                <button type="submit"><img src="static/icons/read.svg"></button>
            </form>
        </div>

        <div>
            <jsp:include page="/WEB-INF/fragments/menu.jsp" />
        </div>

        <div class="user-title-box">
            <jsp:include page="/WEB-INF/fragments/user-sheet-title.jsp" />
        </div>

        <div class="query-box">
            <table id="search-result">
                <c:forEach items="${users}" var="users">
                    <tr>
                        <td><c:if test="${users.isAdmin==1}">admin</c:if>
                            <c:if test="${users.isAdmin==0}">user</c:if>
                        </td>
                        <td>${users.email}</td>
                        <td class="password-col">${users.password}</td>
                        <td>${users.state}</td>
                        <td>${users.balance}</td>
                        <td>${users.image_count}</td>
                        <td><a href="controller?command=updateUserInfoPage&userId=${users.userId}"><button type="button">update</button></a></td>
                        <td><a href="controller?command=deleteUser&userId=${users.userId}"><button type="button">delete</button></a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>

        <div id="flip-button"></div>
    </body>
</html>