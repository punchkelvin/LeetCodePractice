package com.example.demo.leetcodeSolutions.arrayAndHashing.medium;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;

@Slf4j
@Service
public class ValidSudoku {
    public boolean isValidSudoku2(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] columns = new HashSet[9];
        HashSet<Character>[] square = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            columns[i] = new HashSet<>();
            square[i] = new HashSet<>();
        }

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {

                char num = board[r][c];

                if (num == '.') {
                    continue;
                }

                if (rows[r].contains(num)) {
                    return false;
                } else {
                    rows[r].add(num);
                }

                if (columns[c].contains(num)) {
                    return false;
                } else {
                    columns[c].add(num);
                }

                int squareIndex = (r / 3) * 3 + (c / 3);
                if (square[squareIndex].contains(num)) {
                    return false;
                } else {
                    square[squareIndex].add(num);
                }
            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] columns = new HashSet[9];
        HashSet<Character>[] square = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            columns[i] = new HashSet<>();
            square[i] = new HashSet<>();
        }

        int countPiece = 0;
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char num = board[r][c];
                log.info("board piece: " + "[" + r + "]" + "[" + c + "]" + " " + num);
                countPiece++;
                log.info("Count piece: " + countPiece);
                if (num == '.') continue;

                // Check the row
                if (rows[r].contains(num)) return false;
                rows[r].add(num);

                // Check the column
                if (columns[c].contains(num)) return false;
                columns[c].add(num);

                // Check the 3x3 box
                int boxIndex = (r / 3) * 3 + c / 3;
                if (square[boxIndex].contains(num)) return false;
                square[boxIndex].add(num);
            }
        }
        return true;
    }
}
