<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyMutterList</title>
</head>
<body>
<h1>${loginUser.name }さんのツイート一覧</h1>
<c:forEach var="mutter" items="${myMutterList }">
			<form action="/docoTsubu/DeleteMutter" method="post">
	<p><c:out value="${mutter.userName }"/>:
			<c:out value="${mutter.text }"/> >:		
			<input type = "hidden" name = "id" value= "${mutter.id}">
			<input type = "submit" value ="削除">
	</p>		
			</form>
</c:forEach>
<c:if test="${myMutterList.size() == 0 }">
		${loginUser.name }さんのツイートはありません。
</c:if>

<a href="/docoTsubu/Main">ホーム画面へ</a>
</body>
</html>