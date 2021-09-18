/**
 * Given two strings s and t of lengths m and n respectively, 
 * return the minimum window substring of 'S' such that every character in t (including duplicates) is included in the window.
 *  If there is no such substring, return the empty string ""
 * 
 * 
 * SOLUTION:- The idea is to solve using 2-POINTER approach, 'start' and 'end' pointer and after getting a desired string 
 *              we will try to move our start pointer and see if we can minimize the length.
 */

import java.util.*;
public class WindowString {
    public static void main(String[] args) {
        
        WindowString ws = new WindowString();
        String A = "xiEjBOGeHIMIlslpQIZ6jERaAVoHUc9Hrjlv7pQpUSY8oHqXoQYWWll8Pumov89wXDe0Qx6bEjsNJQAQ0A6K21Z0BrmM96FWEdRG69M9CYtdBOrDjzVGPf83UdP3kc4gK0uHVKcPN4HPdccm9Qd2VfmmOwYCYeva6BSG6NGqTt1aQw9BbkNsgAjvYzkVJPOYCnz7U4hBeGpcJkrnlTgNIGnluj6L6zPqKo5Ui75tC0jMojhEAlyFqDs7WMCG3dmSyVoan5tXI5uq1IxhAYZvRQVHtuHae0xxwCbRh6S7fCLKfXeSFITfKHnLdT65K36vGC7qOEyyT0Sm3Gwl2iXYSN2ELIoITfGW888GXaUNebAr3fnkuR6VwjcsPTldQSiohMkkps0MH1cBedtaKNoFm5HbH15kKok6aYEVsb6wOH2w096OwEyvtDBTQwoLN87JriLwgCBBavbOAiLwkGGySk8nO8dLHuUhk9q7f0rIjXCsQeAZ1dfFHvVLupPYekXzxtWHd84dARvv4Z5L1Z6j8ur2IXWWbum8lCi7aErEcq41WTo8dRlRykyLRSQxVH70rUTz81oJS3OuZwpI1ifBAmNXoTfznG2MXkLtFu4SMYC0bPHNctW7g5kZRwjSBKnGihTY6BQYItRwLUINApd1qZ8W4yVG9tnjx4WyKcDhK7Ieih7yNl68Qb4nXoQl079Vza3SZoKeWphKef1PedfQ6Hw2rv3DpfmtSkulxpSkd9ee8uTyTvyFlh9G1Xh8tNF8viKgsiuCZgLKva32fNfkvW7TJC654Wmz7tPMIske3RXgBdpPJd5BPpMpPGymdfIw53hnYBNg8NdWAImY3otYHjbl1rqiNQSHVPMbDDvDpwy01sKpEkcZ7R4SLCazPClvrx5oDyYolubdYKcvqtlcyks3UWm2z7kh4SHeiCPKerh83bX0m5xevbTqM2cXC9WxJLrS8q7XF1nh";
        String B = "dO4BRDaT1wd0YBhH88Afu7CI4fwAyXM8pGoGNsO1n8MFMRB7qugS9EPhCauVzj7h";
        String ans = ws.minWindow(A, B);
        System.out.println(ans);
    }

    public String minWindow(String A, String B) {
        int s=0,start=0,end=-1,e=-1;
        int i=0,len=Integer.MAX_VALUE;
        int fb[] = new int[126];
        int fa[] = new int[126];
        int na = A.length();
        int nb = B.length();
        for(int j=0;j<nb;j++){
            fb[B.charAt(j)-'0']++;
        }
        // while(i<na&&fb[A.charAt(i)-'0']==0)i++;
        // start=i;
        // fa[A.charAt(i)-'0']++;
        // i++;
        while(i<na){
            if(fb[A.charAt(i)-'0']<=0){
                i++;
            }else{
                fa[A.charAt(i)-'0']++;
                while(isSame(fa,fb)){                               //this will check while we can move our start pointer further without losing the result
                    
                    end = i;
                    System.out.println(start+" "+end);
                    if(len>end-start+1){
                        s=start;
                        e=i;
                        len = end-start+1;
                    }
                    
                    fa[A.charAt(start)-'0']--;
                    int j=start+1;
                    while(j<na&&fb[A.charAt(j)-'0']<=0){
                        j++;
                    }
                    start=j;
                }
                i++;
            }
        }
        StringBuilder sb = new StringBuilder("");
        for(i=s;i<=e;i++){
            sb.append(A.charAt(i));
        }
        return sb.toString();
    }
    
    public boolean isSame(int fa[],int fb[]){
        for(int i=0;i<126;i++){
            if(fb[i]!=0&&fa[i]<fb[i]) return false;
        }
        return true;
    }
}
