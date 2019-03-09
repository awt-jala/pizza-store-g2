package pizzeria.business;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import pizzeria.data.Ingredient;
import pizzeria.data.IngredientType;
import pizzeria.data.Pizza;
import pizzeria.data.PizzaTypes;

/**
 * Class to represent a store of pizzas or pizzeria.
 *
 * @author Marines Lopez Soliz
 */
public class PizzaStore {

    /** Store name. **/
    private final String name;

    /** Factory of pizzas. **/
    private final PizzaFactory factory;

    /**
     * Parameterized constructor.
     *
     * @param newName        name
     * @param newIngredients store ingredient collection.
     * @param newMenuDetail  ingredient types of a pizza type per store.
     */
    public PizzaStore(final String newName,
            final Map<IngredientType, Ingredient> newIngredients,
            final Map<PizzaTypes, Collection<IngredientType>> newMenuDetail) {
        this.name = newName;
        this.factory = new PizzaFactory(newIngredients, newMenuDetail);
    }

    /**
     * Create a pizza with the pizzaType.
     *
     * @param type PizzaType
     * @return Pizza
     */
    public Pizza orderPizza(final PizzaTypes type) {
        return factory.createPizza(type);
    }

    /**
     * Create a billing from an order.
     *
     * @param order List<OrderItems>
     * @return billing
     */
    public Billing orderPizza(final List<OrderItem> order) {
        double totalCost = 0;
        final List<Pizza> pizzas = new ArrayList<Pizza>();
        for (final OrderItem orderItem : order) {
            final Pizza pizza = factory.createPizza(orderItem.getType());
            System.out.println(pizza);
            for (int i = 0; i < orderItem.getQuantity(); i++) {
                pizzas.add(pizza);
            }
            totalCost += orderItem.getQuantity() * pizza.getCost();
        }
        return new Billing(totalCost, pizzas);
    }

    /**
     * Getter of store name.
     *
     * @return name
     **/
    public String getName() {
        return this.name;
    }
}
