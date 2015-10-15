package edu.up.cs301.pig;

import edu.up.cs301.game.infoMsg.GameState;

/**
 * Created by camachon18 on 10/14/2015.
 */
public class PigGameState extends GameState{

    private int playerID;
    private int player1Score;
    private int player2Score;
    private int currentTotal;
    private int currentDie;
    private PigGameState endOfTurn;

    public PigGameState()
    {
        playerID = 0;
        player1Score = 0;
        player2Score = 0;
        currentDie = 1;
        currentTotal = 0;
    }

    public PigGameState(PigGameState object)
    {

        this.playerID = object.playerID;
        this.player1Score = object.player1Score;
        this.player2Score = object.player2Score;
        this.currentDie = object.currentDie;
        this.currentTotal = object.currentTotal;

    }
    public int getPlayerID(){return  this.playerID;}

    public int getPlayer1Score() {return this.player1Score;}

    public int getPlayer2Score() {return  this. player2Score;}

    public int getCurrentTotal() {return this.currentTotal;}

    public int getCurrentDie() {return this.currentDie;}

    public void adjustStateHold()
    {
        if(this.playerID == 0)
        {
            player1Score = player1Score + currentTotal;
            this.playerID = 1;
            currentTotal = 0;
        }
        else
        {
            player2Score = player2Score + currentTotal;
            this.playerID = 0;
            currentTotal = 0;
        }
    }

    public void adjustStateRoll()
    {
        currentDie =(int) (Math.random()*6 + 1);
        if (currentDie == 1)
        {
            if(this.playerID == 0)
            {
                currentTotal = 0;
                this.playerID = 1;
            }
            else
            {
                currentTotal = 0;
                this.playerID = 0;
            }
        }
        else
        {
                currentTotal = currentTotal + currentDie;
        }


    }
}
