/**
 * Created by tanyacouture on 5/18/15.
 */
public class SortStrategyFactory {

    public static SortStrategy makeSortStrategy(String newStrategyType, Integer[] list){
        //SortStrategy aStrategy = null;

        // if strategy is SelectionSort
        if(newStrategyType.equals("SelectionSort")){
            return new SelectionSort(list);
        }
        // if strategy is JavaSort
        if(newStrategyType.equals("JavaSort")){
            return new JavaSort(list);
        }
        else return null;
    }
}
