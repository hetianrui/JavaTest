class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(nums.length==0 || k==0 ) return new int[0];
        Map<Integer,Integer> map=new HashMap<>();
        for(int a: nums){
            int c=map.getOrDefault(a,0);
            map.put(a,c+1);
        }
        Node res[]=new Node[map.size()];
        int i=0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
                res[i++]=new Node(entry.getKey(),entry.getValue());    
        }
        return quick(res,0,res.length-1,k-1);
    }
    public static int[] quick(Node []nums,int left,int right,int k){
        int j=quickSort(nums,left,right);
        if(j==k){
            int res[]=new int[k+1];
            for(int i=0;i<res.length;i++){
                res[i]=nums[i].k;
            }
            return res;
        }
        return j>k ? quick(nums,left,j-1,k) : quick(nums,j+1,right,k);
    }
    public static int quickSort(Node []nums,int left,int right){       
        int l=left;
        int r=right;
        Node max=nums[l];
        while(l<r){
            while(l<r && nums[r].v <= max.v){
                r--;
            }
            if(l<r) nums[l]=nums[r];
            while(l<r && nums[l].v >= max.v){
                l++;
            }
            if(l<r) nums[r]=nums[l];
        }
        nums[l]=max;
        return l;
    }
}
class Node{
    int k;
    int v;
    public Node(int k,int v){
        this.k=k;
        this.v=v;
    } 
}