class Solution {
    public int lengthOfLongestSubstring(String s) {
        // List<Character> list=new ArrayList<>();
        // int listsize=0;
        // char c[]=s.toCharArray();
        // for(int i=0;i<c.length;i++){
        //     list.add(c[i]);
        //     for(int j=i+1;j<c.length;j++){
        //         if(list.contains(c[j])){
        //             break;
        //         }else{
        //             list.add(c[j]);
        //         }
        //     }
        //     if(list.size()>listsize){
        //         listsize=list.size();
        //     }
        //     list=new ArrayList();
        // }
        // return listsize;

        // Set que=new HashSet();
        // int i=0;
        // int sz=0;
        // int rz=0;
        // while(i<s.length()){
        //     if(i!=0){
        //         que.remove(s.charAt(i-1));
        //     }
        //     while(rz<s.length() && !que.contains(s.charAt(rz))){
        //         que.add(s.charAt(rz++));
        //     }
        //     i++;
        //     if(que.size()>sz){
        //         sz=que.size();
        //     }

        // }
        // return sz;
        // Set<Character> occ = new HashSet<Character>();
        // int n = s.length();
        // // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        // int rk = -1, ans = 0;
        // for (int i = 0; i < n; ++i) {
        //     if (i != 0) {
        //         // 左指针向右移动一格，移除一个字符
        //         occ.remove(s.charAt(i - 1));
        //     }
        //     while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
        //         // 不断地移动右指针
        //         occ.add(s.charAt(rk + 1));
        //         ++rk;
        //     }
        //     // 第 i 到 rk 个字符是一个极长的无重复字符子串
        //     ans = Math.max(ans, rk - i + 1);
        // }
        // return ans;
          // 记录字符上一次出现的位置
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