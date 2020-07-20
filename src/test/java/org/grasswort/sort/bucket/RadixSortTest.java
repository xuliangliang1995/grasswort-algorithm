package org.grasswort.sort.bucket;

import org.grasswort.sort.IMathArraySort;
import org.grasswort.sort.util.IntArrayUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author xuliangliang
 * @Description
 * @Date 2020/7/20
 */
class RadixSortTest {

    private IMathArraySort radixSort;

    @BeforeEach
    void setUp() {
        radixSort = new RadixSort();
    }

    @AfterEach
    void tearDown() {
        radixSort = null;
    }

    @RepeatedTest(1000)
    void sort() {
        int[] array = IntArrayUtil.randomArray(10000, 0, 999);
        int[] duplicate = IntArrayUtil.copyArray(array);
        radixSort.sort(array);
        Arrays.sort(duplicate);
        assertTrue(IntArrayUtil.isEqual(array, duplicate));
    }

}