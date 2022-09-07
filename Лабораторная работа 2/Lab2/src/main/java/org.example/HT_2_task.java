package org.example;

import java.util.Scanner;

public class HT_2_task {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a1;
        int a2;
        int a3;
        int b1;
        int b2;
        int b3;
        int c1;
        int c2;
        int c3;
        int result1;
        double modula;
        double modulb;
        double pr;
        double angle;
        int choice = -1;
        int choice2;
        int choice3;
        int choice4;
        System.out.print("\nВведите x для вектора а: ");
        a1 = in.nextInt();
        System.out.print("\nВведите y для вектора а: ");
        a2 = in.nextInt();
        System.out.print("\nВведите z для вектора а: ");
        a3 = in.nextInt();

        System.out.print("\nВведите x для вектора b: ");
        b1 = in.nextInt();
        System.out.print("\nВведите y для вектора b: ");
        b2 = in.nextInt();
        System.out.print("\nВведите z для вектора b: ");
        b3 = in.nextInt();

        while (choice != 7) {
            System.out.println(
                    """
                             ================Меню=============
                            1- скалярное произведение
                            2- векторное произведение
                            3- сложение
                            4- вычитание
                            5- модуль вектора
                            6- угол между двумя векторами
                            7- exit
                             """);
            choice = in.nextInt();
            switch (choice) {
                case 1: {
                    result1 = a1 * b1 + a2 * b2 + a3 * b3;//Скалярное произведение
                    System.out.print("\n Cкалярное произведение: "+result1);
                    System.out.print("\n");
                    break;
                }
                case 2: {//Векторное произведение
                    c1=a2*b3-a3*b2;
                    c2=a3*b1-a1*b3;
                    c3=a1*b2-a2*b1;
                    System.out.print("\n Векторное произведение: с={"+c1+";"+c2+";"+c3+"}");
                    System.out.print("\n");
                    break;
                }
                case 3: {//Сложение 2х векторов
                    System.out.print("\nВведите 1-(a+b) или 2-(b+a): ");
                    choice2 = in.nextInt();
                    if (choice2==1){
                        c1=a1+b1;
                        c2=a2+b2;
                        c3=a3+b3;
                        System.out.print("\n a+b: с={"+c1+";"+c2+";"+c3+"}");
                        System.out.print("\n");
                    }
                    else if (choice2==2){
                        c1=b1+a1;
                        c2=b2+a2;
                        c3=b3+a3;
                        System.out.print("\n b+a: с={"+c1+";"+c2+";"+c3+"}");
                        System.out.print("\n");
                    }

                    break;
                }
                case 4: {//Вычитание 2х векторов
                    System.out.print("\nВведите 1-(a-b) или 2-(b-a): ");
                    choice3 = in.nextInt();
                    if (choice3==1){
                        c1=a1-b1;
                        c2=a2-b2;
                        c3=a3-b3;
                        System.out.print("\n a-b: с={"+c1+";"+c2+";"+c3+"}");
                        System.out.print("\n");
                    }
                    else if (choice3==2){
                        c1=b1-a1;
                        c2=b2-a2;
                        c3=b3-a3;
                        System.out.print("\n b-a: с={"+c1+";"+c2+";"+c3+"}");
                        System.out.print("\n");
                    }
                    break;
                }
                case 5: {//Модуль вектора
                    System.out.print("\nВведите 1-a или 2-b: ");
                    choice4 = in.nextInt();
                    if (choice4==1){
                        modula=Math.sqrt(Math.pow(a1,2)+Math.pow(a2,2)+Math.pow(a3,2));//Math.pow()-возведение в степень; Math.sqrt-корень из числа
                        System.out.print("\n Модуль(длина) вектора a: " +modula);
                        System.out.print("\n");
                    }
                    else if (choice4==2){
                        modulb=Math.sqrt(Math.pow(b1,2)+Math.pow(b2,2)+Math.pow(b3,2));
                        System.out.print("\n Модуль(длина) вектора b: " +modulb);
                        System.out.print("\n");
                    }
                    break;
                }
                case 6: {//Поиск угла между веткорами
                    pr=a1 * b1 + a2 * b2 + a3 * b3;//скалярное произведение
                    modula=Math.sqrt(Math.pow(a1,2)+Math.pow(a2,2)+Math.pow(a3,2));// Модуль вектора а
                    modulb=Math.sqrt(Math.pow(b1,2)+Math.pow(b2,2)+Math.pow(b3,2));// Модуль вектора b
                    angle=Math.toDegrees(Math.acos(pr/(modula*modulb)));//Math.acos()-арккосинус; Math.toDegrees()-переводит угол из радиан в градусы
                    System.out.print("\n угол между двумя векторами: " +angle+"°");
                    System.out.print("\n");

                    break;
                }
                case 7:
                {
                    System.out.println("Завершение работы");
                    break;
                }
                default:
                {
                    System.out.println("Нет такого пункта");
                }
            }
        }
    }
}
