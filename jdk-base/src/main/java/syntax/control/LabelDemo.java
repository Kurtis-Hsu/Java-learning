package syntax.control;

/// ### 标签
///
/// 标签用于标记一个语句或语句块，break 或 continue 操作标签时相当于该标签对应的语句或语句块中执行了一次 break 或 continue
public class LabelDemo
{
    public static void main(String... args)
    {
        label:
        for (int i = 1; i < 10; i++)
        {
            System.out.println("outside: " + i);
            for (int j = 1; j < 10; j++)
            {
                System.out.println("inside: " + j);
                if (j == 6)
                    break label;
            }
        }
    }
}
