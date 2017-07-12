package StacksAndQueues;


public class Queue {

    public class QueueFullException extends Exception {
        public QueueFullException(String message) {
            super(message);
        }

    }

    public class QueueEmptyException extends Exception {
        public QueueEmptyException(String message) {
            super(message);
        }

    }

    protected class NegativeNumberException extends Exception {
        public NegativeNumberException(String message) {
            super(message);
        }

    }
}
