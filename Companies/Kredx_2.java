/**
 * 
 * 
 * 
 */

public class Kredx_2 {
    public static void main(String[] args) {
        Kredx_2 k2 = new Kredx_2();
        int[] a = {6,7,1,2,3,4,5};
        int ans = k2.binaryS(2, 0, a.length-1, a);
        System.out.println(ans);
    }

    public int binaryS(int x, int s,int e,int[] a){
        if(s>e) return -1;
        if(s==e) return a[s]==x?s:-1;
        int mid = (s+e)/2;

        if(a[mid]==x) return mid;

        if(a[mid]>a[s]&&a[mid]<a[e]){
            if(a[mid]>x) return binaryS(x, s, mid-1, a);
            else return binaryS(x, mid+1, e, a);
        }else{
            if(a[mid]>a[s]){
                if(x>=a[s]){
                    if(x>a[mid]) return binaryS(x, mid+1, e, a);
                    else return binaryS(x, s, mid-1, a);
                }else{
                    return binaryS(x, mid+1, e, a);
                }
            }else{
                if(x>=a[s]){
                    return binaryS(x, s, mid-1, a);
                }else{
                    if(x>a[mid]) return binaryS(x, mid+1, e, a);
                    else return binaryS(x, s, mid-1, a);
                }
            }
        }
        
    }
}

/**
 * 
 * Techer, stu, courses
 * 
 * techer ----->(many) courses
 * student --> courses
 * one couse------one teacher at a time
 * 
 *  Student
 *  - stud_id
 *  - name
 * 
 *  Course
 *  - couseId
 *  - courseN
 * 
 * Techer
 *  - tId
 *  - tname
 * 
 *  Relationship
 *  -courseId
 *  - stuId
 *  - tId
 * 
 * 
 */
