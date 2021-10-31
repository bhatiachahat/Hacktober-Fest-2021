class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer,int[]> mp=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
         if(!mp.containsKey(nums[i])){
           mp.put(nums[i],new int[]{1,i,i});//degree,first,last
         }
            else {
                int temp[]=mp.get(nums[i]);
                temp[0]++;
                temp[2]=i;
                
            }
        }
        int res=Integer.MAX_VALUE;
        int degree=Integer.MIN_VALUE;
        for(int key:mp.keySet()){
        int temp[]=mp.get(key);
            if(temp[0]>degree){
             degree=temp[0];
                res=temp[2]-temp[1]+1;
            }
            else if(temp[0]==degree){
               res=Math.min(res,temp[2]-temp[1]+1);
            }
        }
        return res;
    }
}
