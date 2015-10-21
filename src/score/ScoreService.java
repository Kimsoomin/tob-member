package score;

import java.util.ArrayList;
import java.util.List;

public interface ScoreService {
	/*
	 * DML
	 */
	public String input(ScoreVO score);
	/**
	 * DQL
	 */
	// 전체 회원 목록
	public List<ScoreVO> getList();
	// 아이디 검색
	public ScoreVO searchByUserid(String userid);
	// 이름 검색
	public ScoreVO searchByName(String name);
	// 성적 내림 차순 정렬
	public void descByTotal();
	// 성적 오름 차순 정렬
	public void ascByTotal();
	// 이름 오름차순 정렬	
	public ArrayList<ScoreVO> ascByName();		

}
