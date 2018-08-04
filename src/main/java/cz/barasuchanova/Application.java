package cz.barasuchanova;

import cz.barasuchanova.persistence.DBUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Application implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        DBUtils.getInstance().startEntityManagerFactory();
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        DBUtils.getInstance().closeEntityManagerFactory();
    }

}
