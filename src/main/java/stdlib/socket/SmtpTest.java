package stdlib.socket;

import java.io.*;
import java.net.Socket;

public class SmtpTest
{
    public static void main(String[] args) throws IOException
    {
        System.out.println("连接中...");
        var socket = new Socket("smtp.163.com", 25);
        System.out.println("连接成功");

        Thread.startVirtualThread(
                () ->
                {
                    try (
                            var reader = new BufferedReader(
                                    new InputStreamReader(socket.getInputStream())
                            )
                    )
                    {
                        String line;
                        while ((line = reader.readLine()) != null) System.out.println(line);
                    }
                    catch (IOException e)
                    {
                        throw new RuntimeException(e);
                    }
                }
        );

        try (var writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true))
        {
            var s = STR."EHLO example.com";
            System.out.println(s);
            writer.println(s);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}
