/* --------モーダルウィンドウ 一覧表示--------*/

$(function(){
    $('.js-modal-open').each(function(){
        $(this).on('click',function(){
            var target = $(this).data('target');
            var modal = document.getElementById(target);
            $(modal).fadeIn();
            return false;
        });
    });
    $('.js-modal-close').on('click',function(){
        $('.js-modal').fadeOut();
        return false;
    });
});

/* ------「非公開」→「公開」submit------*/
function formsubmit() {
	var res = window.confirm("「公開」に設定します。よろしいですか？」");

	if( res == true ) {
		frm = document.answer_form;
		frm.action="/Qsama/AdminServlet";
		frm.submit();
	}else {
        alert("「公開」をキャンセルしました");
        return false;
    }
 }

/* ------「公開」→「非公開」submit------*/
function formsubmit2() {
	var res = window.confirm("「公開」を停止します。よろしいですか？」");

	if( res == true ) {
		frm = document.answer_form;
		frm.action="/Qsama/AdminServlet";
		frm.submit();
	}else {
        alert("「公開停止」をキャンセルしました");
        return false;
    }
 }

/* ------「受講者別質問検索」submit------*/
function personalsubmit() {
	frm = document.answer_form;
	frm.action="/Qsama/AdminServlet";
	frm.submit();
	}

/* ------「select」を変更したら即submit------
$(function(){
  $("#personal_items").change(function(){
    $("#personal_form").submit();
  });
});											*/