package com.logicnow.hiring;

public class Pawn implements IPiece {

    private ChessBoard chessBoard;
    private int xCoordinate;
    private int yCoordinate;
    private PieceColor pieceColor;

    public Pawn(PieceColor pieceColor) {
        this.pieceColor = pieceColor;
    }

    public ChessBoard getChesssBoard() {
        return chessBoard;
    }

    public void setChessBoard(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public void setXCoordinate(int value) {
        this.xCoordinate = value;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public void setYCoordinate(int value) {
        this.yCoordinate = value;
    }

    @Override
    public PieceColor getPieceColor() {
        return this.pieceColor;
    }

    private void setPieceColor(PieceColor value) {
        pieceColor = value;
    }

    public void Move(MovementType movementType, int newX, int newY) {
    	if(movementType.equals(MovementType.MOVE)) {
    		if(isLegalMove(newX, newY)) {
    			this.xCoordinate = newX;
    			this.yCoordinate = newY;
    			chessBoard.setPieceAtBoardPosition(newX, newY, this);
    		}
    	} 
    	if(movementType.equals(MovementType.CAPTURE)) {
    		if(isLegalCapture(newX, newY)) {
    			this.xCoordinate = newX;
    			this.yCoordinate = newY;
    			chessBoard.setPieceAtBoardPosition(newX, newY, this);
    		}
    	}        
    }

    @Override
    public String toString() {
        return CurrentPositionAsString();
    }

    protected String CurrentPositionAsString() {
        String eol = System.lineSeparator();
        return String.format("Current X: {1}{0}Current Y: {2}{0}Piece Color: {3}", eol, xCoordinate, yCoordinate, pieceColor);
    }	
    
    private boolean isLegalMove(int newX, int newY) {
    	if (chessBoard.isBoardPositionFree(newX, newY)) {
    		if (yCoordinate == newY) {
    			if (pieceColor == PieceColor.BLACK) {
					if (xCoordinate == 6 && (newX == xCoordinate - 1 || newX == xCoordinate - 2)){
						return true;    		
			    	}
					if (newX == xCoordinate - 1) {
						return true;
					}
    			}
    			if (pieceColor == PieceColor.WHITE) {
					if (xCoordinate == 1 && (newX == yCoordinate + 1 && newX == yCoordinate + 2)) {
						return true;
					}
					if (newX == xCoordinate + 1) {
						return true;
					}
    			}
    		} 
    		return false;
    	}
    	return false;
    }
    
    private boolean isLegalCapture(int newX, int newY) {
		IPiece piece = chessBoard.getPieceAtBoardPostion(newX, newY);
		if (piece != null) {
			if (pieceColor == PieceColor.BLACK) {
				if (newY == (yCoordinate - 1)) {
					if (piece.getPieceColor() != pieceColor) {
						return true;
					}
					//return false;
				}			
			}
			
			if (pieceColor == PieceColor.WHITE) {
				if (newY == (yCoordinate + 1)) {
					if (piece.getPieceColor() != pieceColor) {
						return true;
					}
					//return false;
				}
			}
		}
		return false;
	}
}

