package com.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBUtils {
    public  static Connection getConnection(){
        Connection connection=null;
        InputStream inputStream = DBUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        try{
            properties.load(inputStream);
            String user=properties.getProperty("user");
            String password=properties.getProperty("password");
            String url=properties.getProperty("url");
            String driverClass=properties.getProperty("driverClass");

            Class.forName(driverClass);

            connection =  DriverManager.getConnection(url,user,password);
        }catch (IOException | ClassNotFoundException | SQLException e){
            e.printStackTrace();

        }
        return connection;
    }

    public static void closeAll(ResultSet rs, PreparedStatement pstm, Connection connection){
        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (pstm!=null) {
            try {
                pstm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
