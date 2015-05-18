

/**
 * Created by tanyacouture on 5/13/15.
 */
public class SelectionSort extends SortStrategy{
    Integer[] list;

    public SelectionSort(Integer[] list){
        this.list = list;
    }

    public Integer[] getSort(Integer[] list){
        // beginning time

        // Selection sort: O(n^2) sorting algorithm
        // Sort number of values in list
        for(int i = 0; i < this.list.length; i++){
            // smallest value stored in i
            int smallest_index = i;

            // initiate j to the 2nd value in the list to compare to the rest of the list
            for(int j = i + 1; j < this.list.length; j++){
                // if the compared value is smaller than the original minimum, change the compared value to the new minimum
                if (this.list[j] < this.list[smallest_index]){
                    smallest_index = j;
                }
                //swap places, put the new smallest index in the sorted portion of the list
                // assign smallest value to a temporary variable
                    int tmp = list[smallest_index];
                    list[smallest_index] = list[i];
                // place smallest in sorted part of list
                list[i] = tmp;

            }
        }
            return list;
    }
}
