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
	//投稿された質問のリスト
	public List<S_Main> RecentQ(){
		List<S_Main> RecentqList = new ArrayList<S_Main>();

	      Connection conn = null;

		  try {

	        // JDBCドライバの読み込み
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/E-4/Qsama/data/E-4", "sa", "");

			// SQL文の準備
			String sql ="select * from POST_WORD where Q_DATE ASC";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// select文の実行
			ResultSet rs = pStmt.executeQuery();

			// selet文の結果をArrayListに格納
			while (rs.next()) {
				S_Main recent = new S_Main(
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
				RecentqList.add(recent);
					System.out.println(recent);
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
}
