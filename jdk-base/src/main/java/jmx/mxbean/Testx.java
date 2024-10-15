package jmx.mxbean;

public class Testx implements TestxMXBean
{
    private String name;
    private int age;
    private Address address;

    @Override public String getName() { return name; }

    @Override public void setName(String name) { this.name = name; }

    @Override public int getAge() { return age; }

    @Override public void setAge(int age) { this.age = age; }

    @Override public Address getAddress() { return address; }

    @Override public void setAddress(Address address) { this.address = address; }

    @Override
    public void print()
    {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Address: " + address.getAddress());
    }
}
