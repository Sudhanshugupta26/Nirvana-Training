class User {

    private String name;
    private String email;
    private int age;
    private String phone;

    private User(Builder builder) {

        this.name = builder.name;
        this.email = builder.email;
        this.age = builder.age;
        this.phone = builder.phone;
    }

    public void display() {

        System.out.println(name);

        System.out.println(email);

        System.out.println(age);

        System.out.println(phone);
    }

    public static class Builder {

        private String name;
        private String email;
        private int age;
        private String phone;

        public Builder(String name, String email) {

            this.name = name;
            this.email = email;
        }

        public Builder age(int age) {

            this.age = age;
            return this;
        }

        public Builder phone(String phone) {

            this.phone = phone;
            return this;
        }

        public User build() {

            return new User(this);
        }
    }
}

public class Builder {
    public static void main(String[] args) {

        User user = new User.Builder(
                "Sudhanshu",
                "abc@gmail.com")

                .age(22)

                .phone("9876543210")

                .build();

        user.display();
    }
}
