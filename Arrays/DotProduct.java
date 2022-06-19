/**
 * 
 * Given two array of same sizes having elements which are repeating continuously.
 * You need to find the dot product of these two arrays.
 * 
 * Note:-  try to do in such a way tht u need to do minimal multiplications
 * 
 * DOT PRODUCT of two arrays A=[],B=[] is => Summation of { A(i)*B(i) } for each i
 */


import java.util.ArrayList;

public class DotProduct {
    public static void main(String[] args) {

        DotProduct dp = new DotProduct();
        int[] a = {1,1,1,1,1,2,2,2,2,2,3,3};
        int[] b = {7,7,7,2,2,2,5,5,5,6,6,6};

        long ans = dp.solve(a, b);
        System.out.println(ans);
    }

    public long solve(int[]a, int[]b){
        int n = a.length;
        int v1=a[0],c1=1;
        int v2=b[0],c2=1;
        

        ArrayList<pair>a1 = new ArrayList<>();
        ArrayList<pair>b1 = new ArrayList<>();

        for(int i=1;i<n;i++){
            if(a[i]==a[i-1]){
                c1++;
            }else{
                a1.add(new pair(v1, c1));
                v1=a[i];
                c1=1;
            }

            if(b[i]==b[i-1]){
                c2++;
            }else{
                b1.add(new pair(v2, c2));
                v2=b[i];
                c2=1;
            }
        }
        a1.add(new pair(v1,c1));
        b1.add(new pair(v2, c2));

        int i=0,j=0;
        long sum=0;
        while(i<a1.size()&&j<b1.size()){
            pair p1 = a1.get(i);
            pair p2 = b1.get(j);
            if(p1.count<p2.count){
                sum+=(p1.count*p1.val*p2.val);
                p2.count = p2.count-p1.count;
                i++;
                b1.set(j, p2);
            }else if(p1.count>p2.count){
                sum+=(p2.count*p1.val*p2.val);
                p1.count = p1.count-p2.count;
                j++;
                a1.set(i, p1);

            }else{
                sum+=(p2.count*p1.val*p2.val);
                i++;j++;
            }
        }

        return sum;

    }
}

class pair{
    int count;
    int val;

    public pair(int v, int c){
        this.count = c;
        this.val = v;
    }
}


