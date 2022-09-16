package pgdp.arrays;

import java.util.Arrays;

public class ProbabilisticSearch extends MiniJava {
    /**
     * Binary Search aus der Vorlesung leicht abgewandelt
     */
    public static int[] find( int[] a, int x) {
        return find0(a, x, 0, a.length - 1, 1);
    }

    public static int[] find0( int[] a, int x, int n1, int n2, int numberOfSteps) {
        int t = (n1 + n2) / 2;
        if (a[t] == x)
            return new int[] { t, numberOfSteps };
        else if (n1 >= n2)
            return new int[] { -1, numberOfSteps };
        else if (x > a[t])
            return find0(a, x, t + 1, n2, numberOfSteps + 1);
        else if (n1 < t)
            return find0(a, x, n1, t - 1, numberOfSteps + 1);
        else
            return new int[] { -1, numberOfSteps };
    }

    public static int[] probalisticSearch(int[] arr, int value) {
        int[] returnarr = new int[2];
        float inputval = value;
        float minvalarr = arr[0];
        float maxvalarr = arr[arr.length - 1];
        int tries = 1;
        int step = 0;
        int tryposition = Math.round((inputval - minvalarr) / ((maxvalarr - minvalarr) / (arr.length)));
        //write(tryposition);
        boolean trypositionEqualsInputval = false;
        int n = 0;
        /*
         * returnarr = new arr that's returned when finished inputval = value searched
         * for minvalarr = minvalue in arr maxvalarr = maxvalue in arr tryposition =
         * arr[tryposition] is tested if it's equal to inputval
         */

                while (arr[tryposition] != inputval) {
                    step = (int) Math.pow(2, n);
                if (tryposition + step >= 0) {
                    if (arr[tryposition] > inputval) {
                        tryposition -= step;
                        tries++;
                        n++;
                    } else if (arr[tryposition] < inputval) {
                        tryposition += step;
                        tries++;
                        n++;
                    } else if (arr[tryposition] == inputval) {
                        trypositionEqualsInputval = true;
                        break;
                    }else if(arr[tryposition] < inputval && arr[tryposition + 1] > inputval){
                        trypositionEqualsInputval = false;
                        break;
                    }
                }else if(tryposition + step <= arr.length - 1){
                    if (arr[tryposition] > inputval) {
                        tryposition -= step;
                        tries++;
                        n++;
                    } else if (arr[tryposition] < inputval) {
                        tryposition += step;
                        tries++;
                        n++;
                    } else if (arr[tryposition] == inputval) {
                        trypositionEqualsInputval = true;
                        break;
                    }else if(arr[tryposition] < inputval && arr[tryposition + 1] > inputval){
                        trypositionEqualsInputval = false;
                        break;
                    }
                    
                }
            }
        if(trypositionEqualsInputval = true){
            returnarr[0] = tryposition;
            returnarr[1] = tries;
        }else if(trypositionEqualsInputval = false){
            find(arr, value);
        }
        
        return returnarr;
    }

    public static void compareApproaches(final int[] arr, int min, int max) {
    // min = arr[0];
    // max = arr[arr.length];

    // for(int i = 0; i < arr.length - 1; i++){
    //     find(arr[i], i);
    // }

    
        

    //     writeConsole("Binäre Suche:");
    //     writeConsole("Maximale Anzahl an Aufrufen:");
    //     System.out.print(find(arr, 74));
    //     writeConsole("Wert bei dem die maximale Anzahl an Aufrufen auftritt:");
    //     System.out.print();
    }

    public static void main(final String[] args) {
        // Not part of the exercise but can be helpful for debugging purposes
         int[] arr = new int[] { 6, 20, 22, 35, 51, 54, 59, 74, 77, 80, 87, 94, 97 };
         write(Arrays.toString(probalisticSearch(arr, 75)));
        // write(Arrays.toString(find(arr, 74)));
    }
}
