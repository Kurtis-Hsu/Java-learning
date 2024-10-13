package jdbc;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.SQLException;

public class DataSourceDemo
{
    public static void main(String... args) throws SQLException
    {
        MysqlDataSource dataSource = new MysqlDataSource();

        var connection = dataSource.getConnection();
    }
}
