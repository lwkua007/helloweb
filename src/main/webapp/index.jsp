<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

    <head>
        <link rel="stylesheet" type="text/css" href="static/css/login-page-style.css">
    </head>

    <body>
        <div class="login-box">
            <h2>Login</h2>

            <form action="controller?command=login" method="post">
                <div class="login-field">
                    <input type="text" name="email" required />
                    <label>Email</label>
                </div>

                <div class="login-field">
                    <input type="password" name="password" required />
                    <label >Password</label>
                </div>

                <button type="submit">log in</button>
            </form>

            <c:if test="${error_message != null}">
                <div class="login-error">
                    ${error_message}
                </div>
            </c:if>

            <form action="controller?command=sign up" method="post">
                <button type="submit">sign up test3</button>
            </form>
        </div>

    </body>

</html>