package pizzashop.decorator;

import pizzashop.model.Pizza;

public class Mushroom extends PizzaDecorator {
    public Mushroom(Pizza pizza) { super(pizza); }

    public String getName()        { return pizza.getName() + " + мөөг"; }
    public double getBasePrice()   { return pizza.getBasePrice() + 1500; }
    public String getIngredients() { return pizza.getIngredients() + ", мөөг"; }
}
