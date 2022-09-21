package ar.edu.unlam.tallerweb1.delivery;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorRegistro {
    @RequestMapping(path = "/registro", method = RequestMethod.GET)
    ModelAndView irAlRegistro(){
        ModelMap modelo = new ModelMap();

        return new ModelAndView("registro", modelo);
    }
}
