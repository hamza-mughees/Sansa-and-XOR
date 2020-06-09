import java.util.Arrays;

class Solution {
  public static void main(String[] args) {
    System.out.println(sansaXor(new int[]{98,74,12}));
  }

  static int sansaXor(int[] arr) {
    int n = arr.length;
    
    if (n%2 == 0) return 0;
    
    int xor = 0;
    for (int i=0; i<n; i+=2)
      xor ^= arr[i];
    
    return xor;
  }
}
