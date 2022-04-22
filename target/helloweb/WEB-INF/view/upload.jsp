<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

    <head>
        <link rel="stylesheet" type="text/css" href="static/css/main-page.css">
    </head>

    <body>
        <div class="title-box">
            <h1>Add images</h1>
        </div>

        <div>
            <jsp:include page="/WEB-INF/fragments/menu.jsp" />
        </div>

        <form action="controller?command=upload" method="post" class="upload-box">
            <div>
                <input type="file" accept="image/jpeg, image/png" />
            </div>

            <p>
                name:<input type="text" name="name"><br>
                category:<input type="text" name="category"><br>
                price:$<input type="text" name="price"><br>
                    <input type="submit" name="upload">
            </p>
        </form>

    </body>

</html>