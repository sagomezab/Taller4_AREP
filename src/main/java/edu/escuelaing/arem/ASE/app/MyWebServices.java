package edu.escuelaing.arem.ASE.app;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;

import edu.escuelaing.arem.ASE.app.example.Component;
import edu.escuelaing.arem.ASE.app.example.GetMapping;

public class MyWebServices {

    /**
     * http://localhost:4567/arep
     * @param args
     * @throws URISyntaxException 
     * @throws IOException 
     * @throws ClassNotFoundException 
     * @throws InvocationTargetException 
     * @throws IllegalArgumentException 
     * @throws IllegalAccessException 
     */
    public static void main( String[] args ) throws IOException, URISyntaxException, ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{

        HttpServer server = HttpServer.getInstance();

        server.staticFiles.location("/public");

        server.get("/hello", (req, res) -> "Hello World");

        server.get("/get-json", (req, res) -> {
            res.type("application/json");
            return "{\"name\": \"Santiago\"}";
        });

        server.get("/get-css", (req, res) -> {
            res.type("text/css");
            return "* {\n" +
                    "    font-family: sans-serif;\n" +
                    "    background-color: #f5f6fa;\n" +
                    "}";
        });

        server.post("/json-post", (req, res) -> {
            res.type("application/json");
            return "{\"name\": \"Santiago\"}";
        });



        server.run(args);

    }
}

