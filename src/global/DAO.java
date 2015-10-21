package global;

import java.util.List;

import member.MemberVO;
import score.ScoreVO;

public abstract class DAO {
	public int insert (Object o){return 0;};
	public String update (String s1,String s2,String s3){return null;};
	public List selectAll(){return null;}
	public List selectBy(){return null;}
	public Object selectOneby (String key){return null;}
	public int delete (String id){return 0;};
	public int delete (Object o){return 0;};
	public abstract int count();
	public int insert(ScoreVO o) {return 0;}
}
