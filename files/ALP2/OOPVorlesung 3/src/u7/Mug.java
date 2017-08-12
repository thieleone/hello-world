package u7;

public class Mug <T extends Liquid>{
	private static final int hotTemperature=40;
	private int capacity,content;
	T fluessigTyp;
	Mug(int capacity,T fluessigkeit){
		this.capacity=capacity;
		this.fluessigTyp=fluessigkeit;
		this.content=0;
	}
	Mug(T fluessigkeit){
		this(200, fluessigkeit);
	}
	public void pour(int ml) throws NotEnoughCapacityException{
		if(ml>capacity)
			throw new NotEnoughCapacityException(this.capacity, ml);
		else
			content=content+ml;
	}
	public void takeOut(int ml) throws NotEnoughLiquidException{
		if(content<ml)
			throw new NotEnoughLiquidException(capacity, content, ml);
		else
			content=content-ml;
	}
	public void drink(int ml) throws UndrinkableException,NotEnoughLiquidException{
		if(fluessigTyp.drinkable==false)
			throw new UndrinkableException(fluessigTyp.getName());
		else{
			if(content<ml)
				throw new NotEnoughLiquidException(capacity, content, ml);
			else
				content=content-ml;
		}
	}
	public int getContent(){
		return content;
	}
	public boolean isEmpty(){
		if(content==0)
			return true;
		else
			return false;
	}
	public boolean isHot(){
		if(fluessigTyp.getTemperature()>hotTemperature)
			return true;
		else
			return false;
	}
	
	
}
