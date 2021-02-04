package codemeans.shopify4j.graphql.admin.orders;

import static codemeans.shopify4j.graphql.admin.ContextForTest.PROPERTIES;
import static codemeans.shopify4j.graphql.admin.ContextForTest.TEST_STORE;

import codemeans.shopify4j.core.exception.GraphqlApiException;
import codemeans.shopify4j.graphql.admin.types.CountryCode;
import codemeans.shopify4j.graphql.admin.types.DraftOrderInput;
import codemeans.shopify4j.graphql.admin.types.DraftOrderLineItemInput;
import codemeans.shopify4j.graphql.admin.types.MailingAddressInput;
import codemeans.shopify4j.graphql.admin.types.MutationQuery;
import codemeans.shopify4j.graphql.admin.types.MutationResponse;
import codemeans.shopify4j.graphql.admin.types.Operations;
import com.shopify.graphql.support.ID;
import java.util.Arrays;
import org.junit.Test;

/**
 * @author: yuanwq
 * @date: 2021-02-04
 */
public class TestOrder {

  @Test
  public void testOrderCreate() throws GraphqlApiException {
    MailingAddressInput mailingAddress = new MailingAddressInput()
        .setAddress1("address1")
        .setAddress2("address2")
        .setCity("City name")
        .setCountryCode(CountryCode.US)
        .setFirstName("FirstName")
        .setLastName("LastName")
        .setPhone("+16135551111")
        .setProvinceCode("NY")
        .setZip("10001");
    DraftOrderLineItemInput lineItemInput1 = new DraftOrderLineItemInput(1)
        .setVariantId(new ID("gid://shopify/ProductVariant/38081516929176"));
    DraftOrderLineItemInput lineItemInput2 = new DraftOrderLineItemInput(1)
        .setVariantId(new ID("gid://shopify/ProductVariant/38081517060248"));
    DraftOrderInput orderInput = new DraftOrderInput()
        .setEmail(PROPERTIES.getProperty("customer.email"))
        .setBillingAddress(mailingAddress)
        .setShippingAddress(mailingAddress)
        .setLineItems(Arrays.asList(lineItemInput1, lineItemInput2))
        .setTags(Arrays.asList(getClass().getSimpleName(), "test"))
        .setNote("This is a test order created by graphql");
    MutationQuery mutationQuery = Operations.mutation(
        mutation -> mutation.draftOrderCreate(orderInput, query -> query
            .userErrors(errors -> errors
                .field()
                .message()
            )
            .draftOrder(order -> order
                .email()
                .customer(customer -> customer
                    .email()
                    .state()
                )
                .createdAt()
                .completedAt()
                .invoiceSentAt()
                .invoiceUrl()
                .currencyCode()
                .ready()
                .status()
                .totalPrice()
                .totalShippingPrice()
                .totalTax()
                .subtotalPrice()
            )
        )
    );
    MutationResponse response = TEST_STORE.mutation(mutationQuery);
    System.out.println(response.prettyPrintJson());
  }
}
