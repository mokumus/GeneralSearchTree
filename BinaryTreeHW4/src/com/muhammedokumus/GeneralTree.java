package com.muhammedokumus;

import java.util.Scanner;


/**
 * A general tree class that extends BinaryTree class to add methods like add, search and print in different
 * formats for generic trees.
 * @param <E> a comparable class
 */

public class GeneralTree<E extends Comparable<E>> extends BinaryTree  {
    //Constructors
    public GeneralTree(){
        super();
    }

    protected GeneralTree(Node<E> root){
        super(root);
    }

    public GeneralTree(E data, GeneralTree<E> leftTree, GeneralTree<E> rightTree){
        super(data,leftTree,rightTree);
    }

    /**
     * Method to read a general tree.
     * pre: The input consists of a preorder traversal of the general tree. The line "null" indicates a null tree.
     * @param scan the Scanner attached to the input file.
     * @return The general tree
     */
    public static GeneralTree<String> readGeneralTree(Scanner scan){
        //Read a line and trim leading and trailing spaces.
        String data = scan.nextLine().trim();
        if(data.equals("null"))
            return null;
        else{
            GeneralTree<String> leftTree = readGeneralTree(scan);
            GeneralTree<String> rightTree = readGeneralTree(scan);
            return new GeneralTree<>(data,leftTree,rightTree);
        }
    }

    /**
     * Method to add a child to general tree. Using postorder manner.
     * pre: Parent data that already exists in the tree and a child node.
     * post: Child node is inserted as the last child of the parent, as the left most node.
     * @param parent parent data
     * @param child child node
     * @return true if parent exists
     */
    public boolean add(E parent, Node<E> child){
        Node<E> parentLocation = postOrderSearch(parent,false);
        if(parentLocation != null){
            add(parentLocation,child);
            return true;
        }
        return false;
    }

    private void add(Node<E> parent, Node<E> child){
        while(parent.left != null){
            parent = parent.left;
        }
        parent.left = child;
    }

    /**
     * Adds all given children to the given parent. Using regular add method
     * @param parent parent data
     * @param children child nodes
     */
    public void addAll(E parent, Node<E>... children) {
        Node<E> parentLocation = postOrderSearch(parent,false);
        for (Node<E> child : children)
           add(parentLocation,child);
    }

    /**
     * Method to add a sibling to general tree. Using postorder manner.
     * pre: Parent data that already exists in the tree and a child node.
     * post: Child node is inserted as the last child of the parent, as the left most node.
     * @param sibling sibling data
     * @param otherSibling new sibling node
     * @return true if sibling exists
     */
    public boolean addSibling(E sibling, Node<E> otherSibling){
        Node<E> siblingLocation = postOrderSearch(sibling,false);
        if(siblingLocation != null){
            addSibling(siblingLocation,otherSibling);
            return true;
        }
        return false;
    }

    private void addSibling(Node<E> sibling, Node<E> otherSibling){
        while(sibling.right != null){
            sibling = sibling.right;
        }
        sibling.right = otherSibling;
    }

    /**
     * Adds all given siblings to the node reached by sibling data. Using regular addSibling method
     * @param sibling sibling data
     * @param otherSiblings new sibling nodes
     */
    public void addAllSiblings(E sibling, Node<E>... otherSiblings) {
        Node<E> siblingLocation = postOrderSearch(sibling,false);
        for (Node<E> other : otherSiblings)
            addSibling(siblingLocation,other);
    }

    /**
     * Method to add a child to general tree. Using levelorder manner.
     * pre: Parent data that already exists in the tree and a child node.
     * post: Child node is inserted as the last child of the parent, as the left most node.
     * @param parent parent data
     * @param child child node
     * @return true if parent exists
     */
    public boolean addByLevelOrder(E parent, Node<E> child){
        Node<E> parentLocation = levelOrderSearch(parent);
        if(parentLocation != null){
            while(parentLocation.left != null){
                parentLocation = parentLocation.left;
            }
            parentLocation.left = child;
            return true;
        }
        return false;
    }

    /**
     * Searches the given target data in the general tree in a postorder manner.
     * @param target item to be searched
     * @return reference to the target node, null if target is not found.
     */
    public Node<E> postOrderSearch(E target, boolean print){
        return postOrderSearch(root,target, print);
    }

    private Node<E> postOrderSearch(Node<E> localRoot, E target, boolean print){
        if(localRoot == null)
            return null;
        else{
            if(print == true)
                System.out.println(target + " =? " + localRoot.data);

            int compResult = target.compareTo(localRoot.data);
            if(compResult == 0)
                return localRoot;
            else{
                Node<E> foundData = postOrderSearch(localRoot.left, target,print);
                if(foundData == null)
                    foundData = postOrderSearch(localRoot.right, target,print);

                return foundData;
            }
        }
    }


    /**
     * Searches the given target data in the general tree in a levelorder manner.
     * @param target item to be searched
     * @return reference to the target node, null if target is not found.
     */
    public Node<E> levelOrderSearch(E target){
        return levelOrderSearch(root,target);
    }

    private Node<E> levelOrderSearch(Node<E> localRoot, E target){
        if(localRoot == null)
            return null;
        else{
            System.out.println(target + " =? " + localRoot.data);
            int compResult = target.compareTo(localRoot.data);
            if(compResult == 0)
                return localRoot;

            else{

                Node<E> foundData = levelOrderSearch(localRoot.right, target);
                if(foundData == null)
                    foundData = levelOrderSearch(localRoot.left, target);

                return foundData;
            }
        }
    }


    /**
     * Prints all left nodes to the deepest level from the given node.
     * @param data node data
     */
    public void printLeft(E data){
        Node<E> nodeLocation = postOrderSearch(data,false);
        if(nodeLocation != null){
            int i = 1;
            System.out.println("Left nodes of: " + nodeLocation.data);
            while(nodeLocation.left != null){
                System.out.println(i + ". " + nodeLocation.left.data);
                nodeLocation = nodeLocation.left;
                i++;
            }
        }
        else
            System.out.println("No left nodes found.");
    }
    /**
     * Prints all rights nodes to the deepest level from the given node.
     * @param data node data
     */
    public void printRight(E data){
        Node<E> nodeLocation = postOrderSearch(data,false);
        if(nodeLocation != null){
            int i = 1;
            System.out.println("Right nodes of: " + nodeLocation.data);
            while(nodeLocation.right != null){
                System.out.println(i + ". " + nodeLocation.right.data);
                nodeLocation = nodeLocation.right;
                i++;
            }
        }
        else
            System.out.println("No right nodes found");
    }

}
