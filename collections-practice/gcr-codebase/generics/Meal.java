interface MealPlan {
    void mealDetails();
}

class VegetarianMeal implements MealPlan {
    public void mealDetails() {
        System.out.println("Vegetarian Meal Plan");
    }
}

class KetoMeal implements MealPlan {
    public void mealDetails() {
        System.out.println("Keto Meal Plan");
    }
}

class Meal<T extends MealPlan> {
    T meal;

    Meal(T meal) {
        this.meal = meal;
    }

    static <T extends MealPlan> void generateMeal(T meal) {
        meal.mealDetails();
    }

    public static void main(String[] args) {

        Meal<VegetarianMeal> vegMeal = new Meal<>(new VegetarianMeal());

        Meal<KetoMeal> ketoMeal = new Meal<>(new KetoMeal());

        generateMeal(vegMeal.meal);
        generateMeal(ketoMeal.meal);
    }
}
