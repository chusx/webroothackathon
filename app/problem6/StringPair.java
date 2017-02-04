package com.webroothackathon.app.problem6;

public class StringPair
{
	public StringPair( String first, String second)
	{
		this.first = first;
		this.second = second;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj == null)
			return false;

		if (!StringPair.class.isInstance(obj))
			return false;

		StringPair other = (StringPair) obj;

		return this.first.equals(other.first) && this.second.equals(other.second);
	}
	
	@Override
	public int hashCode()
	{
		return this.first.hashCode() + this.second.hashCode();
	}

	@Override
	public String toString()
	{
		return "(" + this.first + "," + this.second + ")";
	}


	public String first;
	public String second;
}
