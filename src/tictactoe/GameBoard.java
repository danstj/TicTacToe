
package tictactoe;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

/*
    Author Dan St Jean
 */
public class GameBoard extends JFrame implements ActionListener{
    private final int m_nFRAME_WIDTH;
    private final int m_nFRAME_HEIGHT;
    private final int m_nBUTTON_SIZE;
    
    private int m_nButtonXPos;
    private int m_nButtonYPos;
    
    private final int m_nRowIndex;
    private final int m_nColIndex;
    
    private char m_chMarks[][];
    
    JFrame m_jFrame;
    JPanel m_jPanel;
    JButton m_jButtons[][];
    
    Border m_Button_Border;
    Font m_labelFont;
    
    ImageIcon m_imgBlank = new ImageIcon(getClass().getResource("/button_img/BlankButton.png"));
    
    Player m_obPlayerOne;
    Player m_obPlayerTwo;
    GameManager m_obGM;
    
    public GameBoard(Player one, Player two, GameManager gm)
    {
        m_obPlayerOne = one;
        m_obPlayerTwo = two;
        m_obGM = gm;
        
        m_nFRAME_WIDTH = 615;
        m_nFRAME_HEIGHT = 639;
        m_nBUTTON_SIZE = 200;
        
        m_nButtonXPos = 0;
        m_nButtonYPos = 0;
        
        m_nRowIndex = 3;
        m_nColIndex = 3;
        
        m_chMarks = new char[m_nRowIndex][m_nColIndex];
        
        m_jFrame = new JFrame();
        m_jPanel = new JPanel();
        m_jButtons = new JButton[m_nRowIndex][m_nColIndex];
        
        m_Button_Border = BorderFactory.createLineBorder(Color.BLACK, 2);
        m_labelFont = new Font("Monoscaped", Font.BOLD, 80);
    }
    
    public void createBoard()
    {
        m_jFrame.setVisible(true);
        m_jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        m_jFrame.setSize(m_nFRAME_WIDTH, m_nFRAME_HEIGHT);
        
        m_jFrame.add(m_jPanel);
        m_jPanel.setBackground(Color.GRAY);
        m_jPanel.setLayout(null);
        
        for(int row = 0; row < m_nRowIndex; row++)
        {
            for(int col = 0; col < m_nColIndex; col++)
            {
                m_jButtons[row][col] = new JButton();
                
                m_jPanel.add(m_jButtons[row][col]);
                m_jButtons[row][col].setIcon(m_imgBlank);
                m_jButtons[row][col].addActionListener(this);
                
                m_jButtons[row][col].setSize(m_nBUTTON_SIZE, m_nBUTTON_SIZE);
                m_jButtons[row][col].setLocation(m_nButtonXPos, m_nButtonYPos);
                
                m_nButtonXPos += m_nBUTTON_SIZE;
            }
            m_nButtonYPos += m_nBUTTON_SIZE;
            m_nButtonXPos = 0;
        }
    }

    private void setMark(int row, int col, char playerMark)
    {
        m_chMarks[row][col] = playerMark;
    }
    
    public char[][] getMarks()
    {
        return m_chMarks;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        Object source = evt.getSource();
        
        if(source == m_jButtons[0][0])
        {
            makeMark(0, 0);
        }
        if(source == m_jButtons[0][1])
        {
            makeMark(0, 1);
        }
        if(source == m_jButtons[0][2])
        {
            makeMark(0, 2);
        }
        if(source == m_jButtons[1][0])
        {
            makeMark(1, 0);
        }
        if(source == m_jButtons[1][1])
        {
            makeMark(1, 1);
        }
        if(source == m_jButtons[1][2])
        {
            makeMark(1, 2);
        }
        if(source == m_jButtons[2][0])
        {
            makeMark(2, 0);
        }
        if(source == m_jButtons[2][1])
        {
            makeMark(2, 1);
        }
        if(source == m_jButtons[2][2])
        {
            makeMark(2,2);
        }
    }
    
    private void makeMark(int row, int col)
    {
        if(m_obGM.getPlayerOneTurn())
        {
            setMark(row, col, 'X');
            m_jButtons[row][col].setIcon(m_obPlayerOne.getMark());
            m_jButtons[row][col].removeActionListener(this);
            m_obGM.setPlayerOneTurn(false);
            
        }
        else
        {
            setMark(row, col, 'O');
            m_jButtons[row][col].setIcon(m_obPlayerTwo.getMark());
            m_jButtons[row][col].removeActionListener(this);
            m_obGM.setPlayerOneTurn(true);
        }
        m_obGM.checkForWinner(row, col);
    }
    
    public void gameReset()
    {
        m_obGM.setPlayerOneTurn(true);
        for(int row = 0; row < m_nRowIndex; row++)
        {
            for(int col = 0; col < m_nColIndex; col++)
            {
                m_jButtons[row][col].removeActionListener(this);
                m_jButtons[row][col].setIcon(m_imgBlank);
                m_jButtons[row][col].addActionListener(this);
                setMark(row, col, ' ');
            }
        }
    }
}
