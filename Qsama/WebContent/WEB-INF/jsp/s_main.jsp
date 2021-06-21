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
	<dl>
	  <dt>日付を表示</dt>
	    <dd><c:forEach var="o" items="${NoticeList}">
			${o.a_flag}講師から質問の回答がきています！
			</c:forEach>
	    </dd>
	</dl>

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
	  <input id="servlet" type="radio" name="tab_item">
	  <label class="tab_item" for="servlet">JSP</label>
	  <input id="jimukyoku" type="radio" name="tab_item">
	  <label class="tab_item" for="jimukyoku">事務局</label>
	  <input id="dani" type="radio" name="tab_item">
	  <label class="tab_item" for="dani">段位認定</label>
	  <input id="drill" type="radio" name="tab_item">
	  <label class="tab_item" for="drill">ドリル</label>


	  <!-- 現状で表示はHTMLの表示しかできていないが、データの受け渡しは
	       上手くいているのでCSS,JSPの問題 -->

	  <div class="tab_content" id="html_content">
	    <div class="tab_content_description">
			<c:forEach var="h" items="${ResoledQList}">
				${h.m_items}
				${h.q_flag}
				<p class="q_list">${h.q_content}</p>
				<hr>
			</c:forEach>
	    </div>
	  </div>
	  <div class="tab_content" id="css_content">
	    <div class="tab_content_description">
	      <p class="c-txtsp">CSSの質問がここに入ります(ランキング形式)</p>
			<c:forEach var="h2" items="${ResoledQList2}">
				${h2.m_items}
				${h2.q_flag}
				<p class="q_list">${h2.q_content}</p>
				<hr>
			</c:forEach>
	    </div>
	  </div>
	  <div class="tab_content" id="javascript_content">
	    <div class="tab_content_description">
	      <p class="c-txtsp">JavaScriptの質問がここに入ります(ランキング形式)</p>
			<c:forEach var="h3" items="${ResoledQList3}">
				${h3.m_items}
				${h3.q_flag}
				<p class="q_list">${h3.q_content}</p>
				<hr>
			</c:forEach>
	    </div>
	  </div>
	  <div class="tab_content" id="java_content">
	    <div class="tab_content_description">
	      <p class="c-txtsp">Javaの質問がここに入ります(ランキング形式)</p>
			<c:forEach var="h4" items="${ResoledQList4}">
				${h4.m_items}
				${h4.q_flag}
				<p class="q_list">${h4.q_content}</p>
				<hr>
			</c:forEach>
	    </div>
	  </div>
	      <div class="tab_content" id="sql_content">
	    <div class="tab_content_description">
	      <p class="c-txtsp">SQLの質問がここに入ります(ランキング形式)</p>
			<c:forEach var="h5" items="${ResoledQList5}">
				${h5.m_items}
				${h5.q_flag}
				<p class="q_list">${h5.q_content}</p>
				<hr>
			</c:forEach>
	    </div>
	  </div>
	</div>
    <div class="tab_content" id="servlet_content">
      <div class="tab_content_description">
        <p class="c-txtsp">サーブレット・JSPの質問がここに入ります(ランキング形式)</p>
		  <c:forEach var="h6" items="${ResoledQList6}">
			${h6.m_items}
			${h6.q_flag}
			<p class="q_list">${h6.q_content}</p>
			<hr>
		  </c:forEach>
      </div>
    </div>
	 <div class="tab_content" id="jimukyoku_content">
	   <div class="tab_content_description">
	     <p class="c-txtsp">事務局の質問がここに入ります(ランキング形式)</p>
			<c:forEach var="h7" items="${ResoledQList7}">
				${h7.m_items}
				${h7.q_flag}
				<p class="q_list">${h7.q_content}</p>
				<hr>
			</c:forEach>
	    </div>
	 </div>
	 <div class="tab_content" id="dani_content">
	    <div class="tab_content_description">
	      <p class="c-txtsp">段位認定の質問がここに入ります(ランキング形式)</p>
			<c:forEach var="h8" items="${ResoledQList8}">
				${h8.m_items}
				${h8.q_flag}
				<p class="q_list">${h8.q_content}</p>
				<hr>
			</c:forEach>
	    </div>
	  </div>
	  <div class="tab_content" id="drill_content">
	    <div class="tab_content_description">
	      <p class="c-txtsp">ドリルの質問がここに入ります(ランキング形式)</p>
			<c:forEach var="h9" items="${ResoledQList9}">
				${h9.m_items}
				${h9.q_flag}
				<p class="q_list">${h9.q_content}</p>
				<hr>
			</c:forEach>
	    </div>
	  </div>
	<!-- よくある質問集ここまで -->
	<!-- 最近の質問 -->
	<div class="content">
		<h3>最近の質問</h3>
		<c:forEach var="m" items="${RecentqList}">
			${m.q_date}:${m.m_items}
			<p class="q_list">${m.q_content}</p>
			<hr>
		</c:forEach>
	</div>
	<!-- 最近の質問ここまで -->
</div>

<!-- プロフィール -->
<!--  <div class="profile">
	<h3>プロフィール</h3>
</div>-->
<!-- プロフィールここまで -->

<!-- 共通のフッターー -->
<!-- 共通ヘッダーここまで -->
</body>
</html>