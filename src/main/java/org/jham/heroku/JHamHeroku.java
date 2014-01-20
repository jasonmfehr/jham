package org.jham.heroku;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JHamHeroku extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String ENVIRONMENT_VAR = "PORT";
	private static final String DEFAULT_PORT = "8080";
	
	private static final Logger logger = LoggerFactory.getLogger(JHamHeroku.class);

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().print("Hello Heroku World!\n");
    }

    public static void main(String[] args) throws Exception {
        final Server server;
        final WebAppContext context;
        String webPort;
        
        logger.debug("looking up server port from environment variable {}", ENVIRONMENT_VAR);
        webPort = System.getenv(ENVIRONMENT_VAR);
        if (webPort == null || webPort.isEmpty()) {
        	logger.debug("{} environment variable not found, using default of {}", ENVIRONMENT_VAR, DEFAULT_PORT);
            webPort = DEFAULT_PORT;
        }
        
        logger.info("Starting Jetty server on port {}", webPort);
        server = new Server(Integer.valueOf(webPort));
        context = new WebAppContext();
        
        //TODO context root of jham in non-jetty containers
        //TODO put config in a jetty xml config file
        context.setContextPath("/jham");
        context.setParentLoaderPriority(false);
        context.setResourceBase("src/main/webapp");
        context.setDescriptor("src/main/webapp/WEB-INF/web.xml");
        server.setHandler(context);
        server.start();
        server.join();
    }

}
