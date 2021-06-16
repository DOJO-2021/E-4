<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Qsama | top</title>
<link rel="stylesheet" href="css/s_main.css">
</head>
<body>
<!-- 共通のヘッダー -->
<jsp:include page="/WEB-INF/jsp/header.jsp" />
<!-- 共通ヘッダーここまで -->

<!-- お知らせ -->
<div class="info">
  <h3>お知らせ</h3>
	<dl><dt>日付を表示</dt><dd>講師からの質問回答通知が入ります。</dd></dl>
	<dl><dt>日付を表示</dt><dd>講師からの質問回答通知が入ります。</dd></dl>
	<dl><dt>日付を表示</dt><dd>講師からの質問回答通知が入ります。</dd></dl>
	<dl><dt>日付を表示</dt><dd>講師からの質問回答通知が入ります。</dd></dl>
	<dl><dt>日付を表示</dt><dd>講師からの質問回答通知が入ります。</dd></dl>
</div>
<!-- お知らせここまで -->

<div class="box">
	<!-- よくある質問集 -->
	<div class="tabs">
	  <input id="html" type="radio" name="tab_item" checked>
	  <label class="tab_item" for="html">HTML</label>
	  <input id="css" type="radio" name="tab_item">
	  <label class="tab_item" for="css">CSS</label>
	  <input id="javascript" type="radio" name="tab_item">
	  <label class="tab_item" for="javascript">JavaScript</label>
	  <input id="java" type="radio" name="tab_item">
	  <label class="tab_item" for="java">Java</label>
	  <input id="sql" type="radio" name="tab_item">
	  <label class="tab_item" for="sql">SQL</label>

	  <div class="tab_content" id="html_content">
	    <div class="tab_content_description">
	      <p class="c-txtsp">HTMLの質問がここに入ります(ランキング形式)</p>
	      <ol>
	      	<li>質問内容</li>
	      	<li>質問内容</li>
	      	<li>質問内容</li>
	      	<li>質問内容</li>
	      	<li>質問内容</li>
	      	<li>質問内容</li>
	      </ol>
	    </div>
	  </div>
	  <div class="tab_content" id="css_content">
	    <div class="tab_content_description">
	      <p class="c-txtsp">CSSの質問がここに入ります(ランキング形式)</p>
   	      <ol>
	      	<li>質問内容</li>
	      	<li>質問内容</li>
	      	<li>質問内容</li>
	      	<li>質問内容</li>
	      	<li>質問内容</li>
	      	<li>質問内容</li>
	      </ol>
	    </div>
	  </div>
	  <div class="tab_content" id="javascript_content">
	    <div class="tab_content_description">
	      <p class="c-txtsp">JavaScriptの質問がここに入ります(ランキング形式)</p>
	      <ol>
	      	<li>質問内容</li>
	      	<li>質問内容</li>
	      	<li>質問内容</li>
	      	<li>質問内容</li>
	      	<li>質問内容</li>
	      	<li>質問内容</li>
	      </ol>
	    </div>
	  </div>
	  <div class="tab_content" id="java_content">
	    <div class="tab_content_description">
	      <p class="c-txtsp">Javaの質問がここに入ります(ランキング形式)</p>
	      <ol>
	      	<li>質問内容</li>
	      	<li>質問内容</li>
	      	<li>質問内容</li>
	      	<li>質問内容</li>
	      	<li>質問内容</li>
	      	<li>質問内容</li>
	      </ol>
	    </div>
	  </div>
	      <div class="tab_content" id="sql_content">
	    <div class="tab_content_description">
	      <p class="c-txtsp">SQLの質問がここに入ります(ランキング形式)</p>
    	  <ol>
	      	<li>質問内容</li>
	      	<li>質問内容</li>
	      	<li>質問内容</li>
	      	<li>質問内容</li>
	      	<li>質問内容</li>
	      	<li>質問内容</li>
	      </ol>
	    </div>
	  </div>
	</div>
	<!-- よくある質問集ここまで -->
	<!-- 最近の質問 -->
	<div class="content">
	<h3>最近の質問</h3>
	<c:forEach var="m" items="${Q_RecentList}">
		<label>${m.Q_content}</label>
		<label>${m.Q_date}</label>
		<label>${m.M_items}</label>
	</c:forEach>
	</div>
	<!-- 最近の質問ここまで -->
</div>

<!-- プロフィール -->
<div class="profile">
	<h3>プロフィール</h3>
</div>
<!-- プロフィールここまで -->

<!-- 共通のフッターー -->
<!-- 共通ヘッダーここまで -->
</body>
</html>