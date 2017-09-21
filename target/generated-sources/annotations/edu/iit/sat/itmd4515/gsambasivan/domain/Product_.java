package edu.iit.sat.itmd4515.gsambasivan.domain;

import edu.iit.sat.itmd4515.gsambasivan.domain.UnitMeasurement;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-30T20:47:29")
@StaticMetamodel(Product.class)
public class Product_ { 

    public static volatile SingularAttribute<Product, Long> productId;
    public static volatile SingularAttribute<Product, UnitMeasurement> unitMeasurement;
    public static volatile SingularAttribute<Product, Integer> qty;
    public static volatile SingularAttribute<Product, String> productName;

}