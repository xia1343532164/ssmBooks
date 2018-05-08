package Books.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@RequestMapping(method = RequestMethod.GET,value="/login")
	public String login(@RequestParam(required=false) String error){
		if(error != null){
			System.out.println("µÇÂ¼Ê§°Ü");
			}
		return "login";
	}
}
