package jdbc;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCDemo
{
    static
    {
        // 注册驱动
        try { Class.forName("com.mysql.cj.jdbc.Driver"); }
        catch (ClassNotFoundException e) { throw new RuntimeException(e); }
    }

    public static void main(String... args) throws SQLException
    {
        try (
                var conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/demo?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Chongqing",
                        "root",
                        "root"
                )
        )
        {
            PreparedStatement statement = conn.prepareStatement("INSERT INTO t_stu(sname) VALUES (?)");
            statement.setString(1, "张三");
            statement.execute();
        }
    }
}
