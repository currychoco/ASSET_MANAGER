package site.currychoco.assetmanager.jdbcTest;

import org.assertj.core.api.Fail;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCTest {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testConnection() {

        try(Connection con =
                    DriverManager.getConnection(
                            "jdbc:mysql://database-1.ccnr5xsbemm5.ap-northeast-2.rds.amazonaws.com:3306/asset_manager?user=admin?serverTimezone",
                            "admin",
                            "tGTACmhj8b0ti")){
            System.out.println(con);
        } catch (Exception e) {
            System.out.println("e = " + e);
        }

    }
}
