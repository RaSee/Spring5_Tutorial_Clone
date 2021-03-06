package chap09;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegisterController {
	@RequestMapping("/step1")
	public String handleStep1() {
		return "register/step1";
	}
	
	@PostMapping("/step2")
	public String handleStep2(HttpServletRequest request) {
		String agreeParem = request.getParameter("agree");
		if(agreeParem == null || !agreeParem.equals("true")) {
			return "register/step1";
		}
		return "register/step2";
	}
	@GetMapping("/step2")
	public String handleStep2Get() {
		return "redirect:/register/step1";
	}
	
	@RequestMapping("/step3")
	public String handleStep3() {
		return "register/step3";
	}
	
	
}
