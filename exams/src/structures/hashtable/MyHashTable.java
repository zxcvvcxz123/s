package structures.hashtable;

public class MyHashTable<K, V> {
    private Entry<K, V>[] table;   // Массив элементов хеш-таблицы
    private static int CAPACITY = 13; // Изначальная вместимость
    private int size;    // Количество элементов в хеш-таблице

    // Класс Entry представляет пару ключ-значение
    static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public MyHashTable() {
        table = new Entry[CAPACITY];
    }

    // Метод get для получения значения по ключу
    public V get(K key) {
        int hash = key.hashCode() % CAPACITY;
        Entry<K, V> entry = table[hash];

        // Поиск значения по ключу
        while (entry != null) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
            entry = entry.next;
        }

        return null;
    }

    // Метод put для добавления пары ключ-значение в хеш-таблицу
    public void put(K key, V value) {
        int hash = key.hashCode() % CAPACITY;
        Entry<K, V> entry = table[hash];

        if (entry != null) {
            // Если ключ уже присутствует, обновляем значение
            if (entry.key.equals(key)) {
                entry.value = value;
            } else {
                // Если есть коллизия хеша, добавляем новую запись в начало связанного списка
                Entry<K, V> newEntry = new Entry<>(key, value, entry);
                table[hash] = newEntry;
            }
        } else {
            // Если записей с таким хешом ещё нет, создаём новую
            table[hash] = new Entry<>(key, value, null);
        }

        size++;
    }

    // Метод remove для удаления значения по ключу
    public void remove(K key) {
        int hash = key.hashCode() % CAPACITY;
        Entry<K, V> entry = table[hash];

        if (entry == null)
            return;

        if (entry.key.equals(key)) {
            table[hash] = entry.next;
            size--;
            return;
        }

        while (entry.next != null) {
            if (entry.next.key.equals(key)) {
                entry.next = entry.next.next;
                size--;
                return;
            }
            entry = entry.next;
        }
    }

    // Метод containsKey для проверки наличия ключа в хеш-таблице
    public boolean containsKey(K key) {
        int hash = key.hashCode() % CAPACITY;
        Entry<K, V> entry = table[hash];

        while (entry != null) {
            if (entry.key.equals(key)) {
                return true;
            }
            entry = entry.next;
        }

        return false;
    }

    public int size() {
        return size;
    }
    
    public static void main(String[] args) {
        MyHashTable<String, String> myHashtable = new MyHashTable<>(10);
        myHashtable.put("key1", "value1");
        myHashtable.put("key2", "value2");
        myHashtable.put("key3", "value3");
        myHashtable.put("key4", "value4");

        System.out.println("Value of key1: " + myHashtable.get("key1"));
        System.out.println("Value of key2: " + myHashtable.get("key2"));
        System.out.println("Value of key3: " + myHashtable.get("key3"));
        System.out.println("Value of key4: " + myHashtable.get("key4"));

        myHashtable.remove("key2");
        System.out.println("After removal - value of key2: " + myHashtable.get("key2"));
    }
    
}
