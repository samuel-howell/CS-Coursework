package com.company;
import java.util.*;

/*
Name:   Samuel Howell
Class:  CS227
Date:   10-29-20
File:   BinarySearchTreeImplementation
Descr:  Add methods to find the height of the BST and the postorder using Stacks.
 */
public class BinarySearchTreeImplementation
{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> intArr = new ArrayList<Integer>();
        System.out.println("enter 10 integer values, separating each with a space:");
        String input = sc.nextLine();

        //  split the input into a string array
        String[] stringArr = input.split(" ");

        //parse the user input to 10 ints, and check for input validation
       try
       {
           for (String s:  stringArr)
           {
              intArr.add(Integer.parseInt(s));
           }
       }
       catch (Exception e)
       {
           System.out.println("please only enter integer values");
       }

       BST<Integer> tree = new BST<>();

        for (int i = 0; i < intArr.size(); i++)
        {
            System.out.println(intArr.get(i) + " ");
            tree.insert(intArr.get(i));
        }
        System.out.println("the tree size is " + tree.getSize());
        System.out.println("the tree root is " + tree.getRoot().element);
        System.out.println("the height is " + tree.height(tree.root));
        System.out.println("postorder is ");
        tree.stackPostorder(tree);

    }

    public interface Tree<E> extends Collection<E>
    {
        public boolean search (E e);
        public boolean insert (E e);
        public boolean delete (E e);
        public int getSize ();
        public default void inorder() {}
        public default void postorder() {}
        public default void preorder() {}

        @Override
        public  default boolean isEmpty()
        {
            return size() == 0;
        }

        @Override
        public default boolean contains(Object e)
        {
            return  search((E)e);
        }

        @Override
        public default boolean add(E e)
        {
            return insert(e);
        }

        @Override
        public default boolean remove(Object e)
        {
            return delete((E)e);
        }

        @Override
        public default int size()
        {
            return getSize();
        }

        @Override
        public default boolean containsAll (Collection<?> c)
        {
            //  left as an exercise
            return false;
        }

        @Override
        public default boolean addAll(Collection<? extends E> c)
        {
            //  left as an exercise
            return false;
        }

        @Override
        public default boolean removeAll(Collection<?> c)
        {
            //  left as an exercise
            return false;
        }

        @Override
        public default boolean retainAll(Collection<?> c)
        {
            //  left as an exercise
            return false;
        }

        @Override
        public default Object[] toArray()
        {
            //  left as an exercise
            return null;
        }

        @Override
        public default <T> T[] toArray(T[] array)
        {
            //  left as an exercise
            return null;
        }
    }

    public static class BST<E extends Comparable<E>> implements Tree<E> {
        protected TreeNode<E> root;
        protected int size = 0;

        /** Create a default binary tree */
        public BST() {
        }

        /** Create a binary tree from an array of objects */
        public BST(E[] objects) {
            for (int i = 0; i < objects.length; i++)
                add(objects[i]);
        }

        @Override /** Returns true if the element is in the tree */
        public boolean search(E e) {
            TreeNode<E> current = root; // Start from the root

            while (current != null) {
                if (e.compareTo(current.element) < 0) {
                    current = current.left;
                }
                else if (e.compareTo(current.element) > 0) {
                    current = current.right;
                }
                else // element matches current.element
                    return true; // Element is found
            }

            return false;
        }

        @Override /** Insert element e into the binary tree
         * Return true if the element is inserted successfully */
        public boolean insert(E e) {
            if (root == null)
                root = createNewNode(e); // Create a new root
            else {
                // Locate the parent node
                TreeNode<E> parent = null;
                TreeNode<E> current = root;
                while (current != null)
                    if (e.compareTo(current.element) < 0) {
                        parent = current;
                        current = current.left;
                    }
                    else if (e.compareTo(current.element) > 0) {
                        parent = current;
                        current = current.right;
                    }
                    else
                        return false; // Duplicate node not inserted

                // Create the new node and attach it to the parent node
                if (e.compareTo(parent.element) < 0)
                    parent.left = createNewNode(e);
                else
                    parent.right = createNewNode(e);
            }

            size++;
            return true; // Element inserted successfully
        }

        protected TreeNode<E> createNewNode(E e) {
            return new TreeNode<>(e);
        }

        @Override /** Inorder traversal from the root */
        public void inorder() {
            inorder(root);
        }

        /** Inorder traversal from a subtree */
        protected void inorder(TreeNode<E> root) {
            if (root == null) return;
            inorder(root.left);
            System.out.print(root.element + " ");
            inorder(root.right);
        }

//        @Override /** Postorder traversal from the root */
//        public void postorder() {
//            postorder(root);
//        }

//        /** Postorder traversal from a subtree using RECURSION */
//        protected void postorder(TreeNode<E> root) {
//            if (root == null) return;
//            postorder(root.left);
//            postorder(root.right);
//            System.out.print(root.element + " ");
//        }

        //  ****************************  HOMEWORK PORTION  ******************************************** //

        //  Postorder traversal using a stack instead of recursion
        public void stackPostorder(BST<E> tree)
        {
            Stack<TreeNode<E>> stack1 = new Stack<>();
            Stack<TreeNode<E>> stack2 = new Stack<>();

            if(tree.root == null)       // will return nothing if the tree is empty
            {
                return;
            }

            stack1.push(root);      //  will push the root to the first stack

            while (!stack1.isEmpty())
            {
                TreeNode<E> temp = stack1.pop();        //  pop element from stack1 and push it into stack2
                stack2.push(temp);

                if(temp.left != null) stack1.push(temp.left);   //  handles left children of removed item
                if(temp.right != null) stack1.push(temp.right);  //  handles right children of removed item
            }

            while(!stack2.isEmpty())        //print out the result
            {
                TreeNode<E> temp = stack2.pop();
                System.out.print(temp.element + ", ");
            }
        }



        // height method
        public int height(TreeNode<E> root)
        {
            if(root == null)
            {
                return 0;
            }

            //  use a recursive function to find the biggest node and follow that path until you reach a leaf
            return findBiggerNode(height(root.left), height(root.right)) + 1;
        }

        int findBiggerNode(int a, int b)
        {
            if (a >= b)
            {
                return a;
            }
            else
            {
                return b;
            }
        }

        //  ****************************  HOMEWORK PORTION  ******************************************** //


        @Override /** Preorder traversal from the root */
        public void preorder() {
            preorder(root);
        }

        /** Preorder traversal from a subtree */
        protected void preorder(TreeNode<E> root) {
            if (root == null) return;
            System.out.print(root.element + " ");
            preorder(root.left);
            preorder(root.right);
        }


        /** This inner class is static, because it does not access
         any instance members defined in its outer class */
        public static class TreeNode<E> {
            protected E element;
            protected TreeNode<E> left;
            protected TreeNode<E> right;

            public TreeNode(E e) {
                element = e;
            }
        }

        @Override /** Get the number of nodes in the tree */
        public int getSize() {
            return size;
        }

        /** Returns the root of the tree */
        public TreeNode<E> getRoot() {
            return root;
        }

        /** Returns a path from the root leading to the specified element */
        public java.util.ArrayList<TreeNode<E>> path(E e) {
            java.util.ArrayList<TreeNode<E>> list =
                    new java.util.ArrayList<>();
            TreeNode<E> current = root; // Start from the root

            while (current != null) {
                list.add(current); // Add the node to the list
                if (e.compareTo(current.element) < 0) {
                    current = current.left;
                }
                else if (e.compareTo(current.element) > 0) {
                    current = current.right;
                }
                else
                    break;
            }

            return list; // Return an array list of nodes
        }

        @Override /** Delete an element from the binary tree.
         * Return true if the element is deleted successfully
         * Return false if the element is not in the tree */
        public boolean delete(E e) {
            // Locate the node to be deleted and also locate its parent node
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while (current != null) {
                if (e.compareTo(current.element) < 0) {
                    parent = current;
                    current = current.left;
                }
                else if (e.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                }
                else
                    break; // Element is in the tree pointed at by current
            }

            if (current == null)
                return false; // Element is not in the tree

            // Case 1: current has no left child
            if (current.left == null) {
                // Connect the parent with the right child of the current node
                if (parent == null) {
                    root = current.right;
                }
                else {
                    if (e.compareTo(parent.element) < 0)
                        parent.left = current.right;
                    else
                        parent.right = current.right;
                }
            }
            else {
                // Case 2: The current node has a left child
                // Locate the rightmost node in the left subtree of
                // the current node and also its parent
                TreeNode<E> parentOfRightMost = current;
                TreeNode<E> rightMost = current.left;

                while (rightMost.right != null) {
                    parentOfRightMost = rightMost;
                    rightMost = rightMost.right; // Keep going to the right
                }

                // Replace the element in current by the element in rightMost
                current.element = rightMost.element;

                // Eliminate rightmost node
                if (parentOfRightMost.right == rightMost)
                    parentOfRightMost.right = rightMost.left;
                else
                    // Special case: parentOfRightMost == current
                    parentOfRightMost.left = rightMost.left;
            }

            size--;
            return true; // Element deleted successfully
        }

        @Override /** Obtain an iterator. Use inorder. */
        public java.util.Iterator<E> iterator() {
            return new InorderIterator();
        }

        // Inner class InorderIterator
        private class InorderIterator implements java.util.Iterator<E> {
            // Store the elements in a list
            private java.util.ArrayList<E> list =
                    new java.util.ArrayList<>();
            private int current = 0; // Point to the current element in list

            public InorderIterator() {
                inorder(); // Traverse binary tree and store elements in list
            }

            /** Inorder traversal from the root*/
            private void inorder() {
                inorder(root);
            }

            /** Inorder traversal from a subtree */
            private void inorder(TreeNode<E> root) {
                if (root == null)return;
                inorder(root.left);
                list.add(root.element);
                inorder(root.right);
            }

            @Override /** More elements for traversing? */
            public boolean hasNext() {
                if (current < list.size())
                    return true;

                return false;
            }

            @Override /** Get the current element and move to the next */
            public E next() {
                return list.get(current++);
            }

            @Override /** Remove the current element */
            public void remove() {
                delete(list.get(current)); // Delete the current element
                list.clear(); // Clear the list
                inorder(); // Rebuild the list
            }
        }

        @Override /** Remove all elements from the tree */
        public void clear() {
            root = null;
            size = 0;
        }
    }
}

