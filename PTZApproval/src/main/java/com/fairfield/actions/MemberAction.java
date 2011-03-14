package com.fairfield.actions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberAction {

	@RequestMapping(value="/logout.do",method=RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request) throws Exception{
		request.getSession().invalidate();
		return new ModelAndView("login");
	}	
	
	@RequestMapping(value="/login.do",method=RequestMethod.GET)
	public ModelAndView showLogin(@RequestParam(value="error", required=false) boolean error) throws Exception{
		ModelAndView mv = new ModelAndView("login");
		if(error){
			mv.addObject("error","User Name or Password is incorrect");
		}
		return mv;
	}
	@RequestMapping(value="/home.do")
	public String showHomePage(HttpServletRequest request){
		return "home";
	}
	
}