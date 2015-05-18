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
        return sortMethod.getSort(list);
    }

    public static void main(String[] args){
        Integer[] array = {12, 1, 9, 3, 23, 8};

        //make array sorter whose strategy is Selection
        SortStrategy selectionType = SortStrategyFactory.makeSortStrategy("SelectionSort", array);
        ArraySorter sorter = new ArraySorter(array, selectionType);

        // run strategy pattern
        long beginningTime = System.nanoTime();
        sorter.getSort(array);
        long endTime = System.nanoTime() - beginningTime;
        // print time
        System.out.println("Selection sort time(strategy): " + endTime);

        //run factory pattern
        long beginningSFTime = System.nanoTime();
        selectionType.getSort(array);
        long endSFTime = System.nanoTime() - beginningSFTime;
        // print time
        System.out.println("Selection sort time(factory): " + endSFTime);


        // Java timing
        // Make an array sorter whose strategy is JavaSort
        SortStrategy javaType = SortStrategyFactory.makeSortStrategy("JavaSort", array);
        ArraySorter javaSort = new ArraySorter(array, javaType);

        long beginningJavaTime = System.nanoTime();
        javaSort.getSort(array);
        long totalJavaTime = System.nanoTime() - beginningJavaTime;
         // print time
        System.out.println("Java sort time(strategy):" + totalJavaTime);

        long beginningJFTime = System.nanoTime();
        javaType.getSort(array);
        long endJFTime = System.nanoTime() - beginningJFTime;
        // print time
        System.out.println("Selection sort time(factory): " + endJFTime);
    }
}
