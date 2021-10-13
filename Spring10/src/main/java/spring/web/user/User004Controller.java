package spring.web.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import mybatis.service.user.UserDao;
import spring.service.domain.User;
import spring.service.user.dao.UserDAO;

@Controller
public class User004Controller {

	@Autowired
	@Qualifier("userDaoImpl14")
	UserDao userDao;
	public User004Controller() {
		// TODO Auto-generated constructor stub
		System.out.println("==>User004Controller default Constructor call.....");
	}
	
	@RequestMapping("/logon.do")
	public ModelAndView logon() {
		System.out.println("\n:: ==> logon() start....");
		
	String message = "[logon()] ���̵�,�н����� 3���̻� �Է��ϼ���.";
	
		//System.out.println("\n:: ==> logon() start....");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/user002/logon.jsp");
		modelAndView.addObject("message", message);
		
		System.out.println("\n:: ==> logon() end....");
		return modelAndView;
	}
	
	@RequestMapping("/home.do")
	public ModelAndView home() {
		
		System.out.println("\n:: ==> home() start....");
		String message = "[home() ]WELCOME";
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/user002/home.jsp");
		modelAndView.addObject("message",message);
		
		System.out.println("\n:: ==> home() end....");
		
		return modelAndView;
	}
	@RequestMapping(value="/logonAction.do", method=RequestMethod.GET)
	public ModelAndView logonAction() {
		
		System.out.println("\n:: ==> logonAction() start....");
		String message = "[home() ]WELCOME";
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/user002/home.jsp");
		modelAndView.addObject("message",message);
		
		System.out.println("\n:: ==> logonAction() end....");
		
		return modelAndView;
	}
	@RequestMapping(value="/logonAction.do", method=RequestMethod.POST)
	public ModelAndView logonAction(@ModelAttribute("user") User user,
									HttpSession session) {
		
		System.out.println("[logonAction() method=RequestMethod.POST start....");
		String viewName = "/user002/logon.jsp";
		
		UserDAO userDAO = new UserDAO();
		userDAO.getUser(user);
		
		if(user.isActive()) {
			viewName = "/user002/home.jsp";
			session.setAttribute("sessionUser",user);
		}
	//}
	System.out.println("[action :"+viewName+"]");
	
	String message = null;
	if(viewName.equals("/user002/home.jsp")) {
		message = "[logonAction() ] WELCOME";
	}else {
		message = "[logonAction()]���̵�,�н����� 3���̻� �Է��ϼ���.";
	}
	
	
	ModelAndView modelAndView = new ModelAndView();
	modelAndView.setViewName(viewName);
	modelAndView.addObject("message",message);
	
	//System.out.println("[logonAction() end.....]\n");
	System.out.println("[logonAction() method=RequestMethod.POST end....");
	return modelAndView;

	}
	
	@RequestMapping("/logout.do")
	public ModelAndView logout(HttpSession session) {
		
		System.out.println("\n:: ==> logout() start....");
		
		session.removeAttribute("sessionUser");
		
		String message = "[Logout()] ���̵�,�н����� 3���̻� �Է��ϼ���.";
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/user002/logout.jsp");
		modelAndView.addObject("message", message);
		System.out.println("\n:: ==> logout() end....");
		
		return modelAndView;
	}

}
