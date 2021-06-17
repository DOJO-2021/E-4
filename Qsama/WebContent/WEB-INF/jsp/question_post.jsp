<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Qさま｜個別投稿</title>

<!-- JavaScript -->
<script src='//ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js?ver=1.11.3'></script>
<script type='text/javascript' src= "js/question_post.js"></script>
<!-- fontawesome -->
<link href="https://use.fontawesome.com/releases/v6.6.0-beta1/css/all.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/question_post.css">
</head>
<!-- body（ここから） -->
<body>
  <!-- ヘッダー -->
<jsp:include page="/WEB-INF/jsp/header.jsp" />

  <h1>個別投稿</h1>
  <main>

<!-- 質問タブ表示 -->
  <div class="cp_qa">
    <input id="cp_conttab1" type="radio" name="tabs" checked>
    <label for="cp_conttab1" class="cp_tabitem"><i class="fa-solid fa-circle-question"></i>最近多い質問</label>
    <input id="cp_conttab2" type="radio" name="tabs">
    <label for="cp_conttab2" class="cp_tabitem">よくある質問</label>

  <div id="cp_content1">
	<div class="cp_qain">
		<div class="cp_actab">
			<input id="cp_tabfour051" type="checkbox" name="tabs">
			<div class="cp_plus">+</div>
			<label for="cp_tabfour051">質問テキスト</label>
			<div class="cp_actab-content">答えテキスト</div>
		</div>
		<div class="cp_actab">
			<input id="cp_tabfour052" type="checkbox" name="tabs">
			<div class="cp_plus">+</div>
			<label for="cp_tabfour052">質問テキスト </label>
			<div class="cp_actab-content">答えテキスト</div>
		</div>
		<div class="cp_actab">
			<input id="cp_tabfour053" type="checkbox" name="tabs">
			<div class="cp_plus">+</div>
			<label for="cp_tabfour053">質問テキスト</label>
			<div class="cp_actab-content">答えテキスト</div>
		</div>
	</div>
  </div>
  
  <div id="cp_content2">
	<div class="cp_qain">
		<div class="cp_actab">
			<input id="cp_tabfour054" type="checkbox" name="tabs">
			<div class="cp_plus">+</div>
			<label for="cp_tabfour054">質問テキスト</label>
			<div class="cp_actab-content">答えテキスト</div>
		</div>

		<div class="cp_actab">
			<input id="cp_tabfour055" type="checkbox" name="tabs">
			<div class="cp_plus">+</div>
			<label for="cp_tabfour055">質問テキスト</label>
			<div class="cp_actab-content">答えテキスト</div>
		</div>
	</div>
  </div>
  
  </div>
  
  
   <!-- 投稿入力フォーム（ここから） -->
   <h2>投稿入力欄</h2>
   
  <!-- Qsama/image/* -->
  <form method="POST" action="/Qsama/Question_postServlet">
  <div class="form-wrapper">
    <div class="form1">
    <!-- 大カテゴリ (必須選択） -->
    <div class="question_cat">
      <select id="M_items" name="M_items">
        <option value=""> -- 大カテゴリ選択 -- </option>
        <option value="HTML">HTML</option>
        <option value="CSS">CSS</option>
        <option value="JavaScript">JavaScript</option>
        <option value="Java">Java</option>
        <option value="サーブレット・JSP">サーブレット・JSP</option>
        <option value="SQL">SQL</option>
        <option value="段位認定">段位認定</option>
        <option value="ドリル">ドリル</option>
        <option value="事務局">事務局</option>
      </select>
    </div>

    <!-- 中カテゴリ
      JavaScriptで大カテゴリと中カテゴリを連動させる
    -->
    <div class="question_cat">
      <select id="S_items" name="S_items">
        <option value="" data-category=""> -- 中カテゴリ選択 -- </option>
        <option value="基礎・基本的な書式" data-category="HTML">基礎・基本的な書式</option>
        <option value="見出し・段落・リスト" data-category="HTML">見出し・段落・リスト</option>
        <option value="テキスト・単語" data-category="HTML">テキスト・単語</option>
        <option value="リンク・画像挿入" data-category="HTML">リンク・画像挿入</option>
        <option value="class属性・id属性" data-category="HTML">class属性・id属性</option>
        <option value="テーブル・フォーム" data-category="HTML">テーブル・フォーム</option>
        <option value="グループ化" data-category="HTML">グループ化</option>
        <option value="その他" data-category="HTML">その他</option>
        <option value="基礎・基本的な書式" data-category="CSS">基礎・基本的な書式</option>
        <option value="装飾" data-category="CSS">装飾</option>
        <option value="レイアウト" data-category="CSS">レイアウト</option>
        <option value="パディング・マージン" data-category="CSS">パディング・マージン</option>
        <option value="レスポンシブデザイン" data-category="CSS">レスポンシブデザイン</option>
        <option value="その他" data-category="CSS">その他</option>
        <option value="基礎" data-category="JavaScript">基礎</option>
        <option value="アウトプット方法" data-category="JavaScript">アウトプット方法</option>
        <option value="文法" data-category="JavaScript">文法</option>
        <option value="条件分岐・繰り返し" data-category="JavaScript">条件分岐・繰り返し</option>
        <option value="関数作成" data-category="JavaScript">関数作成</option>
        <option value="配列" data-category="JavaScript">配列</option>
        <option value="イベント処理" data-category="JavaScript">イベント処理</option>
        <option value="オブジェクト（Date,Mathなど）" data-category="JavaScript">オブジェクト（Date,Mathなど）</option>
        <option value="その他" data-category="JavaScript">その他</option>
        <option value="基礎・基本的な書式" data-category="Java">基礎・基本的な書式</option>
        <option value="条件分岐・繰り返し" data-category="Java">条件分岐・繰り返し</option>
        <option value="配列" data-category="Java">配列</option>
        <option value="メソッド" data-category="Java">メソッド</option>
        <option value="オブジェクト指向" data-category="Java">オブジェクト指向</option>
        <option value="継承" data-category="Java">継承</option>
        <option value="多態性" data-category="Java">多態性</option>
        <option value="カプセル化" data-category="Java">カプセル化</option>
        <option value="API" data-category="Java">API</option>
        <option value="コレクション" data-category="Java">コレクション</option>
        <option value="例外" data-category="Java">例外</option>
        <option value="エラーメッセージ" data-category="Java">エラーメッセージ</option>
        <option value="その他" data-category="Java">その他</option>
        <option value="サーブレット" data-category="servlet_JSP">サーブレット</option>
        <option value="JSP" data-category="servlet_JSP">JSP</option>
        <option value="フォーム" data-category="servlet_JSP">フォーム</option>
        <option value="MVCモデル" data-category="servlet_JSP">MVCモデル</option>
        <option value="スコープ" data-category="servlet_JSP">スコープ</option>
        <option value="アクションタグ" data-category="servlet_JSP">アクションタグ</option>
        <option value="EL式" data-category="servlet_JSP">EL式</option>
        <option value="データベース" data-category="servlet_JSP">データベース</option>
        <option value="エラーメッセージ" data-category="servlet_JSP">エラーメッセージ</option>
        <option value="その他" data-category="servlet_JSP">その他</option>
        <option value="データベースの基本" data-category="SQL">データベースの基本</option>
        <option value="検索 -select-" data-category="SQL">検索 -select-</option>
        <option value="内部結合・外部結合" data-category="SQL">内部結合・外部結合</option>
        <option value="サブクエリ" data-category="SQL">サブクエリ</option>
        <option value="登録 -insert-" data-category="SQL">登録 -insert-</option>
        <option value="更新 -update-" data-category="SQL">更新 -update-</option>
        <option value="削除 -delete-" data-category="SQL">削除 -delete-</option>
        <option value="テーブル作成" data-category="SQL">テーブル作成</option>
        <option value="その他" data-category="SQL">その他</option>
        <option value="初段" data-category="rank">初段</option>
        <option value="2段" data-category="rank">2段</option>
        <option value="3段" data-category="rank">3段</option>
        <option value="その他" data-category="rank">その他</option>
        <option value="アルゴリズムドリル" data-category="drill">アルゴリズムドリル</option>
        <option value="SQLドリル" data-category="drill">SQLドリル</option>
        <option value="Javaドリル" data-category="drill">Javaドリル</option>
        <option value="その他" data-category="drill">その他</option>
        <option value="選択事項なし" data-category="office"> -- 選択事項なし --</option>
      </select>
    </div>

    <!-- 回答レベル選択 -->
    <div class="A_level">
      <select name="A_level">
        <option value=""> -- 回答レベル選択 --</option>
        <option value="0">ヒントが欲しい</option>
        <option value="1">回答が欲しい</option>
      </select>
    </div>


    <!-- 緊急レベル選択 -->
    <div class="emergency"> 緊急の場合は「はい」を選択してください。
      <input type="radio" name="emergency" value="0">はい
      <input type="radio" name="emergency" value="1" checked>いいえ
    </div>

    <!-- 質問内容入力フォーム -->
      <div class="Q_content">
        <label>質問内容<br>
          <textarea name="Q_content"></textarea>
        </label>
      </div>
   </div>
   <!-- class = form1 ここまで-->
 
    <!-- 画像添付欄 -->
    <div class="form2">
    <!-- enctypeは、送信時のデータ形式 -->
    
    <div id="dragDropArea">
       <div class="drag-drop-inside">
            <p class="drag-drop-info">ここにファイルをドロップ</p>
            <p>または</p>
            <p class="drag-drop-buttons">
                <input id="fileInput" type="file"  value="ファイルを選択" name="Postpic_url" onChange="photoPreview(event)" multiple>
            </p>
            <div id="previewArea"></div>
        </div>
     </div>
   </div>
   <!-- class = form2 ここまで-->
  
 </div>
 <!-- class = form-wrapper ここまで-->
   
    <!-- 投稿ボタン -->
    <div class="Q_submit">
      <input type="submit" name="Q_submit" value="投稿" >
    </div>
  
  </form>
<!-- 投稿入力フォーム（ここまで） -->


<!-- 戻るボタン
     受講者トップページへのリンク -->
  <a href="">戻る</a>
  </main>



<!-- フッター -->

</body>
<!-- body（ここまで） -->
</html>