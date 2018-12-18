package org.example.alert.impl;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.example.alert.api.Alert;

import static com.mongodb.client.model.Filters.eq;

public class MongoDBAlertRepository implements AlertRepository
{
    MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://alert-user:praveen1234@ds047207.mlab.com:47207/alert-database"));
    MongoDatabase userDatabase = mongoClient.getDatabase("alert-database");
    MongoCollection<Document> collection = userDatabase.getCollection("alerts");
    MongoCollection<Document> collectionThreshold = userDatabase.getCollection("threshold");


    @Override
    public void storeAlert(Alert alert)
    {
        Document doc = new Document("sensorId", alert.getSensor().getSensorId())
                .append("timeStamp", alert.getSensor().getTimeStamp())
                .append("reading", alert.getSensor().getReading())
                .append("userId", alert.getUser().getId())
                .append("userName",alert.getUser().getName());

        collection.insertOne(doc);
    }

    @Override
    public void storeThreshold(String threshold)
    {
        Document doc = new Document("threshold", threshold);
        collectionThreshold.replaceOne(eq("_id", new ObjectId("5c171313e7179a2e2709c3b7")),doc);

    }

    @Override
    public double getThreshold()
    {

        Document doc = collectionThreshold.find(eq("_id", new ObjectId("5c171313e7179a2e2709c3b7"))).first();
        return Double.parseDouble((String) doc.get("threshold"));
    }
}
