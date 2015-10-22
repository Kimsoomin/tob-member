package member;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HanbitCom {
	/**
	 * "안녕하세요".substring(1,3);  0이상 2미만
	 * "녕하"
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * CRUD
		 * Create : 추가
		 * Read : 검색
		 * Update : 수정
		 * Delete : 삭제
		 */
		String id = "", pass ="";
		Scanner scanner = new Scanner(System.in);
		MemberService service = MemberServiceImpl.getInstance();
		List<MemberVO> list = new ArrayList<MemberVO>();
		MemberVO m = new MemberVO();
		while (true) {
			System.out.println("1 : 회원가입  2: 로그인  3:총회원수 4:ID검색  "
					+ "5:조건검색 6:회원정보수정 7:전체회원정보 9:회원탈퇴  10:종료");
			
			switch (scanner.nextInt()) {
			case 1:
				System.out.println("아이디 입력하세요");
				String userid = scanner.next();
				if (service.searchById(userid).getUserid() != null) {
					System.out.println("이미 가입된 아이디 입니다.");
					break;  // 다시 처음 입력명령문으로 되돌아감
				}
				System.out.println("비번 입력하세요");
				String password = scanner.next();
				System.out.println("이름 입력하세요");
				String name = scanner.next();
				System.out.println("성별 입력하세요");
				String gender = scanner.next();
				System.out.println("생년 입력하세요");
				String birth = scanner.next();
				System.out.println("이메일 입력하세요");
				String email = scanner.next();
				System.out.println("주소 입력하세요");
				String addr = scanner.next();
				System.out.println("전화번호 입력하세요");
				String phone = scanner.next();
				MemberVO temp = new MemberVO( userid,  password,  name, 
						 birth,  phone,  email,
						 gender,  addr);
				System.out.println(service.join(temp));
				break;
			case 2:
				System.out.println("로그인 할 ID, 비번을 입력 해주세요");
				String loginId = scanner.next();
				String loginPass = scanner.next();
				if (service.login(loginId, loginPass).getUserid() != null) {
					System.out.println("환영합니다.");
				} else {
					System.out.println("로그인 실패입니다.");
				}
				break;
			case 3:
				System.out.println(service.count()+"명 입니다.");
				break;
			case 4:
				System.out.println("검색할 ID 입력 : ");
				String searchId = scanner.next();
				m = service.searchById(searchId);
				if (m.getUserid() != null) {
					System.out.println(m.toString());
				}else{
					System.out.println("검색할 ID가 존재하지 않습니다.");
				}
				break;
			case 5:
				System.out.println("검색할 항목을 정해주세요. 1:이름 2:주소 3:성별");
				int sub = scanner.nextInt();
				switch (sub) {
				case 1: 
					System.out.println("검색할 이름 입력 : ");
					list = service.searchBySearchword("name", scanner.next());
					break;
				case 2:
					System.out.println("검색할 주소 입력 : ");
					list = service.searchBySearchword("addr", scanner.next());
					break;
				case 3:
					System.out.println("검색할 성별 입력(남:M , 여:W) : ");
					list = service.searchBySearchword("gender", scanner.next());
					break;
				default:
					break;
				}
				for (MemberVO vo : list) {
					System.out.println(vo);
				}
				break;
			case 6:
				System.out.println("로그인 할 ID, 비번을 입력 해주세요");
				String loginId2 = scanner.next();
				String loginPass2 = scanner.next();
				m = service.login(loginId2, loginPass2);
				if (m != null) {
					System.out.println("환영합니다.");
				}else{
					System.out.println("다시 로그인 해주세요");
					break;
				}
				System.out.println("수정할 항목을 정해주세요.(비번 : password, 주소 : addr)");
				String column = scanner.next();
				System.out.println("수정값을 입력하세요");
				String changeVal = scanner.next();
				switch (column) {
				case "password":
					m.setPassword(changeVal);
					if (service.changePass(m)==1) { // 오라클이 리턴한 값
						System.out.println("수정되었습니다.");
					} else {
						System.out.println("수정 실패");
					} 
					break;
				case "addr":
					m.setAddr(changeVal);
					service.changePass(m);
					break;

				default:break;
				}
				System.out.println("정보가 수정되었습니다.");
//				searchByID(dao, loginId2);
				break;
			case 7:
				list = service.getList();
				for (MemberVO mem : list) {
					System.out.println(mem);
				}
				break;
			case 9:
				System.out.println("로그인 할 ID, 비번을 입력 해주세요");
				String delId = scanner.next();
				String delPw = scanner.next();
				m = service.login(delId, delPw);
				if (m != null) {
					System.out.println("환영합니다.");
				}else{
					System.out.println("다시 로그인 해주세요");
					break;
				}
				if (service.remove(m) == 1) {
					System.out.println("삭제되었습니다.");
				}else{
					System.out.println("실패했습니다.");
					break;
				}
				break;
			case 10: return;
			default:
				break;
			}
		}
	}

}