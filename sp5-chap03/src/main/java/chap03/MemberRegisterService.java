package chap03;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberRegisterService {

	@Autowired
	private MemberDao MemberDao;
	
	public MemberRegisterService() {
	}
	
	public MemberRegisterService(MemberDao MemberDao) {
		this.MemberDao = MemberDao;
	}
	
	public Long regist(RegisterRequest req) {
		Member member = MemberDao.SelectByEmail(req.getEmail());
		if (member != null) {
			throw new DuplicateMemberException("Duplicated email : " + req.getEmail());
		}
		Member newMember = new Member(
						req.getEmail(), req.getPassword(), req.getName(),
						LocalDateTime.now());
		MemberDao.insert(newMember);
		return newMember.getID();
	}
	
}
