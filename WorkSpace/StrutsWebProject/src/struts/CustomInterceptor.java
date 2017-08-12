package struts;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class CustomInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		System.out.println("pre-processing");
		String result=actionInvocation.invoke();
		System.out.println("post-processing");
		
		return result;
	}

}
