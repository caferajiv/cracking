package patterns.creational.factorymethod;

import java.sql.*;

public class TestClientFactoryUsage {
static Connection con;
static Statement stmt;
public static void main(String[] args) {
try {
Class.forName("oracle.jdbc.driver.OracleDriver");
con = DriverManager.getConnection("myServer", "user",
"password");
stmt = con.createStatement();
} catch(Exception e) {}
}
}
