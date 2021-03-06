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

import model.Question_post;


public class Question_postDAO {

	public List<Question_post> postAll(){
	  List<Question_post> Question_postList = new ArrayList<Question_post>();

      Connection conn = null;

	  try {

        // JDBCドライバの読み込み
		Class.forName("org.h2.Driver");

		// データベースに接続する
		conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/E-4/Qsama/data/E-4", "sa", "");

		// SQL文の準備
	/*	 String sql =
		"select * from Question_post";
	*/
		// 外部結合で、p_userテーブルのデータ "ac_id" 取得
		 String sql =
		"select * from POST_WORD as p inner join P_USER as u on p.ac_id=u.ac_id ";


		PreparedStatement pStmt = conn.prepareStatement(sql);

		// select文の実行
		ResultSet rs = pStmt.executeQuery();

		// selet文の結果をArrayListに格納
		while (rs.next()) {
			Question_post question_post = new Question_post(
				rs.getInt("QQ_id"),
				rs.getInt("ac_id"),
				rs.getInt("Post_Number"),
				rs.getString("M_items"),
				rs.getString("S_items"),
				rs.getString("Q_date"),
				rs.getString("Q_content"),
				rs.getInt("A_level"),
				rs.getInt("Q_flag"),
				rs.getInt("emergency"),
				rs.getString("Postpic_url")
				);
				Question_postList.add(question_post);
//				System.out.println(question_post);
			}


	  }  // エラー処理
		catch (SQLException e) {
			e.printStackTrace();
			Question_postList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			Question_postList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					Question_postList = null;
				}
			}
		}

		// 結果を返す
		return Question_postList;
	 }



	// insert
	public boolean P_insert(String ac_id, int Post_Number, String M_items, String S_items, String Q_date, String Q_content, String A_level, int Q_flag, String emergency, String Postpic_url) {
//	public boolean P_insert(Question_post question_post) {

		Connection conn = null;
		boolean result = false;


		//---------------   本日の日付を格納   -----------------------------
				LocalDateTime nowDateTime = LocalDateTime.now();
				DateTimeFormatter datetimeformatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				String today = datetimeformatter.format(nowDateTime);
		//---------------    本日の日付を格納   ------------------------------


		try {

			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/E-4/Qsama/data/E-4", "sa", "");

			// SQL文を準備する
			// IDはauto increment
			String sql = "insert into POST_WORD (ac_id, Post_Number, M_items, S_items, Q_date, Q_content, A_level, Q_flag, emergency, Postpic_url) values ("+ac_id+","+Post_Number+", ?, ?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement pStmt = conn.prepareStatement(sql);


			// SQL文を完成させる

			if (M_items != null) {
				pStmt.setString(1, M_items);
			} else {
				pStmt.setString(1, null);
			}

			if (S_items != null) {
				pStmt.setString(2, S_items);
			} else {
				pStmt.setString(2, null);
			}

				pStmt.setString(3, today);      // 今日の日付


			// not null制約あり
			if (Q_content != null && !Q_content.equals("")) {
				pStmt.setString(4, Q_content);
			} else {
				pStmt.setString(4, null);
			}

			pStmt.setString(5, A_level);

			pStmt.setInt(6, Q_flag);

			pStmt.setString(7, emergency);

			if (Postpic_url != null) {
				pStmt.setString(8, Postpic_url);
			    //	System.out.print(question_post.getPostpic_url());
			} else {
				pStmt.setString(8, null);
			}

			System.out.println("insert SQL →"+pStmt);

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

//-----------------------   よくある質問 出力   ------------------------------------

	public List<Question_post> PostFaq(){
		  List<Question_post> PostFaqList = new ArrayList<Question_post>();

	      Connection conn = null;					// 接続リセット

		  try {

	        // JDBCドライバの読み込み
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/E-4/Qsama/data/E-4", "sa", "");

			// SQL文の準備 よくある質問：上位５件の出力
			String sql =
			"select p.M_items, count(M_items), p.Q_content, m.A_content from POST_WORD as p inner join MANAGEMENT_WORD as m inner join P_USER as u on p.post_number = m.post_number on u.ac_id = p.ac_id group by p.M_items, Q_content, A_content order by count(M_items) DESC limit 5";

			PreparedStatement q2_res = conn.prepareStatement(sql);

			// select文の実行
			ResultSet rs = q2_res.executeQuery();

			// select文の結果をArrayListに格納
			while (rs.next()) {
				Question_post question_post = new Question_post(
					rs.getString("M_items"),
					rs.getInt("count(M_items)"),
					rs.getString("Q_content"),
					rs.getString("A_content")
					);
				PostFaqList.add(question_post);
				}

			System.out.println("DAO　よくある質問出力PostFaqList:" + PostFaqList);     //OK

		  }  // エラー処理
		  catch (SQLException e) {
				e.printStackTrace();
				PostFaqList = null;
		  }
		  catch (ClassNotFoundException e) {
				e.printStackTrace();
				PostFaqList = null;
		  }
		  finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						PostFaqList = null;
					}
				}
		  } return PostFaqList;	 	// 結果を返す
		}


	//-----------------------   最近の質問出力  ------------------------------------

	public List<Question_post> WeekFaqRanking(){
		  List<Question_post> WeekFaqList = new ArrayList<Question_post>();

	      Connection conn = null;					// 接続リセット

		  try {
	        // JDBCドライバの読み込み
			Class.forName("org.h2.Driver");
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/E-4/Qsama/data/E-4", "sa", "");

			// SQL文の準備 週間：上位５位まで出力
	/*		String sql = "SELECT word ,count(word) from SEARCH_WORD where A_DATE >= (NOW() - INTERVAL 7 DAY) group by word order by count(word) DESC limit 5";
	 *
	 */
			String sql =
				"select p.M_items, count(M_items), p.Q_content, m.A_content, m.A_date from Post_word as p inner join MANAGEMENT_WORD as m inner join p_user as u on p.post_number = m.post_number on u.ac_id = p.ac_id "
			//	+ "where m.A_DATE >= (NOW() - INTERVAL 7 DAY) "
				+ "group by p.M_items, p.Q_content, m.A_content, m.A_date  order by count(M_items) DESC limit 5";


			PreparedStatement s2_res = conn.prepareStatement(sql);

			// select文の実行
			ResultSet rs = s2_res.executeQuery();

			// select文の結果をArrayListに格納
			while (rs.next()) {
				Question_post question_post = new Question_post(

						rs.getString("M_items"),
						rs.getInt("count(M_items)"),
						rs.getString("Q_content"),
						rs.getString("A_content"),
						rs.getString("A_date")

						);

				WeekFaqList.add(question_post);
				}

			System.out.println("DAO　週間質問リストWeekFaqList:" + WeekFaqList);

		  }  // エラー処理
		  catch (SQLException e) {
				e.printStackTrace();
				WeekFaqList = null;
		  }
		  catch (ClassNotFoundException e) {
				e.printStackTrace();
				WeekFaqList = null;
		  }
		  finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						WeekFaqList = null;
					}
				}
		  }return WeekFaqList;	 	// 結果を返す
		}


	//-----------画像を保存---------------------------------------------------------
			public boolean post_url(Question_post card) {

			Connection conn = null;
			boolean result = false;

			try {

				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/E-4/Qsama/data/E-4", "sa", "");

				// SQL文を準備する
				String sql2 = "update post_word set Postpic_url=? where Post_Number=?";

				PreparedStatement pStmt = conn.prepareStatement(sql2);

				// SQL文を完成させる
				if (card.getNewPostpic_url() != null) {
					pStmt.setString(1, card.getNewPostpic_url());
				}else {
					pStmt.setString(1, null);
				}
				if (card.getPost_Number() != 0) {
					pStmt.setInt(2, card.getPost_Number());
				}else {
					pStmt.setString(2, null);
				}

				System.out.println("画像保存SQL→"+pStmt);

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
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}return result;
		}

	// --------------post_numberの最大値を取得-------------------------------------------------------
	public int MAXpost_number() {
			Connection conn = null;
			int post_number= 0;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/E-4/Qsama/data/E-4", "sa", "");

				//bc_idの最大値を検索
				String sql = "SELECT MAX(post_number) as MAX FROM POST_WORD";
				PreparedStatement pStmt2 = conn.prepareStatement(sql);

				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt2.executeQuery();

				// 結果表をコレクションにコピーする
				while(rs.next()){
				post_number = rs.getInt("MAX");
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
				post_number = 0;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				post_number = 0;
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
			return post_number;
		}

	//------------------MANAGEMENT_WORDに新規post_nemuberを追加-------------------------------------
	public boolean NewPost_number(String ac_id, int post_number) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/E-4/Qsama/data/E-4", "sa", "");


			// SQL文を準備する
			String sql2 = "insert into MANAGEMENT_WORD ( AC_ID, POST_NUMBER, A_CONTENT, A_flag) values ('"+ac_id+"', '"+post_number+"',' ','0')";

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
}
