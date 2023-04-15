package com.ckm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectJDBC {

    public static Connection getConnection() {
        // 1. Oracle JDBC 드라이버를 로드합니다. 
        Connection conn = null;
        String driver = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@192.168.119.119:1521/dink";
        String user = "scott";
        String passwd = "tiger";
        // 2. 데이터베이스에 연결합니다.
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, passwd);
            System.out.println(conn);
        
        } catch (ClassNotFoundException e) {
            // 드라이버 로드 중 예외가 발생한 경우 처리합니다.
            e.printStackTrace();
        } catch (SQLException e) {
         // 데이터베이스 연결 및 쿼리 실행 중 예외가 발생한 경우 처리합니다.
            e.printStackTrace();
        } 
        return conn;

    }

}
