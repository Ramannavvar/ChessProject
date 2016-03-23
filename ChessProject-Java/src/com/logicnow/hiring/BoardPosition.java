package com.logicnow.hiring;

public class BoardPosition {
	private int x;
	private int y;
	
	public BoardPosition(int newX, int newY) {
		x = newX;
		y = newY;
	}
	
	@Override
    public int hashCode() {
        final int prime = 37;
        int result = 1;
        result = prime * result + y;
        result = prime * result + x;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        BoardPosition other = (BoardPosition) obj;
        if (y != other.y || x != other.x) {
            return false;
        }
        
        return true;
    }
}

