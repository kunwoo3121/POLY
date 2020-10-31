import java.util.Scanner;
public class POLY {
	static int mdr = 10000000;
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		int[][] cache = new int[101][101];
		int[] result = new int[101];
		
		
		cache[1][1] = 1;
		result[1] = 1;
		
		for(int i = 2; i < 101; i++)
		{
			for(int j = 1; j <= i; j++)
			{
				if(i == j)
				{
					cache[i][j] = 1;
					result[i] += cache[i][j];
					result[i] %= mdr;
					continue;
				}
				for(int k = 1; k <= i-j; k++)
				{
					cache[i][j] += cache[i - j][k] * (j + k - 1);
					cache[i][j] %= mdr;
				}
				result[i] += cache[i][j];
				result[i] %= mdr;
			}
		}
		
		int c = sc.nextInt();
		
		for(int i = 0; i < c; i++)
		{
			int n = sc.nextInt();
			
			System.out.println(result[n]);
		}
	}

}
