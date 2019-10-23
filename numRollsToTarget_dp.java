package ama_aTest;

import java.util.*;

public class RollsToTarget {

	public static void main(String[] args) {
//		int d = 1, f = 6, target = 3;
		int d = 2, f = 6, target = 7;
		RollsToTarget a = new RollsToTarget();
		System.out.println(a.numRollsToTarget(d, f, target));
		System.out.println(a.numRollsToTarget_dp(d, f, target));
	}

	public int numRollsToTarget_dp(int d, int f, int target) {
        int MOD = 1000000007;
        int[][] dp = new int[d + 1][target + 1]; 
        dp[0][0] = 1;
	
        for(int i = 1; i <= d; i++) {
            for(int j = 1; j<= target; j++) {
                if(j > i * f) {
                   continue;          
                } else {                  
                    for(int k = 1; k <= f && k <= j ; k++) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - k]) % MOD; 
                        System.out.println(" dp["+i+"]["+j+"] "+ dp[i][j]+" "+dp[i][j]+" "+
                        		"dp["+i+"- 1]["+j+" -"+k+"]: "+dp[i - 1][j - k] +"%"+" MOD "+MOD+ " : "
                        		+" (dp[i][j] + dp[i - 1][j - k]) "+(dp[i][j] + dp[i - 1][j - k])+" :"
                        		+(dp[i][j] + dp[i - 1][j - k]) % MOD);
                    }
                }
            }
        }
        return dp[d][target];
    }

	int MOD = 1000000000 + 7;
	Map<String, Integer> memo = new HashMap<>();

	public int numRollsToTarget(int d, int f, int target) {
		if (d == 0 && target == 0) {
			return 1;
		}
		if (d == 0 || target == 0) {
			return 0;
		}
		String str = d + " " + target;
		if (memo.containsKey(str)) {
			return memo.get(str);
		}
		int res = 0;
		for (int i = 1; i <= f; i++) {
			if (target >= i) {
				res = (res + numRollsToTarget(d - 1, f, target - i)) % MOD;
			} else {
				break;
			}
		}
		memo.put(str, res);
		return res;
	}
}
