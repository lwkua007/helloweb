<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <link rel="stylesheet" type="text/css" href="static/css/main-page.css">
    <script type="text/javascript" src="static/js/page-break.js"></script>
</head>

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
                        <div class="rating">
                            <a href="controller?command=ratingImage&rating=5&imageId=${images.imageId}&userId=${user.userId}"
                               class="rating-star-link"><button class="rating-star">&#10084;</button></a>
                            <a href="controller?command=ratingImage&rating=4&imageId=${images.imageId}&userId=${user.userId}"
                               class="rating-star-link"><button class="rating-star">&#10084;</button></a>
                            <a href="controller?command=ratingImage&rating=3&imageId=${images.imageId}&userId=${user.userId}"
                               class="rating-star-link"><button class="rating-star">&#10084;</button></a>
                            <a href="controller?command=ratingImage&rating=2&imageId=${images.imageId}&userId=${user.userId}"
                               class="rating-star-link"><button class="rating-star">&#10084;</button></a>
                            <a href="controller?command=ratingImage&rating=1&imageId=${images.imageId}&userId=${user.userId}"
                               class="rating-star-link"><button class="rating-star">&#10084;</button></a>
                            <p class="rate-number">${images.rating}</p>
                        </div>

                        <div class="price">${images.price}$</div>
                        <div class="name">name:${images.name}</div>
                        <div class="category">category:${images.category}</div>

                        <div class="buy">
                            <a href="controller?command=buyImagePage"><button type="button" class="buy-button">buy</button></a>
                        </div>

                        <div class="download">
                            <a href="${images.location}" download="${images.location}"><button type="button">download</button></a>
                        </div>

                        <div class="delete">
                            <c:if test="${user != null and user.isAdmin == 1}">
                                <a href="controller?command=deleteImage&imageId=${images.imageId}">
                                    <button type="button">delete</button>
                                </a>
                            </c:if>
                        </div>
                    </div>
                </td>
            </div>
        </tr>
    </c:forEach>
</table>
