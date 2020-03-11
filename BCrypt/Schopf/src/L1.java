

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

/**
 * Application Lifecycle Listener implementation class L1
 *
 */
@WebListener
public class L1 implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public L1() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    
    public void contextInitialized(ServletContextEvent sce){

        database d = database.getInstance();
        
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
	        DataSource dataSource = (DataSource) envContext.lookup("jdbc/web");
	        d.init(dataSource);
		} catch (NamingException e) {
			e.printStackTrace();
		}
        
        
    }
	
}
