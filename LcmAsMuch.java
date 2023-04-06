import java.util.*;
public class LcmAsMuch
{
    private static void two(int [] val){
        int prod = val[0] * val[1];
        int hcf = 1;
        for(int i = 1; i <= Math.min(val[0], val[1]); i ++)
        {
            if(val[0] % i == 0 && val[1] % i == 0)
            {
                hcf = i;
            }
        }
        int lcm = prod / hcf;
        System.out.println("LCM is: " + lcm);
    }
    private static void power(int [] val){
        int [] prods = new int[val.length/2];
        int [] hcfs = new int[val.length/2];
        int [] lcms = new int[val.length/2];
        for(int i = 0; i < val.length/2; i ++)
        {
            prods[i] = val[i*2] * val[(i*2) + 1];
            for(int j = 1; j <= Math.min(val[i*2], val[i*2 + 1]); j ++)
            {
                if(val[i*2] % j == 0 && val[(i*2)+1] % j == 0)
                {
                    hcfs[i] = j;
                }
            }
            lcms[i] = prods[i] / hcfs[i];
        }
        if(lcms.length == 1)
        {
            System.out.println("The lcm is: " + lcms[0]);
        }
        else if(lcms.length == 2)
        {
            two(lcms);
        }
        else if(lcms.length % 2 == 0)
        {
            if(powCheck(lcms.length))
            {
                power(lcms);
            }
            else
            {
                even(lcms);
            }
        }
        else
        {
            odd(lcms);
        }
    }
    private static void even(int [] val){
        int [] prods = new int[val.length/2];
        int [] hcfs = new int[val.length/2];
        int [] lcms = new int[val.length/2];
        for(int i = 0; i < val.length/2; i ++)
        {
            prods[i] = val[i*2] * val[(i*2) + 1];
            for(int j = 1; j <= Math.min(val[i*2], val[i*2 + 1]); j ++)
            {
                if(val[i*2] % j == 0 && val[(i*2)+1] % j == 0)
                {
                    hcfs[i] = j;
                }
            }
            lcms[i] = prods[i] / hcfs[i];
        }
        if(lcms.length == 1)
        {
            System.out.println("The lcm is: " + lcms[0]);
        }
        else if(lcms.length == 2)
        {
            two(lcms);
        }
        else if(lcms.length % 2 == 0)
        {
            if(powCheck(lcms.length))
            {
                power(lcms);
            }
            else
            {
                even(lcms);
            }
        }
        else
        {
            odd(lcms);
        }
    }
    private static void odd(int [] val){
        int [] prods = new int[(val.length+1)/2];
        int [] hcfs = new int[(val.length+1)/2];
        int [] lcms = new int[(val.length+1)/2];
        for(int i = 0; i < (val.length+1)/2; i ++)
        {
            if((i+1) >= ((val.length +1)/2))
            {
                lcms[i] = val[val.length - 1];
            }
            else
            {
                prods[i] = val[i*2] * val[(i*2) + 1];
                for(int j = 1; j <= Math.min(val[i*2], val[i*2 + 1]); j ++)
                {
                    if(val[i*2] % j == 0 && val[(i*2)+1] % j == 0)
                    {
                        hcfs[i] = j;
                    }
                }
                lcms[i] = prods[i] / hcfs[i];
            }
        }
        if(lcms.length == 1)
        {
            System.out.println("The lcm is: " + lcms[0]);
        }
        else if(lcms.length == 2)
        {
            two(lcms);
        }
        else if(lcms.length % 2 == 0)
        {
            if(powCheck(lcms.length))
            {
                power(lcms);
            }
            else
            {
                even(lcms);
            }
        }
        else
        {
            odd(lcms);
        }
    }
    private static boolean powCheck(int a)
    {
        boolean result = false;
        for(int i = 1; i <= a; i ++)
        {
            int num = (int)Math.pow(2, i);
            if(num == a)
            {
                result = true;
            }
        }
        return result;
    }
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many numbers lcm you wish to calculate: ");
        int count = sc.nextInt();
        int [] val = new int[count];
        for(int i = 0; i < count; i ++)
        {
            System.out.println("Enter number " + (i + 1) + ": ");
            val[i] = sc.nextInt();
        }
        if(count < 2){
            System.out.println("Lcm of " + count + " no. of terms is not possible");
        }
        else if(count == 2){
            two(val);
        }
        else if(count % 2 == 0){
            if(powCheck(count)){
                power(val);
            }
            else{
                even(val);
            }
        }
        else
        {
            odd(val);
        }
    }
}
