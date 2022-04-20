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

        <form action="controller?command=addUser" method="post">
            <div class="login-field">
                <input type="text" name="isAdmin" required />
                <label>Is admin</label>
            </div>

            <div class="login-field">
                <input type="text" name="email" required />
                <label>Email</label>
            </div>

            <div class="login-field">
                <input type="password" name="password" required />
                <label >Password</label>
            </div>

            <div class="login-field">
                <input type="text" name="state" required />
                <label>State</label>
            </div>

            <div class="login-field">
                <input type="text" name="balance" required />
                <label>Balance</label>
            </div>

            <button type="submit">Add</button>
        </form>

    </body>
</html>