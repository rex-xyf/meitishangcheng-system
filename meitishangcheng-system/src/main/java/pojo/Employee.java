package pojo;

public class Employee {
    private int id;
    private String name;
    private String address;
    private String hourWages;
    private String department;
    private String workShifts;

    public Employee() {
    }

    public Employee(int id, String name, String address, String hourWages, String department, String workShifts) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.hourWages = hourWages;
        this.department = department;
        this.workShifts = workShifts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHourWages() {
        return hourWages;
    }

    public void setHourWages(String hourWages) {
        this.hourWages = hourWages;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getWorkShifts() {
        return workShifts;
    }

    public void setWorkShifts(String workShifts) {
        this.workShifts = workShifts;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", hourWages='" + hourWages + '\'' +
                ", department='" + department + '\'' +
                ", workShifts='" + workShifts + '\'' +
                '}';
    }
}
