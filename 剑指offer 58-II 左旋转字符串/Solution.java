class Solution {
    public String reverseLeftWords(String s, int n) {
        // char a[]=s.toCharArray();
        // char b[]=new char[a.length];
        // for(int i=0;i<a.length-n;i++){
        //     b[i]=a[i+n];
        // }
        // int j=0;
        // // 
        // int k=a.length-n;
        // for(;k<a.length;){
        //     b[k++]=a[j++];
        // }
    
        // return new String(b);
        return (s+s).substring(n,(s.length()+n));
    }
}