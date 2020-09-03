class Solution {
    public String reverseWords(String s) {
        String res[]=s.split(" ");
        for(int i=0;i<res.length;i++){
            StringBuilder sb=new StringBuilder(res[i]);
            res[i]=new String(sb.reverse());
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<res.length;i++){
            if(i==res.length-1){
                sb.append(res[i]);
            }else{
                sb.append(res[i]).append(" ");
            }
        }
        return new String(sb);
    }
    
}