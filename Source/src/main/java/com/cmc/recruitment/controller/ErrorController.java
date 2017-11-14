package com.cmc.recruitment.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorController {

	@RequestMapping(value = "error", method = RequestMethod.GET)
	public ModelAndView renderErrorPage(HttpServletRequest httpRequest) {
		return new ModelAndView("error").addObject("errorMsg", getErrorMessage(getErrorCode(httpRequest)));
	}

	private int getErrorCode(HttpServletRequest httpRequest) {
		return (Integer) httpRequest.getAttribute("javax.servlet.error.status_code");
	}

	private String getErrorMessage(int errorCode) {
		String errorMsg = "";
		switch (errorCode) {
		case 400:
			errorMsg = "Http Error Code: 400. Bad Request";
			break;
		case 401:
			errorMsg = "Http Error Code: 401. Unauthorized";
			break;
		case 404:
			errorMsg = "Http Error Code: 404. Resource not found";
			break;
		case 500:
			errorMsg = "Http Error Code: 500. Internal Server Error";
			break;
		}
		return errorMsg;
	}
}