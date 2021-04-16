*** CHINTALY WHSE ***


Bootstrap v3.3.5 (http://getbootstrap.com)


POM.XML
-- VARIABLES
<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
<java.version>1.8</java.version>
<jboss_logging.version>3.4.0.Final</jboss_logging.version>
<slf4j_log4j.version>1.6.4</slf4j_log4j.version>
<slf4j_api.version>1.6.4</slf4j_api.version>
<jsf_api.version>2.2.18</jsf_api.version>
<jsf_impl.version>2.2.18</jsf_impl.version>
<javax_servlet_api.version>4.0.1</javax_servlet_api.version>

-- DEPENDENCIES VERSION
			<groupId>org.hibernate</groupId>
			<artifactId>hibernate-core</artifactId>
			<!-- <version>5.4.3.Final</version> -->
			<version>4.3.10.Final</version>

			<groupId>org.hibernate</groupId>
			<artifactId>hibernate-validator</artifactId>
			<!-- <version>6.0.17.Final</version> -->
			<version>6.0.12.Final</version>

			<groupId>org.hibernate</groupId>
		    <!-- <artifactId>hibernate-annotations</artifactId> -->
			<!-- <version>3.5.6-Final</version> -->
			<artifactId>hibernate-commons-annotations</artifactId>
			<!-- <version>5.1.0.Final</version> -->
			<version>3.2.0.Final</version>

			<groupId>org.hibernate</groupId>
			<artifactId>hibernate-entitymanager</artifactId>
			<!-- <version>5.4.3.Final</version> -->
			<version>4.3.10.Final</version>

			<groupId>org.hibernate.javax.persistence</groupId>
            <!-- <artifactId>hibernate-jpa-2.1-api</artifactId> -->
			<!-- <version>1.0.2.Final</version> -->
			<artifactId>hibernate-jpa-2.0-api</artifactId>
			<version>1.0.1.Final</version>

/*                                            ,IN piDimension VARCHAR(15)
                                            ,IN piWeight VARCHAR(15)
                                            ,IN piFreight VARCHAR(25))
*/




-- STRUCTURES
item
item_part
item_structure
item_structure_detail

1
NADINE-SC
* NOT ASSEMBLED
* GRAY
* BLK
	SEAT
	BACK
	FRAME
	HARDWARE
	- GLIDE
2
MOLLY-SC
* ASSEMBLED
* GRY
* BLK
* WHT
* WHT POLISH
* GRY POLISH
	- SEAT
	- BACK
	- FRAME
	- SCREW
	- GLIDE
	- SPRING
	- HINGE
	- KNOB
	- BOLT
	- METAL CONNECTION

3 LUNA-SC
* NOT ASSEMBLED
* GRY
	SEAT
	BACK
	FRAME LEFT
	FRAME RIGHT
	FRAME CONNECTION
	HARDWARE
	SCREW COVER
	- GLIDE
	
4 TAMI
* ASSEMBLED
	- GLIDE	


-- FOLDERS
+ chintaly_whse
	|
	+ packingslip
	|	|
	|	+ 201901
	|		|
	|		+ 01
	|		+ 02
	|		+ 03
	|		+ ...
	|
	+ return
		|
		+ 201901
			|
			+ 01
			+ 02
			+ 03
			+ ...
	
	
	

