class Solution {

    static boolean compareFreq(int[] count1 , int[] count2) {
        for(int i = 0; i < 26; i++) {
            if(count1[i] != count2[i]){
                return false;
            }
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {

        if(s1.length() > s2.length()) {
            return false;
        }

        int[] count1 = new int[26];
        int[] count2 = new int[26];
        // s1 ki freq.. table create kr di....... gyi..
        for(int i = 0; i < s1.length();i++) {
            char ch = s1.charAt(i);
            int index = ch - 'a';
            count1[index]++;
        }

        int i = 0;
        int windowLen = s1.length();
        for( i = 0; i < windowLen;i++) {
            char ch = s2.charAt(i);
            int index = ch - 'a';
            count2[index]++;
        }

        if(compareFreq( count1 , count2) == true) {
            return true;
        }

        else {

            while(i < s2.length()) {
                char newchar = s2.charAt(i);
                int newcharIndex = newchar  - 'a';
                count2[newcharIndex]++;

                int oldcharIndex =  i - windowLen;
                char oldchar = s2.charAt(oldcharIndex);
                int freqtableofindex  = oldchar - 'a';
                count2[freqtableofindex]--;

                  if(compareFreq( count1 , count2) == true) {
            return true;
                  }
            i++;
       
        }
        }
        return false;
    }

}