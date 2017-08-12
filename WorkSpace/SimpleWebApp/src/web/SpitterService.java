package web;

import org.springframework.stereotype.Controller;

@Controller("spitterService")
public interface SpitterService {
	
	String getRecentSpittles(int num);

}
