package com.datasource.connection.listener;

import org.jboss.jca.adapters.jdbc.spi.listener.ConnectionListener;
import org.jboss.logging.Logger;
import org.wildfly.security.auth.server.SecurityDomain;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import java.security.Principal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

/*
<connection-listener class-name="com.datasource.connection.listener.ClientIdentifierConnectionPreparer"/>
 */
public class ClientIdentifierConnectionPreparer implements ConnectionListener {
    private static final Logger logger = Logger.getLogger(ClientIdentifierConnectionPreparer.class);


    private String prepSql = "{ call DBMS_SESSION.SET_IDENTIFIER(?) }";

    @Override
    public void initialize(ClassLoader classLoader) {
        logger.info("[initialize] classLoader=" + classLoader);
        logger.info("[initialize] principal=" + getUserId());
    }

    @Override
    public void activated(Connection connection) throws SQLException {
        logger.info("[activated] connection=" + connection);
        logger.info("[activated] principal=" + getUserId());
    }

    @Override
    public void passivated(Connection connection) throws SQLException {
        logger.info("[passivated] connection=" + connection);
        logger.info("[passivated] principal=" + getUserId());
    }

    protected Connection setClientIdentifier(Connection connection) throws SQLException {
        final String userId = getUserId();
        if (userId != null) {
            CallableStatement cs = connection.prepareCall(prepSql);
            cs.setString(1, userId);
            cs.execute();
            cs.close();
        }
        return connection;
    }

    protected String getUserId() {
        String userId = null;
        logger.info("[getUserId] SecurityDomain.getCurrent=" + SecurityDomain.getCurrent());
        if (SecurityDomain.getCurrent() != null) {
            logger.info("[getUserId] SecurityDomain.getCurrent().getCurrentSecurityIdentity=" + SecurityDomain.getCurrent().getCurrentSecurityIdentity());
            if (SecurityDomain.getCurrent().getCurrentSecurityIdentity() != null) {
                logger.info("[getUserId] SecurityDomain.getCurrent().getCurrentSecurityIdentity().getPrincipal=" + SecurityDomain.getCurrent().getCurrentSecurityIdentity().getPrincipal());
                if (SecurityDomain.getCurrent().getCurrentSecurityIdentity().getPrincipal() != null) {
                    userId = SecurityDomain.getCurrent().getCurrentSecurityIdentity().getPrincipal().getName();
                }
            }
        }

        return userId;
    }

}
