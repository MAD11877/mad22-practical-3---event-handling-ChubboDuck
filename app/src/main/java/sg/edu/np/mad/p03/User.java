package sg.edu.np.mad.p03;

public class User {
    String Name;
    String Description;
    Integer Id;
    Boolean Followed;

    public User(String n, String d, int eyed, boolean f){
        Name = n;
        Description = d;
        Id = eyed;
        Followed = f;
    }
}