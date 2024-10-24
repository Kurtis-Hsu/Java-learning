package syntax.control;

import static java.lang.System.out;

/// ### switch 语句
///
/// switch 语句会执行匹配成功的代码段
///
/// 如果没有 break 会一直向下执行其他代码段，直到遇到 break或 switch 结束
public class SwitchDemo1
{
    public static void main(String... args)
    {
        int i = 3;
        switch (i)
        {
            // 若 default 放在首位，会直接贯穿整个 switch 语句，直到遇到 break
            // default:
            //     out.println(666);
            case 1:
                out.println(111);
                break;
            case 2:
                out.println(222);
                break;
            case 3:
                out.println(333);
            default:
                out.println(666);
        }
    }
}
