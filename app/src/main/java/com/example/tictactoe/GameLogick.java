package com.example.tictactoe;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameLogick {

    private int[][] gameBoard;

    private String [] playerNames = {"Player 1", "Player 2"};

    private int[] typeWin = {-1, -1, -1};

    private int player = 1;

    private Button playAgainButton;
    private Button homeBTN;
    private TextView playerTurn;


    GameLogick(){
        gameBoard = new int[3][3];
        for (int r=0; r<3; r++){
            for (int c=0; c<3; c++){
                gameBoard[r][c] = 0;
            }
        }
    }


    public boolean updateGameBoard(int row, int col){
        if (gameBoard[row - 1] [col - 1] == 0){
            gameBoard[row - 1] [col - 1] = player;

            if (player == 1){
                playerTurn.setText((playerNames[1] + " - ваш ход"));
            } else {
                playerTurn.setText((playerNames[0] + " - ваш ход"));
            }

            return true;
        } else {
            return false;
        }
    }

    public boolean winnerCheck(){
        boolean isWinner = false;

        //Горизонт!!!!!!
        for(int r = 0; r < 3; r++){
            if (gameBoard[r][0] == gameBoard[r][1] && gameBoard[r][0] == gameBoard[r][2] &&
                    gameBoard[r][0] != 0){
                typeWin = new int[] {r, 0, 1};
                isWinner = true;
            }
        }
        //Вертикаль
        for(int c = 0; c < 3; c++) {
            if (gameBoard[0][c] == gameBoard[1][c] && gameBoard[0][c] == gameBoard[2][c] &&
                    gameBoard[0][c] != 0) {
                typeWin = new int[] {0, c, 2};
                isWinner = true;
            }
        }
        // Наискосок негатив :)
        if (gameBoard[0][0] == gameBoard[1][1] && gameBoard[0][0] == gameBoard[2][2] &&
                gameBoard[0][0] != 0){
            typeWin = new int[] {0, 2, 3};
            isWinner = true;
        }
        // Наискосок позитив ^^
        if (gameBoard[2][0] == gameBoard[1][1] && gameBoard[2][0] == gameBoard[0][2] &&
                gameBoard[2][0] != 0){
            typeWin = new int[] {2, 2, 4};
            isWinner = true;
        }

        int boardFilled = 0;

        for(int r=0;r<3;r++){
            for(int d=0; d<3; d++){
                if(gameBoard[r][d] != 0){
                    boardFilled+=1;
                }
            }
        }

        if (isWinner){
            playAgainButton.setVisibility(View.VISIBLE);
            homeBTN.setVisibility(View.VISIBLE);
            playerTurn.setText((playerNames[player-1] + "- Победитель!!"));
            return true;
        } else if (boardFilled == 9){
            playAgainButton.setVisibility(View.VISIBLE);
            homeBTN.setVisibility(View.VISIBLE);
            playerTurn.setText("Ничья!");
            return true;
        }
        else{
            return false;
        }
    }





    public void resetGame(){
        for (int r=0; r<3; r++){
            for (int c=0; c<3; c++){
                gameBoard[r][c] = 0;
            }
        }


        player = 1;
        playAgainButton.setVisibility(View.GONE);
        homeBTN.setVisibility(View.GONE);
        typeWin = new int [] {-1, -1, -1};
        playerTurn.setText((playerNames[0] + " - ваш ход"));
    }

    public void setPlayerNames(String[] playerNames) {
        this.playerNames = playerNames;
    }

    public void setPlayAgainButton(Button playAgainButton) {
        this.playAgainButton = playAgainButton;
    }

    public void setHomeBTN(Button homeBTN) {
        this.homeBTN = homeBTN;
    }

    public void setPlayerTurn(TextView playerTurn) {
        this.playerTurn = playerTurn;
    }

    public int[][] getGameBoard() {
        return gameBoard;
    }

    public void setPlayer(int player) {
        this.player = player;
    }

    public int getPlayer() {
        return player;
    }

    public int[] getTypeWin() {
        return typeWin;
    }
}
