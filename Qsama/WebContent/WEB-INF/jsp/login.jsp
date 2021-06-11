<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="/Qsama/css/login.css">
	<!-- <script src = "./Qsama/js/login.js"></script>-->
	<meta charset="UTF-8">
	<title>ログイン</title>
</head>
<body>
<div class="tabs">
  <input id="login" type="radio" name="tab_item" checked>
  <label class="tab_item" for="login">ログイン</label>
  <input id="regist" type="radio" name="tab_item">
  <label class="tab_item" for="regist">新規登録</label>
  <div class="tab_content" id="login_content">
    <div class="tab_content_description">
      <div class = login_item>
        <div class = item>
        <form class="login-form" method="POST" id="form" action="/Qsama/LoginServlet">
		  <label class = content><input type="text" name = "USER_ID" placeholder = "ユーザID"></label><br>
		  <label class = content><input type="password" name = "USER_PW" placeholder = "パスワード"></label><br>
		</form>
		</div>
		<input type="submit" name="Login" value="Login" class="login-submit" >
	  </div>
    </div>
  </div>
  <div class="tab_content" id="regist_content">
      <label for = "belong">所属クラス</label>
	    <select class = "belong" name = "belong">
		  <option value = "a">A</option>
		  <option value = "b">B</option>
		  <option value = "c">C</option>
		  <option value = "d">D</option>
		  <option value = "e">E</option>
	    </select><br>
	    <div class = item>
	      <label class = content><input type="text" placeholder = "Email"></label><br>
	      <label class = content><input type="text" placeholder = "氏名"></label><br>
	      <label class = content><input type="password" placeholder = "パスワード"></label><br>
	      <label class = content><input type="password" placeholder = "パスワード(確認)"></label><br>
	    </div>
	    <label>ユーザランク</label><br>
	    <div>	
	      <button id = "openModal">新規登録</button>
	    <!-- モーダルエリアここから -->
		<section id="modalArea" class="modalArea">
  			<div id="modalBg" class="modalBg"></div>
  			<div class="modalWrapper">
    			<div class="modalContents">
      				<h1>新規登録が完了しました！</h1>
    			</div>
    		<div id="closeModal" class="closeModal">
      			×
    		</div>
  			</div>
		</section>
<!-- モーダルエリアここまで -->
	      <!-- <a href = "/Qsama/Regist_FServlet"><input type="submit" name="regist" value="新規登録"></a> -->
	    </div>
	    <!-- <div id = "mask" class = "hidden"></div>
	    <section id = "model" class = "hidden">
	      <p>新規登録完了しました！</p>
	      <div id = "close">
	        ×
	      </div>
	    </section> -->
    </div>
</div>
<script  src = "//Qsama/WebContent/js/login.js">
$(function () {
	  $('#openModal').click(function(){
	      $('#modalArea').fadeIn();
	  });
	  $('#closeModal , #modalBg').click(function(){
	    $('#modalArea').fadeOut();
	  });
	});
</script>
</body>
</html>