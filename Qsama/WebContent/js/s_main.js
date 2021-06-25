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

/* ----フェードイン機能---- */
/* 過去の質問
  // オプションを追加し、アニメーションをカスタマイズ可能
  ScrollReveal().reveal('.content', {
    duration: 1200, // アニメーションの完了にかかる時間
    scale:0.1,
    reset: true   // 何回もアニメーション表示するか
  });
  */

/* タブコンテンツ*/
$(document).ready(function() {
	$(".tab_content").hide();							//タブコンテンツの中身を全て隠す
	$("label:first").addClass("active").show();	 		//ラベルの一番最初を追加
	$(".tab_content:first").show();						//コンテンツの中身を表示

	$("label").click(function() {						//クリックされたら
		$("label").removeClass("active");				//"active"のラベルを削除
		$(this).addClass("active");						//クリックされたラベル追加
		$(".tab_content").hide();						//タブコンテンツの中身を全て隠す
		var activeTab = $(this).find("a").attr("href");	//activeTabにaタグでidを代入
		$(activeTab).fadeIn(1000);						//フェードインさせて表示
		return false;
	});
});


/* 選択されたタブの色を切り替える */
