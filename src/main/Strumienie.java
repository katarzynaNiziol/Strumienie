package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Strumienie {

    public static void main(String[] arg) {

        List<Mieszkanie> mList = Arrays.asList(
                new Mieszkanie("Wroclaw", "Psie Pole", "Ulica na Psim Polu", 3, 66, true, 390000),
                new Mieszkanie("Warszawa", "Praga", "Targowa", 2, 25.65f, true, 320000),
                new Mieszkanie("Lublin", "Czechów", "Chodzki", 2, 30.9f, false, 300000),
                new Mieszkanie("Gdansk", "Glowne Miasto", "Mariacka", 3, 45, true, 459000));

        mList.stream()
                .filter(mieszkanie -> mieszkanie.getMiasto().equals("Wroclaw"))
                .filter(mieszkanie -> mieszkanie.getPokoje() >1)
                .filter(mieszkanie -> mieszkanie.getCena() < 400000)
                .map(mieszkanie -> mieszkanie.getMiasto() + " " + mieszkanie.getDzielnica() + " " + mieszkanie.getUlica()
                        + " " + mieszkanie.getPokoje() + " " + mieszkanie.getCena())
                .forEach(System.out::println);




        Predicate<Mieszkanie> mNazwa = m -> m.isPiwnica();

        List<Mieszkanie> lista = new ArrayList<>();

        lista = mList.stream()
                .filter(mNazwa)
                .collect(Collectors.toList());

        System.out.println(lista);

    }
}
