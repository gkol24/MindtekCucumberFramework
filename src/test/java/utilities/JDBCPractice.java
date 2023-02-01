package utilities;

import java.sql.*;

public class JDBCPractice {
    public static void main(String[] args) throws SQLException {
        Connection cnn = DriverManager.getConnection("jdbc:postgresql://localhost/HR_Production",
                "postgres", "admin");

        Statement stt = cnn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stt.executeQuery("select employees.first_name, employees.last_name,jobs.job_title, dependents.first_name\n" +
                "from employees, jobs, dependents\n" +
                "where employees.employee_id=dependents.employee_id and employees.job_id=jobs.job_id;");
        while (rs.next()) System.out.println(rs.getString("first_name")+' '+rs.getString("last_name")+ "is working as" +" "
                + rs.getString("job_title")+"."+"Child's name is "+" " + rs.getString("first_name")+".");

    }
}