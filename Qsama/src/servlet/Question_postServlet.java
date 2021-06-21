package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Question_postDAO;
import model.Question_post;


/**
 * Servlet implementation class Question_postServlet
 */
@MultipartConfig(location = "C:\\pleiades\\workspace\\Qsama\\WebContent\\images") // アップロードファイルの一時的な保存先
@WebServlet("/Question_postServlet")
public class Question_postServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
			HttpSession session = request.getSession();
			if (session.getAttribute("user_id") == null) {
				response.sendRedirect("/Qsama/LoginServlet");
				return;
			}
		
		// ログインしているユーザID（ac_id)の取得
		//	String ac_id = (String) session.getAttribute("ac_id");
		
				
		// ----------- よくある質問 ------------------
			Question_postDAO qDao = new Question_postDAO();
			List<Question_post> PostFaqList = qDao.PostFaq();
			List<Question_post> WeekFaqList = qDao.WeekFaqRanking();
			
			System.out.println("scope PostFaqList:" + PostFaqList);   // 結果出力
			System.out.println("scope WeekFaqList:" + WeekFaqList);
				
			// 結果をリクエストスコープに格納する
			request.setAttribute("PostFaqList", PostFaqList);	
			request.setAttribute("WeekFaqList", WeekFaqList);
		
		// 個人投稿ページにフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/question_post.jsp");
			dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
			HttpSession session = request.getSession();
			if (session.getAttribute("user_id") == null) {
				response.sendRedirect("/Qsama/LoginServlet");
				return;
			}
				
		
		// ログインしているユーザID（ac_id)の取得
	//	String ac_id = (String) session.getAttribute("ac_id");
	

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String M_items = request.getParameter("M_items");
		String S_items = request.getParameter("S_items");
		String Q_date = request.getParameter("Q_date");
		String Q_content = request.getParameter("Q_content");
		int A_level = Integer.parseInt(request.getParameter("A_level"));
	//	int A_level = 0;
	//	int Q_flag = Integer.parseInt(request.getParameter("Q_flag"));
	//	int Q_flag = 0;
		int emergency = Integer.parseInt(request.getParameter("emergency"));
	//	int emergency = 0;
		String Postpic_url = request.getParameter("Postpic_url");
	//	LoginUser ac_id = (LoginUser)session.getAttribute("ac_id");
	//	System.out.print("ac_id:" + ac_id );
		
	//	int ac_id = LoginUser.getAc_id();
		
		// ----------パラメータの取得確認 ----------
		System.out.println("大項目：" + M_items);
		System.out.println("中項目：" + S_items);
		System.out.println("日付：" + Q_date);
		System.out.println("質問内容：" + Q_content);
		System.out.println("回答レベル：" + A_level);
	//	System.out.println("回答フラグ：" + Q_flag);
		System.out.println("緊急レベル：" + emergency);
		System.out.println("画像URL：" + Postpic_url);
		
/*			
		// ----------- よくある質問 ------------------
		Question_postDAO qDao = new Question_postDAO();
		List<Question_post> PostFaqList = qDao.PostFaq();
		
			System.out.println("scope PostFaqList:" + PostFaqList);   // 結果出力
		
			// 結果をリクエストスコープに格納する
			request.setAttribute("PostFaqList", PostFaqList);	
*/			
			
		
/*		
		//--------------- ファイル取得 ---------------
		Part part = request.getPart("Postpic_url"); // getPartでファイル取得
	//	String image = this.getPostpic_url(part);
		System.out.println("imageの中身：" + part);
		request.setAttribute("image", part);
		
		// サーバの指定のファイルパスへファイルを保存
        //場所はクラス名↑の上に指定してある
		
		//ここで名前を決定
		 LocalDateTime nowDateTime = LocalDateTime.now();
		 DateTimeFormatter java8Format = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		 
		 // 日時情報を指定フォーマットの文字列で取得
		 String java8Disp = nowDateTime.format( java8Format );
		 
		 // if文でファイルの種類を判定する
		 part.write(java8Disp+".jpg");
		 String url_s = "image/"+java8Disp+".jpg";
		 System.out.println("URL書き換え後：" + url_s);
			
*/
       //ディスパッチ
	/*	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
		dispatcher.forward(request, response);
		
	*/
	   //ファイルの名前を取得してくる
	/*	 private String getFileName() {
	        String name = null;
	        for (String dispotion : part.getHeader("Content-Disposition").split(";")) {
	            if (dispotion.trim().startsWith("filename")) {
	                name = dispotion.substring(dispotion.indexOf("=") + 1).replace("\"", "").trim();
	                name = name.substring(name.lastIndexOf("\\") + 1);
	                break;
	            }
	        }		
			return;  // nameを戻す
		}
	*/
		// 登録処理を行う
		Question_postDAO qDao = new Question_postDAO();
		if (qDao.P_insert(new Question_post(M_items, S_items, Q_date, Q_content, A_level, emergency, Postpic_url))) {	// 登録成功
			System.out.println("登録成功");
		}
		else {
			System.out.println("登録失敗");
		}
		
		
		
			
		// 投稿ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/question_post.jsp");
				dispatcher.forward(request, response);

	}
}
