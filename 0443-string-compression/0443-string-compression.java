class Solution {
    public int compress(char[] chars) {
       
       int readindex = 0;
       int  writeindex = 0;

       while (readindex < chars.length) {
        char currentchar = chars[readindex];
        int count = 0;

        while(readindex < chars.length && currentchar == chars[readindex]){
            readindex++;
            count++;
        }

        chars[writeindex] = currentchar;
        writeindex++;

        if(count > 1){
            String countstr = String.valueOf(count);
            for(char digit : countstr.toCharArray()){
                chars[writeindex++] = digit;
            }
        }

        
    }
    return writeindex;
    }
}