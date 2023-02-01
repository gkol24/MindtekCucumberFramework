package utilities;

import java.sql.*;
import java.util.ArrayList;

public class JDBCDepartments {

    public static void main(String[] args) throws SQLException {

        // create connection:
        Connection cnn = DriverManager.getConnection("jdbc:postgresql://localhost/HR_Production",
                "postgres", "admin");


        // statement
        Statement stt = cnn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);


        //printDepartmentsByCountries(stt);
        updateAllEmails(stt);

    }

    private static void updateAllEmails(Statement stt) throws SQLException {
        //1. write a query to get emIL IN A RESULT SET
        String emailQuery = "Select email from employees";
        ResultSet rs = stt.executeQuery(emailQuery);

        //2.Iterate through yours rs & put all emails into arraylist
        ArrayList<String> emailList = new ArrayList<>();
        while (rs.next()) {
            emailList.add(rs.getString("email"));
        }
        //3.Iterate through arrayList & change from @tutotiaal.org to @mindtek.edu
        ArrayList<String> newEmailList = new ArrayList<>();
        for (String email : emailList) {
            email = email.substring(0, email.indexOf('@')) + "@mindtek.edu";
            newEmailList.add(email);
        }
        System.out.println(newEmailList);


        //put to db
        String updateQuery = "update employees set email = newEmail where employees.email= oldEmail ";
        int i = 0;
        for (String em : emailList) {
            updateQuery = "update employees set email ='" + newEmailList.get(i) + "' where employees.email= '"+
            emailList.get(i) + "'";
            stt.executeUpdate(updateQuery);
            i++;
        }
    }
    private static void printDepartmentsByCountries(Statement stt) throws SQLException {
            ResultSet rs = stt.executeQuery("select l.country_id, count(d.department_name)\n" +
                    "from locations l, departments d\n" +
                    "where l.location_id=d.location_id\n" +
                    "group by l.country_id");

            while (rs.next()) {

                System.out.println(rs.getString("country_id")+" -> "+rs.getString("count"));

            }
    }
}