package utilities;

import java.sql.*;

public class JDBC1 {
    public static void main(String[] args) throws SQLException {

        // create connection:
        Connection cnn = DriverManager.getConnection("jdbc:postgresql://localhost/HR_Production",
                "postgres", "admin");


        // statement
        Statement stt = cnn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);


        // read data
        ResultSet rs = stt.executeQuery("Select * from jobs");
        while (rs.next()) {
            System.out.println(rs.getString("job_title"));

            printCountries(stt);
        }
    }

    private static void printCountries(Statement stt) throws SQLException {
        ResultSet rs = stt.executeQuery("Select * from countries");
        int i=0;
        while (rs.next()) {
            i++;
            System.out.println(i+ "->"+ (rs.getString("country_name")));

        }
    }
}