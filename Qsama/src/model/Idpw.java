package model;
import java.io.Serializable;

public class Idpw implements Serializable {
	private String user_id;	// ID
	private String user_pw;	// PW
	private String my_class; //クラス
	private String user_rank; //ランク
	

	public Idpw(String user_id, String user_pw, String my_class, String user_rank) {
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.my_class = my_class;
		this.user_rank = user_rank;
	}

	public Idpw() {
		this.user_id = "";
		this.user_pw = "";
		this.my_class = "";
		this.user_rank = "";
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
	public String getUser_rank() {
		return user_rank;
	}

	public void setUser_rank(String user_rank) {
		this.user_rank = user_rank;
	}

}
