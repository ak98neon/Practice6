package ua.nure.kudria.practice6.part7;

public class Part7 {

    public static void main(String[] args) {
        Range range = new Range(3, 10);
        System.out.print("result: ");
        for (Integer el : range) {
            System.out.printf("%d ", el);
        }
        System.out.println();
        // result: 3 4 5 6 7 8 9 10

        range = new Range(3, 10, true);
        System.out.print("result: ");
        for (Integer el : range) {
            System.out.printf("%d ", el);
        }
        System.out.println();
        // result: 10 9 8 7 6 5 4 3
    }
}
