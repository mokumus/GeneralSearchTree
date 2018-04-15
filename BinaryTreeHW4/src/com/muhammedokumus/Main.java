package com.muhammedokumus;

import java.io.File;
import java.util.Scanner;


import static com.muhammedokumus.GeneralTree.readGeneralTree;

public class Main {

    public static void main(String[] args) {

        try {

            Scanner input = new Scanner(new File("Files/FirstOfHisName.txt"));
            GeneralTree<String> royalTree = readGeneralTree(input);
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
            GeneralTree.Node<String> Arthur = new GeneralTree.Node<>("Arthur");
            GeneralTree.Node<String> John = new GeneralTree.Node<>("John");
            GeneralTree.Node<String> HenryIII = new GeneralTree.Node<>("Henry III");
            GeneralTree.Node<String> Richard = new GeneralTree.Node<>("Richard");
            GeneralTree.Node<String> EdwardI = new GeneralTree.Node<>("Edward I");
            GeneralTree.Node<String> EdmundI= new GeneralTree.Node<>("Edmund I");
            GeneralTree.Node<String> EdwardII= new GeneralTree.Node<>("Edward II");
            GeneralTree.Node<String> Thomas= new GeneralTree.Node<>("Thomas");
            GeneralTree.Node<String> EdmundII = new GeneralTree.Node<>("Edmund II");
            GeneralTree.Node<String> EdwardIII = new GeneralTree.Node<>("Edward III");

            System.out.println("************************************PART 1************************************");
            System.out.println("**********************************SCENARIO 1**********************************");
            System.out.println("Adding new children to william");
            System.out.println("royalTree.addAll(\"William I\", Robert, William);\n");
            royalTree.addAll("William I", Robert, William);
            royalTree.printLeft("William I");
            System.out.println("\nPrint tree:\n" + royalTree);

            System.out.println("******************************************************************************");
            System.out.println("**********************************SCENARIO 2**********************************");
            System.out.println("Adding new siblings to Robert");
            System.out.println("royalTree.addAllSiblings(\"Robert\",WilliamII,Adela,HenryI);\n");
            royalTree.addAllSiblings("Robert",WilliamII,Adela,HenryI);
            royalTree.printRight("Robert");
            System.out.println("\nPrint tree:\n" + royalTree);

            System.out.println("******************************************************************************");
            System.out.println("*********************************SCENARIO 3.1*********************************");
            System.out.println("Adding new children and siblings...");
            System.out.println("            royalTree.add(\"Adela\", Stephen);\n" +
                    "            royalTree.add(\"Henry I\", WilliamIII);\n" +
                    "            royalTree.addSibling(\"William III\",Matilda);\n" +
                    "            royalTree.addAll(\"Matilda\", HenryII,Henry);\n" +
                    "            royalTree.addAllSiblings(\"Henry\", RichardI,Geoffrey,John);");

            royalTree.add("Adela", Stephen);
            royalTree.add("Henry I", WilliamIII);
            royalTree.addSibling("William III",Matilda);
            royalTree.addAll("Matilda", HenryII,Henry);
            royalTree.addAllSiblings("Henry", RichardI,Geoffrey,John);

            System.out.println("\nPrint tree:\n" + royalTree);


            System.out.println("******************************************************************************");
            System.out.println("*********************************SCENARIO 3.2*********************************");
            System.out.println("Adding new children and siblings...");
            System.out.println("            royalTree.add(\"Geoffrey\",Arthur);\n" +
                    "            royalTree.addAll(\"John\",HenryIII,EdwardI,EdwardII,EdwardIII);\n" +
                    "            royalTree.addSibling(\"Henry III\",Richard);\n" +
                    "            royalTree.addSibling(\"Edward I\", EdmundI);\n" +
                    "            royalTree.addAllSiblings(\"Edward II\", Thomas, EdmundII);");
            royalTree.add("Geoffrey",Arthur);
            royalTree.addAll("John",HenryIII,EdwardI,EdwardII,EdwardIII);
            royalTree.addSibling("Henry III",Richard);
            royalTree.addSibling("Edward I", EdmundI);
            royalTree.addAllSiblings("Edward II", Thomas, EdmundII);
            System.out.println("\nPrint tree:\n" + royalTree);
            System.out.println("******************************************************************************");
            System.out.println("*********************************SCENARIO 4.1*********************************");
            System.out.println("Search for a person using levelorder:");
            royalTree.levelOrderSearch("Adela");
            System.out.println("Search for a person using postorder:");
            royalTree.postOrderSearch("Adela",true);
            System.out.println("******************************************************************************");
            System.out.println("*********************************SCENARIO 4.2*********************************");
            System.out.println("Search for a person using levelorder:");
            royalTree.levelOrderSearch("Henry III");
            System.out.println("Search for a person using postorder:");
            royalTree.postOrderSearch("Henry III",true);

            System.out.println("******************************************************************************");
            System.out.println("Main and unit test result can be accessed in the project folder at TestResults directory.");
            System.out.println("Please note that unit test outputs are not formatted correctly when saving as html, you can\n"+
            "see the correct formatted results in report.pdf and by running the unit tests.");


        } catch (Exception ex) {
            ex.printStackTrace();
        }



    }
}
