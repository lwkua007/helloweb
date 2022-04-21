<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

<link rel="stylesheet" type="text/css" href="static/css/main-page.css">

    <body>
    <div class="text-box">
        <h2>Add images</h2>
    </div>


        <div>
            <jsp:include page="/WEB-INF/fragments/menu.jsp" />
        </div>

        <form action="controller?command=upload" method="post">
            <div>
                <input id="choose file" type="file" accept="image/jpeg, image/png" />
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