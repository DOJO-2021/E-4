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

import model.Search;

public class SearchDAO {
	public List<Search> KeywordSearch(String S4_word, String Search_radio, String m_items, String s_items){
	  List<Search> SearchList = new ArrayList<Search>();

      Connection conn = null;					// 接続リセット
      String sqladd = null;					// SQLの追加分作成準備
      String Operator = null;					// AND・OR入れ物準備

      word_insert(S4_word);						// 検索キーワード蓄積
      var Search_word = S4_word.split(" ");	// 半角スペースで配列

   //------------------AND・OR判定---------------------------------------
      if( Search_radio.equals("and")) {
      	Operator = "AND ";
      }else if( Search_radio.equals("or")) {
      	Operator = "OR ";
      }
//      System.out.println("AND/OR:"+Operator);	// AND・OR出力確認 ok

   //-------------------項目判定-----------------------------------------
      if( !(m_items.equals("")) && !(s_items.equals(""))) {			// 大項目・小項目記入あり
    	  sqladd = "M_items='"+m_items+"' AND "+"S_items='"+s_items+"' AND ";
      }else if(!(m_items.equals(""))) {							// 大項目のみ記入あり
    	  sqladd = "M_items='"+m_items+"' AND ";
      }
//		System.out.println(!(m_items.equals("")));
// 		System.out.println(!(m_items.equals("")) && !(s_items.equals("")));

   //-------------------検索キーワード判定------------------------------------------------------------
      if(Search_word.length==1) {
    	  sqladd = sqladd+" Q_CONTENT LIKE '%"+Search_word[0]+"%'";	// 検索キーワードが１つならこれだけ
      }else {
            for (int i = 0; Search_word.length > 0; i++){	// 検索キーワード数が２つ以上ならfor文で追記
            	if(i == 0) {
            		sqladd = "Q_CONTENT LIKE '%"+Search_word[i]+"%' "+Operator;
            	}else if((Search_word.length - i) ==0){
            		break;
            	}else if((Search_word.length - i) ==1) {
            		sqladd =  sqladd+"Q_CONTENT LIKE '%"+Search_word[i]+"%'";
            	}else if((Search_word.length - i) !=0) {
            		sqladd =  sqladd+"Q_CONTENT LIKE '%"+Search_word[i]+"%' "+Operator;
            	}
            }
      }
      System.out.println(sqladd);  // sqladdの中身確認
	  try {
        // JDBCドライバの読み込み
		Class.forName("org.h2.Driver");
		// データベースに接続する
		conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/E-4/Qsama/data/E-4", "sa", "");

		// SQL文の準備 検索キーワードに対して、個別質問 + 管理テーブルを全出力
		String sql = "select * from POST_WORD outer join MANAGEMENT_WORD where "+sqladd;

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
	  }return SearchList;	 	// 結果を返す
	}


	//検索キーワードを蓄積するだけ
	public boolean word_insert(String S4_word) {
	Connection conn = null;
	boolean result = false;

//------------------本日の日付を格納----------------------------------------------------------
		LocalDateTime nowDateTime = LocalDateTime.now();
		DateTimeFormatter datetimeformatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String today = datetimeformatter.format(nowDateTime);

//------------------本日の日付を格納----------------------------------------------------------
    var Search_word = S4_word.split(" ");	// 半角スペースで配列

	try {
		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		// データベースに接続する
		conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/E-4/Qsama/data/E-4", "sa", "");

		for (int i = 0; Search_word.length > (i+1); i++){
			// SQL文を準備する
			String sql2 = "insert into SEARCH_WORD (word, search_date) values ("+"'"+Search_word[i]+"', '"+today+"')";

			PreparedStatement pStmt = conn.prepareStatement(sql2);

			int end = pStmt.executeUpdate();

			// SQL文を実行する
			if (end == 1 && Search_word.length == i) {
				result = true;
			}
	}}
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

//-----------------------検索ランキング出力------------------------------------
	public List<Search> MaxSearchRanking(){
		  List<Search> MaxRankingList = new ArrayList<Search>();

	      Connection conn = null;					// 接続リセット

		  try {
	        // JDBCドライバの読み込み
			Class.forName("org.h2.Driver");
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/E-4/Qsama/data/E-4", "sa", "");

			// SQL文の準備 通年：上位５位まで出力
			String sql = "SELECT word ,count(word) from SEARCH_WORD group by word order by count(word) DESC limit 5";

			PreparedStatement s2_res = conn.prepareStatement(sql);

			// select文の実行
			ResultSet rs = s2_res.executeQuery();

			// select文の結果をArrayListに格納
			while (rs.next()) {
				Search Search = new Search(
					rs.getString("WORD"),
					rs.getInt("COUNT(WORD)")
					);
				MaxRankingList.add(Search);
				}
		  }  // エラー処理
		  catch (SQLException e) {
				e.printStackTrace();
				MaxRankingList = null;
		  }
		  catch (ClassNotFoundException e) {
				e.printStackTrace();
				MaxRankingList = null;
		  }
		  finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						MaxRankingList = null;
					}
				}
		  }return MaxRankingList;	 	// 結果を返す
		}

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
