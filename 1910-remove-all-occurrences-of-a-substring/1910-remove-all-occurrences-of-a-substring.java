class Solution {
    public String removeOccurrences(String s, String part) {

        while(s.contains(part)) {

            int index = s.indexOf(part);

            s = s.substring(0 , index) + s.substring(index + part.length());

        }

        return s;
        /*

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
        */
    }
}