package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Question_post;

public class Question_postDAO {
	public List<Question_post> findAll(){
	  List<Question_post> Question_postList = new ArrayList<Question_post>();

      Connection conn = null;

	  try {
        // JDBCドライバの読み込み
		Class.forName("org.h2.Driver");
		// データベースに接続する
		conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/E-4/Qsama/data/E-4", "sa", "");

		// SQL文の準備
		String sql =
		"select * from Question_post";
			PreparedStatement pStmt = conn.prepareStatement(sql);

		// select文の実行
		ResultSet rs = pStmt.executeQuery();

		// select文の結果をArrayListに格納
		while (rs.next()) {
			Question_post question_post = new Question_post(
				rs.getInt("Q_Number"),
				rs.getInt("user_id"),
				rs.getString("Major_items"),
				rs.getString("Medium_item"),
				rs.getString("Q_date"),
				rs.getString("A_date"),
				rs.getString("Q_content"),
				rs.getString("A_content"),
				rs.getInt("A_level"),
				rs.getInt("Q_flag"),
				rs.getInt("A_flag"),
				rs.getInt("emergency")
				);
				Question_postList.add(question_post);
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
	public boolean insert(Question_post question_post) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/E-4/Qsama/data/E-4", "sa", "");

			// insert文を準備する
			String sql = "insert into question_post(Q_number, user_id, Major_items, medeium_item, Q_date, A_Date, Q_Content, A_content, A_level, Q_flag, A_flag, emergency"+" values (null,null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			// insert文中の？に使用する値を設定しSQLを完成
			if (question_post.getMajor_items() != null) {
				pStmt.setString(1, question_post.getMajor_items());
			} else {
				pStmt.setString(1, "null");
			}

			if (question_post.getMedium_item() != null) {
				pStmt.setString(2, question_post.getMedium_item());
			} else {
				pStmt.setString(2, "null");
			}

			if (question_post.getQ_date() != null) {
				pStmt.setString(3, question_post.getQ_date());
			} else {
				pStmt.setString(3, "null");
			}

			if (question_post.getA_date() != null) {
				pStmt.setString(4, question_post.getA_date());
			} else {
				pStmt.setString(4, "null");
			}

			if (question_post.getQ_content() != null) {
				pStmt.setString(5, question_post.getQ_content());
			} else {
				pStmt.setString(5, "null");
			}

			if (question_post.getA_content() != null) {
				pStmt.setString(6, question_post.getA_content());
			} else {
				pStmt.setString(6, "null");
			}

			pStmt.setInt(7, question_post.getA_level());

			pStmt.setInt(8, question_post.getQ_flag());

			pStmt.setInt(9, question_post.getA_flag());

			pStmt.setInt(10, question_post.getEmergency());

			pStmt.setInt(11, question_post.getQ_Number());

			pStmt.setInt(12, question_post.getUser_id());

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
}

