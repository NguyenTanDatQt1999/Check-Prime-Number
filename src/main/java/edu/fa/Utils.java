package edu.fa;

public class Utils {
	public static boolean checkNT(int n) throws Exception {
		if(n < 0)
			throw new Exception();
		if(n >= 2) {
			for(int i = 2; i <= Math.sqrt(n); i++)
					if(n % i == 0)
						return false;
			return true;
		}
		return false;
	}
}