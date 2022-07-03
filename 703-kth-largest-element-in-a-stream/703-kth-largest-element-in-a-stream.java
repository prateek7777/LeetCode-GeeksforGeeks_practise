class KthLargest {

    private final PriorityQueue<Integer> minHeap;       //minHeap.
    private final Integer k;
    
    
    public KthLargest(int k, int[] nums) {
        
        this.k = k;                                  //initialization.
        minHeap = new PriorityQueue<Integer>();      //intialization.
        for(int ele : nums)                          //adding the elements in the minHeap using a for loop and a function call, as we are adding the elements, each at once.
            add(ele);
        
    }
    
    public int add(int val) {
        //the pivot of the minHeap always points to the smallest element of the minHeap as an implicit property of minHeaps.
        minHeap.add(val);              //adding to minHeap.
        if(minHeap.size() > k) //if the minHeap size is greater than k, one element is evicted.as a property of the minHeap, smallest element will be removed.
            minHeap.remove();
        
        return minHeap.peek(); //the smallest element(the kth largest, naturally) will be at the top of the minHeap(the implicit property) and is just returned, not removed.
        
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */