public class Actor {

    private String name;
    private String role;

    private void setRole(String role){
        this.role = role;
    }

    private String getRole(){
        return role;
    }

    private String getName(){
        return name;
    }

    private void actor(String name){
        this.name = name;
    }

    public String toString(){
        return name + "-" + role;
    }
}