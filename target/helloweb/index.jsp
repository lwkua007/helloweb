<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

    <head>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>

    <body>
        <div class="login-box">
            <h2>Login</h2>

            <form action="controller?command=login" method="post">
                <div class="login-field">
                    <input type="text" name="name" required />
                    <label>Username</label>
                </div>

                <div class="login-field">
                    <input type="password" name="password" required />
                    <label >Password</label>
                </div>

                <button type="submit">Submit</button>
            </form>

            <c:if test="${error_message != null}">
                <div class="login-error">
                    ${error_message}
                </div>
            </c:if>

        </div>

    </body>

</html>