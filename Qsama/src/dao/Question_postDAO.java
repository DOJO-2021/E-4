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
	public List<Question_post> select(Question_post param){
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
	public boolean insert(Question_post question_post) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/E-4/Qsama/data/E-4", "sa", "");

			// insert文を準備する
			String sql = "insert into question_post values (null,null, null, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			// insert文中の？に使用する値を設定しSQLを完成

			// not null制約あり
			if (question_post.getM_items() != null && !question_post.getM_items().equals("")) {
				pStmt.setString(1, question_post.getM_items());
			} else {
				pStmt.setString(1, null);
			}

			if (question_post.getS_items() != null) {
				pStmt.setString(2, question_post.getS_items());
			} else {
				pStmt.setString(2, null);
			}

			if (question_post.getQ_date() != null) {
				pStmt.setString(3, question_post.getQ_date());
			} else {
				pStmt.setString(3, null);
			}

			// not null制約あり
			if (question_post.getQ_content() != null && !question_post.getQ_content().equals("")) {
				pStmt.setString(4, question_post.getQ_content());
			} else {
				pStmt.setString(4, null);
			}

			pStmt.setInt(5, question_post.getA_level());

			pStmt.setInt(6, question_post.getQ_flag());

			pStmt.setInt(7, question_post.getEmergency());

			if (question_post.getPostpic_url() != null) {
				pStmt.setString(8, question_post.getPostpic_url());
			} else {
				pStmt.setString(8, null);
			}

			pStmt.setInt(9, question_post.getQQ_id());

			pStmt.setInt(10, question_post.getAc_id());

			pStmt.setInt(11, question_post.getPost_Number());

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

