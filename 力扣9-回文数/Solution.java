class Solution {
    public boolean isPalindrome(int x) {
        if(x<0 || (x!=0 && x%10==0)){
            return false;
        }
        int i=0;
        while(x>i){
            int j=x%10;
            i=i*10+j;
            x/=10;
        }
        return x==i || x==i/10;
    }
}