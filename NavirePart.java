

public class NavirePart implements CaseCord {
	private Boolean estDetruit;
	private int x;
	private int y;
	private int value;
	
	public NavirePart(int x, int y, int value){
		estDetruit(false);
		setCoords(x, y);
	}
	public Boolean estDetruit()         {return estDetruit;}
	public void estDetruit(Boolean b)   {estDetruit = b;   }
	public void setCoords(int x, int y)	{setX(x);setY(y);  }
	public int getX()                   {return x;         }
	public void setX(int x)             {this.x = x;       }
	public int getY()                  {return y;         }
	public void setY(int y)            {this.y = y;       }
	public int getValue(int x, int y) {return this.getValue(x, y);}
	public void setValue(int value)      {this.value = value;       }
	public int getValue()                  {return this.value;         }
	
}
