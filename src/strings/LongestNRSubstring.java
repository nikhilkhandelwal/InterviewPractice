package strings;

public class LongestNRSubstring {

   public static int maxlen = 1;
    public static String maxString ;


    public static void main(String args[]) {

        System.out.println(longestNRSubstring("acb"));
    }

    public static String longestNRSubstring(String str){

       // if (str.length() == 0) return 0;
       // if (str.length() == 1) return 1;

        boolean [] map =  new boolean[256];

        map[str.charAt(0)] = true;
        int i = 1;
        int j = 0 ;
        while(i < str.length()){
            if(map[str.charAt(i)]){
                while(j <i){
                    if(str.charAt(i)==str.charAt(j)){
                        j++;
                        break;
                    }else{
                        map[str.charAt(j)]=false;
                        j++;
                    }
                }
            } else{
                map[str.charAt(i)] = true;
                maxString = (i-j+1) > maxlen ? str.substring(j, (i+1)) : maxString;
                maxlen = (i-j+1) > maxlen ? (i-j+1): maxlen;
            }
            i++;
        }
        return maxString;
    }


}
