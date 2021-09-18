import java.util.HashSet;

public class RemoveMinInvalidParenthesis {
    int maxLen=0;
    HashSet<String>hset = new HashSet<>();
    public static void main(String[] args) {
        RemoveMinInvalidParenthesis rip = new RemoveMinInvalidParenthesis();
         
        String s = ")(f";
        rip.getValid(s, new StringBuilder(), 0, 0, 0);
        for(String t:rip.hset){
            if(t.length()==rip.maxLen){
                System.out.println(t);
            }
        }
    }

    public void getValid(String src,StringBuilder sb, int in,int open, int close){
        if(in==src.length()){
            if(open==close) {
                maxLen = Math.max(maxLen, sb.length());
                hset.add(sb.toString());
            }
            return;
        }

        if(close>open) return;

        if(src.charAt(in)!='('&&src.charAt(in)!=')'){
            sb.append(src.charAt(in));
            getValid(src,sb,in+1,open,close);
            sb.deleteCharAt(sb.length()-1);
            return;
        }

        if(src.charAt(in)=='('){
            sb.append("(");
            getValid(src, sb, in+1, open+1, close);
            sb.deleteCharAt(sb.length()-1);
        }
        if(src.charAt(in)==')'){
            sb.append(")");
            getValid(src, sb, in+1, open, close+1);
            sb.deleteCharAt(sb.length()-1);
        }
        getValid(src, sb, in+1, open, close);
    }
}
