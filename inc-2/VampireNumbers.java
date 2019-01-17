import java.util.Arrays;
import java.util.HashSet;

public class VampireNumbers
{
    private static int getNumberOfDigits(long num)
    {
        return Long.toString(Math.abs(num)).length();
    }

    /**
    checks if the number is a vampire number
    @param number

    @param fang1
           first factor of the number
    @param fang2
            second factor of the number
    **/

    private static boolean checkFang(long number, long fang1, long fang2)
    {
        if(Long.toString(fang1).endsWith("0") && Long.toString(fang2).endsWith("0"))
            return false;

        int numberLen = getNumberOfDigits(number);
        if(getNumberOfDigits(fang1) != numberLen / 2 || getNumberOfDigits(fang2) != numberLen / 2)
            return false;

        byte[] numberBytes = Long.toString(number).getBytes();
        byte[] fangBytes = (Long.toString(fang1) + Long.toString(fang2)).getBytes();
        Arrays.sort(numberBytes);
        Arrays.sort(fangBytes);
        return Arrays.equals(numberBytes, fangBytes);
    }

    public static void main(String[] args)
    {
        int vampireNumbercount=0;
        for(long i = 10; vampireNumbercount < 100; i++ )
	{
            if((getNumberOfDigits(i) % 2) != 0) 
              continue;
             for(long fang1 = 2; fang1 <= Math.sqrt(i) + 1 ; fang1++) 
	     {
                if (i % fang1 == 0) 
		{
                    long fang2 = i / fang1;//obtaining other factor i.e fang
                    if (checkFang(i, fang1, fang2) && fang1 <= fang2) 
		    {
                        vampireNumbercount++;
                        System.out.println(vampireNumbercount + ")  " + i);
                    }
                }
            }
        }
    }
}
