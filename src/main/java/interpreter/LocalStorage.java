package interpreter;

import java.util.HashMap;
import java.util.Map;

public class LocalStorage implements Memory<String, Value> {

    private Map<String, Value> memory;

    public LocalStorage() {
        this.memory = new HashMap<>();
    }

    @Override
    public void save(String key, Value value) {
        this.memory.put(key, value);
    }

    @Override
    public Value read(String key) {
        return this.memory.get(key);
    }

    @Override
    public boolean has(String key) {
        return this.memory.containsKey(key);
    }
}
