package model;

import java.io.Serializable;

public class Question_post implements Serializable {

	// Post_wordの列名をフィールドに設定する

	protected int QQ_id;                // 識別ナンバー
	protected int ac_id;                // 識別ID
	protected int Post_Number;          // 共有ナンバー
	private String M_items;             // 大項目
	private String S_items;             // 小項目
	private String Q_date;              // 投稿日
	private String Q_content;           // 質問内容
	private int A_level;                // 回答レベル
	private int Q_flag;                 // 質問者フラグ
	private int emergency;              // 緊急レベル
	private String Postpic_url;         // 画像



	// 引数がないコンストラクタ（デフォルトコンストラクタ）
	public Question_post() {
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
		this.Postpic_url = "";
	}

	// 引数があるコンストラクタ
	public Question_post(int QQ_id, int ac_id, int Post_Number, String M_items, String S_items, String Q_date, String Q_content, int A_level, int Q_flag, int emergency, String Postpic_url) {
		super();
		this.QQ_id = QQ_id;
		this.ac_id = ac_id;
		this.Post_Number = Post_Number;
		this.M_items = M_items;
		this.S_items = S_items;
		this.Q_date = Q_date;
		this.Q_content = Q_content;
		this.A_level = A_level;
		this.Q_flag = Q_flag;
		this.emergency = emergency;
		this.Postpic_url = Postpic_url;
	}

	// getter ・ setter
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
		return Postpic_url;
	}

	public void setPostpic_url(String Postpic_url) {
		this.Postpic_url = Postpic_url;
	}

	
}