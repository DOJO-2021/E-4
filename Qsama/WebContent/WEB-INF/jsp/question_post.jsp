<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Qさま｜個別投稿</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.0/jquery.min.js"></script>
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
  <div class="Q_tab">
    <input id="L_faq" type="radio" name="tab_name" checked>
    <label class="tab_name" for="L_faq">最近多い質問</label>
     <!-- コンテンツ表示 -->
    <div class="Q_tabCont" id="L_faq_Cont">
      <p>最近多い質問がここに入ります</p>
    </div>


    <input id="faq" type="radio" name="tab_name">
    <label class="tab_name" for="faq">よくある質問</label>
     <!-- コンテンツ表示 -->
    <div class="Q_tabCont" id="faq_Cont">
      <p>よくある質問がここに入ります</p>
    </div>

  </div>


  <h2>投稿入力欄</h2>
<!-- 投稿入力フォーム（ここから） -->
  <form>
  <div class="form-wrapper">
  <div class="form1">
  <!-- 大カテゴリ (必須選択） -->
  <div class="question_cat">
    <select id="Major_items" name="Major_items">
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
    <select id="Medium_item" name="Medium_item">
      <option value="" data-category=""> -- 中カテゴリ選択 -- </option>
      <option value="" data-category="HTML">基礎・基本的な書式</option>
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
  <div class="ans_items">
    <select name="ans_items">
      <option value=""> -- 回答レベル選択 --</option>
      <option value="hint">ヒントが欲しい</option>
      <option value="answer">回答が欲しい</option>
    </select>
  </div>


  <!-- 緊急レベル選択 -->
  <div class="emergency">
    緊急の場合は「はい」を選択してください。
    <input type="radio" name="emergency" value="yes">はい
    <input type="radio" name="emergency" value="no" checked>いいえ
  </div>

  <!-- 質問内容入力フォーム -->
    <div class="Q_cont">
      <label>質問内容<br>
        <textarea name="Q_area"></textarea>
      </label>
    </div>
 </div>
 <!-- class = form1 -->


  <!-- 画像添付欄 -->
  <div class="form2">
  <div class="drag-area">
    <div class="icon"><i class="fas fa-cloud-upload-alt"></i></div>
    <header>Drag & Drop to Upload File</header>
    <span>OR</span>
    <button>Browse File</button>
    <input type="file" type="hidden">
  </div>
  <!--
    <div id="drag-and-drop-area">
      <div>画像をドラッグ＆ドロップ<br>またはクリックでファイル選択</div>
    </div>

    <h4>プレビュー</h4>
    <div id="previews"></div>

    <div id="file-select">
      <input type="file" class="hidden" accept="image/*" id="file-select-input">
      <button type="button" id="file-select-button">ファイル選択</button>
    </div>
  </div>
  -->
  <!-- class = form2 -->

  </div>
  <!-- class = form-wrapper -->
  </div>
  <!-- 投稿ボタン -->
  <div class="Q_submit">
    <input type="submit" name="Q_submit" value="投稿">
  </div>
  </form>

<!-- 投稿入力フォーム（ここまで） -->


<!-- 戻るボタン
     受講者トップページへのリンク -->
  <a href="/Qsama/S_MainServlet">戻る</a>
  </main>

<!-- フッター -->

</body>
<!-- body（ここまで） -->

<script>

/* カテゴリ連動 */
document.addEventListener("DOMContentLoaded", function(){
    // 初期値が設定されている場合は最上位を選択させない
    var firstChange = ($("#Medium_item").val() == "");

    $("#Major_items").on("change",function(){
        if(firstChange){
            // 最上位を選択（現在選択項目を解除）
            $("#Medium_item option[value='']").prop('selected',true);
        }
        firstChange = true;

        $("#Medium_item option").hide();
        $("#Medium_item option[data-category='']").show();
        $("#Medium_item option[data-category=" + this.value + "]").show();
    }).change();
});

/* テキストエリアのサイズ可変 */
function flexTextarea(el) {
  const dummy = el.querySelector('.FlexTextarea__dummy')
  el.querySelector('.FlexTextarea__textarea').addEventListener('input', e => {
    dummy.textContent = e.target.value + '\u200b'
  })
}

document.querySelectorAll('.FlexTextarea').forEach(flexTextarea)


/* 画像添付 */


 //selecting all required elements
const dropArea = document.querySelector(".drag-area"),
dragText = dropArea.querySelector("header"),
button = dropArea.querySelector("button"),
input = dropArea.querySelector("input");
let file; //this is a global variable and we'll use it inside multiple functions
button.onclick = ()=>{
  input.click(); //if user click on the button then the input also clicked
}
input.addEventListener("change", function(){
  //getting user select file and [0] this means if user select multiple files then we'll select only the first one
  file = this.files[0];
  dropArea.classList.add("active");
  showFile(); //calling function
});
//If user Drag File Over DropArea
dropArea.addEventListener("dragover", (event)=>{
  event.preventDefault(); //preventing from default behaviour
  dropArea.classList.add("active");
  dragText.textContent = "Release to Upload File";
});
//If user leave dragged File from DropArea
dropArea.addEventListener("dragleave", ()=>{
  dropArea.classList.remove("active");
  dragText.textContent = "Drag & Drop to Upload File";
});
//If user drop File on DropArea
dropArea.addEventListener("drop", (event)=>{
  event.preventDefault(); //preventing from default behaviour
  //getting user select file and [0] this means if user select multiple files then we'll select only the first one
  file = event.dataTransfer.files[0];
  showFile(); //calling function
});
function showFile(){
  let fileType = file.type; //getting selected file type
  let validExtensions = ["image/jpeg", "image/jpg", "image/png"]; //adding some valid image extensions in array
  if(validExtensions.includes(fileType)){ //if user selected file is an image file
    let fileReader = new FileReader(); //creating new FileReader object
    fileReader.onload = ()=>{
      let fileURL = fileReader.result; //passing user file source in fileURL variable
        // UNCOMMENT THIS BELOW LINE. I GOT AN ERROR WHILE UPLOADING THIS POST SO I COMMENTED IT
      // let imgTag = `<img src="${fileURL}" alt="image">`; //creating an img tag and passing user selected file source inside src attribute
      dropArea.innerHTML = imgTag; //adding that created img tag inside dropArea container
    }
    fileReader.readAsDataURL(file);
  }else{
    alert("This is not an Image File!");
    dropArea.classList.remove("active");
    dragText.textContent = "Drag & Drop to Upload File";
  }
}





// ファイル選択ボタン, ドラッグ＆ドロップ領域のクリックでファイル選択ダイアログ
/*
document.querySelectorAll('#file-select-button, #drag-and-drop-area').forEach((ele) => {
  ele.addEventListener('click', () => {
    document.getElementById('file-select-input').click();
  });
});

// ファイル選択後
document.getElementById('file-select-input').addEventListener('change', (event) => {
  const files = event.target.files;
  if (files.length > 0) {
    previewAndInsert(files);
  }
  event.target.files = null;
  event.target.value = null;
});

const dragAndDropArea = document.getElementById('drag-and-drop-area');

// ドラッグ中
dragAndDropArea.addEventListener('dragover', (event) => {
  dragAndDropArea.classList.add('active');
  event.preventDefault();
  event.dataTransfer.dropEffect = 'copy';
});

// マウスがドラッグ＆ドロップ領域外に出たとき
dragAndDropArea.addEventListener('dragleave', (event) => {
  dragAndDropArea.classList.remove('active');
});

// ドロップ時
dragAndDropArea.addEventListener('drop', (event) => {
  event.preventDefault();
  dragAndDropArea.classList.remove('active');
  const files = event.dataTransfer.files;
  if (files.length === 0) {
    return;
  }

  // 画像ファイルのみ OK
  if (!files[0].type.match(/image\/*/
//		  )) {
/*    return;
  }

  previewAndInsert(files);
});

// 画像プレビューと input 追加
const previewAndInsert = (files) => {
  const file = files[0];

  const wrapper = document.createElement('div');

  const input = document.createElement('input');
  input.type = 'file';
  input.classList.add('hidden');
  // https://qiita.com/jkr_2255/items/1c30f7afefe6959506d2
  if (files.length > 1 && typeof DataTransfer !== 'undefined') {
    const dt = new DataTransfer();
    dt.items.add(files[0]);
    input.files = dt.files;
  } else {
    input.files = files;
  }
  wrapper.appendChild(input);

  const img = document.createElement('img');
  const reader = new FileReader();
  reader.onload = (event) => {
    img.src = event.target.result;
    updateHTMLCode();
  }
  reader.readAsDataURL(file);
  wrapper.appendChild(img);

  document.getElementById('previews').appendChild(wrapper);
}
*/
</script>

</html>