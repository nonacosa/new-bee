package link.newBee.util;

/**
 * data 2018-08-03   00:49
 * E-mail   sis.nonacosa@gmail.com
 * 更优雅的创建Map
 * @author sis.nonacosa
 */
import com.google.common.collect.ImmutableMap;

import java.util.Map;

import static com.google.common.collect.Maps.newHashMap;


public class MapUtils<K, V> {

    public static <K, V> MapUtils<K, V> newMapUtils() {
        return new MapUtils<>();
    }

    public static <K, V> MapUtils<K, V> newMapUtils(Map<K, V> map) {
        return new MapUtils<>(map);
    }

    private Map<K, V> map = newHashMap();

    public MapUtils() {
        this.map = newHashMap();
    }

    public MapUtils(Map<K, V> map) {
        this.map = newHashMap(map);
    }

    public MapUtils<K, V> putAll(Map<K, V> map) {
        this.map.putAll(map);
        return this;
    }

    public MapUtils<K, V> put(K key, V value) {
        this.map.put(key, value);
        return this;
    }

    public MapUtils<K, V> remove(K key) {
        this.map.remove(key);
        return this;
    }

    public MapUtils<K, V> clear() {
        this.map.clear();
        return this;
    }

    public V get(K key) {
        return map.get(key);
    }

    public boolean containsKey(K key) {
        return map.containsKey(key);
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }

    public Map<K, V> map() {
        return this.map;
    }

    public ImmutableMap<K, V> immutableMap() {
        return ImmutableMap.copyOf(map);
    }
}
