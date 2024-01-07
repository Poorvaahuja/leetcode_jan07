class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int total_count = 0;
        int n = nums.length;
        HashMap<Integer, Integer>[] dp = new HashMap[n]; // initialising a hashmap, each index represents the number of arithmetic subsequences ending at index i with a common difference of j
        for(int i=0; i<n; ++i){
            dp[i] = new HashMap<>();
        }
        for(int i=1; i<n; ++i){
            for(int j=0; j<i; ++j){
                long diff = (long)nums[i] - nums[j];
                if(diff > Integer.MAX_VALUE || diff < Integer.MIN_VALUE)
                    continue;
                int diffInt = (int) diff;
                dp[i].put(diffInt, dp[i].getOrDefault(diffInt, 0)+1);
                if(dp[j].containsKey(diffInt)){
                    dp[i].put(diffInt, dp[i].get(diffInt) + dp[j].get(diffInt));
                    total_count += dp[j].get(diffInt);
                }
            }
        }
        return total_count;
    }
}
