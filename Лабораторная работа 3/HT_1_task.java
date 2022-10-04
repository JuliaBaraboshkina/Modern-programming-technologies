package com.finu;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class HT_1_task {
    public final static String emptyFileName = "Input.txt";
    public final static String resultFileName = "Result.txt";
    public static void main(String[] args) throws IOException {
        int numberOfUpperCase=0;
        int numberOfLowerCase=0;
        int numberOfWhiteSpace=0;
        int summaLetters;
        int numberOfInt=0;
        int numberOfFloat=0;
        int numberOfPunctuationMarks=0;
        int convert;
        String finalResult;
        String resultOfConvert;
        String txt = "";

        System.out.println("Хотите ли вы сами заполнить файл? (Y or y для Да)");
        Scanner in = new Scanner(System.in);
        char choice = in.nextLine().charAt(0);

        if (choice == 'Y' || choice == 'y') {
            System.out.println("!!! После (,) ставится пробел, если это не число с плавающей точкой !!!");
            System.out.println("Введите текст"); //привет, приветик, привет! Меня зовут Юля-Юля, а тебя? 0,455432, 456543, 8953 и 8942,954862
            txt = in.nextLine();
            FileWriter myWriter = new FileWriter(emptyFileName);
            myWriter.write(txt);
            myWriter.close();
        } else {
            FileWriter myWriter = new FileWriter(emptyFileName);
            //myWriter.write("Hi? Hi! Is it example? Yes! 5555 0,6765 12345, 5,78765544 ..!!???,,");
            myWriter.write("Word1 Word2 22 67,9999");
            myWriter.close();
        }

        StringBuilder sb = new StringBuilder();
        try {
            FileReader myReader = new FileReader(emptyFileName);
            int character = myReader.read();

            while (character != -1) {
                sb.append((char) character);
                character = myReader.read();
            }
            myReader.close();
        } catch (Exception e) {
            System.out.println("Text reading failed.");
            e.printStackTrace();
        }
        //2-подсчитать количество слов в тексте
        int amountSmbl;
        int numberOfWords=0;
        String[] words = sb.toString().split(" ");
        for (int i = 0; i < words.length; i++){
            amountSmbl = 0;
            for (int j = 0; j < words[i].length(); j++){
                char symbol=words[i].charAt(j);
                if (Character.isLetter(symbol)){
                    amountSmbl++;
                }
            }
            if (amountSmbl>1){
                numberOfWords++;
            }
        }
        System.out.println("Количество слов в строке:"+numberOfWords);

        for(int i = 0; i< sb.length(); i++) {
            //3-подсчитать количество прописных и строчных букв в тексте и их сумма.
            if (Character.isUpperCase(sb.charAt(i))) {
                numberOfUpperCase++;
            }
            if (Character.isLowerCase(sb.charAt(i))) {
                numberOfLowerCase++;
            }
            //4-подсчитать количество пробелов в тексте.
            if (sb.charAt(i)==' ') {
                numberOfWhiteSpace++;
            }
        }
        summaLetters=numberOfUpperCase+numberOfLowerCase;
        System.out.println("Количество прописных букв: "+numberOfUpperCase);
        System.out.println("Количество строчных букв: "+numberOfLowerCase);
        System.out.println("Cумма букв: "+summaLetters);
        System.out.println("Количество пробелов: "+numberOfWhiteSpace);

        //5- подсчитать количество целых чисел и чисел с плавающей запятой.
        for (int i = 0; i < words.length; i++) {
            if (words[i].contains(",")) {
                String[] numberWithСomma = words[i].split(",");
                try {
                    Integer.parseInt(numberWithСomma[0]);
                    if (numberWithСomma.length==1) {
                        numberOfInt++;
                        convert = Integer.parseInt (numberWithСomma[0]);
                        resultOfConvert = Integer.toHexString(convert);
                        words[i]=resultOfConvert+",";}
                }
                catch (NumberFormatException e) {
                    continue;
                }
                }
            else{
                try {

                    Integer.parseInt(words[i]);
                    numberOfInt++;
                    convert = Integer.parseInt (words[i]);
                    resultOfConvert = Integer.toHexString(convert);
                    words[i]=resultOfConvert;
                }
                catch (NumberFormatException e) {
                    continue;}
            }
        }
        System.out.println("Количество целых чисел: "+numberOfInt);
        //В случае обнаружения чисел с плавающей точкой программа должна вывести их с двумя десятичными знаками
        for (int i = 0; i < words.length; i++) {
            if (words[i].contains(",")) {
                String[] numberWithСomma = words[i].split(",");
                try {
                    Integer.parseInt(numberWithСomma[0]);
                    if (numberWithСomma.length == 2) {
                        numberOfFloat++;
                        String doubleNumber = numberWithСomma[0] + "." + numberWithСomma[1];
                        double converDouble = Double.parseDouble(doubleNumber);
                        words[i]=String.format("%.2f", converDouble);
                    }
                }
                catch (NumberFormatException e) {
                    continue;}
            }
        }
        System.out.println("Количество чисел с плавающей запятой: "+numberOfFloat);

        // подсчитать количество знаков препинанияи удалить их
        String listWords = String.join(" ",words);
        StringBuilder sb2 = new StringBuilder(listWords);
        int flag = -1;
        while (flag==-1){
            for(int i = 0; i< sb2.length(); i++) {
                if (sb2.charAt(i)=='!' || sb2.charAt(i)=='?' || sb2.charAt(i)=='.') {
                    numberOfPunctuationMarks++;
                    sb2.deleteCharAt(i);
                    break;
                }
                if (sb2.charAt(i)==','){
                    if (i<sb2.length()-1){
                        if (!Character.isDigit(sb2.charAt(i+1))){
                            numberOfPunctuationMarks++;
                            sb2.deleteCharAt(i);
                            break;
                        }
                    }
                    else{
                        numberOfPunctuationMarks++;
                        sb2.deleteCharAt(i);
                        break;
                    }
                }
                if (i==sb2.length()-1){
                    flag=1;
                }
            }
        }
        System.out.println("Количество знаков препинания: "+numberOfPunctuationMarks);
        finalResult = sb2.toString();
        FileWriter myWriter = new FileWriter(resultFileName);
        myWriter.write(finalResult);
        myWriter.write("\nКоличество слов в строке: "+numberOfWords+"\nКоличество прописных букв: "+numberOfUpperCase
        +"\nКоличество строчных букв: "+numberOfLowerCase+"\nCумма букв: "+summaLetters+"\nКоличество пробелов: "+numberOfWhiteSpace
        +"\nКоличество целых чисел: "+numberOfInt+"\nКоличество чисел с плавающей запятой: "+numberOfFloat+ "\nКоличество знаков препинания: " +numberOfPunctuationMarks );
        myWriter.close();
        //предоставить пользователю возможность искать слово в текстовом файле "Input.txt"
        System.out.println("Введите слово, которое хотите найти");
        String research = in.nextLine();
        flag=0; // проверка на наличие слова в строке
        String stroka = sb.toString();
        int lastIndexEnd=0; //последний индекс (нужен если в строке несколько слов)
        int sumDelIndexEnd=0;
        while (true) {
            if (stroka.contains(research)) {
                int flagBefor = 1;
                int flagAfter = 1;
                int indexStart = stroka.indexOf(research);
                int indexEnd = indexStart + research.length()-1;
                try{
                    char charBefor = stroka.charAt(indexStart-1);
                    char charBefor2 = stroka.charAt(indexStart-2);
                    if (Character.isLetter(charBefor) || Character.isDigit(charBefor)|| charBefor==','){
                        flagBefor=-1;
                    }
                } catch (Exception e) {
                    flagBefor=1;
                }
                try{
                    char charAfter= stroka.charAt(indexEnd+1);
                    if (Character.isLetter(charAfter) || Character.isDigit(charAfter)) {
                        flagBefor = -1;
                    }
                } catch (Exception e) {
                    flagAfter=1;
                }

                if (flagBefor==1 & flagAfter==1){
                    int sumIndexStart = indexStart + lastIndexEnd+sumDelIndexEnd ;
                    int sumIndexEnd = sumIndexStart+research.length()-1;
                    System.out.println("индекс начала: " + sumIndexStart + " индекс конца: " + sumIndexEnd);
                    stroka = stroka.substring(indexEnd+1);
                    flag++;
                    lastIndexEnd = indexEnd+1;
                }
                else if (flagBefor==-1 || flagAfter==-1){
                    int delIndexEnd=0;
                    for(int i = 1; i< stroka.length(); i++){
                        char charr = stroka.charAt(i);
                        if (charr==' '){
                            delIndexEnd++;
                            break;}
                        else{delIndexEnd++;}
                    }
                    sumDelIndexEnd= sumDelIndexEnd+delIndexEnd;
                    stroka = stroka.substring(delIndexEnd);
                }
            }
            else {
                if (flag == 0) {
                    System.out.println("Такого слова нет в строке");
                }
                break;
            }
        }
    }
}
