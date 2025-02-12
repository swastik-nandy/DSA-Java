import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
      HashMap<Integer,Integer>map=new HashMap<>();

      for(int i=0;i<nums.length;i++){
          int complement=target-nums[i];

          if(map.containsKey(complement))
             return new int[]{map.get(complement),i};   

          map.put(nums[i],i);
      }
      return new int[]{-1,-1};
    }
        
    public static void main(String args[]){
        Scanner in=new Scanner(System.in);
        System.out.println("Enter array size :");
        int s=in.nextInt();
        int a[]=new int[s];
        System.out.println("Enter array elements :");
        for(int i=0;i<s;i++)
        a[i]=in.nextInt();
        System.out.println("Enter target :");
        int t=in.nextInt();
        Solution ob=new Solution();
        int result[]=ob.twoSum(a,t);
        for(int i=0;i<result.length;i++)
        {
            if(i!=result.length-1)
            System.out.print(result[i]+",");
            else
            System.out.print(result[i]);

    }
           
in.close();
    }
}
