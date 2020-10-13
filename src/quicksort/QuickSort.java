package quicksort;
import java.io.PrintStream;
import java.util.*;
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {98, 90, 86, 76, 62, 54, 49, 37, 26, 23, 21, 19, 12, 11, 9, 9, 3, 3};       
        shuffleArray(arr);
        System.out.println("Initial Array: ");
        System.out.println(Arrays.toString(arr));
        System.out.println("\nQuick Sort Begins: \n");
        quickSort(arr, 0, arr.length-1);
        System.out.println("\nQuick Sort Ends: \n");
        System.out.println("Sorted Array: ");
        System.out.println(Arrays.toString(arr));
    }
    public static void quickSort(int[] a, int b, int t){
        if(b < t){
            int pi = partitionFirst(a, b, t);            
            quickSort(a, b, pi-1);
            quickSort(a, pi+1, t);
        }
    }
    public static int partitionMedian(int[] a, int l, int h){//Median        
        int p = (l+h)/2;
        int pvt = a[p];
        int i = l;
        int j = h;
        int temp = 0;
        int[] subArr = Arrays.copyOfRange(a, l, h+1);
        System.out.println("Partitioning: "+Arrays.toString(subArr)+". on median Pivot: "+pvt);
        while(i < j){
            while(a[i] < pvt){                  
                ++i;                          
            }
            while(a[j] > pvt){
                --j;
                if(j==0) break;
            }
            if(i < j){
                temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
            
        }
        subArr = Arrays.copyOfRange(a, l, h+1);
        System.out.println(Arrays.toString(subArr));
        //System.out.println("i: "+i+", j:"+j);
        return i;
    }
    public static int partitionFirst(int[] a, int l, int h){
        int p = l;
        int pvt = a[p];
        int i = l+1;
        int j = h;
        int temp = 0;
        int[] subArr = Arrays.copyOfRange(a, l, h+1);
        System.out.println("Partitioning: "+Arrays.toString(subArr)+". on First Element as Pivot: "+pvt);
        try{
            while(i < j){
                while(a[i] < pvt){                  
                    ++i;
                    if(i>h) {
                        i=h;
                        break;
                    }
                }
                while(a[j] > pvt){
                    --j;                
                }
                if(i < j){                
                    temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;
                    //if(a[i]==a[j]) ++i;
                }

            }
            if(i > j){
                temp = a[j];
                a[j] = pvt;
                a[p] = temp;
            }
            if(i == j){
                if(pvt > a[i]){
                    temp = a[j];
                    a[j] = pvt;
                    a[p] = temp;
                }
            }
        }catch(Exception e){
            System.out.println(e.toString());
        }
        subArr = Arrays.copyOfRange(a, l, h+1);
        System.out.println(Arrays.toString(subArr));
        //System.out.println("i: "+i+", j:"+j);
        return j;
    }
    private static void shuffleArray(int[] array)
    {
        int index, temp;
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--)
        {
            index = random.nextInt(i + 1);
            temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }
}
