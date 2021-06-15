<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Qさま｜個別投稿</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.0/jquery.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!--
<script type="text/javascript" src="/Qsama_konno/js/question_post.js"></script>
 -->
<link rel="stylesheet" type="text/css" href="css/question_post.css">
</head>
<!-- body（ここから） -->
<body>
  <!-- ヘッダー -->


  <h1>個別投稿</h1>
  <main>

<!-- 質問タブ表示 -->
   <div class="cp_qa">
     <input id="cp_conttab1" type="radio" name="tabs" checked>
     <label for="cp_conttab1" class="cp_tabitem">最近多い質問</label>
     <input id="cp_conttab2" type="radio" name="tabs">
     <label for="cp_conttab2" class="cp_tabitem">よくある質問</label>
     
     <div id="cp_content1">
	 <div class="cp_qain">
		<div class="cp_actab">
			<input type="checkbox" name="tabs">
			<div class="cp_plus">+</div>
			<label>最近1</label>
			<div class="cp_actab-content">答えテキスト</div>
		</div>
		<div class="cp_actab">
			<input type="checkbox" name="tabs">
			<div class="cp_plus">+</div>
			<label>最近２</label>
			<div class="cp_actab-content">答えテキスト</div>
		</div>
	</div>
	</div>
	<div id="cp_content2">
	<div class="cp_qain">
		<div class="cp_actab">
			<input type="checkbox" name="tabs">
			<div class="cp_plus">+</div>
			<label>よくある１</label>
			<div class="cp_actab-content">答えテキスト</div>
		</div>
		<div class="cp_actab">
			<input type="checkbox" name="tabs">
			<div class="cp_plus">+</div>
			<label>よくある２</label>
			<div class="cp_actab-content">答えテキスト</div>
		</div>
		<div class="cp_actab">
			<input type="checkbox" name="tabs">
			<div class="cp_plus">+</div>
			<label>よくある３</label>
			<div class="cp_actab-content">答えテキスト</div>
		</div>
	</div>
</div>
     
   </div>

  <h2>投稿入力欄</h2>
<!-- 投稿入力フォーム（ここから） -->
  <!-- Qsama/image/* -->
  <form method="POST" action="/Qsama/Question_postServlet" accept="image/png, image/jpeg, image/jpg" enctype="multipart/form-data" >
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
      <option value="servlet_JSP">サーブレット・JSP</option>
      <option value="SQL">SQL</option>
      <option value="rank">段位認定</option>
      <option value="drill">ドリル</option>
      <option value="office">事務局</option>
    </select>
  </div>

  <!-- 中カテゴリ
  JavaScriptで大カテゴリと中カテゴリを連動させる
  -->
  <div class="question_cat">
    <select id="S_items" name="S_items">
      <option value="" data-category=""> -- 中カテゴリ選択 -- </option>
      <option value="base" data-category="HTML">基礎・基本的な書式</option>
      <option value="" data-category="HTML">見出し・段落・リスト</option>
      <option value="" data-category="HTML">テキスト・単語</option>
      <option value="" data-category="HTML">リンク・画像挿入</option>
      <option value="" data-category="HTML">class属性・id属性</option>
      <option value="" data-category="HTML">テーブル・フォーム</option>
      <option value="" data-category="HTML">グループ化</option>
      <option value="" data-category="HTML">その他</option>
      <option value="" data-category="CSS">基礎・基本的な書式</option>
      <option value="" data-category="CSS">装飾</option>
      <option value="" data-category="CSS">レイアウト</option>
      <option value="" data-category="CSS">パディング・マージン</option>
      <option value="" data-category="CSS">レスポンシブデザイン</option>
      <option value="" data-category="CSS">その他</option>
      <option value="" data-category="JavaScript">基礎</option>
      <option value="" data-category="JavaScript">アウトプット方法</option>
      <option value="" data-category="JavaScript">文法</option>
      <option value="" data-category="JavaScript">条件分岐・繰り返し</option>
      <option value="" data-category="JavaScript">関数作成</option>
      <option value="" data-category="JavaScript">配列</option>
      <option value="" data-category="JavaScript">イベント処理</option>
      <option value="" data-category="JavaScript">オブジェクト（Date,Mathなど）</option>
      <option value="" data-category="JavaScript">その他</option>
      <option value="" data-category="Java">基礎・基本的な書式</option>
      <option value="" data-category="Java">条件分岐・繰り返し</option>
      <option value="" data-category="Java">配列</option>
      <option value="" data-category="Java">メソッド</option>
      <option value="" data-category="Java">オブジェクト指向</option>
      <option value="" data-category="Java">継承</option>
      <option value="" data-category="Java">多態性</option>
      <option value="" data-category="Java">カプセル化</option>
      <option value="" data-category="Java">API</option>
      <option value="" data-category="Java">コレクション</option>
      <option value="" data-category="Java">例外</option>
      <option value="" data-category="Java">エラーメッセージ</option>
      <option value="" data-category="Java">その他</option>
      <option value="" data-category="servlet_JSP">サーブレット</option>
      <option value="" data-category="servlet_JSP">JSP</option>
      <option value="" data-category="servlet_JSP">フォーム</option>
      <option value="" data-category="servlet_JSP">MVCモデル</option>
      <option value="" data-category="servlet_JSP">スコープ</option>
      <option value="" data-category="servlet_JSP">アクションタグ</option>
      <option value="" data-category="servlet_JSP">EL式</option>
      <option value="" data-category="servlet_JSP">データベース</option>
      <option value="" data-category="servlet_JSP">エラーメッセージ</option>
      <option value="" data-category="servlet_JSP">その他</option>
      <option value="" data-category="SQL">データベースの基本</option>
      <option value="" data-category="SQL">検索 -select-</option>
      <option value="" data-category="SQL">内部結合・外部結合</option>
      <option value="" data-category="SQL">サブクエリ</option>
      <option value="" data-category="SQL">登録 -insert-</option>
      <option value="" data-category="SQL">更新 -update-</option>
      <option value="" data-category="SQL">削除 -delete-</option>
      <option value="" data-category="SQL">テーブル作成</option>
      <option value="" data-category="SQL">その他</option>
      <option value="" data-category="rank">初段</option>
      <option value="" data-category="rank">2段</option>
      <option value="" data-category="rank">3段</option>
      <option value="" data-category="rank">その他</option>
      <option value="" data-category="drill">アルゴリズムドリル</option>
      <option value="" data-category="drill">SQLドリル</option>
      <option value="" data-category="drill">Javaドリル</option>
      <option value="" data-category="drill">その他</option>
      <option value="" data-category="office"> -- 選択事項なし --</option>
    </select>
  </div>

  <!-- 回答レベル選択 -->
  <div class="A_level">
    <select name="A_level">
      <option value=""> -- 回答レベル選択 --</option>
      <option value=0>ヒントが欲しい</option>
      <option value=1>回答が欲しい</option>
    </select>
  </div>


  <!-- 緊急レベル選択 -->
  <div class="emergency">
    緊急の場合は「はい」を選択してください。
    <input type="radio" name="emergency" value=0>はい
    <input type="radio" name="emergency" value=1 checked>いいえ
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