package kosta.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.mvc.model.domain.Electronics;
import kosta.mvc.model.service.ElectronicsService;

public class ReadElecController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String modelNum = request.getParameter("modelNum");
		if(modelNum==null || modelNum.equals("")) {
			throw new RuntimeException("입력값이 충분하지 않습니다.");
		}
		
		boolean flag = (request.getParameter("flag")==null) ? true : false;
		
		Electronics elec = ElectronicsService.selectByModelnum(modelNum, flag);
		request.setAttribute("elec", elec);
		ModelAndView mv = new ModelAndView(false, "elecView/read.jsp");
		return mv;
	}

}
