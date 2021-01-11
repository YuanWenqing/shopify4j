package codemeans.shopify4j.admin.rest.model;

import java.util.Currency;
import java.util.List;
import lombok.Data;

/**
 * shopify 返回的数据
 */
@Data
public class ShopifyWebhookEvent {

  private String id;
  private String email;
  private Object closedAt;
  private String createdAt;
  private String updatedAt;
  private String number;
  private Object note;
  private String token;
  private Object gateway;
  private boolean test;
  private String totalPrice;
  private String subtotalPrice;
  private String totalWeight;
  private String totalTax;
  private boolean taxesIncluded;
  private Currency currency;
  private String financialStatus;
  private boolean confirmed;
  private String totalDiscounts;
  private String totalLineItemsPrice;
  private Object cartToken;
  private boolean buyerAcceptsMarketing;
  private String name;
  private Object referringSite;
  private Object landingSite;
  private String cancelledAt;
  private String cancelReason;
  private Object totalPriceUsd;
  private Object checkoutToken;
  private Object reference;
  private Object userID;
  private Object locationID;
  private Object sourceIdentifier;
  private Object sourceURL;
  private Object processedAt;
  private Object deviceID;
  private Object phone;
  private String customerLocale;
  private Object appID;
  private Object browserIP;
  private Object landingSiteRef;
  private String orderNumber;
  private List<DiscountApplication> discountApplications;
  private List<Object> discountCodes;
  private List<Object> noteAttributes;
  private List<String> paymentGatewayNames;
  private String processingMethod;
  private Object checkoutID;
  private String sourceName;
  private String fulfillmentStatus;
  private List<Object> taxLines;
  private String tags;
  private String contactEmail;
  private String orderStatusURL;
  private Currency presentmentCurrency;
  private Set totalLineItemsPriceSet;
  private Set totalDiscountsSet;
  private Set totalShippingPriceSet;
  private Set subtotalPriceSet;
  private Set totalPriceSet;
  private Set totalTaxSet;
  private List<LineItem> lineItems;
  private List<Object> fulfillments;
  private List<Object> refunds;
  private String totalTipReceived;
  private Object originalTotalDutiesSet;
  private Object currentTotalDutiesSet;
  private String adminGraphqlAPIID;
  private List<ShippingLine> shippingLines;
  private Address billingAddress;
  private Address shippingAddress;
  private Customer customer;


  @Data
  public static class Address {

    private String firstName;
    private String address1;
    private String phone;
    private String city;
    private String zip;
    private String province;
    private String country;
    private String lastName;
    private Object address2;
    private String company;
    private Object latitude;
    private Object longitude;
    private String name;
    private String countryCode;
    private String provinceCode;
    private String id;
    private String customerID;
    private String countryName;
    private Boolean addressDefault;
  }

  @Data
  public static class Customer {

    private String id;
    private String email;
    private boolean acceptsMarketing;
    private Object createdAt;
    private Object updatedAt;
    private String firstName;
    private String lastName;
    private String ordersCount;
    private String state;
    private String totalSpent;
    private Object lastOrderID;
    private Object note;
    private boolean verifiedEmail;
    private Object multipassIdentifier;
    private boolean taxExempt;
    private Object phone;
    private String tags;
    private Object lastOrderName;
    private Currency currency;
    private Object acceptsMarketingUpdatedAt;
    private Object marketingOptInLevel;
    private String adminGraphqlAPIID;
    private Address defaultAddress;
  }


  @Data
  public static class DiscountApplication {

    private String type;
    private String value;
    private String valueType;
    private String allocationMethod;
    private String targetSelection;
    private String targetType;
    private String description;
    private String title;
  }

  @Data
  public static class LineItem {

    private String id;
    private String variantID;
    private String title;
    private String quantity;
    private String sku;
    private Object variantTitle;
    private Object vendor;
    private String fulfillmentService;
    private String productID;
    private boolean requiresShipping;
    private boolean taxable;
    private boolean giftCard;
    private String name;
    private String variantInventoryManagement;
    private List<Object> properties;
    private boolean productExists;
    private String fulfillableQuantity;
    private String grams;
    private String price;
    private String totalDiscount;
    private Object fulfillmentStatus;
    private Set priceSet;
    private Set totalDiscountSet;
    private List<DiscountAllocation> discountAllocations;
    private List<Object> duties;
    private String adminGraphqlAPIID;
    private List<Object> taxLines;
  }

  @Data
  public static class DiscountAllocation {

    private String amount;
    private String discountApplicationIndex;
    private Set amountSet;
  }

  @Data
  public static class Set {

    private Money shopMoney;
    private Money presentmentMoney;
  }

  @Data
  public static class Money {

    private String amount;
    private Currency currencyCode;
  }

  @Data
  public static class ShippingLine {

    private String id;
    private String title;
    private String price;
    private Object code;
    private String source;
    private Object phone;
    private Object requestedFulfillmentServiceID;
    private Object deliveryCategory;
    private Object carrierIdentifier;
    private String discountedPrice;
    private Set priceSet;
    private Set discountedPriceSet;
    private List<Object> discountAllocations;
    private List<Object> taxLines;
  }
}


