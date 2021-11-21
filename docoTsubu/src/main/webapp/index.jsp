<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どこつぶへようこそ</title>
</head>
<body>
<h1>どこつぶへようこそ</h1>

<form action="/docoTsubu/AccountSerch" method="post">
ユーザーID：<input type="text" name="id" ><br>
パスワード：<input type="text" name="pass" ><br>
<input type ="submit" value="ログイン">
</form>
<p>ユーザー登録がお済みでない方はこちら↓</p>
<a href="/docoTsubu/AccountRegister" ><button>新規会員登録</button></a>
</body>
</html>