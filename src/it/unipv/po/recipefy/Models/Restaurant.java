package it.unipv.po.recipefy.Models;


/*
 * @Property Int RestaurantID
 * @Property Int UserID
 * @Property String Nome
 * @Property String Indirizzo  !!? Creare Tipo apposito? ?!!
 * @Property String Orario
 * @Property Recipe[] Menu <-- Relationship Recipe<->Restaurant? !!? Creare Tipo Menu ?!!
 *
 * @Method Bool CreateMenu()
 * @Create Bool UpdateMenu()
 *
 */
public class Restaurant {
    int RestaurantID;
    int UserID;
    String Nome;
    String Indirizzo;
    String Orario;
    RecipeModel[] Menu;
}
