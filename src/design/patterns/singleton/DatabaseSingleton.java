package design.patterns.singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseSingleton {
    private static DatabaseSingleton instance;
    private final String USER = "user1";
    private final String PASS = "password";
    private final String URL = "https://chatgpt.com/c/6743554c-420c-8006-a9d1-68b3e5827990";

    private Connection connection;
    private DatabaseSingleton(){
        try {
            connection = DriverManager.getConnection(URL, USER, PASS );
            System.out.println(" connection established");
        } catch (SQLException e) {
            System.out.println(" connection could not be established");
            throw new RuntimeException(e);
        }


    }

    public static DatabaseSingleton getInstance(){
        if(instance == null){
            synchronized (DatabaseSingleton.class){
                if(instance == null){
                    instance = new DatabaseSingleton();
                }
            }
        }

        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
