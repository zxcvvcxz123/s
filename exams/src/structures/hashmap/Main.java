package structures.hashmap;

public class Main {

    public static void main(String[] args) {
        MyHashMap<Integer, String> hashMap = new MyHashMap<>(20);
        hashMap.put(1, "123");
        hashMap.put(1, "256");
        hashMap.put(2, "134");

        String valueByPresentKey = hashMap.get(1);
        String valueByNotPresentKey = hashMap.get(3);
        boolean containsPresentKey = hashMap.containsKey(1);
        boolean containsNotPresentKey = hashMap.containsKey(3);
        boolean containsPresentValue = hashMap.containsValue("256");
        boolean containsNotPresentValue = hashMap.containsValue("1234");
    }
}