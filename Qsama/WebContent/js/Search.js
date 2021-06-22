/* ジャンル表示 講師側*/

var $children = $('.sub_item');
var original = $children.html();

$('.major_items').change(function() {

  var val1 = $(this).val();

  $children.html(original).find('option').each(function() {
    var val2 = $(this).data('val');

    if (val1 != val2) {
      $(this).not(':first-child').remove();
    }
  });
});

/* ジャンル表示 事務局側*/

var $children2 = $('.sub_item2');
var original2 = $children.html();

$('.major_items2').change(function() {

  var val3 = $(this).val();

  $children2.html(original2).find('option').each(function() {
    var val4 = $(this).data('val');

    if (val3 != val4) {
      $(this).not(':first-child').remove();
    }
  });
});