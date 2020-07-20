package org.grasswort.sort.bucket;

import org.grasswort.sort.IMathArraySort;
import org.grasswort.sort.util.IntArrayUtil;

/**
 * @author xuliangliang
 * @Description 基数排序
 * @Date 2020/7/20
 */
public class RadixSort implements IMathArraySort {
    /**
     * 数组排序, 等同于 Arrays.sort(int[] array)
     *
     * @param array
     */
    @Override
    public void sort(int[] array) {
        boolean bo = true;
        int divisor = 10;
        while (bo) {
            bo = false;
            // [0, 1, 2]
            int[] counter = new int[10];
            for (int i = 0; i < array.length; i++) {
                bo = bo || array[i] / divisor >= 1;
                int mod = array[i] / (divisor / 10) % 10;
                counter[mod]++;
            }
            // [0, 1, 3]
            int [] refer = new int[10];
            int sum = 0;
            for (int i = 0; i < counter.length ; i++) {
                sum += counter[i];
                refer[i] = sum;
            }
            
            int[] duplicate = new int[array.length];
            for (int i = array.length - 1; i >= 0 ; i--) {
                int mode = array[i] / (divisor / 10) % 10;
                duplicate[--refer[mode]] = array[i];
            }

            for (int i = 0; i < duplicate.length ; i++) {
                array[i] = duplicate[i];
            }
            divisor = divisor * 10;
        }
    }

}
