package algorithm;

import java.util.LinkedList;
import java.util.Iterator;


public class HashTable<K, V> implements Iterable<Entry<K, V>>
{
    private final int SIZE = 6;

    @SuppressWarnings("unchecked")
    private LinkedList<Entry<K, V>>[] table = new LinkedList[SIZE];

    @Override
    public Iterator<Entry<K, V>> iterator()
    {
        LinkedList<Entry<K, V>> allEntries = new LinkedList<>();
        for (LinkedList<Entry<K, V>> bucket : table)
        {
            allEntries.addAll(bucket);
        }
        return allEntries.iterator();
    }

    public HashTable()
    {
        for (int i = 0; i < SIZE; i++)
        {
            table[i] = new LinkedList<>();
        }
    }

    public HashTable(Entry<K, V>[] entries)
    {
        for (int i = 0; i < SIZE; i++)
        {
            table[i] = new LinkedList<>();
        }
        for (Entry<K, V> entry : entries)
        {
            int index = hash(entry.getKey());
            table[index].add(entry);
        }
    }


    public V search(K key)
    {
        int index = hash(key);
        for (Entry<K, V> entry : table[index])
        {
            if (entry.getKey() == key)
            {
                return entry.getValue();
            }
        }
        return null;
    }


    public void insert(K key, V value)
    {
        int index = hash(key);
        // 插入已有的 key 時，更新 value
        for (Entry<K, V> entry : table[index])
        {
            if (entry.getKey() == key)
            {
                entry = new Entry<>(key, value);
                return;
            }
        }

        // 插入新的 key value
        table[index].add(new Entry<>(key, value));
    }


    public void delete(K key)
    {
        int index = hash(key);
        for (Entry<K, V> entry : table[index])
        {
            if (entry.getKey() == key)
            {
                table[index].remove(entry);
                return;
            }
        }
    }

    public void printTable()
    {
        for (int i = 0; i < SIZE; i++)
        {
            System.out.print("Index " + i + ": ");
            for (Entry<K, V> entry : table[i])
            {
                System.out.print("[" + entry.getKey() + ", " + entry.getValue() + "] ");
            }
            System.out.println();
        }
    }


    private int hash(K key)
    {
        if (key instanceof String)
        {
            int hash = 0;
            for (char c : ((String) key).toCharArray())
            {
                hash += c;
            }
            return hash % SIZE;
        }
        return (int)key % SIZE;
    }


}
