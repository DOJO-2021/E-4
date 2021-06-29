<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">

<head>
	<!--情報-->
<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Qさま｜質問検索</title>
	<link rel="stylesheet" href="css/common.css">
	<link rel="stylesheet" href="css/search.css"><!--CSS読み込み-->
	
<!-- font awesome -->
<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" rel="stylesheet">
	<!-- choice -->
	 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/choices.js/public/assets/styles/choices.min.css">
	<script type='text/javascript' src='//ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js?ver=1.11.3'></script>
	<script src="js/Search3.js"></script>		<!--検索ボタン空作動防止js-->

</head>
<body>
<!-- 共通のヘッダー -->
<c:choose>
 <c:when test="${sessionScope.user_rank == 1}">
  <jsp:include page="/WEB-INF/jsp/header.jsp" />
 </c:when>
 <c:otherwise>
  <jsp:include page="/WEB-INF/jsp/a_header.jsp" />
 </c:otherwise>
</c:choose>
<!-- 共通ヘッダーここまで -->

	<main>
		<!--メイン-->
		<div id="search_body" class="search_body">

		<div class="foo" id="foo_serch1">
			<span class="letter" data-letter="質">質</span>
			<span class="letter" data-letter="問">問</span>
			<span class="letter" data-letter="検">検</span>
			<span class="letter" data-letter="索">索</span>
		</div>


		<form method="POST" id="search_form" action="/Qsama/SearchServlet">
			<div id="search_window" class="tabs2">



				<input id="teacher" type="radio" name="tab_item2" checked>
 				<label class="tab_item2" for="teacher">講師</label>
 				<input id="office" type="radio" name="tab_item2">
  				<label class="tab_item2" for="office">事務局</label>
				<div class="tab_content2" id="teacher_content">
				    <div class="tab_content_description">
				    	<div class="search_bar">
						<!--    <h3>質問検索</h3>   質問窓-->
							<i class="fas fa-search search_icon"></i>
							<input type="search" id="search_word" class="search_word" name="search_word" size="50" placeholder="検索キーワード(例) JavaScript オブジェクト" autofocus required>
							<input type="submit" name="submit" value="検索" id="search_submit">
						</div>
						<div class="genre custom-radio" style="width:50%; float:left;">
						<br>検索条件<br>
							<input type="radio" name="search_radio" value="and" id="search_radio3" checked>
							<label for="search_radio3"><span class="radio-text"> 全てのワードを含む</span></label><br>
							<input type="radio" name="search_radio" value="or" id="search_radio4">
							<label for="search_radio4"><span class="radio-text"> いずれかのワードを含む</span></label><br>
						</div>

						<div class="pulldownset" style="float:left;">
						<br>検索範囲選択<br>
						<div class="m_items">
					<select class="major_items js-choices" name="m_items" id="m_items">
						<option value="" selected="selected">大カテゴリを選択</option>
						<option value="HTML">HTML</option>
						<option value="CSS">CSS</option>
						<option value="JavaScript">JavaScript</option>
						<option value="Java">Java</option>
						<option value="SQL">SQL</option>
						<option value="ｻｰﾌﾞﾚｯﾄ・JSP">ｻｰﾌﾞﾚｯﾄ・JSP</option>
						<option value="ｱﾌﾟﾘｹｰｼｮﾝ">ｱﾌﾟﾘｹｰｼｮﾝ</option>
						<option value="その他">その他</option>
					</select><br>
						</div>

						<div class="s_items">
					<select class="sub_item js-choices" name="s_items" id="s_items">
						<option value="" selected="selected">詳細カテゴリを選択</option>
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
					</select>
					</div>
				</div>
			</div>
		</div>
				<div class="tab_content2" id="office_content">
				    <div class="tab_content_description">
						
					<!-- 	<h3>質問検索</h3>  -->  <!--質問窓-->
						<div class="search_bar">
							<i class="fas fa-search search_icon"></i>
							<input type="text" class="input_items" name="search_word2" placeholder="検索キーワード">
							<input type="submit" name="submit" value="検索">
						</div>
				<div style="width:50%; float:left;" class="custom-radio">
					<br>検索条件<br>
					<input type="radio" name="search_radio2" value="and" id="search_radio1" checked>
					<label for="search_radio1"><span class="radio-text"> 全てのワードを含む</span></label><br>
					<input type="radio" name="search_radio2" value="or" id="search_radio2">
					<label for="search_radio2"><span class="radio-text"> いずれかのワードを含む</span></label><br>
				</div>
				
				<div style="float:left;" class="office_search">
					<br>ジャンル選択<br>
					<select class="major_items2 js-choices" name="m_items2" id="m_items2">
						<option value="" selected="selected">ジャンルを選択</option>
						<option value="Procedure">事務手続き</option>
						<option value="Report">遅刻・欠席・退勤忘れ</option>
						<option value="S_other">その他</option>
					</select><br>
					<select class="sub_item2 js-choices" name="s_items2" id="s_items2">
						<option value="" selected="selected">項目を選択</option>
						<option value="項目A" data-val="Procedure">項目A</option>
						<option value="項目B" data-val="Procedure">項目B</option>
						<option value="項目C" data-val="Report">項目C</option>
  						<option value="項目D" data-val="Report">項目D</option>
  						<option value="項目E" data-val="S_other">項目E</option>
  						<option value="項目F" data-val="S_other">項目F</option>
					</select>
				</div>
			</div>
		</div>
	</div >
	</form>
		<!--ランキング窓-->




		<div class="tabs" style="float:left;">
			<input id="w_ranking" type="radio" name="tab_item" checked>
			<label class="tab_item" for="w_ranking">週間ランキング</label>
			<input id="a_ranking" type="radio" name="tab_item">
			<label class="tab_item" for="a_ranking">通期ランキング</label>
			<div class="tab_content" id="w_ranking_content">
				<div class="tab_content_description">
				<p class="c-txtsp">
				<!--    <h3>週間ランキング</h3>    -->
					<ol class="ranking">
					<c:forEach var="w" items="${WeekRankingList}" varStatus="t1">
						${(t1.index)+1}位　:　${w.word} <br>
					</c:forEach>
					</ol>
				</div>
			</div>
			<div class="tab_content" id="a_ranking_content">
				<div class="tab_content_description">
				<p class="c-txtsp">
				<!-- <h3>通期ランキング</h3>   -->
					<ol class="ranking">
					<c:forEach var="y" items="${MaxRankingList}" varStatus="t2">
						${(t2.index)+1}位　:　${y.word} <br>
					</c:forEach>
					</ol>
				</div>
			</div>
		</div>
	</div>


	<div id="search_results" class="search_results" style="clear:both;">


		<div id="result_body" class="result_body" style="clear:both;">
		<!-- <h3>検索結果</h3><br> -->

		<div class="foo" >
			<span class="letter" data-letter="検">検</span>
			<span class="letter" data-letter="索">索</span>
			<span class="letter" data-letter="結">結</span>
			<span class="letter" data-letter="果">果</span>
		</div>


			<div class="cp_qa">
			<c:forEach var="s" items="${SearchList}" varStatus="z">
				<div class="cp_actab">
					<input id="cp_tabfour031" type="checkbox" name="tabs">
					<label for="cp_tabfour031">${s.q_content}</label>
					<div class="cp_actab-content">
						<p>${s.a_content}</p>
					</div>
				</div>
			</c:forEach>
			</div>
		</div>
	</div>
	</main>

<jsp:include page="/WEB-INF/jsp/footer.jsp" />

		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script><!--jquery読み込み-->
		<script src="js/Search.js"></script>		<!--講師・事務局ジャンル表示用js-->

		<script src="https://cdn.jsdelivr.net/npm/choices.js/public/assets/scripts/choices.min.js"></script>


<script>
document.addEventListener('DOMContentLoaded', () => {
	  new Choices('#m_items', {
	    removeItemButton: true,        // 各アイテムに削除ボタンを付けるかどうか
	    shouldSort: false,             // 選択肢はHTML記述順で表示
	    itemSelectText: '選択',         // Default: Press to select
	    searchEnabled: false,
	    position: 'bottom'

	  });
	  new Choices('#s_items', {
		    removeItemButton: true,
		    shouldSort: false,
		    itemSelectText: '選択',         // Default: Press to select
		    position: 'bottom',
		    searchEnabled: false
	 });
	  new Choices('#m_items2', {
		    removeItemButton: true,        // 各アイテムに削除ボタンを付けるかどうか
		    shouldSort: false,             // 選択肢はHTML記述順で表示
		    itemSelectText: '選択',         // Default: Press to select
		    searchEnabled: false,
		    position: 'bottom'

		  });
	  new Choices('#s_items2', {
		    removeItemButton: true,        // 各アイテムに削除ボタンを付けるかどうか
		    shouldSort: false,             // 選択肢はHTML記述順で表示
		    itemSelectText: '選択',         // Default: Press to select
		    searchEnabled: false,
		    position: 'bottom'

		  });
});
</script>

</body>
</html>
