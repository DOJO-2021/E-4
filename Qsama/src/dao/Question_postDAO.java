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
		"select * from Question_post outer join ( select ac_id from p_user ) ";
		

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
				System.out.println(question_post);
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
	public boolean P_insert(Question_post question_post) {
		Connection conn = null;
		boolean result = false;
		
		//--------------- 本日の日付を格納 -------------------------------------------
				LocalDateTime nowDateTime = LocalDateTime.now();
				DateTimeFormatter datetimeformatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				String today = datetimeformatter.format(nowDateTime);
		//----------------本日の日付を格納--------------------------------------------

		try {
			
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/E-4/Qsama/data/E-4", "sa", "");

			// SQL文を準備する
			String sql = "insert into Post_word (M_items, S_items, Q_date, Q_content, A_level, emergency, Postpic_url) values (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			
			
			if (question_post.getM_items() != null) {
				pStmt.setString(1, question_post.getM_items());
			} else {
				pStmt.setString(1, null);
			}

			if (question_post.getS_items() != null) {
				pStmt.setString(2, question_post.getS_items());
			} else {
				pStmt.setString(2, null);
			}

		//	if (question_post.getQ_date() != null) {
				pStmt.setString(3, today);      // 今日の日付
		//	} else {
		//		pStmt.setString(3, null);
		//	}

			// not null制約あり
			if (question_post.getQ_content() != null && !question_post.getQ_content().equals("")) {
				pStmt.setString(4, question_post.getQ_content());
			} else {
				pStmt.setString(4, null);
			}

			pStmt.setInt(5, question_post.getA_level());        

			pStmt.setInt(6, question_post.getEmergency());
			
			if (question_post.getPostpic_url() != null) {
				pStmt.setString(7, question_post.getPostpic_url());
				System.out.print(question_post.getPostpic_url());
			} else {
				pStmt.setString(7, null);
			}

			
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

//-----------------------よくある質問 出力------------------------------------
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
			"select M_items, count(M_items), Q_content, A_content from Post_word outer join (select A_content from management_word)  group by M_items, Q_content, A_content order by count(M_items) DESC limit 5";
			
			/*
			 * String sql =
			"select p.M_items, p.count(M_items), p.Q_content, m.A_content from Post_word as p outer join ( select A_content from management_word as m ) group by M_items order by count(M_items) DESC limit 5";
			 * 
			 */
			
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
			
			System.out.println("DAO　PostFaqList:" + PostFaqList);     //OK
			
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
	}

/*
	//-----------------------検索ランキング出力------------------------------------
	public List<Search> WeekSearchRanking(){
		  List<Search> WeekRankingList = new ArrayList<Search>();

	      Connection conn = null;					// 接続リセット

		  try {
	        // JDBCドライバの読み込み
			Class.forName("org.h2.Driver");
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/E-4/Qsama/data/E-4", "sa", "");

			// SQL文の準備 週間：上位５位まで出力
			String sql = "SELECT word ,count(word) from SEARCH_WORD where A_DATE >= (NOW() - INTERVAL 7 DAY) group by word order by count(word) DESC limit 5";

			PreparedStatement s2_res = conn.prepareStatement(sql);

			// select文の実行
			ResultSet rs = s2_res.executeQuery();

			// select文の結果をArrayListに格納
			while (rs.next()) {
				Search Search = new Search(
					rs.getString("WORD"),
					rs.getInt("COUNT(WORD)")
					);
				WeekRankingList.add(Search);
				}
		  }  // エラー処理
		  catch (SQLException e) {
				e.printStackTrace();
				WeekRankingList = null;
		  }
		  catch (ClassNotFoundException e) {
				e.printStackTrace();
				WeekRankingList = null;
		  }
		  finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						WeekRankingList = null;
					}
				}
		  }return WeekRankingList;	 	// 結果を返す
		}
}

*/


