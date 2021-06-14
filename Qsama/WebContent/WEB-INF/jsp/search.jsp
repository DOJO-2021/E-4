<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">

<head>
	<!--情報-->
<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>質問検索</title>
	<link rel="stylesheet" href="css/search.css"><!--CSS読み込み-->
	<script type='text/javascript' src='//ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js?ver=1.11.3'></script>
	<script src="js/Search3.js"></script>		<!--検索ボタン空作動防止js-->
</head>
<body>
	<div class="wrapper">
		<div class="black">
			<!--ヘッダー背景-->
			<header class="header">
				<!--ヘッダー開始-->
				<nav class="nav">
					<ul>
						<li><a href="/Qsama/S_MainServlet">Qさま</a></li>
						<li><a href="/Qsama/ProfileServlet">マイページ</a></li>
						<li><a href="/Qsama/Question_postServlet">個別投稿</a></li>
						<li><a href="/Qsama/Question_allpostServlet">全体投稿</a></li>
						<li><a href="/Qsama/SearchServlet">検索</a></li>
						<li><a href="/Qsama/LogoutServlet">ログアウト</a></li>
					</ul>
				</nav>
			</header>
		</div>
	</div>

	<main>
		<!--メイン-->
		<div id="search_body" class="search_body">
			<div id="search_window" class="tabs2">
				<input id="teacher" type="radio" name="tab_item2" checked>
 				<label class="tab_item2" for="teacher">講師</label>
 				<input id="office" type="radio" name="tab_item2">
  				<label class="tab_item2" for="office">事務局</label>
				<div class="tab_content2" id="teacher_content">
				    <div class="tab_content_description">
				    	<div>
						<h3>質問検索</h3><!--質問窓-->
						<form method="POST" id="search_form" action="/Qsama/SearchServlet">
							<input type="search" id="search_word" class="search_word" name="s_word" size="50" placeholder="検索キーワード(例) JavaScript オブジェクト" autofocus required>
							<input type="submit" name="submit" value="検索">
						</form>
						</div>
				<div class="genre" style="width:50%; float:left;">
					<br>検索条件<br>
					<input type="radio" name="s1" value="and"> 全てのワードを含む<br>
					<input type="radio" name="s1" value="or"> いずれかのワードを含む<br>
				</div>
				<div class="pulldownset" style="float:left;">
					<br>ジャンル選択<br>
					<select class="major_items" name="m_items">
						<option value="" selected="selected">ジャンルを選択</option>
						<option value="HTML">HTML</option>
						<option value="CSS">CSS</option>
						<option value="JavaScript">Javascript</option>
						<option value="Java">Java</option>
						<option value="SQL">SQL</option>
						<option value="Servlet_JSP">ｻｰﾌﾞﾚｯﾄ・JSP</option>
						<option value="App">アプリケーション</option>
						<option value="Other">その他</option>
					</select><br>
					<select class="sub_item" name="s_item">
						<option value="" selected="selected">詳細ジャンルを選択</option>
						<option value="" data-val="HTML">基礎・基本的な書式</option>
						<option value="" data-val="HTML">見出し・段落・リスト</option>
						<option value="" data-val="HTML">テキスト・単語</option>
						<option value="" data-val="HTML">リンク・画像挿入</option>
						<option value="" data-val="HTML">class属性・id属性</option>
						<option value="" data-val="HTML">テーブル・フォーム</option>
						<option value="" data-val="HTML">グループ化</option>
						<option value="" data-val="HTML">その他</option>
						<option value="" data-val="CSS">基礎・基本的な書式</option>
						<option value="" data-val="CSS">装飾</option>
						<option value="" data-val="CSS">レイアウト</option>
						<option value="" data-val="CSS">パディング・マージン</option>
						<option value="" data-val="CSS">レスポンシブデザイン</option>
						<option value="" data-val="CSS">その他</option>
						<option value="" data-val="JavaScript">基礎</option>
						<option value="" data-val="JavaScript">アウトプット方法</option>
						<option value="" data-val="JavaScript">文法</option>
						<option value="" data-val="JavaScript">条件分岐・繰り返し</option>
						<option value="" data-val="JavaScript">関数作成</option>
						<option value="" data-val="JavaScript">配列</option>
						<option value="" data-val="JavaScript">イベント処理</option>
						<option value="" data-val="JavaScript">オブジェクト（Date,Mathなど）</option>
						<option value="" data-val="JavaScript">その他</option>
						<option value="" data-val="Java">基礎・基本的な書式</option>
						<option value="" data-val="Java">条件分岐・繰り返し</option>
						<option value="" data-val="Java">配列</option>
						<option value="" data-val="Java">メソッド</option>
						<option value="" data-val="Java">オブジェクト指向</option>
						<option value="" data-val="Java">継承</option>
						<option value="" data-val="Java">多態性</option>
						<option value="" data-val="Java">カプセル化</option>
						<option value="" data-val="Java">API</option>
						<option value="" data-val="Java">コレクション</option>
						<option value="" data-val="Java">例外</option>
						<option value="" data-val="Java">エラーメッセージ</option>
						<option value="" data-val="Java">その他</option>
						<option value="" data-val="Servlet_JSP">サーブレット</option>
						<option value="" data-val="Servlet_JSP">JSP</option>
						<option value="" data-val="Servlet_JSP">フォーム</option>
						<option value="" data-val="Servlet_JSP">MVCモデル</option>
						<option value="" data-val="Servlet_JSP">スコープ</option>
						<option value="" data-val="Servlet_JSP">アクションタグ</option>
						<option value="" data-val="Servlet_JSP">EL式</option>
						<option value="" data-val="Servlet_JSP">データベース</option>
						<option value="" data-val="Servlet_JSP">エラーメッセージ</option>
						<option value="" data-val="Servlet_JSP">その他</option>
						<option value="" data-val="SQL">データベースの基本</option>
						<option value="" data-val="SQL">検索 -select-</option>
						<option value="" data-val="SQL">内部結合・外部結合</option>
						<option value="" data-val="SQL">サブクエリ</option>
						<option value="" data-val="SQL">登録 -insert-</option>
						<option value="" data-val="SQL">更新 -update-</option>
						<option value="" data-val="SQL">削除 -delete-</option>
						<option value="" data-val="SQL">テーブル作成</option>
						<option value="" data-val="SQL">その他</option>
						<option value="" data-val="App">Eclipse</option>
 						<option value="" data-val="App">H2コンソール</option>
						<option value="" data-val="App">Git関係</option>
						<option value="" data-val="App">その他</option>
						<option value="" data-val="Other">講義全般</option>
    					<option value="" data-val="Other">その他</option>
					</select>
				</div>
				</div>
				</div>
				<div class="tab_content2" id="office_content">
				    <div class="tab_content_description">
						<div>
						<h3>質問検索</h3><!--質問窓-->
						<form method="POST" action="/Qsama/SearchServlet">
							<input type="text" class="input_items" name="s_word" size="50" placeholder="検索キーワード">
							<input type="submit" name="submit" value="検索">
						</form>
						</div>
				<div style="width:50%; float:left;">
					<br>検索条件<br>
					<input type="radio" name="s1" value="and"> 全てのワードを含む<br>
					<input type="radio" name="s1" value="or"> いずれかのワードを含む<br>
				</div>
				<div style="float:left;">
					<br>ジャンル選択<br>
					<select class="major_items2" name="m_items2">
						<option value="" selected="selected">ジャンルを選択</option>
						<option value="Procedure">事務手続き</option>
						<option value="Report">遅刻・欠席・退勤忘れ</option>
						<option value="S_other">その他</option>
					</select><br>
					<select class="sub_item2" name="s_item2">
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

				<!--ランキング窓-->
			<div class="tabs" style="float:left;">
				<input id="w_ranking" type="radio" name="tab_item" checked>
				<label class="tab_item" for="w_ranking">週間ランキング</label>
				<input id="a_ranking" type="radio" name="tab_item">
				<label class="tab_item" for="a_ranking">通期ランキング</label>
				<div class="tab_content" id="w_ranking_content">
					<div class="tab_content_description">
					<p class="c-txtsp">
					<h3>週間ランキング</h3>
						<ol class="ranking">
							<li>1位</li>
							<li>2位</li>
							<li>3位</li>
							<li>4位</li>
							<li>5位</li>
						</ol>
					</div>
				</div>
				<div class="tab_content" id="a_ranking_content">
					<div class="tab_content_description">
					<p class="c-txtsp">
					<h3>通期ランキング</h3>
						<ol class="ranking">
							<li>1位</li>
							<li>2位</li>
							<li>3位</li>
							<li>4位</li>
							<li>5位</li>
						</ol>
					</div>
				</div>
			</div>
		</div>

		<div id="search_results" class="search_results" style="clear:both;">
			<div id="result_body" class="result_body" style="clear:both;">
			<h3>検索結果</h3><br>
				<div class="cp_qa">
					<div class="cp_actab">
						<input id="cp_tabfour031" type="checkbox" name="tabs">
						<label for="cp_tabfour031">質問テキスト</label>
							<div class="cp_actab-content">
								<p>答えテキスト</p>
							</div>
					</div>
					<div class="cp_actab">
						<input id="cp_tabfour032" type="checkbox" name="tabs">
						<label for="cp_tabfour032">質問テキスト</label>
							<div class="cp_actab-content">
								<p>答えテキスト</p>
							</div>
					</div>
					<div class="cp_actab">
						<input id="cp_tabfour033" type="checkbox" name="tabs">
						<label for="cp_tabfour033">質問テキスト</label>
							<div class="cp_actab-content">
								<p>答えテキスト</p>
							</div>
					</div>
			</div>
		</div>
	</div>
	</main>

		<footer class="footer"><!--フッター-->
			<p>&copy; Copyright Qsama. All rights reserved</p>
		</footer>

		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script><!--jquery読み込み-->
		<script src="js/Search.js"></script>		<!--講師ジャンル表示用js-->
		<script src="js/Search2.js"></script>		<!--事務局ジャンル表示用js-->

	<!-- 戻るボタン
    受講者トップページへのリンク -->
  <a href="/Qsama/S_MainServlet">戻る</a>
</body>
</html>
