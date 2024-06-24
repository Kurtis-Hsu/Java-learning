> 相关网址

| 网址                                                       | 说明                                                 |
| ---------------------------------------------------------- | ---------------------------------------------------- |
| https://www.oracle.com                                     | Oracle官网（Java目前属于Oracle公司）                 |
| https://www.oracle.com/cn/java                             | Java中文官网                                         |
| www.oracle.com/technetwork/java/javase/downloads           | Java开发工具包与文档下载地址                         |
| http://openjdk.java.net                                    | 源代码（例如编译器、虚拟机、原生方法以及私有辅助类） |
| http://docs.oracle.com/javase/tutorial/getStarted/cupojava | Oracle官方教程                                       |



# Java编译运行过程

1. 编译期：`.java`源文件，经过编译，生成`.class`字节码文件

2. 运行期：JVM加载`.class`并运行

**相关名词**

- **JVM（Java Virutal Machine，Java虚拟机）**

  它是为了屏蔽底层OS之间的不同差异而存在的程序，JVM本身并不能跨平台

  Java开发的代码不是直接编译成底层OS所需要的执行程序，而是编译成JVM所需要的中间码，这个中间码称为**字节码（`.class`文件）**

- **JRE（JAVA Runtime Environment，JAVA运行环境）**

  包含JVM及运行java程序所必须的环境

- **JDK（Java Development Kit，Java开发工具包）**

  包含JVM、JRE、一些可执行命令（java，javac，jshell，javadoc等）以及第三方的类库

  > 运行java程序的最小环境为JRE
  >
  > 开发java程序的最小环境为JDK

==Java源文件以类名作为文件名，后缀为`.java`，经过编译器编译后，在旁边生成后缀为`.class`的同名字节码文件（内容为二进制机器语言）==



# 命令行工具

**编译源文件：`javac [-option] source_name.java`**

**例如：**`javac HelloWord.java`

> 使用通配符编译源文件：`javac Hello*.java`（编译所有文件名以`Hello`开头的java源文件）



如果源文件在其他文件夹中，使用命令：**`javac dir\dir\...\source_name.java`**

- **`.`**

  当前文件夹

  > `.\file`指向当前文件夹下的文件名为`file`的文件

- **`..`**

  上一级文件夹

  > `..\file`指向当前文件夹的上一级文件夹下的文件名为`file`的文件



**运行程序：`java class_name`**

必须是后缀为`.class`的文件，使用该命令需要去除后缀

**例如：**`java HelloWorld`



> 编译器对文件（带有文件分隔符和扩展名`.java`的文件）进行操作
>
> 而Java解释器加载类（不需要`.class`后缀）
>
> 如果运行包中的类需要使用`.`分隔符而不是文件分隔符
>
> 例如：`java com.xxx.HelloWorld`



# 包

==包用于将类组织起来，让自己的代码与别人提供的代码库分开管理（相当于计算机中的文件系统）==

> Sun公司建议将公司的因特网域名以逆序的形式作为包名，并且对于不同的项目使用不同的子包
>
> 例如：`com.baidu.project`

**从编译器的角度，嵌套的包之间没有任何关系**

> `java.util`与`java.util.jar`毫无关系，每一个都拥有独立的集合



## 类的导入

==一个类可以使用所属包中的所有类，以及其他包中的公有类==

**导入包的两种方式：**

- **在每个类之前添加完整的包名**

  ```java
  class OOP
  {
      java.time.LocalDate today = java.time.LocalDate.now();
  }
  ```

- **使用import语句**

  import语句是一种引用包含在包中的类的简明描述，**一旦使用了import语句，就无需写出包的全名**

  ```java
  import java.time.LocalDate;
  
  class OOP
  {
      LocalDate today = LoacalDate.now();
  }
  ```




使用通配符导入一个包下的所有类：`import java.time.*;`

> 只能使用星号导入一个包，无法使用`java.*`或`java.*.*`导入以java为前缀的所有包



==在发生类名冲突时，就需要注意包名==

```java
// java.util和java.sql中都有日期（Date）类
import java.util.*;
import java.sql.*;
// 如果程序中使用Date类，就会出现编译错误
import java.util.Date; // 增加一个特定的import语句解决报错

class OOP
{
    public static void main(String[] args)
    {
        java.util.Date d1 = new java.util.Date();
        java.sql.Date d2 = new java.sql.Date(...);
        // 如果两个类都需要使用，那就必须在前面添加完整的包名
    }
}
```



## 静态导入

==import语句可以导入静态属性和方法==

```java
import static java.lang.System.*;
import static java.lang.System.out; // 导入指定的属性或方法

class OOP
{
    public static void main(String[] args)
    {
        out.println("Hello World!"); // 此时就可以不写类名前缀直接使用静态属性
    }
}
```



## 将类放入包中

**定义类的所在包：**

在源文件的开头，包中定义类的代码之前写上类所在的包名

```java
package com.xxx; // 定义该类在com.xxx包下

public class HelloWorld
{
    ...
}
```



如果没有在源文件中定义package语句，这个源文件中的类就被放置在**默认包**中，默认包是一个没有名字的包

在此之前，定义的所有类都在默认包中

**包中的文件应该放在与包名匹配的子目录中**

> `com.xxx`包中的源文件应被放置在子目录`com\xxx`中



==若使用命令行工具，编译源文件要在**基目录**中进行==

**例如：**

`PackageTest`类放置在默认包中，`Employee`类放置在`com.company.staff`包中

```java
import com.company.staff.Employee;

public class PackageTest
{
    Employee e = new Employee();
}
```

```java
package com.company.staff;

public class Employee
{
}
```

目录结构为：

```
.（基目录）
	- Package.java
	- Package.class
	- com
		- company
			- staff
				- Employee.java
				- Employee.class
```

这种情况只需要在基目录下编译`javac Package.java`，编译器会自动寻找文件`com\company\staff\Employee.java`并编译



**另一种情况：**

`PackageTest`类放置在`com.othercompany`包中，`Employee`类放置在`com.company.staff`包中

```java
package com.othercompany;

import com.company.staff.Employee;

public class PackageTest
{
    Employee e = new Employee();
}
```

```java
package com.company.staff;

public class Employee
{
}
```

目录结构为：

```
.（基目录）
	- com
		- company
			- staff
				- Employee.java
				- Employee.class
		- othercompany
			- Package.java
			- Package.class
```

这种情况仍然要从基目录编译和运行

`javac com\othercompany\Package.java`

`java com.othercompany.Package`



> 编译器在编译源文件时不检查目录结构
>
> **例如：**一个源文件开头是`package com.mycompany;`，即使这个源文件没有在子目录`com/mycompany`下，也可以进行编译
>
> 如果它不依赖于其他包，那么就不会出现编译错误
>
> 但是，最终的程序将无法执行，除非先将类文件（`.class`文件）移至正确的位置上
>
> 如果包名与目录不匹配，虚拟机就找不到类



# JAR文件

==JAR（Java归档）文件使用ZIP格式组织文件和子目录==

可以使用ZIP程序查看JAR文件结构



# 类路径

可以在编译Java文件时，引用其他文件或JAR包中的类，分为以下步骤：

1. 将类或JAR包放入一个目录中，例如`C:\\users\xxx\classdir`，这个目录是**包树状结构的基目录**

   > 如果要添加`com.company.staff.Employee`类
   >
   > `Employee.class`文件就必须位于子目录`C:\users\xxx\classdir\com\company\staff`中

2. 设置类路径（包含所有类文件的路径的集合，不规定顺序）

   - UNIX环境中，类路径的不同项目之间采用冒号`:`分隔

     `/home/user/classdir:.:/home/user/archives/archive.jar:xxx`

   - Windows环境中以分号`;`分隔

     `C:\user\xxx\classdir;.;xxx\xxx.jar;xxx`

> JavaSE6开始，可以在JAR文件目录中指定通配符
>
> 例如：`C:\classdir;.;C:\archives\*`或`/home/user/classdir:.:/home/user/archives/'*'`
>
> 表示`archives`目录中的所有JAR文件都包含在路径中
>
> 但是在UNIX中，禁止使用`*`以防止shell命令进一步扩展



运行时库文件（`re.jar`和在`jre/lib`与`jre/lib/ext`目录下的一些其他JAR文件）会被自动搜索，所以不必显式的列在类路径中

> javac编译器总是在当前目录中查找文件，但Java虚拟机仅在类路径中有`“.”`目录时才查看当前目录
>
> 如果没有设置类路径，那也不会产生问题，默认的类路径包含`“.”`目录
>
> 但如果设置了类路径却忘记包含`“.”`目录，程序仍然可以通过编译，但不能运行



## 定位类

==类路径所列出的目录和归档文件是搜寻类的起始点==

**例如：**

- **虚拟机定位类：**

  有一个类路径`/home/user/classdir:.:/home/user/archives/archive.jar`

  虚拟机要搜索`com/xxx/Employee`类文件

  1. 查看存储在`jre/lib`与`jre/lib/ext`目录下的归档文件中所存放的系统类文件
  2. 如果系统类文件中没有，则在类路径中查找以下文件：
     - `/home/user/classdir/com/xxx/Employee.class`
     - `com/xxx/Employee.class`（从当前目录开始）
     - `/home/user/archives/archive.jar`中的`com/xxx/Employee.class`

- **编译器定位文件：**

  如果引用了一个类，而没有指出这个类所在的包

  那么编译器将首先查找包含这个类的包，并询查所有的import指令，确定其中是否包含了被引用的类

  **例如：**

  源文件包含指令：

  `import java.util.*;`

  `import com.xxx.*;`

  并且源代码引入了`Employee`类

  编译器将试图寻找`java.lang.Employee`（`java.lang`包被默认导入）、`java.util.Employee`、`com.xxx.Employee`和当前包中的`Employee`，对这个类路径的所有位置中列出的每一个类进行逐一查看

  如果找到了一个以上的类，就会产生编译错误（类必须唯一，而import语句的次序无关紧要）

  > 编译器还需要对比源文件与类文件，如果源文件比类文件新，源文件会自动被重新编译



## 设置类路径

==使用`-classpath`（或`-cp`）选项指定类路径==

例如：`java -classpath /home/user/classdir:.:/home/user/archives/archive.jar HelloWorld`

或：`java -classpath C:\classdir;.;C:\archives/archive.jar HelloWorld`

> 整个命令应该写在一行中（可以放在一个shell脚本或批处理文件中）



**可以通过设置系统环境变量（CLASSPATH）的方式设置类路径，如果运行时不指定类路径，Java会默认去寻找系统的CLASSPATH环境变量中设置的类路径**