package com.unifun.voice.orm;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="test_table")

@NamedQuery(name="testtable.getAll",query="select t from TestTable t")
public class TestTable {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
int id;
String text;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getText() {
	return text;
}
public void setText(String text) {
	this.text = text;
}


}
