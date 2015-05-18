import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertArrayEquals;

/**
 * Created by tanyacouture on 5/14/15.
 */
public class SortTest extends TestCase{
    @Test
    public void testSelectionStrategy(){
        Integer[] array = {12, 1, 9, 3, 23, 8};
        Integer[] inOrder = {1, 3, 8, 9, 12, 23};
        SelectionSort s = new SelectionSort(array);
        assertArrayEquals(inOrder, s.getSort(array));
    }
    @Test
    public void testJavaStrategy(){
        Integer[] array = {12, 1, 9, 3, 23, 8};
        Integer[] inOrder = {1, 3, 8, 9, 12, 23};
        JavaSort s1 = new JavaSort(array);
        assertArrayEquals(inOrder, s1.getSort(array));
    }

    @Test
    public void testSelectionFactory() {
        Integer[] array = {12, 1, 9, 3, 23, 8};
        Integer[] inOrder = {1, 3, 8, 9, 12, 23};

        //make array sorter whose strategy is Selection
        SortStrategy selectionType = SortStrategyFactory.makeSortStrategy("SelectionSort", array);
        assertArrayEquals(inOrder, selectionType.getSort(array));
    }
    @Test
    public void testJavaFactory() {
        Integer[] array = {12, 1, 9, 3, 23, 8};
        Integer[] inOrder = {1, 3, 8, 9, 12, 23};

        SortStrategy selectionJavaType = SortStrategyFactory.makeSortStrategy("JavaSort", array);
        assertArrayEquals(inOrder, selectionJavaType.getSort(array));
    }



}
