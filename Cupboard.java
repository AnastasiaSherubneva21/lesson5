package lesson5;

import java.util.Random;

public class Cupboard {

    String[] colors = {"blue", "green", "yellow", "red", "purple"};
    String[] names = {"paks", "kleppstad", "boaksel", "nordkiza", "yonaksel"};

    private String name;
    private String color;
    private int height;

    public static String getRandom(String[] array) {
        int r = new Random().nextInt(array.length);
        return array[r];
    }

    public void setName() {
        this.name = getRandom(names);
    }

    public void setColor() {
        this.color = getRandom(colors);
    }

    public void setHeight() {
        int min = 70;
        int max = 210;
        int diff = max - min;
        Random random = new Random();
        int i = random.nextInt(diff+1);
        int h = min + i;
        this.height = h;
    }

    public void printInfo() {
        System.out.println(name + " " + color + " " + height);
    }
}
