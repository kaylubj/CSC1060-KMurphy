import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class PigGameGUI extends JFrame {
    private int userTotal = 0, computerTotal = 0, roundScore = 0;
    private boolean userTurn = true;

    private JLabel statusLabel, userScoreLabel, compScoreLabel, roundLabel, diceLabel;
    private JButton rollButton, holdButton;
    private Random rand = new Random();

    public PigGameGUI() {
        setTitle("Pig Dice Game");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center on screen
        setResizable(false);

        // MAIN PANEL
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // padding
        add(mainPanel);

        // STATUS & SCORE PANEL
        statusLabel = createLabel("🎲 Welcome to Pig! Your turn.", 18);
        userScoreLabel = createLabel("Your Score: 0", 16);
        compScoreLabel = createLabel("Computer Score: 0", 16);
        roundLabel = createLabel("Round Score: 0", 16);

        mainPanel.add(statusLabel);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(userScoreLabel);
        mainPanel.add(compScoreLabel);
        mainPanel.add(roundLabel);

        // DICE IMAGE
        diceLabel = new JLabel();
        diceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        setDiceImage(1);
        mainPanel.add(Box.createVerticalStrut(20));
        mainPanel.add(diceLabel);

        // BUTTONS PANEL
        JPanel buttonPanel = new JPanel();
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

        rollButton = createButton("Roll 🎲");
        holdButton = createButton("Hold ✋");

        rollButton.addActionListener(e -> handleRoll());
        holdButton.addActionListener(e -> handleHold());

        buttonPanel.add(rollButton);
        buttonPanel.add(holdButton);
        mainPanel.add(Box.createVerticalStrut(20));
        mainPanel.add(buttonPanel);

        setVisible(true);
    }

    // Create styled label
    private JLabel createLabel(String text, int fontSize) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("SansSerif", Font.PLAIN, fontSize));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        return label;
    }

    // Create styled button
    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("SansSerif", Font.BOLD, 16));
        button.setFocusPainted(false);
        button.setBackground(new Color(80, 160, 240));
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        return button;
    }

    private void handleRoll() {
        int roll = rand.nextInt(6) + 1;
        setDiceImage(roll);
        if (roll == 1) {
            statusLabel.setText("😵 You rolled a 1! Turn over.");
            roundScore = 0;
            updateRoundScore();
            userTurn = false;
            computerTurn();
        } else {
            roundScore += roll;
            statusLabel.setText("You rolled a " + roll + ".");
            updateRoundScore();
            if (userTotal + roundScore >= 100) {
                userTotal += roundScore;
                gameOver("You");
            }
        }
    }

    private void handleHold() {
        userTotal += roundScore;
        userScoreLabel.setText("Your Score: " + userTotal);
        roundScore = 0;
        updateRoundScore();
        if (userTotal >= 100) {
            gameOver("You");
        } else {
            userTurn = false;
            computerTurn();
        }
    }

    private void computerTurn() {
        rollButton.setEnabled(false);
        holdButton.setEnabled(false);
        roundScore = 0;

        Timer timer = new Timer(1000, null);
        timer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                int roll = rand.nextInt(6) + 1;
                setDiceImage(roll);
                if (roll == 1) {
                    statusLabel.setText("Computer rolled a 1!");
                    roundScore = 0;
                    endComputerTurn(timer);
                } else {
                    roundScore += roll;
                    statusLabel.setText("Computer rolled: " + roll);
                    if (roundScore >= 20 || computerTotal + roundScore >= 100) {
                        computerTotal += roundScore;
                        compScoreLabel.setText("Computer Score: " + computerTotal);
                        if (computerTotal >= 100) {
                            gameOver("Computer");
                            timer.stop();
                            return;
                        }
                        endComputerTurn(timer);
                    }
                }
                updateRoundScore();
            }
        });
        timer.start();
    }

    private void endComputerTurn(Timer timer) {
        timer.stop();
        roundScore = 0;
        updateRoundScore();
        statusLabel.setText("Your turn!");
        userTurn = true;
        rollButton.setEnabled(true);
        holdButton.setEnabled(true);
    }

    private void updateRoundScore() {
        roundLabel.setText("Round Score: " + roundScore);
    }

    private void gameOver(String winner) {
        String message = (winner.equals("You") ? "You Win! \uD83C\uDF89" : "Computer wins! \uD83E\uDD16");
        statusLabel.setText(message);
        rollButton.setEnabled(false);
        holdButton.setEnabled(false);

        int option = JOptionPane.showConfirmDialog(
                this,
                message + "\nDo you want to play again?",
                "Play Again?",
                JOptionPane.YES_NO_OPTION
        );

        if (option == JOptionPane.YES_OPTION) {
            resetGame();
        } else {
            System.exit(0);
        }
    }

    private void resetGame() {
        userTotal = 0;
        computerTotal = 0;
        roundScore = 0;
        userTurn = true;

        userScoreLabel.setText("Your Score: 0");
        compScoreLabel.setText("Computer Score: 0");
        roundLabel.setText("Round Score: 0");
        statusLabel.setText("🎲 New game! Your turn.");
        setDiceImage(1);

        rollButton.setEnabled(true);
        holdButton.setEnabled(true);
    }

    private void setDiceImage(int roll) {
        ImageIcon originalIcon = new ImageIcon("die" + roll + ".png");
        Image scaledImage = originalIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        diceLabel.setIcon(new ImageIcon(scaledImage));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PigGameGUI());
    }
}
