package spring.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import spring.Performer;

@Component("juggler")
public class Juggler implements Performer {
	
	private int beanBags=3;
	private String name="Duke";
	public Juggler()
	{
		
	}
	
	public void initializeJuggler()
	{
		System.out.println("Juggler going to perform");
	}
	
	public void destroyJuggler()
	{
		System.out.println("Juggler going home");
	}
	
	public Juggler(int beanBags, String name)
	{
		this.beanBags=beanBags;
		this.name=name;
	}

	@Override
	public void perform() {
		System.out.print(name+" Juggling with "+beanBags+ " BeanBags");
		
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring/spring.xml");
				Performer performer = (Performer) ctx.getBean("duke");
				performer.perform();
				((Performer)ctx.getBean("blaze")).perform();
	}

}
