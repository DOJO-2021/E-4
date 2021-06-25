package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDAO;
import model.Admin;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 検索処理を行う
		AdminDAO aDao = new AdminDAO();
		List<Admin> GetList = aDao.PostGet();							// 未回答の検索
		List<Admin> GetList2 = aDao.PostGet2();						// 回答済の検索

		List<Admin> HtmlModalList = aDao.HtmlOpenModal();				// 公開済 HTML モーダルウィンドウ用
		List<Admin> CssModalList = aDao.CssOpenModal();				// 公開済 CSS モーダルウィンドウ用
		List<Admin> JavaModalList = aDao.JavaOpenModal();				// 公開済 Java モーダルウィンドウ用
		List<Admin> JavascriptModalList = aDao.JavascriptOpenModal();// 公開済 JavaScript モーダルウィンドウ用
		List<Admin> SQLModalList = aDao.SQLOpenModal();				// 公開済 SQL モーダルウィンドウ用
		List<Admin> SJspModalList = aDao.SJspOpenModal();				// 公開済 ｻｰﾌﾞﾚｯﾄ・JSP モーダルウィンドウ用
		List<Admin> DanModalList = aDao.DanOpenModal();				// 公開済 段位認定 モーダルウィンドウ用
		List<Admin> DrillModalList = aDao.DrillOpenModal();			// 公開済 ﾄﾞﾘﾙ モーダルウィンドウ用

//		List<Admin> Html2ModalList = aDao.HtmlCloseModal();			// 非公開 HTML モーダルウィンドウ用
		List<Admin> Css2ModalList = aDao.CssCloseModal();				// 非公開 CSS モーダルウィンドウ用
		List<Admin> Java2ModalList = aDao.JavaCloseModal();			// 非公開 Java モーダルウィンドウ用
		List<Admin> Javascript2ModalList = aDao.JavascriptCloseModal();// 非公開 JavaScript モーダルウィンドウ用
		List<Admin> SQL2ModalList = aDao.SQLCloseModal();				// 非公開 SQL モーダルウィンドウ用
		List<Admin> SJsp2ModalList = aDao.SJspCloseModal();			// 非公開 ｻｰﾌﾞﾚｯﾄ・JSP モーダルウィンドウ用
		List<Admin> Dan2ModalList = aDao.DanCloseModal();				// 非公開 段位認定 モーダルウィンドウ用
		List<Admin> Drill2ModalList = aDao.DrillCloseModal();			// 非公開 ﾄﾞﾘﾙ モーダルウィンドウ用

//		System.out.println("DoGetのGetListの中身："+GetList);			// 結果出力　テストok
//		System.out.println("OpenModalListの中身："+OpenModalList);		// 結果出力　テストok
//		System.out.println("Java2ModalListの中身："+Java2ModalList);	// 結果出力　テストok

		request.setAttribute("GetList", GetList);
		request.setAttribute("GetList2", GetList2);
		request.setAttribute("HtmlModalList", HtmlModalList);
		request.setAttribute("CssModalList", CssModalList);
		request.setAttribute("JavaModalList", JavaModalList);
		request.setAttribute("JavascriptModalList", JavascriptModalList);
		request.setAttribute("SQLModalList", SQLModalList);
		request.setAttribute("SJspModalList", SJspModalList);
		request.setAttribute("DanModalList", DanModalList);
		request.setAttribute("DrillModalList", DrillModalList);
//		request.setAttribute("Html2ModalList", Html2ModalList);
		request.setAttribute("Css2ModalList", Css2ModalList);
		request.setAttribute("Java2ModalList", Java2ModalList);
		request.setAttribute("Javascript2ModalList", Javascript2ModalList);
		request.setAttribute("SQL2ModalList", SQL2ModalList);
		request.setAttribute("SJsp2ModalList", SJsp2ModalList);
		request.setAttribute("Dan2ModalList", Dan2ModalList);
		request.setAttribute("Drill2ModalList", Drill2ModalList);

		// 管理者ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/admin.jsp");
		dispatcher.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				// もしもログインしていなかったらログインサーブレットにリダイレクトする
/*		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/Qsama/LoginServlet");
			return;
		}
*/
		// ---------リクエストパラメータを取得する----------------------------------------
		request.setCharacterEncoding("UTF-8");
		String post_number = request.getParameter("post_number");			// 講師：検索キーワードを取得
		String answer = request.getParameter("answer_area");				// 回答の投稿
		String areapost_number = request.getParameter("areapost_number");	// 公開エリア更新用
		String m_items = request.getParameter("m_items");					// 大項目取得
		String s_items = request.getParameter("s_items");					// 中項目取得
		String displaybutton = request.getParameter("displaybutton");		// 左メニューボタン取得

		System.out.println("AdminS内post_number:"+post_number);
		System.out.println("m_items："+m_items+"\t s_items:"+s_items+"\n");

		// ---------質問内容の検索処理を行う----------------------------------------------
		AdminDAO aDao = new AdminDAO();
		List<Admin> GetList = aDao.PostGet();								// 未回答の検索
		List<Admin> GetList2 = aDao.PostGet2();							// 回答済の検索

		System.out.println("post_number.length()の結果："+post_number.length());

		// --------左のボタン　→　右のデータ表示機能--------------------------------------
		if(displaybutton != null) {
			if (displaybutton.equals("表示")) {
				if(post_number.length() != 0) {
					List<Admin> DisplayGetList = aDao.DisplayPostGet(post_number);	// 右欄へ表示する内容検索

					request.setAttribute("DisplayGetList", DisplayGetList);

					// ---------添付画像のURLを構築してJSPへ渡す--------------------------------------
					String pic_url = aDao.Getpic_url(post_number);				// 「post_word」ﾃｰﾌﾞﾙより「Postpic_url」を取得
					String picURL = "";

					if(pic_url != null) {
						var Extract_url = pic_url.split("<br>");				// <br>を基準に分割

						for (int i = 0 ; i < Extract_url.length; i++){
							if(i == Extract_url.length) {
								picURL = picURL +  "<a href='images/"+Extract_url[i]+"' target=\'_blank\' rel=\'noopener noreferrer\'>添付画像"+(i+1)+"</a>";
							}else {
								picURL = picURL + "<a href='images/"+Extract_url[i]+"' target=\'_blank\' rel=\'noopener noreferrer\'>添付画像"+(i+1)+"</a> ";
							}
						}
					}
				request.setAttribute("picURL", picURL);
				System.out.println("picURL→"+picURL);
				}
			}
		}
		//----------------------公開機能---------------------------------------------------
		String button = request.getParameter("button");

		if(button != null) {
			if (button.equals("公開停止")) {
				aDao.StopPublishing(areapost_number);					// 公開エリア：「非公開」更新
			}else if(button.equals("公開")) {
				aDao.Release(areapost_number);							// 公開エリア:「公開」に更新
			}
		}
//		System.out.println("DoPostのGetListの中身："+GetList);
//		System.out.println("DoPostのGetList2の中身："+GetList2);
//		System.out.println("DoPostのDisplayGetListの中身"+DisplayGetList);
		System.out.println("DoPostの変数post_numberの中身"+post_number+"\t answerは："+answer);


		// ------------回答済みかチェックする----------------------------------------------
		String answer_submit = request.getParameter("answer_submit");


//		int AnswerResult=aDao.AnswerCheck(post_number);
		if(answer_submit != null) {
			if (answer_submit.equals("投稿")) {
				if(answer != null) {												// 未回答
					if(post_number.length() != 0) {
						// ------------回答の登録処理を行う----------------------------------------
						aDao.PostAnswer(post_number, m_items, s_items, answer);		// 回答書き込み
						if(m_items != null) {
							//-------------ジャンルの更新------------------------------------------
							aDao.UpdateItem(m_items, s_items, post_number);			// ジャンルアップデート
						}
					}
				}else {																// 回答済
					if(post_number.length() != 0) {
						// ------------回答の登録変更を行う----------------------------------------
						aDao.PostCorrection(post_number, m_items, s_items, answer);	// 回答書き込み
						if(m_items != null) {
							//-------------ジャンルの更新------------------------------------------
							aDao.UpdateItem(m_items, s_items, post_number);			// ジャンルアップデート
						}
					}
				}
			}
		}
		System.out.println("--------------------------------END------------------------------------");

		request.setAttribute("GetList", GetList);
		request.setAttribute("GetList2", GetList2);

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/admin.jsp");
		dispatcher.forward(request, response);
	}
}
