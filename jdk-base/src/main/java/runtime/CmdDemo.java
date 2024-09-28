package runtime;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @Date 2024-04-24 17:30
 */
public class CmdDemo
{
    public static void main(String... args) throws Exception
    {
        // 调用CMD命令
        String[] command = { "ping", "127.0.0.1" };
        Process process = Runtime.getRuntime().exec(command);
        String line;

        try (
                // 设置编码为GBK
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(process.getInputStream(), System.getProperty("native.encoding"))
                )
        ) { while ((line = reader.readLine()) != null) System.out.println(line); }
    }
}