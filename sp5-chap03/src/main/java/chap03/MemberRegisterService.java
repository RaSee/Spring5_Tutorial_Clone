package chap03;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberRegisterService {

	@Autowired
	private MemberManager memberManager;
	
	public MemberRegisterService() {
	}
	
	public MemberRegisterService(MemberManager memberManager) {
		this.memberManager = memberManager;
	}
	
	public Long regist(RegisterRequest req) {
		Member member = memberManager.SelectByEmail(req.getEmail());
		if (member != null) {
			throw new DuplicateMemberException("Duplicated email : " + req.getEmail());
		}
		Member newMember = new Member(
						req.getEmail(), req.getPassword(), req.getName(),
						LocalDateTime.now());
		memberManager.insert(newMember);
		return newMember.getID();
	}
	
}
