package model;

import java.io.Serializable;

public class LoginUser implements Serializable {
	private int ac_id;			// 識別ID
	private String user_id;	// ログイン時のID
	private String user_pw;	// パスワード
	private String my_class;	// 所属クラス
	private String email;		// E-mail
	private String name;		// 氏名
	private int user_rank;	// ユーザーランク

	public LoginUser(int ac_id, String user_id, String user_pw, String my_class, String email, String name,int user_rank) {
		this.ac_id = ac_id;
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.my_class = my_class;
		this.email = email;
		this.name = name;
		this.user_rank = user_rank;
	}

	public LoginUser() {
		this.ac_id = 0;
		this.user_id = "";
		this.user_pw = "";
		this.my_class = "";
		this.email = "";
		this.name = "";
		this.user_rank = 0;
	}

	public LoginUser(String user_id, String user_pw, String my_class, int user_rank) {
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.my_class = my_class;
		this.user_rank = user_rank;
	}

	public LoginUser(String id) {
		this.user_id = id;
	}

	public LoginUser(String id, String pw) {
		this.user_pw = pw;
	}

	public int getAc_id() {
		return ac_id;
	}

	public void setAc_id(int ac_id) {
		this.ac_id = ac_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_pw() {
		return user_pw;
	}

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}

	public String getMy_class() {
		return my_class;
	}

	public void setMy_class(String my_class) {
		this.my_class = my_class;
	}

	public String getEmail() {
		return email;
	}

	public void setE_mail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUser_rank() {
		return user_rank;
	}

	public void setUser_rank(int user_rank) {
		this.user_rank = user_rank;
	}

}
