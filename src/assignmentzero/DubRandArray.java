/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentzero;

import java.util.Random;

/**
 *
 * @author Reed
 */
public class DubRandArray
{

    private double arr[];
    private long selectionSortTime;
    private long quickSortTime;

    DubRandArray(int x)
    {
        double temp[] = new double[x];
        int i = 0;
        for (Double ex : temp) {
            Random insert = new Random();
            temp[i] = insert.nextDouble();
            i++;
        }
        arr = temp;
    }

    /**
     *
     * @return a selection sorted array of doubles
     */
    public double[] selectionSort()
    {
        double sorted[] = arr;

        int i, j, first;
        double temp;
        long start = System.currentTimeMillis();
        for (i = sorted.length - 1; i >= 0; i--) {
            first = 0;   //initialize to subscript of first element
            for (j = 0; j <= i; j++) //locate smallest element between positions 1 and i.
            {
                if (sorted[j] < sorted[first]) {
                    first = j;
                }
            }
            temp = sorted[first];   //swap smallest found with element in position i.
            sorted[first] = sorted[i];
            sorted[i] = temp;
        }
        selectionSortTime =  System.currentTimeMillis() - start ;
        return sorted;
    }

    /**
     *
     * @return quick sorted array of doubles
     */
    private int partition(double arr[], int left, int right)

    {

        int i = left, j = right;

        double tmp;

        double pivot = arr[(left + right) / 2];

        while (i <= j) {

            while (arr[i] < pivot) {
                i++;
            }

            while (arr[j] > pivot) {
                j--;
            }

            if (i <= j) {

                tmp = arr[i];

                arr[i] = arr[j];

                arr[j] = tmp;

                i++;

                j--;

            }

        };

        return i;

    }

    private double[] quickSort(double temp[],int left, int right)
    {
        
        int index = partition(temp, left, right);

        if (left < index - 1) {
            quickSort(temp, left, index - 1);
        }

        if (index < right) {
            quickSort(temp, index, right);
        }
        return temp;
    }
    
    public double[] quickSortMaster(int left, int right){
        double temp[] = arr;
        
        long start = System.currentTimeMillis();
        temp = quickSort(temp,left,right);
        quickSortTime = System.currentTimeMillis() - start;
        
        return temp;
    }

    public double[] getArr()
    {
        return arr;
    }

    public void setArr(double temp[])
    {
        arr = temp;
    }

    public long getSelectionSortTime()
    {
        return selectionSortTime;
    }

    public void setSelectionSortTime(long selectionSortTime)
    {
        this.selectionSortTime = selectionSortTime;
    }
    
    public long getquickSortTime()
    {
        return quickSortTime;
    }

    public void setquickSortTime(long quickSortTime)
    {
        this.quickSortTime = quickSortTime;
    }

}
