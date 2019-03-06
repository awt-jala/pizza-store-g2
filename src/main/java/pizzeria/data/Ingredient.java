package pizzeria.data;

/**
 * This class is used to represent the ingredients per sucursal.
 *
 * @author Marines Lopez Soliz
 *
 */
public class Ingredient {

    /** Ingredient Type. **/
    private final IngredientType ingredient;

    /** Cost of the ingredient per sucursal. **/
    private final double cost;

    /** Unity of the ingredient per sucursal. **/
    private final String unity;

    /**
     * Default Constructor.
     *
     * @param ingredient IngredientType
     * @param cost       double
     * @param unity      String, e.g. 8km
     */
    public Ingredient(final IngredientType newIngredient, final double newCost,
            final String newUnity) {
        this.ingredient = newIngredient;
        this.cost = newCost;
        this.unity = newUnity;
    }

    /**
     * Getter.
     *
     * @return ingredient type
     */
    public IngredientType getIngredient() {
        return ingredient;
    }

    /**
     * Getter.
     *
     * @return cost
     */
    public double getCost() {
        return cost;
    }

    /**
     * Getter.
     *
     * @return unity
     */
    public String getUnity() {
        return unity;
    }

}
