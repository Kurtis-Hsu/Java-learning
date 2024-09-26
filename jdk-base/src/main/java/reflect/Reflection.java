package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/**
 * <h2>反射</h2>
 *
 * @Date 2023/11/5 16:28
 */
public class Reflection
{
    private static final String TAB = "    ";

    public static void main(String... args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("class name: ");
        String name = scan.nextLine();

        try
        {
            Class<?> c1 = Class.forName(name);
            Class<?> superc1 = c1.getSuperclass();
            String modifiers = Modifier.toString(c1.getModifiers());

            if (modifiers.length() > 0) System.out.print(modifiers + " ");
            System.out.print("class " + name);
            if (superc1 != null && superc1 != Object.class)
                System.out.print(" extends " + superc1.getName());

            System.out.println("\n{");

            printConstructors(c1);
            System.out.println();

            printMethods(c1);
            System.out.println();

            printFields(c1);

            System.out.println('}');
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        System.exit(0);
    }

    /**
     * 打印类中的所有构造器
     *
     * @param cls 类
     */
    private static void printConstructors(Class<?> cls)
    {
        Constructor<?>[] constructors = cls.getDeclaredConstructors();

        for (Constructor<?> c : constructors)
        {
            String name = c.getName();
            System.out.print(TAB);
            String modifiers = Modifier.toString(c.getModifiers());
            if (modifiers.length() > 0) System.out.print(modifiers + " ");
            System.out.print(name + "(");

            // 打印参数
            Class<?>[] paramTypes = c.getParameterTypes();
            for (int i = 0; i < paramTypes.length; i++)
            {
                if (i > 0) System.out.print(", ");
                System.out.print(paramTypes[i].getName());
            }
            System.out.println(");");
        }
    }

    /**
     * 打印类的方法
     *
     * @param cls 类
     */
    private static void printMethods(Class<?> cls)
    {
        Method[] methods = cls.getDeclaredMethods();

        for (Method m : methods)
        {
            Class<?> rt = m.getReturnType();
            String name = m.getName();

            System.out.print(TAB);

            // 打印修饰符、返回类型和方法名
            String modifiers = Modifier.toString(m.getModifiers());
            if (modifiers.length() > 0) System.out.print(modifiers + " ");
            System.out.print(rt.getName() + " " + name + "(");

            // 打印参数类型
            Class<?>[] paramTypes = m.getParameterTypes();
            for (int i = 0; i < paramTypes.length; i++)
            {
                if (i > 0) System.out.print(", ");
                System.out.print(paramTypes[i].getName());
            }
            System.out.println(");");
        }
    }

    /**
     * 打印类中的字段
     *
     * @param cls 类
     */
    private static void printFields(Class<?> cls)
    {
        Field[] fields = cls.getDeclaredFields();

        for (Field f : fields)
        {
            Class<?> type = f.getType();
            String name = f.getName();
            System.out.print(TAB);
            String modifiers = Modifier.toString(f.getModifiers());
            if (modifiers.length() > 0) System.out.print(modifiers + " ");
            System.out.println(type.getName() + " " + name + ";");
        }
    }
}