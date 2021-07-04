package hard;

import java.util.Collections;
import java.util.PriorityQueue;

class MedianFinder {

    /** initialize your data structure here. */
    public MedianFinder() {

    }

    PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> large = new PriorityQueue<>();

    boolean even = true;

    public void addNum(int num) {
        if(even){
            large.offer(num);
            small.offer(large.poll());
        }
        else{
            small.offer(num);
            large.offer(small.poll());
        }
        even = !even;
    }


    public double findMedian() {
        if(even)
            return (large.peek()+small.peek())/2.0;
        else
            return small.peek();
    }
}
