class Solution {
        public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        // Map<Character, Integer> map = new HashMap<>();

        // for (int i = 0; i < s.length(); i++) {
        //     map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        // }

        // for (int i = 0; i < t.length(); i++) {
        //     if (map.containsKey(t.charAt(i))) {
        //         map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
        //         if (map.get(t.charAt(i)) == 0) {
        //             map.remove(t.charAt(i));
        //         }
        //     } else {
        //         return false;
        //     }
        // }

        // if (map.isEmpty())
        //     return true;
        // return false;
        int[] charArray = new int[26];

        for(int i = 0; i < s.length(); i++) {
            charArray[s.charAt(i) - 'a']++;
            charArray[t.charAt(i) - 'a']--;
        }

        for(int i = 0; i < charArray.length; i++) {
            int count = charArray[i];
            if(count > 0)
                return false;
        }
        return true;
    }    
}
