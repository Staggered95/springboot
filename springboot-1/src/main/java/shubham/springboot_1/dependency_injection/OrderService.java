package shubham.springboot_1.dependency_injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderService {
    //1. field injection
    //@Autowired
    PaymentService paymentService;

    //2. constructor injection
    OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    //3. setter injection
    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }


    public void placeOrder() {
        paymentService.pay();
        System.out.println("Order Placed");
    }
}
