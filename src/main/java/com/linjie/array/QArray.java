package com.linjie.array;

/**
 * Created by zhuxiaolong on 2018/5/29.
 */
public class QArray {

    public int removeElement(int[] array, int element) {

        if (array == null)
            return 0;

        int duplicate = 0;

        int i = 0;

        for (i = 0; i < array.length; i++) {

            if (array[i] == element) {

                duplicate++;

            } else {

                array[i - duplicate] = array[i];
            }
        }

        return i - duplicate;
    }
}
