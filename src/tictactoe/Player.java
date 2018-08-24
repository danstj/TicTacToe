
package tictactoe;

import javax.swing.ImageIcon;

/*
    Author Dan St Jean
 */
public class Player {
    private String m_strName;
    ImageIcon playerMark;
    
    private int m_nWins;
    private int m_nLosses;
    private int m_nTies;
    
    public Player(ImageIcon mark)
    {
        m_strName = getName();
        this.playerMark = mark;
        
        m_nWins = 0;
        m_nLosses = 0;
        m_nTies = 0;
    }
    
    public void setName(String name) { this.m_strName = name; }
    
    public String getName() { return m_strName; }
    public ImageIcon getMark() { return playerMark; }
    
    public String getWins() 
    {
        String strWins = Integer.toString(m_nWins);
        return strWins; 
    }
    public String getLosses() 
    {
        String strLosses = Integer.toString(m_nLosses);
        return strLosses; 
    }
    public String getTies() 
    {
        String strTies = Integer.toString(m_nTies);
        return strTies; 
    }
    
    public void incrementWins() { m_nWins++; }
    public void incrementLosses() { m_nLosses++; }
    public void incrementTies() { m_nTies++; }
}
