<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="/Qsama/css/login.css">
	<link rel="stylesheet" href="css/common.css">
	<!-- choice -->
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/choices.js/public/assets/styles/choices.min.css">
	<script type='text/javascript' src= "js/login.js"></script>

	<meta charset="UTF-8">
	<title>ログイン</title>
</head>
<body class="login_body">
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
        <div class = "class_number">
          <label for = "belong">所属クラス</label>
	        <select class = "belong js-choices" name = "belong" id="belong">
		      <option value = "A">A</option>
		      <option value = "B">B</option>
		      <option value = "C">C</option>
		      <option value = "D">D</option>
		      <option value = "E">E</option>
	        </select><br>
	    </div>
	    
	      <label class = "content"><input type="text" placeholder = "ID" name = "id"required></label><br>
	      <label class = "content"><input type="text" placeholder = "Email" name = "email"required></label><br>
	      <label class = "content"><input type="text" placeholder = "氏名" name = "name"required></label><br>
	      <label class = "content"><input type="password" placeholder = "パスワード" name = "pw"required></label><br>
          <div class="rank custom-radio">
	          <input type="radio" name="rank" value="1" checked="checked" id="rank1">
	          <label class = "content" for="rank1"><span class="radio-text"> 受講者</span></label>
			  <input type="radio" name="rank" value="2" id="rank2">
			  <label class = "content" for="rank2" ><span class="radio-text"> 管理者</span></label><br>
	      </div>
	    
	    <div class = "button">
	      <input type="submit" name="regist" value="新規登録" onclick = "checkForm()">
	    </div>
	    </form>
		</div>
	  </div>
 </div>
 <script src="https://cdn.jsdelivr.net/npm/choices.js/public/assets/scripts/choices.min.js"></script>
 
 <script>
document.addEventListener('DOMContentLoaded', () => {
	  new Choices('#belong', {
	    removeItemButton: true,		// 各アイテムに削除ボタンを付けるかどうか
	    shouldSort: false,			// 選択肢はHTML記述順で表示
	    searchEnabled: false,		// 検索領域　非表示
	    itemSelectText: '選択',		// Default: Press to select
	    position: 'below'			// 選択肢は下に伸ばす
	  });
	});
</script>
 
 
 </body>
</html>