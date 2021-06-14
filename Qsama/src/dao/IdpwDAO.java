package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.LoginUser;

public class IdpwDAO {
	// ログインできるならtrueを返す
	public boolean isLoginOK(String id, String pw) {
		Connection conn = null;				// 接続がされているかどうかチェックするため
		boolean loginResult = false;			// ログインできたかどうかチェックするため

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する　connが「true」なら接続されている
			conn = DriverManager.getConnection("jdbc:h2:file:C:\\pleiades\\workspace\\E-4\\Qsama\\data\\E-4", "sa", "");

			// SELECT文を準備する
			String sql = "select count(*) from IDPW where user_id = ? and user_pw = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, id);
			pStmt.setString(2, pw);


			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// ユーザーIDとパスワードが一致するユーザーがいたかどうかをチェックする
			rs.next();
			System.out.println(rs);
			System.out.println(rs.getInt("count(*)"));

			if (rs.getInt("count(*)") == 1) {
				loginResult = true;
			}
		}
		catch (SQLException e) {
			loginResult = false;
		}
		catch (ClassNotFoundException e) {
			loginResult = false;
		}
		finally {					// 必ず実行するコマンド
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					loginResult = false;
				}
			}
		}

		// 結果を返す
		return loginResult;
	}
	// 個人情報を取得
	public List<LoginUser> Mydata(String user_id, String user_pw) {
		Connection conn = null;
		List<LoginUser> MyList = new ArrayList<LoginUser>();

			try {
			// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/simpleBC", "sa", "");

				//認証成功後、ログインIDを利用して個人データを抽出実行
				String mysql = "select * from IDPW where user_id = ? and user_pw = ?";
				PreparedStatement myidpw = conn.prepareStatement(mysql);
				myidpw.setString(1, user_id);
				myidpw.setString(2, user_pw);
				ResultSet Mydata2 = myidpw.executeQuery();

				// 個人データを抽出中
				while (Mydata2.next()) {
					LoginUser idpw = new LoginUser(
						Mydata2.getInt("AC_ID"),
						Mydata2.getString("USER_ID"),
						Mydata2.getString("USER_PW"),
						Mydata2.getString("MY_CLASS"),
						Mydata2.getString("E_MAIL"),
						Mydata2.getString("NAME"),
						Mydata2.getInt("USER_RANK")
						);
					//ログインしたユーザー情報：MyListの完成
					MyList.add(idpw);
					}
				}
			catch (SQLException e) {
				e.printStackTrace();
				MyList = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				MyList = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						MyList = null;
					}
				}
			}
			// 結果を返す
			return MyList;
		}

	// ユーザーランクを取得
	public int MyRank(String user_id, String user_pw) {
		Connection conn = null;
		int Rank = 0;

			try {
			// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/simpleBC", "sa", "");

				//認証成功後、ログインIDを利用して個人データを抽出実行
				String mysql = "select user_rank from IDPW where user_id = ? and user_pw = ?";
				PreparedStatement myidpw = conn.prepareStatement(mysql);
				myidpw.setString(1, user_id);
				myidpw.setString(2, user_pw);
				ResultSet Mydata = myidpw.executeQuery();

				// 個人データを抽出中
				while (Mydata.next()) {
						Rank = Mydata.getInt("USER_RANK");
					}
				}
			catch (SQLException e) {
				e.printStackTrace();
				Rank = 0;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				Rank = 0;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						Rank = 0;
					}
				}
			}
			// 結果を返す
			return Rank;
		}
	}