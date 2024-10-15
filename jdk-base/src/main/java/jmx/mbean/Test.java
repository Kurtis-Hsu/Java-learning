package jmx.mbean;

public class Test implements TestMBean
{
    private String name;
    private int age;

    @Override public String getName() { return name; }

    @Override public void setName(String name) { this.name = name; }

    @Override public int getAge() { return age; }

    @Override public void setAge(int age) { this.age = age; }

    @Override public void print() { System.out.println("Name: " + name + ", Age: " + age); }
}
