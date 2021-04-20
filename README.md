# Shopify4j

Java SDK for Shopify APIs, including:

* Shopify Store & Shopify APP
* GraphQL Admin Schema
* GraphQL Admin API
* GraphQL Storefront Schema
* GraphQL Storefront API
* [INCOMPLETE] REST Admin API Models
* [INCOMPLETE] REST Admin API
* ...

## Usage

Shopify Core & APP

```
implementation("xyz.codemeans.shopify4j:shopify4j-core:1.0")
```

GraphQL Admin

```groovy
// api
implementation("xyz.codemeans.shopify4j:graphql-admin-api:1.0")
// schema
implementation("xyz.codemeans.shopify4j:graphql-admin-schema:1.0")
```

GraphQL Storefront
```groovy
// api
implementation("xyz.codemeans.shopify4j:graphql-storefront-api:1.0")
// schema
implementation("xyz.codemeans.shopify4j:graphql-storefront-schema:1.0")
```

REST Admin
```groovy
// api
implementation("xyz.codemeans.shopify4j:rest-admin-api:1.0")
// model
implementation("xyz.codemeans.shopify4j:rest-admin-model:1.0")
```

## Build from source

Requirements:

* JDK 8
* gradle >= 5.6
* ruby >= 2.3
* graphql_java_gen

Configure nexus repository in build.gradle: `$HOME/.gradle/gradle.properties` OR `gradle.properteis`

```properties
nexus.repo.url=http://your.nexus.host/repository/maven-public/
nexus.repo.public=http://your.nexus.host/repository/maven-public/
nexus.repo.release=http://your.nexus.host/repository/maven-releases/
nexus.repo.snapshot=http://your.nexus.host/repository/maven-snapshots/
nexus.username=your-nexus-username
nexus.password=your-nexus-password
```

Then run
~~~bash
gradle publish -Prelease -Ppub=nexus
~~~

# Shopify Core

## Shopify App Oauth

Shopify Oauth flow: https://shopify.dev/tutorials/authenticate-with-oauth

```java
// step1: Get client credentials
PublicApp app = new PublicApp()
  .setClientId("<client-id>")
  .setClientSecret("<client-secret>")
  .setScopes(...);

// step2: Ask for permission
AuthorizationReq req = new AuthorizationReq();
...
String authorizationUrl = oauthFlow.authorizationUrl(app, req);
redirectTo(authorizationUrl);

// step3: Confirm installation
ConfirmRedirection redirection = new ConfirmRedirection()
  .setCode("<code>")
  .setShop("<shop>");
OauthAccessToken accessToken = oauthFlow.exchangeAccessToken(app, redirection);
...

// step4: Making authenticated requests
...
```

HMAC Verification

```java
boolean verified = HmacVerification.verifyHmac(queryString, app.getClientSecret());
```

## Multi-Stores

If you are integrating with multiple shopify stores in one sysmtem, just like we do, `StoreFactory` will be very helpful.

If information of your stores is saved in some persistent database, you can just implement a `StoreSettingStorage` to retrieve data and build out a `StoreSetting`.

Here is an example for REST & GraphQL API:

```java
StoreSettingStorage settingStorage = ...;

GraphqlInvoker invoker = new OkHttpGraphqlInvoker(new PrivateAppAdminAccessTokenProvider(settingStorage));
StoreFactory<GraphqlAdmin> clientFactory = new DefaultGraphqlAdminFactory(settingStorage, invoker);
clientFactory = CachedStoreFactory.of(clientFactory); // cache created stores, avoiding duplicated creation
GraphqlAdmin store1 = clientFactory.getStore(domain1);
```

## Release

Please see release notes:  <https://github.com/YuanWenqing/shopify4j/releases>

# Shopify GraphQL

## QuickStart

~~~java
StoreSetting setting = ...;
GraphqlInvoker invoker = new OkHttpGraphqlInvoker(AccessTokenProvider.constant(setting.getPrivateApp().getAdminApiPassword()));
GraphqlAdmin admin = new DefaultGraphqlAdmin(setting, invoker);

// get a product with: title, handle ...
QueryRootQuery queryRootQuery = Operations.query(
    query -> query.product(id,
        product -> product.title()
            .handle()
            ...));
Product product = admin.query(queryRootQuery).getData().getProduct();
~~~

## GraphqlInvoker

`GraphqlInvoker` is a simple interface to invoke GraphQL http request.

`OkHttpGraphqlInvoker` is the basic implementation based on okhttp3. 

You can customize your implementation on any http library you like.

## Reference

* GraphQL Admin API Documentation: https://shopify.dev/docs/admin-api/graphql/reference
* GraphQL Storefront API Documentation: https://shopify.dev/docs/storefront-api/reference
* Starter Tutorial: https://www.shopify.com/partners/blog/getting-started-with-graphql
* Codegen: https://github.com/Shopify/graphql_java_gen/
* Find GraphQL schema: https://community.shopify.com/c/Shopify-APIs-SDKs/Admin-API-Graphql-shema-endpoint/m-p/837807
* Useful Documenation: https://2fd.github.io/graphdoc/shopify/

# Admin Rest API

## Quickstart

```java
StoreSetting setting = ...;
RestInvoker invoker = new OkHttpRestInvoker(AccessTokenProvider.constant(setting.getPrivateApp().getAdminApiPassword()));
RestAdmin store = new DefaultRestAdmin(setting, invoker);

// get a product
Product product = store.products.get(pid).object();
```

## APIs

For now, supported apis can be checked in [`RestAdmin`](./rest-admin-api/src/main/java/codemeans/shopify4j/rest/admin/RestAdmin.java)

* `store.collects()`
* `store.collections()`
* `store.customCollections()`
* `store.smartCollections()`
* `store.products()`
* `store.productImages()`
* `store.productVariants()`
* ...

## Pipeline

Sometimes, it's necessary to invoke multiple requests to complete one business operation.

For example, creation of a product with different images in some varaints needs steps below:

1. invoke product creation request
2. set imageId of varaints according to the response of product creation
3. invoke product update request to bind variant and its image

`Pipeline`  is designed to simplify invocation of these requests:

```java
store.products().pipeline(ProductModifyPipeline.create(product));
```

More general, if requests cross multiple apis, do pipeline via store

```java
class StorePipeline implements Pipeline<RestAdmin, Product> {
  public StorePipeline(...) {
    ...
  }
  @Override
  public Class<Product> typeOfR() {
    return Product.class;
  }

  @Override
  public Product runWith(RestAdmin store) throws ShopifyServerException {
    ...
  }
}

store.pipeline(new StorePipeline(...));
```

## RestInvoker

`RestInvoker` is a simple interface to invoke REST http request.

`OkHttpRestInvoker` is the basic implementation based on okhttp3. 

You can customize your implementation on any http library you like.

## (De)serialization

Jackson is the default json serialization library. Since it is not easy to configure root-wrapping for specific classes by Jackson until the future version 3.0, we adopt a convention for model definication: `@JsonRootName` is used as a signal to explicitly indicate whether root-wrapping is enabled.

## Enums

`shopify4j` is a third-party sdk of Shopify, thus it's impossible to track changes of Shopify API exactly in time. For compatibility  and flexiblity, we don't use enums in Shopify model directly. But for convenience, we define almost all of the enums described in Shopify documentation and every enum type implements the interface `ShopifyEnum`. It's very simple to use pre-defined enums when requesting Shopify like this:

~~~java
ProductApi.ListReq listReq = new ProductApi.ListReq()
  .setStatus(ProductStatus.active.shopifyValue())
  .setPublishedStatus(PublishedStatus.any.shopifyValue());
~~~

If you want to cast a string value in response to an enum value, do like this:

~~~java
ProductStatus status = ShopifyEnum.asEnum("active", ProductStatus.class);
~~~

## Reference

* API Documentation: https://shopify.dev/docs/admin-api/rest/reference



