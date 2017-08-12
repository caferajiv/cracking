package struts;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;

public class HelloWorldAction {
	
	private String name;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String execute()
	{
		System.out.println("Inside Action...");
		ValueStack valueStack= ActionContext.getContext().getValueStack();
		Map<String, Object> context= new HashMap<String, Object>();
		context.put("key1", "This is key 1");
		context.put("key2", "This is key 2");
		valueStack.push(context);
		return "success";
	}

}
