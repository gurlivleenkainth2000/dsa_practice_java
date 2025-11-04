package org.example;

public class ArrayConcatenation {
    public int[] getConcatenation(int[] nums) {
        int newArrayLength = 2 * nums.length;
        int[] newArray = new int[newArrayLength];

        for (int arrIdx = 0; arrIdx < newArrayLength; arrIdx++) {
            int remainder = arrIdx % nums.length;
            newArray[arrIdx] = nums[remainder];
        }

        return newArray;
    }

    public static void main(String[] args) {
        ArrayConcatenation arrayConcatenation = new ArrayConcatenation();
        int[] resultArray = arrayConcatenation.getConcatenation(new int[]{13, 16, 18});
        System.out.println(resultArray.length);
    }
}
