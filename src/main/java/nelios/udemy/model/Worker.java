package nelios.udemy.model;

import nelios.udemy.model.enums.WorkerLevel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Worker {

    private String name;
    private WorkerLevel workerLevel;
    private Double baseSalary;
    private Department department;
    private List<HourContract> contracts = new ArrayList<>();

    public Worker() {}

    public Worker(String name, WorkerLevel workerLevel, Double baseSalary, Department department) {
        this.name = name;
        this.workerLevel = workerLevel;
        this.baseSalary = baseSalary;
        this.department = department;
    }

    public void addContract(final HourContract contract) {
        contracts.add(contract);
    }

    public void removeContract(final HourContract contract){
        contracts.remove(contract);
    }

    public Double income(final int year, final int month) {
        double sum = baseSalary;

        Calendar calendar = Calendar.getInstance();

        for (HourContract c : contracts) {
            calendar.setTime(c.getDate());

            int contractYear = calendar.get(Calendar.YEAR);
            int contractMonth = calendar.get(Calendar.MONTH);

            if (year == contractYear && month == contractMonth ) {
                sum += c.totalValue();
            }
        }

        return sum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkerLevel getWorkerLevel() {
        return workerLevel;
    }

    public void setWorkerLevel(WorkerLevel workerLevel) {
        this.workerLevel = workerLevel;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<HourContract> getContracts() {
        return contracts;
    }

}
