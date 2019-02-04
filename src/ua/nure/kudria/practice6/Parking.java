package ua.nure.kudria.practice6;

public class Parking {
    //Maybe ArrayList?
    private Object[] list;

    public Parking(int size) {
        this.list = new Object[size];
    }

    public void arrive(int pos, Object car) {
        for (int i = 0; i < list.length; i++) {
            if (list[i] == null) {
                list[i] = car;
                return;
            }

        }
        System.out.println("Свободных мест нет");
    }

    public void depart(Object car) {
        try {
            if ((list[car] != null)) {
                list[car] = null;
            } else
                System.out.println("Место свободно!");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Парковочное место не существует");
        }
    }

    public void print() {
        for (final String s : list) {
            if (s == null) {
                System.out.println("Место свободно");
            } else
                System.out.println("Место занято");
        }
    }
}
