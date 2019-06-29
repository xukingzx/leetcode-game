package waitsolve;

public class IsPalindrome {
    public boolean isPalindrome(String s) {
        char[] str = s.toCharArray();
        for(int i = 0;i < str.length;i++){
            str[i] = Character.toLowerCase(str[i]);
        }
        boolean palindrome = true;
        for(int left = 0,right = str.length - 1;left <= right;){
            if(Character.isLetterOrDigit(str[left]) == false){
                left++;
                continue;
            }
            if(Character.isLetterOrDigit(str[right]) == false){
                right--;
                continue;
            }
            if(str[left] != str[right]){
                palindrome = false;
                break;
            }
            else{
                left++;
                right--;
            }
        }
        return palindrome;
    }
}
