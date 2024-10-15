package jmx.mbean;

import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

public class MBeanDemo
{
    public static void main(String... args) throws Exception
    {
        var test = new Test();
        test.setName("张三");
        test.setAge(18);

        // 注册 MBean
        var mbeanServer = ManagementFactory.getPlatformMBeanServer();

        // 命名规范：域名(一般为包名):type=(接口名),name=(MBean名)
        var objName = new ObjectName("jmx.mbean:type=TestMBean,name=test");
        mbeanServer.registerMBean(test, objName);
    }
}
