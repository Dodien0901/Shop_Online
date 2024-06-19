package phuocvu.org.btl_web_final.context;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//
//public class DBContext {
//    /*USE BELOW METHOD FOR YOUR DATABASE CONNECTION FOR BOTH SINGLE AND MULTILPE SQL SERVER INSTANCE(s)*/
//    /*DO NOT EDIT THE BELOW METHOD, YOU MUST USE ONLY THIS ONE FOR YOUR DATABASE CONNECTION*/
////    public Connection getConnection()throws Exception {
////        String url = "jdbc:sqlserver://"+serverName+":"+portNumber + "\\" + instance +";databaseName="+dbName;
////        if(instance == null || instance.trim().isEmpty())
////            url = "jdbc:sqlserver://"+serverName+":"+portNumber +";databaseName="+dbName;
////        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
////        return DriverManager.getConnection(url, userID, password);
////    }
//    public Connection getConnection() throws Exception {
//        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName + ";integratedSecurity=true;";
//        if (instance != null && !instance.trim().isEmpty()) {
//            url += "instanceName=" + instance + ";";
//        }
//        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        return DriverManager.getConnection(url);
//    }
//
//    /*Insert your other code right after this comment*/
//    /*Change/update information of your database connection, DO NOT change name of instance variables in this class*/
//    private final String serverName = "NVDO";
//    private final String dbName = "master";
//    private final String portNumber = "1433";
//    private final String instance="";//LEAVE THIS ONE EMPTY IF YOUR SQL IS A SINGLE INSTANCE
////    private final String userID = "sa";
////    private final String password = "phuoc1252002";

   import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

    public class DBContext {
        private final String serverName = "NVDO";
        private final String dbName = "Ecom_DB";
        private final String portNumber = "1433";
        private final String instance = ""; // LEAVE THIS ONE EMPTY IF YOUR SQL IS A SINGLE INSTANCE

        public Connection getConnection() throws Exception {
            System.out.println("check kn");
            String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName + ";integratedSecurity=true;";
            if (instance != null && !instance.trim().isEmpty()) {
                url += "instanceName=" + instance + ";";
            }
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(url);
        }

        public static void main(String[] args) {
            try {
                Connection conn = new DBContext().getConnection();
                if (conn != null) {
                    System.out.println("Kết nối đến cơ sở dữ liệu thành công!");
                } else {
                    System.out.println("Không thể kết nối đến cơ sở dữ liệu!");
                }
            } catch (Exception e) {
                e.printStackTrace(); // In ra lỗi chi tiết
            }
        }
    }


