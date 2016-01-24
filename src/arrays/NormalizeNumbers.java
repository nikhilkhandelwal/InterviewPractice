package arrays;

/**
 * Created by nikhandelwal on 1/17/2016.
 */
public class NormalizeNumbers {


    public static void main(String [] args){

        String[] numbers = {"AAABBBCCCC", "AAA-BBB-CCCC"};
        normalizeNumber(numbers);

        for(String temp: numbers){
            System.out.println(temp);
        }
    }

    public static void normalizeNumber(String [] phoneNumbers){


        StringBuilder normalizeNumber = new StringBuilder();


        for(int i=0;i< phoneNumbers.length; i++){
            String oldNumber = phoneNumbers[i];
            if(oldNumber.length() ==10){
                    phoneNumbers[i] = fixPhoneNumber10(phoneNumbers[i]).toString();
            }
            else if( oldNumber.length() == 12){
                phoneNumbers[i] = fixPhoneNumber12(phoneNumbers[i]).toString();

            }
        }
    }

    private static StringBuilder fixPhoneNumber10(String phoneNumber) {
        StringBuilder normalizeNumber = new StringBuilder();
        int areaCodeStartIndex = 3;
        int areaCodeEndIndex = 5;
        int prefixStartIndex = 0;
        int prefixEndIndex = 2;
        int lineStartIndex = 6;
        int lineEndIndex =9;
        for(int i = areaCodeStartIndex; i<= areaCodeEndIndex; i++){
            normalizeNumber.append(phoneNumber.charAt(i));
        }

        normalizeNumber.append("-");
        for(int i = prefixStartIndex; i<= prefixEndIndex; i++){
            normalizeNumber.append(phoneNumber.charAt(i));
        }
        normalizeNumber.append("-");
        for(int i = lineStartIndex; i<= lineEndIndex; i++){
            normalizeNumber.append(phoneNumber.charAt(i));
        }

        return normalizeNumber;
    }

    private static StringBuilder fixPhoneNumber12(String phoneNumber) {
        StringBuilder normalizeNumber = new StringBuilder();
        int areaCodeStartIndex = 4;
        int areaCodeEndIndex = 6;
        int prefixStartIndex = 0;
        int prefixEndIndex = 2;
        int lineStartIndex = 8;
        int lineEndIndex =11;
        for(int i = areaCodeStartIndex; i<= areaCodeEndIndex; i++){
            normalizeNumber.append(phoneNumber.charAt(i));
        }

        normalizeNumber.append("-");
        for(int i = prefixStartIndex; i<= prefixEndIndex; i++){
            normalizeNumber.append(phoneNumber.charAt(i));
        }
        normalizeNumber.append("-");
        for(int i = lineStartIndex; i<= lineEndIndex; i++){
            normalizeNumber.append(phoneNumber.charAt(i));
        }

        return normalizeNumber;
    }
}
