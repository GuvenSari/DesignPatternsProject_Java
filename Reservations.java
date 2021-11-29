import java.util.ArrayList;

// reservations class to handle all the reservations
public class Reservations {
    private ArrayList<Student> reservations = new ArrayList<Student>();
    private ArrayList<Student> acceptedOnes = new ArrayList<>();

    // adding student to reservation
    public void Add(Student student) {
        reservations.add(student);
    }

    // removing student
    public void Remove(Student student) {
        for (int i = 0; i < reservations.size(); i++) {
            if (reservations.get(i).getName() == student.getName()) {
                reservations.remove(i);
                return;
            }
        }
    }

    // displaying reservations
    public void Display() {
        for (int i = 0; i < reservations.size(); i++) {
            System.out.println(reservations.get(i));
        }
    }

    // getting reservations
    public ArrayList<Student> getReservations() {
        return reservations;
    }

    // function to accept the visitor and assigning him the equipment if it is available or not
    public void Accept(Visitor visitor) {
        for (int i = 0; i < reservations.size(); i++) {
            for (Equipment equipment : Main.arrayList) {
                if (equipment.isAvailable()) {
                    if (equipment.getName().equals(reservations.get(i).getEquipmentName())) {
                        reservations.get(i).AcceptReservation(visitor);
                        Student student = reservations.get(i);
                        equipment.setStatus(false);
                        System.out.println("Reservation to " + student.getName() + " for equipment " +
                                student.getEquipmentName() + " is taken");
                        acceptedOnes.add(student);
                    }
                }
            }
        }

        settingAcceptedStudents();
        rejectedOnes();
    }

    // function to display the rejected reservation because the equipment was not available
    public void rejectedOnes(){
        for(Student student : reservations){
            System.out.println("Reservation to " + student.getName() + " for equipment " +
                    student.getEquipmentName() + " is rejected");
        }
    }

    public void settingAcceptedStudents(){
        for(Student s : acceptedOnes){
            Remove(s);
        }
        acceptedOnes.clear();
    }
}

