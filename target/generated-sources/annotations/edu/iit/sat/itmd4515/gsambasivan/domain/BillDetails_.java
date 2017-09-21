package edu.iit.sat.itmd4515.gsambasivan.domain;

import edu.iit.sat.itmd4515.gsambasivan.domain.Order;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-30T20:47:29")
@StaticMetamodel(BillDetails.class)
public class BillDetails_ { 

    public static volatile SingularAttribute<BillDetails, Date> bilDate;
    public static volatile SingularAttribute<BillDetails, Double> amount;
    public static volatile SingularAttribute<BillDetails, Order> customer_order;
    public static volatile SingularAttribute<BillDetails, String> bankName;
    public static volatile SingularAttribute<BillDetails, Long> id;
    public static volatile SingularAttribute<BillDetails, String> cardNumber;

}