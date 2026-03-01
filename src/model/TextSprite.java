package model;

public class TextSprite {
// Properties
	int sourceX1;
	int sourceY1;
	int sourceX2;
	int sourceY2;

// Constructor
	public TextSprite(int sourceX1, int sourceY1, int sourceX2, int sourceY2){
		this.sourceX1 = sourceX1;
		this.sourceY1 = sourceY1;
		this.sourceX2 = sourceX2;
		this.sourceY2 = sourceY2;
	}

// Getters
	public int getsourceX1(){
		return this.sourceX1;
	}

	public int getsourceY1(){
		return this.sourceY1;
	}

	public int getsourceX2(){
		return this.sourceX2;
	}

	public int getsourceY2(){
		return this.sourceY2;
	}
}
