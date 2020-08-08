class Solution {
    public char firstUniqChar(String s) {
        int temp[]=new int[26];
        char str[]=s.toCharArray();
        for(char c: str){
            temp[c-'a']++;
        }
        for(char c:str){
            if(temp[c-'a']==1){
                return c;
            }
        }
         return ' ';

    }
}