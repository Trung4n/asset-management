package asset.project;

import java.sql.Connection;
import java.sql.DriverManager;

class TestDB {
    public static void run() {
        String url = "jdbc:postgresql://db.aqgqsthqwppfjjcwdnad.supabase.co:5432/postgres";
        String user = "postgres";
        String password = "Nhonhoi2962005";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            if (conn != null) {
                System.out.println("Connection Failed");
            }
        } catch (Exception e) {
            System.out.println("Connection Succesfull");
            e.printStackTrace();
        }
    }
}