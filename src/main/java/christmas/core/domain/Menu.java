package christmas.core.domain;

import static christmas.core.domain.MenuCategory.*;

public enum Menu {
    BUTTON_MUSHROOM_SOUP("양송이수프", APPETIZER, 6000),
    TAPAS("타파스", APPETIZER,5500),
    CAESAR_SALAD("시저샐러드", APPETIZER, 8000),
    T_BONE_STEAK("티본스테이크", MAIN, 55000),
    BARBECUE_RIBS("바비큐립", MAIN, 54000),
    SEAFOOD_PASTA("해산물파스타", MAIN, 35000),
    CHRISTMAS_PAST("크리스마스파스타", MAIN, 25000),
    CHOCOLATE_CAKE("초코케이크", DESSERT, 15000),
    ICECREAM("아이스크림", DESSERT, 5000),
    ZERO_COKE("제로콜라", DRINK, 3000),
    RED_WINE("레드와인", DRINK, 60000),
    CHAMPAGNE("샴페인", DRINK, 25000);

    private final String name;
    private final MenuCategory menuCategory;
    private final int price;

    Menu(String name, MenuCategory menuCategory, int price) {
        this.name = name;
        this.menuCategory = menuCategory;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public boolean hasCategoryOf(MenuCategory category) {
        return menuCategory == category;
    }
}
