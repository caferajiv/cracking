package spring.impl;

import org.springframework.stereotype.Component;

import spring.Poem;
@Component
public class Sonnet implements Poem{
	
	private String linesOfPoem="Poem Sonnet!!";
	
	public Sonnet()
	{
		
	}

	@Override
	public void recite() {
		System.out.print(linesOfPoem);
		
	}

}
