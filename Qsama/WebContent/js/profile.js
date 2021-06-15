'use strict';

//編集をクリックすると自己紹介の項目を表示する

//編集ボタンをクリックでアクションを起こす
 function OnButtonClick() {
    target = document.getElementByname("edit");
 }

 var id = document.getElementById('form');     //HTML要素のform要素を取得

//ユーザがブラウザに入力した情報の取得
document.forms("company         :    " + location.company);
document.forms("my_class        :    " + location.my_class);
document.forms("name            :    " + location.name);
document.forms("experience      :    " + location.experience);
document.forms("bloodtype       :    " + location.boodtype);
document.forms("birthday        :    " + location.birthday);
document.forms("college         :    " + location.college);
document.forms("undergraduate   :    " + location.undergraduate);
document.forms("hobby           :    " + location.hobby);
document.forms("special_skill   :    " + location.special_skill);
document.forms("qualification   :    " + location.qualification);
document.forms("favorite        :    " + location.favorite);
document.forms("comment         :    " + location.comment);

//削除ボタンのクリックでアクションを起こす
function OnButtonClick() {
    target = document.getElementByname("reset");
}

//ファイル（画像）アップロード

var file = document.getElementById('file');
var result = document.getElementById('result');

function loadLocalImage(e) {
  // ファイル情報を取得
  var fileData = e.target.files[0];

  // 画像ファイル以外は処理を止める
  if(!fileData.type.match('image.*')) {
    alert('画像を選択してください');
    return;
  }

  // FileReaderオブジェクトを使ってファイル読み込み
  var reader = new FileReader();
  // ファイル読み込みに成功したときの処理
  reader.onload = function() {
    // ブラウザ上に画像を表示する
    var img = document.createElement('img');
    img.src = reader.result;
    result.appendChild(img);
  }
  // ファイル読み込みを実行
  reader.readAsDataURL(fileData);
}

// ファイルが指定された時にloadLocalImage()を実行
file.addEventListener('change', loadLocalImage, false);