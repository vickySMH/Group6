import java.io.Serializable;

public class Actor implements Serializable {

    private String name;
    private String role;

    public Actor(String name, String role)
    {
        setName(name);
        setRole(role);
    }

    public void setRole(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String toString(){
        return name + " - " + role;
    }
}