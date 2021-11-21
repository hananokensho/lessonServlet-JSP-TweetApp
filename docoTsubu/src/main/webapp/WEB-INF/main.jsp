<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ツイートアプリメイン画面</title>
</head>
<body>
<h1>ツイートアプリタイムライン</h1>
<p>${loginUser.name }さんログイン中</p>
<a href="/docoTsubu/Main" >更新</a><br>
<a href="/docoTsubu/Logout" >ログアウト</a><br>
<a href="/docoTsubu/MyMutterList">${loginUser.name }さんのツイート一覧・ツイートの削除はこちら</a>

<form action = "/docoTsubu/Main" method = "post">
<input type="text" name="text">
<input type="submit" value="ツイート">
</form>

<c:forEach var="mutter" items="${mutterList }">
	<p><c:out value="${mutter.userName }"/>:
			<c:out value="${mutter.text }"/>
	</p>		
</c:forEach>
<c:if test="${mutterList.size() == 0 }">
		タイムラインにはツイートがありません。
</c:if>
</body>
</html>