package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.S_Main;

public class MainDAO {
	// お知らせ機能
	public List<S_Main> Notice(String user_id) {
		List<S_Main> NoticeList = new ArrayList<S_Main>();
	      Connection conn = null;
	      try {

		        // JDBCドライバの読み込み
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/E-4/Qsama/data/E-4", "sa", "");

				// SQL文の準備 回答フラグを取得 ac_idを一致させる
				String sql = "SELECT l.user_id, l.ac_id, p.q_date, p.m_items, m.a_flag FROM login as l INNER JOIN management_word  as m INNER JOIN post_word  as p"
						+ " on l.ac_id=p.ac_id on m.post_number = p.post_number  where m.a_flag=1 and l.user_id= '"+user_id +"' order by p.q_date desc";

				PreparedStatement pStmt = conn.prepareStatement(sql);

				// select文の実行
				ResultSet rs = pStmt.executeQuery();

				// selet文の結果をArrayListに格納
				while (rs.next()) {
					S_Main recent = new S_Main(
						rs.getInt("ac_id"),
						rs.getInt("A_flag"),
						rs.getString("M_items"),
						rs.getString("Q_date")
						);
					NoticeList.add(recent);
					}


			  }  // エラー処理
				catch (SQLException e) {
					e.printStackTrace();
					NoticeList = null;
				}
				catch (ClassNotFoundException e) {
					e.printStackTrace();
					NoticeList = null;
				}
				finally {
					// データベースを切断
					if (conn != null) {
						try {
							conn.close();
						}
						catch (SQLException e) {
							e.printStackTrace();
							NoticeList = null;
						}
					}
				}

				// 結果を返す
				return NoticeList;
	}

	//過去に投稿された質問のリスト
	public List<S_Main> RecentQ(){
		List<S_Main> RecentqList = new ArrayList<S_Main>();

	      Connection conn = null;

		  try {

	        // JDBCドライバの読み込み
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/E-4/Qsama/data/E-4", "sa", "");

			// SQL文の準備
			String sql ="select * from post_word order by q_date desc";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// select文の実行
			ResultSet rs = pStmt.executeQuery();

			// selet文の結果をArrayListに格納
			while (rs.next()) {
				S_Main recent = new S_Main(
					rs.getInt("ac_id"),
					rs.getString("M_items"),
					rs.getString("Q_date"),
					rs.getString("Q_content")
					);
					RecentqList.add(recent);
				}


		  }  // エラー処理
			catch (SQLException e) {
				e.printStackTrace();
				RecentqList = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				RecentqList = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						RecentqList = null;
					}
				}
			}

			// 結果を返す
			return RecentqList;
		 }

	//HTMLの解決済みの質問
	public List<S_Main> ResolvedQuestion() {
		List<S_Main> ResoledQList = new ArrayList<S_Main>();

	      Connection conn = null;

		  try {

	        // JDBCドライバの読み込み
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/E-4/Qsama/data/E-4", "sa", "");

			// SQL文の準備
			String sql ="select p.qq_id, p.ac_id, p.m_items, p.Q_date, p.q_content, p.q_flag, m.a_content, m.aa_id from post_word as p INNER JOIN management_word as m  ON p.qq_id = m.aa_id where p.m_items = 'HTML' and p.Q_FLAG = '1'";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// select文の実行
			ResultSet rs = pStmt.executeQuery();

			// selet文の結果をArrayListに格納
			while (rs.next()) {
				S_Main recent1 = new S_Main(
					rs.getInt("qq_id"),
					rs.getInt("aa_id"),
					rs.getInt("ac_id"),
					rs.getString("M_items"),
					rs.getString("Q_date"),
					rs.getString("Q_content"),
					rs.getInt("Q_flag"),
					rs.getString("A_content")
					);
					ResoledQList.add(recent1);

				}


		  }  // エラー処理
			catch (SQLException e) {
				e.printStackTrace();
				ResoledQList = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				ResoledQList = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						ResoledQList = null;
					}
				}
			}

			// 結果を返す
			return ResoledQList;
		 }

	//CSSの解決済みの質問
	public List<S_Main> ResolvedQuestion2() {
		List<S_Main> ResoledQList2 = new ArrayList<S_Main>();

	      Connection conn = null;

		  try {

	        // JDBCドライバの読み込み
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/E-4/Qsama/data/E-4", "sa", "");

			// SQL文の準備
			String sql ="select p.qq_id, p.ac_id, p.m_items, p.Q_date, p.q_content, p.q_flag, m.a_content, m.aa_id from post_word as p INNER JOIN management_word as m  ON p.qq_id = m.aa_id where p.m_items = 'CSS' and p.Q_FLAG = '1'";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// select文の実行
			ResultSet rs = pStmt.executeQuery();

			// selet文の結果をArrayListに格納
			while (rs.next()) {
				S_Main recent1 = new S_Main(
						rs.getInt("qq_id"),
						rs.getInt("aa_id"),
						rs.getInt("ac_id"),
						rs.getString("M_items"),
						rs.getString("Q_date"),
						rs.getString("Q_content"),
						rs.getInt("Q_flag"),
						rs.getString("A_content")
					);
					ResoledQList2.add(recent1);
				}


		  }  // エラー処理
			catch (SQLException e) {
				e.printStackTrace();
				ResoledQList2 = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				ResoledQList2 = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						ResoledQList2 = null;
					}
				}
			}

			// 結果を返す
			return ResoledQList2;
		 }

	//JavaScriptの解決済みの質問
	public List<S_Main> ResolvedQuestion3() {
		List<S_Main> ResoledQList3 = new ArrayList<S_Main>();

	      Connection conn = null;

		  try {

	        // JDBCドライバの読み込み
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/E-4/Qsama/data/E-4", "sa", "");

			// SQL文の準備
			String sql ="select p.qq_id, p.ac_id, p.m_items, p.Q_date, p.q_content, p.q_flag, m.a_content, m.aa_id from post_word as p INNER JOIN management_word as m  ON p.qq_id = m.aa_id where p.m_items = 'JavaScript' and p.Q_FLAG = '1'";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// select文の実行
			ResultSet rs = pStmt.executeQuery();

			// selet文の結果をArrayListに格納
			while (rs.next()) {
				S_Main recent1 = new S_Main(
						rs.getInt("qq_id"),
						rs.getInt("aa_id"),
						rs.getInt("ac_id"),
						rs.getString("M_items"),
						rs.getString("Q_date"),
						rs.getString("Q_content"),
						rs.getInt("Q_flag"),
						rs.getString("A_content")
					);
					ResoledQList3.add(recent1);

				}


		  }  // エラー処理
			catch (SQLException e) {
				e.printStackTrace();
				ResoledQList3 = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				ResoledQList3 = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						ResoledQList3 = null;
					}
				}
			}

			// 結果を返す
			return ResoledQList3;
		 }

	//Javaの解決済みの質問
	public List<S_Main> ResolvedQuestion4() {
		List<S_Main> ResoledQList4 = new ArrayList<S_Main>();

	      Connection conn = null;

		  try {

	        // JDBCドライバの読み込み
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/E-4/Qsama/data/E-4", "sa", "");

			// SQL文の準備
			String sql ="select p.qq_id, p.ac_id, p.m_items, p.Q_date, p.q_content, p.q_flag, m.a_content, m.aa_id from post_word as p INNER JOIN management_word as m  ON p.qq_id = m.aa_id where p.m_items = 'Java' and p.Q_FLAG = '1'";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// select文の実行
			ResultSet rs = pStmt.executeQuery();

			// selet文の結果をArrayListに格納
			while (rs.next()) {
				S_Main recent1 = new S_Main(
						rs.getInt("qq_id"),
						rs.getInt("aa_id"),
						rs.getInt("ac_id"),
						rs.getString("M_items"),
						rs.getString("Q_date"),
						rs.getString("Q_content"),
						rs.getInt("Q_flag"),
						rs.getString("A_content")
					);
					ResoledQList4.add(recent1);

				}


		  }  // エラー処理
			catch (SQLException e) {
				e.printStackTrace();
				ResoledQList4 = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				ResoledQList4 = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						ResoledQList4 = null;
					}
				}
			}

			// 結果を返す
			return ResoledQList4;
		 }

	//SQLの解決済みの質問
	public List<S_Main> ResolvedQuestion5() {
		List<S_Main> ResoledQList5 = new ArrayList<S_Main>();

	      Connection conn = null;

		  try {

	        // JDBCドライバの読み込み
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/E-4/Qsama/data/E-4", "sa", "");

			// SQL文の準備
			String sql ="select p.qq_id, p.ac_id, p.m_items, p.Q_date, p.q_content, p.q_flag, m.a_content, m.aa_id from post_word as p INNER JOIN management_word as m  ON p.qq_id = m.aa_id where p.m_items = 'SQL' and p.Q_FLAG = '1'";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// select文の実行
			ResultSet rs = pStmt.executeQuery();

			// selet文の結果をArrayListに格納
			while (rs.next()) {
				S_Main recent1 = new S_Main(
						rs.getInt("qq_id"),
						rs.getInt("aa_id"),
						rs.getInt("ac_id"),
						rs.getString("M_items"),
						rs.getString("Q_date"),
						rs.getString("Q_content"),
						rs.getInt("Q_flag"),
						rs.getString("A_content")
					);
					ResoledQList5.add(recent1);

				}


		  }  // エラー処理
			catch (SQLException e) {
				e.printStackTrace();
				ResoledQList5 = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				ResoledQList5 = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						ResoledQList5 = null;
					}
				}
			}

			// 結果を返す
			return ResoledQList5;
		 }

	//サーブレット・JSPの解決済みの質問
	public List<S_Main> ResolvedQuestion6() {
		List<S_Main> ResoledQList6 = new ArrayList<S_Main>();

	      Connection conn = null;

		  try {

	        // JDBCドライバの読み込み
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/E-4/Qsama/data/E-4", "sa", "");

			// SQL文の準備
			String sql ="select p.qq_id, p.ac_id, p.m_items, p.Q_date, p.q_content, p.q_flag, m.a_content, m.aa_id from post_word as p INNER JOIN management_word as m  ON p.qq_id = m.aa_id where p.m_items = 'サーブレット・JSP' and p.Q_FLAG = '1'";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// select文の実行
			ResultSet rs = pStmt.executeQuery();

			// selet文の結果をArrayListに格納
			while (rs.next()) {
				S_Main recent1 = new S_Main(
						rs.getInt("qq_id"),
						rs.getInt("aa_id"),
						rs.getInt("ac_id"),
						rs.getString("M_items"),
						rs.getString("Q_date"),
						rs.getString("Q_content"),
						rs.getInt("Q_flag"),
						rs.getString("A_content")
					);
					ResoledQList6.add(recent1);

				}


		  }  // エラー処理
			catch (SQLException e) {
				e.printStackTrace();
				ResoledQList6 = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				ResoledQList6 = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						ResoledQList6 = null;
					}
				}
			}

			// 結果を返す
			return ResoledQList6;
		 }

	//事務局の解決済みの質問
	public List<S_Main> ResolvedQuestion7() {
		List<S_Main> ResoledQList7 = new ArrayList<S_Main>();

	      Connection conn = null;

		  try {

	        // JDBCドライバの読み込み
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/E-4/Qsama/data/E-4", "sa", "");

			// SQL文の準備
			String sql ="select p.qq_id, p.ac_id, p.m_items, p.Q_date, p.q_content, p.q_flag, m.a_content, m.aa_id from post_word as p INNER JOIN management_word as m  ON p.qq_id = m.aa_id where p.m_items = '事務局' and p.Q_FLAG = '1'";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// select文の実行
			ResultSet rs = pStmt.executeQuery();

			// selet文の結果をArrayListに格納
			while (rs.next()) {
				S_Main recent1 = new S_Main(
						rs.getInt("qq_id"),
						rs.getInt("aa_id"),
						rs.getInt("ac_id"),
						rs.getString("M_items"),
						rs.getString("Q_date"),
						rs.getString("Q_content"),
						rs.getInt("Q_flag"),
						rs.getString("A_content")
					);
					ResoledQList7.add(recent1);

				}


		  }  // エラー処理
			catch (SQLException e) {
				e.printStackTrace();
				ResoledQList7 = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				ResoledQList7 = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						ResoledQList7 = null;
					}
				}
			}

			// 結果を返す
			return ResoledQList7;
		 }
	//ドリルの解決済みの質問
	public List<S_Main> ResolvedQuestion8() {
		List<S_Main> ResoledQList8 = new ArrayList<S_Main>();

	      Connection conn = null;

		  try {

	        // JDBCドライバの読み込み
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/E-4/Qsama/data/E-4", "sa", "");

			// SQL文の準備
			String sql ="select p.qq_id, p.ac_id, p.m_items, p.Q_date, p.q_content, p.q_flag, m.a_content, m.aa_id from post_word as p INNER JOIN management_word as m  ON p.qq_id = m.aa_id where p.m_items = 'ドリル' and p.Q_FLAG = '1'";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// select文の実行
			ResultSet rs = pStmt.executeQuery();

			// selet文の結果をArrayListに格納
			while (rs.next()) {
				S_Main recent1 = new S_Main(
						rs.getInt("qq_id"),
						rs.getInt("aa_id"),
						rs.getInt("ac_id"),
						rs.getString("M_items"),
						rs.getString("Q_date"),
						rs.getString("Q_content"),
						rs.getInt("Q_flag"),
						rs.getString("A_content")
					);
					ResoledQList8.add(recent1);

				}


		  }  // エラー処理
			catch (SQLException e) {
				e.printStackTrace();
				ResoledQList8 = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				ResoledQList8 = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						ResoledQList8 = null;
					}
				}
			}

			// 結果を返す
			return ResoledQList8;
		 }
	//段位認定の解決済みの質問
	public List<S_Main> ResolvedQuestion9() {
		List<S_Main> ResoledQList9 = new ArrayList<S_Main>();

	      Connection conn = null;

		  try {

	        // JDBCドライバの読み込み
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/E-4/Qsama/data/E-4", "sa", "");

			// SQL文の準備
			String sql ="select p.qq_id, p.ac_id, p.m_items, p.Q_date, p.q_content, p.q_flag, m.a_content, m.aa_id from post_word as p INNER JOIN management_word as m  ON p.qq_id = m.aa_id where p.m_items = '段位認定' and p.Q_FLAG = '1'";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// select文の実行
			ResultSet rs = pStmt.executeQuery();

			// selet文の結果をArrayListに格納
			while (rs.next()) {
				S_Main recent1 = new S_Main(
						rs.getInt("qq_id"),
						rs.getInt("aa_id"),
						rs.getInt("ac_id"),
						rs.getString("M_items"),
						rs.getString("Q_date"),
						rs.getString("Q_content"),
						rs.getInt("Q_flag"),
						rs.getString("A_content")
					);
					ResoledQList9.add(recent1);

				}


		  }  // エラー処理
			catch (SQLException e) {
				e.printStackTrace();
				ResoledQList9 = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				ResoledQList9 = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						ResoledQList9 = null;
					}
				}
			}

			// 結果を返す
			return ResoledQList9;
		 }
}
