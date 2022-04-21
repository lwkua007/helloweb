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

        <div>
            <jsp:include page="/WEB-INF/fragments/manage-menu.jsp" />
        </div>

        <form action="controller?command=addUser" method="post">
            <div class="login-field">
                <label>Is admin</label>
                <input type="hidden" name="isAdmin" value="0"/>
                <input type="checkbox" name="isAdmin" value="1"/>
            </div>

            <div class="login-field">
                <label>Email</label>
                <input type="text" name="email" required />
            </div>

            <div class="login-field">
                <label >Password</label>
                <input type="password" name="password" required />
            </div>

            <div class="login-field">
                <label>State</label>
                <input type="text" name="state" required />
            </div>

            <div class="login-field">
                <label>Balance:$</label>
                <input type="text" name="balance" required />
            </div>

            <button type="submit">Add</button>
            <c:if test="${addStateMessage != null}">
                ${addStateMessage}
            </c:if>
        </form>

    </body>
</html>