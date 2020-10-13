package lesson5;

public class CupboardBuilderImpl implements CupboardBuilder{

    private Cupboard cupboard;

    CupboardBuilderImpl() {
        cupboard = new Cupboard();
    }
    @Override
    public Cupboard build() {
        return cupboard;
    }

    @Override
    public CupboardBuilder name() {
        cupboard.setName();
        return this;
    }

    @Override
    public CupboardBuilder color() {
        cupboard.setColor();
        return this;
    }

    @Override
    public CupboardBuilder height() {
        cupboard.setHeight();
        return this;
    }
}
