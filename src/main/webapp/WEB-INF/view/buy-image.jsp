<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false"  pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="static/css/buy-image-page.css">
    </head>

    <body>
        <div class="title-box">
            <h1>Wechat Pay.</h1>
        </div>

        <jsp:include page="/WEB-INF/fragments/menu.jsp" />

        <div class="attention-box">
            <p>Important Notes:<br>
                You will not be notified of the success of your payment,
                although we are an open source image sharing platform,
                we still appreciate your voluntary payment for the author's efforts.</p>
        </div>

        <div class="receipt-code">
            <img src="static/icons/receiptCode.jpg" width="700px" height="700px" alt="">
        </div>
    </body>
</html>