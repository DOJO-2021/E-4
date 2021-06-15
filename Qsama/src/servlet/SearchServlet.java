package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SearchDAO;
import model.Search;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする

		// 検索ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/search.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/Qsama/LoginServlet");
			return;
		}
*/
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String Search_word = request.getParameter("search_word");		// 講師：検索キーワードを取得
		String Search_radio = request.getParameter("search_radio");	// 講師：ラジオボタン情報を取得
		String m_items = request.getParameter("m_items");				// 講師：大項目 情報を取得
		String s_items = request.getParameter("s_items");				// 講師：小項目 情報を取得
		String Search_word2 = request.getParameter("search_word2");	// 事務：検索キーワードを取得
		String Search_radio2 = request.getParameter("search_radio2");	// 事務：ラジオボタン情報を取得
		String m_items2 = request.getParameter("m_items2");			// 事務：大項目 情報を取得
		String s_items2 = request.getParameter("s_items2");			// 事務：小項目 情報を取得

//		System.out.println(Search_word); 								// 検索ワードの確認テスト　ok
//		System.out.println(Search_word.length()); 						// 検索ワードの長さ確認  ok
		System.out.print("ｻｰﾌﾞﾚｯﾄradio:"+Search_radio+" "); 			// ラジオテスト　ok
		System.out.print("ｻｰﾌﾞﾚｯﾄm_items:"+m_items+" "); 				// 大項目確認  ok
		System.out.println("ｻｰﾌﾞﾚｯﾄs_items:"+s_items); 					// 小項目確認　ok

		if(Search_word2.length() > 0) {				// 事務局側で入力した場合
			Search_word = Search_word2;
			Search_radio = Search_radio2;
			m_items = m_items2;
			s_items = s_items2;
		}

		var S1_word = Search_word.split("　"); 	//全角スペース判定
		String S2_word = null;
		String S4_word = null;

	    for (int i = 0 ; i < S1_word.length; i++){ //var→Stringに変換
	    	if(i==0) {
	    		S2_word = S1_word[i];
	    	}else {
		    	S2_word = S2_word +" "+ S1_word[i];
	   	}	}

		var S3_word = S2_word.split(" ");  		//半角スペース判定

	    for (int i = 0 ; i < S3_word.length; i++){	//var→Stringに変換
	    	if(i==0) {
	    		S4_word = S3_word[i];
	    	}else {
		    	S4_word = S4_word +" "+ S3_word[i];
	   	}	}

		// 検索処理を行う
		SearchDAO sDao = new SearchDAO();
		List<Search> SearchList = sDao.KeywordSearch(S4_word, Search_radio, m_items, s_items);

//		System.out.println(SearchList);		//結果出力　テストok

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("SearchList", SearchList);

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/search.jsp");
		dispatcher.forward(request, response);
	}
}
