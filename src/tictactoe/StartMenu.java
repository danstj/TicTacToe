
package tictactoe;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
    author Dan St Jean
 */
public class StartMenu implements ActionListener{
    private final int m_nFrameWidth;
    private final int m_nFrameHeight;
    
    private final int m_nButtonWidth;
    private final int m_nButtonHeight;
    private final int m_nButtonXPos;
    private final int m_nButtonYPos;
    
    private final String m_strTic;
    private final String m_strTac;
    private final String m_strToe;
    private final String m_strPlay;
    private final String m_strQuit;
    
    JFrame m_jFrame;
    JPanel m_jPanel;
    
    JButton m_jbPlay;
    JButton m_jbQuit;

    JLabel m_jlTic;
    JLabel m_jlTac;
    JLabel m_jlToe;
    JLabel m_jlPlay;
    JLabel m_jlQuit;
    
    Font m_titleFont;
    Font m_buttonFont;
    
    GameManager obGM;
    
    // Constructor
    public StartMenu(GameManager GM)
    {
        obGM = GM;
        
        m_nFrameWidth = 300;
        m_nFrameHeight = 400;
        
        m_nButtonWidth = 150;
        m_nButtonHeight = 50;
        m_nButtonXPos = (m_nFrameWidth / 2) - (m_nButtonWidth / 2);
        m_nButtonYPos = 225;
        
        m_strTic = "TIC";
        m_strTac = "TAC";
        m_strToe = "TOE";
        m_strPlay = "PLAY";
        m_strQuit = "QUIT";
        
        m_jFrame = new JFrame();
        m_jPanel = new JPanel();
        
        m_jbPlay = new JButton();
        m_jbQuit = new JButton();

        m_jlTic = new JLabel();
        m_jlTac = new JLabel();
        m_jlToe = new JLabel();
        m_jlPlay = new JLabel();
        m_jlQuit = new JLabel();
        
        m_titleFont = new Font("Monospaced", Font.BOLD, 50);
        m_buttonFont = new Font("Monoscaped", Font.BOLD, 24);
    }
    
    // Creates the GUI for the start menu
    public void createFrame()
    {
        m_jFrame.setVisible(true);
        m_jFrame.setSize(m_nFrameWidth, m_nFrameHeight);
        m_jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        m_jFrame.add(m_jPanel);
        m_jPanel.setLayout(null);
        m_jPanel.setBackground(Color.GRAY);

        // Adding the Tic label
        m_jPanel.add(m_jlTic);
        m_jlTic.setSize(100, 50);
        m_jlTic.setText(m_strTic);
        m_jlTic.setFont(m_titleFont);
        m_jlTic.setLocation(15, 15);
        
        // Adding the Tac label
        m_jPanel.add(m_jlTac);
        m_jlTac.setSize(100, 50);
        m_jlTac.setText(m_strTac);
        m_jlTac.setFont(m_titleFont);
        m_jlTac.setLocation(75, 75);
        
        // Adding the Toe label
        m_jPanel.add(m_jlToe);
        m_jlToe.setSize(100, 50);
        m_jlToe.setText(m_strToe);
        m_jlToe.setFont(m_titleFont);
        m_jlToe.setLocation(135, 135);
        
        // Adding the Play button and it's label
        m_jPanel.add(m_jbPlay);
        m_jbPlay.setSize(m_nButtonWidth, m_nButtonHeight);
        m_jbPlay.setBackground(Color.LIGHT_GRAY);
        m_jbPlay.setLocation(m_nButtonXPos, m_nButtonYPos);
        m_jbPlay.addActionListener(this);
        m_jbPlay.add(m_jlPlay);
        m_jlPlay.setText(m_strPlay);
        m_jlPlay.setSize(m_nButtonWidth, m_nButtonHeight);
        m_jlPlay.setFont(m_buttonFont);
        
        // Adding the Quit button and it's label
        m_jPanel.add(m_jbQuit);
        m_jbQuit.setSize(m_nButtonWidth, m_nButtonHeight);
        m_jbQuit.setBackground(Color.LIGHT_GRAY);
        m_jbQuit.setLocation(m_nButtonXPos, m_nButtonYPos + 60);
        m_jbQuit.addActionListener(this);
        m_jbQuit.add(m_jlQuit);
        m_jlQuit.setText(m_strQuit);
        m_jlQuit.setSize(m_nButtonWidth, m_nButtonHeight);
        m_jlQuit.setFont(m_buttonFont);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        Object source = evt.getSource();
        
        if(source == m_jbPlay)
        {
            obGM.playerNameEntry();
        }
        
        if(source == m_jbQuit)
        {
            System.exit(0);
        }
    }
}
