package member;

import java.io.Serializable;
import java.util.List;

import global.SQL;

public class MemberVO implements Serializable, SQL{

	private static final long serialVersionUID = 1L;
	
	private String userid;		// 아이디
	private String password;	// 비번
	private String name;		// 회원이름
	private String birth;		// 태어난 날짜
	private String phone;		// 전화번호
	private String email;		// 이메일
	private String gender;		// 성별
	private String addr;		// 주소
	private String regdate;		// 등록
	private String profile;		// 프로필사진

	public MemberVO() {
	
	}
	
	public MemberVO(String userid,String password,String name,
			String birth,String phone, String email, String gender,String addr
			) {
		this.userid = userid;
		this.password = password;
		this.name = name;
		this.birth = birth;
		this.phone = phone;
		this.email = email;
		this.gender = gender;
		this.addr = addr;
		this.profile = "default.png";
		
	}

	
	public String getUserid() {
		return userid;
	}
	public String getPassword() {
		return password;
	}
	public String getName() {
		return name;
	}
	public String getBirth() {
		return birth;
	}
	public String getPhone() {
		return phone;
	}
	public String getEmail() {
		return email;
	}
	public String getGender() {
		return gender;
	}

	public String getAddr() {
		return addr;
	}
	public String getRegdate() {
		return regdate;
	}
	public String getProfile() {
		return profile;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public void setProfile(String profile) {
		this.profile = "default.png";
	}
	
	@Override
	public String toString() {
		return "회원 [아이디=" + userid 
				+ ", 비밀번호=" + password 
				+ ", 이름=" + name
				+ ", 생년월일=" + birth
				+ ", 전화번호=" + phone
				+ ", 이메일=" + email
				+ ", 성별=" + gender
				+ ", 주소=" + addr
				+ ", 등록일=" + regdate
				+ ", 프로필 사진=" + profile + "]";
	}
	/**
	 * excuteUpdate
	 * 추가
	 * System.out.printf("hello %s, Good Bye %s ,name,name2);
	 */
	@Override
	public String insert() {
		String query = "insert into member "
				+ "(userid, password, name, birth, phone, email, "
				+ "gender, addr, regdate, profile) values(?,?,?,?,?,?,?,?,sysdate,?)";
		// ? -> %s , %d
		return query; 
	}
	@Override
	public String update() {
		String query = "update member set password = ?,"
				+ "phone = ?,"
				+ "email = ?,"
				+ "addr = ?,"
				+ "profile = ?"
				+ "where userid = ?";
		return query;
	}
	@Override
	public String delete(String id) {
		String query = "delete from member where ? = ?";
		return query;
	}
	@Override
	public String selectAll() {
		String query = "select * from member";
		return query;
	}
	@Override
	public String selectOneby(String s) {
		String query = "select * from  member where userid =" 
				+make(s) ;
		
		return query;
	}
	@Override
	public String count() {
		String query = "select count (*) as count from member";
		// 오라클에서 as는 결과값에 키 값을 주는 역할을 한다.
		// 키값은 rs 가 해당 value 를 가져올 때 사용한다.
		// 따로 정하지 않으며, 컬럼명이 키 값이 온다.
		// int count = 0; (= select count(*))
		return query;
	}
	@Override
	public String make(String s) {
		return "'"+s+"'";
	}
	
	@Override
	public String selectBy(String s) {
		String query = "select * from member where name =" 
	+make(s);
		return query;
	
	}
	@Override
	public String selectSomeBy(String s1,String s2) {
		String query = "select * from member where "
				+s1+ "=" +this.make(s2);
		
		return query;
	}

	
}
	
	
