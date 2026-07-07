class Solution {
    public String removeOccurrences(String s, String part) {

        StringBuilder ans = new StringBuilder();

        for(char ch : s.toCharArray()) {
            ans.append(ch);

        if(ans.length() >= part.length()) {
            if(ans.substring(ans.length() - part.length()).equals(part)){
                ans.delete(ans.length()  - part.length() , ans.length());
            }
        }
        
        }
    
        return ans.toString();
    }
}