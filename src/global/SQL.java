package global;

import java.util.List;

import member.MemberVO;

public interface SQL {
	/**
	 * executeUpdate : DML 중에 테이블의 데이터값이 변형됨
	 */
	public String insert();		// 추가
	public String update();		// 수정
	public String delete(String s);		// 삭제

	/**
	 * executeQuery : DML 중에 테이블의 데이터값이 변형되지 않음 
	 */
	public String selectAll();			   	// 전체조회
	public String selectOneby(String s);	// ID 조회
	public String count();					// 전체 수량
	public String selectBy(String s);		// 이름 조회
	public String selectSomeBy(String s1, String s2);	// 다중 결과값 검색
	
	/**
	 * 쿼리 스타일
	 */
	public String make(String s);		// SQL타입의 파라미터로 변환

	

}
