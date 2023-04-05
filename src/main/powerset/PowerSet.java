package main.powerset;

import java.util.Hashtable;

public class PowerSet
{

    public final Hashtable<String, Object> ht;
    private final Object obj;

    public PowerSet()
    {
        ht = new Hashtable<>(20000);
        obj = new Object();
    }

    public int size()
    {
        return ht.size();
    }

    public void put(String value)
    {
        ht.put(value, obj);
    }

    public boolean get(String value)
    {
        return ht.containsKey(value);
    }

    public boolean remove(String value)
    {
        return ht.remove(value, obj);
    }

    public PowerSet intersection(PowerSet set2)
    {
        PowerSet rsl = new PowerSet();
        set2.ht.forEach((k,v) -> {
            if (this.get(k)) {
                rsl.put(k);
            }
        });
        return rsl;
    }

    public PowerSet union(PowerSet set2)
    {
        PowerSet rsl = new PowerSet();
        this.ht.forEach((k, v) -> rsl.put(k));
        set2.ht.forEach((k, v) -> rsl.put(k));
        return rsl;
    }

    public PowerSet difference(PowerSet set2)
    {
        PowerSet rsl = new PowerSet();
        this.ht.forEach((k,v) -> {
            if (!set2.get(k)) {
                rsl.put(k);
            }
        });
        return rsl;
    }

    public boolean isSubset(PowerSet set2)
    {
        return this.union(set2).size() == this.size();
    }
}
