import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements Runnable, ActionListener{

  // Class Variables 
  //need the frame here so we can update it 
  JFrame frame;

  //These are all the different panels which will be used for the program
  JPanel instructionsPanel;
  JPanel easyPanel;
  JPanel easyL1; 
  JPanel easyL2;
  JPanel easyL3; 
  JPanel easyL4; 
  JPanel easyL5; 
  JPanel mediumPanel;
  JPanel mediumL1;
  JPanel mediumL2;
  JPanel mediumL3;
  JPanel mediumL4;
  JPanel mediumL5;
  JPanel hardPanel;
  JPanel hardL1; 
  JPanel hardL2;
  JPanel hardL3; 
  JPanel hardL4; 
  JPanel hardL5; 

  //these are the different answerAreas that will be used throughout the code
  JTextField answerAreaE1;
  JTextField answerAreaE2;
  JTextField answerAreaE3;
  JTextField answerAreaE4;
  JTextField answerAreaE5;
  JTextField answerAreaM1;
  JTextField answerAreaM2;
  JTextField answerAreaM3;
  JTextField answerAreaM4;
  JTextField answerAreaM5;
  JTextField answerAreaH1;
  JTextField answerAreaH2;
  JTextField answerAreaH3;
  JTextField answerAreaH4;
  JTextField answerAreaH5;

  //these are the different integers that will be used in the code
  int testEasyL2 = 0;
  int testEasyL3 = 0;
  int testEasyL4 = 0;
  int testEasyL5 = 0;
  int testMediumL2 = 0;
  int testMediumL3 = 0;
  int testMediumL4 = 0;
  int testMediumL5 = 0;
  int testHardL2 = 0;
  int testHardL3 = 0;
  int testHardL4 = 0;
  int testHardL5 = 0;

  //these are the different word ladders in the code
  JLabel questionEL1;
  JLabel questionEL2;
  JLabel questionEL3;
  JLabel questionEL4;
  JLabel questionEL5;
  JLabel questionML1;
  JLabel questionML2;
  JLabel questionML3;
  JLabel questionML4;
  JLabel questionML5;
  JLabel questionHL1;
  JLabel questionHL2;
  JLabel questionHL3;
  JLabel questionHL4;
  JLabel questionHL5;

  //these will be all of the feedback areas in each of the levals
  JLabel feedbackEL1;
  JLabel feedbackEL2;
  JLabel feedbackEL3;
  JLabel feedbackEL4;
  JLabel feedbackEL5;
  JLabel feedbackML1;
  JLabel feedbackML2;
  JLabel feedbackML3;
  JLabel feedbackML4;
  JLabel feedbackML5;
  JLabel feedbackHL1;
  JLabel feedbackHL2;
  JLabel feedbackHL3;
  JLabel feedbackHL4;
  JLabel feedbackHL5;

  //these string arrays are created to have the answers put inside of them
  String [] easyL2Answers = new String[2];
  String [] easyL3Answers = new String[3];
  String [] easyL4Answers = new String[4];
  String [] easyL5Answers = new String[5];
  String [] mediumL2Answers = new String[2];
  String [] mediumL3Answers = new String[3];
  String [] mediumL4Answers = new String[4];
  String [] mediumL5Answers = new String[5];
  String [] hardL2Answers = new String[2];
  String [] hardL3Answers = new String[3];
  String [] hardL4Answers = new String[4];
  String [] hardL5Answers = new String[5];

  //this will create a back button when a level is complete
  JButton completeEL1;
  JButton completeEL2;
  JButton completeEL3;
  JButton completeEL4;
  JButton completeEL5;
  JButton completeML1;
  JButton completeML2;
  JButton completeML3;
  JButton completeML4;
  JButton completeML5;
  JButton completeHL1;
  JButton completeHL2;
  JButton completeHL3;
  JButton completeHL4;
  JButton completeHL5;

  //cardLayout is used to keep track of different screens
  CardLayout screenLayout;
  JPanel screens;

  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);
    
    //set up to create the title screen
    JPanel titlePanel = new JPanel();
    //gives the programer full control of the panel
    titlePanel.setLayout(null);
   
    //this will be used in the code to create different title fonts and text fonts
    Font biggerFont = new Font("arial", Font.BOLD, 60);
    Font textFont = new Font("arial", Font.PLAIN, 20);
    Font wordLadderFont = new Font("arial", Font.PLAIN, 35);

    //this changes the font of the title in the titlePanel
    JLabel titleLabel = new JLabel("Word Ladder!");
    titleLabel.setFont(biggerFont);

    //this will add the title to the titlePanel and manipulate the title to the top of the panel
    titleLabel.setBounds(160,50,600,80);
    titlePanel.add(titleLabel);
    
    //this creates an instructions button and adds it to the title panel
    JButton instructions = new JButton("Instructions");
    titlePanel.add(instructions);
    instructions.setBounds(300, 150, 125, 30);

    //this sets the 
    instructions.setActionCommand("instructions");
    instructions.addActionListener(this);

    //this creates the instructions panel and sets the layout to null
    instructionsPanel = new JPanel();
    instructionsPanel.setLayout(null);

    //this will create, set the font, and add a title to the instructions panel
    JLabel instructionsTitle = new JLabel("INSTRUCTIONS");
    instructionsTitle.setFont(biggerFont);
    instructionsTitle.setBounds(160, 50, 600, 80);
    instructionsPanel.add(instructionsTitle);

    //this will create the instructions the game. They will be JLabels
    JLabel howPlay1 = new JLabel("- You will get a starting word and an ending word");
    JLabel howPlay2 = new JLabel("- The starting, ending, and every word in-between must be the same in length");
    JLabel howPlay3 = new JLabel("- You will change one letter at a time, trying to move from the starting word");
    JLabel howtoPlay3 = new JLabel("to the ending word");
    JLabel howPlay4 = new JLabel("- Each transitional step must be a valid word. This also means that no proper");
    JLabel howToPlay4 = new JLabel("nouns are allowed");

    //the fonts of all of the instructions were then set to textFont
    howPlay1.setFont(textFont);
    howPlay2.setFont(textFont);
    howPlay3.setFont(textFont);
    howtoPlay3.setFont(textFont);
    howPlay4.setFont(textFont);
    howToPlay4.setFont(textFont);

    //the instructions were then added to the instruction panel
    instructionsPanel.add(howPlay1);
    instructionsPanel.add(howPlay2);
    instructionsPanel.add(howPlay3);
    instructionsPanel.add(howtoPlay3);
    instructionsPanel.add(howPlay4);
    instructionsPanel.add(howToPlay4);

    //the instructions were then manipulated to different parts of the instruction panel
    howPlay1.setBounds(10, 100, 550, 100);
    howPlay2.setBounds(10, 150, 800, 100);
    howPlay3.setBounds(10, 200, 800, 100);
    howtoPlay3.setBounds(10, 225, 800, 100);
    howPlay4.setBounds(10, 275, 800, 100);
    howToPlay4.setBounds(10, 300, 800, 100);
    
    //this will create a button to go back to the title screen from the instruction panel
    JButton backButtonInstructions = new JButton("Back");
    instructionsPanel.add(backButtonInstructions);
    backButtonInstructions.setBounds(350, 425, 75, 50);
    backButtonInstructions.setActionCommand("backButtonInstructions");
    backButtonInstructions.addActionListener(this);

    //this will create a easy panel and set the layout for the panel
    easyPanel = new JPanel();
    easyPanel.setLayout(null);

    //this will create a button that the user can press to got to the easy panel. This button will be added to the title panel
    JButton easy = new JButton("Easy");
    titlePanel.add(easy);
    easy.setBounds(300, 200, 125, 30);
    easy.setActionCommand("easy");
    easy.addActionListener(this);

    //this will add a title to the easy panel
    JLabel easyTitle = new JLabel("Easy");
    easyTitle.setFont(biggerFont);
    easyPanel.add(easyTitle);
    easyTitle.setBounds(310, 40, 600, 80);

    //this will create 5 different panels for the easy levels
    easyL1 = new JPanel();
    easyL2 = new JPanel();
    easyL3 = new JPanel();
    easyL4 = new JPanel();
    easyL5 = new JPanel();

    //this will set the layout for all 5 of the levels
    easyL1.setLayout(null);
    easyL2.setLayout(null);
    easyL3.setLayout(null);
    easyL4.setLayout(null);
    easyL5.setLayout(null);

    //this will create 5 answer areas that will later be added to each of the panels
    answerAreaE1 = new JTextField("");
    answerAreaE2 = new JTextField("");
    answerAreaE3 = new JTextField("");
    answerAreaE4 = new JTextField("");
    answerAreaE5 = new JTextField("");

    //this will add the answerAreas to the easy levels
    easyL1.add(answerAreaE1);
    easyL2.add(answerAreaE2);
    easyL3.add(answerAreaE3);
    easyL4.add(answerAreaE4);
    easyL5.add(answerAreaE5);

    //this will manipulate each of the answerAreas to different parts of the panels
    answerAreaE1.setBounds(250, 400, 150, 30);
    answerAreaE2.setBounds(250, 400, 150, 30);
    answerAreaE3.setBounds(250, 400, 150, 30);
    answerAreaE4.setBounds(250, 400, 150, 30);
    answerAreaE5.setBounds(250, 400, 150, 30);

    //this will add a submit button where the user can test if there guess was correct
    JButton submitE1 = new JButton("Submit");
    JButton submitE2 = new JButton("Submit");
    JButton submitE3 = new JButton("Submit");
    JButton submitE4 = new JButton("Submit");
    JButton submitE5 = new JButton("Submit");

    //this will add the submit buttons to the panels
    easyL1.add(submitE1);
    easyL2.add(submitE2);
    easyL3.add(submitE3);
    easyL4.add(submitE4);
    easyL5.add(submitE5);

    //this will manipulate each of the buttons to different parts of each panel
    submitE1.setBounds(425, 400, 100, 30);
    submitE2.setBounds(425, 400, 100, 30);
    submitE3.setBounds(425, 400, 100, 30);
    submitE4.setBounds(425, 400, 100, 30);
    submitE5.setBounds(425, 400, 100, 30);

    //this will set an action command to these buttons
    submitE1.setActionCommand("submitE1");
    submitE2.setActionCommand("submitE2");
    submitE3.setActionCommand("submitE3");
    submitE4.setActionCommand("submitE4");
    submitE5.setActionCommand("submitE5");

    //this will add an action listener to these butttons
    submitE1.addActionListener(this);
    submitE2.addActionListener(this);
    submitE3.addActionListener(this);
    submitE4.addActionListener(this);
    submitE5.addActionListener(this);

    //this will create 5 different buttons to acess the 5 panels made above
    JButton easyLevel1 = new JButton("Level 1");
    JButton easyLevel2 = new JButton("Level 2");
    JButton easyLevel3 = new JButton("Level 3");
    JButton easyLevel4 = new JButton("Level 4");
    JButton easyLevel5 = new JButton("Level 5");

    //this will add the 5 buttons made above to the easy panel
    easyPanel.add(easyLevel1);
    easyPanel.add(easyLevel2);
    easyPanel.add(easyLevel3);
    easyPanel.add(easyLevel4);
    easyPanel.add(easyLevel5);

    //this manipulates the buttons to different parts of the scren
    easyLevel1.setBounds(320, 150, 125, 30);
    easyLevel2.setBounds(320, 200, 125, 30);
    easyLevel3.setBounds(320, 250, 125, 30);
    easyLevel4.setBounds(320, 300, 125, 30); 
    easyLevel5.setBounds(320, 350, 125, 30);

    //this will set the action command for each of the "easy" buttons
    easyLevel1.setActionCommand("easyLevel1");
    easyLevel2.setActionCommand("easyLevel2");
    easyLevel3.setActionCommand("easyLevel3");
    easyLevel4.setActionCommand("easyLevel4");
    easyLevel5.setActionCommand("easyLevel5");

    //this will add an action listener to each of the buttons
    easyLevel1.addActionListener(this);
    easyLevel2.addActionListener(this);
    easyLevel3.addActionListener(this);
    easyLevel4.addActionListener(this);
    easyLevel5.addActionListener(this);

    //this wil create JLabels that will show the word ladder to the user
    questionEL1 = new JLabel("cup ... cat");
    questionEL2 = new JLabel("rug ... ... bat");
    questionEL3 = new JLabel("cap ... ... ... him");
    questionEL4 = new JLabel("map ... ... ... ... dog");
    questionEL5 = new JLabel("pig ... ... ... ... ... sow");

    //this will set the font of the word ladders
    questionEL1.setFont(wordLadderFont);
    questionEL2.setFont(wordLadderFont);
    questionEL3.setFont(wordLadderFont);
    questionEL4.setFont(wordLadderFont);
    questionEL5.setFont(wordLadderFont);

    //this will add the word ladder to the respected panel
    easyL1.add(questionEL1);
    easyL2.add(questionEL2);
    easyL3.add(questionEL3);
    easyL4.add(questionEL4);
    easyL5.add(questionEL5);

    //this will manipulate the word ladders to different parts of their respected panels
    questionEL1.setBounds(275, 125, 800, 60);
    questionEL2.setBounds(250, 125, 800, 60);
    questionEL3.setBounds(225, 125, 800, 60);
    questionEL4.setBounds(175, 125, 800, 60);
    questionEL5.setBounds(200, 125, 800, 60);

    //this will create a feedback area for each level
    feedbackEL1 = new JLabel("Take your guess below");
    feedbackEL2 = new JLabel("Take your guess below");
    feedbackEL3 = new JLabel("Take your guess below");
    feedbackEL4 = new JLabel("Take your guess below");
    feedbackEL5 = new JLabel("Take your guess below");

    //this will add the feedback area to each level
    easyL1.add(feedbackEL1);
    easyL2.add(feedbackEL2);
    easyL3.add(feedbackEL3);
    easyL4.add(feedbackEL4);
    easyL5.add(feedbackEL5);

    //this will manipulate the feedback areas to different parts of their respected panels
    feedbackEL1.setBounds(300, 350, 800, 30);
    feedbackEL2.setBounds(300, 350, 800, 30);
    feedbackEL3.setBounds(300, 350, 800, 30);
    feedbackEL4.setBounds(300, 350, 800, 30);
    feedbackEL5.setBounds(300, 350, 800, 30);

    //this will create a button that will allow the user to go back
    completeEL1 = new JButton("Next");
    completeEL2 = new JButton("Next");
    completeEL3 = new JButton("Next");
    completeEL4 = new JButton("Next");
    completeEL5 = new JButton("Next");

    //this will add the button to the respected 
    easyL1.add(completeEL1);
    easyL2.add(completeEL2);
    easyL3.add(completeEL3);
    easyL4.add(completeEL4);
    easyL5.add(completeEL5);

    //this will manipulate the button to replected parts
    completeEL1.setBounds(340, 450, 100, 30);
    completeEL2.setBounds(340, 450, 100, 30);
    completeEL3.setBounds(340, 450, 100, 30);
    completeEL4.setBounds(340, 450, 100, 30);
    completeEL5.setBounds(340, 450, 100, 30);

    //this will set the action command to the button
    completeEL1.setActionCommand("completeEL1");
    completeEL2.setActionCommand("completeEL2");
    completeEL3.setActionCommand("completeEL3");
    completeEL4.setActionCommand("completeEL4");
    completeEL5.setActionCommand("completeEL5");
 
    //this will add the action listener to each button
    completeEL1.addActionListener(this);
    completeEL2.addActionListener(this);
    completeEL3.addActionListener(this);
    completeEL4.addActionListener(this);
    completeEL5.addActionListener(this);

    //this will make the buttons invisible
    completeEL1.setVisible(false);
    completeEL2.setVisible(false);
    completeEL3.setVisible(false);
    completeEL4.setVisible(false);
    completeEL5.setVisible(false);
    
    //this will create a button where the user can go back to the title screen from the easy panel. The action listener and command will be added and the button will be manipulated
    JButton backButtonEasy = new JButton("Back");
    easyPanel.add(backButtonEasy);
    backButtonEasy.setBounds(320, 400, 125, 30);
    backButtonEasy.setActionCommand("backButtonEasy");
    backButtonEasy.addActionListener(this);

    //this will create a panel where the medium levels will be placed. The layout will be set to null
    mediumPanel = new JPanel();
    mediumPanel.setLayout(null);

    //this will create a button where the medium panel may be accessed
    JButton medium = new JButton("Medium");
    titlePanel.add(medium);
    medium.setBounds(300, 250, 125, 30);
    medium.setActionCommand("medium");
    medium.addActionListener(this);

    //this will create a title for the medium panel
    JLabel mediumTitle = new JLabel("Medium");
    mediumTitle.setFont(biggerFont);
    mediumPanel.add(mediumTitle);
    mediumTitle.setBounds(260, 40, 600, 80);
    
    //this will create 5 different panels for the medium levels
    mediumL1 = new JPanel();
    mediumL2 = new JPanel();
    mediumL3 = new JPanel();
    mediumL4 = new JPanel();
    mediumL5 = new JPanel();

    //this will set the layout for all 5 of the levels
    mediumL1.setLayout(null);
    mediumL2.setLayout(null);
    mediumL3.setLayout(null);
    mediumL4.setLayout(null);
    mediumL5.setLayout(null);

    //this will create 5 answer areas that will later be added to each of the panels
    answerAreaM1 = new JTextField("");
    answerAreaM2 = new JTextField("");
    answerAreaM3 = new JTextField("");
    answerAreaM4 = new JTextField("");
    answerAreaM5 = new JTextField("");

    //this will add the answerAreas to the medium levels
    mediumL1.add(answerAreaM1);
    mediumL2.add(answerAreaM2);
    mediumL3.add(answerAreaM3);
    mediumL4.add(answerAreaM4);
    mediumL5.add(answerAreaM5);

    //this will manipulate the answerAreas to different parts of the panels
    answerAreaM1.setBounds(250, 400, 150, 30);
    answerAreaM2.setBounds(250, 400, 150, 30);
    answerAreaM3.setBounds(250, 400, 150, 30);
    answerAreaM4.setBounds(250, 400, 150, 30);
    answerAreaM5.setBounds(250, 400, 150, 30);

    //this will add a submit button where the user can test if there guess was correct
    JButton submitM1 = new JButton("Submit");
    JButton submitM2 = new JButton("Submit");
    JButton submitM3 = new JButton("Submit");
    JButton submitM4 = new JButton("Submit");
    JButton submitM5 = new JButton("Submit");

    //this will add the submit buttons to the panels
    mediumL1.add(submitM1);
    mediumL2.add(submitM2);
    mediumL3.add(submitM3);
    mediumL4.add(submitM4);
    mediumL5.add(submitM5);

    //this will manipulate each of the buttons to different parts of each panel
    submitM1.setBounds(425, 400, 100, 30);
    submitM2.setBounds(425, 400, 100, 30);
    submitM3.setBounds(425, 400, 100, 30);
    submitM4.setBounds(425, 400, 100, 30);
    submitM5.setBounds(425, 400, 100, 30);

    //this will set the action command to each button
    submitM1.setActionCommand("submitM1");
    submitM2.setActionCommand("submitM2");
    submitM3.setActionCommand("submitM3");
    submitM4.setActionCommand("submitM4");
    submitM5.setActionCommand("submitM5");

    //this will add an action listener to each button
    submitM1.addActionListener(this);
    submitM2.addActionListener(this);
    submitM3.addActionListener(this);
    submitM4.addActionListener(this);
    submitM5.addActionListener(this);

    //this will create 5 different buttons where the panels above may be accessed
    JButton mediumLevel1 = new JButton("Level 1");
    JButton mediumLevel2 = new JButton("Level 2");
    JButton mediumLevel3 = new JButton("Level 3");
    JButton mediumLevel4 = new JButton("Level 4");
    JButton mediumLevel5 = new JButton("Level 5");

    //this will add the buttons to the medium panel
    mediumPanel.add(mediumLevel1);
    mediumPanel.add(mediumLevel2);
    mediumPanel.add(mediumLevel3);
    mediumPanel.add(mediumLevel4);
    mediumPanel.add(mediumLevel5);

    //this will manipulate each of the buttons to different parts of the panel
    mediumLevel1.setBounds(320, 150, 125, 30);
    mediumLevel2.setBounds(320, 200, 125, 30);
    mediumLevel3.setBounds(320, 250, 125, 30);
    mediumLevel4.setBounds(320, 300, 125, 30);
    mediumLevel5.setBounds(320, 350, 125, 30);

    //this will set the action command to all of the "medium" butons
    mediumLevel1.setActionCommand("mediumLevel1");
    mediumLevel2.setActionCommand("mediumLevel2");
    mediumLevel3.setActionCommand("mediumLevel3");
    mediumLevel4.setActionCommand("mediumLevel4");
    mediumLevel5.setActionCommand("mediumLevel5");

    //this will add an action listener to each of the buttons
    mediumLevel1.addActionListener(this);
    mediumLevel2.addActionListener(this);
    mediumLevel3.addActionListener(this);
    mediumLevel4.addActionListener(this);
    mediumLevel5.addActionListener(this);

    //this wil create JLabels that will show the word ladder to the user
    questionML1 = new JLabel("fish ... fast");
    questionML2 = new JLabel("fast ... ... coot");
    questionML3 = new JLabel("deer ... ... ... beak");
    questionML4 = new JLabel("sing ... ... ... ... pair");
    questionML5 = new JLabel("most ... ... ... ... ... moot");

    //this will set the font of the word ladders
    questionML1.setFont(wordLadderFont);
    questionML2.setFont(wordLadderFont);
    questionML3.setFont(wordLadderFont);
    questionML4.setFont(wordLadderFont);
    questionML5.setFont(wordLadderFont);

    //this will add the word ladder to the respected panel
    mediumL1.add(questionML1);
    mediumL2.add(questionML2);
    mediumL3.add(questionML3);
    mediumL4.add(questionML4);
    mediumL5.add(questionML5);

    //this will manipulate the word ladders to different parts of their respected panels
    questionML1.setBounds(275, 125, 800, 60);
    questionML2.setBounds(250, 125, 800, 60);
    questionML3.setBounds(210, 125, 800, 60);
    questionML4.setBounds(200, 125, 800, 60);
    questionML5.setBounds(100, 125, 800, 60);

    //this will create a feedback area for each level
    feedbackML1 = new JLabel("Take your guess below");
    feedbackML2 = new JLabel("Take your guess below");
    feedbackML3 = new JLabel("Take your guess below");
    feedbackML4 = new JLabel("Take your guess below");
    feedbackML5 = new JLabel("Take your gueuss below");

    //this will add the feedback area to each level
    mediumL1.add(feedbackML1);
    mediumL2.add(feedbackML2);
    mediumL3.add(feedbackML3);
    mediumL4.add(feedbackML4);
    mediumL5.add(feedbackML5);

    //this will manipulate the feedback areas to different parts of their respected panels
    feedbackML1.setBounds(300, 350, 800, 30);
    feedbackML2.setBounds(300, 350, 800, 30);
    feedbackML3.setBounds(300, 350, 800, 30);
    feedbackML4.setBounds(300, 350, 800, 30);
    feedbackML5.setBounds(300, 350, 800, 30);

    //this will create a button that will allow the user to go back once a level is completed
    completeML1 = new JButton("Next");
    completeML2 = new JButton("Next");
    completeML3 = new JButton("Next");
    completeML4 = new JButton("Next");
    completeML5 = new JButton("Next");

    //this will add the button to the respected 
    mediumL1.add(completeML1);
    mediumL2.add(completeML2);
    mediumL3.add(completeML3);
    mediumL4.add(completeML4);
    mediumL5.add(completeML5);

    //this will manipulate the button to replected parts
    completeML1.setBounds(340, 450, 100, 30);
    completeML2.setBounds(340, 450, 100, 30);
    completeML3.setBounds(340, 450, 100, 30);
    completeML4.setBounds(340, 450, 100, 30);
    completeML5.setBounds(340, 450, 100, 30);

    //this will set the action command to the button
    completeML1.setActionCommand("completeML1");
    completeML2.setActionCommand("completeML2");
    completeML3.setActionCommand("completeML3");
    completeML4.setActionCommand("completeML4");
    completeML5.setActionCommand("completeML5");

    //this will add the action listener to each button
    completeML1.addActionListener(this);
    completeML2.addActionListener(this);
    completeML3.addActionListener(this);
    completeML4.addActionListener(this);
    completeML5.addActionListener(this);

    //this will make the buttons invisible
    completeML1.setVisible(false);
    completeML2.setVisible(false);
    completeML3.setVisible(false);
    completeML4.setVisible(false);
    completeML5.setVisible(false);

    //this will create a back button on the medium panel
    JButton backButtonMedium = new JButton("Back");
    mediumPanel.add(backButtonMedium);
    backButtonMedium.setBounds(320, 400, 125, 30); 

    //this will set the action command and the action listener for the backButton
    backButtonMedium.setActionCommand("backButtonMedium");
    backButtonMedium.addActionListener(this);

    //this will create a new panel where all of the difficult questions will go
    hardPanel = new JPanel();
    hardPanel.setLayout(null);

    //this will create a button where the panel made above may be accessed
    JButton hard = new JButton("Hard");
    titlePanel.add(hard);
    hard.setBounds(300, 300, 125, 30);
    hard.setActionCommand("hard");
    hard.addActionListener(this);

    //this will create a title for the hard panel
    JLabel hardTitle = new JLabel("Hard");
    hardTitle.setFont(biggerFont);
    hardPanel.add(hardTitle);
    hardTitle.setBounds(310, 40, 600, 80);
    
    //this will create 5 different panels for the hard levels
    hardL1 = new JPanel();
    hardL2 = new JPanel();
    hardL3 = new JPanel();
    hardL4 = new JPanel();
    hardL5 = new JPanel();

    //this will set the layout for all 5 of the levels
    hardL1.setLayout(null);
    hardL2.setLayout(null);
    hardL3.setLayout(null);
    hardL4.setLayout(null);
    hardL5.setLayout(null);

    //this will create 5 answer areas that will later be added to each of the panels
    answerAreaH1 = new JTextField("");
    answerAreaH2 = new JTextField("");
    answerAreaH3 = new JTextField("");
    answerAreaH4 = new JTextField("");
    answerAreaH5 = new JTextField("");

    //this will add the answerAreas to the hard levels
    hardL1.add(answerAreaH1);
    hardL2.add(answerAreaH2);
    hardL3.add(answerAreaH3);
    hardL4.add(answerAreaH4);
    hardL5.add(answerAreaH5);

    //this will manipulate the answerAreas to different parts of the panels
    answerAreaH1.setBounds(250, 400, 150, 30);
    answerAreaH2.setBounds(250, 400, 150, 30);
    answerAreaH3.setBounds(250, 400, 150, 30);
    answerAreaH4.setBounds(250, 400, 150, 30);
    answerAreaH5.setBounds(250, 400, 150, 30);

    //this will add a submit button where the user can test if there guess was correct
    JButton submitH1 = new JButton("Submit");
    JButton submitH2 = new JButton("Submit");
    JButton submitH3 = new JButton("Submit");
    JButton submitH4 = new JButton("Submit");
    JButton submitH5 = new JButton("Submit");
  

    //this will add the submit buttons to the panels
    hardL1.add(submitH1);
    hardL2.add(submitH2);
    hardL3.add(submitH3);
    hardL4.add(submitH4);
    hardL5.add(submitH5);

    //this will manipulate each of the buttons to different parts of each panel
    submitH1.setBounds(425, 400, 100, 30);
    submitH2.setBounds(425, 400, 100, 30);
    submitH3.setBounds(425, 400, 100, 30);
    submitH4.setBounds(425, 400, 100, 30);
    submitH5.setBounds(425, 400, 100, 30);

    //this will set the action command to all of the "hard" butons
    submitH1.setActionCommand("submitH1");
    submitH2.setActionCommand("submitH2");
    submitH3.setActionCommand("submitH3");
    submitH4.setActionCommand("submitH4");
    submitH5.setActionCommand("submitH5");

    //this will add the action listener to all of the "hard" buttons
    submitH1.addActionListener(this);
    submitH2.addActionListener(this);
    submitH3.addActionListener(this);
    submitH4.addActionListener(this);
    submitH5.addActionListener(this);

    //this wil create JLabels that will show the word ladder to the user
    questionHL1 = new JLabel("brown ... brain");
    questionHL2 = new JLabel("crash ... ... claws");
    questionHL3 = new JLabel("peach ... ... ... lunch");
    questionHL4 = new JLabel("clout ... ... ... ... bleak");
    questionHL5 = new JLabel("space ... ... ... ... ... store");

    //this will set the font of the word ladders
    questionHL1.setFont(wordLadderFont);
    questionHL2.setFont(wordLadderFont);
    questionHL3.setFont(wordLadderFont);
    questionHL4.setFont(wordLadderFont);
    questionHL5.setFont(wordLadderFont);

    //this will add the word ladder to the respected panel
    hardL1.add(questionHL1);
    hardL2.add(questionHL2);
    hardL3.add(questionHL3);
    hardL4.add(questionHL4);
    hardL5.add(questionHL5);

    //this will manipulate the word ladders to different parts of their respected panels
    questionHL1.setBounds(250, 125, 800, 60);
    questionHL2.setBounds(175, 125, 800, 60);
    questionHL3.setBounds(175, 125, 800, 60);
    questionHL4.setBounds(175, 125, 800, 60);
    questionHL5.setBounds(50, 125, 800, 60);

    //this will create a feedback area for each level
    feedbackHL1 = new JLabel("Take your guess below");
    feedbackHL2 = new JLabel("Take your guess below");
    feedbackHL3 = new JLabel("Take your guess below");
    feedbackHL4 = new JLabel("Take your guess below");
    feedbackHL5 = new JLabel("Take your guess below");

    //this will add the feedback area to each level
    hardL1.add(feedbackHL1);
    hardL2.add(feedbackHL2);
    hardL3.add(feedbackHL3);
    hardL4.add(feedbackHL4);
    hardL5.add(feedbackHL5);

    //this will manipulate the feedback areas to different parts of their respected panels
    feedbackHL1.setBounds(300, 350, 800, 30);
    feedbackHL2.setBounds(300, 350, 800, 30);
    feedbackHL3.setBounds(300, 350, 800, 30);
    feedbackHL4.setBounds(300, 350, 800, 30);
    feedbackHL5.setBounds(300, 350, 800, 30);

    //this will create a button that will allow the user to go back once a level is completed
    completeHL1 = new JButton("Next");
    completeHL2 = new JButton("Next");
    completeHL3 = new JButton("Next");
    completeHL4 = new JButton("Next");
    completeHL5 = new JButton("Next");

    //this will add the button to the respected 
    hardL1.add(completeHL1);
    hardL2.add(completeHL2);
    hardL3.add(completeHL3);
    hardL4.add(completeHL4);
    hardL5.add(completeHL5);

    //this will manipulate the button to replected parts
    completeHL1.setBounds(340, 450, 100, 30);
    completeHL2.setBounds(340, 450, 100, 30);
    completeHL3.setBounds(340, 450, 100, 30);
    completeHL4.setBounds(340, 450, 100, 30);
    completeHL5.setBounds(340, 450, 100, 30);

    //this will set the action command to the button
    completeHL1.setActionCommand("completeHL1");
    completeHL2.setActionCommand("completeHL2");
    completeHL3.setActionCommand("completeHL3");
    completeHL4.setActionCommand("completeHL4");
    completeHL5.setActionCommand("completeHL5");

    //this will add the action listener to each button
    completeHL1.addActionListener(this);
    completeHL2.addActionListener(this);
    completeHL3.addActionListener(this);
    completeHL4.addActionListener(this);
    completeHL5.addActionListener(this);

    //this will make each button invisible
    completeHL1.setVisible(false);
    completeHL2.setVisible(false);
    completeHL3.setVisible(false);
    completeHL4.setVisible(false);
    completeHL5.setVisible(false);

    //this will create 5 different buttons where the panels above may be accessed
    JButton hardLevel1 = new JButton("Level 1");
    JButton hardLevel2 = new JButton("Level 2");
    JButton hardLevel3 = new JButton("Level 3");
    JButton hardLevel4 = new JButton("Level 4");
    JButton hardLevel5 = new JButton("Level 5");

    //this will add the buttons to the hard panel
    hardPanel.add(hardLevel1);
    hardPanel.add(hardLevel2);
    hardPanel.add(hardLevel3);
    hardPanel.add(hardLevel4);
    hardPanel.add(hardLevel5);

    //this will manipulate each of the buttons to different parts of the panel
    hardLevel1.setBounds(325, 150, 125, 30);
    hardLevel2.setBounds(325, 200, 125, 30);
    hardLevel3.setBounds(325, 250, 125, 30);
    hardLevel4.setBounds(325, 300, 125, 30);
    hardLevel5.setBounds(325, 350, 125, 30);

    //this will set the action command to all of the "hard" butons
    hardLevel1.setActionCommand("hardLevel1");
    hardLevel2.setActionCommand("hardLevel2");
    hardLevel3.setActionCommand("hardLevel3");
    hardLevel4.setActionCommand("hardLevel4");
    hardLevel5.setActionCommand("hardLevel5");

    //this will add an action listener to each of the buttons
    hardLevel1.addActionListener(this);
    hardLevel2.addActionListener(this);
    hardLevel3.addActionListener(this);
    hardLevel4.addActionListener(this);
    hardLevel5.addActionListener(this);

    //this will create a back button on the hard panel
    JButton backButtonHard = new JButton("Back");
    hardPanel.add(backButtonHard);
    backButtonHard.setBounds(325, 400, 125, 30); 

    //this will set the action command and the action listener for the backButton
    backButtonHard.setActionCommand("backButtonHard");
    backButtonHard.addActionListener(this);

    //this will create a string arrray for the word ladders. Each level is separated by a space
    easyL2Answers[0] = "bug";
    easyL2Answers[1] = "bag";

    easyL3Answers[0] = "lap";
    easyL3Answers[1] = "lip";
    easyL3Answers[2] = "hip";

    easyL4Answers[0] = "mop";
    easyL4Answers[1] = "pop";
    easyL4Answers[2] = "pot";
    easyL4Answers[3] = "dot";

    easyL5Answers[0] = "pit";
    easyL5Answers[1] = "pet";
    easyL5Answers[2] = "pot";
    easyL5Answers[3] = "cot";
    easyL5Answers[4] = "cow";

    mediumL2Answers[0] = "cast";
    mediumL2Answers[1] = "cost";

    mediumL3Answers[0] = "peer";
    mediumL3Answers[1] = "pear";
    mediumL3Answers[2] = "peak";

    mediumL4Answers[0] = "sang";
    mediumL4Answers[1] = "sand";
    mediumL4Answers[2] = "said";
    mediumL4Answers[3] = "paid";

    mediumL5Answers[0] = "host";
    mediumL5Answers[1] = "hoot";
    mediumL5Answers[2] = "hood";
    mediumL5Answers[3] = "mood";
    mediumL5Answers[4] = "moon";

    hardL2Answers[0] = "clash";
    hardL2Answers[1] = "class";

    hardL3Answers[0] = "beach";
    hardL3Answers[1] = "bench";
    hardL3Answers[2] = "bunch";

    hardL4Answers[0] = "flout";
    hardL4Answers[1] = "float";
    hardL4Answers[2] = "bloat";
    hardL4Answers[3] = "bleat";

    hardL5Answers[0] = "spare";
    hardL5Answers[1] = "spars";
    hardL5Answers[2] = "scars";
    hardL5Answers[3] = "scare";
    hardL5Answers[4] = "stare";

    //set up a screenLayout to manage all the screens
    screenLayout = new CardLayout();
    screens = new JPanel();
    frame.add(screens);
    screens.setLayout(screenLayout);

    //this will add the different screens to the screenLayout
    screens.add(titlePanel, "titlePanel");
    screens.add(instructionsPanel, "instructionsPanel");
    screens.add(easyPanel, "easyPanel");
    screens.add(easyL1, "easyL1");
    screens.add(easyL2, "easyL2");
    screens.add(easyL3, "easyL3");
    screens.add(easyL4, "easyL4");
    screens.add(easyL5, "easyL5");
    screens.add(mediumPanel, "mediumPanel");
    screens.add(mediumL1, "mediumL1");
    screens.add(mediumL2, "mediumL2");
    screens.add(mediumL3, "mediumL3");
    screens.add(mediumL4, "mediumL4");
    screens.add(mediumL5, "mediumL5");
    screens.add(hardPanel, "hardPanel");
    screens.add(hardL1, "hardL1");
    screens.add(hardL2, "hardL2");
    screens.add(hardL3, "hardL3");
    screens.add(hardL4, "hardL4");
    screens.add(hardL5, "hardL5");

    //this will show the title screen when the program is first run
    screenLayout.show(screens,"titlePanel");
  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();
    
    //if instructions is hit, the program will switch to the instructions panel
    if (command.equals("instructions"))
      {
      screenLayout.show(screens, "instructionsPanel");
      }

    //if the user wants to back to the title screen from the instructions panel
    else if (command.equals("backButtonInstructions"))
      {
      screenLayout.show(screens, "titlePanel");
      }

    //if the user wants to do the easy levels they will be sent to the screen where they may select a leval
    else if (command.equals("easy"))
      {
      screenLayout.show(screens, "easyPanel");
      }
    
    //if the user wants to do leval 1 of the easy levels they will be sent to that panel
    else if (command.equals("easyLevel1"))
      {
      screenLayout.show(screens, "easyL1");
      }
    
    //if the user wants to do leval 2 of the easy levels they will be sent to that panel
    else if (command.equals("easyLevel2"))
      {
      screenLayout.show(screens, "easyL2");  
      }
    
    //if the user wants to do leval 3 of the easy levels they will be sent to that panel
    else if(command.equals("easyLevel3"))
      {
      screenLayout.show(screens, "easyL3");  
      }

    //if the user wants to do leval 4 of the easy levels they will be sent to that panel
    else if(command.equals("easyLevel4"))
      {
      screenLayout.show(screens, "easyL4"); 
      }
    
    //if the user wants to do leval 5 of the easy levels they will be sent to that panel
    else if(command.equals("easyLevel5"))
      {
      screenLayout.show(screens, "easyL5");  
      }
    
    //if the user wants to go back to the title screen from the easy panel 
    else if(command.equals("backButtonEasy"))
      {
      screenLayout.show(screens, "titlePanel");  
      }
    
    //if the user wants to do the medium levels they will be sent to the screen where they may select a leval
    else if(command.equals("medium"))
      {
      screenLayout.show(screens, "mediumPanel");  
      }

    //if the user wants to do leval 1 of the medium levels they will be sent to that panel
    else if(command.equals("mediumLevel1"))
      {
      screenLayout.show(screens, "mediumL1");  
      }

    //if the user wants to do leval 2 of the medium levels they will be sent to that panel
    else if(command.equals("mediumLevel2"))
      {
      screenLayout.show(screens, "mediumL2");  
      }
    
    //if the user wants to do leval 3 of the medium levels they will be sent to that panel
    else if(command.equals("mediumLevel3"))
      {
      screenLayout.show(screens, "mediumL3");  
      }

    //if the user wants to do leval 4 of the medium levels they will be sent to that panel
    else if(command.equals("mediumLevel4"))
      {
      screenLayout.show(screens, "mediumL4");  
      }
    
    //if the user wants to do leval 5 of the medium levels they will be sent to that panel
    else if(command.equals("mediumLevel5"))
      {
      screenLayout.show(screens, "mediumL5");  
      }

    //if the user wants to go back to the title screen from the medium panel they may by this button
    else if(command.equals("backButtonMedium"))
      {
      screenLayout.show(screens, "titlePanel");  
      }
    
    //if the user wants to try the hard levels they may access all of the levels by clicking this button
    else if(command.equals("hard"))
      {
      screenLayout.show(screens, "hardPanel");
      }
    
    //if the user wants to do level 1 of the hard levels they will be sent to that panel
    else if(command.equals("hardLevel1"))
      {
      screenLayout.show(screens, "hardL1");  
      }
    
    //if the user wants to do leval 2 of the hard levels they will be sent to that panel
    else if(command.equals("hardLevel2"))
      {
      screenLayout.show(screens, "hardL2");  
      }

    //if the user wants to do leval 3 of the hard levels they will be sent to that panel
    else if(command.equals("hardLevel3"))
      {
      screenLayout.show(screens, "hardL3");  
      }

    //if the user wants to do leval 4 of the hard levels they will be sent to that panel
    else if(command.equals("hardLevel4"))
      {
      screenLayout.show(screens, "hardL4");  
      }

    //if the user wants to do leval 5 of the hard levels they will be sent to that panel
    else if(command.equals("hardLevel5"))
      {
      screenLayout.show(screens, "hardL5");  
      }
    
    //if the user wants to be sent to the title screen from the hard levels they can do it
    else if(command.equals("backButtonHard"))
      {
      screenLayout.show(screens, "titlePanel");
      }
    
    //if the user wants to test their answer for level 1 on the easy level
    else if(command.equals("submitE1"))
      {
      //this will get what the user entered and put it in a string
      String answer = answerAreaE1.getText();
      if(answer.equals("cap"))
        {
        questionEL1.setText("cup cap cat");
        feedbackEL1.setText("Congratulations! Click next!");  
        completeEL1.setVisible(true);
        }
      //if the user is incorrect, tell them
      else{
        feedbackEL1.setText("Wrong guess! Keep trying!");
        }
      }
    
    //if the user wants to test their answer for level 2 on the easy levels
    else if(command.equals("submitE2"))
      {
      String answer = answerAreaE2.getText();
      String labelEL2 = questionEL2.getText();
      if (answer.equals(easyL2Answers[testEasyL2]))
        {
        int firstDot = labelEL2.indexOf("...");
        String newText = questionEL2.getText().substring(0, firstDot) + answer + questionEL2.getText().substring(firstDot + 3, questionEL2.getText().length());
        questionEL2.setText(newText);
        feedbackEL2.setText("Congratulations!");
        testEasyL2++;
        if(testEasyL2 == 2)
          {
          completeEL2.setVisible(true);
          }
        }
       //if the user is incorrect, tell them
       else{
         feedbackEL2.setText("Wrong guess! Try again!");
         }
      }

    //if the user wants to test their answer for level 3 on the easy levels
    else if(command.equals("submitE3"))
      {
      String answer = answerAreaE3.getText();
      String labelEL3 = questionEL3.getText();
      if(answer.equals(easyL3Answers[testEasyL3]))
        {
        int firstDot = labelEL3.indexOf("...");
        String newText = questionEL3.getText().substring(0, firstDot) + answer + questionEL3.getText().substring(firstDot + 3, questionEL3.getText().length());
        questionEL3.setText(newText);
        feedbackEL3.setText("Congratulations!");
        testEasyL3++;
        if(testEasyL3 == 3)
          {
          completeEL3.setVisible(true);
          }
        }
      else{
        feedbackEL3.setText("Wrong Guess! You can do this!");
        }
      }
    
    //if the user wants to test their answer for level 4 on the easy levels
   else if(command.equals("submitE4"))
     {
     String answer = answerAreaE4.getText();
     String labelEL4 = questionEL4.getText();
     if(answer.equals(easyL4Answers[testEasyL4]))
       {
       int firstDot = labelEL4.indexOf("...");
       String newText = questionEL4.getText().substring(0, firstDot) + answer + questionEL4.getText().substring(firstDot + 3, questionEL4.getText().length());
       questionEL4.setText(newText);
       feedbackEL4.setText("Congratulations!");
       testEasyL4++;
       if(testEasyL4 == 4)
         {
         completeEL4.setVisible(true);
         }
       }
     else{
        feedbackEL4.setText("Incorrect! Don't give up!");
        }
     }

   //if the user wants to test their answer for level 5 on the easy levels
   else if(command.equals("submitE5"))
     {
     String answer = answerAreaE5.getText();
     String labelEL5 = questionEL5.getText();
     if(answer.equals(easyL5Answers[testEasyL5]))
       {
       int firstDot = labelEL5.indexOf("...");
       String newText = questionEL5.getText().substring(0, firstDot) + answer + questionEL5.getText().substring(firstDot + 3, questionEL5.getText().length());
       questionEL5.setText(newText);
       feedbackEL5.setText("Congratulations!");
       testEasyL5++;
       if(testEasyL5 == 5)
        {
        completeEL5.setVisible(true);
        }
       }
      else{
        feedbackEL5.setText("Wrong guess! Try something else!");
        }
     }
  
  //if the user wants to test their answer for level 1 on the medium levels
   else if(command.equals("submitM1"))
     {
     String answer = answerAreaM1.getText();
     if(answer.equals("fist"))
       {
       questionML1.setText("fish fist fast");
       feedbackML1.setText("Congratulations!");
       completeML1.setVisible(true);
       }
     else{
       feedbackML1.setText("Wrong guess! Keep trying!");
       }
     }
   
   //if the user wants to test their answer for level 2 on the medium levels
   else if(command.equals("submitM2"))
     {
     String answer = answerAreaM2.getText();
     String labelML2 = questionML2.getText();
     if(answer.equals(mediumL2Answers[testMediumL2]))
       {
       int firstDot = labelML2.indexOf("...");
       String newText = questionML2.getText().substring(0, firstDot) + answer + questionML2.getText().substring(firstDot + 3, questionML2.getText().length());
       questionML2.setText(newText);
       feedbackML2.setText("Congratulations!");
       testMediumL2++;
       if(testMediumL2 == 2)
         {
         completeML2.setVisible(true);
         }
       }
     else{
       feedbackML2.setText("Wrong guess! Keep trying!");
       }
     }

    //if the user wants to test their answer for level 3 of the medium questions
    else if(command.equals("submitM3"))
      {
      String answer = answerAreaM3.getText();
      String labelML3 = questionML3.getText();
      if(answer.equals(mediumL3Answers[testMediumL3]))
        {
        int firstDot = labelML3.indexOf("...");
        String newText = questionML3.getText().substring(0, firstDot) + answer + questionML3.getText().substring(firstDot + 3, questionML3.getText().length());
        questionML3.setText(newText);
        testMediumL3++;
        feedbackML3.setText("Congratulations!");
        if(testMediumL3 == 3)
          {
          completeML3.setVisible(true);
          }
        }
      else{
        feedbackML3.setText("Wrong guess! You can do this!");
        }
      }
 
    //if the user wants to test their answer for level 4 of the medium questions
    else if(command.equals("submitM4"))
      {
      String answer = answerAreaM4.getText();
      String labelML4 = questionML4.getText();
      if(answer.equals(mediumL4Answers[testMediumL4]))
        {
        int firstDot = labelML4.indexOf("...");
        String newText = questionML4.getText().substring(0, firstDot) + answer + questionML4.getText().substring(firstDot + 3, questionML4.getText().length());
        questionML4.setText(newText);
        testMediumL4++;
        feedbackML4.setText("Congratulations!");
        if(testMediumL4 == 4)
          {
          completeML4.setVisible(true);
          }
        }
      else
        {
        feedbackML4.setText("Incorrect! Don't give up!");
        }
      }
    
    //if the user wants to test their answer for level 5 of the medium questions
    else if(command.equals("submitM5"))
      {
      String answer = answerAreaM5.getText();
      String labelML5 = questionML5.getText();
      if(answer.equals(mediumL5Answers[testMediumL5]))
        {
        int firstDot = labelML5.indexOf("...");
        String newText = questionML5.getText().substring(0,firstDot) + answer + questionML5.getText().substring(firstDot + 3, questionML5.getText().length());
        questionML5.setText(newText);
        testMediumL5++;
        feedbackML5.setText("Congratulations!");
        if(testMediumL5 == 5)
          {
          completeML5.setVisible(true);
          }
        }
      else{
        feedbackML5.setText("Incorrect! Try something else!");
        }
      }

    //if the user wants to test their answer for level 1 of the hard levels
    else if(command.equals("submitH1"))
      {
      String answer = answerAreaH1.getText();
      if(answer.equals("brawn"))
        {
        questionHL1.setText("brown brawn brain");
        feedbackHL1.setText("Congratulations!");
        completeHL1.setVisible(true);
        }
      else{
        feedbackHL1.setText("Wrong guess! Keep trying!");
        }
      }
    
    //if the user wants to test their answer for level 2 of the hard levels
    else if(command.equals("submitH2"))
      {
      String answer = answerAreaH2.getText();
      String labelHL2 = questionHL2.getText();
      if(answer.equals(hardL2Answers[testHardL2]))
        {
        int firstDot = labelHL2.indexOf("...");
        String newText = questionHL2.getText().substring(0,firstDot) + answer + questionHL2.getText().substring(firstDot + 3, questionHL2.getText().length());
        questionHL2.setText(newText);
        testHardL2++;
        feedbackHL2.setText("Congratulations!");
        if(testHardL2 == 2)
          {
          completeHL2.setVisible(true);
          }
        }
      else
        {
        feedbackHL2.setText("Wrong guess! Keep trying!");
        }
      }
    
    //if the user wants to test their answer for level 3 of the hard levels
    else if(command.equals("submitH3"))
      {
      String answer = answerAreaH3.getText();
      String labelHL3 = questionHL3.getText();
      if(answer.equals(hardL3Answers[testHardL3]))
        {
        int firstDot = labelHL3.indexOf("...");
        String newText = questionHL3.getText().substring(0,firstDot) + answer + questionHL3.getText().substring(firstDot + 3, questionHL3.getText().length());
        questionHL3.setText(newText);
        testHardL3++;
        feedbackHL3.setText("Congratulations!");
        if(testHardL3 == 3)
          {
          completeHL3.setVisible(true);
          }
        }
      else
        {
        feedbackHL3.setText("Wrong guess! You can do this!");
        }
      }
    
    //if the user wants to test their answer for level 4 of the hard levels
    else if(command.equals("submitH4"))
      {
      String answer = answerAreaH4.getText();
      String labelHL4 = questionHL4.getText();
      if(answer.equals(hardL4Answers[testHardL4]))
        {
        int firstDot = labelHL4.indexOf("...");
        String newText = questionHL4.getText().substring(0,firstDot) + answer + questionHL4.getText().substring(firstDot + 3, questionHL4.getText().length());
        questionHL4.setText(newText);
        testHardL4++;
        feedbackHL4.setText("Congratulations!");
        if(testHardL4 == 4)
          {
          completeHL4.setVisible(true);
          }
        }
      else
        {
        feedbackHL4.setText("Incorrect! Don't give up!");
        }
      }

    //if the user wants to test their answer for level 5 of the hard levels
    else if(command.equals("submitH5"))
      {
      String answer = answerAreaH5.getText();
      String labelHL5 = questionHL5.getText();
      if(answer.equals(hardL5Answers[testHardL5]))
        {
        int firstDot = labelHL5.indexOf("...");
        String newText = questionHL5.getText().substring(0,firstDot) + answer + questionHL5.getText().substring(firstDot + 3, questionHL5.getText().length());
        questionHL5.setText(newText);
        testHardL5++;
        feedbackHL5.setText("Congratulations!");
        if(testHardL5 == 5)
          {
          completeHL5.setVisible(true);
          }
        }
      else
        {
        feedbackHL5.setText("Incorrect! Try something else!");
        }
      }

    //after a level is completed, the user will be sent back to the title screen. This applies for every "else if" statement below
    else if(command.equals("completeEL1"))
      {
      screenLayout.show(screens, "titlePanel");
      }

    else if(command.equals("completeEL2"))
      {
      screenLayout.show(screens, "titlePanel");
      }
         
    else if(command.equals("completeEL3"))
      {
      screenLayout.show(screens, "titlePanel");
      }

    else if(command.equals("completeEL4"))
      {
      screenLayout.show(screens, "titlePanel");
      }

    else if(command.equals("completeEL5"))
      {
      screenLayout.show(screens, "titlePanel");
      }
    
    else if(command.equals("completeML1"))
      {
      screenLayout.show(screens, "titlePanel");
      }

    else if(command.equals("completeML2"))
      {
      screenLayout.show(screens, "titlePanel");
      }
         
    else if(command.equals("completeML3"))
      {
      screenLayout.show(screens, "titlePanel");
      }

    else if(command.equals("completeML4"))
      {
      screenLayout.show(screens, "titlePanel");
      }

    else if(command.equals("completeML5"))
      {
      screenLayout.show(screens, "titlePanel");
      }
    
    else if(command.equals("completeHL1"))
      {
      screenLayout.show(screens, "titlePanel");
      }

    else if(command.equals("completeHL2"))
      {
      screenLayout.show(screens, "titlePanel");
      }
         
    else if(command.equals("completeHL3"))
      {
      screenLayout.show(screens, "titlePanel");
      }

    else if(command.equals("completeHL4"))
      {
      screenLayout.show(screens, "titlePanel");
      }

    else if(command.equals("completeHL5"))
      {
      screenLayout.show(screens, "titlePanel");
      }
      
 
  } 

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}