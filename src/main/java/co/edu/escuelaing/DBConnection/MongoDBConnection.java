/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.escuelaing.DBConnection;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.Date;
import org.bson.Document;

/**
 *
 * @author jaime.cacuna
 */
public class MongoDBConnection {

    private MongoDatabase mongodb;
    private MongoClient mongoClient;
    private String uriMongo;

    public MongoDBConnection() {        
        uriMongo = "mongodb://jaimecacuna:nicolasarep@ac-rasowq5-shard-00-00.k3zsmoc.mongodb.net:27017,ac-rasowq5-shard-00-01.k3zsmoc.mongodb.net:27017,ac-rasowq5-shard-00-02.k3zsmoc.mongodb.net:27017/?ssl=true&replicaSet=atlas-f3y7wy-shard-0&authSource=admin&retryWrites=true&w=majority";
        mongoClient = MongoClients.create(uriMongo);
        mongodb = mongoClient.getDatabase("cluster0");
    }

    public void insertInfoDB(String info) {
        if (mongodb.getCollection("mensajes") == null) {
            mongodb.createCollection("mensajes");
        }
        Document document = new Document();
        document.append("Fecha", new Date().toString());
        document.append("Mensaje", info);
        mongodb.getCollection("mensajes").insertOne(document);
    }

    public String getInfoDB() {
        MongoCollection<Document> collection = mongodb.getCollection("mensajes");
        String message = "";
        FindIterable<Document> iterable = collection.find();
        for (Document document : iterable) {
            message += document.toJson();
        }
        return message;
    }

}