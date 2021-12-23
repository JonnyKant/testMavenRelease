import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.IndexOptions;
import com.mongodb.lang.NonNull;
import org.bson.BsonTimestamp;
import org.bson.Document;

import java.util.Date;
import java.util.Iterator;
import java.util.function.Consumer;

/**
 * todo Document type Main
 */

public class Main {
    public static void main(String[] args) {
        //        new Main1().start();
        try (var mongoClient = MongoClients.create()) {
            var database = mongoClient.getDatabase("test");
            mongoClient.listDatabaseNames()
                .forEach((Consumer<String>) System.out::println);
            database.listCollectionNames()
                .forEach((Consumer<String>) System.out::println);
            var todo = database.getCollection("todo");
            var doc= new Document();
            doc.put("name","Tom");
            doc.put("ts", new BsonTimestamp(new Date().getTime()));
            todo.insertOne(doc);
            todo.find().forEach((Consumer<Document>) System.out::println);
//            todo.listIndexes().forEach((Consumer<Document>) System.out::println);
        }
    }
}

class Main1 extends Thread{
    @Override
    public void run() {
        super.run();
        System.out.println("Hello world");
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @NonNull public void testnull(){}
}

