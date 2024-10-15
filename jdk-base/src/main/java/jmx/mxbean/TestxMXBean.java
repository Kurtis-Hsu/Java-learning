package jmx.mxbean;

public interface TestxMXBean
{
    String getName();

    void setName(String name);

    int getAge();

    void setAge(int age);

    Address getAddress();

    void setAddress(Address address);

    void print();
}
