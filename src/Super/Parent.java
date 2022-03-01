package Super;

// Tạo class cha Parent
class Parent {
    public String name = "Biến lớp cha";
    public String address = "Hà Nội";

    public Parent() {} //Hàm tạo hay Constructor
}

// Tạo class con kế thừa class Parent
class Child extends Parent{
    public String name = "Biến lớp con";

    public Child(String add) {
        this.address = add;
    } //Hàm tạo hay Constructor

    public void display1() {
        // Sử dụng từ khóa super
        System.out.println("Sử dụng super gọi biến name: " + this.name);
        // Không sử dụng từ khóa super
        System.out.println("Không sử dụng super: " + name);
    }

    public void display2() {
        System.out.println("Nơi ở: " + address);

    }
}


