# WIP

```shell
15:36:39,319 INFO  [org.jboss.weld.Version] (MSC service thread 1-8) WELD-000900: 3.0.6 (redhat)
15:36:40,008 INFO  [org.jboss.as.jpa] (ServerService Thread Pool -- 72) WFLYJPA0010: Iniciando unidade de persist▒ncia (fase 2 de 2) Servi▒o'my-ear-1.3.2-EAP7.ear/com.example-my-ejb-1.3.2-EAP7.jar#test'
15:36:40,508 ERROR [org.jboss.msc.service.fail] (ServerService Thread Pool -- 72) MSC000001: Failed to start service jboss.persistenceunit."my-ear-1.3.2-EAP7.ear/com.example-my-ejb-1.3.2-EAP7.jar#test": org.jboss.msc.service.StartException in service jboss.persistenceunit."my-ear-1.3.2-EAP7.ear/com.example-my-ejb-1.3.2-EAP7.jar#test": java.lang.NoClassDefFoundError: Could not initialize class com.datasource.connection.listener.ClientIdentifierConnectionPreparer
        at org.jboss.as.jpa.service.PersistenceUnitServiceImpl$1$1.run(PersistenceUnitServiceImpl.java:195)
        at org.jboss.as.jpa.service.PersistenceUnitServiceImpl$1$1.run(PersistenceUnitServiceImpl.java:125)
        at org.wildfly.security.manager.WildFlySecurityManager.doChecked(WildFlySecurityManager.java:662)
        at org.jboss.as.jpa.service.PersistenceUnitServiceImpl$1.run(PersistenceUnitServiceImpl.java:209)
        at org.jboss.threads.ContextClassLoaderSavingRunnable.run(ContextClassLoaderSavingRunnable.java:35)
        at org.jboss.threads.EnhancedQueueExecutor.safeRun(EnhancedQueueExecutor.java:1982)
        at org.jboss.threads.EnhancedQueueExecutor$ThreadBody.doRunTask(EnhancedQueueExecutor.java:1486)
        at org.jboss.threads.EnhancedQueueExecutor$ThreadBody.run(EnhancedQueueExecutor.java:1377)
        at java.lang.Thread.run(Thread.java:748)
        at org.jboss.threads.JBossThread.run(JBossThread.java:485)
Caused by: java.lang.NoClassDefFoundError: Could not initialize class com.datasource.connection.listener.ClientIdentifierConnectionPreparer
        at java.lang.Class.forName0(Native Method)
        at java.lang.Class.forName(Class.java:348)
        at org.jboss.jca.adapters.jdbc.BaseWrapperManagedConnectionFactory.loadConnectionListenerPlugin(BaseWrapperManagedConnectionFactory.java:900)
        at org.jboss.jca.adapters.jdbc.BaseWrapperManagedConnectionFactory.getConnectionListenerPlugin(BaseWrapperManagedConnectionFactory.java:985)
        at org.jboss.jca.adapters.jdbc.BaseWrapperManagedConnection.returnHandle(BaseWrapperManagedConnection.java:567)
        at org.jboss.jca.adapters.jdbc.BaseWrapperManagedConnection.closeHandle(BaseWrapperManagedConnection.java:545)
        at org.jboss.jca.adapters.jdbc.BaseWrapperManagedConnection.cleanup(BaseWrapperManagedConnection.java:342)
        at org.jboss.jca.core.connectionmanager.pool.mcp.SemaphoreConcurrentLinkedDequeManagedConnectionPool.returnConnection(SemaphoreConcurrentLinkedDequeManagedConnectionPool.java:669)
        at org.jboss.jca.core.connectionmanager.pool.mcp.SemaphoreConcurrentLinkedDequeManagedConnectionPool.returnConnection(SemaphoreConcurrentLinkedDequeManagedConnectionPool.java:614)
        at org.jboss.jca.core.connectionmanager.pool.AbstractPool.returnConnection(AbstractPool.java:847)
        at org.jboss.jca.core.connectionmanager.AbstractConnectionManager.returnManagedConnection(AbstractConnectionManager.java:725)
        at org.jboss.jca.core.connectionmanager.AbstractConnectionManager.managedConnectionDisconnected(AbstractConnectionManager.java:1113)
        at org.jboss.jca.core.connectionmanager.AbstractConnectionManager.allocateConnection(AbstractConnectionManager.java:804)
        at org.jboss.jca.adapters.jdbc.WrapperDataSource.getConnection(WrapperDataSource.java:151)
        at org.jboss.as.connector.subsystems.datasources.WildFlyDataSource.getConnection(WildFlyDataSource.java:64)
        at org.hibernate.engine.jdbc.connections.internal.DatasourceConnectionProviderImpl.getConnection(DatasourceConnectionProviderImpl.java:122)
        at org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator$ConnectionProviderJdbcConnectionAccess.obtainConnection(JdbcEnvironmentInitiator.java:180)
        at org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator.initiateService(JdbcEnvironmentInitiator.java:68)
        at org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator.initiateService(JdbcEnvironmentInitiator.java:35)
        at org.hibernate.boot.registry.internal.StandardServiceRegistryImpl.initiateService(StandardServiceRegistryImpl.java:94)
        at org.hibernate.service.internal.AbstractServiceRegistryImpl.createService(AbstractServiceRegistryImpl.java:263)
        at org.hibernate.service.internal.AbstractServiceRegistryImpl.initializeService(AbstractServiceRegistryImpl.java:237)
        at org.hibernate.service.internal.AbstractServiceRegistryImpl.getService(AbstractServiceRegistryImpl.java:214)
        at org.hibernate.id.factory.internal.DefaultIdentifierGeneratorFactory.injectServices(DefaultIdentifierGeneratorFactory.java:152)
        at org.hibernate.service.internal.AbstractServiceRegistryImpl.injectDependencies(AbstractServiceRegistryImpl.java:286)
        at org.hibernate.service.internal.AbstractServiceRegistryImpl.initializeService(AbstractServiceRegistryImpl.java:243)
        at org.hibernate.service.internal.AbstractServiceRegistryImpl.getService(AbstractServiceRegistryImpl.java:214)
        at org.hibernate.boot.internal.InFlightMetadataCollectorImpl.<init>(InFlightMetadataCollectorImpl.java:179)
        at org.hibernate.boot.model.process.spi.MetadataBuildingProcess.complete(MetadataBuildingProcess.java:119)
        at org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl.metadata(EntityManagerFactoryBuilderImpl.java:1215)
        at org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl.build(EntityManagerFactoryBuilderImpl.java:1246)
        at org.jboss.as.jpa.hibernate5.TwoPhaseBootstrapImpl.build(TwoPhaseBootstrapImpl.java:44)
        at org.jboss.as.jpa.service.PersistenceUnitServiceImpl$1$1.run(PersistenceUnitServiceImpl.java:167)
        ... 9 more

15:36:40,523 ERROR [org.jboss.as.controller.management-operation] (DeploymentScanner-threads - 1) WFLYCTL0013: Falha na opera▒▒o ("deploy") - endere▒o ([("deployment" => "my-ear-1.3.2-EAP7.ear")]) - falha na descri▒▒o: {"WFLYCTL0080: Falha de servi▒os" => {"jboss.persistenceunit.\"my-ear-1.3.2-EAP7.ear/com.example-my-ejb-1.3.2-EAP7.jar#test\"" => "java.lang.NoClassDefFoundError: Could not initialize class com.datasource.connection.listener.ClientIdentifierConnectionPreparer
    Caused by: java.lang.NoClassDefFoundError: Could not initialize class com.datasource.connection.listener.ClientIdentifierConnectionPreparer"}}
15:36:40,746 INFO  [org.jboss.as.server] (DeploymentScanner-threads - 1) WFLYSRV0010: Implantado "my-ear-1.3.2-EAP7.ear" (runtime-name: "my-ear-1.3.2-EAP7.ear")
```



# References

* https://access.redhat.com/solutions/5749421
