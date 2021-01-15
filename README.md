# shopify4j

Java SDK for Shopify APIs, including:

* Admin REST API
* ...

## Usage

gradle

```groovy
implementation("xyz.codemeans.shopify4j:admin-rest-api:1.0")
// okhttp invoker
implementation("xyz.codemeans.shopify4j:shopify4j-okhttp:1.0")
```

## Build from source

Requirements:

* JDK 8
* gradle >= 5.6

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

	gradle publish -Prelease -Ppub=nexus

## Release

Please see release notes:  <https://github.com/YuanWenqing/shopify4j/releases>

## Reference

https://shopify.dev/docs/admin-api/rest/reference

# Admin Rest API

## Quickstart

```java
StoreSetting setting = new StoreSetting();
Invoker invoker = new OkHttpInvoker(
      AccessTokenProvider.constant(setting.getApiPassword()));
ShopifyStore store = new DefaultShopifyStore(setting, invoker);

// get a product
Product = store.products.get(pid);
...
```

## APIs

For now, supported apis:

* `store.collects()`
* `store.collections()`
* `store.customCollections()`
* `store.smartCollections()`
* `store.products()`
* `store.productImages()`
* `store.productVariants()`

## Pipeline

In some cases, multiple requests will be invoked to complete one business operation.

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
class StorePipeline implements Pipeline<ShopifyStore, Product> {
  public StorePipeline(...) {
    ...
  }
  @Override
  public Class<Product> typeOfR() {
    return Product.class;
  }

  @Override
  public Product runWith(ShopifyStore store) throws ShopifyServerException {
    ...
  }
}

store.pipeline(new StorePipeline(...));
```

## Invoker

Invoker is a simple interface to invoke http request.

`OkHttpInvoker` in `shopify4j-okhttp` is the basic implementation based on okhttp3. 

You can customize your implementation on any http library you like.

## ShopifyStoreFactory

If you are integrating with multiple shopify stores in one sysmtem, just like we do, `ShopifyStoreFactory` will be very helpful. 

```java
MemoryStoreSettingStorage settingStorage = new MemoryStoreSettingStorage();
settingStorage.registerStore(store1);
settingStorage.registerStore(store2);

Invoker invoker = new OkHttpInvoker(new PrivateAppAccessTokenProvider(settingStorage));

ShopifyStoreFactory storeFactory = new DefaultShopifyStoreFactory(settingStorage, invoker);
// cache created stores, avoiding duplicated creation
storeFactory = CachedShopifyStoreFactory.of(storeFactory);

Product productFromStore1 = storeFactory.getStore(domain1).products().get(pid1);
Product productFromStore2 = storeFactory.getStore(domain2).products().get(pid2);
```

If information of your stores is saved in some persistent database, you can just implement another `StoreSettingStorage` to retrieve data and build out a `StoreSetting`.

