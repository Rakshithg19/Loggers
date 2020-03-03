package com.raksh.log.Controller;


import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class Log4jDemoController {
	private static Logger  logger = Logger.getLogger(Log4jDemoController.class);
	
	public Log4jDemoController() {
		logger.info("info message --> inside getMessage()...");
}
@PostMapping("/message.do")
public String getMessage() {
	logger.info("info messsage --> inside getMessage()...");
	
	logger.trace("trace message --> inside getMessage()...");
	logger.debug("debug message --> inside getMessage()...");
	logger.warn("warn message --> inside getMessage()...");
	logger.fatal("fatal message --> inside getMessage()...");
	try {
		Integer.parseInt("234asdf435");
		
	}
	catch(NumberFormatException e) {
		logger.error("-- Exception occured--", e);
	}
	System.out.println("inside getMessage()...");
	return "/Message.jsp";
}
}