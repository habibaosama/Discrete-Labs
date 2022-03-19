package testset;


import java.util.ArrayList;
import java.util.Scanner;

public class mainSet {

    public static ArrayList Universe;

    public static void main(String[] args) {

        Myset my = new Myset();
        Scanner input = new Scanner(System.in);

        System.out.println("!!!WELCOME TO OUR SIMPLE SET OPERATIONS EVALUATOR!!!");

        //taking the Universe set
        System.out.println("\nEnter The Universe Set");
        String uni = input.nextLine();
        Universe = my.convertToArray(uni);
        my.removeRepition(Universe);

        System.out.println("Enter The Number of Sets You Want to Deal With : ");
        int noSets = input.nextInt();
        input.nextLine();  //for the enter

        for (int i = 1; i <= noSets; i++) {
            System.out.println("Enter set" + i);
            String elements = input.nextLine();
            my.addSets(i, elements, Universe);
        }

        //while loop taking infinite no of operations until the user want to exit

        while (true) {

            System.out.println("to chosse operation write number: ");
            System.out.println("1- for intersection");
            System.out.println("2- for union");
            System.out.println("3- for complement");
            System.out.println("4- to print any set");
            System.out.println("5- to exit");


            int operation = input.nextInt();
            input.nextLine();
            boolean flag = true;

            switch (operation) {

                case 1: {
                    System.out.println("The name of the first set : ");
                    String set1 = input.nextLine();
                    System.out.println("The name of the second set : ");
                    String set2 = input.nextLine();
                    ArrayList res = my.Intersection(set1, set2);
                    System.out.println(res.toString().replace("[", "{").replace("]", "}"));


                }
                break;

                case 2: {
                    System.out.println("The name of the first set : ");
                    String set1 = input.nextLine();
                    System.out.println("The name of the second set : ");
                    String set2 = input.nextLine();
                    ArrayList res = my.Union(set1, set2);

                    System.out.println(res.toString().replace("[", "{").replace("]", "}"));

                }
                break;

                case 3: {
                    System.out.println("The name of set : ");
                    String set1 = input.nextLine();
                    ArrayList res = my.Complement(Universe, set1);
                    System.out.println(res.toString().replace("[", "{").replace("]", "}"));

                }
                break;

                case 4: {
                    System.out.println("enter name of the set");
                    String set1 = input.nextLine();

                    ArrayList res = my.printset(set1);
                    System.out.println(res.toString().replace("[", "{").replace("]", "}"));


                }
                break;

                case 5: {
                    flag = false;
                    break;
                }

                default:
                    System.out.println("Wrong Operation!! Please, Write It in The Correct Form!!");

            }

            if (flag == false) {
                break;
            }


        }
    }


}
