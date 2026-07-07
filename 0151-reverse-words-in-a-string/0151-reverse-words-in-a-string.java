class Solution {
    public String reverseWords(String s) {

        StringBuilder ans = new StringBuilder();
        // traversal at the end 
        int i = s.length() - 1;
       //start to end 
        while(i >= 0) {
   // ignore space End ya beech ke extra spaces skip karo
        while( i >= 0 && s.charAt(i) == ' '){
            i--;
        }
         // Agar pura string traverse ho gaya to loop se bahar aa jao
        if(i < 0) {
            break;
        }
        int j = i;

            // Jab tak space na mile, peeche move karte raho
            // Isse word ka start mil jayega
        while(j >= 0 && s.charAt(j) != ' ') {
            j--;
        }

         // Word ko answer me add karo
            // j+1 = word ka start
            // i+1 = substring ka exclusive end
        ans.append(s.substring( j + 1 , i + 1));

         // Word ke baad jo spaces hain unhe skip karo
          while(j >= 0 && s.charAt(j) ==' ') {
            j--;
        }

        //agar word bach gye to space add kre 
        if(j >= 0 ) {
            ans.append(' ');
        }

   // next itreation k liye update--
        i = j;

        }

        return ans.toString();
    }
}



