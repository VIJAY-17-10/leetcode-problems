import java.util.LinkedList;

class MyHashSet {
    private final int SIZE = 769; // A prime number to reduce collisions
    private LinkedList<Integer>[] table;

    public MyHashSet() {
        table = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            table[i] = new LinkedList<>();
        }
    }
    
    private int hash(int key) {
        return key % SIZE;
    }
    
    public void add(int key) {
        int index = hash(key);
        if (!table[index].contains(key)) {
            table[index].add(key);
        }
    }
    
    public void remove(int key) {
        int index = hash(key);
        table[index].remove((Integer) key);
    }
    
    public boolean contains(int key) {
        int index = hash(key);
        return table[index].contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
