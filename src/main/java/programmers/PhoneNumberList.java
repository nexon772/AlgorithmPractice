package programmers;

public class PhoneNumberList {

    public static void main(String[] args){
        System.out.println(new PhoneNumberList().solve(new String[]{"119", "97674223", "1195524421"}));
        System.out.println(new PhoneNumberList().solve(new String[]{"123", "456", "789"}));
        System.out.println(new PhoneNumberList().solve(new String[]{"12", "123", "1235", "567", "88"}));
    }

    private boolean solve(String[] phoneBook){
        for(int i=0; i<phoneBook.length; i++){
            for(int j=i+1; j<phoneBook.length; j++){
                boolean result;
                if(phoneBook[i].length() < phoneBook[j].length()){
                    result = compare(phoneBook[j], phoneBook[i]);
                } else if(phoneBook[i].length() > phoneBook[j].length()){
                    result = compare(phoneBook[i], phoneBook[j]);
                } else {
                    result = phoneBook[i].equals(phoneBook[j]);
                }
                if(result){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean compare(String str, String target){
        return str.contains(target);
    }
}
