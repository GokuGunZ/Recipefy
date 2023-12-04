package it.unipv.po.recipefy.Models;


/*
 * @Property Int ReviewID
 * @Property Int RecipeID
 * @Property Int UserID
 * @Property Enumeration OverallRating
 * @Property Enumeration TasteRating
 * @Property Enumeration PreparationRating
 * @Property Enumeration ReproducibilityRating
 * @Property Enumeration StalenessRating
 * @Property String Comment
 * @Property DateTime DatePosted
 *
 * @Method Bool CreateReview(RecipeID, UserID)
 *
 */
public class Review {
    int ReviewID;
    int RecipeID;
    int UserID;
    //Enumeration OverallRating;
    //Enumeration TasteRating;
    //Enumeration PreparationRating;
    //Enumeration ReproducibilityRating;
    //Enumeration StalenessRating;
    String Comment;
    //DateTime DatePosted;
}
