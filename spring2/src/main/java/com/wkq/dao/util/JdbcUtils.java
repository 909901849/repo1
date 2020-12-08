package com.wkq.dao.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mysql.cj.jdbc.Driver;

import javax.sql.DataSource;
import java.sql.*;

public class JdbcUtils {

//    private static DataSource ds = new ComboPooledDataSource("dao_c3p0");
    private static DataSource ds = new ComboPooledDataSource("dao_c3p0_1");

    public static Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new Driver());
        return ds.getConnection();
    }

    public static void close(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (ps != null) {
            ps.close();
        }
        if (conn != null) {
            conn.close();
        }
    }
}
