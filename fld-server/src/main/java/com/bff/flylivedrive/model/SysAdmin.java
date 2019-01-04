package com.bff.flylivedrive.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@DiscriminatorValue("SYSTEM_ADMIN")
public class SysAdmin extends User {
	
}
