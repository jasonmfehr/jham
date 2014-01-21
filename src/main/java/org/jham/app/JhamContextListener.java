package org.jham.app;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.jham.encrypt.EncryptionHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@WebListener
public class JhamContextListener implements ServletContextListener {

	private static final Logger logger = LoggerFactory.getLogger(JhamContextListener.class);
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		logger.info("JhamContextListener initialized");
		
		sce.getServletContext().setAttribute("encryptionHelper", new EncryptionHelper());
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		logger.info("JhamContextListener destroyed");
	}

}
