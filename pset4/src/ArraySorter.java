import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by tanyacouture on 5/13/15.
 */
public class ArraySorter {

    Integer[] list;
    SortStrategy sortMethod;

    public ArraySorter(Integer[] list, SortStrategy sortMethod) {
        this.list = list;
        this.sortMethod = sortMethod;
    }


    public Integer[] getSort(Integer[] list) {
        //public ArrayList[] getSort(ArrayList[] list){
        return sortMethod.getSort(list);
    }


    public static void main(String[] args){
        Integer[] array = {12, 1, 9, 3, 23, 8};

        //make array sorter whose strategy is s2
        SelectionSort s2 = new SelectionSort(array);
        ArraySorter sorter = new ArraySorter(array, s2);

        long beginningTime = System.nanoTime();
        sorter.getSort(array);
        long endTime = System.nanoTime() - beginningTime;
        // print time
        System.out.println("Selection sort time: " + endTime);


        // Java timing

        // Make an array sorter whose strategy is j2
        JavaSort j2 = new JavaSort(array);
        ArraySorter sorter2 = new ArraySorter(array, j2);
        long beginningJavaTime = System.nanoTime();
        sorter2.getSort(array);
        long totalJavaTime = System.nanoTime() - beginningJavaTime;
         // print time
        System.out.println("Java sort time:" + totalJavaTime);
    }
}
