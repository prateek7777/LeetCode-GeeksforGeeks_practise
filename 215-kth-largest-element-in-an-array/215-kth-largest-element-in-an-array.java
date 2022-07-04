class Solution {
    public int findKthLargest(int[] nums, int k) {
        //the pivot always points to the smallest element in the priority queue.(implicit property)
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);      //priority queue of size k.
        for(int ele : nums){
         
            pq.add(ele);           //adding the elements to the priority queue one by one.
            if(pq.size() > k)      //if the size of the priority queue exceeds k, the smallest element is removed from the priority queue.
                pq.poll();
   
        }
        return pq.peek();          //the smallest element(naturally, the kth largest) in the priority queue is returned after iteration through the entire nums array is over.
    }
}