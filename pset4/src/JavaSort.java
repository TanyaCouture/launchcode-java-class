import java.util.Arrays;

/**
 * Created by tanyacouture on 5/15/15.
 */
public class JavaSort implements SortStrategy {
    Integer[] list;

    public JavaSort(Integer[] list) {
            this.list = list;
        }

    @Override
    public Integer[] getSort(Integer[] list) {
        //long beginingTime = System.nanoTime();

        Arrays.sort(list);

        return list;
    }
}
