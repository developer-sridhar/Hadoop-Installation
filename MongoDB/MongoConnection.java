import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoConnection {

    public static void main(String[] args) {
        // MongoDB URI
        String uri = "mongodb+srv://username:password@cluster0.mvc5wum.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";

        // Connect to MongoDB
        try (MongoClient mongoClient = MongoClients.create(uri)) {

            // Get or create a database
            MongoDatabase database = mongoClient.getDatabase("myTestDB");

            System.out.println("✅ Connected to MongoDB successfully!");
            System.out.println("📁 Database: " + database.getName());
        } catch (Exception e) {
            System.err.println("❌ Connection failed: " + e.getMessage());
        }
    }
}
