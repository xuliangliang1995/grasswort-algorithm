package org.grasswort.sort;

import org.grasswort.sort.util.IntArrayUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author xuliangliang
 * @Description
 * @Date 2020/7/18
 */
public class MergerSortTest {

    private IMathArraySort mergerSort;

    @BeforeEach
    void setUp() {
        mergerSort = new MergerSort();
    }

    @AfterEach
    void tearDown() {
        mergerSort = null;
    }

    @RepeatedTest(1000)
    void sort() {
        int[] array = IntArrayUtil.randomArray(10000, Integer.MIN_VALUE, Integer.MAX_VALUE);
        int[] duplicate = IntArrayUtil.copyArray(array);
        mergerSort.sort(array);
        Arrays.sort(duplicate);
        assertTrue(IntArrayUtil.isEqual(array, duplicate));
    }
}
