package com.visma;

import java.text.ParseException;
import java.util.Scanner;


public class Main {


    public static void main(String[] args)  {
        DataList dl = new DataList();
        Scanner sc = new Scanner(System.in);
        String operationID ;

        System.out.println("\nPažymėkite kokią operaciją norite atlikti (parašyti operacijos ID): \n" + "1. Peržiūrėti trūkstamų prekių kiekius \n"
                + "2. Patikrinti prekes, kurių galiojimo laikas pasibaigęs arba pasibaigs greitu metu \n");
         operationID = sc.nextLine();
        
        if (!operationID.equals("1") && !operationID.equals("2")) {
            System.out.println("Blogai įvedėte ID");
            main(args);
        }

        if (operationID.equals("1")) {
            System.out.println("Įveskite prekių kiekį, norėdami sužinoti visas prekes, kurių likutis yra mažesnis už jūsų nurodytą kiekį:");
            String amountOfGoods = sc.nextLine();
            dl.deleteDublicatesAndPrint(amountOfGoods, operationID);

            while (true) {
                System.out.println("\nAr dar norite vykdyti operacijas?(T/N)");
                String answer = sc.nextLine();
                if (answer.equals("T") || answer.equals("t")) {
                    main(args);
                    break;
                }
                else if (answer.equals("N")|| answer.equals("n")){
                    System.out.println("Sistemos darbas baigtas");
                    break;
                }
                else {
                    System.out.println("Klaidinga įvestis, įveskite iš naujo");
                }
            }
        } else if (operationID.equals("2")) {
            System.out.println("Įveskite datą, norėdami sužinoti visas prekes, kurių galiojimo data yra iki jūsų nurodytos datos (pvz. 2018-11-12):");
            String stringDeadLineDate = sc.nextLine();

            dl.deleteDublicatesAndPrint(stringDeadLineDate, operationID);

                while (true) {

                    String answer ;

                    System.out.println("\nAr dar norite vykdyti operacijas?(T/N)");
                    answer = sc.nextLine();
                    if (answer.equals("T") || answer.equals("t")) {
                        main(args);
                        break;
                    }
                    else if (answer.equals("N")|| answer.equals("n")){
                        System.out.println("Sistemos darbas baigtas");
                        break;
                    }
                     else {
                        System.out.println("Klaidingai įvestis, įveskite iš naujo");
                    }
                }
        }
    }
}