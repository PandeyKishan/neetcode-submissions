class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int maxLength = 1, currLength;
        int left = 0, right = 1;

        if (s.length() == 0)
            return 0;

        // for(int i = 0; i < s.length(); i++) {
        //     if(!set.add(s.charAt(i))) {
        //         maxLength = Math.max(maxLength, currLength);
        //     }

        //     currLength++;
        // }

        set.add(s.charAt(0));
        
        while(right < s.length()) {
            while(right < s.length() && s.charAt(right) == s.charAt(right - 1)) {
                set.clear();
                left = right;
                set.add(s.charAt(left));
                right++;
            }
            if (right == s.length())
                break;    
            while(left < right && set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            currLength = set.size();
            maxLength = Math.max(maxLength, currLength);
            right++;
        }

        return maxLength;
    }
}
