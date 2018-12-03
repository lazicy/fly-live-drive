package com.bff.flylivedrive.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@DiscriminatorValue("SYS")
public class SysAdmin extends User {
	
}
