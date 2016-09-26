package com.whc.shoppingcart.web;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.whc.shoppingcart.domain.User;


@Controller
public class UserController extends BaseController {

	@RequestMapping(value = "/userValidation", params = { "username", "password" }, method = RequestMethod.GET)
	public @ResponseBody User UserValidation(@RequestParam(value = "username") String username,
			@RequestParam(value = "password") char[] password) {
		User u = us.UserValidation(username, password);
		return u;

	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	@ResponseBody
	public String UserRegisteration(@RequestBody User user) {
		if (us.checkUserExist(user.getUserName())) {
			return "failed";
		}
		us.UserRegistration(user);
		return "success";
	}
	
	

}
