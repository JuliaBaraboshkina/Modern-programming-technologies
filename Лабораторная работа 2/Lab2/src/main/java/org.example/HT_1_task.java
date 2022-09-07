package org.example;
import java.util.*;
class Employee
{
    //объявление переменных
    private int amount=100;//По условию максимум 100
    private String[] id=new String[amount];
    private String[] names=new String[amount];
    private String[] secnames=new String[amount];
    private String[] births=new String[amount];
    private String[] places=new String[amount];
    private String[] salaries=new String[amount];
    private String[] statuses=new String[amount];
    public Employee (String [] id,String [] names,String [] secnames,String [] births,String [] places,String [] salaries,String [] statuses)
    {
        this.addInf(id,names,secnames,births,places,salaries,statuses);
    }
    //Добавление информации о сотрудниках в списки
    public String[] addInf(String [] id,String [] names,String [] secnames,String [] births,String [] places,String [] salaries,String [] statuses) {
        this.id = id;
        this.names=names;
        this.secnames=secnames;
        this.births=births;
        this.places=places;
        this.salaries=salaries;
        this.statuses=statuses;
        return null;
    }

    public void researchId(int i) { //поиск сотрудника по id
        System.out.print("ID: "+id[i]+" Имя: "+names[i]+" Фамилия: "+secnames[i]+" Дата рождения: "+births[i]+" Место рождения: "+places[i]+" Зарплата: "+salaries[i]+" Семейное положение: "+statuses[i]);
    }
    public void checkName(int amount, String nameInf,int kol) { //Поиск сотрудника по имени
        for (int i = 0; i < amount; i++) {
            if (names[i].equals(nameInf)) {
                System.out.print("\nID: "+id[i]+" Имя: "+names[i]+" Фамилия: "+secnames[i]+" Дата рождения: "+births[i]+" Место рождения: "+places[i]+" Зарплата: "+salaries[i]+" Семейное положение: "+statuses[i]);
                kol++;
            }
        }
        if (kol == 0) {
            System.out.println("Нет сотрудников с таким именем ");
        }
    }
    public void checkbirth(int amount, String birthInf,int kol) {//поиск сотрудника по дате рождения
        for (int i = 0; i < amount; i++) {
            if (births[i].equals(birthInf)) {
                System.out.print("\nID: "+id[i]+" Имя: "+names[i]+" Фамилия: "+secnames[i]+" Дата рождения: "+births[i]+" Место рождения: "+places[i]+" Зарплата: "+salaries[i]+" Семейное положение: "+statuses[i]);
                kol++;
            }
        }
        if (kol == 0) {
            System.out.println("Нет сотрудников с такой датой рождения ");
        }
    }
}

public class HT_1_task {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int amount;
        System.out.print("\nВведите количество сотрудников: ");
        amount = in.nextInt();
        while (amount > 101) // проверка на количество сотрудников
        {
            System.out.print("\nКоличество сотрудников должно быть не больше 100");
            System.out.print("\nВведите количество сотрудников: ");
            amount = in.nextInt();
        }

        String[] id = new String[amount]; //присвоение id
        for (int i = 1; i < amount + 1; i++) {
            String str = "" + i; //перевод int в string
            id[i - 1] = str;//запись id в []
        }
        String[] names = new String[amount];
        String[] secnames = new String[amount];
        String[] births = new String[amount];
        String[] places = new String[amount];
        String[] salaries = new String[amount];
        String[] statuses = new String[amount];
        for (int i = 0; i < amount; i++) {//Ввод данных
            System.out.print("Введите имя сотрудника: ");
            names[i] = in.next();
            System.out.print("Введите фамилию сотрудника: ");
            secnames[i] = in.next();
            System.out.print("Введите дату рождения сотрудника (1.1.2000): ");
            births[i] = in.next();
            System.out.print("Введите место рождения сотрудника: ");
            places[i] = in.next();
            System.out.print("Введите зарплату сотрудника: ");
            salaries[i] = in.next();
            System.out.print("Введите семейное положение сотружника (1- не замужем(женат); 2- замужем(женат)): ");
            statuses[i] = in.next();
        }
        int choice = -1;
        while (choice != 5) {
            Employee emp = new Employee(id, names, secnames, births, places, salaries, statuses);//передача данных о сотрудниках в Employee
            System.out.println(
                    """
                             ================Меню=============
                            1- Вывести информацию о сотруднике по id
                            2- Найти сотрудника по имени или дате рождения
                            3- Изменить любую информацию о сотруднике.
                            4- Расчетать общую сумму денег, которые сотрудники получают в качестве заработной платы.
                            5- exit
                             """);
            choice = in.nextInt();
            switch (choice) {
                case 1: {
                    System.out.print("\nВведите id сотрудника: ");
                    int idInf = in.nextInt() - 1;
                    emp.researchId(idInf);
                    System.out.print("\n");
                    break;
                }
                case 2: {
                    System.out.print(
                            """
                                     ================Меню===============
                                    1-Найти сотрудника по имени
                                    2-Найти сотрудника по дате рожения
                                                                   
                                     """);
                    int choice2 = in.nextInt();
                    switch (choice2) {
                        case 1: {
                            System.out.print("\nВведите имя сотрудника: ");
                            String nameInf = in.next();
                            emp.checkName(amount, nameInf, 0);
                            System.out.print("\n");
                            break;
                        }
                        case 2: {
                            System.out.print("\nВведите дату рождения (Например 1.1.2000): ");
                            String birthInf = in.next();
                            emp.checkbirth(amount, birthInf, 0);
                            System.out.print("\n");
                            break;
                        }
                    }
                    break;
                }
                case 3:
                {
                    boolean kol;

                    System.out.print("\nВведите id сотрудника, о котором хотите изменить информацию: ");
                    int idInf2 = in.nextInt();
                    System.out.print(
                            """
                                     ================Меню===============
                                    1-Имя
                                    2-Фамилия
                                    3-Дату рождения
                                    4-Место рождения
                                    5-Зарплата
                                    6-Семейное положение
                                                             
                                     """);
                    int choice3 = in.nextInt();
                    System.out.print("\n Пример для даты рождения:   1.1.2000");
                    System.out.print("\n Для семейного положения: 1- не замужем(женат); 2- замужем(женат)");
                    System.out.print("\nВведите новую информацию: ");
                    String newInf = in.next();
                    kol = false;
                    for (int i = 0; i < amount; i++) {
                        if (choice3 == 1) {
                            names[idInf2 - 1] = newInf;
                            kol = true;
                        } else if (choice3 == 2) {
                            secnames[idInf2 - 1] = newInf;
                            kol = true;
                        }else if (choice3 == 3) {
                            births[idInf2 - 1] = newInf;
                            kol = true;
                        }else if (choice3 == 4) {
                            places[idInf2 - 1] = newInf;
                            kol = true;
                        } else if (choice3 == 5) {
                            salaries[idInf2 - 1] = newInf;
                            kol = true;
                        } else if (choice3 == 6) {
                            statuses[idInf2 - 1] = newInf;
                            kol = true;
                        }else{
                            System.out.print("\nНет такого пункта меню");
                        }

                    }
                    if (kol == false) {
                        System.out.print("\nНет такого сотрудника");
                    }
                    break;
                }
                case 4: { //Расчет общей суммы зарплат
                    int totalSalary=0;
                    for (int i = 0; i < amount; i++) {
                        int res = Integer.parseInt(salaries[i]);
                        totalSalary=totalSalary+res;
                    }
                    System.out.print("\nCумма:" + totalSalary);
                    System.out.println("\n");
                    break;
                }
                case 5:
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

