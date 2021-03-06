class MyCircularQueue {

            // what is queue: https://youtu.be/1j2gWyY5CK4 
            final int[] a;
    
            int front;
            int rear = -1;
            int len = 0;

            // 初始化 循环queue
            public MyCircularQueue(int k) { a = new int[k];}

            public boolean enQueue(int val) {
                
                if (!isFull()) {
 
                    /** 用這種方式來定位 */
                    rear = (rear + 1) % a.length;
                    a[rear] = val;
                    len++;
                    
                    return true;
                    
                } else {
                    
                    return false;   
                }
                
            }

            public boolean deQueue() {
                
                if (!isEmpty()) {
                    
                    front = (front + 1) % a.length;
                    
                    len--;
                    
                    return true;
                    
                } else return false;
                
            }

            // 下面是常规的操作
            public int Front() { return isEmpty() ? -1 : a[front];}

            public int Rear() {return isEmpty() ? -1 : a[rear];}

            public boolean isEmpty() { return len == 0;}

            public boolean isFull() { return len == a.length;}
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */