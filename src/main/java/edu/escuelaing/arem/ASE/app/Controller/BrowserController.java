package edu.escuelaing.arem.ASE.app.Controller;

import edu.escuelaing.arem.ASE.app.Annotacion.Controller;
import edu.escuelaing.arem.ASE.app.Annotacion.RequestMapping;

@Controller
public class BrowserController {
    /**
     * Carga un mensaje precargado
     * @return Retorna el header y el body del mensaje
     */
    @RequestMapping("/hello")
    public static String hello(){
        return "HTTP/1.1 200 \r\n" +
                "Content-Type:text/html\r\n" +
                "\r\n"+
                "Greetings from Spring Boot!";
    }
}
