package edu.iit.sat.itmd4515.gsambasivan.domain;

import edu.iit.sat.itmd4515.gsambasivan.domain.Product;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-30T20:47:29")
@StaticMetamodel(SubCategory.class)
public class SubCategory_ { 

    public static volatile ListAttribute<SubCategory, Product> product;
    public static volatile SingularAttribute<SubCategory, String> description;
    public static volatile SingularAttribute<SubCategory, String> categoryName;
    public static volatile SingularAttribute<SubCategory, Long> categoryId;

}