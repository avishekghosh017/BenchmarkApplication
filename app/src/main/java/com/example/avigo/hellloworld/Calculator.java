package com.example.avigo.hellloworld;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by AviGo on 12/2/2015.
 */
public class Calculator {

    public static int[] cloneArray(int a[]){
        int i;
        int array[]=new int[a.length];
        for(i=0;i<a.length;i++){
            array[i]=a[i];
        }
        return array;
    }
    public static int[] arrayOfNatural(int n){
        int i;
        int arr[]=new int[n];
        for(i=0;i<n;i++){
            arr[i]=i+1;
        }
        return arr;
    }
    public static int[] arrayRandom(int n){
        int i;
        int arr[]=new int[n];
        Random generator = new Random();

        for(i=0;i<n;i++){
            arr[i]=generator.nextInt(100);
        }
        return arr;
    }

    public static int[] arrayReverse(int n){
        int[] arr=new int[n];
        int index=0;
        for(int i=arr.length;i>0;i--){
            arr[index]=i;
            index++;
        }
        return arr;
    }

    public static int[] bubble(int a[]){
        int temp;
        for(int i=0;i<(a.length-1);i++){
            for(int j=0;j<(a.length-i-1);j++){
                if(a[j]>a[j+1]){
                    temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
        }
        return a;
    }
    public static int[] selection(int a[]){
        int temp;
        for(int i=0;i<(a.length-1);i++){
            for(int j=i+1;j<a.length;j++){
                if(a[j]<a[i]){
                    temp=a[j];
                    a[j]=a[i];
                    a[i]=temp;
                }
            }
        }
        return a;
    }
    public static int[] insertion(int a[]){
        int temp;
        for (int i = 1; i < a.length; i++) {
            for(int j = i ; j > 0 ; j--){
                if(a[j] < a[j-1]){
                    temp = a[j];
                    a[j] = a[j-1];
                    a[j-1] = temp;
                }
            }
        }
        return a;
    }
    public static void quickSort(int[] arr, int low, int high) {
        if (arr == null || arr.length == 0)
            return;
        if (low >= high)
            return;
        int middle = low + (high - low) / 2;
        int pivot = arr[middle];
        int i = low, j = high;
        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        if (low < j)
            quickSort(arr, low, j);
        if (high > i)
            quickSort(arr, i, high);
    }

    public static void mergeSort(int[] a, int low, int high) {
        int N = high - low;
        if (N <= 1)
            return;
        int mid = low + N/2;
        mergeSort(a, low, mid);
        mergeSort(a, mid, high);
        int[] temp = new int[N];
        int i = low, j = mid;
        for (int k = 0; k < N; k++)
        {
            if (i == mid)
                temp[k] = a[j++];
            else if (j == high)
                temp[k] = a[i++];
            else if (a[j]<a[i])
                temp[k] = a[j++];
            else
                temp[k] = a[i++];
        }
        for (int k = 0; k < N; k++)
            a[low + k] = temp[k];
    }
}
