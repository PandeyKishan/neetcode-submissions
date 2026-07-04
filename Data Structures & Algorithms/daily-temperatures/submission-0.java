class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();
        int index;
        // int left = 0, right = 1;

        // int stack[] = new int[temperatures.length];
        // int top = -1;
        // // st.push(temperatures[right]); 
        // // temperatures -> 28
        // // stack -> 6 5
        // // result -> 1 4 1 2 1
        //  index ->    0 1 2 3 4
        for(int i = 0; i < n; i++) {
            // if(st.isEmpty())
            //     st.push(i);
            // else {

                while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]) {
                    index = st.pop();
                    result[index] = i - index;
                }
            // }
            st.push(i);    
        }

        return result;


        // List<Integer> list = new ArrayList<>();
        // list.addFirst(0);
        // st.push(temperatures[n - 1]);
        // // stack -> 30 36 40
        // // list -> 1 2 1 0 0
        // // loop -> 38
        // // count = 1

        // int right = n - 1;
        // int count;

        // for(int i = n - 2; i >= 0; i--) {
        //     count = 0;
        //     while(!st.isEmpty() && st.peek() < temperatures[i]) {
        //         st.pop();
        //         count++;
        //     }
        //     if(st.isEmpty()) {
        //         list.addFirst(0);
        //         count = 0;
        //     }    
        //     if(!st.isEmpty() && st.peek() > temperatures[i])
        //         count = count + 1;
        //     if(count > 0) 
        //         list.addFirst(count);
        //     st.push(temperatures[i]);    
        // }

        // return result;


    }
}
