package com.company;
//  Samuel Howell
//  2-5-21
//  CS318

//  Design two classes: Node and BSTOfIntegersImplement the methods (using recursion):
//  -insert(int e)
//  -delete(int e)
//  -search(int e)
//  -postOrder()
//  -inOrder()
//  -preOrder()


public class CodePlayground
{

    public static void main(String[] args)
    {
        //  driver code
        int[] intArr = {2, 4, 3, 1, 5};

        BSTOfIntegers bst = new BSTOfIntegers();
        BSTOfIntegers emptyBst = new BSTOfIntegers();
        BSTOfIntegers bstIntArr = new BSTOfIntegers(intArr);

        System.out.println();
        System.out.println("---------------  INSERT METHOD  ---------------");
        System.out.println();

            System.out.println("bstIntArr was populated with 2, 4, 3, 1, 5");
            System.out.println("Nothing was inserted into emptyBst.");
            System.out.println("Testing insert method...inserting 2, 4, 3, 1, 5 into bst...");
            bst.insert(2);
            bst.insert(4);
            bst.insert(3);
            bst.insert(1);
            bst.insert(5);

        System.out.println();
        System.out.println("---------------  SEARCH METHOD  ---------------");
        System.out.println();

            System.out.println("Testing search method...");
            System.out.println("the search for 2 in bst returns: " + bst.search(2));
            System.out.println("the search for 6 in bst returns: " + bst.search(6));
            System.out.println("the search for 1 in bstIntArr returns: " + bstIntArr.search(2));
            System.out.println("the search for 6 in bstIntArr returns: " + bstIntArr.search(6));
            System.out.println("the search for 2 in emptyBst returns: " + emptyBst.search(2));
            System.out.println("the search for 6 in emptyBst returns: " + emptyBst.search(6));

        System.out.println();
        System.out.println("---------------  PreOrder, InOrder, PostOrder METHODS  ---------------");
        System.out.println();

            System.out.println("-------  FOR bst -------");
                System.out.println("preOrder traversal for bst looks like: ");
                bst.preOrder(bst.root);
                System.out.println();

                System.out.println("inOrder traversal for bst looks like: ");
                bst.inOrder(bst.root);
                System.out.println();

                System.out.println("postOrder traversal for bst looks like: ");
                bst.postOrder(bst.root);
                System.out.println();

            System.out.println("-------  FOR bstIntArr -------");
                System.out.println("preOrder traversal for bstIntArr looks like: ");
                bstIntArr.preOrder(bstIntArr.root);
                System.out.println();

                System.out.println("inOrder traversal for bstIntArr looks like: ");
                bstIntArr.inOrder(bstIntArr.root);
                System.out.println();

                System.out.println("postOrder traversal for bstIntArr looks like: ");
                bstIntArr.postOrder(bstIntArr.root);
                System.out.println();

            System.out.println("-------  FOR emptyBst -------");
                System.out.println("preOrder traversal for emptyBst looks like: ");
                emptyBst.preOrder(emptyBst.root);

                System.out.println("inOrder traversal for emptyBst looks like: ");
                emptyBst.inOrder(emptyBst.root);

                System.out.println("postOrder traversal for emptyBst looks like: ");
                emptyBst.postOrder(emptyBst.root);

        System.out.println();
        System.out.println("---------------  DELETION METHOD  ---------------");
        System.out.println();

            System.out.println("---");

                System.out.println("Before deletion postOrder traversal for bstIntArr looks like: ");
                bstIntArr.postOrder(bstIntArr.root);
                System.out.println();

                System.out.println("Testing deletion on bstIntArr... deleting 3...");
                bstIntArr.delete(3);
                System.out.println();

                System.out.println("After deletion postOrder traversal for bstIntArr looks like: ");
                bstIntArr.postOrder(bstIntArr.root);
                System.out.println();

            System.out.println("---");

                System.out.println("Before deletion postOrder traversal for bst looks like: ");
                bst.postOrder(bst.root);
                System.out.println();

            System.out.println("Testing deletion on bst... deleting 3...");
                bst.delete(3);
                System.out.println();

                System.out.println("After deletion postOrder traversal for bst looks like: ");
                bst.postOrder(bst.root);
                System.out.println();

            System.out.println("---");

                System.out.println("Before deletion postOrder traversal for emptyBst looks like: ");
                emptyBst.postOrder(emptyBst.root);
                System.out.println();

            System.out.println("Testing deletion on emptyBst... deleting 3...");
                emptyBst.delete(3);
                System.out.println();

                System.out.println("After deletion postOrder traversal for emptyBst looks like: ");
                emptyBst.postOrder(emptyBst.root);
                System.out.println();

            System.out.println("Inserting 1 and 3 into emptyBst...");
                emptyBst.insert(1);
                emptyBst.insert(3);
            System.out.println("Now inOrder of emptyBst is...");
                emptyBst.inOrder(emptyBst.root);
            System.out.println();
            System.out.println("Inserting 1 AGAIN into emptyBst...");
                emptyBst.insert(1);
    }
}

class BSTOfIntegers
{
    Node root;

    public BSTOfIntegers()                      //  default constructor.
    {
    }

    public BSTOfIntegers(int[] nodes)           //  parameterized constructor used to take in int[]
    {
        for(int n : nodes)
        {
            this.insert(n);
        }
    }


    public void inOrder(Node root)              //  inorder method, using recursion.  LEFT -> ROOT -> RIGHT
    {
        if (root == null)                       //  base case: you reach the leaf root, meaning there is nothing else to explore.
        {
            return;
        }
        inOrder(root.left);                     //  recursively call inOrder  on root.left, quickly traversing down the left subtree
        System.out.print(root.data + " ");      //  print the data stored in the root.
        inOrder(root.right);                    //  recursively call inOrder  on root.right, quickly traversing down the right subtree
    }

    public void preOrder(Node root)             //  preOrder method, using recursion.  ROOT -> LEFT -> RIGHT
    {
        if (root == null)                       //  base case: you reach the leaf root, meaning there is nothing else to explore.
        {
            return;
        }
        System.out.print(root.data + " ");      //  print the data stored at the root
        preOrder(root.left);                    //  recursively call inOrder  on root.left, quickly traversing down the left subtree
        preOrder(root.right);                   //  recursively call inOrder  on root.right, quickly traversing down the right subtree
    }

    public void postOrder(Node root)            //  postOrder method, using recursion.  LEFT -> RIGHT -> ROOT
    {
        if (root == null)                       //  base case: you reach the leaf root, meaning there is nothing else to explore.
        {
            return;
        }
        postOrder(root.left);                   //  recursively call inOrder  on root.left, quickly traversing down the left subtree
        postOrder(root.right);                  //  recursively call inOrder  on root.right, quickly traversing down the right subtree
        System.out.print(root.data + " ");      //  print the data stored at the root
    }


    public boolean search(int e)                //  boolean method to search the BST for a certain int value
    {
        Node current = root;

        while (current != null)
        {
            if (e < current.data)
            {
                current = current.left;         //  traverse down the left subtree if e is smaller
            }
            else if (e > current.data)
            {
                current = current.right;        //  traverse down the right subtree if e is bigger
            }
            else
            {
                return true;                    //  if we have not reached the end of the BST, and the other two conditions have been skipped, then we must have found e
            }
        }
        return false;                           //  if we have exited the while loop, then that means e was not in the BST
    }

    public void insert(int e)                   //  insert method that calls overloaded insert().  Makes it simpler, because now we don't have to specify Node node every time we insert.
    {
        insert(root, e);
    }

    public void insert(Node root, int e)        //  overloaded method. by placing Node root in our parameter, we can recursively call the insert() method to traverse down the tree.
    {
        if(root == null)
        {
            this.root = new Node(e);            //  if nothing already exists, initialize a new Node to the root position of the tree and store the int newNode value inside of it.
        }

        else if(e == root.data)                 //  handles if the newNode already exists in the BST.
        {
            System.out.println("ERROR: the value " + e + " is already contained in the BST.");
        }

        else if(e > root.data)
            if(root.right != null)
            {
                insert(root.right, e);          //  recursively call insert() to continue traversing down the right subtree
            }
            else
            {
                root.right = new Node(e);       //  create a new right child Node leaf, and store the int newNode value inside of it.
            }

        else if(e < root.data)
            if(root.left != null)
            {
                insert(root.left, e);           //  recursively call insert() to continue traversing down the left subtree
            }
            else
            {
                root.left = new Node(e);        //  create a new left child Node leaf, and store the int newNode value inside of it.
            }
    }

    public void delete(int e)                   //  method that calls overloaded delete method.  Simplifies input.
    {
        delete(root, e);
    }

    public Node delete(Node root, int e)        //  delete method that determines location of node storing e value, and deletes it accordingly.
    {
        if (root == null)
        {
            System.out.println("ERROR: Cannot delete.");
            return null;
        }

        if (root.data > e) {                    //  find the node where int e is stored.
            root.left = delete(root.left, e);
        } else if (root.data < e) {
            root.right = delete(root.right, e);

        } else {
            if (root.left != null && root.right != null) {              //  if the node that is supposed to be deleted has both children
                Node nextBiggestNode = minimumNode(root.right);         //  finding the next biggest node to replace the deleted node with. Should be the leftmost leaf in the right subtree
                root.data = nextBiggestNode.data;                       //  replace the data in the specified root node with the data from the nextBiggestNode, effectively deleting the original node.
                root.right = delete(root.right, nextBiggestNode.data);  //  now that the data from the next biggest node has been moved, delete the original node it was stored in.

            }
            else if (root.left != null) {       //  handles if the node to be deleted only has a left child
                root = root.left;
            }
            else if (root.right != null) {      //  handles if the node to be deleted only has a right child
                root = root.right;
            }
            else                                //  handles if the node to be deleted is a leaf
                root = null;
        }
        return root;
    }

    public Node minimumNode(Node root)          // helper function to find the minimum Node needed to replace deleted Node
    {
        if (root.left == null)
            return root;
        else {
            return minimumNode(root.left);
        }
    }



}

class Node                                      //  class to create the Nodes that the BST will be comprised of.
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        right = null;
        left = null;
    }
}
