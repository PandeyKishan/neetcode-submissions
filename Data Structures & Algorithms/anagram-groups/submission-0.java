class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        if(strs.length == 1) {
            result.add(Arrays.asList(strs[0]));
            return result;
        }

        for(int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars); 
            String key = new String(chars);

            map.computeIfAbsent(key, k -> new ArrayList<>()).add(strs[i]); 
        }

        for(Map.Entry<String, List<String>> entry: map.entrySet()) {
            result.add(entry.getValue());
        }

        return result;
    }
}
