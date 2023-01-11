
class Main {
  
  static boolean solve(int[] input, int n) {

    int A = 0;
    for (int i = 0; i < input.length; i++) {
      A += input[i];
    }

    if(A % 3 != 0) {
      return false;
    }

    boolean[][][] dp = new boolean[input.length + 1][A/3 + 1][A/3 + 1];

    //DP[i][a][b] = input[0] ... input[i-1] können wir summen machen der grössen a und b.
    
    //base case
    for(int i = 0; i < input.length + 1; i++) {
      dp[i][0][0] = true;
    }

    //step
    for (int i = 1; i < input.length + 1; i++) {
      for (int a = 0; a < A/3 + 1; a++) {
        for (int b = 0; b < A/3 + 1; b++) {
          int val_a = a - input[i-1]; 
          
          if (val_a >= 0) {
            dp[i][a][b] = dp[i-1][val_a][b];
          }

          int val_b = b - input[i-1]; 
          
          if (val_b >= 0) {
            dp[i][a][b] = dp[i-1][a][val_b] || dp[i][a][b];
          }
          dp[i][a][b] = dp[i][a][b] || dp[i-1][a][b];
        }
      }
    }


    
    //solution:
    return dp[input.length][A/3][A/3];
  }


  public static void main(String args[]) {
    int n = 7;
    int[] input = {2, 4, 8, 1, 4, 5, 3};

    System.out.println(solve(input, n));
  }
}
