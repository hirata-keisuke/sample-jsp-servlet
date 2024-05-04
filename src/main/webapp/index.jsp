<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>入力画面</title>
</head>
<body>
<h1>サンプルプログラム</h1>
<form action="./SampleServlet" method="POST">
    <label for="LastName">名字</label>: <input type="text" name="LastName"/><br/>
    <label for="FirstName">名前</label>: <input type="text" name="FirstName"/><br/>
    <input type="hidden" name="action" value="hello"/>
    <input type="submit" name="send" value="送信"/>
</form>
</body>
</html>