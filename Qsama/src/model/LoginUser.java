package model;

import java.io.Serializable;

public class LoginUser implements Serializable {
	private String user_id;	// ログイン時のID
	private String my_class ;
	private int user_rank;

	public LoginUser() {
		this(null);
	}

	public LoginUser(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getMy_class() {
		return my_class;
	}

	public void setMy_class(String my_class) {
		this.my_class = my_class;
	}

	public int getUser_rank() {
		return user_rank;
	}

	public void setUser_rank(int user_rank) {
		this.user_rank = user_rank;
	}
}
