package com.example.yandex.demo;

import com.example.yandex.demo.sorting.impl.ShakerSortService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.Arrays;

/**
 * @author Ivanov Roman
 */
@SpringBootTest
public class ShakerSortTest {

    private final ShakerSortService shakerSortService;

    @Autowired
    public ShakerSortTest(ShakerSortService shakerSortService) {
        this.shakerSortService = shakerSortService;
    }

    @Test
    void shakerSortEmptyTest() {
        final int[] list = new int[0];
        final int[] sort = shakerSortService.sort(list);
        Assert.isTrue(sort.length == 0, "");
    }

    @Test
    void shakerSortTestSorted() {
        final int[] list = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 8};
        final int[] sort = shakerSortService.sort(list);
        Assert.isTrue(Arrays.equals(list, sort), "");
    }

    @Test
    void shakerSortTestSortedRevert() {
        final int[] list = new int[]{8, 8, 7, 6, 5, 4, 3, 2, 1};
        final int[] sort = shakerSortService.sort(list);
        Assert.isTrue(Arrays.equals(sort, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 8}), "");
    }

}
