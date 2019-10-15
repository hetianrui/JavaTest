public class ArrayUtils{
    
    public static int arrayMaxElement(int[] date){
        int max=0;
        for(int i=0;i<date.length;i++){
        if(date[i]>max){
            max=date[i];
        }
        }
       return max;
   }
   public static void main(String[] args){
       int[] date=new int[]{12,32,33,44};
      
       System.out.println(arrayMaxElement(date));
       }
    }