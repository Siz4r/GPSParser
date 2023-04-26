import java.util.function.Function;

public enum Parametry {
    DATA("Data: ", data -> String.join(".", data.split("(?<=\\G.{" + 2 + "})"))),
    CZAS("Czas (UTC): ", data -> String.join(":", data.split("(?<=\\G.{" + 2 + "})"))),
    ODCHYLENIE("Odchylenie magnetyczne ziemi: ", data -> data),
    WYSOKOSC_GEOID("Wysokosc geoid: ", data -> data),
    OKRESLENIE_POZYCJI("Sposob okreslenia pozycji: ", data -> {
        char sposob = data.charAt(0);
        char pozycja = data.charAt(1);
        if (sposob == 'A' && pozycja == '1') {
            throw new RuntimeException("Zly format dla okreslania pozycji");
        }

        return (sposob == 'A' ? "automatyczny" : "manualny") +
                switch (pozycja) {
                    case '1' -> " brak ustalonej precyzji satelity";
                    case '2' -> " 2D";
                    case '3' -> " 3D";
                    default -> throw new RuntimeException("Zly wymiar dla okreslania pozycji");
                };
    }),
    SUMA("Suma kontrolna: ", data -> data.split("\\*")[1]),
    PRECYZJA_H("Precyzja horyzontalna: ", data -> data),
    PRECYZJA_W("Precyzja wertykalna: ", data -> data),
    PRECYZJA_O("Precyzja (ogolnie): ", data -> data.split("\\*")[0]),
    NUMERY_SATELITOW("Numery satelitow do pozycjonowania: ", data -> data),
    WIDOCZNE_SATELITY("Liczba widocznych satelitow: ", data -> data),
    SLEDZONE_SATELITY("Liczba sledzonych satelitow: ", data -> data),
    ID_SATELITY("Id satelity (numer): ", data -> data),
    WYNIESIENIE("Wyniesienie nad rownik w stopniach: ", data -> data),
    AZYMUT("Azymut satelity w stopniach: ", data -> data),
    SNR("Stosunek sygnal/szum (SNR) satelity: ", data -> data),
    SZEROKOSC("Szerokosc geograficzna: ", data -> data),
    DLUGOSC("Dlugosc geograficzna: ", data -> data),
    PREDKOSC("Predkosc (w wezlach): ", data -> data),
    KAT("Kat przemieszczania sie: ", data -> data),
    STATUS("Status urzadzenia (np. aktywny): ", data -> (data.equals("A") ? "aktywny" : "nieaktywny")),
    WYSOKOSC("Wysokosc n.p.m.: ", data -> data),
    POMIAR("Jakosc pomiaru: ", data -> data),
    CZAS_USTALANIA_POZYCJI("Czas ustalania pozycji wzgledem satelitow(UTC): ", data -> String.join(":", data.split("(?<=\\G.{" + 2 + "})")));


    Parametry(String name, Function<String, String> mappingFunction) {
        this.name = name;
        this.mappingFunction = mappingFunction;
    }

    final String name;
    final Function<String, String> mappingFunction;
}
