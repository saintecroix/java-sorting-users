package model;

/*[Model] User JAV-1*/
public class User {
    private final int id;
    private final String name;
    private final String password;
    private final  String email;
    
    private User(int id, String name, String password, String email) {
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
    public static Builder builder() {
            return new Builder();
        }
/*[Model] Builder JAV-3*/
    public static class Builder {
        private int id;
        private String name;
        private String password;
        private String email;

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public User build() {
            return new User(id, name, password, email);
        }
    }
}
  