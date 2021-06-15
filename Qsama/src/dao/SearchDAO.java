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
    	  sqladd = "M_items='"+m_items+"'"+"S_items='"+s_items+"' ";
      }else if(!(m_items.equals(""))) {		// 大項目のみ記入あり
    	  sqladd = "M_items='"+m_items+"'";
      }
      System.out.println(!(m_items.equals("")));
      System.out.println(!(m_items.equals("")) && !(s_items.equals("")));
   //-------------------検索キーワード判定------------------------------------------------------------
      if(Search_word.length==1) {
    	  sqladd = "Q_CONTENT LIKE '%"+Search_word[0]+"%'";	// 検索キーワードが１つならこれだけ
      }else {
            for (int i = 0; Search_word.length > 0; i++){	// 検索キーワード数が２つ以上ならfor文で追記
            	if(i == 0) {
            		sqladd = "Q_CONTENT LIKE '%"+Search_word[i]+"%' "+Operator;
            		word_insert(Search_word[i]);			// 検索キーワード蓄積
            	}else if((Search_word.length - i) ==0){
            		break;
            	}else if((Search_word.length - i) ==1) {
            		sqladd =  sqladd+"Q_CONTENT LIKE '%"+Search_word[i]+"%'";
            		word_insert(Search_word[i]);			// 検索キーワード蓄積
            	}else if((Search_word.length - i) !=0) {
            		sqladd =  sqladd+"Q_CONTENT LIKE '%"+Search_word[i]+"%' "+Operator;
            		word_insert(Search_word[i]);			// 検索キーワード蓄積
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
	public boolean word_insert(String word) {
	Connection conn = null;
	boolean result = false;

	LocalDateTime nowDateTime = LocalDateTime.now();
	DateTimeFormatter datetimeformatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-");
	String today = datetimeformatter.format(nowDateTime);

	try {
		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		// データベースに接続する
		conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/E-4/Qsama/data/E-4", "sa", "");

		// SQL文を準備する
		String sql2 = "insert into SEARCH_WORD (key_id, word, search_date) values ('', ?, ?)";

		PreparedStatement pStmt = conn.prepareStatement(sql2);

		// SQL文を完成させる
		if (word != null) {
			pStmt.setString(2, word);			// 検索キーワード
		}else {
			pStmt.setString(2, null);
		}
		if (today != null) {
			pStmt.setString(3, today);			// 検索日
		}else {
			pStmt.setString(3, null);
		}

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