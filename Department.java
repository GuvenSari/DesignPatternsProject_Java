import java.util.ArrayList;

public abstract class Department {
    // Aggregate object for storing equipments
    AbstractAggregate aggregate = new EquipmentsCollection();
    // iterator object for iteration over the Collection
    AbstractIterator iterator = aggregate.CreateIterator();
    // students in department
    protected ArrayList<Student> students = new ArrayList<Student>();
    ArrayList<Student> notifiedStudents = new ArrayList<>();
    protected String departmentName;

    // constructor
    public Department(String departmentName, ArrayList<Equipment> equipments) {
        this.departmentName = departmentName;
        for (Equipment equipment : equipments) {
            aggregate.add(equipment);
        }
    }

    // getter and setters

    public ArrayList<Equipment> getEquipments() {
        return aggregate.getEquipments();
    }

    //Register the Observers
    public void Attach(Student student) {
        students.add(student);
    }

    //Unregister from the list of Observers.
    public void Detach(Student student) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getName() == student.getName()) {
                students.remove(i);
                return;
            }
        }
    }

    //Notify the Observers.
    public void Notify() {
        // set argument to something that helps
        // tell the Observers what happened
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            if(!notifiedStudents.contains(students.get(i))){
                notifiedStudents.add(student);
                student.Update(this);
            }
        }
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    // changing status of equipment
    public void setAvailable(String equipmentName, boolean status) {
        for (iterator.First(); !iterator.IsDone(); iterator.Next()) {
            Equipment equipment = iterator.CurrentEquipment();
            if (equipment.getName().equals(equipmentName)) {
                equipment.setStatus(status);
            }
        }
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    // get a particular student from name
    public Student getStudent(String name) {
        for (Student student : students) {
            if (student.getName().equals(name)) {
                return student;
            }
        }
        return null;
    }

    // displaying equipments that are available
    public void displayAvailableEquipments() {
        System.out.println("Displaying available equipments");

        for (iterator.First(); !iterator.IsDone(); iterator.Next()) {
            Equipment equipment = iterator.CurrentEquipment();
            if (equipment.isAvailable()) {
                equipment.Display();
            }
        }

    }
}
