package czzz.luhau.myapplication.Model;

public class User  {
    String mUserName,mPass,mPhone;

    public User() {
    }

    public User(String mUserName, String mPass, String mPhone) {
        this.mUserName = mUserName;
        this.mPass = mPass;
        this.mPhone = mPhone;
    }

    public String getmUserName(String username) {
        return mUserName;
    }

    public void setmUserName(String mUserName) {
        this.mUserName = mUserName;
    }

    public String getmPass() {
        return mPass;
    }

    public void setmPass(String mPass) {
        this.mPass = mPass;
    }

    public String getmPhone() {
        return mPhone;
    }

    public void setmPhone(String mPhone) {
        this.mPhone = mPhone;
    }
}
