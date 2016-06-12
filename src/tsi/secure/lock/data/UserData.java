package tsi.secure.lock.data;


public class UserData {

    private int apartment;
    private int code;

    public UserData(final int apartment, final int code) {
        this.apartment = apartment;
        this.code = code;
    }

    public int getApartment() {
        return apartment;
    }

    public void setApartment(final int apartment) {
        this.apartment = apartment;
    }

    public int getCode() {
        return code;
    }

    public void setCode(final int code) {
        this.code = code;
    }
}
