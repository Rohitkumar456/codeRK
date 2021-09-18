
/**
 * Given a String S of length N( consistes only lower alphabets), and an Integer K, Select any random character K times from string S and generate a String Y.
 * You need to calculate thesum of power of strings Y generated using above step.
 * 
 * poer of a String can be calculated like, a=0,b=1,c=2....
 */


public class PowerOfString {
    int totalPower = 0;
    public static void main(String[] args) {
        PowerOfString pos = new PowerOfString();
        String s = "abc";
        int k = 2;
        pos.generate(s, 0, k, 0, 0);
        System.out.println("totalPower = "+pos.totalPower);
    }


    public void generate(String s, int l, int k,int start,int power){
        if(start==s.length()) return;
        if(l==k){
            totalPower+=power;
            System.out.println("power = "+power);
            return;
        }

        for(int i=0;i<s.length();i++){
            int p = s.charAt((i))-'a';
            generate(s, l+1, k, i, power+p);
        }

    }
}
