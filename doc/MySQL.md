> ==MySQL是一种**关系型数据库管理系统**，**RDBMS**==

# 用户管理

> 默认情况下，系统会提供一个root账户，这个账户拥有所有的权限

**修改root密码**

```mysql
ALTER USER 'root'@'localhost' identified with mysql_native_password by '123456';
```

**创建新用户**

```mysql
CREATE USER name; // 默认以'%'作为host，并且没有密码
CREATE USER 'name'@'localhost' identified with mysql_native_password by '123456';
// 以localhost作为主机，并以123456作为密码
```

- @后面是host值

  - **%**：通配符，所有主机都可访问
  - **localhost**：只允许本地登录
  - **127.0.0.1**：只允许本地登录，以ip地址匹配
  - **::1**：与127.0.0.1相同，但是::1支持ipv6
  - **ip**：指定用户在某个ip登录

  ==host值不同的话，即使用户名相同也是不同的用户==

  > 例如：'root'@'localhost'和'root'@'%'是两个不同的用户

**删除用户**

```mysql
DROP USER name; // 删除'name'@'%'，如果没有这条记录，则删除失败
DROP USER 'name'@'localhost'; // 删除'name'@'localhost'
```

**查询用户权限**

```mysql
show grants for 用户名; // 用户名必须为名字加host值的形式，'name'@'%'
```

**用户授权**

```mysql
GRANT 权限1[,权限2,...] ON *.* TO 用户@主机; // *.*为”数据库.表“的形式，*为通配符，表示所有数据库中的所有表
GRANT ALL ON *.* TO 用户@主机; // 授予所有权限
```

**收回权限**

```mysql
REVOKE 权限1[,权限2,...] ON *.* FROM 用户@主机;
REVOKE ALL ON *.* TO 用户@主机; // 收回所有权限
```



# 数据库操作

- **创建库**

  ```mysql
  CREATE DATABASE 库名;
  ```

- **删除库**

  ```mysql
  DROP DATABASE 库名;
  ```

- **列出所有库名**

  ```mysql
  SHOW DATABASES;
  ```



# 表操作

## **创建表**

```mysql
CREATE TABLE 表名(
	列名 数据类型[DEFAULT value][约束信息],
    列名 数据类型[DEFAULT value][约束信息],
    ...,
    列名 数据类型[DEFAULT value][约束信息]
)[options];
```

**查看建表语句**

```mysql
SHOW CREATE TABLE 表名;
```



### 数据类型

- **数字型**

  - tinyint

    相当于byte

  - smallint

    相当于short

  - mediumint

    3个字节

  - int

  - bigint

    相当于long

  - float

  - double

- **字符型**

  - char(length)

    定长字符

  - varchar(length)

    可变长字符

  - text

    文本类型

- **日期型**

  - date
  - time
  - datetime
  - timestamp

- **枚举**

  - enum

- **二进制类型**

  - clob (character large object)
  - blob (binary large object)



### 约束信息

> 在原有的数据类型上做进一步限制

- **主键约束（primary key，PK）**

  非空且唯一

  一个表中最多只能有一个主键约束

- **非空约束（NOT NULL，NN）**

- **唯一性约束（UNIQUE）**

  列值不允许重复

- **外键约束（Foreign key，FK）**

  列值来自于其他列的值

  ==只有主键列或唯一性键列才能被引用为外键列==

- **自定义约束（Check，ck）**

#### 添加约束

- **在列定义结束之前添加约束（列级语法）**

  ```mysql
  CREATE TABLE student(
  	id int AUTO_INCREMENT PRIMARY KEY;
      name varchar(128) NOT NULL,
      age mediumint CHECK(age > 5 AND age < 127),
      birth date,
      gender enum('男','女') DEFAULT '男'
  );
  ```

  > 列级语法不能跨列添加约束

- **在列定义结束之后添加约束（表级语法）**

  ```mysql
  CREATE TABLE student(
  	id int AUTO_INCREMENT;
      name varchar(128) NOT NULL,
      age mediumint,
      birth date,
      gender enum('男','女') DEFAULT '男',
      -- 添加约束
      PRIMARY KEY(id),
      UNIQUE(name,gender), -- 跨列
      CHECK(age > 5 AND age < 127)
  );
  ```

  > NOT NULL约束只能写在列定义后面



## 删除表

```mysql
DROP TABLE 表名 [CASCADE contraints];
```



## 修改表

```mysql
ALTER TABLE 表名 子命令;
```



**常用子命令：**

- **添加列**

  ```mysql
  ALTER TABLE 表名 ADD 字段名 数据类型 [DEFAULT value] [约束信息];
  ```

- **删除列**

  ```mysql
  ALTER TABLE 表名 DROP COLUMN 字段名;
  ```

- **修改列名**

  ```mysql
  ALTER TABLE 表名 RENAME COLUMN 字段名 TO 新字段名;
  ```

- **修改列的数据类型**

  ```mysql
  ALTER TABLE 表名 MODIFY 字段名 数据类型 [DEFAULT value] [约束信息];
  ```



# SQL

> SQL标准是针对关系型数据库管理系统的一套操作标准，全称为**Structure Query Language**

SQL有多种不同的命令，主要有：

- **DDL命令**

  Data Definition Language，数据定义语言

  - CREATE
  - DROP
  - ALTER

- **DCL命令**

  Data Control Language，数据控制语句

  - GRANT
  - REVOKE

- **DQL命令**

  Data Query Language，数据查询语句

  - SELECT

- **DML命令**

  Data Manipulate Language，数据操作语句

  - INSERT
  - UPDATE
  - DELETE

- **DTL命令**

  Data Transaction Language，数据事务语句

  - COMMIT
  - ROLLBACK
  - SAVEPOINT



## MySQL中的算术运算与函数

**算术：**

```mysql
SELECT 1 + 1;
SELECT sin(0.5);
...
```

**函数**

> 由RDBMS开发好的一组逻辑代码的整合，可以直接调用
>
> 详见[MySQL官方文档](https://dev.mysql.com/doc/refman/5.7/en/functions.html)

- **字符函数**
- **日期函数**
- **数字函数**
- **加密函数**

```mysql
SELECT user(); -- 返回当前 用户@主机
SELECT now(); -- 返回当前系统时间
SELECT current_date(); -- 返回当前系统日期，不含时间
SELECT current_time(); -- 返回当前系统时间，不含日期
SELECT rand(); -- 返回[0,1.0)之间的随机数
...
```



### 运算符

- **比较运算符**

  <、>、=、<=、>=、!=(<>)

- **逻辑运算符**

  `&&(AND)`、`||(OR)`、`!(NOT)`

- **算术运算**

- **通配运算符**

  `LIKE`和`NOT LIKE`

  - `_` 通配任意单个字符
  - `%` 通配任意多个字符

- **IN运算符**

  `IN(list)`

- **`IS NULL`和`IS NOT NULL`**

- **`BETWEEN ... AND ...`**

- **`REGEXP`**

  正则表达式



## DQL语句

> 数据查询语言

### 基本查询

```mysql
SELECT
	[表别名.]列名1 [AS] 列别名,
	[表别名.]列名2 [AS] 列别名,
	...,
	[表别名.]列名N [AS] 列别名
FROM 表名 [表别名];

SELECT * FROM 表名 [表别名]; -- 查询表中所有数据
```



### 排序子句

```mysql
SELECT
	[表别名.]列名1 [AS] 列别名,
	[表别名.]列名2 [AS] 列别名,
	...,
	[表别名.]列名N [AS] 列别名
FROM 表名 [表别名]
ORDER BY 列名[,列名2,...] | 列的位置 | 表达式
[ASC | DESC] -- 升序|降序，若不指定则默认为升序
```

> 排序子句最后执行



### 条件查询

> 通过WHERE子句对数据进行过滤，支持各种运算符

```mysql
SELECT
	[表别名.]列名1 [AS] 列别名,
	[表别名.]列名2 [AS] 列别名,
	...,
	[表别名.]列名N [AS] 列别名
FROM 表名 [表别名]
WHERE 子句
[ORDER BY 子句];
```



### 关联查询

```mysql
SELECT
	[表别名.]列名1 [AS] 列别名,
	[表别名.]列名2 [AS] 列别名,
	...,
	[表别名.]列名N [AS] 列别名
FROM 表名 [表别名]
[inner|left outer|right outer] JOIN 表名 [表别名] ON 关联条件
[WHERE 子句]
[ORDER BY 子句];
```

- **内连接**

  `INNER JOIN`

  ==只有当关联条件左右两边都满足时，才会进入结果集==

  若不指定内外连接，JOIN语句默认为内连接

- **外连接**

  - **左外连接**

    `LEFT OUTER JOIN`（OUTER可以省略）

    ==以关联的左边为准，即使右边没有与之匹配的记录，左边的记录也会进入结果集==

  - **右外连接**

    `RIGHT OUTER JOIN`（OUTER可以省略）

    ==以关联的右边为准，即使左边没有与之匹配的记录，右边的记录也会进入结果集==

> 一般情况下使用主外键进行连接

#### 自关联

==同一个表，自己和自己关联==





## DML语句

### INSERT命令

```mysql
INSERT [INTO] 表名(列名[,列名][,...][,列名]) VALUES (值1[,值2][,...][,值N]);

INSERT [INTO] 表名 VALUES (值1[,值2][,...][,值N]); -- 要求值顺序与列名顺序一一对应，这种方法无法使用默认值
```

**利用子查询输入：**

```mysql
INSERT INTO 表名(列名[,列名][,...][,列名])
	SELECT 语句; -- 查询出来的列个数和类型都要与被插入的列保持一致
```



### DELETE命令

```mysql
DELETE FROM 表名 [表别名]
[WHERE 子句]
-- 若不使用WHERE子句，表示删除所有行记录。若使用WHERE子句，只删除满足条件的行记录
```



### UPDATE命令

```mysql
UPDATE 表名 [表别名] SET 列1=值1[,列2=值2][,...][,列N=值N]
[WHERE 子句];
-- 若不使用WHERE子句，表示更新所有行记录。若使用WHERE子句，只更新满足条件的行记录
```



# 视图

视图也是一种数据库对象，基于表而存在，并且==与表共享存储空间==

操作视图的方法与表一致，且==对视图进行CUD操作时，也会影响所在表的数据==

```mysql
CREATE [OR REPLACE] [ALGORITHM = {UNDEFINED | MERGE | TEMPTABLE}]
VIEW view_name[(column_list]
AS
	select_statement
[WITH [CASCADE | LOCAL] CHECK OPTION];
                       
-- 举例
CREATE VIEW emp_view_demo
AS
	SELECT ename, sal, job FROM emp WHERE deptno = 20;
```

> 如果使用者是普通用户，需要授予`CREATE VIEW`权限
>
> `ALGORITHM`指定系统创建视图的算法，默认为`UNDEFINED`，表示由系统自动选择
>
> `WITH [CASCADE | LOCAL] CHECK OPTION`，默认为`CASCADE`，表示在对视图进行CUD操作时，是否遵守原来创建此视图时的SELECT语句的约束以及原表中的约束



## 视图的分类

- **简单视图**

  视图的数据来源于一张表，并且创建视图的查询语句中没有表达式、函数

  > 简单视图可以做CUD操作，能否成功视情况而定

- **复杂视图**

  视图的数据来源于多张表的联合查询，并且创建视图的查询语句中可以使用表达式、函数

  > 复杂视图不能做CUD操作



# E-R 图

> **Entity Relationship Diagram，实体关系图**



# 数据库事务

==**事务**：一组相关的SQL操作，也就是说事务的边界由业务决定==

## 事务的开始与结束

调用`begin`命令或`start transaction`命令表明事务开始

调用`commit`命令或`rollback`命令表明事务结束

- **commit**

  提交事务，把此事务中内存的数据状态同步到底层磁盘中

- **rollback**

  回滚事务，把事务中内存的状态取消，回到事务开始前的状态

> MySQL中在默认情况下自动调用开始命令
>
> 每执行一条命令，会自动提交并再次调用开始命令
>
> 所以若不自行调用事务命令，MySQL永远处于事务状态中

## 事物的特性

**四大特性【ACID】：**

- **原子性 Atomictiy**

  处在同一事务的操作不可分割，要么一起成功，要么一起失败

- **一致性 Consistency**

  事务结束后，内存中的数据状态与底层磁盘中的数据状态保持一致

- **隔离性 Isolation**

  多个事务之间互相隔离

- **持久性 Durability**

  事务一旦正确提交，RDBMS要保证数据不再丢失



## 事务并发

当多个事务对同一个数据库对象【表】进行操作时，会发生并发，数据库提供了“锁”机制来做并发处理

> INNODB引擎支持表级锁与行级锁
>
> MYISAM引擎只支持表级锁

- **表级锁**

  粒度较大，性能开销较小，但是并发性低

  ```mysql
  LOCK TABLE table_name READ | WRITE -- 必须显示调用
  ```

- **行级锁**

  粒度较小，性能开销较大，但是并发性能高

  行级锁是自动申请的，在执行DML操作时，RDBMS都会自动为当前事务分配行级排它锁

  一个表只有一个表级锁，它的每一行记录都有一把行级锁



## 事务操作

1. **开始事务**

   `begin`

2. **调用SQL命令**

   `INSERT ...`

   `UPDATE ...`

   `DELETE ...`

3. **结束事务**

   `commit`提交

   `rollback`回滚



## 事务的隔离级别

```mysql
SELECT @@transaction_isolation; -- 查询当前会话的事务隔离级别
SET session transaction isolation level read committed; -- 设置当前会话的事务隔离级别
-- read uncommitted
-- read committed
-- repeatable read
-- serializable
```



> MySQL中，采用`INNODB`引擎时，默认的事务隔离级别是**READ_COMMITED**

- **READ UNCOMMITED**

  可以读取没有提交的事务中的数据，允许脏读（dirty read）

- **READ COMMITED**

  可以读取已提交的事务中的数据，不允许脏读

- **READ REPEATABLE**

  不可重复读

  在同一个事务中，连续执行两次相同的SELECT命令，读到的数据不一样

  因为查询语句在默认情况下不会申请行级排它锁，所以在一个事务的两次查询中有可能被另一个事务更新目标数据

- **Serializable**

  串行化，不可幻读

  在同一个事务中，连续执行两次SELECT COUNT(*)命令，得到的结果不一样

  幻读是指在一个事务的两次查询中有可能被另一个事务执行插入命令

  这个级别会在表上加锁

  > serializable级别可以防止幻读、不可重复读、脏读
  >
  > 但是并发性能最低

### 加锁

**查询加锁**

```mysql
SELECT * FROM t_student FOR UPDATE [nowait];
```

**锁表**

```mysql
LOCK TABLE table_name READ | WRITE;
-- READ模式：其他事务可以做SELECT操作
-- WRITE模式：其他事务不可以左任何操作

-- 释放锁
UNLOCK TABLES;
```



# 索引（index）

索引是数据库在查询时的一种==优化、提高查询效率==的一种方式

它**本身也是数据库对象，==有独立的存储空间和命名空间==**

默认情况下，索引采用==BTREE==结果来存储

## 索引的创建方式

- **自动创建**

  当表中的列添加了主键约束或唯一约束时，RDBMS会自动创建唯一性索引

  > 只有查询条件是创建了索引的列时，RDBMS才会使用索引进行查询

- **手动创建**

  ```mysql
  CREATE INDEX index_name ON table_name(column_name[,column_name]) [visible];
  -- 多列表时联合索引，不是为每个列创建索引
  ```



## 何时创建索引

- 列中的NULL太多时，不适合创建索引
- 列中的值重复率高时，不适合创建索引
- 列经常做更新时，不适合创建索引



## RDBMS查询步骤

1. 判断查询条件列是否加了索引
2. 查询索引，找到“行记录的物理位置”
3. 根据“行记录的物理位置”去表中定位记录
4. 把记录返回给结果集



## 索引失效的情况

- 查询条件没有使用添加了索引的列
- 查询条件中使用了表达式或函数
