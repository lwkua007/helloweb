<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

    <head>
        <link rel="stylesheet" type="text/css" href="static/css/login-page.css">
    </head>

    <body>
        <div class="login-box">
            <h2>Sign Up</h2>

            <form action="controller?command=signUp" method="post">
                <div class="login-field">
                    <input type="text" name="email" required />
                    <label>Email</label>
                </div>

                <div class="login-field">
                    <input type="password" name="password" required />
                    <label >Password</label>
                </div>

                <button type="submit">sign up</button>
            </form>
        </div>

    </body>

</html>