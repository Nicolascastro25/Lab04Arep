/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.escuelaing.lab04arep;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import java.util.Date;
import org.bson.Document;

/**
 *
 * @author jaime.cacuna
 */
public class MongoDBConnection {

    private MongoClient mongoClient;
    private MongoDatabase mongodb;
    private MongoClientURI uriMongo;

    public MongoDBConnection() {
        uriMongo = new MongoClientURI("mongodb+srv://jaimecacuna:<password>@cluster0.eju0yt7.mongodb.net/?retryWrites=true&w=majority");
        mongoClient = new MongoClient(uriMongo);
        mongodb = mongoClient.getDatabase("Cluster0");
    }

    public void insertInfoDB(String info) {
        if (mongodb.getCollection("mensajes") == null) {
            mongodb.createCollection("mensajes");
        }
        mongodb.createCollection("mensajes");
        Document document = new Document();
        document.append("Fecha", new Date().toString());
        document.append("Mensaje", info);
        mongodb.getCollection("mensajes").insertOne(document);
    }

}
