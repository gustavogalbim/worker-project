package nelios.udemy;

import nelios.udemy.model.Department;
import nelios.udemy.model.HourContract;
import nelios.udemy.model.Worker;
import nelios.udemy.model.enums.WorkerLevel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter department's name: ");
        String departmentName = scanner.nextLine();

        System.out.println("Enter worker data: ");
        System.out.println("Name: ");
        String workerName = scanner.nextLine();
        System.out.println("Worker Level: ");
        String workerLevel = scanner.nextLine();
        System.out.println("Base Salary: ");
        double baseSalary = scanner.nextDouble();

        Department department = new Department(departmentName);
        Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, department);

        System.out.println("How many contracts to this worker? ");
        int number = scanner.nextInt();

        for(int i = 0; i<number; i++) {
            System.out.println("Enter contract #" +i+ " data: ");
            System.out.println("Date (DD/MM/YYYY)");
            Date date = dateFormat.parse(scanner.next());
            System.out.println("Value per hour: ");
            double valuePerHour = scanner.nextDouble();
            System.out.println("Hours: ");
            int hours = scanner.nextInt();

            HourContract hourContract = new HourContract(date, valuePerHour, hours);
            worker.addContract(hourContract);
        }

        scanner.nextLine();

        System.out.println("Enter month and year to calculate income (MM/YYYY): ");
        String monthAndYear = scanner.next();
        int month = Integer.parseInt(monthAndYear.substring(0, 2));
        int year = Integer.parseInt(monthAndYear.substring(3));

        System.out.println("Name: " +worker.getName());
        System.out.println("Department: " +worker.getDepartment().getName());
        System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));
    }
}