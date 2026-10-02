class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>(); 
        for(int i = 0; i < tasks.length; i++)
            map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int frequency: map.values())
            pq.add(frequency);
        int time = 0;
        while(!pq.isEmpty()) {
            ArrayList<Integer> temp = new ArrayList<>();
            int count = 0;
            while(count <= n && !pq.isEmpty()) {
                int frequency = pq.poll();
                if(frequency - 1 > 0) 
                    temp.add(frequency - 1);

                count++;
                time++;    
            }
            for(int value: temp) 
                pq.add(value);
            if(count <= n && !pq.isEmpty())
                time += (n + 1 - count);  
        }
        return time;
    }
}
