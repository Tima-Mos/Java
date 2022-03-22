import javax.swing.*;
import java.awt.*;

public class GuessApp extends JFrame {
    private static final String PLAF_1 = "javax.swing.plaf.metal.MetalLookAndFeel";
    private static final String PLAF_2 = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
    private static final String PLAF_3 = "javax.swing.plaf.nimbus.NimbusLookAndFeel";

    private static final String ACTION_COMMAND_1 = "plaf1";
    private static final String ACTION_COMMAND_2 = "plaf2";
    private static final String ACTION_COMMAND_3 = "plaf3";

    private JLabel znac, min, max, style;
    private JTextField minNumb, maxNumb;
    private JTextArea area;
    private Container container;
    private JButton start, guessLess, guessMore, youGuessed;
    private JRadioButton plafRadioButton1, plafRadioButton2, plafRadioButton3;
    private ButtonGroup styleButtons;
    private Guesser guesser;
    private int estimatedNumb;
    public GuessApp(){
        super("угадатель");
        super.setBounds(200, 100, 600, 500);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        container = super.getContentPane();
        container.setLayout(new GridLayout(6, 2, 0, 2));
        init();
        addRadioButtonsToGroup();
        createGuesser();
        enableStarting();
        disableGuessing();
    }
    private void init(){
        //znac = new JLabel("значения диапазона:");
        min = new JLabel("минимальное:");
        //minNumb = new JSpinner();
        minNumb = new JTextField("0",1);
        max = new JLabel("максимальное:");
        maxNumb = new JTextField("0",1);
       // maxNumb = new JSpinner();
        area = new JTextArea("", 5, 5);
        start = new JButton("Начать");
        guessLess = new JButton("Меньше");
        guessMore = new JButton("Больше");
        youGuessed = new JButton("Угадал");
        styleButtons = new javax.swing.ButtonGroup();
        plafRadioButton1 = new javax.swing.JRadioButton();
        plafRadioButton2 = new javax.swing.JRadioButton();
        plafRadioButton3 = new javax.swing.JRadioButton();
       // container.add(znac);
        container.add(min);
        container.add(minNumb);
        container.add(max);
        container.add(maxNumb);
        container.add(start);
        container.add(youGuessed);
        container.add(guessMore);
        container.add(guessLess);
        container.add(area);
        container.add(plafRadioButton1);
        container.add(plafRadioButton2);
        container.add(plafRadioButton3);
        start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        youGuessed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                youGuessedButtonActionPerformed(evt);
            }
        });

        guessLess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guessLessButtonActionPerformed(evt);
            }
        });

        guessMore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guessMoreButtonActionPerformed(evt);
            }
        });
        plafRadioButton1.setText(PLAF_1);
        plafRadioButton1.setActionCommand(ACTION_COMMAND_1);
        plafRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plafRadioButton1ActionPerformed(evt);
            }
        });

        plafRadioButton2.setText(PLAF_2);
        plafRadioButton2.setActionCommand(ACTION_COMMAND_2);
        plafRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plafRadioButton1ActionPerformed(evt);
            }
        });

        plafRadioButton3.setText(PLAF_3);
        plafRadioButton3.setActionCommand(ACTION_COMMAND_3);
        plafRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plafRadioButton1ActionPerformed(evt);
            }
        });
    }
    private void createGuesser() {
        int min = Integer.parseInt(minNumb.getText());
        int max = Integer.parseInt(maxNumb.getText());
        guesser = new Guesser(min, max);
    }
    private void addRadioButtonsToGroup() {
        styleButtons.add(plafRadioButton1);
        styleButtons.add(plafRadioButton2);
        styleButtons.add(plafRadioButton3);

        plafRadioButton1.setSelected(true);
    }
    private void changePlaf(String actionCommand) {
        try {
            String plafName = PLAF_1;
            switch (actionCommand) {
                case ACTION_COMMAND_1:
                    plafName = PLAF_1;
                    break;
                case ACTION_COMMAND_2:
                    plafName = PLAF_2;
                    break;
                case ACTION_COMMAND_3:
                    plafName = PLAF_3;
                    break;
                default:
                    break;
            }

            UIManager.setLookAndFeel(plafName);
            SwingUtilities.updateComponentTreeUI(this);
            this.pack();
        } catch (Exception exc) {
            area.append(exc.getMessage());
            area.append(System.lineSeparator());
        }
    }
    private void disableStarting() {
        minNumb.setEnabled(false);
        maxNumb.setEnabled(false);
        start.setEnabled(false);
    }

    private void enableGuessing() {
        youGuessed.setEnabled(true);
        guessLess.setEnabled(true);
        guessMore.setEnabled(true);
    }
    private void enableStarting() {
        minNumb.setEnabled(true);
        maxNumb.setEnabled(true);
        start.setEnabled(true);
    }

    private void disableGuessing() {
        youGuessed.setEnabled(false);
        guessLess.setEnabled(false);
        guessMore.setEnabled(false);
    }
    private void guess() {
        disableStarting();
        enableGuessing();

        try {
            guesser.setMinNumb(Integer.parseInt(minNumb.getText()));
            guesser.setMaxNumb(Integer.parseInt(maxNumb.getText()));
            System.out.println();
        } catch (Exception exc) {
            area.append(exc.getMessage());
            area.append(System.lineSeparator());
            disableGuessing();
            enableStarting();
            return;
        }

        estimatedNumb = guesser.guess();
        area.setText("");
        area.append("я думаю, что это ... ");
        area.append(Integer.toString(estimatedNumb));
        area.append(System.lineSeparator());
    }
    private void youGuessed() {
        enableStarting();
        disableGuessing();
        area.setText("");
        area.append("Я угадал! Вы загадали ... " + estimatedNumb);
        area.append(System.lineSeparator());
        area.append("Хотите сыграть ещё раз? Нажмите НАЧАТЬ.");
        area.append(System.lineSeparator());
    }
    private void guessLess() {
        if (guesser.getMinNumb() == guesser.getMaxNumb()) {
            youAreCheater();
        } else {
            final int newMax = estimatedNumb - 1;
            maxNumb.setText(String.valueOf((Object) newMax));
            guess();
        }
    }

    private void youAreCheater() {
        area.setText("");
        area.append("Вы жульничаете! Я уже угадал число.");
        area.append(System.lineSeparator());
        area.append("Хотите сыграть ещё раз? Нажмите НАЧАТЬ.");
        area.append(System.lineSeparator());
        disableGuessing();
        enableStarting();
    }

    private void guessMore() {
        if (guesser.getMinNumb() == guesser.getMaxNumb()) {
            youAreCheater();
        } else {
            final int newMin = estimatedNumb + 1;
            minNumb.setText(String.valueOf((Object) newMin));
            guess();
        }
    }
    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {
        guess();
    }

    private void youGuessedButtonActionPerformed(java.awt.event.ActionEvent evt) {
        youGuessed();
    }

    private void guessLessButtonActionPerformed(java.awt.event.ActionEvent evt) {
        guessLess();
    }

    private void guessMoreButtonActionPerformed(java.awt.event.ActionEvent evt) {
        guessMore();
    }
    private void plafRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        changePlaf(styleButtons.getSelection().getActionCommand());
    }

}
