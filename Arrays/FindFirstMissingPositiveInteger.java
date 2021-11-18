public class FindFirstMissingPositiveInteger {
    public static void main(String[] args) {
        int[] a = {2,1,4,-1,0,5};
        int missing = FindFirstMissingPositiveInteger.getFirstMissing(a);
        System.out.println(missing);
    }

    public static int getFirstMissing(int[] a){
        int n = a.length;
        int i=0;
        while(i<n){
            if(a[i]>0&&a[i]<n&&(i+1)!=a[i]&&a[a[i]-1]!=a[i]){
                int t = a[a[i]-1];
                a[a[i]-1] = a[i];
                a[i] = t;
            }
            else i++;
        }   
            
        for(i=0;i<n;i++){
            if(a[i]!=i+1) return i+1;
        }
        return n+1;
    }
}
