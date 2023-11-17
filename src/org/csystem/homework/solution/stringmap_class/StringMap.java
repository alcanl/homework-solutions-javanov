package org.csystem.homework.solution.stringmap_class;

import java.util.HashMap;
import java.util.Optional;

public class StringMap<T> implements IStringMap<T> {
    private final HashMap<String, T> hashMap;
    private void checkParameter(String key)
    {
        if (key == null || key.isBlank())
            throw new IllegalArgumentException();
    }
    public StringMap()
    {
        hashMap = new HashMap<>();
    }
    @Override
    public int count()
    {
        return hashMap.keySet().size();
    }

    @Override
    public boolean addElement(String key, T value)
    {
        checkParameter(key);

        if (hashMap.containsKey(key)) {
            hashMap.replace(key, value);
            return true;
        }
        else {
            hashMap.put(key, value);
            return false;
        }
    }
    @Override
    public boolean removeElement(String key)
    {
        checkParameter(key);

        return hashMap.remove(key) != null;
    }

    @Override
    public Optional<T> getValue(String key)
    {
        checkParameter(key);

        Optional<T> optional = Optional.empty();

        if (hashMap.containsKey(key))
            optional = Optional.of(hashMap.get(key));

        return optional;
    }

    @Override
    public T getValue(String key, T defaultValue)
    {
        checkParameter(key);

        return hashMap.getOrDefault(key, defaultValue);
    }
}
