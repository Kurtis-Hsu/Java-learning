package syntax;

public class Methods
{
    public static void main(String[] args)
    {

    }

    public boolean isPrime(int num)
    {
        boolean isPrime = true;
        for (int i = 2;i < num;i++)
            if (num % i == 0)
            {
                isPrime = false;
                break;
            }
        return isPrime;
    }
}
