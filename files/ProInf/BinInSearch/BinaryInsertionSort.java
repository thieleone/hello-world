import java.util.Arrays;
public class BinaryInsertionSort{
    public static int[] BinInSearch(int[] a){
        int n=a.length;
        int ins;
        int tmp;
        for (int i=0;i<n;i++){
            ins=BinSearch(a,a[i],0,i);
            if (ins<i){
                tmp=a[i];
                for (int j=i-1;j<ins;i--){
                    a[j+1]=a[j];
                }
                a[ins]=tmp;
            }
        }
        return a;
    }
    public static int BinSearch(int[] werte,int gesucht,int start,int ende){
        if (ende<start){
            return -start;
        }
        int mitte=(start+ende)/2;
        System.out.println(mitte);
        if (werte[mitte]==gesucht){
            return mitte;
        }
        else if (werte[mitte]<gesucht){
            return BinSearch(werte,gesucht,mitte+1,ende);
        }
        else{
            return BinSearch(werte,gesucht,start,mitte-1);
        }
    }


    public static void main(String[] args){
        // int[] b={3,7,6,4,5};
        int[] b={3,7,6,4,5,8};
        System.out.println(Arrays.toString(BinInSearch(b)));
        System.out.println(BinSearch(b,3,0,4));


    // def BinaryInsertionSort (a):
    //     n=len(a)

    //     for i in range(1,n):
    //         ins = binaersuche_rekursiv(a, a[i], 0, i)
    //         if (ins < i):
    //             tmp = a[i]
    //             for j in range(i - 1,ins, -1):
    //                 a[j + 1] = a[j]
    //             a[ins] = tmp
    //     return a

    // def binaersuche_rekursiv(werte, gesucht, start, ende):
    //     if ende < start:
    //         return -start
    //     mitte = (start + ende)//2
    //     if werte[mitte] == gesucht:
    //         return mitte
    //     elif werte[mitte] < gesucht:
    //         return binaersuche_rekursiv(werte, gesucht, mitte+1, ende)
    //     else:
    //         return binaersuche_rekursiv(werte, gesucht, start, mitte-1)

    // print(BinaryInsertionSort([5,4,6,3,7]))


    }
}