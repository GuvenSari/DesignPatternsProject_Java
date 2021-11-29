// reservationfor class implementing element interface
public abstract class ReservationFor implements Element {
    // data members
    String name;
    String id;
    String equipmentName;

    // constructor
    public ReservationFor(String name, String id, String equipmentName) {
        this.name = name;
        this.id = id;
        this.equipmentName = equipmentName;
    }

    // getter and setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    @Override
    public boolean equals(Object obj) {
        ReservationFor s = (ReservationFor) obj;
        return s.getId().equals(this.id) && s.getName().equals(this.name) && s.getEquipmentName().equals(this.equipmentName);
    }

    // toString method to print
    @Override
    public String toString() {
        return "ReservationFor{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", equipmentName='" + equipmentName + '\'' +
                '}';
    }
}