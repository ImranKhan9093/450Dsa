package Strings;

import java.util.HashMap;
import java.util.Map;

public class DuplicateCharacters {
 public static void main(String[] args) {
    String s= "hello05688";
    System.out.println("The duplicate are : ");
    findDuplicates(s);
 }   
 public static void findDuplicates(String s){
    HashMap<Character,Integer> hm = new HashMap<>();
    for (int i = 0; i <s.length(); i++) {
        if(!hm.containsKey(s.charAt(i))){
            hm.put(s.charAt(i),1);

        }else{
            hm.put(s.charAt(i),hm.get(s.charAt(i))+1);
        }
    }
    for(Map.Entry<Character,Integer> e:hm.entrySet()){
        char charToCheck = e.getKey();
        int countOfChar = e.getValue();
        if(countOfChar>1){
            System.out.println(charToCheck);
        }
    }
  }
}
