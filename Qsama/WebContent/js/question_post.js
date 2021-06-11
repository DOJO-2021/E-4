'use strict';

/**
 * セレクトボックス
   大カテゴリと中カテゴリを連動させる
 */

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

/* コピペ元ソースコード

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
*/

/**
 * タブ表示の切り替え
 */


$(function() {

  // ①タブをクリックしたら発動
  $('.Q_tab li').click(function() {

    // ②クリックされたタブの順番を変数に格納
    var index = $('.Q_tab li').index(this);

    // ③クリック済みタブのデザインを設定したcssのクラスを一旦削除
    $('.Q_tab li').removeClass('active');

    // ④クリックされたタブにクリック済みデザインを適用する
    $(this).addClass('active');

    // ⑤コンテンツを一旦非表示にし、クリックされた順番のコンテンツのみを表示
    $('.Q_list ul').removeClass('show').eq(index).addClass('show');

  });
});


/* ドラッグ＆ドロップ
   コピペ元

   export default {
  props: ["value"],
  data() {
    return {
      isDragOver: false
    };
  },
  computed: {
    image: {
      set(value) {
        this.$emit("input", value);
      },
      get() {
        return this.value;
      }
    }
  },
  methods: {
    onDrag(type) {
      this.isDragOver = type === "over";
    },
    onDrop(event) {
      this.isDragOver = false;
      const files = event.dataTransfer.files;
      if (files.length !== 1 || files[0].type.indexOf("image") !== 0) {
        return;
      }
      this.readImage(files[0]);
    },
    onChange(event) {
      const files = event.target.files;
      if (files.length !== 1 || files[0].type.indexOf("image") !== 0) {
        return;
      }
      this.readImage(files[0]);
    },
    readImage(file) {
      let reader = new FileReader();
      reader.onload = this.loadImage;
      reader.readAsDataURL(file);
    },
    loadImage(e) {
      let image = new Image();
      image.src = e.target.result;
      this.image = image;
    }
  }
};

*/
