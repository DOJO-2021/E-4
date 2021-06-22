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
	private int count;				    // カウント
	private String A_content;           // 回答
	private String A_date;              // 回答日



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
		this.A_date = "";
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

	// -------------------- insert用 コンストラクタ----------------------
	public Question_post(int ac_id, String M_items, String S_items, String Q_date, String Q_content, int A_level, int Q_flag, int emergency, String Postpic_url) {
		super();
		
		this.ac_id = ac_id;
		this.M_items = M_items;
		this.S_items = S_items;
		this.Q_date = Q_date;
		this.Q_content = Q_content;
		this.A_level = A_level;
		this.Q_flag = Q_flag;
		this.emergency = emergency;
		this.Postpic_url = Postpic_url;
	}
	
	// -------------------- よくある質問用 コンストラクタ -------------------- 
		public Question_post(String M_items, int count, String Q_content, String A_content) {
		this.M_items = M_items;
		this.count = count;
		this.Q_content = Q_content;
		this.A_content = A_content;
		}
		
	// -------------------- 最近の質問用 コンストラクタ -------------------- 
		public Question_post(String M_items, int count, String Q_content, String A_content, String A_date) {
			this.M_items = M_items;
			this.count = count;
			this.Q_content = Q_content;
			this.A_content = A_content;
			this.A_date = A_date;
			}
		
	

	// getter ・ setter
	public int getQQ_id() {
		return QQ_id;
	}

	public void setQQ_id(int QQ_id) {
		this.QQ_id = QQ_id;
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

	public void setPost_Number(int Post_Number) {
		this.Post_Number = Post_Number;
	}

	public String getM_items() {
		return M_items;
	}

	public void setM_items(String M_items) {
		this.M_items = M_items;
	}

	public String getS_items() {
		return S_items;
	}

	public void setS_items(String S_items) {
		this.S_items = S_items;
	}

	public String getQ_date() {
		return Q_date;
	}

	public void setQ_date(String Q_date) {
		this.Q_date = Q_date;
	}

	public String getQ_content() {
		return Q_content;
	}

	public void setQ_content(String Q_content) {
		this.Q_content = Q_content;
	}

	public int getA_level() {
		return A_level;
	}

	public void setA_level(int A_level) {
		this.A_level = A_level;
	}

	public int getQ_flag() {
		return Q_flag;
	}

	public void setQ_flag(int Q_flag) {
		this.Q_flag = Q_flag;
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

	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getA_content() {
		return A_content;
	}
	public void setA_content(String a_content) {
		A_content = a_content;
	}
	public String getA_date() {
		return A_date;
	}
	public void setA_date(String a_date) {
		A_date = a_date;
	}
}

	
