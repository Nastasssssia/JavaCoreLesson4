package ru.gb.goroninova;

import java.time.LocalDate;


public class Main {

    enum Holiday{
        NO_HOLIDAY, NEW_YEAR, MARCH_8, FEBRUARY_23
    }
    public static void main(String[] args) {
        // Создание сотрудников
        Employee emp1 = new Employee(1, "Alice", "2001-01-01", "Recruiting", 700, Customer.Gender.FEMALE);
        Employee emp2 = new Employee(2, "Bob", "2000-08-15", "IT", 2000, Customer.Gender.MALE);
        Employee emp3 = new Employee(3, "Julia", "2004-05-11", "Recruiting", 650, Customer.Gender.FEMALE);
        Employee emp4 = new Employee(4, "Ivan", "1998-03-08", "IT", 2500, Customer.Gender.MALE);
        Employee emp5 = new Employee(4, "Mikel", "1998-02-23", "IT", 2500, Customer.Gender.MALE);
        Employee emp6 = new Employee(4, "Petya", "1998-08-23", "IT", 2500, Customer.Gender.MALE);
        Employee emp7 = new Employee(4, "Ivan", "1998-08-23", "IT", 2500, Customer.Gender.MALE);

        Employee[] employees = {emp1, emp2, emp3, emp4, emp5, emp6, emp7};

        // Получаем текущую дату
        //LocalDate currentDate = LocalDate.now();
        // устанавливаем нужную нам дату для проверки
        LocalDate currentDate = LocalDate.of(2024, 2, 23);
        System.out.println("Текущая дата: " + currentDate);

        // Проверка на текущий праздник и поздравление сотрудников
        congratulateEmployees(employees, currentDate);
    }

    /**
     * Метод для получения текущего праздника на основе даты.
     *
     * @param date Текущая дата.
     * @return Текущий праздник.
     */
    public static Holiday getCurrentHoliday(LocalDate date) {
        if (date.equals(LocalDate.of(date.getYear(), 1, 1))) {
            return Holiday.NEW_YEAR;
        } else if (date.equals(LocalDate.of(date.getYear(), 3, 8))) {
            return Holiday.MARCH_8;
        } else if (date.equals(LocalDate.of(date.getYear(), 2, 23))) {
            return Holiday.FEBRUARY_23;
        } else {
            return Holiday.NO_HOLIDAY;
        }
    }

    /**
     * Метод для поздравления сотрудников с соответствующими праздниками.
     *
     * @param employees Массив сотрудников.
     * @param date      Текущая дата.
     */
    public static void congratulateEmployees(Employee[] employees, LocalDate date) {
        Holiday holiday = getCurrentHoliday(date);

        for (Employee emp : employees) {
            switch (holiday) {
                case NEW_YEAR:
                    System.out.println("С Новым Годом, " + emp.getName() + "!");
                    break;
                case MARCH_8:
                    if (emp.getGender() == Customer.Gender.FEMALE) {
                        System.out.println("С 8 марта, " + emp.getName() + "!");
                    }
                    break;
                case FEBRUARY_23:
                    if (emp.getGender() == Customer.Gender.MALE) {
                        System.out.println("С 23 февраля, " + emp.getName() + "!");
                    }
                    break;
                case NO_HOLIDAY:

                    break;
            }
        }
    }
}

