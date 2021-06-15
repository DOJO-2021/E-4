<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Qsama | 共通ヘッダー</title>
<link rel="stylesheet" href="css/header.css"><!--CSS読み込み-->
</head>
<body>
<!-- 共通のヘッダー -->
<header>
<div class="header_body">
  <div class="header_left">
  <img src="images/logo.png" alt="Qsama_logo">
  </div>
  <div class="header_right">
    <nav class="global">
      <ul class="dropdwn">
        <li><a href="/Qsama/S_MainServlet">TOP</a></li>
        <li>マイページ
            <ul class="dropdwn_menu">
                <li><a href="#">過去の質問一覧</a></li>
                <li><a href="#">プロフィール編集</a></li>
                <li><a href="#">プロフィール一覧</a></li>
            </ul>
        </li>
        <li>投稿
            <ul class="dropdwn_menu">
                <li><a href="/Qsama/Question_postServlet">個別投稿</a></li>
                <li><a href="/Qsama/Question_allpostServlet">全体投稿</a></li>
            </ul>
        </li>
        <li><a href="/Qsama/SearchServlet">検索</a></li>
        <li><a href="/Qsama/LogoutServlet">ログアウト</a></li>
    </ul>
   </nav>
  </div>
 </div>
</header>
<!-- 共通ヘッダーここまで -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="js/header.js"></script>
</body>
</html>