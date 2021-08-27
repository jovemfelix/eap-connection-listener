package br.com.server.ejb;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
public class GetUserInfoInterceptor {
    @AroundInvoke
    public Object intercept(InvocationContext context) throws Exception {
//        context.getContextData().put("SESSION_USER", getUser(context));
        System.out.println("[intercept] >>>> context=" + context);
        return context.proceed();
    }
}
