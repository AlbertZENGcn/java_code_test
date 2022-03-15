public class quicksort {
    public static void sort(int a[],int low, int high){
        int i,j,index;
        if(low>high){
            return;
        }
        i = low;
        j = high;
        index = a[i];
        while(i<j){
            while(i<j && a[j]>=index){
                j--;
            }
            if(i<j){
                a[i++]=a[j];
            }
            while(i<j && a[j]< index){
                i++;
            }
            if(i<j){
                a[j--]=a[i];
            }
        }
        a[i]=index;
        sort(a,low,i-1);
        sort(a,i+1,high);
    }

    public static void main(String[] args) {
        int [] nums= new int [] {2,1,3,4,6};
        sort(nums,0, nums.length-1);
        for(int num :nums){
            System.out.println(num);
        }

    }
}
