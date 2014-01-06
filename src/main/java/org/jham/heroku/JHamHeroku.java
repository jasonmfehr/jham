package org.jham.heroku;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class JHamHeroku extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().print("Hello Heroku World!\n");
    }

    public static void main(String[] args) throws Exception {
        final Server server;
        final WebAppContext context;
        String webPort;
        
        webPort = System.getenv("PORT");
        if (webPort == null || webPort.isEmpty()) {
            webPort = "8080";
        }
        
        server = new Server(Integer.valueOf(webPort));
        context = new WebAppContext();
        
        context.setContextPath("/");
        context.setParentLoaderPriority(false);
        context.setResourceBase("src/main/webapp");
        context.setDescriptor("src/main/webapp/WEB-INF/web.xml");
        server.setHandler(context);
        server.start();
        server.join();
    }

}
