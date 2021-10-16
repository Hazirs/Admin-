package sample;

import java.sql.*;

public class Db {
    Connection c;
    String URL = "jdbc:mysql://localhost/asignmentdropbox1";
    String user = "root";
    String password = "";
    public void Db(){}
    public void connect(){
        String tab = "\t"+"\t";
        try {

            //Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = (Connection) DriverManager.getConnection(URL, user, password);
            System.out.println("Connection Succeeded");

        }
        catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
            System.out.println("Connection Failed");
        }
    }

    public ResultSet query(String q) throws SQLException {
        Statement stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery(""+q);
        return rs;
    }

    public void InsertSchool(String query) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        c = (Connection) DriverManager.getConnection(URL, user, password);
        Statement stmt = c.createStatement();
        stmt.executeUpdate(query);

//        try{
//            DBUtil.dbExecute
//        }
//        catch (Exception e){
//            e.printStackTrace();
//            System.out.println("Could not save the data");
//        }
    }


}
