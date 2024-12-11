package org.example;
import java.util.HashMap;
import java.util.Map;

interface InMemoryDB {
    Integer get(String key);

    void put(String key, int val);

    void begin_transaction();

    void commit();

    void rollback();
}

public class InMemoryDatabase implements InMemoryDB {
    private final Map<String, Integer> mainStore = new HashMap<>();
    private Map<String, Integer> transactionStore = null;
    private Map<String, Integer> transactionSnapshot = null;

    @Override
    public Integer get(String key) {
        return mainStore.get(key);
    }

    @Override
    public void put(String key, int val) {
        if (transactionStore == null) {
            throw new IllegalStateException("Transaction is not in progress");
        }
        transactionStore.put(key, val);
    }

    @Override
    public void begin_transaction() {
        if (transactionStore != null) {
            throw new IllegalStateException("Transaction is already in progress");
        }
        transactionStore = new HashMap<>();
        transactionSnapshot = new HashMap<>(mainStore);
    }

    @Override
    public void commit() {
        if (transactionStore == null) {
            throw new IllegalStateException("No transaction in progress to commit");
        }
        mainStore.putAll(transactionStore);
        transactionStore = null;
        transactionSnapshot = null;
    }

    @Override
    public void rollback() {
        if (transactionStore == null) {
            throw new IllegalStateException("No transaction in progress to rollback");
        }
        transactionStore = null;
        transactionSnapshot = null;
    }
}
