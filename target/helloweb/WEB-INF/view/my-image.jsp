<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="static/css/main-page.css">
        <script type="text/javascript" src="static/js/page-break.js"></script>
    </head>

    <body onload="goPage(1,4);">
        <div class="title-box">
            <h1>Your image information.</h1>
        </div>

        <div class="menu-box">
            <jsp:include page="/WEB-INF/fragments/menu.jsp" />
        </div>

        <div class="search-page-box">
            <table id="search-result">
                <c:forEach items="${images}" var="images">
                    <tr>
                        <div class="image-frame">
                            <td>
                                <div class="image-preview">
                                    <img src="${images.location}" data-holder-rendered="true">
                                </div>
                            </td>
                            <td>
                                <div class="image-information">
                                    <div class="my-image-rate">rate:${images.rating}</div>
                                    <div class="price">price:${images.price}$</div>
                                    <div class="name">name:${images.name}</div>
                                    <div class="category">category:${images.category}</div>

                                    <div class="download">
                                        <a href="${images.location}" download="${images.location}"><button type="button">download</button></a>
                                    </div>

                                    <div class="delete">
                                        <a href="controller?command=deleteMyImage&imageId=${images.imageId}&userId=${user.userId}">
                                            <button type="button">delete</button>
                                        </a>
                                    </div>
                                </div>
                            </td>
                        </div>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div id="flip-button"></div>
    </body>
</html>