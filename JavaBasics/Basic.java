


import java.util.*;
public class Basic {
    public static void main(String[] args) {
        List a = null;

        Basic b = new Basic();
    }

    public detailResponse getDetails(int a){
        detailResponse dr = null;
        if(a==1) dr = detailResponse.get();
        else dr = demoDetailsResponse.get();
        return  dr;
    }
}

class detailResponse{
    String name;
    String addr;
    String lastName;

    public static detailResponse get(){
        detailResponse d = new detailResponse();
        d.addr = "addr";
        d.name = "addr";
        d.lastName = "addr";
        return d;
    }

}

class demoDetailsResponse extends detailResponse{
    String firstName;
    String motherName;
    String fatherName;

    public static demoDetailsResponse get(){
        demoDetailsResponse dr = new demoDetailsResponse();
        dr.addr = "tmp addr";
        dr.name="tmp name";
        dr.lastName = "tmp last";
        dr.firstName = "tmp last";
        dr.motherName = "tmp last";
        dr.fatherName = "tmp last";
        return  dr;
    }
}


