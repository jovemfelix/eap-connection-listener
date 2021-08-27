package com.datasource.connection.listener;

import org.jboss.jca.adapters.jdbc.spi.listener.ConnectionListener;
import org.jboss.logging.Logger;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

/*
<connection-listener class-name="com.datasource.connection.listener.ClientIdentifierConnectionPreparer"/>
 */
public class ClientIdentifierConnectionPreparer implements ConnectionListener {
    private static final Logger logger = Logger.getLogger(ClientIdentifierConnectionPreparer.class);

    @Resource
    private SessionContext sessionContext;

    @Context
    private HttpServletRequest httpRequest;

    private String prepSql = "{ call DBMS_SESSION.SET_IDENTIFIER(?) }";

    @Override
    public void initialize(ClassLoader classLoader) {
        logger.info("[initialize] classLoader=" + classLoader);
        logger.info("[initialize] sessionContext=" + sessionContext);
        logger.info("[initialize] httpRequest=" + httpRequest);
    }

    @Override
    public void activated(Connection connection) throws SQLException {
        logger.info("[activated] connection=" + connection);
        logger.info("[activated] sessionContext=" + sessionContext);
        logger.info("[activated] httpRequest=" + httpRequest);
    }

    @Override
    public void passivated(Connection connection) throws SQLException {
        logger.info("[passivated] connection=" + connection);
        logger.info("[passivated] sessionContext=" + sessionContext);
        logger.info("[passivated] httpRequest=" + httpRequest);
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
        return null;
    }

}
