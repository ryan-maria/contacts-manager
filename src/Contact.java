public class Contact {
    private String _firstName;
    private String _lastName;
    private Integer _phone;

    public Contact(String firstName, String lastName, Integer phone){
        this._firstName = firstName;
        this._lastName = lastName;
        this._phone = phone;
    }

    public void setName(String firstName, String lastName){
        this._firstName = firstName;
        this._lastName = lastName;
    }

    public void setPhone(Integer phone){
        this._phone = phone;
    }

    public String getName(){
        return this._firstName + " " + this._lastName;
    }

    public Integer getPhone(){
        return this._phone;
    }
}
