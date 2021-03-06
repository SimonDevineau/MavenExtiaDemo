package com.simondevineau.extia.maven.demo;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BaseController {

	/**
	 * This a counter
	 */
	private static int counter = 0;
	private static final String VIEW_INDEX = "index";
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(BaseController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(ModelMap model) {
		System.out.println("Je ne devrais pas faire ca.");
		model.addAttribute("message", "Welcome");
		model.addAttribute("counter", --counter);
		logger.debug("[welcome] counter : {}", counter);
		try {
			throw new NullPointerException();
		} catch (Exception e) {
			logger.error("Je devrais reforward l'exception");
		}
		// Spring uses InternalResourceViewResolver and return back index.jsp
		return VIEW_INDEX;

	}

	/**
	 * 
	 * @param name,
	 *            the name of the person to welcomed
	 * @param model,
	 *            the type oh the HTTP request
	 * @return the InternalResourceViewResolver used by spring
	 */
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public String welcomeName(@PathVariable String name, ModelMap model) {
		model.addAttribute("message", "Welcome " + name);
		model.addAttribute("counter", --counter);
		logger.debug("[welcomeName] counter : {}", counter);
		return VIEW_INDEX;

	}

}