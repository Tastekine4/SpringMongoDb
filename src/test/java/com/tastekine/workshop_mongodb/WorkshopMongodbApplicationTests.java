package com.tastekine.workshop_mongodb;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.bson.Document;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.MongoCollection;

@SpringBootTest
class WorkshopMongodbApplicationTests {

	@Test
	void testMongoConnection() {
		// Replace the placeholder with your MongoDB deployment's connection string
		String uri = "mongodb+srv://tastekine:12345@cluster0.ijueq.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";

		try (MongoClient mongoClient = MongoClients.create(uri)) {
			MongoDatabase database = mongoClient.getDatabase("tastekine");
			MongoCollection<Document> collection = database.getCollection("JobPost");
			Document doc = collection.find(eq("profile", "java developer")).first();
			if (doc != null) {
				System.out.println(doc.toJson());
			} else {
				System.out.println("No matching documents found.");
			}
		}
	}

}
