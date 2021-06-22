/**
 *
 */
'use strict';
/* 解決済み質問のアコーディオン機能 */
$(document).ready(function(){
 $("p.question").on("click", function() {
  $("p.question").not(this).removeClass("open");
  //クリックしたquestion以外の全てのopenを取る

  $("p.question").not(this).next().slideUp(350);
  //クリックされたquestion以外のanswerを閉じる

  $(this).toggleClass("open");
  //thisにopenクラスを付与

  $(this).next().slideToggle(200);
 });
});
