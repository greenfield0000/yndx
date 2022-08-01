package com.example.yandex.demo;

import com.example.yandex.demo.sorting.impl.BubbleSortService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.Arrays;


/**
 * @author Ivanov Roman
 */
@SpringBootTest
public class BubbleSortTest {

    private final BubbleSortService bubbleSortService;

    @Autowired
    public BubbleSortTest(BubbleSortService bubbleSortService) {
        this.bubbleSortService = bubbleSortService;
    }

    @Test
    void sortEmptyTest() {
        final int[] list = new int[0];
        final int[] sort = bubbleSortService.sort(list);
        Assert.isTrue(sort.length == 0, "");
    }

    @Test
    void sortTestSorted() {
        final int[] list = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 8};
        final int[] sort = bubbleSortService.sort(list);
        Assert.isTrue(Arrays.equals(list, sort), "");
    }

    @Test
    void sortTestSortedRevert() {
        final int[] list = new int[]{8, 8, 7, 6, 5, 4, 3, 2, 1};
        final int[] sort = bubbleSortService.sort(list);
        Assert.isTrue(Arrays.equals(sort, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 8}), "");
    }

}
