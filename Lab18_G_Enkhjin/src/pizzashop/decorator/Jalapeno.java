package pizzashop.decorator;

import pizzashop.model.Pizza;

public class Jalapeno extends PizzaDecorator {
    public Jalapeno(Pizza pizza) { super(pizza); }

    public String getName()        { return pizza.getName() + " + халуун чинжүү"; }
    public double getBasePrice()   { return pizza.getBasePrice() + 1200; }
    public String getIngredients() { return pizza.getIngredients() + ", халуун чинжүү"; }
}
