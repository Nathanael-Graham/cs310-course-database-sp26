package edu.jsu.mcis.cs310.coursedb.dao;

import java.sql.*;
import com.github.cliftonlabs.json_simple.*;
import java.util.ArrayList;

public class DAOUtility {
    
    public static final int TERMID_SP26 = 1;
    
    public static String getResultSetAsJson(ResultSet rs) {
        
        JsonArray records = new JsonArray();
        
        try {
        
            if (rs != null) {

                // INSERT YOUR CODE HERE
                ResultSetMetaData rsmd = rs.getMetaData();
                int columnNumber = rsmd.getColumnCount();
                
                while (rs.next()){
                    JsonObject jsonObject = new JsonObject();
                    
                    for (int i = 1; i <= columnNumber; i++){
                        String columnName = rsmd.getColumnName(i);
                        Object value = rs.getObject(i);
                        
                        jsonObject.put(columnName, (value != null) ? value.toString() : null);
                    }
                    
                    records.add(jsonObject);
                }
            }
            
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        return Jsoner.serialize(records);
        
    }
    
}
