package com.webroothackathon.app.problem1;

public class IntPair
{
  public IntPair(int first, int second)
  {
    this.first = first;
    this.second = second;
  }

  @Override
    public boolean equals(Object obj)
    {
      if (obj == null)
        return false;

      if (!IntPair.class.isInstance(obj))
        return false;

      IntPair other = (IntPair) obj;

      return this.first == other.first && this.second == other.second;
    }

  @Override
    public int hashCode()
    {
      return (this.first * 17) + (this.second * 53);
    }

  @Override
    public String toString()
    {
      return "(" + this.first + "," + this.second + ")";
    }

  public int first;
  public int second;
}
