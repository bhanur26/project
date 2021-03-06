package com.pack;



import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pack.form.Admin;
import com.pack.form.Center;
import com.pack.form.Status;
import com.pack.form.Type;
import com.pack.form.User;
import com.pack.service.UserService;
@Controller
public class UserController {
	private static final Logger log=Logger.getLogger(UserController.class);	
	private UserService userService;
	
	@Autowired(required=true)
	@Qualifier(value="userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value="/redir")
	public String viewForm1()
	{
return "firstpage";
}
	@RequestMapping(value="/use")
	public String viewForm(Map<String,Object> map)
	{
	
		map.put("user", new User());
		return "userRegistration";
}
	@RequestMapping(value="/ad")
	public String viewForm2(Map<String,Object> map)
	{
		
		map.put("admin", new Admin());
		return "adminRegistration";
}

	@RequestMapping(value="/user/add" ,method=RequestMethod.POST)
	public String addUser (@ModelAttribute("user") @Validated User user,BindingResult bindingResult,Model model,HttpServletRequest request,HttpServletResponse response)
	{
		if(bindingResult.hasErrors()) {
			log.info("validation error");
		
			return "userRegistration";
		}
		else
				{
			log.info("add user");
		
			System.out.println(user.getUserId());
			userService.addUser(user);
			
			}
			
		return "redirect:/redir";
	}
	@RequestMapping(value="/admin/add1" ,method=RequestMethod.POST)
	public String addAdmin (@ModelAttribute("admin") @Validated Admin admin,BindingResult bindingResult,Model model)
	{
		if(bindingResult.hasErrors()) {
			log.info("validation error");
		
			return "adminRegistration";
		}
		else
				{
			log.info("add admin");
			userService.addAdmin(admin);
			
			}
			
		return "redirect:/redir";
	}
	@RequestMapping(value="/validate")
	public String validateUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        
        System.out.println("welcome");
       String userId=request.getParameter("userId");
        String password=request.getParameter("password");
        User u=new User(userId,password);
        System.out.println(u.getUserId()+""+u.getPassword());
       int i= userService.validateUser(u);
       if(i!=0) {
    		HttpSession session=request.getSession();
    		session.setAttribute("userId", userId);
			System.out.println(userId);
    		return "req";
    	     	  
    		}
    	   
   		
       
       else
       {
    	   JOptionPane.showMessageDialog(null, "Please enter valid details");
	return "userlogin";
	}
	
}
	@RequestMapping(value="/validate1")
	public String validateAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        
        System.out.println("welcome");
       String adminId=request.getParameter("adminId");
        String password=request.getParameter("password");
        Admin a=new Admin(adminId,password);
        System.out.println(a.getAdminId()+""+a.getPassword());
       int i= userService.validateAdmin(a);
       if(i!=0) {
    	   HttpSession session=request.getSession();
   		session.setAttribute("adminId", adminId);
			System.out.println(adminId);
    	          return "adsuccess";
    		}
    	  
       
       else
       {
    	   JOptionPane.showMessageDialog(null, "Please enter valid details");
    	   
	      return "adminlogin";
	}
}
	@RequestMapping(value="/add" ,method=RequestMethod.POST)
	public String addService (@ModelAttribute("ser") @Validated Center ser,BindingResult bindingResult,Model model,HttpServletRequest request) throws Exception
	{
		if(bindingResult.hasErrors()) {
			log.info("validation error");
		
			return "userRegistration";
		}
		else
				{
			if(null==ser.getServiceId())
			{
		System.out.println("hiiiiiiiii");
		String dat=request.getParameter("trip-start");
		SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
		ser.setAvailability(sd.parse(dat));
		System.out.println(ser.getAvailability());
			Random r=new Random();
			int n=r.nextInt(90000)+100000;
			ser.setServiceId(n);
			System.out.println(ser.getServiceId());
			log.info("add service");
			userService.addService(ser);
			
			}
			else {
				
			}
			
		return "redirect:/redir";
	}
	
}

	@RequestMapping(value="/details")
	public String listService(Map<String,Object> map)
	{
		map.put("ser", new Center());
		map.put("serList",userService.listService());
		log.info("Inside list service");
		return "request";
	}

	@RequestMapping("/type")
	   public String addRequestv(@ModelAttribute("ty") @Validated Type ty,Model model,HttpServletRequest req) 
		{
			   String type[]=req.getParameterValues("type");
			   int tcost=0;
			   for(int i=0;i<type.length;i++) {
				   tcost+=Integer.parseInt(type[i]);
			   }
			   int sid=Integer.parseInt(req.getParameter("sid"));
			   System.out.println(tcost+" "+sid);
			    Random r=new Random();
				int n=r.nextInt(90000)+100000;
				ty.setRequestId(n);
				log.info("add type cost");
				userService.addRequest1(ty);
				
			return "request";
		}

	
	@RequestMapping(value="/status/{serviceId}",method=RequestMethod.GET  )
	public void requestGeneration(@PathVariable("serviceId") Integer serviceId,HttpServletRequest request,HttpServletResponse response)
	
	{
		System.out.println("in");
		Status s=new Status();
	   
		s.setServiceId(serviceId);
		 Random r=new Random();
			int n=r.nextInt(90000)+100000;
			
			s.setRequestId(n);
			s.setStatus("requested");
			
		log.info("uegwf");
	    userService.addRequest(s);
	}
	
	@RequestMapping(value="/viewRequests")
	public String viewRequest(Map<String,Object> map)
	{
		map.put("sta", new Status());
		map.put("serList",userService.listRequest());
		log.info("Inside list service");
		return "adminrequests";
	}
	
	@RequestMapping(value="/accept/{requestId}")
	public String acceptRequest(@PathVariable ("requestId") Integer requestId)
	{
		int reqId=requestId;
		userService.acceptRequest(reqId);
		
		return "redirect:/viewRequests";
	}
	@RequestMapping(value="/adminlogin")
	public String login()
	{
		return "adminlogin";
	}
	@RequestMapping(value="/userlogin")
	public String login1()
	{
		return "userlogin";
	}
	@RequestMapping(value="/status")
	public String viewStatus(Map<String,Object> map)
	{
		map.put("sta", new Status());
		map.put("ser1List",userService.listStatus());
		return "status";
	}
	@RequestMapping(value="/reject/{requestId}")
	public String rejectRequest(@PathVariable ("requestId") Integer requestId)
	{
		int reqId=requestId;
		userService.rejectRequest(reqId);
		
		return "redirect:/viewRequests";
	}

	@RequestMapping(value="/adhead" ,method=RequestMethod.GET)
	public String viewHead() {
		return "adsuccess";
	}
}
