package com.SpringWebIntro.myController;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.SpringWebIntro.model.User;

import jakarta.validation.Valid;

@Controller
@RequestMapping("form")
public class FormController {

	
	
	@RequestMapping(method = RequestMethod.GET, value="/runForm")
	public  ModelAndView sayHello2() {
		ModelAndView mAndV=new ModelAndView();
		mAndV.addObject("userObj", new User());
		mAndV.setViewName("SpringCustomJsp");
		System.out.println("Hello Spring Web without param with capturing request object");
		return mAndV;
	}
	
	@RequestMapping(method=RequestMethod.POST,  value="/runForm")
	public ModelAndView processSpringCustomForm(@Valid @ModelAttribute("userObj") User user,BindingResult result) {
		ModelAndView mAndV=new ModelAndView();
		System.out.println("I am running action");
		if(result.hasErrors()) {
			mAndV.setViewName("SpringCustomJsp");
			return mAndV;
		}
		else {
			System.out.println("Username...:"+user.getUname());
			user.setUname(user.getUname()+"encora technologies...");
			mAndV.addObject("userObj",user);
			mAndV.setViewName("EntryPage");
			return mAndV;
		}
	}
}
