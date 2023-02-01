package utilities;

import java.sql.*;
import java.util.ArrayList;

public class JDBCTest {
    public static void main(String[] args) throws SQLException {
        //interface
        //create Connection:
        Connection cnn = DriverManager.getConnection("jdbc:postgresql://localhost/HR_Production",
                "postgres", "admin");


        //Statement
        Statement stt = cnn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        //ResultSet rs = stt.executeQuery("Select * from jobs");
        // rs.next();
        //rs.next();
        // while( rs.next()==true){
        //System.out.println(rs.getString("job_title"));
        // }


        //print "f.name of parent is a parent od fName of child
        //ResultSet rs2 = stt.executeQuery("select concat(e.first_name, ' ', e.last_name) as p_full_name, concat(d.first_name, ' ', d.last_name) as d_full_name from employees e, dependents d\n" +
              //  "where e.employee_id = d.employee_id;");

       // while (rs2.next()) System.out.println(rs.getString("p_full_name") + "is a parent of " + rs2.getString("d_full_name"));


        findDifferentEmail(cnn,stt);
    }
    private static void findDifferentEmail(Connection cnn, Statement stt) throws SQLException {
        ResultSet rs3 = stt.executeQuery("select email\n" +
                "from employees");
        ArrayList<String> emailList= new ArrayList<>();

        while(rs3.next()) emailList.add(rs3.getString("email"));

        boolean isWrongEmail = false;
        for(String em : emailList){
        if(!em.endsWith("@saltitorial.org")){
            System.out.println("wrong email"+ em);
            isWrongEmail = true;
    }
}
    if(isWrongEmail) System.out.println("Found different email");
    else System.out.println("All emails are the same");
    }
}
