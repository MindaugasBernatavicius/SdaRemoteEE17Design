package cf.mindaugas._02_solid;

public class _05_DIP {
    public static void main(String[] args) {
//        Student s0 =  new Student("USA", "Los angeles", "Venice Beatch", 15);
         Student s1 =  new Student(new ShippingAddress("USA", "Los angeles", "Venice Beatch", 15, "PO-152"));
         Student s2 =  new Student(new OfficeAddress("USA", "Los angeles", "Venice Beatch"));
    }
}

// Prerequisite: what is a "dependency".
// ... when a class needs another class to be instantiated ands work correctly

//// 0.
//// this Student depends on ShippingAddress class.
//// dependency for the Student class is the ShippingAddress class.
//// b/c ShippingAddress is a concrete class we depend on a concretion
//// ... so we violate Dep. Inv. Princip.
//class Student {
//    private String name;
//    private ShippingAddress address; // dependency
//
////    public Student(String country, String city, String address, int flat) {
////        this.address = new ShippingAddress(country, city, address, flat);
////    }
//
//    public Student(ShippingAddress shippingAddress) {
//        this.address = shippingAddress;
//    }
//}

//// 1.
//// ... let's make it a bit better
//// ... but we still don't get the full flexibility
// class Student {
//     private String name;
//     private Address address;
//
//     public Student(String country, String city, String address) {
//         this.address = new Address(country, city, address);
//     }
//
//     // ... what if we need the flat number? We can use conditional initialization
//     // public Student(String country, String city, String address, int flat) {
//     //     if(flat == 0){
//     //         this.address = new Address(country, city, address);
//     //     } else {
//     //         this.address = new ShippingAddress(country, city, address, flat);
//     //     }
//     // }
// }

// 2.
// we can use dep inversion + dependency injection to achieve the most flexibility
class Student {
    private String name;
    private Address address;

    // constructor injection
    public Student(Address address) {
        this.address = address;
    }

    // ... or setter injection
    void setAddress(Address address) {
        address = address;
    }
}

abstract class Address {
    private String country;
    private String city;
    private String streetAddress;

    public Address(String country, String city, String streetAddress) {
        this.country = country;
        this.city = city;
        this.streetAddress = streetAddress;
    }
}

class OfficeAddress extends Address {
    public OfficeAddress(String country, String city, String streetAddress) {
        super(country, city, streetAddress);
    }
}

class ShippingAddress extends Address {
    private int flatNumber;

    public ShippingAddress(String country,
                           String city,
                           String streetAddress,
                           int flatNumber,
                           String poBox) {
        super(country, city, streetAddress);
        this.flatNumber = flatNumber;
    }
}