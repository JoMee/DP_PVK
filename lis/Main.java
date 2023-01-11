
class Main {
  
  static int lis(int[] input) {
    //dp table
    int n = input.length;
    int[] dp = new int[n];

    //base cases
    for(int i = 0; i < n; i++) {
      dp[i] = 1;
    }
  
    //step
    for (int i = 0; i < n; i++) {
      for(int j = 0; j < i; j++) {
        if (input[j] < input[i]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
    }


    for( int i = 0; i< n; i++) {
      System.out.print(dp[i] + " ");
    }
    System.out.println();

    //extraction of solution:
    int max_element = 0;
    for (int i = 0; i < n; i++) {
      max_element = Math.max(max_element, dp[i]);
    }

    return max_element;
  }


  public static void main(String args[]) {

    int input[] = {10, 22, 9, 33, 21, 50, 41, 60};
    System.out.println(lis(input));

  }
}
