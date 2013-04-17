package se.strolle.euler.problems.p018;


public class PyramidSum {
	static int[][] input = new int[][] {
{75},
{95,64},
{17,47,82},
{18,35,87,10},
{20,04,82,47,65},
{19,01,23,75,03,34},
{88,02,77,73,07,63,67},
{99,65,04,28,06,16,70,92},
{41,41,26,56,83,40,80,70,33},
{41,48,72,33,47,32,37,16,94,29},
{53,71,44,65,25,43,91,52,97,51,14},
{70,11,33,28,77,73,17,78,39,68,17,57},
{91,71,52,38,17,14,91,43,58,50,27,29,48},
{63,66,04,68,89,53,67,30,73,16,69,87,40,31},
{04,62,98,27,23,9,70,98,73,93,38,53,60,04,23}};
	
	static long[][] sum = new long[input.length][];

	public static void main(String[] args) {
		long result = 0;
		
		for (int row =0; row<input.length;row++){
			sum[row]=new long[input[row].length];
			for (int col =0; col<input[row].length;col++){
				long val=input[row][col];
				long bestPrevious = 0L;
				if (row-1 >=0){
					if(input[row-1].length > col)
						bestPrevious = sum[row-1][col];
					if(col-1 >= 0 && sum[row-1][col-1] > bestPrevious)
						bestPrevious = sum[row-1][col-1];
				}
				val+=bestPrevious;
				sum[row][col]=val;
				if(row+1==input.length && val>result)
					result=val;
			}			
		}

		System.out.println("Result: " + result);
		
		for (int row =0; row<sum.length;row++){
			for (int col =0; col<sum[row].length;col++){
				System.out.print(sum[row][col] + ",");
			}
			System.out.println();
		}
		System.exit(0);
	}

}
