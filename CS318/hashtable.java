package com.company;
//  Samuel Howell
//  2-13-21
//  CS318


import java.util.Scanner;

public class CodePlayground
{

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter some lowercase characters to store as keys in the hash table ");
        System.out.println("(Their uppercase equivalents will be used as the corresponding values):");
        String charsToHash = scanner.nextLine();

        System.out.println();

        HashTable<Character,Character> ht = new HashTable<Character,Character>();

        for (int i = 0; i < charsToHash.length(); i++) {
            ht.put(charsToHash.charAt(i), charsToHash.toUpperCase().charAt(i)); // lowercase letter is the key, uppercase letter is the value.
        }

        System.out.println(ht);

        System.out.println("Testing retrieval:");
        for (int i = 0; i < charsToHash.length(); i++) {
            System.out.print(ht.get(charsToHash.charAt(i)));
        }
        System.out.println("\n");

        System.out.println("Now enter one or more lowercase character keys to delete from the hash table: ");
        String charsToDelete = scanner.nextLine();
        scanner.close();
        for (int i = 0; i < charsToDelete.length(); i++) {
            ht.delete(charsToDelete.charAt(i));
        }
        System.out.println();

        System.out.println("Testing retrieval after deletion:");
        for (int i = 0; i < charsToHash.length(); i++) {
            Character v = ht.get(charsToHash.charAt(i));
            System.out.print(v != null ? v : '-');
        }
    }
}


class HashTable<Key, Value>
{

    private int size;                       // how many key/value pairs are stored
    private int arrayLength;                // size of the array (and consequently, the mod)
    private Key[] keys;
    private Value[] vals;
    private boolean[] tombstones;           // true if element at this index has been deleted, false otherwise

    public HashTable()
    {
        this(1);  // chains to the other constructor with 1 specified as capacity.
    }

    public HashTable(int capacity)
    {

        // INSERT CODE HERE //
        arrayLength = capacity;                             //  initialize keys, vals, and tombstones to new arrays of size capacity.
        keys = (Key[]) new Object[capacity];
        vals = (Value[]) new Object[capacity];
        tombstones = new boolean[capacity];

    }

    private int hash(Key key)
    {
        return (key.hashCode() & 0x7fffffff) % arrayLength;
    }

    public String toString()
    {
        String s = "";
        for (int i = 0; i < arrayLength; i++)
        {
            s += i + " : " + keys[i] + "/" + vals[i] + "\n";
        }
        return s;
    }

    public void put(Key key, Value val)
    {
        // insert or update the value associated with the given key
        // in the array by hashing and handling any collisions


        // INSERT CODE HERE //
        int c = 0;                                                                                   //c stores how many times it has collided.

        do
        {
            int index = (int) (hash(key) + (.5 * c) + (.5 * Math.pow(c, 2))) % arrayLength;          //  find the index by hashing out the key
            if(keys[index] != null && keys[index].equals(key))                                      //  check to make sure that key isn't null and that key[index] = correct key elem
            {
                return;
            }
            else if(keys[index] == null)                                                            //  if the spot at keys[index] is open...
            {
                tombstones[index] = false;                                                          //  remove the tombstone if it exists
                keys[index] = key;                                                                  //  insert the key into the keys[] at the specified index
                vals[index] = val;                                                                  //  insert the val into the vals[] at the specified index

                size++;

                //  check and see if the array needs to be resized
                if(size > (double)arrayLength / 2)                  //  if its at half capacity...
                {
                    resize(arrayLength * 2);                //  double the size of the array
                }
                else if (size < (double) arrayLength / 8)           //  if its at 1/8 capacity....
                {
                    resize(arrayLength / 2);                //  half the size of the array
                }
                return;
            }
            c++;                                                    //  if we've made it to this line, another collision has occurred, so increment c
        }
        while (true);
    }

    public Value get(Key key)
    {
        // get the value associated with a given key

        // INSERT CODE HERE //
        int c = 0;                                                                                  //  set c to watch for collisions

        do
        {
            int index = (int) (hash(key) + (.5 * c) + (.5 * Math.pow(c, 2))) % arrayLength;          //  find the index by hashing out the key

            if(keys[index] != null && keys[index].equals(key))                                      //  checking for keys[index] != null first prevents nullPointer exception, then check that keys[index] = correct key
            {
                return vals[index];                                                             //  return the appropriate value stored at the index
            }
            else if (!tombstones[index] && keys[index] == null)                             //  if there is NOT a tombstone at the index, and the keys[index] is empty...
            {
                return null;
            }
            c++;                                                                                //  if we've made it to this line, another collision has occurred, so increment c
        }
        while (true);
    }

    public boolean contains(Key key) {


        // INSERT CODE HERE //
        return get(key) != null;            //  call get method on the key passed in through the parameter then return that truth value.

    }

    public void delete(Key key) {


        // INSERT CODE HERE //
        if(!contains((key)))            // if the key is not present in the hashtable at all...
        {
            return;
        }

        //  find the position of the key from parameter and delete it

        int c = 0;                                                                                  //   create c to keep track of collisions

        do
        {
            int index = (int) (hash(key) + (.5 * c) + (.5 * Math.pow(c, 2))) % arrayLength;          //  find the index by hashing out the key

            if(keys[index] == null && !tombstones[index])                           // if keys[index] is null and there is not a tombstone at the index...
            {
                return;
            }
            else if (keys[index].equals(key))
            {
                tombstones[index] = true;                                       //  create a tombstone at the specified index
                vals[index] = null;                                             //  delete the val stored at the index
                keys[index] = null;                                             //  delete the key stored at the index

                size--;                                                         // decrease our size, since technically we have deleted the element from both key[] and vals[]

                //  check and see if the array needs to be resized
                if(size > (double)arrayLength / 2)         //  if its at half capacity...
                {
                    resize(arrayLength * 2);            //  double the size of the array
                }
                else if (size < (double) arrayLength / 8)    //  if its at 1/8 capacity....
                {
                    resize(arrayLength / 2);            //  half the size of the array
                }
                return;
            }
            c++;             //  if we've made it to this line, another collision has occurred, so increment c
        }
        while (true);
    }

    private void resize(int capacity) {
        // resize the array to have the given capacity
        // (requires a rehashing of all items).


        // INSERT CODE HERE //
        if(capacity < 1)            //  if we have a capacity of less than one, then there is no use in resizing
        {
            return;
        }

        //  store the arrayLength. keys, and vals that were already in the array
        int originalArrLength = arrayLength;
        Key[] originalKeys = keys;
        Value[] originalVals = vals;

        //  create new arrays with the capacity brought in by the parameter
        keys = (Key[]) new Object[capacity];
        vals = (Value[]) new Object[capacity];
        arrayLength = capacity;
        tombstones = new boolean[capacity];

        //place original stuff back into the newly resized arrays, rehashing by calling the put() on all the old values.
        for(int i = 0; i < originalArrLength; i++)
        {
            if(originalKeys[i] != null)
            {
                size--;                                             // basically offsets that size++ that happens in the following put()
                put(originalKeys[i], originalVals[i]);
            }
        }
    }
}
