package utilities;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBC22 {
    public static void main(String[] args) throws SQLException {
        Connection cnn = DriverManager.getConnection("jdbc:postgresql://localhost/HR_Production",
                "postgres", "admin");


        //Statement
        Statement stt = cnn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stt.executeQuery("Select * from employess");

        Map<Integer,String> map =new HashMap<>();
        map.put(5, "Chicago");
        map.put(6, "park Ridge");
        map.put(7,"Des Plaines");
        System.out.println(map.get(5));
        System.out.println(map.get(6));

        Map<Integer,String> map1 =new HashMap<>();
        map1.put(5, "Mt Prospect");
        map1.put(6, "Shaumburg");
        map1.put(7,"Muundeline");

        Map<Integer,String> map2 =new HashMap<>();
        map2.put(5, "Libertiville");
        map2.put(6, "Evanston");
        map2.put(7,"Skokie");

        List<Map<Integer, String>> list =new ArrayList<>();
        list.add(map);
        list.add(map1);
        list.add(map2);
        System.out.println(list);

        for(int i=0; i<list.size(); i++){
            System.out.println("Map # " +(i+1));
            for( int j=5; j<8; j++){
                System.out.println(list.get(i).get(j));
            }
            System.out.println("========");
        }
    }
}
