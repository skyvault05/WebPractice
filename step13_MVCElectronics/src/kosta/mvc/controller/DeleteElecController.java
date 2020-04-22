package kosta.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.mvc.model.service.ElectronicsService;

public class DeleteElecController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String modelNum = request.getParameter("modelNum");
		String password = request.getParameter("password");
		String path = request.getServletContext().getRealPath("/save");
		
				
		ElectronicsService.delete(modelNum, password, path);
		
		ModelAndView mv = new ModelAndView(true, "elec");
		
		return mv;
	}

}
