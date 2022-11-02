package Strings;

public class CyclicRotation {
    public static void main(String[] args) {
        String p = "hello";
        String q = "hello";
        System.out.println(isCyclicRotation(p,q)?"String q is cyclic rotation of p":"String q is not cyclic rotation of p");
    }
    public static boolean isCyclicRotation(String  p , String q){
        p=p+p;
        if(p.contains(q))
          return true;
        return false;
    }
}
