
import java.util.*;
public class BinaryWatch {

    ArrayList<String>times = new ArrayList<>();
    ArrayList<ArrayList<Integer>>permutations = new ArrayList<>();
    int count=0;
    public static void main(String[] args) {
        
        BinaryWatch bw = new BinaryWatch();

        int[] a = {0,0,0,0,0,0,0,0,0,1};
        bw.distinctPer(a, 0);
        // bw.show();
        bw.convert();
        bw.showTimes();
    }


    public void convert(){

        for(ArrayList<Integer>tmp:permutations){
            int h=0,m=0;
            for(int i=0;i<4;i++){
                h=(h|(tmp.get(4-i-1)<<i));
            }
            for(int i=0;i<6;i++){
                m=(m|(tmp.get(10-i-1)<<i));
            }

            if(h<=11&&m<=59){
                String t = "";
                if(m<10){
                    t+=h;
                    t+=":";
                    t+="0"+m;
                }else{
                    t+=h;
                    t+=":";
                    t+=m;
                }
                times.add(t);
            }
        }
    }

    public void distinctPer(int[]a,int st){
        if(st==a.length-1){
            ArrayList<Integer>tmp = new ArrayList<>();
            for(int x:a){
                tmp.add(x);
            }
            permutations.add(tmp);
            return;
        }

        for(int i=st;i<a.length;i++){
            boolean chk = shouldSwap(a, st, i);
            if(chk){
                swap(a, i, st);
                if(a[0]!=1||a[1]!=1){
                    distinctPer(a, st+1);
                }
                swap(a, i, st);
            }
        }
    }

    public void swap(int[]a,int i,int j){
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    
    public boolean shouldSwap(int[] a, int st, int cur){
        for(int i=st;i<cur;i++){
            if(a[i]==a[cur]) return false;
        }
        return true;
    }

   
    public void show(){
        for(ArrayList<Integer>tmp:permutations){
            System.out.print("[ ");
            for(int x:tmp){
                System.out.print(x+" ");
            }
            System.out.println("]");
        }
    }

    public void showTimes(){
        for(String s:times){
            System.out.println(s);
        }
    }
}