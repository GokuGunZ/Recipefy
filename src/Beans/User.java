package Beans;

public class User {
    int userID;
    String username;
    String email;
    String name;
    String bio;

    public User(int Id, String user, String eMail){
        this.userID = Id;
        this.username = user;
        this.email = eMail;
        this.name = "";
        this.bio = "";
    }

    public User(int Id, String user, String eMail, String name, String bio){
        this.userID = Id;
        this.username = user;
        this.email = eMail;
        this.name = name;
        this.bio = bio;
    }

    public int getUserID(){return this.userID;};
    public String getUsername(){return this.username;};
    public String getName(){return this.name;};
    public String getEmail(){return this.email;};
    public String getBio(){return this.bio;};
}
