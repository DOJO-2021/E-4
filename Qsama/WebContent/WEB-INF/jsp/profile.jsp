<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Profile</title>
</head>

<body>
<h3>プロフィール</h3>

<!-- 自己紹介（ここから） -->

   <form method="POST" action="/Qsama/ProfileServlet">

   <div class="introducation">
    <div class="mandatory">
      <label>会社名<input type="text" name="COMPANY" required></label><br>
      <label>クラス番号<input type="text" name="CLASS_NUMBER" required></label><br>
      <label>名前<input type="text" name="NAME" required></label><br>
      <label>プログラミング経験<input type="text" name="EXPERIENCE" required></label><br>
    </div>
    <div class="choice">
      <label>血液型<input type="text" name="BLOODTYPE"></label><br>
      <label>誕生日<input type="text" name="BIRTHDAY"></label><br>
      <label>大学名<input type="text" name="COLLEGE"></label><br>
      <label>学部名<input type="text" name="UNDERGRADUATE"></label><br>
      <label>趣味<input type="text" name="HOBBY"></label><br>
      <label>特技<input type="text" name="SPECIAL_SKILL"></label><br>
      <label>資格<input type="text" name="QUALIFICATION"></label><br>
      <label>好きなアーティスト<input type="text" name="FAVORITE_ARTIST"></label><br>
	  <label>一言コメント<input type="text" name="COMMENT"></label><br>
	</div>

	<!--個人写真の挿入  -->
	  <img src="" class="id_photo">
	</div>
<!-- 自己紹介（ここまで）-->
    <img src="" class="photo">

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
</form>
</body>
</html>