package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Search;

public class SearchDAO {
	public List<Search> KeywordSearch(String Search_word){
	  List<Search> SearchList = new ArrayList<Search>();

      Connection conn = null;

	  try {
        // JDBCドライバの読み込み
		Class.forName("org.h2.Driver");
		// データベースに接続する
		conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/E-4/Qsama/data/E-4", "sa", "");

		// SQL文の準備 検索キーワードに対して、個別質問 + 管理テーブルを全出力
		String sql = "SELECT * FROM POST_WORD OUTER JOIN MANAGEMENT_WORD UNION SELECT * FROM MANAGEMENT_WORD OUTER JOIN POST_WORD"
				+ "Where [ここに検索ワードを入れる]";

		PreparedStatement s_res = conn.prepareStatement(sql);

		// select文の実行
		ResultSet rs = s_res.executeQuery();

		// select文の結果をArrayListに格納
		while (rs.next()) {
			Search Search = new Search(
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
				rs.getInt("AA_id"),
				rs.getString("A_date"),
				rs.getString("A_content"),
				rs.getInt("A_flag"),
				rs.getInt("area_open")
				);
				SearchList.add(Search);
			}

	  }  // エラー処理
		catch (SQLException e) {
			e.printStackTrace();
			SearchList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			SearchList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					SearchList = null;
				}
			}
		}

		// 結果を返す
		return SearchList;
	 }
}