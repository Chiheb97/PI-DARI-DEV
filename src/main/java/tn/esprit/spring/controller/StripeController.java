package tn.esprit.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.param.checkout.SessionCreateParams;
import com.stripe.model.checkout.Session;
import java.util.HashMap;
import java.util.Map;
import tn.esprit.spring.utils.CheckoutPayment;

@Controller
@RestController
@CrossOrigin
@RequestMapping(path = "/api")
public class StripeController {
	private static Gson gson = new Gson();
	@PostMapping("/payment")
	public String paymentWithCheckoutPage(@RequestBody CheckoutPayment payment) throws StripeException {
		// We initilize stripe object with the api key
		init();
		// We create a  stripe session parameters
		SessionCreateParams params = SessionCreateParams.builder()
				// We will use the credit card payment method 
				.addPaymentMethodType(SessionCreateParams.PaymentMethodType.CARD).setLocale(SessionCreateParams.Locale.EN)
				.setMode(SessionCreateParams.Mode.PAYMENT).setSuccessUrl(payment.getSuccessUrl())
				.setCancelUrl(
						payment.getCancelUrl())
				.addLineItem(
						SessionCreateParams.LineItem.builder().setQuantity(payment.getQuantity())
								.setPriceData(
										SessionCreateParams.LineItem.PriceData.builder()
												.setCurrency(payment.getCurrency()).setUnitAmount(payment.getAmount())
												.setProductData(SessionCreateParams.LineItem.PriceData.ProductData
														.builder().setName(payment.getName()).build())
												.build())
								.build())
				.build();
  // create a stripe session
		Session session = Session.create(params);
		Map<String, String> responseData = new HashMap<>();
    // We get the sessionId and we putted inside the response data you can get more info from the session object
		responseData.put("id", session.getId());
      // We can return only the sessionId as a String
		return gson.toJson(responseData);
	}

	private static void init() {
		Stripe.apiKey = "sk_test_51Ii5QfLTxymQJUsGgkKhrvB0QzrpMEg28fBKWIZmI9KZAeR1jRVEAXJwhviY23zNSJV4D5LLTmh9ywuqNjr1FS9L00tmglUFyI";
	}
}
