/* 検索ボタン空作動防止 */

$(function(){
	// 1.フォーム要素の取得
	var search_form = $("#search_form");
	// 2.フォームのsubmitイベントを取得
	search_form.submit(function(){
		// 3.入力されているキーワードを取得し、正規表現により未入力かどうかを判別する
		var keyword = $('input[id=search_word]').val();
		if(keyword.match(/^[ 　\r\n\t]*$/)){
			return false;
		}
	});
});