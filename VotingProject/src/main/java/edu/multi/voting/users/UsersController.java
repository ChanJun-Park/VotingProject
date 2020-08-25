package edu.multi.voting.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

// login - post/get , signup - post/get


@Controller
public class UsersController {
	
	@Autowired
	UsersDAO user_dao;
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String loginform() {
		return "Login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView loginProcess(String user_id, String password) {
		System.out.println(user_id);
		System.out.println(password);
		ModelAndView mv = new ModelAndView();
		UsersVO vo = new UsersVO();
		vo=user_dao.validcheck(user_id,password);
		if(vo.getUser_id()==null) {
			mv.addObject("validcheck","아이디가 존재하지 않습니다. 회원가입하세요.");
			mv.setViewName("Login");
		}
		else if(vo.getPassword().equals(password)==false) {
			mv.addObject("validcheck","비밀번호가 일치하지 않습니다.");
			mv.setViewName("Login");
		}
		else {
			System.out.println("����");
			mv.addObject("validcheck","success");
			mv.setViewName("MainPage");
		}
		
		return mv;
	}
	
	@RequestMapping(value = "/signup",method=RequestMethod.GET)
	public String signupform() {
		return "CreateID";
	}
	
	
	
	@RequestMapping(value = "/signup",method=RequestMethod.POST)
	//���� �̿ϼ�
	public ModelAndView signupProcess(UsersVO vo) {
		ModelAndView mv = new ModelAndView();
		System.out.println(vo.getPassword());
		System.out.println(vo.getNickname());
		System.out.println(vo.getEmail());
		
		user_dao.createUser(vo);
		mv.setViewName("Login");
		return mv;
		
	}
	
	@RequestMapping(value = "/dupcheck", method=RequestMethod.POST)
	public @ResponseBody String dupcheck(@RequestParam("user_id") String user_id) {
	
		String dupcheck;
		dupcheck= user_dao.dupcheck(user_id);
		System.out.println(dupcheck);
		return dupcheck;
		
	}
	
	
}
	


