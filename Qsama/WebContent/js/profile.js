'use strict';

	/** ----------------編集ボタン1---------------- **/
function OnButtonClick(){
    let array1 = ["A1", "A2", "A3", "A4", "A5", "A6", "A7", "A8", "A9", "A10", "A11", "A12", "A13"];
    for(let i=0; i<array1.length; i++){

		/* inputのon・off */
        if (document.getElementById(array1[i]).hidden === true){
            // hidden属性を削除
            document.getElementById(array1[i]).hidden = "";
            document.getElementById(array1[i]).style.color = "black";
        }else{
            // hidden属性を設定
            document.getElementById(array1[i]).hidden = "true";
            document.getElementById(array1[i]).style.color = "White";
        }
    }
		/* 画像アップロードボタン1のon・off */
		if (document.getElementById("file").hidden === true){
            // hidden属性を削除
            document.getElementById("file").hidden = "";
        }else{
            // hidden属性を設定
            document.getElementById("file").hidden = "true";
        }
        	/* 画像アップロードボタン2のon・off */
		if (document.getElementById("file2").hidden === true){
            // hidden属性を削除
            document.getElementById("file2").hidden = "";
        }else{
            // hidden属性を設定
            document.getElementById("file2").hidden = "true";
        }

         	/* HTML書換　背景画像部分 */
		var result = document.getElementById('result');
		result.innerHTML = '<canvas id="preview"><canvas>';

 		/* 編集・編集決定・リセットボタンのon・off */

   		if(document.getElementById("h_edit").style.display="inline"){
			 document.getElementById("h_edit").style.display="none";		// 編集 非表示
			 document.getElementById("h_reset").style.display="inline";		// リセット 表示
 			 document.getElementById("h_submit").style.display="inline";	// 決定 表示
 		}
 }
	/** ----------------編集ボタン2---------------- **/
function OnButtonClick2(){
    let array1 = ["A1", "A2", "A3", "A4", "A5", "A6", "A7", "A8", "A9", "A10", "A11", "A12", "A13"];
    for(let i=0; i<array1.length; i++){

		/* inputのon・off */
        if (document.getElementById(array1[i]).hidden === true){
            // hidden属性を削除
            document.getElementById(array1[i]).hidden = "";
            document.getElementById(array1[i]).style.color = "black";
        }else{
            // hidden属性を設定
            document.getElementById(array1[i]).hidden = "true";
            document.getElementById(array1[i]).style.color = "White";
        }
    }
		/* 画像アップロードボタン1のon・off */
		if (document.getElementById("file").hidden === true){
            // hidden属性を削除
            document.getElementById("file").hidden = "";
        }else{
            // hidden属性を設定
            document.getElementById("file").hidden = "true";
        }
        	/* 画像アップロードボタン2のon・off */
		if (document.getElementById("file2").hidden === true){
            // hidden属性を削除
            document.getElementById("file2").hidden = "";
        }else{
            // hidden属性を設定
            document.getElementById("file2").hidden = "true";
        }

         	/* 編集・編集決定・リセットボタンのon・off */
 		if(document.getElementById("h_reset").style.display="inline"){
 			document.getElementById("h_edit").style.display="inline";	// 編集 表示
 			document.getElementById("h_reset").style.display="none";	// リセット 非表示
 			document.getElementById("h_submit").style.display="none";	// 決定 非表示
 		}

         	/* HTML書換　背景画像部分 */
		var result = document.getElementById('result');
		result.innerHTML = '<c:forEach var="pr" items="${ProfileList}" varStatus="pri"><img src="${pr.back_url}" align="middle"></c:forEach>';
}
	/* ----------------背景画像の編集---------------- */
	function previewImage(obj){

		var fileReader = new FileReader();

		// 読み込み後に実行する処理
		fileReader.onload = (function() {

			// canvas にプレビュー画像を表示
			var canvas = document.getElementById('preview');
			var ctx = canvas.getContext('2d');
			var image = new Image();
			image.src = fileReader.result;

			image.onload = (function () {
				canvas.width = image.width;
				canvas.height = image.height;
				ctx.drawImage(image, 0, 0);
			});
		});
		// 画像読み込み
		fileReader.readAsDataURL(obj.files[0]);
	}

	/* ----------------顔写真の編集---------------- */
	function previewImage2(obj2){

		var fileReader2 = new FileReader();

		// 読み込み後に実行する処理
		fileReader2.onload = (function() {

			// canvas2 にプレビュー画像を表示
			var canvas2 = document.getElementById('preview2');
			var ctx2 = canvas.getContext('2d');
			var image2 = new Image();
			image2.src = fileReader2.result;

			image2.onload = (function () {
				canvas2.width = image2.width;
				canvas2.height = image2.height;
				ctx2.drawImage(image2, 0, 0);
			});
		});
		// 画像読み込み
		fileReader.readAsDataURL(obj2.files[1]);
	}

	/* ------投稿内容の「削除」submit------*/
	function ppsubmit1() {
		var res = window.confirm("本質問を「削除」いたします。よろしいですか？");

		if( res == true ) {
			frm = document.answer_form;
			frm.action="/Qsama/ProfileServlet";
			frm.submit();
	    }
	    else {
	        alert("「削除」をキャンセルしました");
	        return false;
	    }
	}

	/* ------投稿内容の「解決」submit------*/
	function ppsubmit2() {
		var res = window.confirm("本質問を「解決済」といたします。よろしいですか？");

		if( res == true ) {
			frm = document.answer_form;
			frm.action="/Qsama/ProfileServlet";
			frm.submit();
		}else {
	        alert("「解決済」をキャンセルしました");
	        return false;
	    }
	 }
