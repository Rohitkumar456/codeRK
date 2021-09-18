
/**
 * InversionCountOfArray
 * 
 * Given an array of integers A. If i < j and A[i] > A[j] then the pair (i, j) is called an inversion of A.
 *  Find the total number of inversions of A modulo (10^9 + 7).
 * 
 */
public class InversionCountOfArray {
    int inversion=0;
    public static void main(String[] args) {
        InversionCountOfArray ioc = new InversionCountOfArray();
        int[] a = {1, 20, 6, 4, 5};

        ioc.sort(a, 0, a.length-1);
        System.out.println(ioc.inversion);
        
    }

    public void sort(int[] a, int st, int end){
        if(st>=end) return;
        int mid = (st+end)/2;
        sort(a,st,mid);
        sort(a,mid+1,end);
        merge(a,st,mid,end);
    }

    public void merge(int[] a, int st,int mid,int e){
        int n1 = mid-st+1;
        int n2 = e-mid;

        int[] b = new int[n1+n2];
        int i=0,j=0,k=0;
        while(i<n1&&j<n2){
            if(a[st+i]<=a[mid+j+1]){
                b[k++] = a[st+i];
                i++;
            }else{
                b[k++] = a[mid+j+1];
                inversion+=mid-(st+i)+1;            // if for a prticlr 'i' a[i]>a[j] i.e all element after i will be gr8r thn a[j]as they are sorted.
                j++;                                // i.e  mid - (start+i) +1  => mid - (st+i) +1      [(start+i) is total we have traversed in left array ] 
            }
        }
        while(i<n1){
            b[k++] = a[st+i];
            i++;
        }
        while(j<n2){
            b[k++] = a[mid+j+1];
            j++;
        }
        k=0;
        for(i=st;i<=e;i++){
            a[i] = b[k++];
        }
    }
    
}