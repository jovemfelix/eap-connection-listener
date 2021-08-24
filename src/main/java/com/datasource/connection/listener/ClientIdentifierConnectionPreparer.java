package com.datasource.connection.listener;

import org.jboss.jca.adapters.jdbc.spi.listener.ConnectionListener;
import org.jboss.logging.Logger;

//import javax.annotation.Resource;
//import javax.ejb.SessionContext;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
/*
<connection-listener class-name="com.datasource.connection.listener.ClientIdentifierConnectionPreparer"/>
 */
public class ClientIdentifierConnectionPreparer implements ConnectionListener {
    private static final Logger logger = Logger.getLogger(ClientIdentifierConnectionPreparer.class);

//    @Resource
//    private SessionContext sessionContext;

    private String prepSql = "{ call DBMS_SESSION.SET_IDENTIFIER(?) }";

    @Override
    public void initialize(ClassLoader classLoader) {
        logger.info("[initialize] INFO");
        logger.debug("[initialize] DEBUG");

        System.out.println("[initialize] classLoader=" + classLoader);
//        System.out.println("[initialize] sessionContext=" + sessionContext);
    }

    @Override
    public void activated(Connection connection) throws SQLException {
        System.out.println("[activated] connection=" + connection);
//        System.out.println("[activated] sessionContext=" + sessionContext);
    }

    @Override
    public void passivated(Connection connection) throws SQLException {
        System.out.println("[passivated] connection=" + connection);
//        System.out.println("[passivated] sessionContext=" + sessionContext);
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
