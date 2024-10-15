package jmx.mxbean;

import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

public class MXBeanDemo
{
    public static void main(String... args) throws Exception
    {
        var address = new Address();
        address.setAddress("江苏");

        var testx = new Testx();
        testx.setName("张三");
        testx.setAge(18);
        testx.setAddress(address);

        // 注册 MBean
        var mbeanServer = ManagementFactory.getPlatformMBeanServer();

        // 命名规范：域名(一般为包名):type=(接口名),name=(MXBean名)
        var objName = new ObjectName("jmx.mxbean:type=TestMXBean,name=testx");
        mbeanServer.registerMBean(testx, objName);
    }
}
