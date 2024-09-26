package syntax;

import java.util.Arrays;

/**
 * <h2>关键字表</h2>
 *
 * @Date 2024-04-02 13:07
 */
public enum KeyWords
{
    // JDK8
    ABSTRACT("抽象类或方法"),
    ASSERT("用来查找内部程序错误"),
    BOOLEAN("布尔类型"),
    BREAK("跳出一个选择语句或循环"),
    BYTE("8位整数类型"),
    CASE("switch 的一个分支"),
    CATCH("捕获异常的 try 块子句"),
    CHAR("Unicode 字符类型"),
    CLASS("定义一个类类型"),
    CONST("未使用"),
    CONTINUE("在循环末尾继续"),
    DEFAULT("switch 的默认子句，或者接口的默认方法"),
    DO("do/while 循环最前面的子句"),
    DOUBLE("双精度浮点数类型"),
    ELSE("if 语句的 else 子句"),
    ENUM("枚举类型"),
    EXPORTS("导出一个模块的包（受限）"),
    EXTENDS("定义一个类的父类，或者一个通配符的上界"),
    FINAL("一个常量，或一个不能被覆盖的类或方法"),
    FINALLY("try 块中总会执行的部分"),
    FLOAT("单精度浮点数类型"),
    FOR("一种循环类型"),
    GOTO("未使用"),
    IF("一个条件语句"),
    IMPLEMENTS("定义一个类实现的接口"),
    IMPORT("导入一个包"),
    INSTANCEOF("测试一个对象是否为一个类的实例"),
    INT("32位整数类型"),
    INTERFACE("一种抽象类型，其中包含可以由类实现的方法"),
    LONG("64位长整数类型"),
    NATIVE("由宿主系统实现的一个方法"),
    NEW("分配一个新对象或数组"),
    NULL("一个空引用（null 从技术上讲是一个字面量，而非关键字）"),
    MODULE("声明一个模块（受限）"),
    OPEN("修改一个 module 声明（受限）"),
    OPENS("打开一个模块的包（受限）"),
    PACKAGE("包含类的一个包"),
    PRIVATE("这个特性只能由该类的方法访问"),
    PROTECTED("这个特性只能由该类、其子类以及同一个包中的其他类的方法访问"),
    PROVIDES("只是一个模块使用一个服务（受限）"),
    PUBLIC("这个特性可以由所有类的方法访问"),
    RETURN("从一个方法返回"),
    SHORT("16位整数类型"),
    STATIC("这个特性是类或接口特有的，而不属于类的实例"),
    STRICTFP("对浮点数计算使用严格的规则"),
    SUPER("超类对象或构造器，或一个通配符的下界"),
    SWITCH("一个选择语句"),
    SYNCHRONIZED("对线程而言是原子的方法或代码块"),
    THIS("当前类的一个方法或构造器的隐含参数"),
    THROW("抛出一个异常"),
    TO("exports 或 opens 声明的一部分（受限）"),
    THROWS("一个方法可能抛出的异常"),
    TRANSIENT("标记非永久的数据"),
    TRANSITIVE("修饰一个 requires 声明（受限）"),
    TRY("捕获异常的代码块"),
    USES("指示一个模块使用一个服务（受限）"),
    VAR("声明一个变量的类型是推导得出的（受限）"),
    VOID("指示一个方法不返回任何值"),
    VOLATILE("确保一个字段可以由多个线程访问"),
    WITH("在一个 provides 语句中定义服务类（受限）"),
    WHILE("一种循环"),
    ;

    private final String description;

    KeyWords(String description) { this.description = description; }

    public static void main(String... args)
    {
        Arrays
                .stream(KeyWords.values())
                .sorted()
                .forEach(k -> System.out.printf("%16s: %s\n", k.name().toLowerCase(), k.description));
    }
}