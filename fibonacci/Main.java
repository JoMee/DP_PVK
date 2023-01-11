
class Main {
  
  static long fib(int n) {
    if (n == 0 || n == 1) {
      return 1;
    }
    long[] dp = new long[n];
    
    //base cases
    dp[0] = 1;
    dp[1] = 2;

    //computation of entries:

    for (int i = 2; i < n; i++) {
      dp[i] = dp[i-1] + dp[i-2];
    }

    //extraction of solution:
    return dp[n-1];
  }


  public static void main(String args[]) {
    
    for (int i = 0; i < 80; i++) {
      System.out.println(fib(i));
    }

  }
}
