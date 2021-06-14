/* ジャンル表示 事務局側*/

var $children = $('.sub_item2');
var original = $children.html();

$('.major_items2').change(function() {

  var val1 = $(this).val();

  $children.html(original).find('option').each(function() {
    var val2 = $(this).data('val');

    if (val1 != val2) {
      $(this).not(':first-child').remove();
    }
  });
});