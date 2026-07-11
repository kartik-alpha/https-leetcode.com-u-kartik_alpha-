class Solution {
    public int climbStairs(int n) {


        /*   
        //base case 
         if( n <= 2) 
            return n; 
            //rr
            int ans  = climbStairs(n -1 ) + climbStairs(n -2);

            return ans;


        */

        if( n <= 2) 
            return n;

            int prev1 = 1;
            int prev2 = 1;

            for(int i = 2; i <= n;i++) {
                int current = prev1 + prev2;
                prev2 = prev1;
                prev1  = current;
            }

            return prev1;
    }

}