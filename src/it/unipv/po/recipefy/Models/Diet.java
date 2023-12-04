package it.unipv.po.recipefy.Models;


/*
 * @Property Int DietID
 * @Property Int DietitianID ||UserID From table
 * @Property String DietName
 * @Property MealPlan MealPlan <-- !??Implementare classe MealPlan come Recipe[] strutturato??! --correlato Classe Meal
 * @Property User[] SharedWith <-- Relationship Diet<->User
 * @Property String NutritionInfo
 *
 * @Method Bool CreateDietPlan(DietitianID)
 * @Method User[] GetClients(DetitianID)
 * @Method Meal[] GetMeal(weekday, meal)  !??Implementare classe Meal??!
 *
 */
public class Diet {
    int DietID;
    int DietitianID;
    String DietName;
    //MealPlan MealPlan;
    UserModel[] SharedWith;
    String NutritionInfo;
}
