import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by pc on 4/3/2021.
 */
public class User extends ProgramFunctions {
    private String name;
    private String phone;
    private String email;
    private String country;
    private int age ;
    private LinkedList<Products> stackFav;
    Scanner s ;

    public User(String name, String phone, String email, String country, int age) {
        super();
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.country = country;
        this.age = age;
        stackFav = new LinkedList<>();
        s = new Scanner(System.in);
    }

    public boolean check (){
        boolean f = true;
        if (!checkString(name))
        {
            System.out.println("Invalid Name.");
            setName(s.next());
            f = false;
        }

        if (!checkPhone(phone))
        {
            System.out.println("Invalid Phone Number.");
            setPhone(s.next());
            f = false;
        }

        if (!checkCountry(country))
        {
            System.out.println("Invalid Country Name.");
            setCountry(s.next());
            f = false;
        }

        if (!valid22(email))
        {
            System.out.println("Invalid Email Form.");
            setEmail(s.next());
            f = false;
        }

        if (!checkAge(age))
        {
            System.out.println("Invalid Age.Age must be in 18 - 120");
            setAge(s.nextInt());
            f = false;
        }

        return f;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        if (checkCountry(country))
            this.country = country;
        else {
            System.out.println("Invalid Country Name.");
            setCountry(s.next());
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (checkString(name))
            this.name = name;
        else
        {
            System.out.println("Invalid Name.");
            setName(s.next());
        }
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if (checkPhone(phone))
            this.phone = phone;
        else
        {
            System.out.println("Invalid Phone Number.");
            setPhone(s.next());
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (valid22(email))
            this.email = email;
        else
        {
            System.out.println("Invalid Email Form.");
            setEmail(s.next());
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (checkAge(age))
            this.age = age;
        else
        {
            System.out.println("Invalid Age.");
            setAge(s.nextInt());
        }
    }

    public void addFav (Products p){
        stackFav.add(p);
        System.out.println("Added.");
    }

    public Products removeFav (Products p){
        Products x ;
        if (stackFav.indexOf(p) != -1)
        {
            x = stackFav.get(stackFav.indexOf(p));
            stackFav.remove(p);
            return x;
        }
        return null;
    }

    public void printFav (){
        stackFav.toString();
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", country='" + country + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        User user = new User("Manal","737366371","alsaeedimanal96@gmail.com","s",19);
        int t = 1;
        Scanner s1 = new Scanner(System.in);

        while (!user.check());

        while (user.check() && t != 0)
        {
            System.out.println("1- Add Product to Favorite List.");
            System.out.println("2- Remove Product off List.");
            System.out.println("3- Edit profile.");

            switch (s1.nextInt()) {
                case 1:
                    user.addFav(new Products());
                    break;
                case 2:
                    user.removeFav(new Products());
                    break;
                case 3:
                {
                    System.out.println("1- Edit Your Name.");
                    System.out.println("2- Edit Your Phone Number.");
                    System.out.println("3- Edit Your Email.");
                    System.out.println("4- Edit Your Country.");
                    System.out.println("5- Edit Your Age.");

                    switch (s1.nextInt())
                    {
                        case 1:
                            user.setName(s1.next());
                            break;
                        case 2:
                            user.setPhone(s1.next());
                            break;
                        case 3:
                            user.setEmail(s1.next());
                            break;
                        case 4:
                            user.setCountry(s1.next());
                            break;
                        case 5:
                            user.setAge(s1.nextInt());
                            break;
                        default:
                            System.out.println("Invalid Number.");
                            break;
                    }
                }

                default:
                    System.out.println("Invalid Number.");
                    break;
            }
            System.out.println("0 to exit.");
            t = s1.nextInt();
        }
    }
}
