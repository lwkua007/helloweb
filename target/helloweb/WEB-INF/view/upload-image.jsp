<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false"  pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="static/css/main-page.css">
        <script type="text/javascript" src="static/js/image-preview.js"></script>
    </head>

    <body>
        <div class="title-box">
            <h1>Add images</h1>
        </div>

        <jsp:include page="/WEB-INF/fragments/menu.jsp" />

        <div class="upload-box">
            <form action="controller?command=uploadImage&userId=${user.userId}" enctype="multipart/form-data" method="post" class="upload-box">
                <div class="upload-image-box">
                    <img src="static/icons/cloud.png" alt="" id="preview-image">
                    <input type="file" accept="image/jpeg, image/png" name="location" onchange="selectImage(this);"/>
                </div>

                <p>
                    name:<input type="text" name="name"><br>
                    category:<input type="text" name="category"><br>
                    price:$<input type="text" name="price"><br>
                </p>

                <button type="submit">Upload</button>
                <c:if test="${uploadStateMessage != null}">
                    ${uploadStateMessage}
                </c:if>
            </form>
        </div>
    </body>

</html>