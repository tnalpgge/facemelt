facemelt
========

Java and Spring experiment with pretty pathnames.

Originally written to prove that a Java/Spring web app can be used to
provide customer-friendly URLs for individual sites.  Also a first few
tentative steps into the world of such development, which quickly
resulted in slight regret...but a small price to pay to SHOW THEM ALL
that such a thing can, in fact, be done...and that someone who is an
abject novice at Java and Spring can do it by finding the right bits
in the [Spring docs](http://spring.io/docs).

Build: Java 6, Maven 3.

       mvn clean package

Run: Java 6, JBoss AS 7, PostgreSQL JDBC driver.  Data source in
JNDI at `java:jboss/datasources/SpringQuickstartDS`.  May not work
with earlier versions of JBoss.  Probably works with later versions
of Java.

Database setup (PostgreSQL):

	create table member (
		id serial primary key,
		name varchar(64),
		email varchar(64),
		phone varchar(32),
		path varchar(32)
	);

Resulting .war file expects to be installed as ROOT.war.

External web server setup: "htdocs" in this directory maps to the
document root of your local web server.  Concept was proven with
JBoss on `http://localhost:8080/` and Apache on `http://localhost/` e.g.

      http://localhost:8080/grace/

gets some of its style from

     http://localhost/facemelt/grace/style.css

Not even alpha quality.  Stolen from a Maven archetype and tweaked minimally.
