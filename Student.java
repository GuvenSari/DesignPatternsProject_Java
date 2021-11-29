// student class extending reservation for and implementing notification interface to receive notification
public class Student extends ReservationFor implements Notification{

    // constructor
    public Student(String name, String id, String equipmentName) {
        super(name, id, equipmentName);
    }
    // override method accepting student as visitor for reservation

    @Override
    public void AcceptReservation(Visitor visitor) {
        visitor.Accept(this);
    }

    // as equipment is updated, it is notified by department to student that particular equipment is available
    @Override
    public void Update(Department department) {
        Student student = department.getStudent(getName()); // getting student details from department

        System.out.println("The  " + student.getEquipmentName() + " equipment is available now!! It notified to Student "
        + student.getName() + " ");
    }
}
