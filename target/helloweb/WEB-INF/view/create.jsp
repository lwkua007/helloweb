<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
    <body>
        <h2>Add images</h2>
        <div style="position: relative;">
            <input id="upload-input" style="position: absolute; top: 0; bottom: 0; left: 0;right: 0; opacity: 0;" type="file" accept="image/jpg, image/png" />

            <div style="text-align: top">
                <span style="font-size: 12px;">upload：</span>
                <img id="upload" src="./static/icons/cloud.png" style="width: 40px; height: 40px; vertical-align: middle;" />
            </div>
        </div>


        <form action="controller?command=create" method="post">
            name:<input type="text" name="name"><br>
            category:<input type="text" name="category"><br>
            <input type="submit">
        </form>
        <br />
        <a href="controller?command=read">imageList</a>
    </body>
</html>