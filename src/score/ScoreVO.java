package score;

import java.io.Serializable;

import global.SQL;

public class ScoreVO implements Serializable, SQL{
	private static final long serialVersionUID = 1L;
	private int scoreSeq;//일련번호
	private int java; //자바
	private int jsp; //JSP
	private int html; //html
	private int javascript; //자바스크립
	private int oracle; //오라클
	private int spring; //스프링
	private String userid; //유저아이디
	
	public ScoreVO() {
	}

	public ScoreVO(int scoreSeq, int java, int jsp, int html, int javascreipt, 
			int oracle, int Spring, String userid) {
		this.scoreSeq = scoreSeq;
		this.java = java;
		this.jsp = jsp;
		this.html = html;
		this.javascript = javascreipt;
		this.oracle = oracle;
		this.spring = spring;
		this.userid = userid;
	}
	
	public int getScoreSeq() {
		return scoreSeq;
	}

	public int getJava() {
		return java;
	}

	public int getJsp() {
		return jsp;
	}

	public int getHtml() {
		return html;
	}

	public int getJavascript() {
		return javascript;
	}

	public int getOracle() {
		return oracle;
	}
	
	public int getSpring() {
		return spring;
	}

	public String getUserid() {
		return userid;
	}

	public void setScoreSeq(int scoreSeq) {
		this.scoreSeq = scoreSeq;
	}

	public void setJava(int java) {
		this.java = java;
	}

	public void setJsp(int jsp) {
		this.jsp = jsp;
	}

	public void setHtml(int html) {
		this.html = html;
	}

	public void setJavascript(int javascript) {
		this.javascript = javascript;
	}

	public void setOracle(int oracle) {
		this.oracle = oracle;
	}
	

	

	public void setSpring(int spring) {
		this.spring = spring;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "점수 [일련번호" + scoreSeq +
				", java=" + java +
				", jsp=" + jsp +
				", html=" + html +
				", javascript="+ javascript + 
				", oracle=" + oracle + 
				", spring=" + spring + 
				", userid=" + userid + "]"+"\n";
	}
	
	/**
	 * 추가
	 */
	
	@Override
	public String insert() {
		String qurey = "insert into score"
				+ "(score_seq,java,jsp,html,javascreipt,oracle,spring,userid)"
				+ " values(score_seq.nextval,?,?,?,?,?,?,?)";
		return qurey;
	}

	@Override
	public String update() {
		String qurey = "update score"
				+ "set  java = ?,"
				+ "jsp = ?,"
				+ "javascreipt = ?,"
				+ "oracle = ?,"
				+ "spring = ?"
				+ "where userid = ?";
		return qurey;
	}

	@Override
	public String delete(String s) {
		String qurey = "delete from score where userid = ?";
		return qurey;
	}

	@Override
	public String selectAll() {
		String qurey = "select * from score";
		return qurey;
	}

	@Override
	public String selectOneby(String s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String count() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String selectBy(String s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String selectSomeBy(String s1, String s2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String make(String s) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
