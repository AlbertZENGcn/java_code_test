import java.util.PriorityQueue;

class TopK {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq= new PriorityQueue<>((a,b)->(a-b));
        TopK topK= new TopK();
        int [] nums=new int [] {3,2,1,5,6,4};
        int k=4;
        topK.findKthLargest(nums,k);
    }
    public int findKthLargest(int[] nums, int k) {
        int lo=0,hi=nums.length-1;
        k=nums.length-k;
        while(lo<=hi){
            int index=partition(nums,lo,hi);
            if(index<k){
                lo=index+1;
            }
            else if(index>k){
                hi=index-1;
            }
            else{
                return nums[index];
            }
        }
        return -1;
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
}
