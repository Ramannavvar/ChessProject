package com.logicnow.hiring;

import java.util.HashMap;
import java.util.Map;

/*
 *      =========================================
 *    7 |    |    |    |    |    |    |    |    |
 *      =========================================
 *    6 |    |    |    |    |    |    |    |    |
 *      =========================================
 *    5 |    |    |    |    |    |    |    |    |
 *  ^   =========================================
 *  | 4 |    |    |    |    |    |    |    |    |
 *  X   =========================================
 *    3 |    |    |    |    |    |    |    |    |
 *      =========================================
 *    2 |    |    |    |    |    |    |    |    |
 *      =========================================
 *    1 |    |    |    |    |    |    |    |    |
 *      =========================================
 *    0 |    |    |    |    |    |    |    |    |
 *      =========================================
 *   	   0	1	 2	  3	   4	5    6    7    
 *   					y -> 
 */
public class ChessBoard {

    public static int MAX_BOARD_WIDTH = 8;
    public static int MAX_BOARD_HEIGHT = 8;

    // Changed the pieces type from Pawn 2D array to map to hold all the different pieces on the board. 
    // Map are easier to work with and give much better performance 
    private static Map<BoardPosition, IPiece> pieces;

    public ChessBoard() {        
        pieces = new HashMap<>();
    }

    public void Add(Pawn pawn, int xCoordinate, int yCoordinate, PieceColor pieceColor) {    	
    	if (IsLegalBoardPosition(xCoordinate, yCoordinate) &&
    			(pieces.get(new BoardPosition(xCoordinate,yCoordinate)) == null)) {	    	
	    	pawn.setChessBoard(this);
    		if ((pieceColor.equals(PieceColor.BLACK) && (xCoordinate == 6)) ||
    				pieceColor.equals(PieceColor.WHITE) && (xCoordinate == 1)){     			
        		pawn.setXCoordinate(xCoordinate);
        		pawn.setYCoordinate(yCoordinate);
        		pieces.put(new BoardPosition(xCoordinate, yCoordinate), pawn);
        		
    		} else {
    			pawn.setXCoordinate(-1);
        		pawn.setYCoordinate(-1);
    		}
	    }    	
    }

    public boolean IsLegalBoardPosition(int xCoordinate, int yCoordinate) {
       	if ((xCoordinate >= 0 && xCoordinate <= MAX_BOARD_WIDTH) && 
       			(yCoordinate >= 0 && yCoordinate <= MAX_BOARD_HEIGHT)) {
    		return true;
    	}       	
    	return false;
    }
    
    public boolean isBoardPositionFree(int x, int y) {
    	if (pieces.get(new BoardPosition(x, y)) != null) {
    		return false;
    	}
    	return true;
    }
    
    public IPiece getPieceAtBoardPostion(int x, int y) {
    	return pieces.get(new BoardPosition(x, y));
    }
    
    public void setPieceAtBoardPosition(int x, int y, IPiece newPiece) {
    	IPiece oldPiece = pieces.get(new BoardPosition(x, y));
    	if (oldPiece != null) {
    		if (newPiece.getPieceColor() != oldPiece.getPieceColor()) {
    			pieces.put(new BoardPosition(x, y), newPiece);
    		} else {
    			// @TODO Throw a custom exception 
    		}    		
    	} else {
    		pieces.put(new BoardPosition(x, y), newPiece);
    	}
    }
}
