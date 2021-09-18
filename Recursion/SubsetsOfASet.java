import java.util.HashSet;

//Given a set of integers(Array), print all the subsets of the set
import java.util.*;
public class SubsetsOfASet {
    public static void main(String[] args) {

        SubsetsOfASet ss = new SubsetsOfASet();

        int[] A = {1,2,3};
        Set<Integer>s = new HashSet<>();
        ss.printSubsets(A,s,0);
        
    }

    public void printSubsets(int[] a,Set<Integer>s,int i){
        if(i>=a.length){
            System.out.print("{");
            for(int x:s){
                System.out.print(x+" ");
            }
            System.out.println("}");
            return;
        }
        Set<Integer>tmp = new HashSet<>(s);
        tmp.add(a[i]);
        printSubsets(a, s, i+1);
        printSubsets(a, tmp, i+1);
    }   
    
}
