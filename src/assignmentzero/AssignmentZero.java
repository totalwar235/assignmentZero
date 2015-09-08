/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentzero;

/**
 *
 * @author Reed
 */
public class AssignmentZero
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        int k;
        for (k = 0; k < 10; k++) {
            DubRandArray a = new DubRandArray(2000);

            double tempOne[] = a.selectionSort();
            double tempTwo[] = a.quickSortMaster(0, 1999);

            String End = "\n"+String.valueOf(k)+")\nSelection: " + String.valueOf(a.getSelectionSortTime()) + "ms\nQuick: " + String.valueOf(a.getquickSortTime() + "ms");
            System.out.println(End);

            int i = 0;
            int p = 0;
            for (double ex : tempOne) {
                //String post = String.valueOf(i) + " :: " + String.valueOf(tempOne[i]) + " :: " + String.valueOf(tempTwo[i]);
                if (tempOne[i] != tempTwo[i]) {
                    String post = "location " + String.valueOf(i) + ": is not the same at both locations ";
                    System.out.println(post);
                    p++;
                }

                i++;
            }

            if (p != 0) {
                System.out.println("This trial the sorts did not work\n");
            } else {
                System.out.println("The sorts worked correctly");
            }
        }
    }

}
