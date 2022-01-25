package dsa.codepractice.interviews;

import java.util.List;

public class vonage {
    public boolean isSorted(List<String> s){
        if(s.isEmpty()||s.size()==1) return true;

        for(int i=0;i<s.size()-1;i++){
            String one = s.get(i);
            String two = s.get(i+1);
            int length = one.length()>two.length() ? two.length() : one.length();
            for(int j=0;j<length;j++){
                if(Character.isDigit(one.charAt(j)) && Character.isDigit(two.charAt(j))){
                    int intOne = Integer.valueOf(one.charAt(j));
                    int intTwo = Integer.valueOf(two.charAt(j));
                    int index = j;
                    if(intOne==0){
                        //intOne
                    }
                    if(one.charAt(j)==two.charAt(j)){
                        break;
                    } else if(one.charAt(j)=='0'){

                    }
                }
                if(one.charAt(j)=='a'){

                }

            }
        }
        return true;
    }
}