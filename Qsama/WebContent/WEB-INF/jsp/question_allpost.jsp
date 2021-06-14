<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Qさま｜全体投稿</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.0/jquery.min.js" ></script>
<link rel="stylesheet" type="text/css" href="css/question_allpost.css">
</head>
<body>
<!-- ヘッダー -->


  <h1>全体投稿</h1>
  <main>

  <div class="container">
    <!-- チャット閲覧部分 -->
    <div class="chat-area">
    </div>

    <!-- コメント  フレームワーク -->
    <div class="message-area">
      <!-- コメント入力欄 -->
      <div class="message-area-text">
        <textarea id="text"></textarea>
      </div>

      <!-- 送信ボタン -->
      <div class="message-area-button">
        <button id="send" class="disabled-button">送信</button>
      </div>
    </div>
    <!-- コメント部分  フレームワーク -->
  </div>



  <!-- 戻るボタン
     受講者トップページへのリンク -->
  <a href="/Qsama/S_MainServlet">戻る</a>

  </main>

</body>
</html>