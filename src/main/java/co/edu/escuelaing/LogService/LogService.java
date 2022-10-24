/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.escuelaing.LogService;

import co.edu.escuelaing.DBConnection.MongoDBConnection;
import static spark.Spark.*;
import java.util.List;
import spark.Request;
import spark.Response;

/**
 *
 * @author Jaime Castro
 */
public class LogService {

    private static MongoDBConnection mongoConnection = new MongoDBConnection();

    public static void main(String[] args) {
        staticFileLocation("/public");
        port(getPort());
        post("/insertar", (req, res) -> insertarMensaje(req, res));
        get("/obtener", (req, res) -> obtenerMensajes(req, res));

    }

    private static String obtenerMensajes(Request req, Response res) {
        String data = mongoConnection.getInfoDB();
        return data;
    }

    private static String insertarMensaje(Request req, Response res) {
        mongoConnection.insertInfoDB(req.body());
        String data = obtenerMensajes(req, res);
        return data;
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}
