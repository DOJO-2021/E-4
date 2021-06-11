package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
			String sql = "select count(*) from IDPW where ID = ? and PW = ?";
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
//			e.printStackTrace();      // ※お客様提出時にコメントアウトにする
			loginResult = false;
		}
		catch (ClassNotFoundException e) {
//			e.printStackTrace();      // ※お客様提出時にコメントアウトにする
			loginResult = false;
		}
		finally {					// 必ず実行するコマンド
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
//					e.printStackTrace();	// ※お客様提出時にコメントアウトにする
					loginResult = false;
				}
			}
		}

		// 結果を返す
		return loginResult;
	}
}