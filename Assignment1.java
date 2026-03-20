class CharStack {
        private int top;
        private char[] arr;

        CharStack(int size) {
                top = -1;
                arr = new char[size];
        }

        public boolean isEmpty() {
                return top == -1;
        }

        public boolean push(char data) {
                if (top == arr.length - 1)
                        return false;
                arr[++top] = data;
                return true;
        }

        public char pop() {
                if (isEmpty())
                        return '\0';
                return arr[top--];
        }
}

class Tester {
        public static String reverseString(String str) {
                //Implement your Logic here

                CharStack stack = new CharStack(str.length());
                String reversed = "";

                // Push characters to stack
                for (int i = 0; i < str.length(); i++) {
                        stack.push(str.charAt(i));
                }

                // Pop characters to form reversed string
                while (!stack.isEmpty()) {
                        reversed = reversed + stack.pop();
                }

                return reversed;
        }

        public static void main(String[] args) {
                String str = "hello";
                System.out.println("Reversed: " + reverseString(str));
        }
}
