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

/* フェードイン機能 */
/*
  // htmlで付与したクラス単位で、アニメーションを追加する
  ScrollReveal().reveal('.content');

  // オプションを追加し、アニメーションをカスタマイズ可能
  ScrollReveal().reveal('.content', {
    duration: 1000, // アニメーションの完了にかかる時間
    reset: true   // 何回もアニメーション表示するか
  });
*/

