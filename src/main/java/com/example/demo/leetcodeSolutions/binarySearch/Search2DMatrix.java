package com.example.demo.leetcodeSolutions.binarySearch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.Arrays;

@Service
@Slf4j
public class Search2DMatrix {
    // input: [[1,2,4,8],[10,11,12,13],[14,20,30,40]], target = 12
    // output: true

    // Input: matrix = [[1,2,4,8],[10,11,12,13],[14,20,30,40]], target = 15
    // output:false

    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = (matrix.length * matrix[0].length) - 1;

        while (left <= right) {
            int middle = (right - left) / 2 + left;

            // need to find the index of the middle
            int row = middle / matrix[0].length;
            int column = middle % matrix[0].length;

            if (matrix[row][column] == target) {
                return true;
            }

            if (matrix[row][column] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return false;
    }

    public boolean searchMatrixOk(int[][] matrix, int target) {
        int start = 0;
        int end = (matrix[0].length * matrix[1].length) - 1;

        int middle = ((end - start) / 2) + start; // 6
        log.info("Middle: " + middle);

        //        while (start < end) {
        //            if(matrix[middle/matrix[1].length][])
        //        }

        for (int i = 0; i < 16; i++) {
            log.info("I: " + i);
            log.info("Value: " + i / matrix[0].length);
        }

        int[] matrix1 = matrix[0];
        int[] matrix2 = matrix[1];

        int row = middle;
        int column = middle;

        return false;
    }
}
