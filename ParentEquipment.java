import java.util.ArrayList;

// parent equipment class implementing equipment
public class ParentEquipment implements Equipment {
    // data members
    String name;
    boolean isAvailable;
    ArrayList<Equipment> equipments = new ArrayList<>();

    // constructor
    public ParentEquipment(String name) {
        this.name = name;
        isAvailable = true;
    }

    // add child equipment to parent
    @Override
    public void Add(Equipment e) {
        equipments.add(e);
    }

    // remove child equipment from parent
    @Override
    public void Remove(Equipment e) {
        for (int i = 0; i < equipments.size(); i++) {
            if (e.getName().equals(equipments.get(i).getName())) {
                equipments.remove(equipments.get(i));
            }
        }
    }

    // displaying child equipments in parent
    @Override
    public void Display() {
//        System.out.println("Availability : " + isAvailable + ", Equipment Name : " + name);
        System.out.println("--+" + name);
        for (Equipment equipment : equipments) {
//            System.out.print("Availability : " + equipment.getAvailable() + ", Equipment Name : ");
            equipment.Display();
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    // checking if the child or parent equipment is available
    @Override
    public boolean isAvailable() {
        if(isAvailable){
            for(Equipment equipment : equipments){
                if(!equipment.isAvailable()){
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    @Override
    public boolean getAvailable(){
        return isAvailable;
    }


    @Override
    public void setStatus(boolean status) {
        isAvailable = status;
    }
}
