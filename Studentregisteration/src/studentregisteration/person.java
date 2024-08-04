
package studentregisteration;


public abstract class person {//abstract&supercalss
    protected String name;
    protected String address;
    protected String date_ofbirth;
    protected String telephon_number;
    protected int age;
    protected int id;

    person(){};

    public person(String name, String address, String date_ofbirth, String telephon_number, int age, int id) {
        this.name = name;
        this.address = address;
        this.date_ofbirth = date_ofbirth;
        this.telephon_number = telephon_number;
        this.age = age;
        this.id = id;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTelephon_number() {
        return telephon_number;
    }

    public void setTelephon_number(String telephon_number) {
        this.telephon_number = telephon_number;
    }

    public String getDate_ofbirth() {
        return date_ofbirth;
    }

    public void setDate_ofbirth(String date_ofbirth) {
        this.date_ofbirth = date_ofbirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
