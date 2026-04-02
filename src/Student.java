import java.util.Scanner;
import java.util.InputMismatchException;

// Клас, що описує залікову книжку студента
class Student {
    private String lastName;
    private String bookNumber;
    private int course;
    private double averageGrade;

    public Student(String lastName, String bookNumber, int course, double averageGrade) {
        this.lastName = lastName;
        this.bookNumber = bookNumber;
        this.course = course;
        this.averageGrade = averageGrade;
    }

    // Геттери
    public String getLastName() { return lastName; }
    public String getBookNumber() { return bookNumber; }
    public int getCourse() { return course; }
    public double getAverageGrade() { return averageGrade; }

    // Статичний метод для виведення заголовка таблиці
    public static void printTableHeader() {
        System.out.printf("| %-15s | %-12s | %-6s | %-12s |%n", "Прізвище", "№ Книжки", "Курс", "Сер. бал");
        System.out.println("------------------------------------------------------------");
    }

    // Метод для виведення рядка таблиці
    public void printAsRow() {
        System.out.printf("| %-15s | %-12s | %-6d | %-12.2f |%n", lastName, bookNumber, course, averageGrade);
    }
}
