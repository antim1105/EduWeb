package com.example.demo.controller;

import java.io.File;
import java.security.Principal;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Repository.CoursesRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.entity.Courses;
import com.example.demo.entity.User;
import com.example.demo.healper.FileUploadHelper;
import com.example.demo.healper.Massage;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestBody;




@Controller
@RequestMapping("/user")
public class UserController {

	// User Repository 
	// lose   
	@Autowired
	private UserRepository userRepository;
	
	// Courses Repository 
	@Autowired
	private CoursesRepository coursesRepository;
	@Autowired
	private FileUploadHelper fileUploadHelper;
	
	// Add universal Data for all
	@ModelAttribute
	public void addcommonData(Model model, Principal principal) {

		String name = principal.getName();
		System.out.println(name);
		User user = userRepository.getUserByUserName(name);
		System.out.println(user);
		model.addAttribute("user", user);
	}
	
	
	// home page 
	@GetMapping("/index")
	
	public String userHomePage(Model model)
	{
		model.addAttribute("title", "user ");

	      List<Courses> c=coursesRepository.findAll();
	       model.addAttribute("courses",c);
		return "normal/home";
	}
	
	
	// Add Courses
	@GetMapping("/addCourses")
	public String  addCourses(Model model)
	{
		model.addAttribute("title","AddCourses");
		return "normal/addCourses";
	}
	
	// save saveCourses
//	 saveCourses
	@PostMapping("/saveCourses")
	public String saveCourses(@ModelAttribute("courses") Courses courses,  Model model,HttpSession session,  @RequestParam("proimage") MultipartFile file)
	{
		try { 
	        String s=courses.getDate();
	        
	          
			if (file.isEmpty()) {
				throw new Exception("Image Not foud error");
			}
			else {
                 courses.setImg(file.getOriginalFilename());
				boolean f=fileUploadHelper.uploadFile(file);
			System.out.println(f);
			}
			
			Courses c= coursesRepository.save(courses);
			session.setAttribute("massage", new Massage("Course Save ", "success"));
	         
		} catch (Exception e) {
			session.setAttribute("massage" ,new Massage("Something want wrong ", "danger"));
			return "normal/addCourses";
		}
		return "normal/addCourses";
		
	}
	
	
	// User Profile 
	@GetMapping("/profile")
	public String userProfile(Model model)
	{
		model.addAttribute("title","Your Profile");
		return "normal/profile";
	}
	
	
	// Update User Profile 
	@GetMapping("/updateUser")
	public String  updateUser(@ModelAttribute("user") User user,Model model,Principal principal,HttpSession session)
	{
		model.addAttribute("title","Update User ");
		model.addAttribute("user",user);
		
		session.setAttribute("massage", new Massage("ok", "sussess"));
		return "normal/updateuser";
		
	}
	
	//	// Update User Profile  process-update}	
	@PostMapping("/process-update")
	public String postMethodName(@ModelAttribute("user") User user, @RequestParam("proimage") MultipartFile file,HttpSession session,Model model)
	{
		
		
		try {
			Optional<User> oldUser =userRepository.findById(user.getId());
		    if (!file.isEmpty()) {
				
		    	// rewrite
				// delete old photo
				File delete = new ClassPathResource("static/img").getFile();
				File file1 = new File(delete, oldUser.get().getImage());
				file1.delete();

				// update new image
				user.setImage(file.getOriginalFilename());
				boolean f = fileUploadHelper.uploadFile(file);

			}  	
		    else {
		    	// old image 
		    			user.setImage(oldUser.get().getImage());
		    }
		    
		    
   this.userRepository.save(user);
   
			session.setAttribute("massage", new Massage("ok", "sussess"));	model.addAttribute("user",user);
			return "normal/home";
		     
		} catch (Exception e) {
			session.setAttribute("massage", new Massage("Your contact is Updated ....", "danger"));
			model.addAttribute("user",user);
		
		return "normal/home";
		}
	}
	
	
	// Buy -courses
	@GetMapping("/buy-courses")
	public String buyCourses(@ModelAttribute("user") User user, Model model,HttpSession session,Principal principal)
	{

	    System.out.println(principal.getName());	
		model.addAttribute("title","Buy Courses");
		List<Courses> c=coursesRepository.findAll();
		
		model.addAttribute("courses", c);
		session.setAttribute("massage",new Massage());
		
		return "normal/buyCourses";
	}

	  // Bay - courses Process
	@GetMapping("{cid}/buyCourses")
	public String buyCourses(@ModelAttribute("user") User user,@PathVariable("cid") int cid,Model model,HttpSession session,Principal principal)
	{
		System.out.println(principal.getName());
//	     User u
		Optional<Courses> courses =coursesRepository.findById(cid);
		System.out.println("User "+courses.get().getCname());
		
		
//		user.setContects()
user.getCourses2().add(courses.get());
    User result= this.userRepository.save(user);
    
		System.out.println(result);
		session.setAttribute("massage",new Massage("You buy Course Susses fuly Completed","sussess"));
List<Courses> c=coursesRepository.findAll();
		
		model.addAttribute("courses", c);
		
		return "normal/buyCourses";
	}
	
	
	// My Learning 
	
	@GetMapping("/myLearning")
	public String myLearning(@ModelAttribute("user") User user, Model model,HttpSession httpSession,Principal principal) {
		List<Courses> c =user.getCourses2();
		model.addAttribute("courses", c);
		
		return "normal/mylearning";
	}

}
