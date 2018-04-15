package com.muhammedokumus;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Scanner;

import static com.muhammedokumus.GeneralTree.readGeneralTree;
import static org.junit.jupiter.api.Assertions.*;

class TestOnlyChildTree {

    @Test
    void childOnly(){
        try{
            System.out.println("Create a child only tree.");
            Scanner input = new Scanner(new File("Files/FirstOfHisName.txt"));
            GeneralTree<String> onlySiblingsTree = readGeneralTree(input);
            input.close();

            GeneralTree.Node<String> Robert = new GeneralTree.Node<>("Robert");
            GeneralTree.Node<String> William = new GeneralTree.Node<>("William");
            GeneralTree.Node<String> WilliamII = new GeneralTree.Node<>("William II");
            GeneralTree.Node<String> Adela = new GeneralTree.Node<>("Adela");
            GeneralTree.Node<String> Stephen = new GeneralTree.Node<>("Stephen");
            GeneralTree.Node<String> HenryI = new GeneralTree.Node<>("Henry I");
            GeneralTree.Node<String> WilliamIII = new GeneralTree.Node<>("William III");
            GeneralTree.Node<String> Matilda = new GeneralTree.Node<>("Matilda");
            GeneralTree.Node<String> HenryII= new GeneralTree.Node<>("Henry II");
            GeneralTree.Node<String> Henry = new GeneralTree.Node<>("Henry");
            GeneralTree.Node<String> RichardI= new GeneralTree.Node<>("Richard I");
            GeneralTree.Node<String> Geoffrey = new GeneralTree.Node<>("Geoffrey");

            onlySiblingsTree.addAll("William I", Robert,William,WilliamII,Adela,Stephen,Henry,
                    HenryI,HenryII,WilliamIII,Matilda,RichardI,Geoffrey);

            System.out.println("Print tree:" + onlySiblingsTree);
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}