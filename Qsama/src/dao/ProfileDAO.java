package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Profile;

public class ProfileDAO {
	public List<Profile> profileAll(){
	  List<Profile> ProfileList = new ArrayList<Profile>();

      Connection conn = null;

	  try {
        // JDBCドライバの読み込み
		Class.forName("org.h2.Driver");
		// データベースに接続する
		conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/E-4/data/E-4", "sa", "");

		// SQL文の準備
		String sql = "select * from Profile ORDER BY ac_id";

			PreparedStatement pStmt = conn.prepareStatement(sql);

		// select文の実行
		ResultSet rs = pStmt.executeQuery();

		// select文の結果をArrayListに格納
		while (rs.next()) {
			Profile Profile = new Profile(
				rs.getString("COMPANY"),
				rs.getString("CLASS_NUMBER"),
				rs.getString("NAME"),
				rs.getString("EXPERIENCE"),
				rs.getString("BLOODTYPE"),
				rs.getString("BIRTHDAY"),
				rs.getString("COLLEGE"),
				rs.getString("UNDERGRADUATE"),
				rs.getString("HOBBY"),
				rs.getString("SPECIAL_SKILL"),
				rs.getString("QUALIFICATION"),
				rs.getString("FAVORITE"),
				rs.getString("COMPANY")
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
	public boolean p_update(Profile update_user) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/E-4/data/E-4", "sa", "");

			// insert文を準備する
			String sql = "insert into Profile (COMPANY, MY_CLASS, NAME, EXPERIENCE, BLOODTYPE,"
					+ "COLLEGE, UNDERGRADUATE, HOBBY, SPECIAL_SKILL, QUALIFICATION, FAVORITE, COMMENT)"
					+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			// insert文中の？に使用する値を設定しSQLを完成
			if (update_user.getCompany() != null) {
				pStmt.setString(1, update_user.getCompany());
			} else {
				pStmt.setString(1, "null");
			}

			if (update_user.getMy_class() != null) {
				pStmt.setString(2, update_user.getMy_class());
			} else {
				pStmt.setString(2, "null");
			}

			if (update_user.getName() != null) {
				pStmt.setString(3, update_user.getName());
			} else {
				pStmt.setString(3, "null");
			}

			if (update_user.getExperience() != null) {
				pStmt.setString(4, update_user.getExperience());
			} else {
				pStmt.setString(4, "null");
			}

			if (update_user.getBloodtype() != null) {
				pStmt.setString(5, update_user.getBloodtype());
			} else {
				pStmt.setString(5, "null");
			}

			if (update_user.getBirthday() != null) {
				pStmt.setString(6, update_user.getBirthday());
			} else {
				pStmt.setString(6, "null");
			}
			if (update_user.getCollege() != null) {
				pStmt.setString(7, update_user.getCollege());
			} else {
				pStmt.setString(7, "null");
			}
			if (update_user.getUndergraduate() != null) {
				pStmt.setString(8, update_user.getUndergraduate());
			} else {
				pStmt.setString(8, "null");
			}
			if (update_user.getHobby() != null) {
				pStmt.setString(9, update_user.getHobby());
			} else {
				pStmt.setString(9, "null");
			}
			if (update_user.getSpecial_skill() != null) {
				pStmt.setString(10, update_user.getSpecial_skill());
			} else {
				pStmt.setString(10, "null");
			}
			if (update_user.getQualification() != null) {
				pStmt.setString(11, update_user.getQualification());
			} else {
				pStmt.setString(11, "null");
			}
			if (update_user.getFavorite() != null) {
				pStmt.setString(12, update_user.getFavorite());
			} else {
				pStmt.setString(12, "null");
			}
			if (update_user.getComment() != null) {
				pStmt.setString(13, update_user.getComment());
			} else {
				pStmt.setString(13, "null");
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

/*
	// IDPWより必要項目を取得
		public int idpw_search(int ac_id) {
				Connection conn = null;
				List<idpw> idpwList = new ArrayList<idpw>();

				try {
					// JDBCドライバを読み込む
					Class.forName("org.h2.Driver");

					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/simpleBC", "sa", "");

					// SQL文を準備する
				String sql = "select * From IDPW ORDER BY ac_id";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					Bc2 card = new Bc2(
					rs.getInt("BC_ID"),			// 名刺No
					rs.getString("NAME"),		// 名前
					rs.getString("NAME_KANA"),	// 名前(カナ)
					rs.getString("SEX"),		// 性別　1：男　2：女　3：その他
					rs.getString("Comp_name"),	// 会社名
					rs.getString("TEL1"),		// 代表番号
					rs.getString("FAX"),		// FAX
					rs.getString("TEL2"),		// 携帯電話
					rs.getString("EMAIL"),		// E-Mail
					rs.getString("ZIP_CODE"),	// 郵便番号
					rs.getString("ADDRESS"),	// 住所
					rs.getString("REMARKS")		// 備考
					);
					cardList2.add(card);
					}
				}
			catch (SQLException e) {
				e.printStackTrace();
				cardList2 = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				cardList2 = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						cardList2 = null;
					}
				}
			}
			// 結果を返す
			return cardList2;
		}*/
	}
