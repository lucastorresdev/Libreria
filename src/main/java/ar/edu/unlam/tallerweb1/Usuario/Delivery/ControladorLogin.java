package ar.edu.unlam.tallerweb1.Usuario.Delivery;

import ar.edu.unlam.tallerweb1.Usuario.Domain.Usuario;
import ar.edu.unlam.tallerweb1.Usuario.Domain.ServicioLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ControladorLogin {

	// La anotacion @Autowired indica a Spring que se debe utilizar el contructor como mecanismo de inyección de dependencias,
	// es decir, qeue lo parametros del mismo deben ser un bean de spring y el framewrok automaticamente pasa como parametro
	// el bean correspondiente, en este caso, un objeto de una clase que implemente la interface ServicioLogin,
	// dicha clase debe estar anotada como @Service o @Repository y debe estar en un paquete de los indicados en
	// applicationContext.xml
	private ServicioLogin servicioLogin;
	private HttpServletRequest request;

	@Autowired
	public ControladorLogin(ServicioLogin servicioLogin, HttpServletRequest request){
		this.servicioLogin = servicioLogin;
		this.request = request;
	}

//	 Este metodo escucha la URL localhost:8080/NOMBRE_APP/login si la misma es invocada por metodo http GET
	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public ModelAndView irALogin() {
		ModelMap modelo = new ModelMap();
		String vista;
		if(request.getSession().getAttribute("ROL") == null) {
			// Se agrega al modelo un objeto con key 'datosLogin' para que el mismo sea asociado
			// al model attribute del form que esta definido en la vista 'login'
			modelo.put("datosLogin", new DatosLogin());
			vista = "login";
		} else {
			vista = "redirect:/";
		}
		// Se va a la vista login (el nombre completo de la lista se resuelve utilizando el view resolver definido en el archivo spring-servlet.xml)
		// y se envian los datos a la misma  dentro del modelo
		return new ModelAndView(vista, modelo);
	}

	// Este metodo escucha la URL validar-login siempre y cuando se invoque con metodo http POST
	// El metodo recibe un objeto Usuario el que tiene los datos ingresados en el form correspondiente y se corresponde con el modelAttribute definido en el
	// tag form:form
	@RequestMapping(path = "/validar-login", method = RequestMethod.POST)
	public ModelAndView validarLogin(@ModelAttribute("datosLogin") DatosLogin datosLogin, HttpServletRequest request) {
		ModelMap model = new ModelMap();
		String vista;
		if(request.getSession().getAttribute("ROL") == null) {
			// invoca el metodo consultarUsuario del servicio y hace un redirect a la URL /home, esto es, en lugar de enviar a una vista
			// hace una llamada a otro action a traves de la URL correspondiente a esta
			Usuario usuarioBuscado = servicioLogin.consultarUsuario(datosLogin.getEmail(), datosLogin.getPassword());
			if (usuarioBuscado != null) {
				request.getSession().setAttribute("ROL", usuarioBuscado.getRol());
				request.getSession().setAttribute("USUARIO_ID", usuarioBuscado.getId());
				vista = "redirect:/";
			} else {
				// si el usuario no existe agrega un mensaje de error en el modelo.
				model.put("error", "Usuario o clave incorrecta");
				vista = "login";
			}
		} else {
			vista = "redirect:/";
		}
		return new ModelAndView(vista, model);
	}

	@RequestMapping(path = "/cerrar-sesion", method = RequestMethod.GET)
	public ModelAndView cerrarSesion() {
		ModelMap model = new ModelMap();
		if(request.getSession().getAttribute("ROL") != null)
			request.getSession().removeAttribute("ROL");
		return new ModelAndView("redirect:/", model);
	}
}
