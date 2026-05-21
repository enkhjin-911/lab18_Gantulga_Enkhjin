package pizzashop.decorator;

import pizzashop.model.Pizza;

public class ExtraCheese extends PizzaDecorator {
    public ExtraCheese(Pizza pizza) { super(pizza); }

    public String getName()        { return pizza.getName() + " + нэмэлт бяслаг"; }
    public double getBasePrice()   { return pizza.getBasePrice() + 2000; }
    public String getIngredients() { return pizza.getIngredients() + ", нэмэлт бяслаг"; }
}
