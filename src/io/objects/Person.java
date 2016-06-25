package io.objects;

public class Person
	implements java.io.Serializable
{

	private static final long serialVersionUID = 7972850077635520583L;
	private String name;
	private int age;

	public Person(String name , int age){
		this.name = name;
		this.age = age;
	}
	// 省略name与age的setter和getter方法

	// name的setter和getter方法
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return this.name;
	}

	// age的setter和getter方法
	public void setAge(int age)
	{
		this.age = age;
	}
	public int getAge()
	{
		return this.age;
	}
}