<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Qsama | admin</title>
<link rel="stylesheet" href="css/admin.css">
</head>
<body>
<!-- 共通のヘッダー -->
<ul id="nav">
  <li>メニュー</li>
  <li><a href="/Qsama/ProfileServlet">Mypage</a></li>
  <li><a href="/Qsama/SerachServlet">投稿</a></li>
  <li><a href="/Qsama/SerchServlet">検索</a></li>
  <li><a href="/Qsama/LogoutServlet">ログアウト</a></li>
</ul>
<!-- 共通ヘッダーここまで -->
<div class="content_box">
<!-- 通知欄 -->
	<div class="tabs">
	  <input id="html" type="radio" name="tab_item" checked>
	  <label class="tab_item" for="html">質問通知</label>
	  <input id="css" type="radio" name="tab_item">
	  <label class="tab_item" for="css">解答済み通知</label>
	  <div class="tab_content" id="html_content">
	    <div class="tab_content_description">
	      <p class="c-txtsp">質問通知が表示される</p>
	    </div>
	  </div>
	  <div class="tab_content" id="css_content">
	    <div class="tab_content_description">
	      <p class="c-txtsp">解決済み通知が表示される</p>
	    </div>
	  </div>
	</div>
	<!-- 通知欄ここまで -->

	<!-- 回答欄 -->
	<div class="content1">
	質問内容
	</div>

	<!-- 質問カテゴリ修正欄 -->
	<select>
	  <option value="html" selected>HTML</option>
	  <option value="css" >CSS</option>
	  <option value="javascript">JavaScript</option>
	  <option value="java">Java</option>
	  <option value="sql">SQL</option>
	</select>
</div>
</body>
</html>