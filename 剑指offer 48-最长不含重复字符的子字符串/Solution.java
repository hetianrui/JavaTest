class Solution {
    public int lengthOfLongestSubstring(String s) {
        // if("".equals(s)){
        //     return 0;
        // }
        // if(" ".equals(s)){
        //     return 1;
        // }
        // Queue<Character> que=new LinkedList<>();
        // int i=0;
        // int max=0;
        // while( i < s.length() ){
        //     char c=s.charAt(i);
        //     if(!que.contains(c)){
        //         que.add(c);
        //     }else{
        //         while(que.contains(c)){
        //             que.poll();
        //         }
        //         que.add(c);
        //     }
        //     max=Math.max(que.size(),max);
        //     i++;
        // }
        // return max;
        int[] last = new int[128];
        for(int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();
        int res = 0;
        int start = 0; // 窗口开始位置
        for(int i = 0; i < n; i++) {
            int index = s.charAt(i);
            start = Math.max(start, last[index] + 1);
            res   = Math.max(res, i - start + 1);
            last[index] = i;
        }
        return res;
    }
}