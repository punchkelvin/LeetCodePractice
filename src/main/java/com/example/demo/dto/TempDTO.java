package com.example.demo.dto;

import lombok.Data;
import java.util.List;

@Data
public class TempDTO {
    private int[] intArray1;
    private int[] intArray2;

    private int[][] intArray2d1;

    private String[] stringArray;

    private String string1;
    private String string2;

    private Integer integer1;
    private Integer integer2;

    private List<String> stringList;

    private char[][] board;

    private char char1;
    private double double1;
    private double double2;
}
