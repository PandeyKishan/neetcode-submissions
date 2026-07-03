class Solution {
    public int evalRPN(String[] tokens) {
        int num1, num2;
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+") || tokens[i].equals("-") 
            || tokens[i].equals("*") || tokens[i].equals("/")) {
                num2 = st.pop();
                num1 = st.pop();
                switch(tokens[i]) {
                    case "+":
                        st.push(num1 + num2);
                        break;
                    case "-":
                        st.push(num1 - num2);
                        break;
                    case "*":
                        st.push(num1 * num2);
                        break;
                    case "/":
                        st.push(num1 / num2);
                        break;
                    default:
                        return -1;                

                }
            } else {
                st.push(Integer.valueOf(tokens[i]));
            }
        }

        return st.peek();
    }
}
