package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import model.Admin;

public class AdminDAO {
	// -----------未回答の質問を読み込み---------------------------------------------------------------------------
	public List<Admin> PostGet(){
	  List<Admin> GetList = new ArrayList<Admin>();

      Connection conn = null;					// 接続リセット

	  try {
        // JDBCドライバの読み込み
		Class.forName("org.h2.Driver");
		// データベースに接続する
		conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/E-4/Qsama/data/E-4", "sa", "");

		// SQL文の準備 検索キーワードに対して、個別質問 + 管理テーブルを全出力
		String sql = "SELECT p.QQ_ID, p.POST_NUMBER, p.M_ITEMS, p.S_ITEMS, p.Q_DATE, p.Q_CONTENT, p.A_LEVEL, p.EMERGENCY,"
				+ "	p.POSTPIC_URL, m.A_FLAG, m.A_CONTENT, u.NAME"
				+ "	FROM POST_WORD as p inner join MANAGEMENT_WORD as m inner join p_user as u"
				+ "	on p.post_number=m.post_number on u.ac_id = p.ac_id"
				+ "	where m.A_flag=0 order by p.Q_DATE DESC";

		PreparedStatement s_res = conn.prepareStatement(sql);

		// select文の実行
		ResultSet rs = s_res.executeQuery();

		// select文の結果をArrayListに格納
		while (rs.next()) {
			Admin Admin_ = new Admin(
				rs.getInt("QQ_id"),
				rs.getInt("Post_Number"),
				rs.getString("M_items"),
				rs.getString("S_items"),
				rs.getString("Q_date"),
				rs.getString("Q_content"),
				rs.getInt("A_level"),
				rs.getInt("emergency"),
				rs.getString("Postpic_url"),
				rs.getInt("A_flag"),
				rs.getString("A_CONTENT"),
				rs.getString("NAME")
				);
				GetList.add(Admin_);
			}
	  }  // エラー処理
	  catch (SQLException e) {
			e.printStackTrace();
			GetList = null;
	  }
	  catch (ClassNotFoundException e) {
			e.printStackTrace();
			GetList = null;
	  }
	  finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					GetList = null;
				}
			}
	  }return GetList;	 	// 結果を返す
	}

	// -----------回答済の質問を読み込み---------------------------------------------------------------------------
	public List<Admin> PostGet2(){
	  List<Admin> GetList2 = new ArrayList<Admin>();

      Connection conn = null;					// 接続リセット

	  try {
        // JDBCドライバの読み込み
		Class.forName("org.h2.Driver");
		// データベースに接続する
		conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/E-4/Qsama/data/E-4", "sa", "");

		// SQL文の準備 検索キーワードに対して、個別質問 + 管理テーブルを全出力
		String sql = "SELECT p.QQ_ID, p.POST_NUMBER, p.M_ITEMS, p.S_ITEMS, p.Q_DATE, p.Q_CONTENT, p.A_LEVEL, p.EMERGENCY,"
				+ "	p.POSTPIC_URL, m.A_FLAG, m.A_CONTENT, u.NAME"
				+ "	FROM POST_WORD as p inner join MANAGEMENT_WORD as m inner join p_user as u"
				+ "	on p.post_number=m.post_number on u.ac_id = p.ac_id"
				+ "	where m.A_flag=1 order by p.Q_DATE DESC";

		PreparedStatement s_res = conn.prepareStatement(sql);

		// select文の実行
		ResultSet rs = s_res.executeQuery();

		// select文の結果をArrayListに格納
		while (rs.next()) {
			Admin Admin_ = new Admin(
				rs.getInt("QQ_id"),
				rs.getInt("Post_Number"),
				rs.getString("M_items"),
				rs.getString("S_items"),
				rs.getString("Q_date"),
				rs.getString("Q_content"),
				rs.getInt("A_level"),
				rs.getInt("emergency"),
				rs.getString("Postpic_url"),
				rs.getInt("A_flag"),
				rs.getString("A_CONTENT"),
				rs.getString("NAME")
				);
				GetList2.add(Admin_);
			}
	  }  // エラー処理
	  catch (SQLException e) {
			e.printStackTrace();
			GetList2 = null;
	  }
	  catch (ClassNotFoundException e) {
			e.printStackTrace();
			GetList2 = null;
	  }
	  finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					GetList2 = null;
				}
			}
	  }return GetList2;	 	// 結果を返す
	}

// -----------管理画面へ出力---------------------------------------------------------------------------
	public List<Admin> DisplayPostGet(String post_number){
		  List<Admin> DisplayGetList = new ArrayList<Admin>();

	      Connection conn = null;					// 接続リセット

		  try {
	        // JDBCドライバの読み込み
			Class.forName("org.h2.Driver");
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/E-4/Qsama/data/E-4", "sa", "");

			// SQL文の準備 検索キーワードに対して、個別質問 + 管理テーブルを全出力
			String sql = "SELECT p.QQ_ID, p.POST_NUMBER, p.M_ITEMS, p.S_ITEMS, p.Q_DATE, p.Q_CONTENT, p.A_LEVEL, p.EMERGENCY,"
					+ "	p.POSTPIC_URL, m.A_FLAG, m.A_CONTENT, u.NAME"
					+ "	FROM POST_WORD as p inner join MANAGEMENT_WORD as m inner join p_user as u"
					+ "	on p.post_number=m.post_number on u.ac_id = p.ac_id"
					+ "	where p.Post_number="+post_number;

			PreparedStatement s_res = conn.prepareStatement(sql);

			// select文の実行
			ResultSet rs = s_res.executeQuery();

			// select文の結果をArrayListに格納
			while (rs.next()) {
				Admin Admin_ = new Admin(
					rs.getInt("QQ_id"),
					rs.getInt("Post_Number"),
					rs.getString("M_items"),
					rs.getString("S_items"),
					rs.getString("Q_date"),
					rs.getString("Q_content"),
					rs.getInt("A_level"),
					rs.getInt("emergency"),
					rs.getString("Postpic_url"),
					rs.getInt("A_flag"),
					rs.getString("A_CONTENT"),
					rs.getString("NAME")
					);
				DisplayGetList.add(Admin_);
				}
		  }  // エラー処理
		  catch (SQLException e) {
				e.printStackTrace();
				DisplayGetList = null;
		  }
		  catch (ClassNotFoundException e) {
				e.printStackTrace();
				DisplayGetList = null;
		  }
		  finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						DisplayGetList = null;
					}
				}
		  }return DisplayGetList;	 	// 結果を返す
		}


//---------------管理ページ：回答記入---------------------------------------------------------------------------
	public boolean PostAnswer(String post_number, String answer) {
		Connection conn = null;
		boolean result = false;

//------------------本日の日付を格納-----------------------------
		LocalDateTime nowDateTime = LocalDateTime.now();
		DateTimeFormatter datetimeformatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String today = datetimeformatter.format(nowDateTime);

//------------------ジャンルの更新-----------------------------
		UpdateItem(post_number);

	try {
		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		// データベースに接続する
		conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/E-4/Qsama/data/E-4", "sa", "");


		// SQL文を準備する
		String sql2 = "insert into MANAGEMENT_WORD ( POST_NUMBER, A_DATE, A_CONTENT, A_FLAG, AREA_OPEN) values"
				+ " ("+post_number+", '"+today+"', '"+answer+"', 1, 0)";

		PreparedStatement pStmt = conn.prepareStatement(sql2);

		// SQL文を実行する
		if (pStmt.executeUpdate() == 1) {
			result = true;
		}
	}
	catch (SQLException e) {
		e.printStackTrace();
	}
	catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	finally {
		// データベースを切断
		if (conn != null) {
			try {
				conn.commit();
				conn.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}return result;
}

	//---------------ジャンルの更新----223行目で実行--------------------------------------------------------------
		public boolean UpdateItem(String post_number) {
			Connection conn = null;
			boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/E-4/Qsama/data/E-4", "sa", "");


			// SQL文を準備する
			String sql2 = "update POST_WORD set M_ITEMS=?, S_ITEMS=? where post_number="+post_number;

			PreparedStatement pStmt = conn.prepareStatement(sql2);

			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.commit();
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}return result;
	}

		// -----------公開済のモーダルウィンドウ用(HTML)----------------------------------------------------------------
		public List<Admin> HtmlOpenModal(){
		  List<Admin> HtmlModalList = new ArrayList<Admin>();

	      Connection conn = null;					// 接続リセット

		  try {
	        // JDBCドライバの読み込み
			Class.forName("org.h2.Driver");
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/E-4/Qsama/data/E-4", "sa", "");

			// SQL文の準備 検索キーワードに対して、個別質問 + 管理テーブルを全出力
			String sql = "SELECT p.QQ_ID, p.POST_NUMBER, p.M_ITEMS, p.S_ITEMS, p.Q_DATE, p.Q_CONTENT, p.A_LEVEL, p.EMERGENCY,"
					+ "	p.POSTPIC_URL, m.A_FLAG, m.A_CONTENT, u.NAME"
					+ "	FROM POST_WORD as p inner join MANAGEMENT_WORD as m inner join p_user as u"
					+ "	on p.post_number=m.post_number on u.ac_id = p.ac_id"
					+ "	where m.area_open=1 and p.M_ITEMS='HTML' order by p.Q_DATE DESC";

			PreparedStatement s_res = conn.prepareStatement(sql);

			// select文の実行
			ResultSet rs = s_res.executeQuery();

			// select文の結果をArrayListに格納
			while (rs.next()) {
				Admin Admin_ = new Admin(
					rs.getInt("QQ_id"),
					rs.getInt("Post_Number"),
					rs.getString("M_items"),
					rs.getString("S_items"),
					rs.getString("Q_date"),
					rs.getString("Q_content"),
					rs.getInt("A_level"),
					rs.getInt("emergency"),
					rs.getString("Postpic_url"),
					rs.getInt("A_flag"),
					rs.getString("A_CONTENT"),
					rs.getString("NAME")
					);
				HtmlModalList.add(Admin_);
				}
		  }  // エラー処理
		  catch (SQLException e) {
				e.printStackTrace();
				HtmlModalList = null;
		  }
		  catch (ClassNotFoundException e) {
				e.printStackTrace();
				HtmlModalList = null;
		  }
		  finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						HtmlModalList = null;
					}
				}
		  }return HtmlModalList;	 	// 結果を返す
		}

		// -----------公開済のモーダルウィンドウ用(CSS)----------------------------------------------------------------
		public List<Admin> CssOpenModal(){
		  List<Admin> CssModalList = new ArrayList<Admin>();

	      Connection conn = null;					// 接続リセット

		  try {
	        // JDBCドライバの読み込み
			Class.forName("org.h2.Driver");
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/E-4/Qsama/data/E-4", "sa", "");

			// SQL文の準備 検索キーワードに対して、個別質問 + 管理テーブルを全出力
			String sql = "SELECT p.QQ_ID, p.POST_NUMBER, p.M_ITEMS, p.S_ITEMS, p.Q_DATE, p.Q_CONTENT, p.A_LEVEL, p.EMERGENCY,"
					+ "	p.POSTPIC_URL, m.A_FLAG, m.A_CONTENT, u.NAME"
					+ "	FROM POST_WORD as p inner join MANAGEMENT_WORD as m inner join p_user as u"
					+ "	on p.post_number=m.post_number on u.ac_id = p.ac_id"
					+ "	where m.area_open=1 and p.M_ITEMS='CSS' order by p.Q_DATE DESC";

			PreparedStatement s_res = conn.prepareStatement(sql);

			// select文の実行
			ResultSet rs = s_res.executeQuery();

			// select文の結果をArrayListに格納
			while (rs.next()) {
				Admin Admin_ = new Admin(
					rs.getInt("QQ_id"),
					rs.getInt("Post_Number"),
					rs.getString("M_items"),
					rs.getString("S_items"),
					rs.getString("Q_date"),
					rs.getString("Q_content"),
					rs.getInt("A_level"),
					rs.getInt("emergency"),
					rs.getString("Postpic_url"),
					rs.getInt("A_flag"),
					rs.getString("A_CONTENT"),
					rs.getString("NAME")
					);
				CssModalList.add(Admin_);
				}
		  }  // エラー処理
		  catch (SQLException e) {
				e.printStackTrace();
				CssModalList = null;
		  }
		  catch (ClassNotFoundException e) {
				e.printStackTrace();
				CssModalList = null;
		  }
		  finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						CssModalList = null;
					}
				}
		  }return CssModalList;	 	// 結果を返す
		}

		// -----------公開済のモーダルウィンドウ用(Javascript)----------------------------------------------------------------
		public List<Admin> JavascriptOpenModal(){
		  List<Admin> JavascriptModalList = new ArrayList<Admin>();

	      Connection conn = null;					// 接続リセット

		  try {
	        // JDBCドライバの読み込み
			Class.forName("org.h2.Driver");
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/E-4/Qsama/data/E-4", "sa", "");

			// SQL文の準備 検索キーワードに対して、個別質問 + 管理テーブルを全出力
			String sql = "SELECT p.QQ_ID, p.POST_NUMBER, p.M_ITEMS, p.S_ITEMS, p.Q_DATE, p.Q_CONTENT, p.A_LEVEL, p.EMERGENCY,"
					+ "	p.POSTPIC_URL, m.A_FLAG, m.A_CONTENT, u.NAME"
					+ "	FROM POST_WORD as p inner join MANAGEMENT_WORD as m inner join p_user as u"
					+ "	on p.post_number=m.post_number on u.ac_id = p.ac_id"
					+ "	where m.area_open=1 and p.M_ITEMS='JavaScript' order by p.Q_DATE DESC";

			PreparedStatement s_res = conn.prepareStatement(sql);

			// select文の実行
			ResultSet rs = s_res.executeQuery();

			// select文の結果をArrayListに格納
			while (rs.next()) {
				Admin Admin_ = new Admin(
					rs.getInt("QQ_id"),
					rs.getInt("Post_Number"),
					rs.getString("M_items"),
					rs.getString("S_items"),
					rs.getString("Q_date"),
					rs.getString("Q_content"),
					rs.getInt("A_level"),
					rs.getInt("emergency"),
					rs.getString("Postpic_url"),
					rs.getInt("A_flag"),
					rs.getString("A_CONTENT"),
					rs.getString("NAME")
					);
				JavascriptModalList.add(Admin_);
				}
		  }  // エラー処理
		  catch (SQLException e) {
				e.printStackTrace();
				JavascriptModalList = null;
		  }
		  catch (ClassNotFoundException e) {
				e.printStackTrace();
				JavascriptModalList = null;
		  }
		  finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						JavascriptModalList = null;
					}
				}
		  }return JavascriptModalList;	 	// 結果を返す
		}

		// -----------公開済のモーダルウィンドウ用(Java)----------------------------------------------------------------
		public List<Admin> JavaOpenModal(){
		  List<Admin> JavaModalList = new ArrayList<Admin>();

	      Connection conn = null;					// 接続リセット

		  try {
	        // JDBCドライバの読み込み
			Class.forName("org.h2.Driver");
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/E-4/Qsama/data/E-4", "sa", "");

			// SQL文の準備 検索キーワードに対して、個別質問 + 管理テーブルを全出力
			String sql = "SELECT p.QQ_ID, p.POST_NUMBER, p.M_ITEMS, p.S_ITEMS, p.Q_DATE, p.Q_CONTENT, p.A_LEVEL, p.EMERGENCY,"
					+ "	p.POSTPIC_URL, m.A_FLAG, m.A_CONTENT, u.NAME"
					+ "	FROM POST_WORD as p inner join MANAGEMENT_WORD as m inner join p_user as u"
					+ "	on p.post_number=m.post_number on u.ac_id = p.ac_id"
					+ "	where m.area_open=1 and p.M_ITEMS='Java' order by p.Q_DATE DESC";

			PreparedStatement s_res = conn.prepareStatement(sql);

			// select文の実行
			ResultSet rs = s_res.executeQuery();

			// select文の結果をArrayListに格納
			while (rs.next()) {
				Admin Admin_ = new Admin(
					rs.getInt("QQ_id"),
					rs.getInt("Post_Number"),
					rs.getString("M_items"),
					rs.getString("S_items"),
					rs.getString("Q_date"),
					rs.getString("Q_content"),
					rs.getInt("A_level"),
					rs.getInt("emergency"),
					rs.getString("Postpic_url"),
					rs.getInt("A_flag"),
					rs.getString("A_CONTENT"),
					rs.getString("NAME")
					);
				JavaModalList.add(Admin_);
				}
		  }  // エラー処理
		  catch (SQLException e) {
				e.printStackTrace();
				JavaModalList = null;
		  }
		  catch (ClassNotFoundException e) {
				e.printStackTrace();
				JavaModalList = null;
		  }
		  finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						JavaModalList = null;
					}
				}
		  }return JavaModalList;	 	// 結果を返す
		}

		// -----------公開済のモーダルウィンドウ用(SQL)----------------------------------------------------------------
		public List<Admin> SQLOpenModal(){
		  List<Admin> SQLModalList = new ArrayList<Admin>();

	      Connection conn = null;					// 接続リセット

		  try {
	        // JDBCドライバの読み込み
			Class.forName("org.h2.Driver");
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/E-4/Qsama/data/E-4", "sa", "");

			// SQL文の準備 検索キーワードに対して、個別質問 + 管理テーブルを全出力
			String sql = "SELECT p.QQ_ID, p.POST_NUMBER, p.M_ITEMS, p.S_ITEMS, p.Q_DATE, p.Q_CONTENT, p.A_LEVEL, p.EMERGENCY,"
					+ "	p.POSTPIC_URL, m.A_FLAG, m.A_CONTENT, u.NAME"
					+ "	FROM POST_WORD as p inner join MANAGEMENT_WORD as m inner join p_user as u"
					+ "	on p.post_number=m.post_number on u.ac_id = p.ac_id"
					+ "	where m.area_open=1 and p.M_ITEMS='SQL' order by p.Q_DATE DESC";

			PreparedStatement s_res = conn.prepareStatement(sql);

			// select文の実行
			ResultSet rs = s_res.executeQuery();

			// select文の結果をArrayListに格納
			while (rs.next()) {
				Admin Admin_ = new Admin(
					rs.getInt("QQ_id"),
					rs.getInt("Post_Number"),
					rs.getString("M_items"),
					rs.getString("S_items"),
					rs.getString("Q_date"),
					rs.getString("Q_content"),
					rs.getInt("A_level"),
					rs.getInt("emergency"),
					rs.getString("Postpic_url"),
					rs.getInt("A_flag"),
					rs.getString("A_CONTENT"),
					rs.getString("NAME")
					);
				SQLModalList.add(Admin_);
				}
		  }  // エラー処理
		  catch (SQLException e) {
				e.printStackTrace();
				SQLModalList = null;
		  }
		  catch (ClassNotFoundException e) {
				e.printStackTrace();
				SQLModalList = null;
		  }
		  finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						SQLModalList = null;
					}
				}
		  }return SQLModalList;	 	// 結果を返す
		}

		// -----------公開済のモーダルウィンドウ用(ｻｰﾌﾞﾚｯﾄ・JSP)----------------------------------------------------------------
		public List<Admin> SJspOpenModal(){
		  List<Admin> SJspModalList = new ArrayList<Admin>();

	      Connection conn = null;					// 接続リセット

		  try {
	        // JDBCドライバの読み込み
			Class.forName("org.h2.Driver");
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/E-4/Qsama/data/E-4", "sa", "");

			// SQL文の準備 検索キーワードに対して、個別質問 + 管理テーブルを全出力
			String sql = "SELECT p.QQ_ID, p.POST_NUMBER, p.M_ITEMS, p.S_ITEMS, p.Q_DATE, p.Q_CONTENT, p.A_LEVEL, p.EMERGENCY,"
					+ "	p.POSTPIC_URL, m.A_FLAG, m.A_CONTENT, u.NAME"
					+ "	FROM POST_WORD as p inner join MANAGEMENT_WORD as m inner join p_user as u"
					+ "	on p.post_number=m.post_number on u.ac_id = p.ac_id"
					+ "	where m.area_open=1 and p.M_ITEMS='ｻｰﾌﾞﾚｯﾄ・JSP' order by p.Q_DATE DESC";

			PreparedStatement s_res = conn.prepareStatement(sql);

			// select文の実行
			ResultSet rs = s_res.executeQuery();

			// select文の結果をArrayListに格納
			while (rs.next()) {
				Admin Admin_ = new Admin(
					rs.getInt("QQ_id"),
					rs.getInt("Post_Number"),
					rs.getString("M_items"),
					rs.getString("S_items"),
					rs.getString("Q_date"),
					rs.getString("Q_content"),
					rs.getInt("A_level"),
					rs.getInt("emergency"),
					rs.getString("Postpic_url"),
					rs.getInt("A_flag"),
					rs.getString("A_CONTENT"),
					rs.getString("NAME")
					);
				SJspModalList.add(Admin_);
				}
		  }  // エラー処理
		  catch (SQLException e) {
				e.printStackTrace();
				SJspModalList = null;
		  }
		  catch (ClassNotFoundException e) {
				e.printStackTrace();
				SJspModalList = null;
		  }
		  finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						SJspModalList = null;
					}
				}
		  }return SJspModalList;	 	// 結果を返す
		}

		// -----------公開済のモーダルウィンドウ用(段位認定)----------------------------------------------------------------
		public List<Admin> DanOpenModal(){
		  List<Admin> DanModalList = new ArrayList<Admin>();

	      Connection conn = null;					// 接続リセット

		  try {
	        // JDBCドライバの読み込み
			Class.forName("org.h2.Driver");
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/E-4/Qsama/data/E-4", "sa", "");

			// SQL文の準備 検索キーワードに対して、個別質問 + 管理テーブルを全出力
			String sql = "SELECT p.QQ_ID, p.POST_NUMBER, p.M_ITEMS, p.S_ITEMS, p.Q_DATE, p.Q_CONTENT, p.A_LEVEL, p.EMERGENCY,"
					+ "	p.POSTPIC_URL, m.A_FLAG, m.A_CONTENT, u.NAME"
					+ "	FROM POST_WORD as p inner join MANAGEMENT_WORD as m inner join p_user as u"
					+ "	on p.post_number=m.post_number on u.ac_id = p.ac_id"
					+ "	where m.area_open=1 and p.M_ITEMS='段位認定' order by p.Q_DATE DESC";

			PreparedStatement s_res = conn.prepareStatement(sql);

			// select文の実行
			ResultSet rs = s_res.executeQuery();

			// select文の結果をArrayListに格納
			while (rs.next()) {
				Admin Admin_ = new Admin(
					rs.getInt("QQ_id"),
					rs.getInt("Post_Number"),
					rs.getString("M_items"),
					rs.getString("S_items"),
					rs.getString("Q_date"),
					rs.getString("Q_content"),
					rs.getInt("A_level"),
					rs.getInt("emergency"),
					rs.getString("Postpic_url"),
					rs.getInt("A_flag"),
					rs.getString("A_CONTENT"),
					rs.getString("NAME")
					);
				DanModalList.add(Admin_);
				}
		  }  // エラー処理
		  catch (SQLException e) {
				e.printStackTrace();
				DanModalList = null;
		  }
		  catch (ClassNotFoundException e) {
				e.printStackTrace();
				DanModalList = null;
		  }
		  finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						DanModalList = null;
					}
				}
		  }return DanModalList;	 	// 結果を返す
		}

		// -----------公開済のモーダルウィンドウ用(ドリル)----------------------------------------------------------------
		public List<Admin> DrillOpenModal(){
		  List<Admin> DrillModalList = new ArrayList<Admin>();

	      Connection conn = null;					// 接続リセット

		  try {
	        // JDBCドライバの読み込み
			Class.forName("org.h2.Driver");
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/E-4/Qsama/data/E-4", "sa", "");

			// SQL文の準備 検索キーワードに対して、個別質問 + 管理テーブルを全出力
			String sql = "SELECT p.QQ_ID, p.POST_NUMBER, p.M_ITEMS, p.S_ITEMS, p.Q_DATE, p.Q_CONTENT, p.A_LEVEL, p.EMERGENCY,"
					+ "	p.POSTPIC_URL, m.A_FLAG, m.A_CONTENT, u.NAME"
					+ "	FROM POST_WORD as p inner join MANAGEMENT_WORD as m inner join p_user as u"
					+ "	on p.post_number=m.post_number on u.ac_id = p.ac_id"
					+ "	where m.area_open=1 and p.M_ITEMS='ﾄﾞﾘﾙ' order by p.Q_DATE DESC";

			PreparedStatement s_res = conn.prepareStatement(sql);

			// select文の実行
			ResultSet rs = s_res.executeQuery();

			// select文の結果をArrayListに格納
			while (rs.next()) {
				Admin Admin_ = new Admin(
					rs.getInt("QQ_id"),
					rs.getInt("Post_Number"),
					rs.getString("M_items"),
					rs.getString("S_items"),
					rs.getString("Q_date"),
					rs.getString("Q_content"),
					rs.getInt("A_level"),
					rs.getInt("emergency"),
					rs.getString("Postpic_url"),
					rs.getInt("A_flag"),
					rs.getString("A_CONTENT"),
					rs.getString("NAME")
					);
				DrillModalList.add(Admin_);
				}
		  }  // エラー処理
		  catch (SQLException e) {
				e.printStackTrace();
				DrillModalList = null;
		  }
		  catch (ClassNotFoundException e) {
				e.printStackTrace();
				DrillModalList = null;
		  }
		  finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						DrillModalList = null;
					}
				}
		  }return DrillModalList;	 	// 結果を返す
		}

		// -----------非公開のモーダルウィンドウ用(HTML)----------------------------------------------------------------
		public List<Admin> HtmlCloseModal(){
		  List<Admin> Html2ModalList = new ArrayList<Admin>();

	      Connection conn = null;					// 接続リセット

		  try {
	        // JDBCドライバの読み込み
			Class.forName("org.h2.Driver");
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/E-4/Qsama/data/E-4", "sa", "");

			// SQL文の準備 検索キーワードに対して、個別質問 + 管理テーブルを全出力
			String sql = "SELECT p.QQ_ID, p.POST_NUMBER, p.M_ITEMS, p.S_ITEMS, p.Q_DATE, p.Q_CONTENT, p.A_LEVEL, p.EMERGENCY,"
					+ "	p.POSTPIC_URL, m.A_FLAG, m.A_CONTENT, u.NAME"
					+ "	FROM POST_WORD as p inner join MANAGEMENT_WORD as m inner join p_user as u"
					+ "	on p.post_number=m.post_number on u.ac_id = p.ac_id"
					+ "	where m.area_open=0 and p.M_ITEMS='HTML' order by p.Q_DATE DESC";

			PreparedStatement s_res = conn.prepareStatement(sql);

			// select文の実行
			ResultSet rs = s_res.executeQuery();

			// select文の結果をArrayListに格納
			while (rs.next()) {
				Admin Admin_ = new Admin(
					rs.getInt("QQ_id"),
					rs.getInt("Post_Number"),
					rs.getString("M_items"),
					rs.getString("S_items"),
					rs.getString("Q_date"),
					rs.getString("Q_content"),
					rs.getInt("A_level"),
					rs.getInt("emergency"),
					rs.getString("Postpic_url"),
					rs.getInt("A_flag"),
					rs.getString("A_CONTENT"),
					rs.getString("NAME")
					);
				Html2ModalList.add(Admin_);
				}
		  }  // エラー処理
		  catch (SQLException e) {
				e.printStackTrace();
				Html2ModalList = null;
		  }
		  catch (ClassNotFoundException e) {
				e.printStackTrace();
				Html2ModalList = null;
		  }
		  finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						Html2ModalList = null;
					}
				}
		  }return Html2ModalList;	 	// 結果を返す
		}

		// -----------公開済のモーダルウィンドウ用(CSS)----------------------------------------------------------------
		public List<Admin> CssCloseModal(){
		  List<Admin> Css2ModalList = new ArrayList<Admin>();

	      Connection conn = null;					// 接続リセット

		  try {
	        // JDBCドライバの読み込み
			Class.forName("org.h2.Driver");
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/E-4/Qsama/data/E-4", "sa", "");

			// SQL文の準備 検索キーワードに対して、個別質問 + 管理テーブルを全出力
			String sql = "SELECT p.QQ_ID, p.POST_NUMBER, p.M_ITEMS, p.S_ITEMS, p.Q_DATE, p.Q_CONTENT, p.A_LEVEL, p.EMERGENCY,"
					+ "	p.POSTPIC_URL, m.A_FLAG, m.A_CONTENT, u.NAME"
					+ "	FROM POST_WORD as p inner join MANAGEMENT_WORD as m inner join p_user as u"
					+ "	on p.post_number=m.post_number on u.ac_id = p.ac_id"
					+ "	where m.area_open=0 and p.M_ITEMS='CSS' order by p.Q_DATE DESC";

			PreparedStatement s_res = conn.prepareStatement(sql);

			// select文の実行
			ResultSet rs = s_res.executeQuery();

			// select文の結果をArrayListに格納
			while (rs.next()) {
				Admin Admin_ = new Admin(
					rs.getInt("QQ_id"),
					rs.getInt("Post_Number"),
					rs.getString("M_items"),
					rs.getString("S_items"),
					rs.getString("Q_date"),
					rs.getString("Q_content"),
					rs.getInt("A_level"),
					rs.getInt("emergency"),
					rs.getString("Postpic_url"),
					rs.getInt("A_flag"),
					rs.getString("A_CONTENT"),
					rs.getString("NAME")
					);
				Css2ModalList.add(Admin_);
				}
		  }  // エラー処理
		  catch (SQLException e) {
				e.printStackTrace();
				Css2ModalList = null;
		  }
		  catch (ClassNotFoundException e) {
				e.printStackTrace();
				Css2ModalList = null;
		  }
		  finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						Css2ModalList = null;
					}
				}
		  }return Css2ModalList;	 	// 結果を返す
		}

		// -----------公開済のモーダルウィンドウ用(Javascript)----------------------------------------------------------------
		public List<Admin> JavascriptCloseModal(){
		  List<Admin> Javascript2ModalList = new ArrayList<Admin>();

	      Connection conn = null;					// 接続リセット

		  try {
	        // JDBCドライバの読み込み
			Class.forName("org.h2.Driver");
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/E-4/Qsama/data/E-4", "sa", "");

			// SQL文の準備 検索キーワードに対して、個別質問 + 管理テーブルを全出力
			String sql = "SELECT p.QQ_ID, p.POST_NUMBER, p.M_ITEMS, p.S_ITEMS, p.Q_DATE, p.Q_CONTENT, p.A_LEVEL, p.EMERGENCY,"
					+ "	p.POSTPIC_URL, m.A_FLAG, m.A_CONTENT, u.NAME"
					+ "	FROM POST_WORD as p inner join MANAGEMENT_WORD as m inner join p_user as u"
					+ "	on p.post_number=m.post_number on u.ac_id = p.ac_id"
					+ "	where m.area_open=0 and p.M_ITEMS='JavaScript' order by p.Q_DATE DESC";

			PreparedStatement s_res = conn.prepareStatement(sql);

			// select文の実行
			ResultSet rs = s_res.executeQuery();

			// select文の結果をArrayListに格納
			while (rs.next()) {
				Admin Admin_ = new Admin(
					rs.getInt("QQ_id"),
					rs.getInt("Post_Number"),
					rs.getString("M_items"),
					rs.getString("S_items"),
					rs.getString("Q_date"),
					rs.getString("Q_content"),
					rs.getInt("A_level"),
					rs.getInt("emergency"),
					rs.getString("Postpic_url"),
					rs.getInt("A_flag"),
					rs.getString("A_CONTENT"),
					rs.getString("NAME")
					);
				Javascript2ModalList.add(Admin_);
				}
		  }  // エラー処理
		  catch (SQLException e) {
				e.printStackTrace();
				Javascript2ModalList = null;
		  }
		  catch (ClassNotFoundException e) {
				e.printStackTrace();
				Javascript2ModalList = null;
		  }
		  finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						Javascript2ModalList = null;
					}
				}
		  }return Javascript2ModalList;	 	// 結果を返す
		}

		// -----------公開済のモーダルウィンドウ用(Java)----------------------------------------------------------------
		public List<Admin> JavaCloseModal(){
		  List<Admin> Java2ModalList = new ArrayList<Admin>();

	      Connection conn = null;					// 接続リセット

		  try {
	        // JDBCドライバの読み込み
			Class.forName("org.h2.Driver");
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/E-4/Qsama/data/E-4", "sa", "");

			// SQL文の準備 検索キーワードに対して、個別質問 + 管理テーブルを全出力
			String sql = "SELECT p.QQ_ID, p.POST_NUMBER, p.M_ITEMS, p.S_ITEMS, p.Q_DATE, p.Q_CONTENT, p.A_LEVEL, p.EMERGENCY,"
					+ "	p.POSTPIC_URL, m.A_FLAG, m.A_CONTENT, u.NAME"
					+ "	FROM POST_WORD as p inner join MANAGEMENT_WORD as m inner join p_user as u"
					+ "	on p.post_number=m.post_number on u.ac_id = p.ac_id"
					+ "	where m.area_open=0 and p.M_ITEMS='Java' order by p.Q_DATE DESC";

			PreparedStatement s_res = conn.prepareStatement(sql);

			// select文の実行
			ResultSet rs = s_res.executeQuery();

			// select文の結果をArrayListに格納
			while (rs.next()) {
				Admin Admin_ = new Admin(
					rs.getInt("QQ_id"),
					rs.getInt("Post_Number"),
					rs.getString("M_items"),
					rs.getString("S_items"),
					rs.getString("Q_date"),
					rs.getString("Q_content"),
					rs.getInt("A_level"),
					rs.getInt("emergency"),
					rs.getString("Postpic_url"),
					rs.getInt("A_flag"),
					rs.getString("A_CONTENT"),
					rs.getString("NAME")
					);
				Java2ModalList.add(Admin_);
				}
		  }  // エラー処理
		  catch (SQLException e) {
				e.printStackTrace();
				Java2ModalList = null;
		  }
		  catch (ClassNotFoundException e) {
				e.printStackTrace();
				Java2ModalList = null;
		  }
		  finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						Java2ModalList = null;
					}
				}
		  }return Java2ModalList;	 	// 結果を返す
		}

		// -----------公開済のモーダルウィンドウ用(SQL)----------------------------------------------------------------
		public List<Admin> SQLCloseModal(){
		  List<Admin> SQL2ModalList = new ArrayList<Admin>();

	      Connection conn = null;					// 接続リセット

		  try {
	        // JDBCドライバの読み込み
			Class.forName("org.h2.Driver");
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/E-4/Qsama/data/E-4", "sa", "");

			// SQL文の準備 検索キーワードに対して、個別質問 + 管理テーブルを全出力
			String sql = "SELECT p.QQ_ID, p.POST_NUMBER, p.M_ITEMS, p.S_ITEMS, p.Q_DATE, p.Q_CONTENT, p.A_LEVEL, p.EMERGENCY,"
					+ "	p.POSTPIC_URL, m.A_FLAG, m.A_CONTENT, u.NAME"
					+ "	FROM POST_WORD as p inner join MANAGEMENT_WORD as m inner join p_user as u"
					+ "	on p.post_number=m.post_number on u.ac_id = p.ac_id"
					+ "	where m.area_open=0 and p.M_ITEMS='SQL' order by p.Q_DATE DESC";

			PreparedStatement s_res = conn.prepareStatement(sql);

			// select文の実行
			ResultSet rs = s_res.executeQuery();

			// select文の結果をArrayListに格納
			while (rs.next()) {
				Admin Admin_ = new Admin(
					rs.getInt("QQ_id"),
					rs.getInt("Post_Number"),
					rs.getString("M_items"),
					rs.getString("S_items"),
					rs.getString("Q_date"),
					rs.getString("Q_content"),
					rs.getInt("A_level"),
					rs.getInt("emergency"),
					rs.getString("Postpic_url"),
					rs.getInt("A_flag"),
					rs.getString("A_CONTENT"),
					rs.getString("NAME")
					);
				SQL2ModalList.add(Admin_);
				}
		  }  // エラー処理
		  catch (SQLException e) {
				e.printStackTrace();
				SQL2ModalList = null;
		  }
		  catch (ClassNotFoundException e) {
				e.printStackTrace();
				SQL2ModalList = null;
		  }
		  finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						SQL2ModalList = null;
					}
				}
		  }return SQL2ModalList;	 	// 結果を返す
		}

		// -----------公開済のモーダルウィンドウ用(ｻｰﾌﾞﾚｯﾄ・JSP)----------------------------------------------------------------
		public List<Admin> SJspCloseModal(){
		  List<Admin> SJsp2ModalList = new ArrayList<Admin>();

	      Connection conn = null;					// 接続リセット

		  try {
	        // JDBCドライバの読み込み
			Class.forName("org.h2.Driver");
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/E-4/Qsama/data/E-4", "sa", "");

			// SQL文の準備 検索キーワードに対して、個別質問 + 管理テーブルを全出力
			String sql = "SELECT p.QQ_ID, p.POST_NUMBER, p.M_ITEMS, p.S_ITEMS, p.Q_DATE, p.Q_CONTENT, p.A_LEVEL, p.EMERGENCY,"
					+ "	p.POSTPIC_URL, m.A_FLAG, m.A_CONTENT, u.NAME"
					+ "	FROM POST_WORD as p inner join MANAGEMENT_WORD as m inner join p_user as u"
					+ "	on p.post_number=m.post_number on u.ac_id = p.ac_id"
					+ "	where m.area_open=0 and p.M_ITEMS='ｻｰﾌﾞﾚｯﾄ・JSP' order by p.Q_DATE DESC";

			PreparedStatement s_res = conn.prepareStatement(sql);

			// select文の実行
			ResultSet rs = s_res.executeQuery();

			// select文の結果をArrayListに格納
			while (rs.next()) {
				Admin Admin_ = new Admin(
					rs.getInt("QQ_id"),
					rs.getInt("Post_Number"),
					rs.getString("M_items"),
					rs.getString("S_items"),
					rs.getString("Q_date"),
					rs.getString("Q_content"),
					rs.getInt("A_level"),
					rs.getInt("emergency"),
					rs.getString("Postpic_url"),
					rs.getInt("A_flag"),
					rs.getString("A_CONTENT"),
					rs.getString("NAME")
					);
				SJsp2ModalList.add(Admin_);
				}
		  }  // エラー処理
		  catch (SQLException e) {
				e.printStackTrace();
				SJsp2ModalList = null;
		  }
		  catch (ClassNotFoundException e) {
				e.printStackTrace();
				SJsp2ModalList = null;
		  }
		  finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						SJsp2ModalList = null;
					}
				}
		  }return SJsp2ModalList;	 	// 結果を返す
		}

		// -----------公開済のモーダルウィンドウ用(段位認定)----------------------------------------------------------------
		public List<Admin> DanCloseModal(){
		  List<Admin> Dan2ModalList = new ArrayList<Admin>();

	      Connection conn = null;					// 接続リセット

		  try {
	        // JDBCドライバの読み込み
			Class.forName("org.h2.Driver");
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/E-4/Qsama/data/E-4", "sa", "");

			// SQL文の準備 検索キーワードに対して、個別質問 + 管理テーブルを全出力
			String sql = "SELECT p.QQ_ID, p.POST_NUMBER, p.M_ITEMS, p.S_ITEMS, p.Q_DATE, p.Q_CONTENT, p.A_LEVEL, p.EMERGENCY,"
					+ "	p.POSTPIC_URL, m.A_FLAG, m.A_CONTENT, u.NAME"
					+ "	FROM POST_WORD as p inner join MANAGEMENT_WORD as m inner join p_user as u"
					+ "	on p.post_number=m.post_number on u.ac_id = p.ac_id"
					+ "	where m.area_open=0 and p.M_ITEMS='段位認定' order by p.Q_DATE DESC";

			PreparedStatement s_res = conn.prepareStatement(sql);

			// select文の実行
			ResultSet rs = s_res.executeQuery();

			// select文の結果をArrayListに格納
			while (rs.next()) {
				Admin Admin_ = new Admin(
					rs.getInt("QQ_id"),
					rs.getInt("Post_Number"),
					rs.getString("M_items"),
					rs.getString("S_items"),
					rs.getString("Q_date"),
					rs.getString("Q_content"),
					rs.getInt("A_level"),
					rs.getInt("emergency"),
					rs.getString("Postpic_url"),
					rs.getInt("A_flag"),
					rs.getString("A_CONTENT"),
					rs.getString("NAME")
					);
				Dan2ModalList.add(Admin_);
				}
		  }  // エラー処理
		  catch (SQLException e) {
				e.printStackTrace();
				Dan2ModalList = null;
		  }
		  catch (ClassNotFoundException e) {
				e.printStackTrace();
				Dan2ModalList = null;
		  }
		  finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						Dan2ModalList = null;
					}
				}
		  }return Dan2ModalList;	 	// 結果を返す
		}

		// -----------公開済のモーダルウィンドウ用(ドリル)----------------------------------------------------------------
		public List<Admin> DrillCloseModal(){
		  List<Admin> Drill2ModalList = new ArrayList<Admin>();

	      Connection conn = null;					// 接続リセット

		  try {
	        // JDBCドライバの読み込み
			Class.forName("org.h2.Driver");
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/E-4/Qsama/data/E-4", "sa", "");

			// SQL文の準備 検索キーワードに対して、個別質問 + 管理テーブルを全出力
			String sql = "SELECT p.QQ_ID, p.POST_NUMBER, p.M_ITEMS, p.S_ITEMS, p.Q_DATE, p.Q_CONTENT, p.A_LEVEL, p.EMERGENCY,"
					+ "	p.POSTPIC_URL, m.A_FLAG, m.A_CONTENT, u.NAME"
					+ "	FROM POST_WORD as p inner join MANAGEMENT_WORD as m inner join p_user as u"
					+ "	on p.post_number=m.post_number on u.ac_id = p.ac_id"
					+ "	where m.area_open=0 and p.M_ITEMS='ﾄﾞﾘﾙ' order by p.Q_DATE DESC";

			PreparedStatement s_res = conn.prepareStatement(sql);

			// select文の実行
			ResultSet rs = s_res.executeQuery();

			// select文の結果をArrayListに格納
			while (rs.next()) {
				Admin Admin_ = new Admin(
					rs.getInt("QQ_id"),
					rs.getInt("Post_Number"),
					rs.getString("M_items"),
					rs.getString("S_items"),
					rs.getString("Q_date"),
					rs.getString("Q_content"),
					rs.getInt("A_level"),
					rs.getInt("emergency"),
					rs.getString("Postpic_url"),
					rs.getInt("A_flag"),
					rs.getString("A_CONTENT"),
					rs.getString("NAME")
					);
				Drill2ModalList.add(Admin_);
				}
		  }  // エラー処理
		  catch (SQLException e) {
				e.printStackTrace();
				Drill2ModalList = null;
		  }
		  catch (ClassNotFoundException e) {
				e.printStackTrace();
				Drill2ModalList = null;
		  }
		  finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						Drill2ModalList = null;
					}
				}
		  }return Drill2ModalList;	 	// 結果を返す
		}

		// -----------公開停止ボタン----------------------------------------------------------------
		public boolean StopPublishing(String areapost_number) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/E-4/Qsama/data/E-4", "sa", "");

				// insert文を準備する
				String sql = "update MANAGEMENT_WORD set area_open=0 where post_number="+areapost_number;

				PreparedStatement pStmt = conn.prepareStatement(sql);

				// insert文を実行する
				if (pStmt.executeUpdate() == 1) {
					result = true;
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			// 結果を返す
			return result;
		}

		// -----------公開ボタン----------------------------------------------------------------
		public boolean Release(String areapost_number) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/E-4/Qsama/data/E-4", "sa", "");

				// insert文を準備する
				String sql = "update MANAGEMENT_WORD set area_open=1 where post_number="+areapost_number;

				PreparedStatement pStmt = conn.prepareStatement(sql);

				// insert文を実行する
				if (pStmt.executeUpdate() == 1) {
					result = true;
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			// 結果を返す
			return result;
		}

		// -----------生徒別で過去の質問を検索---------------------------------------------------------------------------
		public List<Admin> Student_Search(String Name){
		  List<Admin> StudentList = new ArrayList<Admin>();

	      Connection conn = null;					// 接続リセット

		  try {
	        // JDBCドライバの読み込み
			Class.forName("org.h2.Driver");
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/E-4/Qsama/data/E-4", "sa", "");

			// SQL文の準備 検索キーワードに対して、個別質問 + 管理テーブルを全出力
			String sql = "SELECT p.QQ_ID, p.POST_NUMBER, p.M_ITEMS, p.S_ITEMS, p.Q_DATE, p.Q_CONTENT, p.A_LEVEL, p.EMERGENCY,"
					+ "	p.POSTPIC_URL, m.A_FLAG, m.A_CONTENT, u.NAME"
					+ "	FROM POST_WORD as p inner join MANAGEMENT_WORD as m inner join p_user as u"
					+ "	on p.post_number=m.post_number on u.ac_id = p.ac_id"
					+ "	where u.NAME='"+Name+"' order by p.Q_DATE DESC";

			PreparedStatement s_res = conn.prepareStatement(sql);

			// select文の実行
			ResultSet rs = s_res.executeQuery();

			// select文の結果をArrayListに格納
			while (rs.next()) {
				Admin Admin_ = new Admin(
					rs.getInt("QQ_id"),
					rs.getInt("Post_Number"),
					rs.getString("M_items"),
					rs.getString("S_items"),
					rs.getString("Q_date"),
					rs.getString("Q_content"),
					rs.getInt("A_level"),
					rs.getInt("emergency"),
					rs.getString("Postpic_url"),
					rs.getInt("A_flag"),
					rs.getString("A_CONTENT"),
					rs.getString("NAME")
					);
				StudentList.add(Admin_);
				}
		  }  // エラー処理
		  catch (SQLException e) {
				e.printStackTrace();
				StudentList = null;
		  }
		  catch (ClassNotFoundException e) {
				e.printStackTrace();
				StudentList = null;
		  }
		  finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						StudentList = null;
					}
				}
		  }return StudentList;	 	// 結果を返す
		}

}