public class User {
    private int id;
    private String name;
    private String password;
    private String email;
    
    public User(int id, String name, String password, String email) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
    }
    
    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public int getPasswordLength() {
        return password.length();
    }
}