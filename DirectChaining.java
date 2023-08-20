import java.util.ArrayList;
import java.util.LinkedList;

public class DirectChaining {
    LinkedList<String>[] hashTable;
    int maxChainSize = 5;

    DirectChaining(int size) {
        hashTable = new LinkedList[size];
    }

    // e.g. modASCIIHashFunction("ABC", 24)
    // Ascii values 65 - 67. sum is 192
    // 198 / 24 = 8; 192 % 24 = 6.
    public int modASCIIHashFunction(String word, int M) {
        char ch[];
        ch = word.toCharArray();
        int i, sum;
        for (sum = 0, i = 0; i < word.length(); i++) {
            sum = sum + ch[i];
        }
        return sum % M;
    }

    public void insertHashTable(String word) {
        int newIndex = modASCIIHashFunction(word, hashTable.length);
        if (hashTable[newIndex] == null) {
            hashTable[newIndex] = new LinkedList<String>();
            hashTable[newIndex].add(word);
        } else {
            // Linked list already created
            hashTable[newIndex].add(word);
        }
    }

    public void displayHashTable() {
        if (hashTable == null) {
            return;
        }
        System.out.println("\n-----HashTable------\n");
        for (int i = 0; i < hashTable.length; i++) {
            System.out.println("Index " + i + ", key:" + hashTable[i]);
        }
    }

    public boolean searchHashTable(String word) {
        int newIndex = modASCIIHashFunction(word, hashTable.length);
        if (hashTable[newIndex] != null && hashTable[newIndex].contains(word)) {
            System.out.println("found" + newIndex);
            return true;
        } else {
            System.out.println("not found");
            return false;
        }
    }
}
