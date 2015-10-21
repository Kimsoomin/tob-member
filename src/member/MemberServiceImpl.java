package member;

import java.security.Provider.Service;
import java.util.HashMap;
import java.util.Map;

public class MemberServiceImpl implements MemberService {
	private static MemberService instance = new MemberServiceImpl();
//	MemberService instance = new MemberServiceImpl;
	
	public static MemberService getInstance() {
		return instance;
	}


	Map<String, Object> map = new HashMap<String, Object>();
	MemberVO member = new MemberVO();

	@Override
	public void join(String id, String pass, String name, String age, String addr) {
		member.setUserid(id);
		member.setPassword(pass);
		member.setName(name);
		member.setBirth(age);
		member.setAddr(addr);
		map.put(id, member);
	}

	@Override
	public String login(String id, String pass) {
		String result = null;
		/**
		 * 환영한다. 서울에 사는 독거노인 길동아. 비번이 다르다. 다시 입력 입력한 아이디는 상대성 이론에 따라 안드로메다로 Map
		 * 에서 value 값만 가져오는 메소드는 map.get("key 값")
		 */

		if (map.containsKey(id)) {
			MemberVO temp = new MemberVO();
			temp = (MemberVO) map.get(id);
			if (temp.getUserid().equals(id)&&temp.getPassword().equals(pass)) {
				result = "환영합니다. "+temp.getAddr()+"에 사는 "+temp.getBirth()+"세 "+temp.getName()+"님";
			} else {
				result = "입력한 정보가 틀렸습니다.";
			}
		}
		return result;
	}

	@Override
	public int count() {
		
		return map.size();
	}
	/*
	 * ID 로 회원검색
	 */

	@Override
	public MemberVO searchById(String id) {
		MemberVO temp = (MemberVO) map.get(id);
		MemberVO result = null;
		if (id.equals(temp.getUserid())) {
			result = temp;
		}		
		return result;
		
		//		return (Member) map.get(id);
	}

	@Override
	public String changePass(String id, String pass) {
		String result = null;
		MemberVO target = (MemberVO) map.get(id);
		if (target != null) {
			target.setPassword(pass);
			result = "비밀번호 변경되었습니다.";
		} else {
			result = "비민번호가 변경되지 않았습니다.";
		}
		return result;
	}

	@Override
	public String remove(String id) {
		MemberVO temp = (MemberVO) map.get(id);
		String result = null;
			if (temp.getUserid().equals(id)) {
				map.remove(id);
				result = "입력하신 ID "+temp.getUserid()+ "를 삭제하였습니다";
			} else {
				result = "입력한 정보가 틀렸습니다.";
			}

		return result;
		/*
		 * String result = null;
		 * object m = map.remove(id);	리턴값이 value
		 * if ( m != null ){
		 * result = "입력한 id 가 삭제"
		 * }else{
		 * }
		 * return result
		 * }
		 */
	}
}
