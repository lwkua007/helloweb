<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
    <body>

        <div class="menu-box">
            <jsp:include page="/WEB-INF/fragments/menu.jsp" />
        </div>

        <div>
            <jsp:include page="/WEB-INF/fragments/manage-menu.jsp" />
        </div>

        <table>
            <thead>
            <tr>

                <th scope="col">is_admin</th>
                <th scope="col">email</th>
                <th scope="col">password</th>
                <th scope="col">state</th>
                <th scope="col">balance</th>
                <th scope="col">image_count</th>
                <th scope="col">update</th>
                <th scope="col">delete</th>


            </tr>
            <c:forEach items="${users}" var="users">
                <tr>

                    <td>${users.isAdmin}</td>
                    <td>${users.email}</td>
                    <td>${users.password}</td>
                    <td>${users.state}</td>
                    <td>${users.balance}</td>
                    <td>${users.image_count}</td>
                    <td><a href="controller?command=updateUserInfo"><button type="button">update</button></a></td>
                    <td><a href="controller?command=deleteUser&userId=${users.userId}"><button type="button">delete</button></a></td>
                </tr>
            </c:forEach>
            </thead>
        </table>


    </body>
</html>