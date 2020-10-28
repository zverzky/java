package com.company;

import org.w3c.dom.ls.LSOutput;

import java.util.Collections;
import java.util.Comparator;
import java.util.stream.IntStream;

public class MyList {
    class Node {
        private int value;
        private Node next;
        private Node now;

        public Node(int value) {
            this.value = value;
            this.next = null;
            this.next = null;
        }

        public boolean hasNext() {
            if (this.next == null) {
                return false;
            }
            return true;
        }

        public int compare(Node value) {
            if (value.getValue() > this.value) {
                return 1;
            } else if (value.getValue() == this.value) {
                return 0;
            } else {
                return -1;
            }
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public Node getNow() {
            return now;
        }

        public void setNow(Node now) {
            this.now = now;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public String toString() {
            return Integer.toString(this.value);
        }
    }

    private Node begin;
    private int counter;
    private int length;
    private int pozition;

    public MyList() {
        this.begin = null;
        this.counter = 1;
        this.length = 1;
        this.pozition = 1;
    }

    public void add(int value) {
        Node newvalue = new Node(value);
        if (this.begin == null) {
            this.begin = newvalue;
        } else {
            this.end().setNext(newvalue);
        }
    }


    public String toString() {
        String result = "[ ";
        if (this.begin != null) {
            Node iter = this.begin;
            while (iter.hasNext()) {
                result += iter.toString() + ", ";
                iter = iter.getNext();
            }
            result += iter.toString() + " ";
        }
        result += "]";
        return result;
    }

    public Node end() {
        Node iter = this.begin;
        while (iter.hasNext()) {
            iter = iter.getNext();
        }
        return iter;
    }

    public Node indexAt(int index) {
        Node iter = this.begin;
        int iter2 = kol();
        if (index <= iter2) {
            while (iter.hasNext() && this.counter < index) {
                iter = iter.getNext();
                this.counter++;
            }
            this.counter = 1;
            return iter;
        } else {
            return null;
        }
    }

    public int givePozition(Node value) {
        Node iter = this.begin;
        this.pozition = 1;
        while (iter.hasNext()) {
            if (iter.compare(value) == 0) {
                break;
            } else {
                iter = iter.getNext();
                this.pozition++;
            }
        }
        return this.pozition;
    }


    public int kol() {
        this.length = 1;
        Node iter = this.begin;
        while (iter.hasNext()) {
            iter = iter.getNext();
            this.length++;
        }
        return this.length;

    }

    public void sort() {
        Node iter = this.begin;
//        for (int i = 1; i < kol() - 1; i++) {
//            while (iter.hasNext()) {
//                if (iter.compare(iter.next) == 1) {
//                    swap(givePozition(iter), givePozition(iter.next));
//                }
//                iter = iter.getNext();
//            }
//        }
        while (iter.hasNext()) {
            for (int i = 1; i < kol() - 1; i++) {
                if (iter.compare(iter.next) == 1) {
                    System.out.println(iter);
                    System.out.println(iter.next);
                    swap(givePozition(iter), givePozition(iter.next));
                    System.out.println(iter);
                    System.out.println(iter.next);
                }
                iter = iter.getNext();
            }
        }

    }


    public void swap(int firstPos, int secondPos) {
        Node itFirstPos = indexAt(firstPos);
        Node itSecondPos = indexAt(secondPos);
        Node itPreFirstPos = indexAt(firstPos - 1);
        Node itPreSecondPos = indexAt(secondPos - 1);
        if (firstPos == 1) {
            this.begin = itSecondPos;
            itPreSecondPos.next = itFirstPos;

            Node iter = itFirstPos.next;
            itFirstPos.next = itSecondPos.next;
            itSecondPos.next = iter;

        } else {
            itPreFirstPos.setNext(itSecondPos);
            itPreSecondPos.setNext(itFirstPos);

            Node iter = itFirstPos.next;
            itFirstPos.next = itSecondPos.next;
            itSecondPos.next = iter;
        }
    }
}
