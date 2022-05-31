package inclassdemos.lesson9;

import inclassdemos.lesson2.Address;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class OptionalDemo {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        Customer customer = new Customer(111,"Dean","aaa");

        Optional<Integer> opt1 = Optional.empty();

//        if(opt1.isPresent()){
//            System.out.println("There is no value");
//        }

//        Optional<String> opt2 = Optional.of(customer.getEmail());
//        if(opt2.isPresent())
//            System.out.println("bla");


        Optional<String> opt3 = Optional.ofNullable(customer.getEmail());
//            System.out.println(opt3.orElseGet(() -> "There is nothing"));


//        System.out.println(opt3.orElse("There is no value"));


        List<Customer> customers = new ArrayList<>();
        customers.add(customer);

        // This case you can use orElse, since the result is just returning a constant
        Optional<String> custwithId = customers.stream()
                .filter(c -> c.getId() == 111 )
                .map(c -> c.getName())
                .findFirst();
//
        System.out.println(custwithId.orElse("There is no name"));
//

        // This case you can use orElseGet to avoid an object creation even though it was was non-null
        Optional<Customer> custObjectWithId = customers.stream()
                .filter(c -> c.getId() == 111 )
                .findFirst();

        // What is we printed without any handling
//        System.out.println(custObjectWithId);
        System.out.println(custObjectWithId
                .orElse(
                        new Customer(
                        111,
                        "newName",
                        "newEmail"
                        )
                ));
    }

//    public static String enterCustomerName(){
//        System.out.println("Enter customer name: ");
//        return input.nextLine();
//    }
//
//    public static String enterCustomerEmail(){
//        System.out.println("Enter customer email: ");
//        return input.nextLine();
//    }
}
