package main.bloomfilter;

public class BloomFilter {
    public int filter_len;
    public int filter;

    public BloomFilter(int f_len)
    {
        filter_len = f_len;
    }

    public int hash1(String str1)
    {
        int code = 0;
        for(int  i = 0; i < str1.length(); i++)
        {
            code = 17 * code + (int)str1.charAt(i);
        }
        return code % filter_len;
    }

    public int hash2(String str1)
    {
        int code = 0;
        for(int  i = 0; i < str1.length(); i++)
        {
            code = 223 * code + (int)str1.charAt(i);
        }
        return code % filter_len;
    }

    public void add(String str1)
    {
        filter = filter ^ 1 << hash1(str1);
        filter = filter ^ 1 << hash2(str1);
    }

    public boolean isValue(String str1)
    {
        int mask1 = 1 << hash1(str1);
        int mask2 = 1 << hash2(str1);
        return mask1 == (filter & mask1) && mask2 == (filter & mask2);
    }
}
