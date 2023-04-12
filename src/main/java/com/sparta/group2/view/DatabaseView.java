package com.sparta.group2.view;

import java.util.Scanner;

public class DatabaseView {
    public static void main(String[] args) {

        //DatabaseSetUp.setUpAndPopulateDB();
        //DAO dao = new DAO();

        System.out.println("WELCOME TO THE THE COMMAND LINE INTERFACE!!!");
        System.out.println("HERE YOU WILL BE ABLE TO ACCESS AND VIEW ALL\n" +
                " EMPLOYEE RECORDS WHICH ARE CURRENTLY STORED WITHIN OUR DATABASE\n");

        Scanner scanner = new Scanner(System.in);

        int choice;

        while(true){



            System.out.println("PRESS 1 TO VIEW AND PRINT ALL EMPLOYEE RECORDS\n");
            System.out.println("PRESS 2 TO VIEW AND PRINT A SPECIFIC EMPLOYEE\n");
            System.out.println("PRESS 3 TO EXIT PROGRAM\n");

            choice = scanner.nextInt();


            switch (choice) {
                case 1:
                    //System.out.println(dao.findAll());
                    System.out.println("\nSUCCESSFULLY PRINTED ALL EMPLOYEE RECORDS!");
                    break;
                case 2:
                    //System.out.println(dao.findById(5));
                    System.out.println("\nSUCCESSFULLY PRINTED EMPLOYEE RECORD!");
                    break;
                case 3:
                    scanner.close();
                    return;
                default:
                    System.out.println("INVALID ENTRY, RETRY!");
                    break;
            }
        }









    }
}
