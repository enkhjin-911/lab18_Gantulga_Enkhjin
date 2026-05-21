package pizzashop.decorator;

import pizzashop.model.Pizza;

public class Olives extends PizzaDecorator {
    public Olives(Pizza pizza) { super(pizza); }

    public String getName()        { return pizza.getName() + " + оливс"; }
    public double getBasePrice()   { return pizza.getBasePrice() + 1000; }
    public String getIngredients() { return pizza.getIngredients() + ", оливс"; }
}
