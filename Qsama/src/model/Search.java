package model;

import java.io.Serializable;

public class Search implements Serializable {

	private int key_id; 			// キーワードナンバー
	private String	word;			// 検索キーワード
	private String	search_date;	// 検索日
	private int QQ_id;				// (質問)識別ナンバー
	private int ac_id;				// 識別ID
	private int Post_Number;		// 共有ナンバー
	private String M_items;		// 大項目
	private String S_items;		// 小項目
	private String Q_date;			// 投稿日
	private String Q_content;		// 質問内容
	private int A_level;			// 回答レベル
	private int Q_flag;			// 質問者フラグ
	private int emergency;			// 緊急レベル
	private int AA_id;				// (回答)識別ナンバー
	private String A_date;			// 回答日
	private String A_content;		// 回答内容
	private int A_flag;			// 回答者フラグ
	private int area_open;			// 公開範囲指定
	private String Search_word;	// 検索キーワード
	private int count;				// カウント

	// 検索キーワード 蓄積用
	public Search(int key_id, String word, String search_date){
	this.key_id = key_id;
	this.word = word;
	this.search_date = search_date;
	}
	// 検索キーワード 検索用
	public Search(String Search_word) {
	this.Search_word = Search_word;
	}

	// ランキング用
	public Search(String word, int count) {
	this.word = word;
	this.count = count;
	}

	public Search(){
	this.key_id = 0;
	this.word = "";
	this.search_date = "";
	this.QQ_id = 0;
	this.ac_id = 0;
	this.Post_Number = 0;
	this.M_items ="";
	this.S_items = "";
	this.Q_date = "";
	this.Q_content = "";
	this.A_level = 0;
	this.Q_flag = 0;
	this.emergency = 0;
	this.AA_id = 0;
	this.A_date = "";
	this.A_content = "";
	this.A_flag = 0;
	this.area_open = 0;
	this.Search_word = "";
	}

	// Post_word と management_word のミックス
	public Search(int QQ_id, int ac_id, int Post_Number, String M_items, String S_items, String Q_date, String Q_content,
			int A_level, int Q_flag, int emergency, int AA_id, String A_date, String A_content, int A_flag, int area_open){
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
	this.AA_id = AA_id;
	this.A_date = A_date;
	this.A_content = A_content;
	this.A_flag = A_flag;
	this.area_open = area_open;
	}

	public int getKey_id() {
		return key_id;
	}
	public void setKey_id(int key_id) {
		this.key_id = key_id;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public String getSearch_date() {
		return search_date;
	}
	public void setSearch_date(String search_date) {
		this.search_date = search_date;
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
	public int getAA_id() {
		return AA_id;
	}
	public void setAA_id(int aA_id) {
		AA_id = aA_id;
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
	public String getSearch_word() {
		return Search_word;
	}
	public void setSearch_word(String search_word) {
		Search_word = search_word;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}
