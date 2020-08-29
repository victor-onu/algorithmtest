package com.victor.algorithmtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;


public class AlgorithmtestApplication {
    public static int encodeInteger(int x, int n){
        n = n<<(1<<(1<<(1<<1)));
        x = x | n;
        return x;
    }

    public static int[] encodeArray(int A[], int B[], int n){
        for(int i=0;i<n;i++) {
            A[i] = encodeInteger(A[i], B[i]);
        }
        return A;
    }

    public static String decodedArray(int []encodeArray, int A[]){
        int i = 0;
        int len = encodeArray.length;
        int B[] = new int[len];
        while (i < len){
            B[i] = (A[i] ^ encodeArray[i]) >> (1 << (1 << (1 << 1)));
            i++;
        }
        return Arrays.toString(B);
    }

    public static void main(String[] args) {
        int []encodeArray = encodeArray(new int[]{1,2,3}, new int[]{4,5,6}, 3);
        System.out.println(decodedArray(encodeArray, new int[]{1,2,3}));
    }

}
