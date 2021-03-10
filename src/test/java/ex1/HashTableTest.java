package ex1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class HashTableTest {


    @ParameterizedTest
    @CsvSource({"12", "25", "35" })
    void count(int añadir) {
        HashTable hashTable = new HashTable();
        for (int i = 0; i < añadir; i++) {
            hashTable.put(String.valueOf(añadir), String.valueOf(añadir));
        }
        Assertions.assertEquals(añadir, hashTable.count());
    }

    @org.junit.jupiter.api.Test
    void size() {
        HashTable hashTable = new HashTable();
        Assertions.assertEquals(16, hashTable.size());
    }

    @ParameterizedTest
    @CsvSource({"Hola, 5", "Adios, 12", "Hasta pronto, 20"})
    void put(String valor, String clave) {
        HashTable hashTable = new HashTable();
        for (String primeraClave : hashTable.getCollisionsForKey(clave,7)){
            hashTable.put(primeraClave, valor);
            Assertions.assertEquals(valor, hashTable.get(primeraClave));
        }
    }

    @org.junit.jupiter.api.Test
    void get() {
        String valor = "Hola";
        String clave = "5";
        HashTable hashTable = new HashTable();
        hashTable.put(clave, valor);
        Assertions.assertEquals(valor, hashTable.get(clave));
    }

    @ParameterizedTest
    @CsvSource({"Hola, 5", "Adios, 12", "Hasta pronto, 20"})
    void drop(String valor, String clave) {
        HashTable hashTable = new HashTable();
        for (String primeraClave : hashTable.getCollisionsForKey(clave, 7)){
            hashTable.drop(primeraClave);
            Assertions.assertEquals(null, hashTable.get(primeraClave));
        }
    }
}