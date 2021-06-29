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
<header class="header_wrapper">
<div class="header_body" id="heder">
  <div class="header_left">
  <table>
    <tr>
       <td><img src="logo/logo.png" alt="Qsama_logo"></td>
    </tr>
  </table>
  </div>
  
  <div class="header_right">
    <nav class="global">
      <ul class="globalList">
        <li><a href="/Qsama/S_MainServlet">TOP</a></li>
        <li><a href="/Qsama/ProfileServlet">マイページ</a></li>
        <li><a href="/Qsama/Question_postServlet">投稿</a></li>
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