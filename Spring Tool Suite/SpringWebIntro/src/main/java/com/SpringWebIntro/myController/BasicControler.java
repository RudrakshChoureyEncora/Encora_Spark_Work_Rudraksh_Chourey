package com.SpringWebIntro.myController;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.SpringWebIntro.model.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;

@Controller
@RequestMapping("bc1")
@SessionAttributes({"","atbToModelFromMAndV"})
public class BasicControler {	
	
	
	@RequestMapping(method = RequestMethod.GET, value="/SayHello")
	public String sayHello() {
		System.out.println("Hello Spring Web without param");
		return "home";
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/SayHello1")
	public void sayHello(HttpServletRequest req) {
		System.out.println("Hello Spring Web without param with capturing request object");
		System.out.println(req.getParameter("name"));
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/SayHello2")
	public void sayHello(@RequestParam("asdd") String name) {
		System.out.println("Hello Spring Web..."+name);
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/SayHello3")
	public void sayHello(@RequestParam("name") String name,@RequestParam("name2") String name2) {
		System.out.println("Hello Spring Web..."+name);
		
	}
	
	
	@RequestMapping(method=RequestMethod.GET, value="/SayHello7{myp}")
	public void sayHello4(@PathParam("myp") String name) {
		System.out.println("Hello Spring myp Web..."+name);
		
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value="/SayHello8")
	public String sayHello(HttpServletRequest req,Model m) {
		req.setAttribute("atbToReq", "val1");
		m.addAttribute("atbToModel","val2");
		System.out.println("Hello Spring Web without param with capturing request object");
		return "home";
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/SayHello9")
	public  ModelAndView sayHello2(HttpServletRequest req) {
		ModelAndView mAndV=new ModelAndView();
		req.setAttribute("atbToReq", "val1");
		mAndV.addObject("atbToModelFromMAndV", "val2");
		mAndV.setViewName("home");
		System.out.println("Hello Spring Web without param with capturing request object");
		return mAndV;
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/SayHello10")
	public  ModelAndView sayHello2() {
		ModelAndView mAndV=new ModelAndView();
		mAndV.addObject("userObj", new User());
		mAndV.setViewName("SpringCustomJsp");
		System.out.println("Hello Spring Web without param with capturing request object");
		return mAndV;
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value="/SayHello11")
	public  String sayHello3(HttpServletRequest req) {
		req.getSession().setAttribute("userObj", new User());
		return "SpringCustomJsp";
	}
	
	
	@RequestMapping(method=RequestMethod.POST,  value="/SayHello10")
	public ModelAndView processSpringCustomForm(@Valid @ModelAttribute("userObj") User user,BindingResult result) {
		ModelAndView mAndV=new ModelAndView();
		System.out.println("I am running action");
		if(result.hasErrors()) {
			mAndV.setViewName("SpringCustomJsp");
			return mAndV;
		}
		else {
			mAndV.setViewName("EntryPage");
			return mAndV;
		}
	}
	
//	
//	public String 
}
