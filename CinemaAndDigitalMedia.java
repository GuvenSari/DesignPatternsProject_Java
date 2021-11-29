import java.util.ArrayList;

// VisualCommunicationDepartment class extending from Department abstract class
public class CinemaAndDigitalMedia extends Department {
    // reservation person assigned by department
    ReservationPerson reservationPerson;
    AbstractAggregate aggregate = new EquipmentsCollection();

    // constructor
    public CinemaAndDigitalMedia(String departmentName, ArrayList<Equipment> equipments) {
        super(departmentName, equipments);
        reservationPerson = ReservationPerson.getReservedPerson();
    }

    // function to change the status of a specific equipment either it is available or not
    public void setAvail(String equipmentName, boolean status){
        setAvailable(equipmentName,status);
        // as status changes, it notifies the students
        Notify();
    }

    // getting reservation person
    public ReservationPerson getReservationPerson(){
        return reservationPerson;
    }

    public void setAggregateList(ArrayList<Equipment> equipment){

    }

}
