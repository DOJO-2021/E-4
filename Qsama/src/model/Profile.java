package model;
import java.io.Serializable;

public class Profile implements Serializable {
	private int pro_id;			// プロフィールID
	private int ac_id;				// 識別ID
	private int user_id;			// ユーザーID
	private String company;		// 会社名
	private String my_class;	// クラスNo
	private String name;			// 氏名
	private String experience;		// プログラミング経験
	private String bloodtype;		// 血液型
	private String birthday;		// 誕生日
	private String college;		// 大学名
	private String undergraduate;	// 学部名
	private String hobby;			// 趣味
	private String special_skill;	// 特技
	private String qualification;	// 資格
	private String favorite;		// 好きなアーティスト
	private String comment;		// 一言コメント
	private String back_url;		// 壁紙のURL
	private String prof_url;		// 顔写真のURL


	public Profile(int ac_id, int user_id, String company, String my_class, String name, String experience,
			String bloodtype, String birthday, String college, String undergraduate, String hobby,
			String special_skill, String qualification, String favorite, String comment) {

		this.ac_id = ac_id;					// 識別ID
		this.user_id = user_id;				// ユーザーID
		this.company = company;				// 会社名
		this.my_class = my_class;	// クラスNo
		this.name = name;					// 氏名
		this.experience = experience;		// プログラミング経験
		this.bloodtype = bloodtype;			// 血液型
		this.birthday = birthday;			// 誕生日
		this.college = college;				// 大学名
		this.undergraduate = undergraduate;	// 学部名
		this.hobby = hobby;					// 趣味
		this.special_skill = special_skill;	// 特技
		this.qualification = qualification;	// 資格
		this.favorite = favorite;			// 好きなアーティスト
		this.comment = comment;				// 一言コメント
	}

	public Profile() {

		this.ac_id = 0;				// 識別ID
		this.user_id = 0;			// ユーザーID
		this.company = "";			// 会社名
		this.my_class = "";		// クラスNo
		this.name = "";				// 氏名
		this.experience = "";		// プログラミング経験
		this.bloodtype = "";		// 血液型
		this.birthday = "";			// 誕生日
		this.college = "";			// 大学名
		this.undergraduate = "";	// 学部名
		this.hobby = "";			// 趣味
		this.special_skill = "";	// 特技
		this.qualification = "";	// 資格
		this.favorite = "";			// 好きなアーティスト
		this.comment = "";			// 一言コメント
	}
	public Profile(String company, String my_class, String name, String experience,String bloodtype,
			String birthday, String college, String undergraduate, String hobby, String special_skill,
			String qualification, String favorite, String comment, String back_url, String prof_url, int ac_id) {

		this.company = company;				// 会社名
		this.my_class = my_class;	        // クラスNo
		this.name = name;					// 氏名
		this.experience = experience;		// プログラミング経験
		this.bloodtype = bloodtype;			// 血液型
		this.birthday = birthday;			// 誕生日
		this.college = college;				// 大学名
		this.undergraduate = undergraduate;	// 学部名
		this.hobby = hobby;					// 趣味
		this.special_skill = special_skill;	// 特技
		this.qualification = qualification;	// 資格
		this.favorite = favorite;			// 好きなアーティスト
		this.comment = comment;				// 一言コメント
		this.back_url = back_url;			// 壁紙のURL
		this.prof_url = prof_url;			// 顔写真のURL
		this.ac_id = ac_id;					// 共通ID
	}

	public Profile(int pro_id, String my_class, String name, int ac_id, String company) {
		this.pro_id = pro_id;				// 識別ID
		this.my_class = my_class;	        // クラスNo
		this.name = name;					// 氏名
		this.ac_id = ac_id;					// 共通ID
		this.company = company;				// 会社名
	}

	public int getPro_id() {
		return pro_id;
	}

	public void setPro_id(int pro_id) {
		this.pro_id = pro_id;
	}

	public String getBack_url() {
		return back_url;
	}

	public void setBack_url(String back_url) {
		this.back_url = back_url;
	}

	public String getProf_url() {
		return prof_url;
	}

	public void setProf_url(String prof_url) {
		this.prof_url = prof_url;
	}

	public int getAc_id() {
		return ac_id;
	}
	public void setAc_id(int ac_id) {
		this.ac_id = ac_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getMy_class() {
		return my_class;
	}
	public void setMy_class(String class_number) {
		this.my_class = class_number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getBloodtype() {
		return bloodtype;
	}
	public void setBloodtype(String bloodtype) {
		this.bloodtype = bloodtype;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getUndergraduate() {
		return undergraduate;
	}
	public void setUndergraduate(String undergraduate) {
		this.undergraduate = undergraduate;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getSpecial_skill() {
		return special_skill;
	}
	public void setSpecial_skill(String special_skill) {
		this.special_skill = special_skill;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getFavorite() {
		return favorite;
	}
	public void setFavorite(String favorite) {
		this.favorite = favorite;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

}
