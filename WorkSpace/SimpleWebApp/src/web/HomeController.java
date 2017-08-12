package web;



import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("homeController")
public class HomeController {
	public static final int DEFAULT_SPITTLES_PER_PAGE = 25;
	
	/*@Autowired
	private SpitterService spitterService; 
	*/
	
	//@Autowired
	public HomeController()
	{
		
	}
	/*@Autowired
	public HomeController(SpitterService spitterService)
	{
		this.spitterService=spitterService;
	}*/
	
	
	
	@RequestMapping({"/","/home"})
	public String showHomePage(Map<String, Object> model) {
	model.put("spittles", "hi");
	return "home";
	}

}
