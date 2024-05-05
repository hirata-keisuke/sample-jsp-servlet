<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="me.dto.SampleDTO"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>結果画面</title>
</head>
<body>
<% SampleDTO dto = (SampleDTO) request.getAttribute("dto"); %>
<p name="main">
    <%= dto.getMessage() %>、<%= dto.getLastName() %> <%= dto.getFirstName() %> さん！
</p>
</body>
</html>
