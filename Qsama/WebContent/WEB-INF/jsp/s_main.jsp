<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Qsama | top</title>
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/s_main.css">
<link href="https://use.fontawesome.com/releases/5.12.0/css/all.css" rel="stylesheet">
<!-- font awesome -->
<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" rel="stylesheet">
<script src="https://unpkg.com/scrollreveal"></script>
<script src="jquery.simplePagination.js"></script>
</head>
<body>
<!-- 共通のヘッダー -->
<c:choose>
 <c:when test="${sessionScope.user_rank == 1}">
  <jsp:include page="/WEB-INF/jsp/header.jsp" />
 </c:when>
 <c:otherwise>
  <jsp:include page="/WEB-INF/jsp/a_header.jsp" />
 </c:otherwise>
</c:choose>
<!-- 共通ヘッダーここまで -->
<!-- お知らせ -->

<div class="info">
<!--  <h2>お知らせ</h2>  -->
<div class="foo">
  <span class="letter" data-letter="お">お</span>
  <span class="letter" data-letter="知">知</span>
  <span class="letter" data-letter="ら">ら</span>
  <span class="letter" data-letter="せ">せ</span>
</div>

  <c:forEach var="o" items="${NoticeList}">
	<dl>
	    <dd>
			<i class="fab fa-bell-on"></i>${o.q_date} の質問に対して回答が届いています！
	    </dd>
	</dl>
  </c:forEach>
</div>
<!-- お知らせここまで -->
<!--  <h3>解決済みの質問集</h3>   -->
<div class="foo foo_main">
  <span class="letter" data-letter="解">解</span>
  <span class="letter" data-letter="決">決</span>
  <span class="letter" data-letter="済">済</span>
  <span class="letter" data-letter="み">み</span>
  <span class="letter" data-letter="の">の</span>
  <span class="letter" data-letter="質">質</span>
  <span class="letter" data-letter="問">問</span>
  <span class="letter" data-letter="集">集</span>
</div>


<div class="box">
	<!-- よくある質問集 -->
	<div class="tabs">
	  <input id="html" type="radio" name="tab_item" checked>
	  <label class="tab_item" for="html"><a href="#html_content" class="href">HTML</a></label>
	  <input id="css" type="radio" name="tab_item">
	  <label class="tab_item" for="css"><a href="#css_content" class="href">CSS</a></label>
	  <input id="javascript" type="radio" name="tab_item">
	  <label class="tab_item" for="javascript"><a href="#javascript_content" class="href">JavaScript</a></label>
	  <input id="java" type="radio" name="tab_item">
	  <label class="tab_item" for="java"><a href="#java_content" class="href">Java</a></label>
	  <input id="sql" type="radio" name="tab_item">
	  <label class="tab_item" for="sql"><a href="#sql_content" class="href">SQL</a></label>
	  <input id="servlet" type="radio" name="tab_item">
	  <label class="tab_item" for="servlet"><a href="#servlet_content" class="href">サーブレット</a></label>
	  <input id="jimukyoku" type="radio" name="tab_item">
	  <label class="tab_item" for="jimukyoku"><a href="#jimukyoku_content" class="href">事務局</a></label>
	  <input id="drill" type="radio" name="tab_item">
	  <label class="tab_item" for="drill"><a href="#drill_content" class="href">ドリル</a></label>
	  <input id="dani" type="radio" name="tab_item">
	  <label class="tab_item" for="dani"><a href="#dani_content" class="href">段位認定</a></label>


	  <div class="tab_content" id="html_content">
	    <div class="tab_content_description">
			<c:forEach var="h" items="${ResoledQList}">
				<i class="fa fa-chevron-circle-right color_change"></i>
				<p class="question">${h.q_content}</p>
				<p class="ans">${h.a_content}</p>
				<hr class="hr">
			</c:forEach>
	    </div>
	  </div>
	  <div class="tab_content" id="css_content">
	    <div class="tab_content_description">
			<c:forEach var="h2" items="${ResoledQList2}">
				<i class="fa fa-chevron-circle-right color_change"></i>
				<p class="question">${h2.q_content}</p>
				<p class="ans">${h2.a_content}</p>
				<hr class="hr">
			</c:forEach>
	    </div>
	  </div>
	  <div class="tab_content" id="javascript_content">
	    <div class="tab_content_description">
			<c:forEach var="h3" items="${ResoledQList3}">
				<i class="fa fa-chevron-circle-right color_change"></i>
				<p class="question">${h3.q_content}</p>
				<p class="ans">${h3.a_content}</p>
				<hr class="hr">
			</c:forEach>
	    </div>
	  </div>
	  <div class="tab_content" id="java_content">
	    <div class="tab_content_description">
			<c:forEach var="h4" items="${ResoledQList4}">
				<i class="fa fa-chevron-circle-right color_change"></i>
				<p class="question">${h4.q_content}</p>
				<p class="ans">${h4.a_content}</p>
				<hr class="hr">
			</c:forEach>
	    </div>
	  </div>
	  <div class="tab_content" id="sql_content">
	    <div class="tab_content_description">
			<c:forEach var="h5" items="${ResoledQList5}">
				<i class="fa fa-chevron-circle-right color_change"></i>
				<p class="question">${h5.q_content}</p>
				<p class="ans">${h5.a_content}</p>
				<hr class="hr">
			</c:forEach>
	    </div>
	  </div>
    <div class="tab_content" id="servlet_content">
      <div class="tab_content_description">
		  <c:forEach var="h6" items="${ResoledQList6}">
				<i class="fa fa-chevron-circle-right color_change"></i>
			    <p class="question">${h6.q_content}</p>
			    <p class="ans">${h6.a_content}</p>
			    <hr class="hr">
		  </c:forEach>
      </div>
    </div>
	<div class="tab_content" id="jimukyoku_content">
	   <div class="tab_content_description">
			<c:forEach var="h7" items="${ResoledQList7}">
				<i class="fa fa-chevron-circle-right color_change"></i>
				<p class="question">${h7.q_content}</p>
				<p class="ans">${h7.a_content}</p>
				<hr class="hr">
			</c:forEach>
	    </div>
	 </div>
	 <div class="tab_content" id="drill_content">
	    <div class="tab_content_description">
	      <p class="c-txtsp"></p>
			<c:forEach var="h8" items="${ResoledQList8}">
				<i class="fa fa-chevron-circle-right color_change"></i>
				<p class="question">${h8.q_content}</p>
				<p class="ans">${h8.a_content}</p>
				<hr class="hr">
			</c:forEach>
	    </div>
	  </div>
	  <div class="tab_content" id="dani_content">
	    <div class="tab_content_description">
			<c:forEach var="h9" items="${ResoledQList9}">
				<i class="fa fa-chevron-circle-right color_change"></i>
				<p class="question">${h9.q_content}</p>
				<p class="ans">${h9.a_content}</p>
				<hr class="hr">
			</c:forEach>
	    </div>
	  </div>
  </div>
</div>

<!--  <h3>過去に投稿された質問</h3>  -->
<div class="foo foo_old">
  <span class="letter" data-letter="過">過</span>
  <span class="letter" data-letter="去">去</span>
  <span class="letter" data-letter="に">に</span>
  <span class="letter" data-letter="投">投</span>
  <span class="letter" data-letter="稿">稿</span>
  <span class="letter" data-letter="さ">さ</span>
  <span class="letter" data-letter="れ">れ</span>
  <span class="letter" data-letter="た">た</span>
  <span class="letter" data-letter="質">質</span>
  <span class="letter" data-letter="問">問</span>
</div>

<div class="box2">
	<!-- 最近の質問 -->
		<c:forEach var="m" items="${RecentqList}">
		<div class="content" >
			${m.q_date}:${m.m_items}
			<p class="q_list">${m.q_content}</p>
		</div>
		</c:forEach>
</div>
<!-- 最近の質問ここまで -->

<!-- 共通のフッターー -->
<jsp:include page="/WEB-INF/jsp/footer.jsp" />
<!-- 共通ヘッダーここまで -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<script src="js/s_main.js"></script>
</body>
</html>