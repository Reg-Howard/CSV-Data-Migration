package com.sparta.group2.model.factory;

//import java.time.LocalDate;
//import java.util.Date;
//
///*
//   During the process of writing the code for this project we have discovered that java has build in methods to handle
//   both of these factors in the form of the DateTimeFormatter and the Integer.parseInts and so have commented out this
//   work however have left it in the repository as proof of progress.
// */
//
//public class ParsingFactory {
//
//    public static int toInt(String string){
//        int output = 0;
//        if (string.equals("")){
//            return 0;
//        }
//        output = Integer.parseInt(string);
//        return output;
//    }
//
//    public static LocalDate toDate(String string){ //20/04/1995 -> 1995,4,20
//        if(string == null ||
//          (!string.matches("\\d{2}/\\d{2}/\\d{4}") && (!string.matches("\\d{2}/\\d{2}/\\d{2}")))){
//            return null;
//        }
//        String[] strings = string.split("/");
//        if(strings[2].length() == 2){
//            if(toInt(strings[2]) > 25){
//                strings[2] = "19"+strings[2];
//            } else {
//                strings[2] = "20"+strings[2];
//            }
//        }
//        LocalDate date = LocalDate.of(toInt(strings[2]),toInt(strings[1]),toInt(strings[0]));
//        return date;
//    }
//}