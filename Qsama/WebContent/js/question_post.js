'use strict';


/* ----------------------- カテゴリ連動 ----------------------- */

  document.addEventListener("DOMContentLoaded", function(){
  
    // 初期値が設定されている場合は最上位を選択させない
    var firstChange = ($("#S_items").val() == "");

    $("#M_items").on("change",function(){
        if(firstChange){
            // 最上位を選択（現在選択項目を解除）
            $("#S_items option[value='']").prop('selected',true);
        }
        
        firstChange = true;

        $("#S_items option").hide();
        $("#S_items option[data-category='']").show();
        $("#S_items option[data-category=' + this.value + ']").show();
    }).change();
});


/*  ----------------------- + アイコンの回転 と id/forの変更----------------------- */

	// ここがうまくできない！！！！！


   /* 読み込み時にファンクション  */
   
   window.addEventListener('load', function() {
   
     // id属性,for属性の変更・自動生成
     const moji = 'cp_tabfour05'
     var input_id = document.getElementById('cp_tabfour051');        // id
     var label_for = $('label').prop('label.htmlFor');               // for jQuery以外の記述方法見つからない
   
   for(var i=0; i<input_id.length; i++){
   
     input_id[i].setAttribute('id', moji + (i+1) );
     label_for[i].setAttribute('label.htmlFor', moji + (i+1) );
     
     console.log('for属性：' + label_for[i] + ',id属性' + input_id[i]);
     
   }
   
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
      var files = evt.dataTransfer.files;       // drag&dropでのファイル取得
        console.log("DRAG & DROP");
        console.table(files);
	
  // 取得したファイルをinput[type=file]へ
    fileInput.files = files;
      console.table(files);
      
    photoPreview('onChenge',files[0]);
    });


  // プレビュー機能
    function photoPreview(event, f = null) {
      var file = f;
      if(file === null){
        file = event.target.files[0];
    }

  /* FileReaderで読み込み、プレビュー画像を表示。 */
//  for (i = 0; i < files.length; i++) {
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
    console.log(file);             // ファイル情報取得
  }



/* ---------  ファイルの自動アップデート  --------- */

/*
  var formData = new FormData();
  for (var i = 0; i < files.length; i++) {
    formData.append('file', files[i]);
  }

  //XMLHttpRequestオブジェクトを作成
    var xhr = new XMLHttpRequest();
    xhr.open('POST', 'Sample/image/*');
    
    xhr.onload = function () {
      if (xhr.status === 200) {    //レスポンスが持っているHTTPのステータスコードが200であることを確認
        console.log('all done: ' + xhr.status);
      } else {
        console.log('Something went terribly wrong...');
      }
    };

    xhr.send(formData);
*/
  