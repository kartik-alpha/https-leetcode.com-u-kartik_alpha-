class Solution {

    static boolean isvalid(int[] position , int m , int distance) {
        int count = 1;
        int lastposition = position[0];

        for(int i = 0; i < position.length; i++) {
            if(position[i] - lastposition >= distance ) {
                count++;

                lastposition = position[i];
            }
         
                if(count == m ) {
                    return true;
                }
        }

        return false;

    }
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);

        int s = 1;
        int e = position[position.length - 1] - position[0];
        int ans = 0;

        while(s <= e) {
            int mid = s + (e - s)/2;

            if(isvalid(position , m , mid)) {
                ans = mid;
                s = mid + 1;
            }
            else {

                e = mid  - 1;
            }
        }
        return ans;
    }
}