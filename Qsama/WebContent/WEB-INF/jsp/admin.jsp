<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	    <c:forEach var="g" items="${GetList}" varStatus="GL">
	     	<div class="wrap">
	     		<form method="POST" id="display_form" action="/Qsama/AdminServlet">
	     			<input type="hidden" name="post_number" value="${g.post_Number}">
 					<button class="cp_btn" id="title_${GL.index}" >未回答　　　${g.q_date}<br> 質問No${g.post_Number}:　${g.name}さんより質問です</button><br>
 				</form>
			</div>
	    </c:forEach>
	    </div>
	  </div>
	  <div class="tab_content" id="css_content">
	    <div class="tab_content_description">
		<c:forEach var="g2" items="${GetList2}" varStatus="GL2">
		    <div class="wrap">
				<form method="POST" id="display_form2" action="/Qsama/AdminServlet">
					<input type="hidden" name="post_number" value="${g2.post_Number}">
					<button class="cp_btn" id="title_${GL2.index}" >回答済　　　${g2.q_date}<br> 質問No${g2.post_Number}:　${g2.name}さんより質問です</button><br>
 				</form>
 			</div>
		</c:forEach>
	    </div>
	  </div>
	</div>
	<!-- 通知欄ここまで -->

		<div class="right_content"> <!-- 右側全体のコンテンツ -->
				質　問　内　容
			<!-- 質問内容 -->
			<div class="content1">	<!-- 一番上のコンテンツ -->
				<c:forEach var="d" items="${DisplayGetList}" varStatus="DG">
				${d.q_content}
				</c:forEach>
			</div>
			<div class="middle_content"> <!-- 真ん中のコンテンツ -->
				<!-- 質問カテゴリ修正欄 -->
				項目選択
					<select class="major_items" name="m_items">
						<option value="" selected="selected">ジャンルを選択</option>
						<option value="HTML">HTML</option>
						<option value="CSS">CSS</option>
						<option value="JavaScript">JavaScript</option>
						<option value="Java">Java</option>
						<option value="SQL">SQL</option>
						<option value="ｻｰﾌﾞﾚｯﾄ・JSP">ｻｰﾌﾞﾚｯﾄ・JSP</option>
						<option value="ｱﾌﾟﾘｹｰｼｮﾝ">ｱﾌﾟﾘｹｰｼｮﾝ</option>
						<option value="その他">その他</option>
				  <c:forEach var="d" items="${DisplayGetList}" varStatus="DG">
				  <option value="" selected>${d.m_items}</option>
				  </c:forEach>
				</select>
				<select class="sub_item" name="s_items">
						<option value="" selected="selected">詳細ジャンルを選択</option>
						<option value="基礎・基本的な書式" data-val="HTML">基礎・基本的な書式</option>
						<option value="見出し・段落・リスト" data-val="HTML">見出し・段落・リスト</option>
						<option value="テキスト・単語" data-val="HTML">テキスト・単語</option>
						<option value="リンク・画像挿入" data-val="HTML">リンク・画像挿入</option>
						<option value="class属性・id属性" data-val="HTML">class属性・id属性</option>
						<option value="テーブル・フォーム" data-val="HTML">テーブル・フォーム</option>
						<option value="グループ化" data-val="HTML">グループ化</option>
						<option value="その他" data-val="HTML">その他</option>
						<option value="基礎・基本的な書式" data-val="CSS">基礎・基本的な書式</option>
						<option value="装飾" data-val="CSS">装飾</option>
						<option value="レイアウト" data-val="CSS">レイアウト</option>
						<option value="パディング・マージン" data-val="CSS">パディング・マージン</option>
						<option value="レスポンシブデザイン" data-val="CSS">レスポンシブデザイン</option>
						<option value="その他" data-val="CSS">その他</option>
						<option value="基礎" data-val="JavaScript">基礎</option>
						<option value="アウトプット方法" data-val="JavaScript">アウトプット方法</option>
						<option value="文法" data-val="JavaScript">文法</option>
						<option value="条件分岐・繰り返し" data-val="JavaScript">条件分岐・繰り返し</option>
						<option value="関数作成" data-val="JavaScript">関数作成</option>
						<option value="配列" data-val="JavaScript">配列</option>
						<option value="イベント処理" data-val="JavaScript">イベント処理</option>
						<option value="オブジェクト（Date,Mathなど）" data-val="JavaScript">オブジェクト（Date,Mathなど）</option>
						<option value="その他" data-val="JavaScript">その他</option>
						<option value="基礎・基本的な書式" data-val="Java">基礎・基本的な書式</option>
						<option value="条件分岐・繰り返し" data-val="Java">条件分岐・繰り返し</option>
						<option value="配列" data-val="Java">配列</option>
						<option value="メソッド" data-val="Java">メソッド</option>
						<option value="オブジェクト指向" data-val="Java">オブジェクト指向</option>
						<option value="継承" data-val="Java">継承</option>
						<option value="多態性" data-val="Java">多態性</option>
						<option value="カプセル化" data-val="Java">カプセル化</option>
						<option value="API" data-val="Java">API</option>
						<option value="コレクション" data-val="Java">コレクション</option>
						<option value="例外" data-val="Java">例外</option>
						<option value="エラーメッセージ" data-val="Java">エラーメッセージ</option>
						<option value="その他" data-val="Java">その他</option>
						<option value="サーブレット" data-val="ｻｰﾌﾞﾚｯﾄ・JSP">サーブレット</option>
						<option value="JSP" data-val="ｻｰﾌﾞﾚｯﾄ・JSP">JSP</option>
						<option value="フォーム" data-val="ｻｰﾌﾞﾚｯﾄ・JSP">フォーム</option>
						<option value="MVCモデル" data-val="ｻｰﾌﾞﾚｯﾄ・JSP">MVCモデル</option>
						<option value="スコープ" data-val="ｻｰﾌﾞﾚｯﾄ・JSP">スコープ</option>
						<option value="アクションタグ" data-val="ｻｰﾌﾞﾚｯﾄ・JSP">アクションタグ</option>
						<option value="EL式" data-val="ｻｰﾌﾞﾚｯﾄ・JSP">EL式</option>
						<option value="データベース" data-val="ｻｰﾌﾞﾚｯﾄ・JSP">データベース</option>
						<option value="エラーメッセージ" data-val="ｻｰﾌﾞﾚｯﾄ・JSP">エラーメッセージ</option>
						<option value="その他" data-val="ｻｰﾌﾞﾚｯﾄ・JSP">その他</option>
						<option value="データベースの基本" data-val="SQL">データベースの基本</option>
						<option value="検索 -select-" data-val="SQL">検索 -select-</option>
						<option value="内部結合・外部結合" data-val="SQL">内部結合・外部結合</option>
						<option value="サブクエリ" data-val="SQL">サブクエリ</option>
						<option value="登録 -insert-" data-val="SQL">登録 -insert-</option>
						<option value="更新 -update-" data-val="SQL">更新 -update-</option>
						<option value="削除 -delete-" data-val="SQL">削除 -delete-</option>
						<option value="テーブル作成" data-val="SQL">テーブル作成</option>
						<option value="その他" data-val="SQL">その他</option>
						<option value="Eclipse" data-val="ｱﾌﾟﾘｹｰｼｮﾝ">Eclipse</option>
 						<option value="H2コンソール" data-val="ｱﾌﾟﾘｹｰｼｮﾝ">H2コンソール</option>
						<option value="Git関係" data-val="ｱﾌﾟﾘｹｰｼｮﾝ">Git関係</option>
						<option value="その他" data-val="ｱﾌﾟﾘｹｰｼｮﾝ">その他</option>
						<option value="講義全般" data-val="その他">講義全般</option>
    					<option value="その他" data-val="その他">その他</option>
    					<c:forEach var="d" items="${DisplayGetList}" varStatus="DG">
						<option value="" selected>${d.s_items}</option>
						</c:forEach>
					</select><br>
				<!-- 回答入力フォーム -->
				回　答　入　力
				<form method="POST" id="answer_form" name="answer_form" action="/Qsama/AdminServlet">
					<label>
						<input type="hidden" name="post_number" value="${d.post_Number}">
						<textarea id="answer_area" name="answer_area"><c:forEach var="d" items="${DisplayGetList}" varStatus="DG">${d.a_content}</c:forEach>
						</textarea><br>
						<!-- 投稿ボタン -->
						<input type="submit" name="answer_submit" class="answer_submit" style="width: 50%;" value="投稿">
					</label>
				</form>
			</div>
			<div class="under_content"> <!-- 下二つのコンテンツ -->
				<!-- 質問公開設定 -->
				<div class="content2">質問公開設定<br><br>
					<button style="width: 80%;" class="js-modal-open" data-target="modal01">公開済 - 投稿一覧表示</button><br><br>
					<button style="width: 80%;" class="js-modal-open" data-target="modal02">未公開 - 投稿一覧表示</button>
				</div>
				<div id="modal01" class="modal js-modal">
					<div class="modal__bg js-modal-close"></div>
					<div class="modal__content">
						<p>1つ目モーダルウィンドウです。ここにモーダルウィンドウで表示したいコンテンツを入れます。モーダルウィンドウを閉じる場合は下の「閉じる」をクリックするか、背景の黒い部分をクリックしても閉じることができます。</p>
						<a class="js-modal-close" href="">閉じる</a>
					</div><!--modal__inner-->
				</div><!--modal-->
				<div id="modal02" class="modal js-modal">
					<div class="modal__bg js-modal-close"></div>
					<div class="modal__content">
						<p>2つ目モーダルウィンドウです。ここにモーダルウィンドウで表示したいコンテンツを入れます。モーダルウィンドウを閉じる場合は下の「閉じる」をクリックするか、背景の黒い部分をクリックしても閉じることができます。</p>
						<a class="js-modal-close" href="">閉じる</a>
					</div><!--modal__inner-->
				</div><!--modal-->
				<!-- 受講者質問管理 -->
				<div class="content3">受講者別質問管理
				</div>
			</div>
		</div>
</div>
</body>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="js/Admin.js"></script>		<!--モーダルウィンドウ用js-->
<script>
</html>