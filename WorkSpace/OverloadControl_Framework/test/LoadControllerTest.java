import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rajiv.loadcontrol.LoadController;

import junit.framework.TestCase;


public class LoadControllerTest extends TestCase{
	
	@Before
	public void setUp()
	{
		
	}
	@After
	public void tearDown()
	{
		
	}
	@Test
	public void testGetInstance()
	{
		LoadController loadController1=LoadController.getInstance();
		LoadController loadController2=LoadController.getInstance();
		assertSame(loadController1, loadController2);
	}
	
	public void testGetInstanceMultithreading()
	{
		LoadController loadController1=LoadController.getInstance();
		LoadController loadController2=LoadController.getInstance();
		assertSame(loadController1, loadController2);
	}
	static class Worker implements Runnable
	{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
		}
}


