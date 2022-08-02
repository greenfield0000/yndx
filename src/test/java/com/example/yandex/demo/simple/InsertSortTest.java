package com.example.yandex.demo.simple;

import com.example.yandex.demo.sorting.impl.simple.InsertSortService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.Arrays;


/**
 *
 * @author Ivanov Roman
 */
@SpringBootTest
class InsertSortTest {

    private final InsertSortService insertSortService;

    @Autowired
    public InsertSortTest(InsertSortService insertSortService) {
        this.insertSortService = insertSortService;
    }

    @Test
    void insertEmptyList() {
        final int[] list = new int[0];
        final int[] sort = insertSortService.sort(list);
        Assert.isTrue(sort.length == 0, "");
    }

    @Test
    void insertSortedValues() {
        final int[] list = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 8};
        final int[] sort = insertSortService.sort(list);
        Assert.isTrue(Arrays.equals(list, sort), "");
    }

    @Test
    void insertRevertValues() {
        final int[] list = new int[]{8, 8, 7, 6, 5, 4, 3, 2, 1};
        final int[] sort = insertSortService.sort(list);
        Assert.isTrue(Arrays.equals(sort, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 8}), "");
    }

    @Test
    void insertSingleValue() {
        final int[] list = new int[]{8};
        final int[] sort = insertSortService.sort(list);
        Assert.isTrue(Arrays.equals(sort, new int[]{8}), "");
    }

    @Test
    void insertTwoValue() {
        final int[] list = new int[]{8, 1};
        final int[] list2 = new int[]{1, 8};
        final int[] sort = insertSortService.sort(list);
        final int[] sort2 = insertSortService.sort(list2);
        Assert.isTrue(Arrays.equals(sort, new int[]{1, 8}), "");
        Assert.isTrue(Arrays.equals(sort2, new int[]{1, 8}), "");
    }

}
