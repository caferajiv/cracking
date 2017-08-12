package spring.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.Performer;

public class ComponentTest {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring/spring.xml");
		((Performer)ctx.getBean("juggler")).perform();
		
	}

}
