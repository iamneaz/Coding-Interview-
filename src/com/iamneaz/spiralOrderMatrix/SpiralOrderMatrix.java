package com.iamneaz.spiralOrderMatrix;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class SpiralOrderMatrix {
    int row = 0; // Row
    int col = 0; // Column
    int[][] array;

    public SpiralOrderMatrix(int row, int col) {
        this.row = row;
        this.col = col;
        array = new int[row][col];
        readMatrixFromFile();
    }

    public void readMatrixFromFile() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("./src/com/iamneaz/spiralOrderMatrix/matrix.txt"));
            String line = bufferedReader.readLine();
            int textRow = 0;
            while (line != null) {
                String[] token = line.split(" ");
                for (int i = 0; i < token.length; i++) {
                    array[textRow][i] = Integer.parseInt(token[i]);
                }
                textRow++;
                line = bufferedReader.readLine();
            }
            bufferedReader.close();

//            for (int i = 0; i < row; i++) {
//                for (int j = 0; j < array.length; j++) {
//                    System.out.print(array[i][j] + " ");
//                }
//                System.out.println("\n");
//            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void printSpiralOrderMatrix() {
        int spiralNumber = row / 2;
        int rowStart = 0;
        int colStart = 0;
        if (row % 2 == 0 && col % 2 == 0) {
            while (spiralNumber != 0) {
                loopMatrix(this.row, this.col, rowStart, colStart);
                spiralNumber--;
                this.row--;
                this.col--;
                rowStart++;
                colStart++;
            }
        } else if (row % 2 != 0 && col % 2 == 0) {
            for (int i = 0; i < spiralNumber+1; i++) {
                if (i == spiralNumber) {
                    for (int j = rowStart; j < col; j++) {
                        System.out.print(array[rowStart][j] + " ");
                    }
                } else {
                    loopMatrix(this.row, this.col, rowStart, colStart);
                    this.row--;
                    this.col--;
                    rowStart++;
                    colStart++;
                }

            }
        }
            else if (row % 2 == 0 && col % 2 != 0) {
                for (int i = 0; i < spiralNumber ; i++) {
                    if (i == spiralNumber) {
                        for (int j = rowStart; j < col; j++) {
                            System.out.print(array[rowStart][j] + " ");
                        }
                    } else {
                        loopMatrix(this.row, this.col, rowStart, colStart);
                        this.row--;
                        this.col--;
                        rowStart++;
                        colStart++;
                    }

                }
            }
            else if (row%2!=0 && col%2!=0)
        {
            for (int i = 0; i < spiralNumber+1 ; i++) {
                if (i == spiralNumber) {
                    for (int j = rowStart; j < col; j++) {
                        System.out.print(array[rowStart][j] + " ");
                    }
                } else {
                    loopMatrix(this.row, this.col, rowStart, colStart);
                    this.row--;
                    this.col--;
                    rowStart++;
                    colStart++;
                }

            }
        }


        }

        public void loopMatrix ( int row, int col, int rowStart, int colStart)
        {
            for (int i = rowStart; i < col; i++) {
                System.out.print(array[rowStart][i] + " ");
            }

            for (int i = rowStart + 1; i < row; i++) {
                System.out.print(array[i][col - 1] + " ");
            }
            for (int i = col - 2; i >= colStart; i--) {
                System.out.print(array[row - 1][i] + " ");
            }
            for (int i = row - 2; i > rowStart; i--) {
                System.out.print(array[i][colStart] + " ");
            }
        }


    }
