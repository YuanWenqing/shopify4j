# Shopify4j

Java SDK for Shopify APIs, including:

* REST Admin API Models
* REST Admin API
* GraphQL Admin Schema
* GraphQL Admin API
* ...

## Usage

gradle

REST API
```groovy
implementation("xyz.codemeans.shopify4j:rest-admin-api:1.0")
```
GraphQL API
```groovy
implementation("xyz.codemeans.shopify4j:graphql-admin-api:1.0")
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

## Release

Please see release notes:  <https://github.com/YuanWenqing/shopify4j/releases>

## Reference

https://shopify.dev/docs/admin-api/rest/reference

# Admin Rest API

## Quickstart

```java
StoreSetting setting = new StoreSetting();
Invoker invoker = new OkHttpInvoker(AccessTokenProvider.constant(setting.getApiPassword()));
RestStore store = new DefaultRestStore(setting, invoker);

// get a product
Product = store.products.get(pid).object();
...
```

## APIs

For now, supported apis can be checked in [`RestStore`](./rest-admin-api/src/main/java/codemeans/shopify4j/rest/admin/RestStore.java)

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
class StorePipeline implements Pipeline<RestStore, Product> {
  public StorePipeline(...) {
    ...
  }
  @Override
  public Class<Product> typeOfR() {
    return Product.class;
  }

  @Override
  public Product runWith(RestStore store) throws ShopifyServerException {
    ...
  }
}

store.pipeline(new StorePipeline(...));
```

## Invoker

Invoker is a simple interface to invoke http request.

`OkHttpInvoker` is the basic implementation based on okhttp3. 

You can customize your implementation on any http library you like.

## RestStoreFactory

If you are integrating with multiple shopify stores in one sysmtem, just like we do, `RestStoreFactory` will be very helpful. 

```java
MemoryStoreSettingStorage settingStorage = new MemoryStoreSettingStorage();
settingStorage.registerStore(store1);
settingStorage.registerStore(store2);

Invoker invoker = new OkHttpInvoker(new PrivateAppAccessTokenProvider(settingStorage));

StoreFactory<RestStore> storeFactory = new DefaultRestStoreFactory(settingStorage, invoker);
// cache created stores, avoiding duplicated creation
storeFactory = CachedStoreFactory.of(storeFactory);

Product productFromStore1 = storeFactory.getStore(domain1).products().get(pid1).object();
Product productFromStore2 = storeFactory.getStore(domain2).products().get(pid2).object();
```

If information of your stores is saved in some persistent database, you can just implement another `StoreSettingStorage` to retrieve data and build out a `StoreSetting`.

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



# Shopify GraphQL

Starter Tutorial: https://www.shopify.com/partners/blog/getting-started-with-graphql

Find admin graphql schema: https://community.shopify.com/c/Shopify-APIs-SDKs/Admin-API-Graphql-shema-endpoint/m-p/837807

Codegen: https://github.com/Shopify/graphql_java_gen/

Useful Documenation: https://2fd.github.io/graphdoc/shopify/

