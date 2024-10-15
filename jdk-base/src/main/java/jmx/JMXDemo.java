package jmx;

import java.lang.management.ManagementFactory;

public class JMXDemo
{
    public static void main(String... args)
    {
        var operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean(); // 操作系统
        System.out.println("操作系统名称：" + operatingSystemMXBean.getName());
        System.out.println("操作系统架构：" + operatingSystemMXBean.getArch());
        System.out.println("操作系统版本：" + operatingSystemMXBean.getVersion());
        System.out.println("操作系统处理器数量：" + operatingSystemMXBean.getAvailableProcessors());
        System.out.println("操作系统平均负载：" + operatingSystemMXBean.getSystemLoadAverage());

        var memoryMXBean = ManagementFactory.getMemoryMXBean(); // 内存

        var heapMemoryUsage = memoryMXBean.getHeapMemoryUsage();
        System.out.printf("堆内存：%s%n", heapMemoryUsage.toString());
        var nonHeapMemoryUsage = memoryMXBean.getNonHeapMemoryUsage();
        System.out.printf("非堆内存：%s%n", nonHeapMemoryUsage.toString());

        var classLoadingMXBean = ManagementFactory.getClassLoadingMXBean();
        var loadedClassCount = classLoadingMXBean.getLoadedClassCount();
        var totalLoadedClassCount = classLoadingMXBean.getTotalLoadedClassCount();
        System.out.printf("当前加载类数量：%d%n", loadedClassCount);
        System.out.printf("已加载类总数量：%d%n", totalLoadedClassCount);
        System.out.printf("当前卸载类数量：%d%n", classLoadingMXBean.getUnloadedClassCount());
    }
}
