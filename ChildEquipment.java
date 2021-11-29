/* Guven Sari - 20160601040
    Süleyman Önel - 20160601156
    Mustafa Bozkurt - 20160601008
    Serdar Kan - 20160602158

 */

// childParent class implementing Equipment interface
public class ChildEquipment implements Equipment {
    // data members
    String name;
    boolean isAvailable;

    // constructor
    public ChildEquipment(String name) {
        this.name = name;
        isAvailable = true;
    }

    // override method from interface
    @Override
    public void Add(Equipment e) {
        System.out.println("Cannot add in a child equipment");
        System.out.println(" *** ");
    }

    @Override
    public void Remove(Equipment e) {
        System.out.println("Cannot delete from child equipment");
    }

    @Override
    public void Display() {
        System.out.println("-----" + name);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isAvailable() {
        return isAvailable;
    }

    @Override
    public boolean getAvailable() {
        return isAvailable;
    }

    public void setStatus(boolean available) {
        isAvailable = available;
    }

}
