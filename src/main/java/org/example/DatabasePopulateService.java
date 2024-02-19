package org.example;

import org.example.db.Database;
import org.example.utils.SqlFileLoader;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePopulateService {
    public static void main(String[] args) throws SQLException {
        populateDatabase();
    }

    public static void populateDatabase() throws SQLException {
        System.out.println("H2 populate data...");
        Connection dbH2Conn = Database.getInstance().getConnection();
        Statement stm = dbH2Conn.createStatement();

        String sql = SqlFileLoader.loadSQL("sql/populate_db.sql");
        int count = stm.executeUpdate(sql);
        System.out.println("Inserted, count = " + count);
    }
}
