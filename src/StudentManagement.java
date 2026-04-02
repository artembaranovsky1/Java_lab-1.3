import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentManagement {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int size = 5;
        Student[] students = new Student[size];

        System.out.println("Введення даних про " + size + " студентів:");

        for (int i = 0; i < size; i++) {
            System.out.println("\nСтудент №" + (i + 1));
            students[i] = createStudentSafe();
        }

        System.out.println("\n--- Список усіх студентів ---");
        Student.printTableHeader();
        for (Student s : students) s.printAsRow();

        // середній бал > 4.5
        System.out.println("\n--- Студенти з середнім балом > 4.5 ---");
        boolean foundHighGrade = false;
        Student.printTableHeader();
        for (Student s : students) {
            if (s.getAverageGrade() > 4.5) {
                s.printAsRow();
                foundHighGrade = true;
            }
        }
        if (!foundHighGrade) System.out.println("Студентів із таким балом не знайдено.");

        //Пошук за курсом
        System.out.println("\n--- Пошук студентів за курсом ---");
        int searchCourse = getIntInput("Введіть курс для пошуку (1-6): ", 1, 6);

        boolean foundCourse = false;
        Student.printTableHeader();
        for (Student s : students) {
            if (s.getCourse() == searchCourse) {
                s.printAsRow();
                foundCourse = true;
            }
        }
        if (!foundCourse) System.out.println("Студентів на " + searchCourse + " курсі не знайдено.");
    }

    private static Student createStudentSafe() {
        while (true) {
            try {
                System.out.print("Прізвище: ");
                String name = scanner.next();

                System.out.print("Номер заліковки: ");
                String number = scanner.next();

                int course = getIntInput("Курс (1-6): ", 1, 6);
                double grade = getDoubleInput("Середній бал (0-5.0): ", 0.0, 5.0);

                return new Student(name, number, course, grade);
            } catch (Exception e) {
                System.out.println("Помилка створення об'єкта. Спробуйте ще раз.");
                scanner.nextLine();
            }
        }
    }

    private static int getIntInput(String prompt, int min, int max) {
        while (true) {
            try {
                System.out.print(prompt);
                int val = scanner.nextInt();
                if (val < min || val > max) throw new IllegalArgumentException("Поза діапазоном!");
                return val;
            } catch (InputMismatchException e) {
                System.out.println("Помилка: введіть ціле число.");
                scanner.next();
            } catch (IllegalArgumentException e) {
                System.out.println("Помилка: " + e.getMessage());
            }
        }
    }

    private static double getDoubleInput(String prompt, double min, double max) {
        while (true) {
            try {
                System.out.print(prompt);
                double val = scanner.nextDouble();
                if (val < min || val > max) throw new IllegalArgumentException("Поза діапазоном!");
                return val;
            } catch (InputMismatchException e) {
                System.out.println("Помилка: введіть число (використовуйте кому/крапку залежно від локалі).");
                scanner.next();
            } catch (IllegalArgumentException e) {
                System.out.println("Помилка: " + e.getMessage());
            }
        }
    }
}