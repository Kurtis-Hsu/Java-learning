package syntax;

// Java 只有三种注释
public class Comment
{
    // 单行注释
    /*
        多行注释
        多行注释
     */

    /**
     * 文档注释
     *
     * @param args 参数
     */
    public static /* 多行注释可以在语句中间 */ void main(String[] args)
    {
        // 语句以 ; 结束
        doSth(); // 双斜杠后面单行内的所有内容都是注释
    }

    /**
     * 文档注释给元素添加文档
     * 可以使用 javadoc 生成文档
     */
    static void doSth() { System.out.println("do sth"); }

    /// Java 23 之后可以使用 markdown 语法写文档注释
    ///
    /// [Class] 引用
    void markdown() { System.out.println("markdown"); }
}
