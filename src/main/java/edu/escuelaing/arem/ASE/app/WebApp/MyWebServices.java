package edu.escuelaing.arem.ASE.app.WebApp;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;


import edu.escuelaing.arem.ASE.app.Annotacion.Component;
import edu.escuelaing.arem.ASE.app.Server.HttpServer;

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



        server.run(getComponent());

    }

    public static List<String> getComponent() throws IOException, ClassNotFoundException {
        String route = "edu/eci/arem/ASE/app/WebApp";
        List<String> componentClasses = new ArrayList<>();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Enumeration<java.net.URL> resources = classLoader.getResources(route);
        while (resources.hasMoreElements()){
            java.net.URL resouce = resources.nextElement();
            File directory = new File(resouce.getFile());
            File[] files = directory.listFiles();
            for (File file : files){
                String fileName = file.getName();
                if (file.getName().endsWith(".class")){
                    String className = fileName.substring(0, fileName.length() - 6);
                    Class<?> clase = Class.forName(route.replace("/", ".") + "." + className);
                    if (clase.isAnnotationPresent(Component.class)){
                        componentClasses.add(clase.getName());
                    }
                }
            }
        }
        return componentClasses;
    }
}

