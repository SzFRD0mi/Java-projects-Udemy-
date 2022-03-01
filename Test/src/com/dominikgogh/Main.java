package com.dominikgogh;

public class Main {

    public static void main(String[] args) {

        int[][] array = Kata.spiralize(15);

        for (int i=0; i<array.length; i++) {
            for (int j=0; j<array.length; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }

        System.out.println(array[0][5]);
    }
}
