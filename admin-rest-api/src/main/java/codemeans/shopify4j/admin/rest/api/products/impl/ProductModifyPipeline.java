package codemeans.shopify4j.admin.rest.api.products.impl;

import codemeans.shopify4j.admin.rest.api.products.ProductApi;
import codemeans.shopify4j.admin.rest.api.products.ProductApi.ProductPipeline;
import codemeans.shopify4j.admin.rest.model.products.Product;
import codemeans.shopify4j.admin.rest.model.products.ProductImage;
import codemeans.shopify4j.admin.rest.model.products.ProductVariant;
import codemeans.shopify4j.core.exception.ShopifyServerException;
import com.google.common.collect.Maps;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * modify product: create or update
 *
 * @author: yuanwq
 * @date: 2021-01-14
 */
public abstract class ProductModifyPipeline implements ProductPipeline<Product> {

  /**
   * request for modifying(create/update) {@link Product}
   */
  private final Product modifyReq;
  /**
   * mapping from variant's position to image's position
   */
  private final Map<Integer, Integer> variantPositionToImagePosition = new LinkedHashMap<>();

  public ProductModifyPipeline(Product modifyReq) {
    this.modifyReq = modifyReq;
  }

  public Product getModifyReq() {
    return modifyReq;
  }

  public Map<Integer, Integer> getVariantPositionToImagePosition() {
    return Collections.unmodifiableMap(variantPositionToImagePosition);
  }

  public ProductModifyPipeline setVariantImage(int variantPosition, int imagePosition) {
    this.variantPositionToImagePosition.put(variantPosition, imagePosition);
    return this;
  }

  @Override
  public Class<Product> typeOfR() {
    return Product.class;
  }

  @Override
  public Product runWith(ProductApi api) throws ShopifyServerException {
    Product modifiedProduct = modifyProduct(api, modifyReq);
    modifiedProduct = updateVariantImage(api, modifiedProduct);
    return modifiedProduct;
  }

  /**
   * create or update product
   */
  protected abstract Product modifyProduct(ProductApi api,
      Product modifyReq) throws ShopifyServerException;

  protected Product updateVariantImage(ProductApi api, Product modifiedProduct)
      throws ShopifyServerException {
    if (!variantPositionToImagePosition.isEmpty()
        && modifiedProduct.getImages() != null
        && modifiedProduct.getVariants() != null) {
      Product variantImageReq = buildVariantImageReq(modifiedProduct);
      modifiedProduct = api.update(variantImageReq);
    }
    return modifiedProduct;
  }

  /**
   * build request for updating images of variants
   *
   * @param modifiedProduct response after modifying {@link Product}
   */
  private Product buildVariantImageReq(Product modifiedProduct) {
    Product variantImageReq = new Product()
        .setId(modifiedProduct.getId());
    Map<Integer, ProductImage> positionToImage = Maps
        .uniqueIndex(modifiedProduct.getImages(), ProductImage::getPosition);
    for (ProductVariant variant : modifiedProduct.getVariants()) {
      ProductVariant variantWithImage = new ProductVariant()
          .setId(variant.getId())
          .setProductId(variant.getProductId());
      Integer imagePosition = variantPositionToImagePosition.get(variant.getPosition());
      ProductImage image = positionToImage.get(imagePosition);
      if (image != null) {
        variantWithImage.setImageId(image.getId());
      }
      variantImageReq.addVariant(variantWithImage);
    }
    return variantImageReq;
  }

  public static Creation create(Product product) {
    return new Creation(product);
  }

  public static Update update(Product product) {
    return new Update(product);
  }

  public static class Creation extends ProductModifyPipeline {

    public Creation(Product modifyReq) {
      super(modifyReq);
    }

    @Override
    protected Product modifyProduct(ProductApi api, Product modifyReq)
        throws ShopifyServerException {
      return api.create(modifyReq);
    }
  }

  public static class Update extends ProductModifyPipeline {

    public Update(Product modifyReq) {
      super(modifyReq);
    }

    @Override
    protected Product modifyProduct(ProductApi api, Product modifyReq)
        throws ShopifyServerException {
      return api.update(modifyReq);
    }
  }
}