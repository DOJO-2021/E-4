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
	public boolean isLoginOK(String user_id, String user_pw) {
		Connection conn = null;				// 接続がされているかどうかチェックするため
		boolean loginResult = false;			// ログインできたかどうかチェックするため

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する　connが「true」なら接続されている
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/E-4/Qsama/data/E-4", "sa", "");

			// SELECT文を準備する
			String sql = "select count(*) from LOGIN where user_id = ? and user_pw = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, user_id);
			pStmt.setString(2, user_pw);

			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// ユーザーIDとパスワードが一致するユーザーがいたかどうかをチェックする
			rs.next();
			//System.out.println(rs);
			//System.out.println(rs.getInt("count(*)"));

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
		System.out.println(user_id);
		System.out.println(user_pw);
		System.out.println(loginResult);
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
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/E-4/Qsama/data/E-4", "sa", "");

				//認証成功後、ログインIDを利用して個人データを抽出実行
				String mysql2 = "select * from LOGIN where user_id = ? and user_pw = ?";
				PreparedStatement myidpw = conn.prepareStatement(mysql2);
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
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/E-4/Qsama/data/E-4", "sa", "");

				//認証成功後、ログインIDを利用して個人データを抽出実行
				String mysql3 = "select user_rank from LOGIN where user_id = ? and user_pw = ?";
				PreparedStatement myidpw = conn.prepareStatement(mysql3);
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

	//新規登録
	// 引数nで指定されたレコードを登録し、成功したらtrueを返す
	public boolean insert(LoginUser n) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/E-4/Qsama/data/E-4", "sa", "");

			// SQL文を準備する
			String sql = "insert into LOGIN values (null, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (n.getUser_id() != null) {
				pStmt.setString(1, n.getUser_id());
			}
			else {
				pStmt.setString(1, "null");
			}
			if (n.getUser_pw() != null) {
				pStmt.setString(2, n.getUser_pw());
			}
			else {
				pStmt.setString(2, "null");
			}
			if (n.getMy_class() != null) {
				pStmt.setString(3, n.getMy_class());
			}
			else {
				pStmt.setString(3, "null");
			}
			if (n.getEmail() != null) {
				pStmt.setString(4, n.getEmail());
			}
			else {
				pStmt.setString(4, "null");
			}
			if (n.getName() != null) {
				pStmt.setString(5, n.getName());
			}
			else {
				pStmt.setString(5, "null");
			}
			//user_rank
			pStmt.setInt(6, n.getUser_rank());

			System.out.println(pStmt);
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