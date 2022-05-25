<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <link rel="stylesheet" type="text/css" href="static/css/login-page.css">
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

                <div class="login-error">
                    <c:if test="${error_message != null}">
                        ${error_message}
                    </c:if>
                </div>

                <div class="log-in-button">
                <button type="submit">log in</button>
                </div>
            </form>

            <form action="controller?command=signUpPage" method="post">
                <div class="sign-up-button">
                    <button type="submit">sign up</button>
                </div>
            </form>
        </div>

    </body>

</html>