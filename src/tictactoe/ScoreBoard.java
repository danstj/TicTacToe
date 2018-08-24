
package tictactoe;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/*
    Author Dan St Jean
 */
public class ScoreBoard {
    private final int m_nFRAME_WIDTH;
    private final int m_nFRAME_HEIGHT;
    private final int m_nFRAME_X_POS;
    private final int m_nFRAME_Y_POS;
    
    private final int m_nLABEL_WIDTH;
    private final int m_nLABEL_HEIGHT;
    private int m_nLabelXPos;
    private int m_nLabelYPos;
    
    private final String m_strNAME;
    private final String m_strWINS;
    private final String m_strLOSSES;
    private final String m_strTIES;
    
    JFrame m_jFrame;
    JPanel m_jPanel;
    
    JLabel m_arrLabels[][];
    
    Border m_labelBorder;
    Font m_labelFont;
    
    Player m_obPlayerOne;
    Player m_obPlayerTwo;
    
    public ScoreBoard(Player one, Player two)
    {
        m_obPlayerOne = one;
        m_obPlayerTwo = two;
        
        m_nFRAME_WIDTH = 470;
        m_nFRAME_HEIGHT = 192;
        m_nFRAME_X_POS = 0;
        m_nFRAME_Y_POS = 0;
        
        m_nLABEL_WIDTH = 100;
        m_nLABEL_HEIGHT = 50;
        m_nLabelXPos = 2;
        m_nLabelYPos = 2;
        
        m_strNAME = "Name";
        m_strWINS = "Wins";
        m_strLOSSES = "Losses";
        m_strTIES = "Ties";
        
        m_jFrame = new JFrame("Score Board");
        m_jPanel = new JPanel();
        
        m_labelBorder = BorderFactory.createLineBorder(Color.BLACK, 2);
        m_labelFont = new Font("Monoscaped", Font.BOLD, 24);
        
        m_arrLabels = new JLabel[3][4];
    }
    
    public void createScoreBoard()
    {
        m_jFrame.setVisible(true);
        m_jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        m_jFrame.setSize(m_nFRAME_WIDTH, m_nFRAME_HEIGHT);
        m_jFrame.setLocation(m_nFRAME_X_POS, m_nFRAME_Y_POS);
        
        m_jFrame.add(m_jPanel);
        m_jPanel.setLayout(null);
        m_jPanel.setBackground(Color.GRAY);
        m_jPanel.setBorder(m_labelBorder);
        
        for(int row = 0; row < m_arrLabels.length; row++)
        {
            for(int col = 0; col < m_arrLabels[row].length; col++)
            {
                m_arrLabels[row][col] = new JLabel();
                m_jPanel.add(m_arrLabels[row][col]);
                m_arrLabels[row][col].setLocation(m_nLabelXPos, m_nLabelYPos);
                m_arrLabels[row][col].setBorder(m_labelBorder);
                m_arrLabels[row][col].setFont(m_labelFont);
                m_arrLabels[row][col].setVerticalAlignment(JLabel.BOTTOM);
                if(col == 0)
                {
                   m_arrLabels[row][col].setSize(m_nLABEL_WIDTH + 50, m_nLABEL_HEIGHT);
                   m_nLabelXPos += 150; 
                }
                else
                {
                    m_arrLabels[row][col].setSize(m_nLABEL_WIDTH, m_nLABEL_HEIGHT);
                    m_arrLabels[row][col].setHorizontalAlignment(JLabel.CENTER);
                    m_nLabelXPos += 100;
                    
                }
            }
            m_nLabelYPos += 50;
            m_nLabelXPos = 2;
        }
        
        m_arrLabels[0][0].setText(m_strNAME);
        m_arrLabels[0][1].setText(m_strWINS);
        m_arrLabels[0][2].setText(m_strLOSSES);
        m_arrLabels[0][3].setText(m_strTIES);
        
        m_arrLabels[1][0].setText(m_obPlayerOne.getName());
        m_arrLabels[2][0].setText(m_obPlayerTwo.getName());
        
        updateScore();
    }
    
    public void updateScore()
    {
        m_arrLabels[1][1].setText(m_obPlayerOne.getWins());
        m_arrLabels[2][1].setText(m_obPlayerTwo.getWins());
        
        m_arrLabels[1][2].setText(m_obPlayerOne.getLosses());
        m_arrLabels[2][2].setText(m_obPlayerTwo.getLosses());
        
        m_arrLabels[1][3].setText(m_obPlayerOne.getTies());
        m_arrLabels[2][3].setText(m_obPlayerTwo.getTies());
    }

}
