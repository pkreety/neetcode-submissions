class Solution {
    HashMap<Integer, Integer> map = new HashMap<>(); 
    public int numDecodings(String s) {
        //   12     3 4    21  
        //12, 1,2,  3, 4, 21, 2,1
        // LCDX,  ABCDX, LCDBA, ABCDBA
        if (s.length() == 1) {
            if (s.charAt(0) == '0') {
                return 0;
            }
            return 1;
        }

        return dfs(s, 0);
    }

    private int dfs(String s, int i) { // 11
        if (i>=s.length()) {
            return 1;
        }
        char ch = s.charAt(i);// 1
        if (ch == '0') {
            return 0;
        }

        if (map.containsKey(i)) {
            return map.get(i);
        }

        int result;
        if ( i+1 < s.length() && (ch == '1' || (ch == '2' && s.charAt(i+1) - '0' < 7))) {
           result = dfs(s, i+1) + dfs(s, i+2); 
        } else {
            result = dfs(s, i+1);
        }
         

        map.put(i, result);
        System.out.println(result);
        return map.get(i);
    }
}
