
class Main {
  
  static int lcs(int[] a, int[] b) {
    int[][] dp = new int[a.length + 1][b.length + 1];

    //base cases:
    for(int i = 0; i < a.length + 1; i++) {
      dp[i][0] = 0;
    }
    for(int i = 0; i < b.length + 1; i++) {
      dp[0][i] = 0;
    }

    //step:
    for(int i = 1; i < a.length + 1; i++) {
      for(int j = 1; j < b.length + 1; j++) {
        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        if (a[i-1] == b[j-1]) {
          dp[i][j] = Math.max(dp[i][j], 1 + dp[i-1][j-1]);
        }
      }
    }

    for(int i = 1; i < a.length + 1; i++) {
      for(int j = 1; j < b.length + 1; j++) {
        System.out.print(dp[i][j] + " ");
      }
      System.out.println();
    }
    return dp[a.length][b.length];


  }


  public static void main(String args[]) {

    int a[] = {7, 6, 3, 2, 8, 4, 5, 1};
    int b[] = {3, 9, 10, 8, 7, 1, 2, 6, 4, 5};
    System.out.println(lcs(a, b));

  }
}
