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
        <li><a href="/Qsama/ProfileServlet">プロフィール編集</a></li>
        <li><a href="/Qsama/AdminServlet">質問管理</a></li>
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
