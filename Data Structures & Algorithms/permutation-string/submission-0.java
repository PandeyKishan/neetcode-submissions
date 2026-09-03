class Solution {
    public boolean checkInclusion(String s1, String s2) {
                int right = 0, left = 0;
        int k = 0;
        StringBuilder check = new StringBuilder();

        while (right < s2.length()) {
            if (k < s1.length()) {
                check.append(s2.charAt(right));
                right++;
                k++;
            }

            if (k == s1.length()) {
                StringBuilder sorted = sortString(check);

                if (s1.equals(sorted.toString()))
                    return true;
                else {
                    check.deleteCharAt(0);
                    left++;
                    k--;
                }
            }
        }

        return false;
    }

    public StringBuilder sortString(StringBuilder check) {
        char[] chars = check.toString().toCharArray();
        Arrays.sort(chars);
        return new StringBuilder(new String(chars));
    }
}
