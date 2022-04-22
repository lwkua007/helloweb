<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

<link rel="stylesheet" type="text/css" href="static/css/main-page.css">

    <body>
        <div class="text-box">
            <h2>Welcome!Admin.</h2>
        </div>

        <div class="menu-box">
            <jsp:include page="/WEB-INF/fragments/menu.jsp" />
        </div>

        <form action="controller?command=updateUserInfo" method="post">
            <table>
                <tr>
                    <th>is_admin</th>
                    <td><input type="text" name="isAdmin" value="${users.isAdmin}"/></td>
                </tr>

                <tr>
                    <th>email</th>
                    <td><input type="text" name="email" value="${users.email}"/></td>
                </tr>

                <tr>
                    <th>password</th>
                    <td><input type="text" name="password" value="${users.password}"/></td>
                </tr>

                <tr>
                    <th>state</th>
                    <td><input type="text" name="state" value="${users.state}"/></td>
                </tr>

                <tr>
                    <th>balance:$</th>
                    <td><input type="text" name="balance" value="${users.balance}"/></td>
                </tr>

                <tr>
                    <td><input type="hidden" name="userId" value="${users.userId}"/></td>
                </tr>

                <tr>
                    <th></th>
                    <td><button type="submit">ok</button></td>
                </tr>
            </table>
        </form>

    </body>
</html>