class IntStack {
        private int top;
        private int[] arr;

        IntStack(int size) {
                top = -1;
                arr = new int[size];
        }

        public boolean isEmpty() {
                return top == -1;
        }

        public void push(int data) {
                arr[++top] = data;
        }

        public int pop() {
                return arr[top--];
        }
}

class Tester {
        public static int calculateTotal(String input) {

                IntStack stack = new IntStack(10);
                int num = 0;

                for(int i = 0; i < input.length(); i++) {
                        char ch = input.charAt(i);

                        if(Character.isDigit(ch)) {
                                num = num * 10 + (ch - '0');
                        }
                        else if(ch == ',') {
                                stack.push(num);
                                num = 0;
                        }
                }

                // Push last number
                stack.push(num);

                int total = 0;
                while(!stack.isEmpty()) {
                        total += stack.pop();
                }

                return total;
        }

        public static void main(String[] args) {
                String input = "Rice-50,Oil-120,Sugar-40";
                int total = calculateTotal(input);
                System.out.println("Total Bill: " + total);
        }
}
