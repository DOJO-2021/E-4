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
}}