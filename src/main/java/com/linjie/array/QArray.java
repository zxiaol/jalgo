package com.linjie.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

    public int removeDupilcatesFromSortedArray(int[] array) {

        if (array == null)
            return 0;

        if (array.length == 1)
            return 1;

        int duplicateBegin = 0;

        for (int j = 1; j < array.length; j++) {

            if (array[j] == array[duplicateBegin]) {
                continue;
            }

            array[++duplicateBegin] = array[j];


        }

        return duplicateBegin + 1;
    }

    public int removeDupilcatesFromSortedArray(int[] array, int thresholdOfDuplicateTimes) {

        if (array == null)
            return 0;

        if (array.length == 1)
            return 1;

        int duplicateBegin = 0;

        int numOfDuplicated = 1;

        for (int j = 1; j < array.length; j++) {

            if (array[j] == array[duplicateBegin]) {

                numOfDuplicated++;

                if (numOfDuplicated <= thresholdOfDuplicateTimes) {

                    array[++duplicateBegin] = array[j];

                } else {

                    continue;

                }

            } else {

                numOfDuplicated = 1;
                array[++duplicateBegin] = array[j];
            }
        }

        return duplicateBegin + 1;


    }

    public List<List<Integer>> printPascalTriangle(int numOfLevels) {

        if (numOfLevels < 1)
            return null;

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        result.add(new ArrayList<Integer>(1));

        result.get(0).add(1);

        for (int iLevel = 1; iLevel < numOfLevels; iLevel++) {

            result.add(new ArrayList<Integer>(iLevel + 1));

            result.get(iLevel).add(1);

            result.get(iLevel).add(iLevel, 1);

            for (int i = 1; i < iLevel; i++) {

                result.get(iLevel).add(i, result.get(iLevel - 1).get(i - 1) + result.get(iLevel - 1).get(i));

            }
        }

        return result;
    }

    public List<Integer> quickSort(List<Integer> data) {

        if (data == null || data.size() < 2)
            return data;

        return doQuickSort(data, 0, data.size() - 1);
    }

    private List<Integer> doQuickSort(List<Integer> data, int begin, int end) {

        if (begin >= end)
            return data;

        int mid = partition(data, begin, end);

        doQuickSort(data, begin, mid - 1);

        doQuickSort(data, mid + 1, end);

        return data;


    }

    private int partition(List<Integer> data, int begin, int end) {

        if (begin == end)
            return begin;

        Integer target = data.get(begin);

        while (begin < end) {

            for (; data.get(end) > target && end > begin; end--)
                ;

            if (end > begin)
                data.set(begin, data.get(end));

            for (; data.get(begin) <= target && begin < end; begin++)
                ;

            if (end > begin)
                data.set(end, data.get(begin));
        }

        data.set(begin, target);

        return begin;

    }

    public Long findLargestArea(List<Integer> heights) {

        Long maxArea = 0L;

        if (heights == null || heights.size() == 0)
            return maxArea;

        Stack<Integer> heightStack = new Stack<>();

        heightStack.push(0);

        for (int i = 1; i < heights.size(); i++) {

            Integer preHeight = heights.get(heightStack.peek());

            Integer cntHeight = heights.get(i);

            if (cntHeight < preHeight) {

                Integer start = heightStack.pop();

                Integer end = start;

                while (heightStack.size() > 0) {

                    Integer preStackHeight = heights.get(heightStack.peek());

                    if (preStackHeight < preHeight)
                        break;

                    start = heightStack.pop();

                }

                Long area = (end - start + 1) * preHeight.longValue();

                if (area > maxArea)
                    maxArea = area;


            }

            heightStack.push(i);
        }

        return maxArea;


    }
}
