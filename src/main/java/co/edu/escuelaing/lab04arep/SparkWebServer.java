/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package co.edu.escuelaing.lab04arep;

import spark.Request;
import spark.Response;
import static spark.Spark.*;

/**
 *
 * @author jaime.cacuna
 */
public class SparkWebServer {

    private static MongoDBConnection mongoDb = new MongoDBConnection();

    public static void main(String[] args) {
        port(getPort());
        get("/mensajes", (req, res) -> traerInfoColeccion(req, res));

    }

    private static String traerInfoColeccion(Request req, Response res) {
        String pageContent
                = "<!DOCTYPE html>"
                + "<html>"
                + "<body>"
                + "<h2>MongoDB</h2>"
                + "<br>"
                + "<h4>La info de la base de datos es: </h4>"
                + "<br>"
                + "<br>"
                + getMessages()
                + "</body>"
                + "</html>";
        return pageContent;
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

    private static String insertMessage() {
        return "hola";
    }

    private static String getMessages() {
        String content = mongoDb.getInfoDB();
        return content;
    }

}