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
  <c:forEach var="o" items="${NoticeList}">
	<dl>
		<dt>日付</dt>
	    <dd>
			${o.q_date}:${o.m_items}に対しての回答がきています！

	    </dd>
	</dl>
  </c:forEach>
</div>
<!-- お知らせここまで -->
<h3>解決済みの質問集</h3>
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
	  <input id="servlet" type="radio" name="tab_item">
	  <label class="tab_item" for="servlet">JSP</label>
	  <input id="jimukyoku" type="radio" name="tab_item">
	  <label class="tab_item" for="jimukyoku">事務局</label>
	  <input id="drill" type="radio" name="tab_item">
	  <label class="tab_item" for="drill">ドリル</label>
	  <input id="dani" type="radio" name="tab_item">
	  <label class="tab_item" for="dani">段位認定</label>


	  <div class="tab_content" id="html_content">
	    <div class="tab_content_description">
			<c:forEach var="h" items="${ResoledQList}">
				<p class="question">${h.q_content}</p>
				<p class="ans">A. ${h.a_content}</p>
				<hr>
			</c:forEach>
	    </div>
	  </div>
	  <div class="tab_content" id="css_content">
	    <div class="tab_content_description">
			<c:forEach var="h2" items="${ResoledQList2}">
				<p class="question">${h2.q_content}</p>
				<p class="ans">A. ${h2.a_content}</p>
				<hr>
			</c:forEach>
	    </div>
	  </div>
	  <div class="tab_content" id="javascript_content">
	    <div class="tab_content_description">
			<c:forEach var="h3" items="${ResoledQList3}">
				<p class="question">${h3.q_content}</p>
				<p class="ans">A. ${h3.a_content}</p>
				<hr>
			</c:forEach>
	    </div>
	  </div>
	  <div class="tab_content" id="java_content">
	    <div class="tab_content_description">
			<c:forEach var="h4" items="${ResoledQList4}">
				<p class="question">${h4.q_content}</p>
				<p class="ans">A. ${h4.a_content}</p>
				<hr>
			</c:forEach>
	    </div>
	  </div>
	      <div class="tab_content" id="sql_content">
	    <div class="tab_content_description">
			<c:forEach var="h5" items="${ResoledQList5}">
				<p class="question">${h5.q_content}</p>
				<p class="ans">A. ${h5.a_content}</p>
				<hr>
			</c:forEach>
	    </div>
	  </div>
	</div>
    <div class="tab_content" id="servlet_content">
      <div class="tab_content_description">
		  <c:forEach var="h6" items="${ResoledQList6}">
			    <p class="question">${h6.q_content}</p>
			    <p class="ans">A. ${h6.a_content}</p>
			    <hr>
		  </c:forEach>
      </div>
    </div>
	<div class="tab_content" id="jimukyoku_content">
	   <div class="tab_content_description">
			<c:forEach var="h7" items="${ResoledQList7}">
				<p class="question">${h7.q_content}</p>
				<p class="ans">A. ${h7.a_content}</p>
				<hr>
			</c:forEach>
	    </div>
	 </div>
	 <div class="tab_content" id="drill_content">
	    <div class="tab_content_description">
	      <p class="c-txtsp"></p>
			<c:forEach var="h8" items="${ResoledQList8}">
				<p class="question">${h8.q_content}</p>
				<p class="ans">A. ${h8.a_content}</p>
				<hr>
			</c:forEach>
	    </div>
	  </div>
	  <div class="tab_content" id="dani_content">
	    <div class="tab_content_description">
			<c:forEach var="h9" items="${ResoledQList9}">
				<p class="question">${h9.q_content}</p>
				<p class="ans">A. ${h9.a_content}</p>
				<hr>
			</c:forEach>
	    </div>
	  </div>
</div>

<h3>最近投稿されている質問</h3>
<div class="box2">
	<!-- 最近の質問 -->
	<div class="content">

		<c:forEach var="m" items="${RecentqList}">
			${m.q_date}:${m.m_items}
			<p class="q_list">${m.q_content}</p>
			<hr>
		</c:forEach>
	</div>
</div>
	<!-- 最近の質問ここまで -->
<!-- プロフィール -->
<!--  <div class="profile">
	<h3>プロフィール</h3>
</div>-->
<!-- プロフィールここまで -->

<!-- 共通のフッターー -->
<!-- 共通ヘッダーここまで -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<script src="js/s_main.js"></script>
</body>
</html>