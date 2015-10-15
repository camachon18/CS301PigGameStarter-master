package edu.up.cs301.pig;

import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.LocalGame;
import edu.up.cs301.game.actionMsg.GameAction;
import android.util.Log;

/**
 * class PigLocalGame controls the play of the game
 *
 * @author Andrew M. Nuxoll
 * @version August 2015
 */
public class PigLocalGame extends LocalGame {


    PigGameState state;
    /**
     * This ctor creates a new game state
     */
    public PigLocalGame() {
        //TODO  You will implement this constructor
        state = new PigGameState();
    }

    /**
     * can the player with the given id take an action right now?
     */
    @Override
    public boolean canMove(int playerIdx) {
        //TODO  You will implement this method
        if (playerIdx == state.getPlayerID())
        {
            return true;
        }
        return false;
    }

    /**
     * This method is called when a new action arrives from a player
     *
     * @return true if the action was taken or false if the action was invalid/illegal.
     */
    @Override
    public boolean makeMove(GameAction action) {
        //TODO  You will implement this method
        if (canMove(getPlayerIdx(action.getPlayer())))
        {
            if (action instanceof PigHoldAction)
            {
                state.adjustStateHold();
                return true;
            }
            else
            {
                state.adjustStateRoll();
                return true;
            }
        }
        return false;

    }//makeMove

    /**
     * send the updated state to a given player
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        //TODO  You will implement this method
        PigGameState copyState = new PigGameState(state);
        p.sendInfo(copyState);


    }//sendUpdatedSate

    /**
     * Check if the game is over
     *
     * @return
     * 		a message that tells who has won the game, or null if the
     * 		game is not over
     */
    @Override
    public String checkIfGameOver() {
        //TODO  You will implement this method
        if (state.getPlayer1Score() >= 50)
        {
            return "Player 1 won the game";
        }
        if (state.getPlayer2Score() >= 50)
        {
            return "Player 2 won the game";
        }
        return null;
    }

}// class PigLocalGame
