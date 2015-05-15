import java.util.Arrays;

/**
 * Created by tanyacouture on 5/14/15.
 */

public class MergeSort implements SortStrategy{
    Integer[] list;
   // SortStrategy sortMethod;

    public MergeSort(Integer[] list){
        this.list = list;
      //  this.sortMethod = sortMethod;
    }
    // code borrowed from study.cs50.net
    // function that will call on sort perform merge sort
    public Integer[] getSort(Integer[] list) {
        return mergeSort(list);
    }
       // for(int i = 0; i < this.list.length; i ++){
         //   sort(list, 0, this.list.length - 1);
       // }
       // return list;
    //}

    // code borrowed from study.cs50.net and cs.cmu.edu
    public Integer[] mergeSort(Integer[] list){
        // create temporary array to perform merge
        Integer[] temporary = new Integer[list.length];
        return sort(list, temporary, 0, list.length - 1);
    }



    // sort sorts the list and calls on merge to merge the sorted integers
    public  Integer[] sort(Integer[] list, Integer[] temporary, Integer start, Integer end){
        Integer[] revisedList= null;
        Integer middle = 0;
        Integer middlePlus = 0;
        if(end > start){
            middle = (start + end)/2;
            middlePlus = middle + 1;

            // sort left half
            sort(list, temporary, start, middle);

            // sort right half
            sort(list, temporary, middlePlus, end);


        }
        // merge
        return merge(list, temporary, start, middlePlus, end);
    }

    // most of merge code borrowed from cs.cmu.edu
    public Integer[] merge(Integer[] list, Integer[] temporary, Integer start, Integer middlePlus, int end) {
        Integer endofStart = middlePlus - 1;
        Integer copyStart = start;
        Integer listLength = list.length;

        // iterate through the 2 halves
        while(start <= endofStart && middlePlus <= end) {
            // if the start half is less than the end half(array), add integer to start side
            if (list[start].compareTo(list[middlePlus]) <= 0) {
                temporary[copyStart++] = list[start++];
            } else {
                // else add to the end half
                temporary[copyStart++] = list[middlePlus++];
            }
            // copy more of first half
            while (start <= endofStart) {
                temporary[copyStart++] = list[start++];
            }
            // copy more of the second half
            while (middlePlus <= end) {
                temporary[copyStart++] = list[middlePlus++];
            }
            // copy the full array to list
            for (int i = 0; i < listLength; i++, end--){
                list[end] = temporary[end];
            }
        }
        return list;
    }
       // int leftEnd = right -1;
        //int k = left;
       // int num = rightEnd - left + 1;

        // While there are elements in both subarrays
       // while(start > 0 && middlePlus > 0){
            // Compare numbers at the start of the subarrays
            // Append smaller to merged array
          //  if(start > middlePlus){
         //       temporary[0] = start;
       //     }
            //else{
            //    temporary[0] = middlePlus;
          //  }
        //while(start > 0 || middlePlus > 0){
         //   merge(temporary, start, middle, middlePlus, end);
       //     }
     //   }



        // While elements remain in subarray 1 (not subarray2), append each element to merged array
     //   return list;
   // }

}
