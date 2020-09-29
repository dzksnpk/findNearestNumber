package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static ArrayList<Integer> findNearestNumber(ArrayList<Integer> l1, ArrayList<Integer> l2) {
        Collections.sort(l1);
        Integer number = l2.get(0);
        Integer index = 0;

        Integer distance = Math.abs(l1.get(0) - number);
        for (Integer c = 1; c < l1.size(); c++) {
            Integer cdistance = Math.abs(l1.get(c) - number);

            if (cdistance < distance) {
                index = c;
                distance = cdistance;
            }
        }
        for (Integer c = 0; c < l1.size(); c++) {
            Integer cdistance = Math.abs(l1.get(c) - number);
            if (number == l1.get(c)) {
                l2.add(number);
            }
            if (cdistance.equals(distance) && number > l1.get(c)) {
                l2.add(l1.get(index));
            }
            if (cdistance.equals(distance) && number < l1.get(c)) {
                l2.add(l1.get(c));
            }
        }
        l2.remove(0);
        return l2; // write your code here
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> list1 = readArrayList(sc);
        ArrayList<Integer> list2 = readArrayList(sc);

        ArrayList<Integer> result = findNearestNumber(list1, list2);

        result.forEach(n -> System.out.print(n + " "));

    }

    private static ArrayList<Integer> readArrayList(Scanner scanner) {
        return Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
