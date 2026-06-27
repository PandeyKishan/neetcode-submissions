class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int right = 0;
        int k = 0;
        StringBuilder check = new StringBuilder();

        // Sort s1 once
        String target = sortString(new StringBuilder(s1)).toString();

        while (right < s2.length()) {
            if (k < s1.length()) {
                check.append(s2.charAt(right));
                right++;
                k++;
            }

            if (k == s1.length()) {
                StringBuilder sorted = sortString(check);

                if (target.equals(sorted.toString()))
                    return true;
                else {
                    check.deleteCharAt(0);
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
