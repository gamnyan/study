package spring;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

@WebListener
public class ListenerExam implements ServletContextListener {
	public void contextInitialized(ServletContextEvent sce) {

		DateConverter dc = new DateConverter();
		dc.setPattern("yyyy-MM-dd");
		ConvertUtils.register(dc, java.util.Date.class);
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}

}
