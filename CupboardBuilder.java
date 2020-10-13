package lesson5;

public interface CupboardBuilder {
    Cupboard build();
    CupboardBuilder name();
    CupboardBuilder color();
    CupboardBuilder height();
}
