package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Admin;
import model.Profile;

public class ProfileDAO {
	public List<Profile> profileAll(int ac_id){
	  List<Profile> ProfileList = new ArrayList<Profile>();

      Connection conn = null;

	  try {
        // JDBCドライバの読み込み
		Class.forName("org.h2.Driver");
		// データベースに接続する
		conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/E-4/Qsama/data/E-4", "sa", "");

		// SQL文の準備
		String sql = "select * from p_user where ac_id= "+ac_id;

			PreparedStatement pStmt = conn.prepareStatement(sql);

		// select文の実行
		ResultSet rs = pStmt.executeQuery();

		// select文の結果をArrayListに格納
		while (rs.next()) {
			Profile Profile = new Profile(
				rs.getString("COMPANY"),
				rs.getString("MY_CLASS"),
				rs.getString("NAME"),
				rs.getString("EXPERIENCE"),
				rs.getString("BLOODTYPE"),
				rs.getString("BIRTHDAY"),
				rs.getString("COLLEGE"),
				rs.getString("UNDERGRADUATE"),
				rs.getString("HOBBY"),
				rs.getString("SPECIAL_SKILL"),
				rs.getString("QUALIFICATION"),
				rs.getString("FAVORITE_ARTIST"),
				rs.getString("COMPANY"),
				rs.getInt("ac_id")
				);
			ProfileList.add(Profile);
			}

	 }  // エラー処理
		catch (SQLException e) {   // JDBC関連のメソッドを呼んだときの例外
			e.printStackTrace();   // eclipseのコンソールに例外情報を表示する
			ProfileList = null;
		}
		catch (ClassNotFoundException e) {  // ドライバをロードしたとき（ドライバ存在しない）例外
			e.printStackTrace();
			ProfileList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					ProfileList = null;
				}
			}
		}

		// 結果を返す
		return ProfileList;
	 }


	// プロフィールの更新
	public boolean p_update(String company, String my_class, String name, String experience, String bloodtype, String birthday, String college,
			String undergraduate, String hobby, String special_skill, String qualification, String favorite_artist, String comment, int ac_id) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/E-4/Qsama/data/E-4", "sa", "");

			// insert文を準備する
			String sql = "update  p_user set COMPANY=?, MY_CLASS=?, NAME=?, EXPERIENCE=?, BLOODTYPE=?, BIRTHDAY=?,"
					+ "COLLEGE=?, UNDERGRADUATE=?, HOBBY=?, SPECIAL_SKILL=?, QUALIFICATION=?, FAVORITE_ARTIST=?, COMMENT=?"
					+ " where ac_id=?";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			// insert文中の？に使用する値を設定しSQLを完成
				pStmt.setString(1, company);
				pStmt.setString(2, my_class);
				pStmt.setString(3, name);
				pStmt.setString(4, experience);
				pStmt.setString(5, bloodtype);
				pStmt.setString(6, birthday);
				pStmt.setString(7, college);
				pStmt.setString(8, undergraduate);
				pStmt.setString(9, hobby);
				pStmt.setString(10, special_skill);
				pStmt.setString(11, qualification);
				pStmt.setString(12, favorite_artist);
				pStmt.setString(13, comment);
				pStmt.setInt(14, ac_id);

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


	//---------------個人の質問を収集---------------------------------------------------------------------------
	public List<Admin> MyPostGet(int ac_id){
		  List<Admin> MyGetList = new ArrayList<Admin>();

	      Connection conn = null;					// 接続リセット

		  try {
	        // JDBCドライバの読み込み
			Class.forName("org.h2.Driver");
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/E-4/Qsama/data/E-4", "sa", "");

			// SQL文の準備 検索キーワードに対して、個別質問 + 管理テーブルを全出力
			String sql = "SELECT p.QQ_ID, p.POST_NUMBER, p.M_ITEMS, p.S_ITEMS, p.Q_DATE, p.Q_CONTENT, p.A_LEVEL, p.EMERGENCY,"
					+ " p.POSTPIC_URL, p.Q_FLAG, m.A_FLAG, m.A_date, m.A_CONTENT, u.NAME "
					+ " FROM POST_WORD as p inner join MANAGEMENT_WORD as m inner join p_user as u"
					+ " on p.post_number=m.post_number on u.ac_id = p.ac_id"
					+ " where p.ac_id=100 order by p.Q_DATE DESC";

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
					rs.getInt("Q_flag"),
					rs.getInt("A_flag"),
					rs.getString("A_CONTENT"),
					rs.getString("NAME")
					);
					MyGetList.add(Admin_);
				}
		  }  // エラー処理
		  catch (SQLException e) {
				e.printStackTrace();
				MyGetList = null;
		  }
		  catch (ClassNotFoundException e) {
				e.printStackTrace();
				MyGetList = null;
		  }
		  finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						MyGetList = null;
					}
				}
		  }return MyGetList;	 	// 結果を返す
	}
}