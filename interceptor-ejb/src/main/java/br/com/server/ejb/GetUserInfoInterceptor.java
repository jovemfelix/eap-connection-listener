package br.com.server.ejb;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import org.jboss.logging.Logger;
import org.wildfly.security.auth.server.SecurityDomain;

@Interceptor
public class GetUserInfoInterceptor {
    private static final Logger logger = Logger.getLogger(GetUserInfoInterceptor.class);

    @AroundInvoke
    public Object intercept(InvocationContext context) throws Exception {
//        context.getContextData().put("SESSION_USER", getUser(context));
        System.out.println("[intercept] >>>> context=" + context);
        System.out.println("[intercept] >>>> getUserId=" + getUserId());
        return context.proceed();
    }

    protected String getUserId() {
        String userId = null;
        logger.info("[getUserId] SecurityDomain.getCurrent=" + SecurityDomain.getCurrent());
        System.out.println("[getUserId] SecurityDomain.getCurrent=" + SecurityDomain.getCurrent());
        if (SecurityDomain.getCurrent() != null) {
            logger.info("[getUserId] SecurityDomain.getCurrent().getCurrentSecurityIdentity=" + SecurityDomain.getCurrent().getCurrentSecurityIdentity());
            System.out.println("[getUserId] SecurityDomain.getCurrent().getCurrentSecurityIdentity=" + SecurityDomain.getCurrent().getCurrentSecurityIdentity());
            if (SecurityDomain.getCurrent().getCurrentSecurityIdentity() != null) {
                logger.info("[getUserId] SecurityDomain.getCurrent().getCurrentSecurityIdentity().getPrincipal=" + SecurityDomain.getCurrent().getCurrentSecurityIdentity().getPrincipal());
                System.out.println("[getUserId] SecurityDomain.getCurrent().getCurrentSecurityIdentity().getPrincipal=" + SecurityDomain.getCurrent().getCurrentSecurityIdentity().getPrincipal());
                if (SecurityDomain.getCurrent().getCurrentSecurityIdentity().getPrincipal() != null) {
                    userId = SecurityDomain.getCurrent().getCurrentSecurityIdentity().getPrincipal().getName();
                }
            }
        }

        return userId;
    }
}
