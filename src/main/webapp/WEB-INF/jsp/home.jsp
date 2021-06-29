<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" name="viewport" content="width=device-width, initial-scale=1"/>
    <script src="js/jquery/3.3.1/jquery.min.js"></script>
    <title>Счетчик запросов</title>

</head>
<body onload="refreshCount()">

<div class="container">
    <label for="currentCount">Текущее значение счетчика:</label>
    <input type="text" class="text-primary" id="currentCount" name="currentCount" style="margin: 5px">
    <br>
    <button type="button" class="btn" style="margin: 5px;" onclick="changeCount('POST')">Увеличить счетчик</button>
    <button type="button" class="btn" style="margin: 5px;" onclick="changeCount('DELETE')">Обнулить счетчик</button>

</div>

<script>
    function refreshCount() {
        $.ajax({
            type: 'GET',
            url: '/api/counter',
            success: function (data, textStatus) {
                $('#currentCount').val(data);
            },
            error: function (jqXHR, errorThrown) {
                alert('Произошла ошибка : ' + errorThrown);
            }
        });
    }
</script>

<script>
    function changeCount(requestType) {
        $.ajax({
            type: requestType,
            url: '/api/counter',
            success: function (data, textStatus) {
                $('#currentCount').val(data);
            },
            error: function (jqXHR, errorThrown) {
                alert('Произошла ошибка : ' + errorThrown);
            }
        });
    }
</script>

</body>
</html>
