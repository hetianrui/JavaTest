class Solution {
    public int addDigits(int num) {
        if(num<10){
            return num;
        }
        int res=0;
        while(num>0){
            res=res+num%10;
            num/=10;
        }
        if(res>=10){
            return addDigits(res);
        }
        return res;
    }
}