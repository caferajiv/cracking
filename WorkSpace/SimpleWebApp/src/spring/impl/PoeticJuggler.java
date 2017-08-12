package spring.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import spring.Performer;
import spring.Poem;


public class PoeticJuggler extends Juggler {
	
	
	private Poem poem;
	
	public PoeticJuggler(Poem poem)
	{
		this.poem=poem;
	}
	
	public PoeticJuggler( int bean, String name, Poem poem)
	{
		super(bean,name);
		this.poem=poem;
	}

	@Override
	public void perform() {
		super.perform();
		System.out.print(" while reciting..");
		poem.recite();
		
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring/spring.xml");
				Performer performer = (Performer) ctx.getBean("blaze");
				performer.perform();
				System.out.println("\n");
				((Performer)ctx.getBean("poetic")).perform();
				System.out.println();
				((Performer)ctx.getBean("autopoetic")).perform();
	}

}
