<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="/Qsama/css/login.css">

	<script type='text/javascript' src= "js/login.js"></script>

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
		  <label class = content><input type="text" name = "USER_ID" placeholder = "ユーザID" required></label><br>
		  <label class = content><input type="password" name = "USER_PW" placeholder = "パスワード" required></label><br>
		<div class = button>
	  	  <input type="submit" name="Login" value="ログイン" class="login-submit">
		</div>
		</form>
		  <p id = "error_msg"></p>
	</div>
  </div>
  <div class="tab_content" id="regist_content">
  	<div class = item_regist>
        <form class="login-form" method="POST"  name = "form"id="form_r" action="/Qsama/RegistServlet">
        <div class = class_number>
          <label for = "belong">所属クラス</label>
	        <select class = "belong" name = "belong">
		      <option value = "A">A</option>
		      <option value = "B">B</option>
		      <option value = "C">C</option>
		      <option value = "D">D</option>
		      <option value = "E">E</option>
	        </select><br>
	    </div>
	      <label class = content><input type="text" placeholder = "ID" name = "id"required></label><br>
	      <label class = content><input type="text" placeholder = "Email" name = "email"required></label><br>
	      <label class = content><input type="text" placeholder = "氏名" name = "name"required></label><br>
	      <label class = content><input type="password" placeholder = "パスワード" name = "pw"required></label><br>
          <label class = content><input type="radio" name="rank" value="2" checked="checked">受講者
					            <input type="radio" name="rank" value="1" >管理者</label><br>
	    <div class = "button">
	      <input type="submit" name="regist" value="新規登録" onclick = "checkForm()">
	    </div>
	    </form>
		</div>
	  </div>
 </div>
 </body>
</html>