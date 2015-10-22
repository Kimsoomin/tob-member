package member;

import java.util.ArrayList;
import java.util.List;

public class MemberServiceImpl implements MemberService{
	private static MemberService instance = new MemberServiceImpl();
	public static MemberService getInstance() {
		return instance;
	} 
	MemberDAO dao = new MemberDAO();
	/**
	 * DML
	 */
	// 회원가입
	@Override
	public String join(MemberVO o) {
		String temp = "";
		System.out.println("회원가입 " +o.toString());
		if (dao.insert(o) == 1) {
			System.out.println("회원가입 성공");
		}else{
			System.out.println("회원가입 실패");
		}
		return temp;
	}
	//비번변경
	@Override
	public int changePass(MemberVO o) {
		return dao.update(o);
	}
	 // 회원탈퇴
	@Override
	public int remove(MemberVO o) {
		return dao.delete(o);
	}
	/**
	 * DQL
	 */
	// 로그인
	@Override
	public MemberVO login(String id, String pass) {
		return dao.login(id, pass);
	}
	//전체 회원수 
	@Override
	public int count() {
		return dao.count();
	}
	//ID로 회원검색
	@Override
	public MemberVO searchById(String id) {
		MemberVO m = new MemberVO();
		m =dao.selectOneBy(id);
		
		return m;
	}
	// 검색어로 검색
	@Override
	public List<MemberVO> searchBySearchword(String domain,String searchword) {
		return dao.selectSomeBy(domain, searchword);
	}
	// 전체 회원목록 
	@Override
	public List<MemberVO> getList() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		list = dao.selectAll();
		return list;
	}
	 
	
}
