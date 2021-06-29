'use strict';


/* ----------------------- カテゴリ連動 ----------------------- */

document.addEventListener("DOMContentLoaded", function(){
    // 初期値が設定されている場合は最上位を選択させない
    var firstChange = ($("#subcategory").val() == "");

    $("#maincategory").on("change",function(){
        if(firstChange){
            // 最上位を選択（現在選択項目を解除）
            $("#subcategory option[value='']").prop('selected',true);
        }
        firstChange = true;

        $("#subcategory option").hide();
        $("#subcategory option[data-category='']").show();
        $("#subcategory option[data-category=" + this.value + "]").show();
    }).change();
});


/* -------------------- テキストエリアのサイズ可変 --------------------- */

  function flexTextarea(el) {
    const dummy = el.querySelector('.FlexTextarea__dummy')
    el.querySelector('.FlexTextarea__textarea').addEventListener('input', e => {
      dummy.textContent = e.target.value + '\u200b'
    })
  }

  document.querySelectorAll('.FlexTextarea').forEach(flexTextarea)


/* ----------------------- 画像添付 ： input要素 ----------------------- */

  // ドロップ有効範囲
    var fileArea = document.getElementById('dragDropArea');


  // ファイル選択ボタン
    var fileInput = document.getElementById('fileInput');


  //ドロップ有効範囲上
    fileArea.addEventListener('dragover',function(evt) {
    //  evt.stopPropagation();
      evt.preventDefault();

      this.style.background = '#e1e7f0';
      fileArea.classList.add('dragover');
    });


  // ドロップ有効範囲外
    fileArea.addEventListener('dragleave', function(evt) {
    //  evt.stopPropagation();
      evt.preventDefault();

      this.style.background = '#ffffff';
      fileArea.classList.remove('dragover');
    });


   // ファイルをドロップしたとき
    fileArea.addEventListener('drop', function(evt) {
	//  evt.stopPropagation();
      evt.preventDefault();
      fileArea.classList.remove('dragenter');



      var files = evt.dataTransfer.files;       // drag&dropでのファイル取得（ここが配列！）

		// sendFiles(evt.originalEvent.dataTransfer.files, 'Qsama/images/*');

        console.log("DRAG & DROP");      // OK
        console.table(files);            // ファイル数確認OK


    // 取得したファイルをinput[type=file]へ
      fileInput.files = files;

     //   console.table(fileInput.files);              // ファイル数確認OK filesと一致
        photoPreview('onChenge',files[0]);

    });


  // プレビュー機能
    function photoPreview(evt, f = null) {
      var file = f;
      if(file === null){

         file = evt.target.files[0];

    }

  /* FileReaderで読み込み、プレビュー画像を表示。 */
//   for (i = 0; i < files.length; i++) {

      var reader = new FileReader();
      var preview = document.getElementById("previewArea");
      var previewImage = document.getElementById("previewImage");

    if(previewImage != null) {
      preview.removeChild(previewImage);
    }


    reader.onload = function(event) {

    var img = document.createElement("img");
    img.setAttribute("src", reader.result);
    img.setAttribute("id", "previewImage");
    preview.appendChild(img);
   };

    reader.readAsDataURL(file);
    console.log(file);             // ファイル情報取得  ここが一個しか取れてない
  }



/* ---------------------------  notNull制約部分が未記入・未選択で投稿した場合  ---------------------------- */
  
    document.getElementById('form').onsubmit = function(event) {
      const M_items = document.getElementById('form').M_items.value;         // 大項目
      const Q_content = document.getElementById('form').Q_content.value;     // 質問内容


      if (M_items != "" && Q_content != ""){
			console.log('登録成功');
			window.alert('投稿完了しました！');


		} else if (M_items === "" && Q_content != "") {
			event.preventDefault();
			window.alert('投稿失敗！未入力項目があります。');
			document.getElementById('output1').textContent = '大カテゴリは必須選択です';


		} else if (M_items != "" && Q_content === "") {
			event.preventDefault();
			window.alert('投稿失敗！未入力項目があります。');
			document.getElementById('output2').textContent = '質問内容を入力してください';


		} else {
			event.preventDefault();
			window.alert('投稿失敗！未入力項目があります。');
			document.getElementById('output1').textContent = '大カテゴリは必須選択です';
			document.getElementById('output2').textContent = '質問内容を入力してください';
		}
	 };


  
