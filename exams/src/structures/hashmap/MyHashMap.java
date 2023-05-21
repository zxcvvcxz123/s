package structures.hashmap;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MyHashMap<K, V> {

    private final MapEntry<K, V>[] data;

    public MyHashMap(int capacity) {
        this.data = (MapEntry<K, V>[]) new MapEntry[capacity];
        for (int i = 0; i < capacity; i++) {
            data[i] = new MapEntry<>();
        }
    }

    public int size() {
        return (int) Arrays.stream(data)
                .mapToLong(d -> d.getData().size())
                .sum();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public V get(Object key) {
        int hashCode = key.hashCode();
        List<KeyValue<K, V>> keyValues = getKeyValuesByHashCode(hashCode);

        return keyValues.stream()
                .filter(keyValue -> checkHashCodeAndEquals(key, hashCode, keyValue))
                .findAny()
                .map(KeyValue::getValue)
                .orElse(null);
    }

    private boolean checkHashCodeAndEquals(Object key, int hashCode, KeyValue<K, V> keyValuePair) {
        return keyValuePair.getKey().hashCode() == hashCode
                && keyValuePair.getKey().equals(key);
    }

    public boolean containsKey(Object key) {
        int hashCode = key.hashCode();
        List<KeyValue<K, V>> keyValues = getKeyValuesByHashCode(hashCode);
        if (keyValues.isEmpty()) {
            return false;
        }

        return keyValues.stream()
                .anyMatch(kv -> checkHashCodeAndEquals(key, hashCode, kv));
    }

    public boolean containsValue(Object value) {
        return Arrays.stream(data)
                .anyMatch(entry -> entry.getData()
                        .stream()
                        .anyMatch(keyValue -> keyValue.getValue().equals(value))
                );
    }

    public void put(K key, V value) {
        KeyValue<K, V> keyValue = new KeyValue<>();
        keyValue.setKey(key);
        keyValue.setValue(value);

        int hashCode = key.hashCode();
        List<KeyValue<K, V>> keyValues = getKeyValuesByHashCode(hashCode);

        if (keyValues.isEmpty()) {
            keyValues.add(keyValue);
            return;
        }

        Optional<KeyValue<K, V>> possibleDuplicateKey = keyValues.stream()
                .filter(kv -> checkHashCodeAndEquals(key, hashCode, kv))
                .findAny();
        if (possibleDuplicateKey.isPresent()) {
            KeyValue<K, V> duplicateKeyValue = possibleDuplicateKey.get();
            duplicateKeyValue.setValue(value);
            return;
        }

        keyValues.add(keyValue);
    }

    private List<KeyValue<K, V>> getKeyValuesByHashCode(int hashCode) {
        int index = hashCode % data.length;
        MapEntry<K, V> entry = data[index];
        return entry.getData();
    }
}
