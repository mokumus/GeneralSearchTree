package com.muhammedokumus;

import java.io.Serializable;
import java.util.Scanner;


/**
 * Class for a binary tree that stores type E objects.
 * @param <E> data type
 */

public class BinaryTree<E extends Comparable<E>> {
    /**
     * Class to encapsulate a tree node.
     * @param <E> data type
     */
    protected static class Node<E extends Comparable<E>> implements Serializable{
        //Data fields
        protected E data;
        protected Node<E> left;
        protected Node<E> right;

        //Constructors
        public Node(E data){
            this.data = data;
            left = null;
            right = null;
        }

        //Methods
        public String toString(){
            return data.toString();
        }
    }


    //Data fields
    protected Node<E> root;

    //Constructors
    public BinaryTree(){
        root = null;
    }

    protected BinaryTree(Node<E> root){
        this.root = root;
    }

    public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree){
        root = new Node<>(data);

        if(leftTree != null)
            root.left = leftTree.root;
        else
            root.left = null;

        if(rightTree != null)
            root.right = rightTree.root;
        else
            root.right = null;

    }

    //Methods
    /**
     * Return the left subtree.
     * @return The left subtree or null if either the root or the left subtree is null.
     */
    public BinaryTree<E> getLeftSubtree() {
        if(root != null && root.left != null)
            return new BinaryTree<>(root.left);

        else
            return null;

    }
    /**
     * Return the right subtree.
     * @return The right subtree or null if either the root or the right subtree is null.
     */
    public BinaryTree<E> getRightSubtree() {
        if(root != null && root.right != null)
            return new BinaryTree<>(root.right);

        else{
            return null;
        }
    }
    /**
     * Determine whether this tree is a leaf.
     * @return true if the root has no children
     */
    public boolean isLeaf(){
        return (root.left == null && root.right == null);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        preOrderTraverse(root, 1, sb);
        sb.deleteCharAt(sb.length()-1); //Delete extra new line
        return sb.toString();
    }


    /**
     * Method to read a binary tree.
     * pre: The input consists of a preorder traversal of the binary tree. The line "null" indicates a null tree.
     * @param scan the Scanner attached to the input file.
     * @return The binary tree
     */
    public static BinaryTree<String> readBinaryTree(Scanner scan){
        //Read a line and trim leading and trailing spaces.
        String data = scan.next();
        if(data.equals("null"))
            return null;
        else{
            BinaryTree<String> leftTree = readBinaryTree(scan);
            BinaryTree<String> rightTree = readBinaryTree(scan);
            return new BinaryTree<>(data,leftTree,rightTree);
        }
    }


    private void preOrderTraverse(Node<E> node, int depth, StringBuilder sb){
        for(int i = 1; i < depth; i++)
            sb.append(" ");
        if(node == null)
            sb.append("null\n");
        else{
            sb.append(node.toString());
            sb.append("\n");
            preOrderTraverse(node.left, depth + 1, sb);
            preOrderTraverse(node.right, depth + 1, sb);
        }
    }








}
