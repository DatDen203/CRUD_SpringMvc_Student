package Test.ConnetcMysql.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		return new ModelAndView("home");
	}
	
	@RequestMapping(value="/method7/{id}")
	@ResponseBody
	public ModelAndView method7(@PathVariable("id") String id){
		return new ModelAndView("reqStudent");
	}

	@RequestMapping(value="/update")
	@ResponseBody
	public ModelAndView method9(@RequestParam("id") int id){
		return new ModelAndView ("update");
	}
}
