package edu.iit.sat.itmd4515.gsambasivan.domain;

import edu.iit.sat.itmd4515.gsambasivan.domain.Product;
import edu.iit.sat.itmd4515.gsambasivan.domain.SubCategory;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-30T20:47:29")
@StaticMetamodel(ProductCategory.class)
public class ProductCategory_ { 

    public static volatile ListAttribute<ProductCategory, SubCategory> subCategory;
    public static volatile ListAttribute<ProductCategory, Product> product;
    public static volatile SingularAttribute<ProductCategory, String> description;
    public static volatile SingularAttribute<ProductCategory, String> categoryName;
    public static volatile SingularAttribute<ProductCategory, Long> categoryId;

}