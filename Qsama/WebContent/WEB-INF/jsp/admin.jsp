<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Qsama | 管理者ページ</title>
<link href="https://use.fontawesome.com/releases/v5.0.8/css/all.css" rel="stylesheet">
<link rel="stylesheet" href="css/admin.css">
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

<div class="content_box">
	<!-- 通知欄 -->
	<div class="tabs">
	  <input id="html" type="radio" name="tab_item" checked>
	  <label class="tab_item" for="html">質問通知</label>
	  <input id="css" type="radio" name="tab_item">
	  <label class="tab_item" for="css">解答済み通知</label>
	  <div class="tab_content" id="html_content">
	    <div class="tab_content_description">
	    <c:forEach var="g" items="${GetList}" varStatus="GL">
	     	<div class="wrap">
	     		<form method="POST" id="display_form" action="/Qsama/AdminServlet">
	     			<input type="hidden" name="post_number" value="${g.post_Number}">
 					<button class="cp_btn" name="displaybutton" id="title_${GL.index}" value="表示" onClick="picload()">未回答　　　${g.q_date}<br> 質問No${g.post_Number}:　${g.name}さんより質問です</button><br>
 				</form>
			</div>
	    </c:forEach>
	    </div>
	  </div>
	  <div class="tab_content" id="css_content">
	    <div class="tab_content_description">
		<c:forEach var="g2" items="${GetList2}" varStatus="GL2">
		    <div class="wrap">
				<form method="POST" id="display_form2" action="/Qsama/AdminServlet">
					<input type="hidden" name="post_number" value="${g2.post_Number}">
					<button class="cp_btn" name="displaybutton" id="title_${GL2.index}" value="表示" onClick="picload()">回答済　　　${g2.q_date}<br> 質問No${g2.post_Number}:　${g2.name}さんより質問です</button><br>
 				</form>
 			</div>
		</c:forEach>
	    </div>
	  </div>
	</div>
	<!-- 通知欄ここまで -->

<!---------------------- 右側全体のコンテンツ ---------------------->
		<div class="right_content" >
				質　問　内　容
			<!-- 質問内容 -->
			<div class="content1">	<!-- 一番上のコンテンツ -->
				<c:forEach var="d" items="${DisplayGetList}" varStatus="DG">
				${d.q_content}
				</c:forEach>
				<br>
				<c:if test="${not empty request.getAttribute('picURL')}">
					<%= request.getAttribute("picURL") %>
				</c:if>
						${picURL}
			</div>
			<form method="POST" id="answer_form1" name="answer_form2" action="/Qsama/AdminServlet">
			<div class="middle_content"> <!-- 真ん中のコンテンツ -->
				<!-- 質問カテゴリ修正欄 -->
				項目選択
					<select class="major_items" name="m_items">
						<option value="" selected="selected">ジャンルを選択</option>
						<option value="HTML">HTML</option>
						<option value="CSS">CSS</option>
						<option value="JavaScript">JavaScript</option>
						<option value="Java">Java</option>
						<option value="SQL">SQL</option>
						<option value="ｻｰﾌﾞﾚｯﾄ・JSP">ｻｰﾌﾞﾚｯﾄ・JSP</option>
						<option value="ｱﾌﾟﾘｹｰｼｮﾝ">ｱﾌﾟﾘｹｰｼｮﾝ</option>
						<option value="その他">その他</option>
				  <c:forEach var="d" items="${DisplayGetList}" varStatus="DG">
				  <option value="${d.m_items}" selected>${d.m_items}</option>
				  </c:forEach>
				</select>
				<select class="sub_item" name="s_items">
						<option value="" selected="selected">詳細ジャンルを選択</option>
						<option value="基礎・基本的な書式" data-val="HTML">基礎・基本的な書式</option>
						<option value="見出し・段落・リスト" data-val="HTML">見出し・段落・リスト</option>
						<option value="テキスト・単語" data-val="HTML">テキスト・単語</option>
						<option value="リンク・画像挿入" data-val="HTML">リンク・画像挿入</option>
						<option value="class属性・id属性" data-val="HTML">class属性・id属性</option>
						<option value="テーブル・フォーム" data-val="HTML">テーブル・フォーム</option>
						<option value="グループ化" data-val="HTML">グループ化</option>
						<option value="その他" data-val="HTML">その他</option>
						<option value="基礎・基本的な書式" data-val="CSS">基礎・基本的な書式</option>
						<option value="装飾" data-val="CSS">装飾</option>
						<option value="レイアウト" data-val="CSS">レイアウト</option>
						<option value="パディング・マージン" data-val="CSS">パディング・マージン</option>
						<option value="レスポンシブデザイン" data-val="CSS">レスポンシブデザイン</option>
						<option value="その他" data-val="CSS">その他</option>
						<option value="基礎" data-val="JavaScript">基礎</option>
						<option value="アウトプット方法" data-val="JavaScript">アウトプット方法</option>
						<option value="文法" data-val="JavaScript">文法</option>
						<option value="条件分岐・繰り返し" data-val="JavaScript">条件分岐・繰り返し</option>
						<option value="関数作成" data-val="JavaScript">関数作成</option>
						<option value="配列" data-val="JavaScript">配列</option>
						<option value="イベント処理" data-val="JavaScript">イベント処理</option>
						<option value="オブジェクト（Date,Mathなど）" data-val="JavaScript">オブジェクト（Date,Mathなど）</option>
						<option value="その他" data-val="JavaScript">その他</option>
						<option value="基礎・基本的な書式" data-val="Java">基礎・基本的な書式</option>
						<option value="条件分岐・繰り返し" data-val="Java">条件分岐・繰り返し</option>
						<option value="配列" data-val="Java">配列</option>
						<option value="メソッド" data-val="Java">メソッド</option>
						<option value="オブジェクト指向" data-val="Java">オブジェクト指向</option>
						<option value="継承" data-val="Java">継承</option>
						<option value="多態性" data-val="Java">多態性</option>
						<option value="カプセル化" data-val="Java">カプセル化</option>
						<option value="API" data-val="Java">API</option>
						<option value="コレクション" data-val="Java">コレクション</option>
						<option value="例外" data-val="Java">例外</option>
						<option value="エラーメッセージ" data-val="Java">エラーメッセージ</option>
						<option value="その他" data-val="Java">その他</option>
						<option value="サーブレット" data-val="ｻｰﾌﾞﾚｯﾄ・JSP">サーブレット</option>
						<option value="JSP" data-val="ｻｰﾌﾞﾚｯﾄ・JSP">JSP</option>
						<option value="フォーム" data-val="ｻｰﾌﾞﾚｯﾄ・JSP">フォーム</option>
						<option value="MVCモデル" data-val="ｻｰﾌﾞﾚｯﾄ・JSP">MVCモデル</option>
						<option value="スコープ" data-val="ｻｰﾌﾞﾚｯﾄ・JSP">スコープ</option>
						<option value="アクションタグ" data-val="ｻｰﾌﾞﾚｯﾄ・JSP">アクションタグ</option>
						<option value="EL式" data-val="ｻｰﾌﾞﾚｯﾄ・JSP">EL式</option>
						<option value="データベース" data-val="ｻｰﾌﾞﾚｯﾄ・JSP">データベース</option>
						<option value="エラーメッセージ" data-val="ｻｰﾌﾞﾚｯﾄ・JSP">エラーメッセージ</option>
						<option value="その他" data-val="ｻｰﾌﾞﾚｯﾄ・JSP">その他</option>
						<option value="データベースの基本" data-val="SQL">データベースの基本</option>
						<option value="検索 -select-" data-val="SQL">検索 -select-</option>
						<option value="内部結合・外部結合" data-val="SQL">内部結合・外部結合</option>
						<option value="サブクエリ" data-val="SQL">サブクエリ</option>
						<option value="登録 -insert-" data-val="SQL">登録 -insert-</option>
						<option value="更新 -update-" data-val="SQL">更新 -update-</option>
						<option value="削除 -delete-" data-val="SQL">削除 -delete-</option>
						<option value="テーブル作成" data-val="SQL">テーブル作成</option>
						<option value="その他" data-val="SQL">その他</option>
						<option value="Eclipse" data-val="ｱﾌﾟﾘｹｰｼｮﾝ">Eclipse</option>
 						<option value="H2コンソール" data-val="ｱﾌﾟﾘｹｰｼｮﾝ">H2コンソール</option>
						<option value="Git関係" data-val="ｱﾌﾟﾘｹｰｼｮﾝ">Git関係</option>
						<option value="その他" data-val="ｱﾌﾟﾘｹｰｼｮﾝ">その他</option>
						<option value="講義全般" data-val="その他">講義全般</option>
    					<option value="その他" data-val="その他">その他</option>
    					<c:forEach var="d" items="${DisplayGetList}" varStatus="DG">
						<option value="${d.s_items}" selected>${d.s_items}</option>
						</c:forEach>
					</select>
					<br>
<!----------------------- 回答入力フォーム ----------------------->
				回　答　入　力
					<label>
						<c:forEach var="d" items="${DisplayGetList}" varStatus="DG">
						<input type="hidden" name="post_number" value="${d.post_Number}">
						</c:forEach>
						<textarea id="answer_area" name="answer_area"><c:forEach var="d" items="${DisplayGetList}" varStatus="DG">${d.a_content}</c:forEach>
						</textarea><br>
						<!-- 投稿ボタン -->
						<button type="submit" name="answer_submit" class="answer_submit" onClick="return answersubmit()"style="width: 50%;" value="投稿">投   稿</button>
					</label>
			</div>
		</form>
			<div class="under_content" style="float:left;"> <!-- 下二つのコンテンツ -->
				<!-- 質問公開設定 -->
				<div class="content2">質問公開設定<br><br>
					<button style="width: 80%;" class="js-modal-open" data-target="modal01">公開済 - 投稿一覧表示</button><br><br>
					<button style="width: 80%;" class="js-modal-open" data-target="modal02">未公開 - 投稿一覧表示</button>
				</div>

<!---------- 【モーダルウィンドウ】公開済 - 投稿一覧表示 ---------->
				<div id="modal01" class="modal js-modal">
					<div class="modal__bg js-modal-close"></div>
					<div class="modal__content">
								<div class="cp_qa" id="checkbox_id">
									<input id="cp_conttab1" type="radio" name="tabs" value="HTML">
									<label for="cp_conttab1" class="cp_tabitem">HTML</label>
									<input id="cp_conttab2" type="radio" name="tabs" value="CSS">
									<label for="cp_conttab2" class="cp_tabitem">CSS</label>
									<input id="cp_conttab3" type="radio" name="tabs" value="JavaScript">
									<label for="cp_conttab3" class="cp_tabitem">JavaScript</label>
									<input id="cp_conttab4" type="radio" name="tabs" value="Java">
									<label for="cp_conttab4" class="cp_tabitem">Java</label>
									<input id="cp_conttab5" type="radio" name="tabs" value="SQL">
									<label for="cp_conttab5" class="cp_tabitem">SQL</label>
									<input id="cp_conttab6" type="radio" name="tabs" value="ｻｰﾌﾞﾚｯﾄ・JSP">
									<label for="cp_conttab6" class="cp_tabitem">ｻｰﾌﾞﾚｯﾄ・JSP</label>
									<input id="cp_conttab7" type="radio" name="tabs" value="段位認定">
									<label for="cp_conttab7" class="cp_tabitem">段位認定</label>
									<input id="cp_conttab8" type="radio" name="tabs" value="ﾄﾞﾘﾙ">
									<label for="cp_conttab8" class="cp_tabitem">ﾄﾞﾘﾙ</label>
									<div id="cp_content1">
										<div class="cp_qain">
											<c:forEach var="op1" items="${HtmlModalList}" varStatus="op11">
											<div class="cp_actab">
												<input id="cp_tabfour1${op11.index}" type="checkbox" name="tabs">
												<div class="cp_plus">+</div>
												<label for="cp_tabfour1${op11.index}">${op1.q_content}</label>
												<div class="cp_actab-content">${op1.a_content}</div>
												<form method="POST" id="tab1_form${op11.index}" name="answer_form" >
												<input type="hidden" name="areapost_number" value="${op1.post_Number}">
												<button type='submit' name="button" value="公開停止" onClick="return formsubmit2()">公開停止</button>
												</form>
											</div>
											</c:forEach>
										</div>
									</div>
									<div id="cp_content2">
										<div class="cp_qain">
											<c:forEach var="op2" items="${CssModalList}" varStatus="op21">
											<div class="cp_actab">
												<input id="cp_tabfour2${op21.index}" type="checkbox" name="tabs">
												<div class="cp_plus">+</div>
												<label for="cp_tabfour2${op21.index}">${op2.q_content}</label>
												<div class="cp_actab-content">${op2.a_content}</div>
												<form method="POST" id="tab2_form${op21.index}" name="answer_form" >
												<input type="hidden" name="areapost_number" value="${op2.post_Number}">
												<button type='submit' name="button" value="公開停止" onClick="return formsubmit2()">公開停止</button>
												</form>
											</div>
											</c:forEach>
										</div>
									</div>
									<div id="cp_content3">
										<div class="cp_qain">
											<c:forEach var="op3" items="${JavascriptModalList}" varStatus="op31">
											<div class="cp_actab">
												<input id="cp_tabfour3${op31.index}" type="checkbox" name="tabs">
												<div class="cp_plus">+</div>
												<label for="cp_tabfour3${op31.index}">${op3.q_content}</label>
												<div class="cp_actab-content">${op3.a_content}</div>
												<form method="POST" id="tab3_form${op31.index}" name="answer_form" >
												<input type="hidden" name="areapost_number" value="${op3.post_Number}">
												<button type='submit' name="button" value="公開停止" onClick="return formsubmit2()">公開停止</button>
												</form>
											</div>
											</c:forEach>
										</div>
									</div>
									<div id="cp_content4">
										<div class="cp_qain">
											<c:forEach var="op4" items="${JavaModalList}" varStatus="op41">
											<div class="cp_actab">
												<input id="cp_tabfour4${op41.index}" type="checkbox" name="tabs">
												<div class="cp_plus">+</div>
												<label for="cp_tabfour4${op41.index}">${op4.q_content}</label>
												<div class="cp_actab-content">${op4.a_content}</div>
												<form method="POST" id="tab4_form${op41.index}" name="answer_form" >
												<input type="hidden" name="areapost_number" value="${op4.post_Number}">
												<button type='submit' name="button" value="公開停止" onClick="return formsubmit2()">公開停止</button>
												</form>
											</div>
											</c:forEach>
										</div>
									</div>
									<div id="cp_content5">
										<div class="cp_qain">
											<c:forEach var="op5" items="${SQLModalList}" varStatus="op51">
												<div class="cp_actab">
												<input id="cp_tabfour5${op51.index}" type="checkbox" name="tabs">
												<div class="cp_plus">+</div>
												<label for="cp_tabfour1${op51.index}">${op5.q_content}</label>
												<div class="cp_actab-content">${op5.a_content}</div>
												<form method="POST" id="tab5_form${op51.index}" name="answer_form" >
												<input type="hidden" name="areapost_number" value="${op5.post_Number}">
												<button type='submit' name="button" value="公開停止" onClick="return formsubmit2()">公開停止</button>
												</form>
											</div>
											</c:forEach>
										</div>
									</div>
									<div id="cp_content6">
										<div class="cp_qain">
											<c:forEach var="op6" items="${SJspModalList}" varStatus="op61">
											<div class="cp_actab">
												<input id="cp_tabfour6${op61.index}" type="checkbox" name="tabs">
												<div class="cp_plus">+</div>
												<label for="cp_tabfour6${op61.index}">${op6.q_content}</label>
												<div class="cp_actab-content">${op6.a_content}</div>
												<form method="POST" id="tab6_form${op61.index}" name="answer_form" >
												<input type="hidden" name="areapost_number" value="${op6.post_Number}">
												<button type='submit' name="button" value="公開停止" onClick="return formsubmit2()">公開停止</button>
												</form>
											</div>
											</c:forEach>
										</div>
									</div>
									<div id="cp_content7">
										<div class="cp_qain">
											<c:forEach var="op7" items="${DanModalList}" varStatus="op71">
											<div class="cp_actab">
												<input id="cp_tabfour7${op71.index}" type="checkbox" name="tabs">
												<div class="cp_plus">+</div>
												<label for="cp_tabfour7${op71.index}">${op7.q_content}</label>
												<div class="cp_actab-content">${op7.a_content}</div>
												<form method="POST" id="tab7_form${op71.index}" name="answer_form" >
												<input type="hidden" name="areapost_number" value="${op7.post_Number}">
												<button type='submit' name="button" value="公開停止" onClick="return formsubmit2()">公開停止</button>
												</form>
											</div>
											</c:forEach>
										</div>
									</div>
									<div id="cp_content8">
										<div class="cp_qain">
											<c:forEach var="op8" items="${DrillModalList}" varStatus="op81">
											<div class="cp_actab">
												<input id="cp_tabfour8${op81.index}" type="checkbox" name="tabs">
												<div class="cp_plus">+</div>
												<label for="cp_tabfour8${op81.index}">${op8.q_content}</label>
												<div class="cp_actab-content">${op8.a_content}</div>
												<form method="POST" id="tab8_form${op81.index}" name="answer_form" >
												<input type="hidden" name="areapost_number" value="${op8.post_Number}">
												<button type='submit' name="button" value="公開停止" onClick="return formsubmit2()">公開停止</button>
												</form>
											</div>
											</c:forEach>
										</div>
									</div>
								</div>
								<a class="js-modal-close" href="">閉じる</a>
					</div><!--modal__inner-->
				</div><!--modal-->

<!---------- 【モーダルウィンドウ】非公開 - 投稿一覧表示 ---------->
				<div id="modal02" class="modal js-modal">
					<div class="modal__bg js-modal-close"></div>
					<div class="modal__content">
								<div class="cp_qa" id="checkbox_id">
<!--								<input id="cp_conttab11" type="radio" name="tabs" value="HTML">
									<label for="cp_conttab11" class="cp_tabitem">HTML</label>  -->
									<input id="cp_conttab12" type="radio" name="tabs" value="CSS">
									<label for="cp_conttab12" class="cp_tabitem">CSS</label>
									<input id="cp_conttab13" type="radio" name="tabs" value="JavaScript">
									<label for="cp_conttab13" class="cp_tabitem">JavaScript</label>
									<input id="cp_conttab14" type="radio" name="tabs" value="Java">
									<label for="cp_conttab14" class="cp_tabitem">Java</label>
									<input id="cp_conttab15" type="radio" name="tabs" value="SQL">
									<label for="cp_conttab15" class="cp_tabitem">SQL</label>
									<input id="cp_conttab16" type="radio" name="tabs" value="ｻｰﾌﾞﾚｯﾄ・JSP">
									<label for="cp_conttab16" class="cp_tabitem">ｻｰﾌﾞﾚｯﾄ・JSP</label>
									<input id="cp_conttab17" type="radio" name="tabs" value="段位認定">
									<label for="cp_conttab17" class="cp_tabitem">段位認定</label>
									<input id="cp_conttab18" type="radio" name="tabs" value="ﾄﾞﾘﾙ">
									<label for="cp_conttab18" class="cp_tabitem">ﾄﾞﾘﾙ</label>
	<!-- 							<div id="cp_content11">
										<div class="cp_qain">
											<c:forEach var="qp1" items="${Html2ModalList}" varStatus="qp11">
											<div class="cp_actab">
												<input id="cp_tabfour11${qp11.index}" type="checkbox" name="tabs">
												<div class="cp_plus">+</div>
												<label for="cp_tabfour11${qp11.index}">${qp1.q_content}</label>
												<div class="cp_actab-content">${qp1.a_content}</div>
											</div>
											</c:forEach>
										</div>
									</div>  -->
									<div id="cp_content12">
										<div class="cp_qain">
											<c:forEach var="qp2" items="${Css2ModalList}" varStatus="qp21">
											<div class="cp_actab">
												<input id="cp_tabfour12${qp21.index}" type="checkbox" name="tabs">
												<div class="cp_plus">+</div>
												<label for="cp_tabfour12${qp21.index}">${qp2.q_content}</label>
												<div class="cp_actab-content">${qp2.a_content}</div>
												<form method="POST" id="tab12_form${qp21.index}" name="answer_form" >
												<input type="hidden" name="areapost_number" value="${qp2.post_Number}">
												<button type='submit' name="button" value="公開" onClick="return formsubmit()">公開</button>
												</form>
											</div>
											</c:forEach>
										</div>
									</div>
									<div id="cp_content13">
										<div class="cp_qain">
											<c:forEach var="qp3" items="${Javascript2ModalList}" varStatus="qp31">
											<div class="cp_actab">
												<input id="cp_tabfour13${qp31.index}" type="checkbox" name="tabs">
												<div class="cp_plus">+</div>
												<label for="cp_tabfour13${qp31.index}">${qp3.q_content}</label>
												<div class="cp_actab-content">${qp3.a_content}</div>
												<form method="POST" id="tab13_form${qp31.index}" name="answer_form" >
												<input type="hidden" name="areapost_number" value="${qp3.post_Number}">
												<button type='submit' name="button" value="公開" onClick="return formsubmit()">公開</button>
												</form>
											</div>
											</c:forEach>
										</div>
									</div>
									<div id="cp_content14">
										<div class="cp_qain">
											<c:forEach var="qp4" items="${Java2ModalList}" varStatus="qp41">
											<div class="cp_actab">
												<input id="cp_tabfour14${qp41.index}" type="checkbox" name="tabs">
												<div class="cp_plus">+</div>
												<label for="cp_tabfour14${qp41.index}">${qp4.q_content}</label>
												<div class="cp_actab-content">${qp4.a_content}</div>
												<form method="POST" id="tab14_form${qp41.index}" name="answer_form" >
												<input type="hidden" name="areapost_number" value="${qp4.post_Number}">
												<button type='submit' name="button" value="公開" onClick="return formsubmit()">公開</button>
												</form>
											</div>
											</c:forEach>
										</div>
									</div>
									<div id="cp_content15">
										<div class="cp_qain">
											<c:forEach var="qp5" items="${SQL2ModalList}" varStatus="qp51">
											<div class="cp_actab">
												<input id="cp_tabfour15${qp51.index}" type="checkbox" name="tabs">
												<div class="cp_plus">+</div>
												<label for="cp_tabfour15${qp51.index}">${qp5.q_content}</label>
												<div class="cp_actab-content">${qp5.a_content}</div>
												<form method="POST" id="tab15_form${qp51.index}" name="answer_form" >
												<input type="hidden" name="areapost_number" value="${qp5.post_Number}">
												<button type='submit' name="button" value="公開" onClick="return formsubmit()">公開</button>
												</form>
											</div>
											</c:forEach>
										</div>
									</div>
									<div id="cp_content16">
										<div class="cp_qain">
											<c:forEach var="qp6" items="${SJsp2ModalList}" varStatus="qp61">
											<div class="cp_actab">
												<input id="cp_tabfour16${qp61.index}" type="checkbox" name="tabs">
												<div class="cp_plus">+</div>
												<label for="cp_tabfour16${qp61.index}">${qp6.q_content}</label>
												<div class="cp_actab-content">${qp6.a_content}</div>
												<form method="POST" id="tab16_form${qp61.index}" name="answer_form" >
												<input type="hidden" name="areapost_number" value="${qp6.post_Number}">
												<button type='submit' name="button" value="公開" onClick="return formsubmit()">公開</button>
												</form>
											</div>
											</c:forEach>
										</div>
									</div>
									<div id="cp_content17">
										<div class="cp_qain">
											<c:forEach var="qp7" items="${Dan2ModalList}" varStatus="qp71">
											<div class="cp_actab">
												<input id="cp_tabfour17${qp71.index}" type="checkbox" name="tabs">
												<div class="cp_plus">+</div>
												<label for="cp_tabfour17${qp71.index}">${qp7.q_content}</label>
												<div class="cp_actab-content">${qp7.a_content}</div>
												<form method="POST" id="tab17_form${qp71.index}" name="answer_form" >
												<input type="hidden" name="areapost_number" value="${qp7.post_Number}">
												<button type='submit' name="button" value="公開" onClick="return formsubmit()">公開</button>
												</form>
											</div>
											</c:forEach>
										</div>
									</div>
									<div id="cp_content18">
										<div class="cp_qain">
											<c:forEach var="qp8" items="${Drill2ModalList}" varStatus="qp81">
											<div class="cp_actab">
												<input id="cp_tabfour18${qp81.index}" type="checkbox" name="tabs">
												<div class="cp_plus">+</div>
												<label for="cp_tabfour18${qp81.index}">${qp8.q_content}</label>
												<div class="cp_actab-content">${qp8.a_content}</div>
												<form method="POST" id="tab18_form${qp81.index}" name="answer_form" >
												<input type="hidden" name="areapost_number" value="${qp8.post_Number}">
												<button type='submit' name="button" value="公開" onClick="return formsubmit()">公開</button>
												</form>
											</div>
											</c:forEach>
										</div>
									</div>
								</div>
								<a class="js-modal-close" href="">閉じる</a>
					</div><!--modal__inner-->
				</div><!--modal-->
			</div>
			<!-- 受講者質問管理 -->
			<div class="content3" style="float:left;">受講者別質問管理
					<form method="POST" id="personal_form" action="/Qsama/AdminServlet">
						<select class="personal_items" name="personal_items">
							<option value="" selected>検索したい受講者を選択</option>
							<c:forEach var="pp" items="${PersonalList}" varStatus="pp1">
							<option value="${pp.name}" >${pp.name}</option>
							</c:forEach>
						</select>
						<button type="submit" id="personal_submit" name="personal_submit"onClick="personalsubmit()">検索</button>
					</form>
			<c:forEach var="st" items="${StudentList}" varStatus="stu">
	     	<div>
	     		<form method="POST" id="personal2_form" action="/Qsama/AdminServlet">
	     			<input type="hidden" name="post_number" value="${st.post_Number}">
 					<button class="cp_btn" id="title_${stu.index}" >質問No:${st.post_Number} ｼﾞｬﾝﾙ：${st.m_items}</button><br>
 				</form>
			</div>
	    	</c:forEach>
		</div>
	</div>
</div>
</body>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="js/Admin.js"></script>		<!--モーダルウィンドウ用js-->
</html>