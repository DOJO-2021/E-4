<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="/Qsama/css/login.css">
	<!-- jQuery本体↓ 
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
	<!-- jQueryが書いてあるファイル↓ 
	<script src="./js/login.js"></script>-->
	<meta charset="UTF-8">
	<title>ログイン</title>
</head>
<body>
<div class="tabs">
  <input id="login" type="radio" name="tab_item" checked>
  <label class="tab_item" for="login">ログイン</label>
  <input id="regist" type="radio" name="tab_item">
  <label class="tab_item" for="regist">新規登録</label>
  <div class="tab_content" id ="login_content">
  	<div class = item_login>
    	<form class="login-form" method="POST" id="form_l" action="/Qsama/LoginServlet">
		  <label class = content><input type="text" name = "USER_ID" placeholder = "ユーザID"></label><br>
		  <label class = content><input type="password" name = "USER_PW" placeholder = "パスワード"></label><br>
		  <input type="submit" name="Login" value="ログイン" class="login-submit">
		</form>
	</div>
  </div>
  <div class="tab_content" id="regist_content">
  	<div class = item_regist>
        <form class="login-form" method="POST" id="form_r" action="/Qsama/Regist_FServlet">
        <div class = class_number>
          <label for = "belong">所属クラス</label>
	        <select class = "belong" name = "belong">
		      <option value = "a">A</option>
		      <option value = "b">B</option>
		      <option value = "c">C</option>
		      <option value = "d">D</option>
		      <option value = "e">E</option>
	        </select><br>
	    </div>
	      <label class = content><input type="text" placeholder = "Email"></label><br>
	      <label class = content><input type="text" placeholder = "氏名"></label><br>
	      <label class = content><input type="password" placeholder = "パスワード"></label><br>
	      <label class = content><input type="password" placeholder = "パスワード(確認)"></label><br>
	      <label>ユーザランク</label><br>
	      <input type="submit" name="regist" value="新規登録">
	    </form>
		</div>
	  </div>
 </div>
 <!-- 
 <button>ポップアップ表示</button>
 
 
<div class="popup">
    <div class="content_popup">
        <p>サンプルテキスト、サンプルテキスト、サンプルテキスト、サンプルテキスト</p>
        <button id="close">閉じる</button>
    </div>
</div>-->
</body>
</html>