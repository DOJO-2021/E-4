<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Profile</title>
</head>
<body>
<h3>プロフィール</h3>

<!-- 自己紹介（ここから） -->
	<c:forEach var="e" items="${ProfileList}">
	<form method="POST" action="/Qsama/ProfileServlet">

   <div class="introducation">
    <div class="mandatory">
      <label>会社名：${e.company}		<input type="text" name="COMPANY" required></label><br>
      <label>クラス番号：${e.my_class}		<input type="text" name="MY_CLASS" required></label><br>
      <label>名前：${e.name}		<input type="text" name="NAME" required></label><br>
      <label>プログラミング経験：${e.experience}		<input type="text" name="EXPERIENCE" required></label><br>
    </div>
    <div class="choice">
      <label>血液型：${e.bloodtype}		<input type="text" name="BLOODTYPE"></label><br>
      <label>誕生日：${e.birthday}		<input type="text" name="BIRTHDAY"></label><br>
      <label>大学名：${e.college}		<input type="text" name="COLLEGE"></label><br>
      <label>学部名：${e.undergraduate}		<input type="text" name="UNDERGRADUATE"></label><br>
      <label>趣味：${e.hobby}		<input type="text" name="HOBBY"></label><br>
      <label>特技：${e.special_skill}		<input type="text" name="SPECIAL_SKILL"></label><br>
      <label>資格：${e.qualification}		<input type="text" name="QUALIFICATION"></label><br>
      <label>好きなアーティスト：${e.favorite}		<input type="text" name="FAVORITE"></label><br>
	  <label>一言コメント：${e.comment}		<input type="text" name="COMMENT"></label><br>
	</div>

	<!--個人写真の挿入  -->
	  <img src="" class="id_photo">
	</div>
<!-- 自己紹介（ここまで）-->
    <img src="" class="photo">
    </form>
    </c:forEach>

    <!-- 過去の質問一覧表示（ここから） -->
    <p class="past_questions">過去の質問一覧表示</p>
    	<ol>
	      <li>質問内容</li>
	      <li>質問内容</li>
	      <li>質問内容</li>
	      <li>質問内容</li>
	      <li>質問内容</li>
	    </ol>
    <!-- 過去の質問一覧表示（ここまで） -->

	 <input type="submit" name="edit" value="編集">
	 <input type="reset" name="reset" value="削除"><br>

   <!-- 戻るボタン
   受講者トップページへのリンク -->
  <a href="/Qsama/S_MainServlet">戻る</a>
</body>
</html>