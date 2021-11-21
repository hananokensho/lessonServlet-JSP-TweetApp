<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規会員登録</title>
</head>
<body>
<form action="/docoTsubu/AccountRegister" method="post">
<p>全て入力してください</p>
名前：<input type = "text" name = "name" required><br>
パスワード：<input type = "text" name = "pass" required><br>
ID：<input type = "text" name = "id" required><br>
<input type="submit" value="登録">
</form>
</body>
</html>