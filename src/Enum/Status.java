package Enum;

public enum Status {
    Success(0),
    Fail(-1) ,

    Unknow(-99) ;

    private int code ;

    Status(int code ) {
        this.code =code;
    }

    public int getCode() {
        return code;
    }


}


