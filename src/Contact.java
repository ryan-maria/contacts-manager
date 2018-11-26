public class Contact {
    private String _name;
    private Integer _phone;

    public Contact(String name, Integer phone){
        this._name = name;
        this._phone = phone;
    }

    public void setName(String name){
        this._name = name;
    }

    public void setPhone(Integer phone){
        this._phone = phone;
    }

    public String getName(){
        return this._name;
    }

    public Integer getPhone(){
        return this._phone;
    }
}
