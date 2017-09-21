package edu.iit.sat.itmd4515.gsambasivan.domain;

import edu.iit.sat.itmd4515.gsambasivan.domain.security.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-30T20:47:29")
@StaticMetamodel(Admins.class)
public class Admins_ { 

    public static volatile SingularAttribute<Admins, String> firstName;
    public static volatile SingularAttribute<Admins, String> lastName;
    public static volatile SingularAttribute<Admins, String> gender;
    public static volatile SingularAttribute<Admins, String> storeLocation;
    public static volatile SingularAttribute<Admins, Long> personId;
    public static volatile SingularAttribute<Admins, String> middleName;
    public static volatile SingularAttribute<Admins, String> designation;
    public static volatile SingularAttribute<Admins, User> user;
    public static volatile SingularAttribute<Admins, String> email;

}