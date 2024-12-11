package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        InMemoryDB inmemoryDB = new InMemoryDatabase();

        // should return null, because A doesn’t exist in the DB yet
        System.out.println(inmemoryDB.get("A"));

        // should throw an error because a transaction is not in progress
        try {
            inmemoryDB.put("A", 5);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        inmemoryDB.begin_transaction();
        inmemoryDB.put("A", 5);
        // should return null, because updates to A are not committed yet
        System.out.println(inmemoryDB.get("A"));
        inmemoryDB.put("A", 6);
        inmemoryDB.commit();
        // should return 6, that was the last value of A to be committed
        System.out.println(inmemoryDB.get("A"));

        // throws an error, because there is no open transaction
        try {
            inmemoryDB.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // throws an error because there is no ongoing transaction
        try {
            inmemoryDB.rollback();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // should return null because B does not exist in the database
        System.out.println(inmemoryDB.get("B"));

        inmemoryDB.begin_transaction();
        inmemoryDB.put("B", 10);
        inmemoryDB.rollback();

        // Should return null because changes to B were rolled back
        System.out.println(inmemoryDB.get("B"));
    }
}