package edu.escuelaing.arem.ASE.app.example;

@Component
public class HelloController {
    
    @GetMapping("/testing")
    public static String index(){
        return "Greetings from Spring Boot!";
    }

}
