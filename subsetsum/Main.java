
class Main {
  
  static boolean subsetsum(int[] input, int sum) {
    boolean dp[][] = new boolean[input.length + 1][sum+1];

    //base cases:
    for (int i = 0; i < input.length + 1; i++) {
      dp[i][0] = true;
    }

    //step:
    for(int i = 1; i < input.length + 1; i++) {
      for(int j = 1; j < sum + 1; j++) {
        dp[i][j] = dp[i-1][j];
        
        if (j - input[i-1] >= 0) {
          dp[i][j] = dp[i-1][j - input[i-1]] || dp[i][j];
        }
      }
    }


    for(int i = 0; i < input.length + 1; i++) {
      for(int j = 0; j < sum + 1; j++) {
        System.out.print(dp[i][j] + " ");
      }
      System.out.println();
    }

    return dp[input.length][sum];
  }


  public static void main(String args[]) {

    int input[] = {3, 34, 4, 12, 5, 2};
    int sum = 9;
    System.out.println(subsetsum(input, sum));

  }
}
