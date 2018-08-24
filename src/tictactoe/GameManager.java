
package tictactoe;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/*
    Author Dan St Jean
 */
public class GameManager {
    private boolean isPlayerOneTurn;
    private int m_nTieCounter;
    
    ImageIcon m_imgP1Mark = new ImageIcon(getClass().getResource("/button_img/XButton.png"));
    ImageIcon m_imgP2Mark = new ImageIcon(getClass().getResource("/button_img/OButton.png"));
    
    StartMenu obStartMenu;
    Player obPlayerOne;
    Player obPlayerTwo;
    
    ScoreBoard obScoreBoard;
    GameBoard obGameBoard;
    
    public GameManager()
    {
        isPlayerOneTurn = true;
        m_nTieCounter = 0;
        
        obStartMenu = new StartMenu(this);
        obPlayerOne = new Player(m_imgP1Mark);
        obPlayerTwo = new Player(m_imgP2Mark);
        
        obScoreBoard = new ScoreBoard(obPlayerOne, obPlayerTwo);
        obGameBoard = new GameBoard(obPlayerOne, obPlayerTwo, this);
    }
    
    public void start()
    {
        obStartMenu.createFrame();
    }
    
    public void playerNameEntry()
    {
        String playerOneName = JOptionPane.showInputDialog(null, "Player One Enter Your Name");
        obPlayerOne.setName(playerOneName);
        
        String playerTwoName = JOptionPane.showInputDialog(null, "Player Two Enter Your Name");
        obPlayerTwo.setName(playerTwoName);
        
        init();
    }
    
    public void init()
    {
        obGameBoard.createBoard();
        obScoreBoard.createScoreBoard();
    }
    
    public void setPlayerOneTurn(boolean playerOneTurn)
    {
        isPlayerOneTurn = playerOneTurn;
    }
    
    public boolean getPlayerOneTurn()
    {
        return isPlayerOneTurn;
    }
    
    public void checkForWinner(int row, int col)
    {
        boolean isWinner = false;
        
        if((obGameBoard.getMarks()[row][0] == 'X' &&
                obGameBoard.getMarks()[row][1] == 'X' &&
                obGameBoard.getMarks()[row][2] == 'X') ||
                (obGameBoard.getMarks()[0][col] == 'X' &&
                obGameBoard.getMarks()[1][col] == 'X' &&
                obGameBoard.getMarks()[2][col] == 'X'))
        {
            JOptionPane.showMessageDialog(obGameBoard, obPlayerOne.getName() + " Wins");
            obPlayerOne.incrementWins();
            obPlayerTwo.incrementLosses();
            isWinner = true;
        }
        
        if((obGameBoard.getMarks()[0][0] == 'X' &&
                obGameBoard.getMarks()[1][1] == 'X' &&
                obGameBoard.getMarks()[2][2] == 'X') ||
                (obGameBoard.getMarks()[0][2] == 'X' &&
                obGameBoard.getMarks()[1][1] == 'X' &&
                obGameBoard.getMarks()[2][0] == 'X'))
        {
            JOptionPane.showMessageDialog(obGameBoard, obPlayerOne.getName() + " Wins");
            obPlayerOne.incrementWins();
            obPlayerTwo.incrementLosses();
            isWinner = true;
        }
        
        if((obGameBoard.getMarks()[row][0] == 'O' &&
                obGameBoard.getMarks()[row][1] == 'O' &&
                obGameBoard.getMarks()[row][2] == 'O') ||
                (obGameBoard.getMarks()[0][col] == 'O' &&
                obGameBoard.getMarks()[1][col] == 'O' &&
                obGameBoard.getMarks()[2][col] == 'O'))
        {
            JOptionPane.showMessageDialog(obGameBoard, obPlayerTwo.getName() + " Wins");
            obPlayerTwo.incrementWins();
            obPlayerOne.incrementLosses();
            isWinner = true;
        }

        if((obGameBoard.getMarks()[0][0] == 'O' &&
                obGameBoard.getMarks()[1][1] == 'O' &&
                obGameBoard.getMarks()[2][2] == 'O') ||
                (obGameBoard.getMarks()[0][2] == 'O' &&
                obGameBoard.getMarks()[1][1] == 'O' &&
                obGameBoard.getMarks()[2][0] == 'O'))
        {
            JOptionPane.showMessageDialog(obGameBoard, obPlayerOne.getName() + " Wins");
            obPlayerTwo.incrementWins();
            obPlayerOne.incrementLosses();
            isWinner = true;
        }
        
        m_nTieCounter++;
        
        if(!isWinner && m_nTieCounter == 9)
        {
            JOptionPane.showMessageDialog(obGameBoard, "Tie Game!");
            obPlayerOne.incrementTies();
            obPlayerTwo.incrementTies();
            obGameBoard.gameReset();
            m_nTieCounter = 0;
            obScoreBoard.updateScore();
        }
        
        if(isWinner)
        {
            obGameBoard.gameReset();
            m_nTieCounter = 0;
            obScoreBoard.updateScore();
        }
    }
}
