import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Created by tanyacouture on 5/14/15.
 */
public class SortTest extends TestCase{
    @Test
    public void testSelectionTest(){
        Integer[] array = {12, 1, 9, 3, 23, 8};
        Integer[] inOrder = {1, 3, 8, 9, 12, 23};
        SelectionSort s = new SelectionSort(array);
        assertArrayEquals(inOrder, s.getSort(array));
    }
    @Test
    public void testJavaSort(){
        Integer[] array = {12, 1, 9, 3, 23, 8};
        Integer[] inOrder = {1, 3, 8, 9, 12, 23};
        JavaSort s1 = new JavaSort(array);
        assertArrayEquals(inOrder, s1.getSort(array));
    }


}
