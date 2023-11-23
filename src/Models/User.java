package Models;

/*
 * @Property Int UserID
 * @Property String Username
 * @Property String Email
 * @Property String Password
 * @Property Enumeration UserType
 * @Property Recipe[] RecipeList  <---- Relationship Recipe-User
 *
 * @Method Bool CreateRecipe(UserID)
 * @Method Bool UpdateRecipe(RecipeID)
 * @Method Bool DeleteRecipe(RecipeID)
 * @Method Bool CreateTag(UserID)
 * @Method Bool UpdateTag(TagID)
 * @Method Bool DeleteTag(TagID)
 * @Method Recipe[] GetAllRecipes(UserID)
 * @Method Category[] GetAllTags(UserID)
 * @Method Diet ReadReceivedDietPlan(DietID)
 *
 *
 * ---Specialization---
 * --------Chef-------
 * @Property RestaurantID
 *
 * @Method Bool CreateRestaurant(UserID)
 * @Method Bool UpdateRestaurant(RestaurantID)
 * @Method Bool DeleteRestaurant(RestaurantID)
 * @Method Menu GetRestaurantMenu(RestaurantID)
 *
 * ------Dietitian-----
 * @Property Diet[] CreatedDietList <---- Relationship Diet-Dietitian
 *
 * @Method Bool CreateDiet(UserID)
 * @Method Bool ShareDiet(UserID, DietID)
 * @Method DietPlan GetDietPlan(DietID)
 *
 */
public class User {
}
