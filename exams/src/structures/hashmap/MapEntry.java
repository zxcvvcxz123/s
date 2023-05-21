package structures.hashmap;

import java.util.ArrayList;
import java.util.List;

public class MapEntry<K, V> {

    private List<KeyValue<K, V>> data = new ArrayList<>();

    public List<KeyValue<K, V>> getData() {
        return data;
    }

    public void setData(List<KeyValue<K, V>> data) {
        this.data = data;
    }
}
