<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Qさま｜プロフィール</title>
  <link rel="stylesheet" href="css/profile.css">
  <link href='https://fonts.googleapis.com/css?family=Quicksand:300,400,700' rel='stylesheet' type='text/css'>
  <link href='https://fonts.googleapis.com/css?family=Lato:400,300' rel='stylesheet' type='text/css'>
  <link href="https://netdna.bootstrapcdn.com/font-awesome/3.1.1/css/font-awesome.css" rel="stylesheet">
  <!-- font awesome -->
<link href="https://use.fontawesome.com/releases/5.0.0/css/all.css" rel="stylesheet">
  <script type="text/javascript" src="/Qsama/js/profile.js"></script>
  <script src='//ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js'></script>
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
 <div class="container">
 	<form method="POST" id="form" action="/Qsama/ProfileServlet" enctype="multipart/form-data">
    <header>
     <!----------- 画像表示部分 ----------->
	<div class="bio">
		<div class="result" id="result"><c:forEach var="pr" items="${ProfileList}" varStatus="pri"><img src=${pr.back_url}></c:forEach>
		</div>
       	<div class="file">
       		<input type="file" id="file" name="IMAGE" accept="Qsama/img/*" onchange="previewImage(this);" multiple accept=".jpg,.gif,.png,image/gif,image/jpeg,image/png" hidden="true">
       	</div>
	</div>
     <!----------- 画像表示部分 ここまで----------->
	<div class="avatarcontainer" >
		<div class="icon">
			<input type="file" id="file2" name="IMAGE2" accept="Qsama/img/*" onchange="preview2Image(this);" multiple accept=".jpg,.gif,.png,image/gif,image/jpeg,image/png" hidden="true">
		</div>
	</div>
    </header>

    <div class="content">
      <div class="data">
        <!-- 自己紹介（ここから） -->
	<c:forEach var="e" items="${ProfileList}">
   <div class="introducation">
    <div class="mandatory">
      <label>名前：${e.name}
      <input type="text" name="NAME" id="A3" hidden="true" size="40"value="${e.name}" style="background:#e9e9e9;" readonly></label><br>
      <label>会社名：${e.company}
      <input type="text" name="COMPANY" id="A1" hidden="true" size="40"value="${e.company}" ></label><br>
      <label>クラス番号：${e.my_class}
      <input type="text" name="MY_CLASS" id="A2" hidden="true" size="40"value="${e.my_class}" style="background:#e9e9e9;" readonly></label><br>
      <label>プログラミング経験：${e.experience}
      <input type="text" name="EXPERIENCE" id="A4" hidden="true"size="40"value="${e.experience}"></label><br>
    </div>
    <div class="choice">
      <label>血液型：${e.bloodtype}
      <input type="text" name="BLOODTYPE" id="A5" hidden="true"size="40"value="${e.bloodtype}"></label><br>
      <label>誕生日：${e.birthday}
      <input type="text" name="BIRTHDAY" id="A6" hidden="true"size="40"value="${e.birthday}"></label><br>
      <label>大学名：${e.college}
      <input type="text" name="COLLEGE" id="A7" hidden="true"size="40"value="${e.college}"></label><br>
      <label>学部名：${e.undergraduate}
      <input type="text" name="UNDERGRADUATE" id="A8" hidden="true"size="40"value="${e.undergraduate}"></label><br>
      <label>趣味：${e.hobby}
      <input type="text" name="HOBBY" id="A9" hidden="true"size="40"value="${e.hobby}"></label><br>
      <label>特技：${e.special_skill}
      <input type="text" name="SPECIAL_SKILL" id="A10" hidden="true"size="40"value="${e.special_skill}"></label><br>
      <label>資格：${e.qualification}
      <input type="text" name="QUALIFICATION" id="A11" hidden="true"size="40"value="${e.qualification}"></label><br>
      <label>好きなアーティスト：${e.favorite}
      <input type="text" name="FAVORITE" id="A12" hidden="true"size="40"value="${e.favorite}"></label><br>
	  <label>一言コメント：${e.comment}
	  <input type="text" name="COMMENT" id="A13" hidden="true"size="40"value="${e.comment}"></label><br>
	</div>
	</div>
    <!-- 自己紹介（ここまで）-->
    </c:forEach>
      </div>
      <div class="edit">
        <a>
        <button type="button" class="edit" id="h_edit"	onclick="OnButtonClick()" value="編集"      style="display:inline;">編集</button>
        <button type="submit" class="edit" id="h_submit" 						  value="変更決定"	style="display:none;">変更決定</button>
        <button type="reset"  class="edit" id="h_reset"	onclick="OnButtonClick2()" value="キャンセル"style="display:none;">キャンセル</button>
        </a>
      </div>
    </div>
  </form>
  </div>

   <div class="container2">
    <!-- 過去の質問一覧表示（ここから） -->
       <p class="old_p_list">過去の質問一覧表示</p>
    		<c:forEach var="mg" items="${MyGetList}" varStatus="mm">
   				<div class="cp_qa">
					<div class="cp_actab">
						<input id="cp_tabfour_${mm.index}" type="checkbox" name="tabs">
						<label for="cp_tabfour_${mm.index}">質問日　：　${mg.q_date}<br>${mg.q_content}</label>
						<div class="cp_actab-content">
							<p>回答日　：　${mg.a_date}<br>${mg.a_content}</p>
							<form method="POST" id="display_form" action="/Qsama/ProfileServlet">
								<input type="hidden" name="question_number" value="${mg.post_Number}">
								<button type='submit' name="button" value="削除" onClick="return ppsubmit1()">削　除</button>
								<button type='submit' name="button" value="解決" onClick="return ppsubmit2()">解　決</button>
					  		</form>
						</div>
					</div>
				</div>
	      	</c:forEach>
    <!-- 過去の質問一覧表示（ここまで） -->
   </div>
<!-- 共通のフッターー -->
<jsp:include page="/WEB-INF/jsp/footer.jsp" />
</body>
</html>