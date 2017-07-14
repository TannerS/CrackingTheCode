package StacksAndQueues;


public class StackExceptions {

    public class StackFullException extends Exception {
        public StackFullException(String message) {
            super(message);
        }

    }

    public class StackEmptyException extends Exception {
        public StackEmptyException(String message) {
            super(message);
        }

    }

    protected class NegativeNumberException extends Exception {
        public NegativeNumberException(String message) {
            super(message);
        }

    }
}
