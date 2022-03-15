import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        //System.out.println("123");
        //int [] nums= new int[]{5,2,3,1};
        Solution solution=new Solution();
        //solution.sortArray(nums);
        //System.out.println(nums);
        String s = "ADOBECODEBANC", t = "ABC";
        int [] nums = new int []{4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(solution.search(nums,target));
    }
    public int[] sortArray(int[] nums) {
        quickSort(nums,0,nums.length-1);
        return nums;
    }
    public void quickSort(int[] nums,int lo,int hi){
        if(lo>=hi) return;
        int index= partition(nums,lo,hi);
        quickSort(nums,lo,index-1);
        quickSort(nums,index+1,hi);
    }
    public int partition(int [] nums, int lo, int hi){
        if(lo==hi){
            return lo;
        }
        int pivot=nums[lo];
        int i=lo;
        int j=hi+1;
        while(true){
            while(nums[++i]<pivot){
                if(i==hi) break;
            }
            while(nums[--j]>pivot){
                if(j==lo) break;
            }
            if(i>=j) break;
            swap(nums,i,j);
        }
        swap(nums,j,lo);
        return j;
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public double mySqrt(int x) {
        if(x==0){
            return 0;
        }
        if(x==1){
            return 1;
        }
        double left=1;
        double right=x;
        while(right-left>=0.01){
            double mid=left+(right-left)/2;
            if(mid<x/mid)
                left = mid+1;
            else if(mid>x/mid)
                right = mid-1;
            else{
                return mid;
            }
        }
        return left-1;
    }
    public String reverseWords(String s) {
        //去除空格
        StringBuilder sb= removeSpace(s);
        //反转全部
        reverseAllWord(sb,0,sb.length()-1);
        //反转单个词
        reverseword(sb);
        return sb.toString();
    }

    public StringBuilder removeSpace(String s){
        int start=0;
        int end=s.length()-1;
        while(s.charAt(start)==' ') start++;
        while(s.charAt(end)==' ') end--;
        StringBuilder sb= new StringBuilder();
        while(start<=end){
            char c= s.charAt(start);
            if(c!=' '||sb.charAt(sb.length()-1)!=' '){
                sb.append(c);
            }
            start++;
        }
        return sb;
    }

    public void reverseAllWord(StringBuilder s,int left,int right){
        while(left<right){
            char temp=s.charAt(left);
            s.setCharAt(left,s.charAt(right));
            s.setCharAt(right,temp);
            left++;
            right--;
        }
    }
    public void reverseword(StringBuilder sb){
        int left=0;
        int right=1;
        int n=sb.length();
        while(left<n){
            while(right<n&&sb.charAt(right)!=' '){
                right++;
            }
            reverseAllWord(sb,left,right-1);
            left=right+1;
            right=left+1;
        }
    }
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> need= new HashMap<>();
        HashMap<Character,Integer> window= new HashMap<>();
        int start=0;
        int end=0;
        int len= Integer.MAX_VALUE;
        int valid=0;
        int index=0;
        for(int i=0;i<t.length();i++){
            char ch= t.charAt(i);
            need.put(ch,need.getOrDefault(ch,0)+1);
        }
        while(end<s.length()){
            char c= s.charAt(end);
            end++;
            if(need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1);
                if(need.get(c).equals(window.get(c))){
                    valid++;
                }
            }
            while(need.size()==valid){
                if(end-start<len){
                    index=start;
                    len=end-start;
                }
                char d= s.charAt(start);
                start++;
                if(need.containsKey(d)){
                    if(need.get(d).equals(window.get(d))){
                        valid--;
                    }
                    window.put(d,window.get(d)-1);
                }
            }
        }
        return len==Integer.MAX_VALUE?"":s.substring(index,index+len);
    }
    public int search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while(left<right){
            int mid = (left+right)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]>nums[right]){
                if(nums[mid]>target && nums[mid]>nums[left]){
                    left=mid+1;
                }
                else{
                    right=mid;
                }
            }
            else{
                if(nums[mid]>target && nums[mid]>nums[left]){
                    right=mid;
                }
                else{
                    left=mid+1;
                }
            }
        }
        return -1;
    }
}
