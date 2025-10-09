package com.LogginSession.controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.LogginSession.model.User;
import com.LogginSession.repository.ItemRepo;
import com.LogginSession.service.UserService;
import com.LogginSession.model.Item;
import com.LogginSession.model.Cart;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@Controller
@RequestMapping("BRC")
public class BasicRestController {

	@Autowired
	@Qualifier("uServ1")
	private UserService uServ;
	
//	@Autowired
//	@Qualifier("iServ1")
//	private ItemService iServ;

	@Autowired
	private ItemRepo iRepo;
	
	
	//---------------------------------------- Login ----------------------------------------------------------------------------------
	

	@RequestMapping(method=RequestMethod.GET,value="/Login")
	public ModelAndView openLogin(HttpServletRequest req,HttpServletResponse res) {
		System.out.println("get login to view log in");
		
		if(req.getSession().getAttribute("userObj")!=null) {
			System.out.println("user is there :");
			System.out.println(req.getSession().getAttribute("userObj"));
			System.out.println("users session id: "+((User)req.getSession().getAttribute("userObj")).getSessionid());
			System.out.println("current session id: "+req.getSession().getId());
			
			if(((User)req.getSession().getAttribute("userObj")).getSessionid().equals(req.getSession().getId())) {
				ModelAndView MAV = new ModelAndView();
				MAV.setViewName("EntryPage");
				String s =res.encodeURL("SessionID");
				System.out.println("this is encoded url"+s);
				req.setAttribute("eURL", s);
				return MAV;
			}
			else {
				ModelAndView MAV = new ModelAndView();
				User u=new User();
				MAV.addObject("userObj", u);
				String encodedUrl=res.encodeURL("LoginPage");
				
				MAV.setViewName("LoginPage");
				return MAV;
			}
			
			
			
		}else {
			System.out.println("user is not there");
			User u=new User();
			ModelAndView MAV = new ModelAndView();
			MAV.addObject("userObj", u);
			//Incode Url With Action
			String eStr =res.encodeURL("Login");
			System.out.println("this is encoded url"+eStr);
			MAV.addObject("LoginAction",eStr);
			MAV.setViewName("LoginPage.jsp");
			return MAV;
		}
		
	}
	
	
	
	@RequestMapping(method=RequestMethod.POST,value="/Login")
	public ModelAndView doLogin(@Valid @ModelAttribute("userObj") User user,BindingResult result,HttpServletRequest req,HttpServletResponse resp) {
		
		System.out.println("login button clicked and trying to login");
		ModelAndView mAndV=new ModelAndView();
		if(result.hasErrors()) {
			mAndV.setViewName("LoginPage.jsp");
			return mAndV;
		}
		
		
		else {
			
			String s= uServ.doLogin(user.getUserid(),user.getUserpass());
			if(s.equals("EntryPage")) {
				System.out.println(req.getSession().getId());
				req.getSession().setMaxInactiveInterval(20);
				user.setSessionid(req.getSession().getId());
				req.getSession().setAttribute("userObj", user);
				mAndV.addObject("userObj",user);
				if(req.getSession().getAttribute("Cart")==null) {
					Cart c=new Cart();
					req.getSession().setAttribute("Cart", c);
				}
			}
			String eStr =resp.encodeURL("ShowShop");
			System.out.println("this is encoded url"+eStr);
			mAndV.addObject("Shop1ButAction",eStr);
			mAndV.setViewName(s+".jsp");
			return mAndV;
		}
	}
	
	
	//------------------------------------------------ Show Shops -----------------------------------------------

	
	@RequestMapping(method=RequestMethod.GET,value="/ShowShop")
	public ModelAndView ShowNextShop(HttpServletRequest req,HttpServletResponse res) {
		System.out.println("ShowShop is Called");
		String nextShop=req.getParameter("NextShop");
		
		
		//
		ModelAndView mAndV=new ModelAndView();
		mAndV.addObject("Products",iRepo.findByShopid(nextShop));
		
		
		
		//adding cart url for shop 3
		System.out.println("----------------------- this are parameters of the request");
		String eStr =res.encodeURL("ShowCart");
		System.out.println("this is encoded cart url"+eStr);
		mAndV.addObject("ShopCart",eStr);
		String s1a=req.getParameter("NextShopAction");
		System.out.println("s1a val= "+s1a);
		System.out.println(req.getParameter("NextShopAction"));
		mAndV.addObject("ShowNextShop",s1a);
		mAndV.addObject("abc","abcVal");
		
		
		//-------------- add selected items to cart while going to next page
		Enumeration<String> e=req.getParameterNames();
		Cart c=(Cart)req.getSession().getAttribute("Cart");
		while(e.hasMoreElements()){
			System.out.println();
			String s=e.nextElement();
			System.out.println(s);
			Optional<Item> i=iRepo.findById(s);
			System.out.println(i);
			if(i.isPresent()) {
				c.addToCart(i.get(), Integer.parseInt(req.getParameter(s)));
			}else System.out.println("The item with this id is not there");
		}
		//---------------------------------------------------------------------------
		System.out.println();
		System.out.println();
		
		
		mAndV.setViewName(nextShop+".jsp");
		return mAndV;
	}
	
	
	@RequestMapping(method=RequestMethod.GET,value="/UpdateCart")
	public ModelAndView updateCart(HttpServletRequest req,HttpServletResponse res) {
		ModelAndView mAndV=new ModelAndView();
		//-------------- add selected items to cart while going to next page
		Enumeration<String> e=req.getParameterNames();
		Cart c=(Cart)req.getSession().getAttribute("Cart");
		
		c.getListOfItems().clear();
		c.setTotalPrice(0);
		while(e.hasMoreElements()){
			System.out.println();
			String s=e.nextElement();
			System.out.println(s);
			Optional<Item> i=iRepo.findById(s);
			System.out.println(i);
			if(i.isPresent()) {
				c.addToCart(i.get(), Integer.parseInt(req.getParameter(s)));
			}else System.out.println("The item with this id is not there");
		}
		req.getSession().setAttribute("Cart", c);
		mAndV.setViewName("cart.jsp");
		return mAndV;
	}
	
	
	
	
	
	
	
	
	
}
