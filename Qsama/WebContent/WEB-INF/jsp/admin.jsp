<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Qsama | 管理者ページ</title>
<link rel="stylesheet" href="css/admin.css">
</head>
<body>
<!-- 共通のヘッダー -->
<ul id="nav">
  <li>メニュー</li>
  <li><a href="/Qsama/ProfileServlet">Mypage</a></li>
  <li><a href="/Qsama/Question_allpostServlet">全体投稿</a></li>
  <li><a href="/Qsama/Question_postServlet">個別投稿</a></li>
  <li><a href="/Qsama/AdminServlet">管理者ページ</a></li>
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
		<div class="right_content"> <!-- 右側全体のコンテンツ -->
			<!-- 質問内容 -->
			<div class="content1">	<!-- 一番上のコンテンツ -->
			質問内容
			</div>
			<div class="middle_content"> <!-- 真ん中のコンテンツ -->
				<!-- 質問カテゴリ修正欄 -->
				<select>
				  <option value="html" selected>HTML</option>
				  <option value="css" >CSS</option>
				  <option value="javascript">JavaScript</option>
				  <option value="java">Java</option>
				  <option value="sql">SQL</option>
				</select>
				既存のカテゴリの表示
				<!-- 全体公開、個別公開のチェックボックス -->
					<input type="radio" name="riyu" value="1" checked="checked">全体公開
					<input type="radio" name="riyu" value="2" >個別公開
				<!-- 回答入力フォーム -->
				<form>
					<label>
						<textarea name="answer_area">回答入力</textarea>
						<!-- 投稿ボタン -->
						<input type="submit" name="answer_submit" value="投稿">
					</label>
				</form>
			</div>
			<div class="under_content"> <!-- 下二つのコンテンツ -->
				<!-- 質問公開設定 -->
				<div class="content2">質問公開設定
					<button onclick="location.href=''">最近の質問一覧</button>
					<button onclick="location.href=''">全体投稿一覧</button>
					<button onclick="location.href=''">個別投稿一覧</button>
				</div>
				<!-- 受講者質問管理 -->
				<div class="content3">受講者別質問管理
				</div>
			</div>
		</div>
</div>
</body>
</html>