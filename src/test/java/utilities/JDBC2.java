package utilities;

import java.sql.*;

public class JDBC2 {


        public static void main(String[] args) throws SQLException {


            Connection cnn = DriverManager.getConnection("jdbc:postgresql://localhost/HR_Production",
                    "postgres", "admin");


            Statement stt = cnn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String query = "select * from employees";
            ResultSet rs = stt.executeQuery(query);
            //rs.next();

            ResultSetMetaData rsMeta = rs.getMetaData();

            System.out.println("Column count:" + rsMeta.getColumnCount());
            System.out.println("column #1:" + rsMeta.getColumnName(10));
            System.out.println("Table name: " + rsMeta.getTableName(4));
            System.out.println("Is Nullable "+rsMeta.isNullable(8));

            for(int i=1; i<=rsMeta.getColumnCount(); i++){
                System.out.println("Column # " + i +" :"+ rsMeta.getColumnName(i));
            }


        }

    }





