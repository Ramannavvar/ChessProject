package com.logicnow.hiring;

public interface IPiece {
	public PieceColor getPieceColor();
	public void Move(MovementType movementType, int newX, int newY);
}
