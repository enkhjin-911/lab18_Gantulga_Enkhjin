package pizzashop.decorator;

import pizzashop.model.Pizza;

public abstract class PizzaDecorator implements Pizza {
    protected Pizza pizza;

    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    public String getName()        { return pizza.getName(); }
    public double getBasePrice()   { return pizza.getBasePrice(); }
    public String getIngredients() { return pizza.getIngredients(); }
}
