class Solution {
    public String longestCommonPrefix(String[] strs) {

     if(strs == null || strs.length == 0) return "";

     String pref = strs[0];

     for(int i = 1; i < strs.length;i++) {

        while(!strs[i].startsWith(pref)) {
            pref = pref.substring(0 , pref.length() - 1);

            if(pref.isEmpty())
                return "";
        }
     }

     return pref;

        /*
        int minLen = strs[0].length();

        for(String str : strs) 
            minLen = Math.min(minLen , str.length());

            StringBuilder result  = new StringBuilder();

            for(int i = 0; i < minLen; i++) {

                char ch = strs[0].charAt(i);

                for(String str : strs) {
                    if(str.charAt(i) != ch){
                        return result.toString();
                    }
                }

                result.append(ch);
             }

             return result.toString();

             */
        
    }
}