package model;

import java.io.Serializable;

public class Question_post implements Serializable {

	// Post_wordの列名をフィールドに設定する

	private int Q_Number;
	protected int user_id;
	private String Major_items;
	private String Medium_item;
	private String Q_date;
	private String A_date;
	private String Q_content;
	private String A_content;
	private int A_level;
	private int Q_flag;
	private int A_flag;
	private int emergency;



	// 引数がないコンストラクタ（デフォルトコンストラクタ）
	public Question_post() {
		super();
		this.Q_Number = 0;
		this.user_id = 0;
		this.Major_items = "";
		this.Medium_item = "";
		this.Q_date = "";
		this.A_date = "";
		this.Q_content = "";
		this.A_content = "";
		this.A_level = 0;
		this.Q_flag = 0;
		this.A_flag = 0;
		this.emergency = 0;
	}

	// 引数があるコンストラクタ
	public Question_post(int q_Number, int user_id, String major_items,
			String medium_item, String q_date, String a_date,
			String q_content, String a_content, int a_level, int q_flag,
			int a_flag, int emergency) {
		super();
		this.Q_Number = q_Number;
		this.user_id = user_id;
		this.Major_items = major_items;
		this.Medium_item = medium_item;
		this.Q_date = q_date;
		this.A_date = a_date;
		this.Q_content = q_content;
		this.A_content = a_content;
		this.A_level = a_level;
		this.Q_flag = q_flag;
		this.A_flag = a_flag;
		this.emergency = emergency;
	}

	// getter/setter
	public int getQ_Number() {
		return Q_Number;
	}

	public void setQ_Number(int q_Number) {
		Q_Number = q_Number;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getMajor_items() {
		return Major_items;
	}

	public void setMajor_items(String major_items) {
		Major_items = major_items;
	}

	public String getMedium_item() {
		return Medium_item;
	}

	public void setMedium_item(String medium_item) {
		Medium_item = medium_item;
	}

	public String getQ_date() {
		return Q_date;
	}

	public void setQ_date(String q_date) {
		Q_date = q_date;
	}

	public String getA_date() {
		return A_date;
	}

	public void setA_date(String a_date) {
		A_date = a_date;
	}

	public String getQ_content() {
		return Q_content;
	}

	public void setQ_content(String q_content) {
		Q_content = q_content;
	}

	public String getA_content() {
		return A_content;
	}

	public void setA_content(String a_content) {
		A_content = a_content;
	}

	public int getA_level() {
		return A_level;
	}

	public void setA_level(int a_level) {
		A_level = a_level;
	}

	public int getQ_flag() {
		return Q_flag;
	}

	public void setQ_flag(int q_flag) {
		Q_flag = q_flag;
	}

	public int getA_flag() {
		return A_flag;
	}

	public void setA_flag(int a_flag) {
		A_flag = a_flag;
	}

	public int getEmergency() {
		return emergency;
	}

	public void setEmergency(int emergency) {
		this.emergency = emergency;
	}

}
