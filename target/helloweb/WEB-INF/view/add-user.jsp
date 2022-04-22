<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
    <head>
        <link rel="stylesheet" type="text/css" href="static/css/main-page.css">
    </head>
    <body>
        <div class="title-box">
            <h1>Welcome!Admin.</h1>
        </div>

        <div>
            <jsp:include page="/WEB-INF/fragments/menu.jsp" />
        </div>

        <form action="controller?command=addUser" method="post"  class="upload-box">
            <div>
                <label>Is admin:</label>
                <input type="checkbox" name="isAdmin" value="1"/>
                <input type="hidden" name="isAdmin" value="0"/>
            </div>

            <div>
                <label>Email:</label>
                <input type="text" name="email" required />
            </div>

            <div>
                <label >Password:</label>
                <input type="password" name="password" required />
            </div>

            <div>
                <label>State:</label>
                <input type="text" name="state" required />
            </div>

            <div>
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