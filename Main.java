/* Guven Sari - 20160601040
    Süleyman Önel - 20160601156
    Mustafa Bozkurt - 20160601008
    Serdar Kan - 20160602158

    //ASSET MANAGEMENT SYSTEM - CINEMA AND DIGITAL MEDIA DEPARTMENT

    if the day is equal with current day, check and change day because it may not work...

 */

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Main {

    // array list containing equipments
    static ArrayList<Equipment> arrayList = new ArrayList<>();

    public static void main(String[] args) {


        // declaring different equipments and adding them to their parent ones
        Equipment video = new ParentEquipment("Video");
        Equipment rooms = new ParentEquipment("Rooms");

        Equipment room1 = new ChildEquipment("Room1");
        Equipment room2 = new ChildEquipment("Room2");
        //Equipment room3 = new ParentEquipment("Room3");
        rooms.Add(room1);
        rooms.Add(room2);

        Equipment camera = new ChildEquipment("Camera");
        Equipment gimble = new ChildEquipment("Gimble");
        Equipment sliders = new ChildEquipment("Sliders");
        video.Add(camera);
        video.Add(gimble);
        gimble.Add(sliders); //trial for showing cannot add child elem to child elem...
        video.Add(sliders);


        Equipment tripod = new ChildEquipment("Tripod");
        video.Add(tripod);

        Equipment lighting_kit = new ParentEquipment("Lighting kit");
        Equipment light_stand = new ChildEquipment("Light Stand");
        Equipment power_supply = new ChildEquipment("Power Supply");
        Equipment umbrella = new ChildEquipment("Umbrella");

        lighting_kit.Add(light_stand);
        lighting_kit.Add(power_supply);
        lighting_kit.Add(umbrella);

        video.Add(lighting_kit); // parent equipment

        Equipment audio = new ParentEquipment("Audio");
        Equipment amplifier = new ChildEquipment("Amplifier");
        Equipment loudSpeaker = new ChildEquipment("Loud Speaker");

        Equipment microphone = new ParentEquipment("Microphone");
        Equipment lavalier = new ChildEquipment("Lavalier");
        Equipment shotgun = new ChildEquipment("Shotgun boom mic");

        microphone.Add(lavalier);
        microphone.Add(shotgun);

        audio.Add(microphone);//  it shows us the mic is child of audio
        audio.Add(amplifier);
        audio.Add(loudSpeaker);

        Equipment editingRoom = new ParentEquipment("Editing Room");
        Equipment editing_computer = new ChildEquipment("Video Editing Computer");
        Equipment dvd = new ChildEquipment("DVD");
        editingRoom.Add(editing_computer);
        editingRoom.Add(dvd);


        // adding parent equipments to array list in order to use by the department and reservation person
        arrayList.add(video);
        arrayList.add(audio);
        arrayList.add(editingRoom);

        arrayList.add(rooms);
        //arrayList.add(room3);

        // checking if the current day is of working day or at day where class room has to be closed for reservation
        // if lecture days containing current day then room will not be available
        // otherwise rooms are avaialble
        String today = getCurrentDay();
        for(LectureDays s : LectureDays.values()) {
            if (s.toString().equals(today)) {
                room1.setStatus(false);
                room2.setStatus(false);
                //room3.setStatus(false);
            } else {
                room1.setStatus(true);
                room2.setStatus(true);
                //room3.setStatus(true);
            }
        }


        // creating new instance of  Cinema and Digital Media (CinemaAndDigitalMedia) department
        CinemaAndDigitalMedia cinemaAndDigitalMedia = new CinemaAndDigitalMedia("--> Cinema and Digital Media <-- ", arrayList);
        ReservationPerson reservationPerson = cinemaAndDigitalMedia.getReservationPerson();
        System.out.println(cinemaAndDigitalMedia.getDepartmentName());

        // getting available equipments when department needs
        cinemaAndDigitalMedia.displayAvailableEquipments();

        // reservation person adding reservations
        Student student = new Student("Guven", "20160601040", "Video");
        reservationPerson.reservations.Add(student);

        reservationPerson.reservations.Add(new Student("Süleyman", "201658745684", "Editing Room"));
        // reservationPerson.reservations.Add(new Student("Ali","20155468748","Audio"));
        Student student1 = new Student("Mustafa", "2018CS104", "Video");
        reservationPerson.reservations.Add(student1);

        Student student2 = new Student("Serdar","1231231123","Audio");
        reservationPerson.reservations.Add(student2);


        reservationPerson.reservations.Accept(new ReservationVisitor());
        reservationPerson.callUponSecurity("Security head");


        // adding reservation persons to department who have not been assigned reservations to get notified
        for (Student s : reservationPerson.reservations.getReservations()) {
            cinemaAndDigitalMedia.Attach(s);
        }


        // changing the status of video equipment
        cinemaAndDigitalMedia.setAvail("Video", true);



        reservationPerson.reservations.Accept(new ReservationVisitor());

        Student student3 = new Student("Ali","20548587546","Editing Room");
        reservationPerson.reservations.Add(student3);
        cinemaAndDigitalMedia.Attach(student3);
        rooms.Remove(room1); // removing room when a student reserved

        cinemaAndDigitalMedia.setAvail("Editing Room",true);
        reservationPerson.reservations.Accept(new ReservationVisitor());


        System.out.println();
        // displaying available equipments
        cinemaAndDigitalMedia.displayAvailableEquipments();


        EquipmentsCollection count = new EquipmentsCollection();
        CollectionIterator collectionIterator = new CollectionIterator(count);


        for (Equipment equipment : arrayList) {
            count.add(equipment);
        } // iter for adding equipmen collections

        System.out.println("The number of collections in the "+cinemaAndDigitalMedia.getDepartmentName()+
                "is : "+collectionIterator.equipmentsCollection.getCount()); // gives the number of all parent units

    }

    // getting current day from current date like Sunday
    public static String getCurrentDay(){
        Date date = new Date();
        return new SimpleDateFormat("EEEE").format(date);
    }

}

