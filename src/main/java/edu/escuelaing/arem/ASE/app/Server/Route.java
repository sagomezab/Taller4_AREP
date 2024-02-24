package edu.escuelaing.arem.ASE.app.Server;

public interface Route {
    public String handle(String req, HttpResponse res);
}
