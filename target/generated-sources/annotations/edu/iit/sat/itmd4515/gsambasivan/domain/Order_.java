package edu.iit.sat.itmd4515.gsambasivan.domain;

import edu.iit.sat.itmd4515.gsambasivan.domain.BillDetails;
import edu.iit.sat.itmd4515.gsambasivan.domain.GiftVoucher;
import edu.iit.sat.itmd4515.gsambasivan.domain.OrderDetails;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-30T20:47:29")
@StaticMetamodel(Order.class)
public class Order_ { 

    public static volatile SingularAttribute<Order, BillDetails> billDetails;
    public static volatile ListAttribute<Order, OrderDetails> orderDetails;
    public static volatile SingularAttribute<Order, Double> billAmount;
    public static volatile SingularAttribute<Order, Double> totAmount;
    public static volatile SingularAttribute<Order, Long> id;
    public static volatile SingularAttribute<Order, Double> discAmount;
    public static volatile SingularAttribute<Order, Date> orderDate;
    public static volatile SingularAttribute<Order, String> paymentType;
    public static volatile SingularAttribute<Order, GiftVoucher> giftVoucher;

}