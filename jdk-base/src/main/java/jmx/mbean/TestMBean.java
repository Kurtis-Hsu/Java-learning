package jmx.mbean;

/// MBean 不支持自定义对象
public interface TestMBean
{
    String getName();

    void setName(String name);

    int getAge();

    void setAge(int age);

    void print();
}
