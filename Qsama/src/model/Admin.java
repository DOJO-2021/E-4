package model;

import java.io.Serializable;

public class Admin implements Serializable {

	// Post_wordの列名をフィールドに設定する

	private int QQ_id;					// 識別ナンバー
	private int ac_id;					// 識別ID
	private int Post_Number;			// 共有ナンバー
	private String M_items;			// 大項目
	private String S_items;			// 小項目
	private String Q_date;				// 投稿日
	private String Q_content;			// 質問内容
	private int A_level;				// 回答レベル
	private int Q_flag;				// 質問者フラグ
	private int emergency;				// 緊急レベル
	private String postpic_url;		// 画像URL(質問者)
	private String A_date;				// 回答日
	private String A_content;			// 回答内容
	private int A_flag;				// 回答フラグ
	private int area_open;				// 公開範囲
	private String manapic_url;		// 画像URL(回答者：講師・事務)
	private String Name;				// 名前

	// 引数がないコンストラクタ（デフォルトコンストラクタ）
	public Admin() {
		super();
		this.QQ_id = 0;
		this.ac_id = 0;
		this.Post_Number = 0;
		this.M_items = "";
		this.S_items = "";
		this.Q_date = "";
		this.Q_content = "";
		this.A_level = 0;
		this.Q_flag = 0;
		this.emergency = 0;
		this.postpic_url="";
		this.A_date="";
		this.A_content="";
		this.A_flag=0;
		this.area_open=0;
		this.manapic_url="";
	}

	public Admin(int QQ_id, int Post_Number, String M_items, String S_items, String Q_date, String Q_content, int A_level, int emergency, String postpic_url, int A_flag, String A_content, String name) {
		super();
		this.QQ_id = QQ_id;
		this.Post_Number = Post_Number;
		this.M_items = M_items;
		this.S_items = S_items;
		this.Q_date = Q_date;
		this.Q_content = Q_content;
		this.A_level = A_level;
		this.emergency = emergency;
		this.postpic_url = postpic_url;
		this.A_flag = A_flag;
		this.A_content = A_content;
		this.Name = name;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getQQ_id() {
		return QQ_id;
	}

	public void setQQ_id(int qQ_id) {
		QQ_id = qQ_id;
	}

	public int getAc_id() {
		return ac_id;
	}

	public void setAc_id(int ac_id) {
		this.ac_id = ac_id;
	}

	public int getPost_Number() {
		return Post_Number;
	}

	public void setPost_Number(int post_Number) {
		Post_Number = post_Number;
	}

	public String getM_items() {
		return M_items;
	}

	public void setM_items(String m_items) {
		M_items = m_items;
	}

	public String getS_items() {
		return S_items;
	}

	public void setS_items(String s_items) {
		S_items = s_items;
	}

	public String getQ_date() {
		return Q_date;
	}

	public void setQ_date(String q_date) {
		Q_date = q_date;
	}

	public String getQ_content() {
		return Q_content;
	}

	public void setQ_content(String q_content) {
		Q_content = q_content;
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

	public int getEmergency() {
		return emergency;
	}

	public void setEmergency(int emergency) {
		this.emergency = emergency;
	}

	public String getPostpic_url() {
		return postpic_url;
	}

	public void setPostpic_url(String postpic_url) {
		this.postpic_url = postpic_url;
	}

	public String getA_date() {
		return A_date;
	}

	public void setA_date(String a_date) {
		A_date = a_date;
	}

	public String getA_content() {
		return A_content;
	}

	public void setA_content(String a_content) {
		A_content = a_content;
	}

	public int getA_flag() {
		return A_flag;
	}

	public void setA_flag(int a_flag) {
		A_flag = a_flag;
	}

	public int getArea_open() {
		return area_open;
	}

	public void setArea_open(int area_open) {
		this.area_open = area_open;
	}

	public String getManapic_url() {
		return manapic_url;
	}

	public void setManapic_url(String manapic_url) {
		this.manapic_url = manapic_url;
	}

}