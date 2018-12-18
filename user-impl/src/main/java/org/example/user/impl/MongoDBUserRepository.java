package org.example.user.impl;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.example.user.api.User;

import static com.mongodb.client.model.Filters.eq;


public class MongoDBUserRepository implements UserRepository
{


    MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://db_user:praveen1234@ds053459.mlab.com:53459/user-database"));
    MongoDatabase userDatabase = mongoClient.getDatabase("user-database");
    MongoCollection<Document> collection = userDatabase.getCollection("user");

    @Override
    public User getUserById(String id)
    {
        Document result = collection.find(eq("userId", id)).first();
        User user = new User((String) result.get("userId"),(String)result.get("sensorId"),(String)result.get("name"),(String)result.get("tel"),(String)result.get("email"),(String)result.get("preferredAlertMethod"));
        return user;
    }

    @Override
    public void addUser(User user)
    {
        Document doc = new Document("userId", user.getId())
                .append("sensorId", user.getSensorId())
                .append("name", user.getName())
                .append("email", user.getEmail())
                .append("phone", user.getTel())
                .append("preferredAlertMethod",user.getPreferredAlertMethod());

        collection.insertOne(doc);
    }

    @Override
    public User getUserBySensorId(String sensorId)
    {
        Document result = collection.find(eq("sensorId", sensorId)).first();
        User user = new User((String) result.get("userId"),(String)result.get("sensorId"),(String)result.get("name"),(String)result.get("tel"),(String)result.get("email"),(String)result.get("preferredAlertMethod"));
        return user;

    }

    @Override
    public void removeUser(String id)
    {
        collection.deleteOne(eq("userId", id));
    }
}
