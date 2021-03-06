package jpabook.jpashop;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.exception.SessionConstants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class HelloController {

	@GetMapping("/loginsession")
	public String hello(@SessionAttribute(name = SessionConstants.LOGIN_MEMBER, required = false) Member loginMember, Model model) {
		// 세션에 회원 데이터가 없으면 홈으로 이동
		if (loginMember == null) {
			return "home";
		}

		// 세션이 유지되면 로그인 홈으로 이동
		model.addAttribute("member", loginMember);

		return "home";
	}
}
