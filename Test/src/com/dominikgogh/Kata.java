package com.dominikgogh;

public class Kata {
    private static boolean horizontal = false;
    private static boolean dirUp = false;
    private static boolean dirRight = false;

    public static int[][] spiralize(int size) {
        int[][] intArray = new int[size][size];
        int length = size + 2;
        Point a = new Point(0, (intArray.length - 1));

        //első sor fixen 1-esekből áll
        for (int i=0; i<intArray.length; i++){
            intArray[0][i] = 1;
        }

        while (true) {
            if (horizontal) {
                if (length > 2){
                    if (dirRight) {
                        int currentLength = a.x+length;
                        for (a.x=a.x; a.x<currentLength; a.x++){
                            intArray[a.y][a.x] = 1;
                        }
                        a.x--;
                        dirRight = false;
                    } else {
                        int currentLength = a.x-length;
                        for (a.x=a.x; a.x>currentLength; a.x--){
                            intArray[a.y][a.x] = 1;
                        }
                        a.x++;
                        dirRight = true;
                    }
                    horizontal = false;
                } else {
                    break;
                }
            } else{
                length = length -2;
                if (length >= 2){
                    if (dirUp){
                        int currentLength = a.y-length;
                        for (a.y=a.y; a.y>currentLength; a.y--){
                            intArray[a.y][a.x] = 1;
                        }
                        a.y++;
                        dirUp = false;
                    } else {
                        int currentLength = a.y+length;
                        for (a.y = a.y; a.y<currentLength; a.y++) {
                            intArray[a.y][a.x] = 1;
                        }
                        a.y--;
                        dirUp = true;
                    }
                    horizontal = true;
                } else {
                    break;
                }
            }
        }
        return intArray;
    }

    public static class Point {
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
