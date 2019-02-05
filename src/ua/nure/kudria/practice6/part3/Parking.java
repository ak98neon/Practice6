package ua.nure.kudria.practice6.part3;

import java.util.Objects;

public class Parking {
    private Object[] list;

    public Parking(int size) {
        this.list = new Object[size];
    }

    public void arrive(int pos, Object car) {
        if (pos < 0 || pos > list.length - 1) {
            return;
        }

        if (list[pos] == null) {
            list[pos] = car;
            return;
        } else {
            for (int i = pos + 1; i < list.length; i++) {
                if (list[i] == null) {
                    list[i] = car;
                    return;
                }
            }
        }
        System.out.println("Свободных мест нет");
    }

    public void depart(Object car) {
        for (int i = 0; i < Objects.requireNonNull(list).length; i++) {
            if (list[i] == car) {
                list[i] = null;
                System.out.println("Место свободно!");
                return;
            }
        }
        System.out.println("Car not exist!");
    }

    public void print() {
        for (final Object s : list) {
            if (s == null) {
                System.out.println("Место свободно");
            } else
                System.out.println("Место занято");
        }
    }
}
