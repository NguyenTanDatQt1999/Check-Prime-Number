package edu.fa;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) throws Exception{
        int[] a = {2, 3, 5, 6, 9, 11};
        
        int sum = 0;
        for (int x : a)
        	if(Utils.checkNT(x) == true)
        		sum += x;
        System.out.println(sum);
    }
}
