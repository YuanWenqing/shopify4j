package codemeans.shopify4j.admin.rest.api.impl;

import codemeans.shopify4j.admin.rest.api.ProductApi;
import codemeans.shopify4j.admin.rest.api.ProductApi.ProductPipeline;
import codemeans.shopify4j.admin.rest.model.products.Product;
import codemeans.shopify4j.admin.rest.model.products.ProductImage;
import codemeans.shopify4j.admin.rest.model.products.ProductVariant;
import codemeans.shopify4j.core.exception.ShopifyServerException;
import com.google.common.collect.Maps;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: yuanwq
 * @date: 2021-01-14
 */
public abstract class ProductModifyPipeline implements ProductPipeline<Product> {

  /**
   * request for modifying(create/update) {@link Product}
   */
  private final Product modifyReq;
  private final Map<Integer, Integer> variantPositionToImagePosition = new LinkedHashMap<>();

  public ProductModifyPipeline(Product modifyReq) {
    this.modifyReq = modifyReq;
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
    Product modifiedProduct = modifyProduct(modifyReq);
    modifiedProduct = updateVariantImage(api, modifiedProduct);
    return modifiedProduct;
  }

  /**
   * create or update product
   */
  protected abstract Product modifyProduct(Product modifyReq);

  protected Product updateVariantImage(ProductApi api, Product modifiedProduct)
      throws ShopifyServerException {
    if (!variantPositionToImagePosition.isEmpty()
        && modifiedProduct.getImages() != null
        && modifiedProduct.getVariants() != null) {
      Product variantImageReq = buildVariantImageReq(modifiedProduct);
      modifiedProduct = api.updateProduct(variantImageReq);
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
}
