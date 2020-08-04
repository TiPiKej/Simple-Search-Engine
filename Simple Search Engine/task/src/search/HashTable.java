package search;

public class HashTable<T> {
    private int size;
    private TableEntry[] table;
    private int usedSize;

    public HashTable(int size) {
        this.size = size;
        table = new TableEntry[size];
        usedSize = 0;
    }

    public boolean put(int key, T value) {
        if (usedSize == size) rehash();

        int index = findKey(key);

        if (index == -1) {
            return false;
        }

        table[index] = new TableEntry(key, value);
        usedSize++;

        return true;
    }

    public int get(int key, T value) {
        int idx = findKey(key);

        if (idx == -1 || table[idx] == null) {
            return -1;
        }

        return idx;
    }

    private int findKey(int key) {
        int hash = key % size;

        while (!(table[hash] == null || table[hash].getKey() == key)) {
            hash = (hash + 1) % size;

            if (hash == key % size) {
                return -1;
            }
        }

        return hash;
    }

    private void rehash() {
        final int scalingFactor = 2;

        TableEntry[] oldTable = table;

        size *= scalingFactor;
        this.table = new TableEntry[size];
        usedSize = 0;

        for (TableEntry entry : oldTable) {
            this.put(entry.getKey(), (T) entry.getValue());
        }
    }

    @Override
    public String toString() {
        StringBuilder tableStringBuilder = new StringBuilder();

        for (int i = 0; i < table.length; i++) {
            if (table[i] == null) {
                tableStringBuilder.append(i + ": null");
            } else {
                tableStringBuilder.append(i + ": key=" + table[i].getKey()
                        + ", value=" + table[i].getValue());
            }

            if (i < table.length - 1) {
                tableStringBuilder.append("\n");
            }
        }

        return tableStringBuilder.toString();
    }

    private static int createKey(String word, int length) {
        String ret = "";
        int i = 0;
        while (ret.length() < length && i < word.length()) {
            char ch = word.toCharArray()[i++];
            ret += (int) ch;
        }

        while (ret.length() < length) {
            ret = "0" + ret;
        }

        if (ret.length() > length) {
            ret = ret.substring(0, length);
        }

        return Integer.parseInt(ret);
    }
}
