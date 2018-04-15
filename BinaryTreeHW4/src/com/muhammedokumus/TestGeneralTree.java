package com.muhammedokumus;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Scanner;

import static com.muhammedokumus.GeneralTree.readGeneralTree;
import static org.junit.jupiter.api.Assertions.*;

class TestGeneralTree {


    @Test
    void add() {
        try {
            System.out.println("Construct a tree from file for tests.");
            Scanner input = new Scanner(new File("Files/FamilyTree.txt"));
            GeneralTree<String> testTree = readGeneralTree(input);
            input.close();

            GeneralTree.Node<String> Mehmet = new GeneralTree.Node<>("Mehmet");
            System.out.println("Trying to add to invalid parent.");
            assertEquals(false,testTree.add("II. Murat", Mehmet ));

            System.out.println("Trying to add to valid parent.");
            assertEquals(true,testTree.add("William I", Mehmet ));

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    void addByLevelOrder() {
        try {
            System.out.println("Construct a tree from file for tests.");
            Scanner input = new Scanner(new File("Files/FamilyTree.txt"));
            GeneralTree<String> testTree = readGeneralTree(input);
            input.close();

            GeneralTree.Node<String> Mehmet = new GeneralTree.Node<>("Mehmet");
            System.out.println("Trying to add to invalid parent.(level order)");
            assertEquals(false,testTree.addByLevelOrder("II. Murat", Mehmet ));

            System.out.println("Trying to add to valid parent.(level order)");
            assertEquals(true,testTree.addByLevelOrder("William I", Mehmet ));

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }




}