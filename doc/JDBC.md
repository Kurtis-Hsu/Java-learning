# 连接数据库的步骤

## 一、注册驱动

- `Class.forName("com.mysql.jdbc.Driver");`

  推荐这种方式，不会对具体的驱动类产生依赖

  > MySQL8的驱动类路径为`com.mysql.cj.jdbc.Driver`

- `DriverManager.registerDriver(com.mysql.jdbc.Driver);`

  会造成DriverManager中产生两个一样的驱动，并会对具体的驱动类产生依赖

- `System.setProperty("jdbc.drivers", "driver1:driver2");`

  虽然不会对具体的驱动类产生依赖；但注册不太方便，所以很少使用

- 驱动类型（四种类型）



## 二、建立连接（Connection）

- `Connection conn = DriverManager.getConnection(url, user, password);`

- **url格式**：

  JDBC:子协议:子名称//主机名:端口/数据库名?属性名=属性值&..

  `jdbc:mysql://localhost:3306/db_name?key=value&...`

- User,password可以用“属性名=属性值”方式告诉数据库;

- 其他参数如：

  - `useUnicode=true`
  - `characterEncoding=GBK`
  - `serverTimezone=Asia/Chongqing`




## 三、创建执行SQL的语句（Statement）

- **Statement**

  ```Java
  Statement sm = conn.createStatement();
  sm.executeQuery(sql);
  ```

  

- **PreparedStatement**

  ```Java
  String sql = "SELECT * FROM table_name WHERE col_name = ?";
  PreparedStatement ps = conn.preparedStatement(sql);
  ps.setString(1, "col_value");
  ps.executeQuery();
  ```

  



## 四、处理执行结果（ResultSet）

```Java
ResultSet rs = statement.executeQuery(sql);
While(rs.next())
{
    rs.getString("col_name");
    rs.getInt("col_name");
    // ...
}
```



## 五、释放资源

释放`ResultSet`，`Statement`，`Connection`

数据库连接（Connection）是非常稀有的资源，用完后必须马上释放，如果Connection不能及时正确的关闭将导致系统宕机

Connection的使用原则是尽量晚创建，尽量早释放



# 基本的CRUD操作（创建、读取、更新、删除）

```java
// 模板代码
Connection conn = null;
Statement sm = null;
ResultSet rs = null;
try
{
    // 获取Connection
    // 创建Statement
    // 处理查询结果ResultSet
}
finally
{
    // 释放ResultSet，Statement，Connection
}
```



## 创建

增加对应SQL的INSERT，返回增加成功的行（记录）数

```java
conn = getConnection();
Statement sm = conn,createStatement();
String sql = "INSERT INTO ...";
int i = sm.executeUpdate(sql);
// i为插入的记录数
```
