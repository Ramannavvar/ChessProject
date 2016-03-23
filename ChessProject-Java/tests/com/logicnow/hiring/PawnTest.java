package com.logicnow.hiring;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PawnTest {

    private ChessBoard chessBoard;
    private Pawn testSubject;

    @Before
    public void setUp() {
        this.chessBoard = new ChessBoard();
        this.testSubject = new Pawn(PieceColor.BLACK);
    }

    @Test
    public void testChessBoard_Add_Sets_XCoordinate() {
        this.chessBoard.Add(testSubject, 6, 3, PieceColor.BLACK);
        assertEquals(6, testSubject.getXCoordinate());
    }

    @Test
    public void testChessBoard_Add_Sets_YCoordinate() {
        this.chessBoard.Add(testSubject, 6, 3, PieceColor.BLACK);
        assertEquals(3, testSubject.getYCoordinate());
    }


    @Test
    public void testPawn_Move_IllegalCoordinates_Right_DoesNotMove() {
        chessBoard.Add(testSubject, 6, 3, PieceColor.BLACK);
        testSubject.Move(MovementType.MOVE, 7, 3);
        assertEquals(6, testSubject.getXCoordinate());
        assertEquals(3, testSubject.getYCoordinate());
    }

    /* Had to change the assert values here - slight confusion with the layout of the board.
     * The previous values were entered considering x as horizontal axis and y as vertical axis
     * The rest of the test cases and coding is done considering: 
            =========================================
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
    @Test
    public void testPawn_Move_IllegalCoordinates_Left_DoesNotMove() {
        chessBoard.Add(testSubject, 6, 3, PieceColor.BLACK);
        testSubject.Move(MovementType.MOVE, 6, 4);
        assertEquals(6, testSubject.getXCoordinate());
        assertEquals(3, testSubject.getYCoordinate());
    }

    /*
     * Had to change the values of the assert here, please see comment for
     * testPawn_Move_IllegalCoordinates_Left_DoesNotMove()
     */
    @Test
    public void testPawn_Move_LegalCoordinates_Forward_UpdatesCoordinates() {
        chessBoard.Add(testSubject, 6, 3, PieceColor.BLACK);
        testSubject.Move(MovementType.MOVE, 5, 3);
        assertEquals(5, testSubject.getXCoordinate());
        assertEquals(3, testSubject.getYCoordinate());
    }
    
    @Test
    public void testIsLegalCapture_TRUE() {
    	Pawn testSubject2 = new Pawn(PieceColor.WHITE);
    	chessBoard.Add(testSubject, 6, 2, PieceColor.BLACK);
    	chessBoard.Add(testSubject2, 1, 1, PieceColor.WHITE);
    	testSubject.Move(MovementType.MOVE, 4, 2);
    	testSubject2.Move(MovementType.MOVE, 3, 1);
    	testSubject2.Move(MovementType.CAPTURE, 4, 2);
    	assertEquals(4, testSubject2.getXCoordinate());
    	assertEquals(2, testSubject2.getYCoordinate());
    }
    
    @Test
    public void testIsLegalCapture_FALSE_DOESNOTMOVE() {
    	Pawn testSubject2 = new Pawn(PieceColor.BLACK);
    	chessBoard.Add(testSubject, 6, 2, PieceColor.BLACK);
    	chessBoard.Add(testSubject2, 6, 3, PieceColor.BLACK);
    	testSubject.Move(MovementType.MOVE, 4, 2);
    	testSubject2.Move(MovementType.MOVE, 5, 3);
    	testSubject2.Move(MovementType.CAPTURE, 4, 2);
    	assertEquals(5, testSubject2.getXCoordinate());
    	assertEquals(3, testSubject2.getYCoordinate());
    }
}