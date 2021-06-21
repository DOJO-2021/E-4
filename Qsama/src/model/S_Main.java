package model;

import java.io.Serializable;

public class S_Main implements Serializable{
	private String user_id;
	// Post_wordの列名をフィールドに設定する
	protected int ac_id;                // 識別ID
	private String M_items;             // 大項目
	private String Q_date;              // 投稿日
	private String Q_content;           // 質問内容
	protected int Q_flag;
	// management_wordの必要な列名をフィールドに設定する
	protected int A_flag;

	// 引数がないコンストラクタ（デフォルトコンストラクタ）
	public S_Main() {

		this.ac_id = 0;
		this.M_items = "";
		this.Q_date = "";
		this.Q_content = "";
		this.Q_flag = 0;
		this.A_flag = 0;
		//management_word
		//this.ac_id1 = 0;
		//this.A_content = "";
	}
	// お知らせ用
	public S_Main(int ac_id, int A_flag) {

		this.ac_id = ac_id;
		this.A_flag = A_flag;
	}

	public S_Main(String user_id) {
		this.user_id = user_id;
	}

	// 引数があるコンストラクタ//解決済みの質問
	public S_Main(int ac_id, String M_items, String Q_date, String Q_content, int Q_flag) {
		this.ac_id = ac_id;
		this.M_items = M_items;
		this.Q_date = Q_date;
		this.Q_content = Q_content;
		this.Q_flag = Q_flag;

	}

	//最近の質問用
	public S_Main(int ac_id, String M_items, String Q_date, String Q_content) {
		this.ac_id = ac_id;
		this.M_items = M_items;
		this.Q_date = Q_date;
		this.Q_content = Q_content;
	}


	public int getAc_id() {
		return ac_id;
	}

	public void setAc_id(int ac_id) {
		this.ac_id = ac_id;
	}

	public String getM_items() {
		return M_items;
	}

	public void setM_items(String m_items) {
		this.M_items = m_items;
	}

	public String getQ_date() {
		return Q_date;
	}

	public void setQ_date(String q_date) {
		this.Q_date = q_date;
	}

	public String getQ_content() {
		return Q_content;
	}

	public void setQ_content(String q_content) {
		this.Q_content = q_content;
	}

	public int getQ_flag() {
		return Q_flag;
	}

	public void setQ_flag(int q_flag) {
		this.Q_flag = q_flag;
	}

	public int getA_flag() {
		return A_flag;
	}

	public void setA_flag(int a_flag) {
		this.A_flag = a_flag;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

/*	public int getAc_id1() {
		return ac_id1;
	}

	public void setPostpic_url(int ac_id1) {
		this.ac_id1 = ac_id1;
	}

	public String getA_content() {
		return A_content;
	}

	public void setA_content(String a_content) {
		this.A_content = a_content;
	}*/




}
