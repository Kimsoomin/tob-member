package member;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import global.DAO;

public class HanbitMain {
	/**
	 * "안녕하세요" .substring(0.2); => 0이상 2미만 "안녕" 
	 * "안녕하세요" .substring(1.3); => 1이상 3미만 "녕하"
	 */

	public static void main(String[] args) {
		/**
		 * CRUD
		 * Create : 추가
		 * Read   : 검색
		 * Update : 수정
		 * Delete : 삭제
		 */
		Scanner scanner = new Scanner(System.in);
		MemberService service = MemberServiceImpl.getInstance();
		MemberDAO dao = MemberDAO.getInstance();
		List<MemberVO> list = new ArrayList<MemberVO>();
	
		MemberVO m = new MemberVO();
		while (true) {
			System.out.println("1번.회원가입 2.로그인 3.총회원수 "
					+ "4.ID검색 5.이름검색 6. 다양 검색 7.회원정보수정 "
					+ "8.전체회원정보 9.회원탈퇴 10.종료");
			switch (scanner.nextInt()) {
			case 1:
				System.out.println("아이디");
				String userid = scanner.next();
				System.out.println("비번");
				String password = scanner.next();
				System.out.println("이름");
				String name = scanner.next();
				System.out.println("성별");
				String gender = scanner.next();
				System.out.println("생일");
				String birth = scanner.next();
				System.out.println("주소");
				String addr = scanner.next();
				System.out.println("메일");
				String email = scanner.next();
				System.out.println("전화번호");
				String phone = scanner.next();
				MemberVO temp = new MemberVO( userid, password,
						 name,  birth, phone,  email, 
						 gender, addr);
				dao.insert(temp);
				if (dao.insert(temp)==1) {
					System.out.println("회원가입 성공");
				} else {
					System.out.println("회원가입 실패");
				}
				
//				service.join(id, pass, name, age, addr);
				break;
			case 2:
				System.out.println("아이디, 비번 입력");
				String loginID = scanner.next();
				String loginPass = scanner.next();
				m = dao.login(loginID,loginPass);
				if (m != null) {
					System.out.println("환영");
				}	System.out.println("실패");
				
				break;
			case 3:
				System.out.println(dao.count() +" 명 입니다");
				break;
			case 4:
				System.out.println("검색할 아이디 입력");
				String searchID = scanner.next();
				searchByID(dao, searchID);	//메소드 리펙토링
					
				break;
			//	
			case 5:
				System.out.println("이름 검색");
				String name1 = scanner.next();
				System.out.println(dao.selectBy(name1));
				
//				id = scanner.next();
//				System.out.println("Pass");
//				pass = scanner.next();
//				System.out.println(service.changePass(id, pass));
				break;
			case 6:
				System.out.println("검색항목 1: 이름 2.주소 3.성별");
				int sub = scanner.nextInt();
				switch (sub) {
				case 1:
					System.out.println("검색 이름");
					list = dao.selectSomeBy("name", scanner.next());
					break;
				case 2:
					System.out.println("검색 주소: ");
					list = dao.selectSomeBy("addr", scanner.next());
					break;
				case 3:
					System.out.println("검색 성별(남:M 여:W)");
					list = dao.selectSomeBy("gender", scanner.next());
					break;
				default:
					break;
				}
				for (MemberVO vo : list) {
					System.out.println(vo);
				}
			case 7:
				System.out.println("아이디, 비번 입력");
				String loginID2 = scanner.next();
				String loginPass2 = scanner.next();
				m = dao.login(loginID2,loginPass2);
				if (m != null) {
					System.out.println("환영");
				} else {
					System.out.println("다시 입력");
					break;
				}
				System.out.println("수정 항목. 비번:password, 주소:addr");
				String column = scanner.next();
				System.out.println("수정값 입력");
				String changeVal = scanner.next();
				switch (column) {
				case "password": 
					m.setPassword(changeVal);
					dao.update(m);
					break;
				case "addr":
					m.setAddr(changeVal);
					dao.update(m);
					break;

				default:
					break;
				}
				System.out.println("정보가 수정되었습니다");
				searchByID(dao, loginID2);
				break;
			case 8:
				list = dao.selectAll();
				for (MemberVO mem : list) {
					System.out.println(mem);
				}
				break;
			case 9:
				System.out.println("삭제할 ID 입력");
				String deletId = scanner.next();
				System.out.println(dao.delete(deletId));
				break;
			case 10:
				return;
			default:
				break;
			}
		}
	}

	private static void searchByID(MemberDAO dao, String searchID) {
		MemberVO m;
		m= dao.selectOneby(searchID);
		if (m.getUserid() != null) {
			System.out.println(m.toString());
		} else {
			System.out.println("존재하지 않음");
		}
	}
}
