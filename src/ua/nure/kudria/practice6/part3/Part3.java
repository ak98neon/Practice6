package ua.nure.kudria.practice6.part3;

public class Part3 {

    public static void main(String[] args) {
        int sizeParking = 5;
        Object testCar = new Object();
        Parking parking = new Parking(sizeParking);
        parking.arrive(0, testCar);
        parking.depart(testCar);
        parking.arrive(0, testCar);
        parking.arrive(1, new Object());
        parking.arrive(2, new Object());
        parking.arrive(3, new Object());
        parking.arrive(4, new Object());
        parking.arrive(5, new Object());
        parking.print();
    }
}
