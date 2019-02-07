package edu.jsu.mcis;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TicTacToeController implements ActionListener {

    private final TicTacToeModel model;
    private final TicTacToeView view;

    
    /* CONSTRUCTOR */

    public TicTacToeController(int width) {
        
        /* Initialize model, view, and width */

        model = new TicTacToeModel(width);
        view = new TicTacToeView();        
    }        

    public String getMarkAsString(int row, int col) {        
        return (model.getMark(row, col).toString());        
    }
    
    public TicTacToeView getView() {        
        return view;        
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        // INSERT YOUR CODE HERE
        Object b = event.getSource();
        String square = b.getName();
        String[] split = square.split("");
        
        int row = Integer.parseInt(split[6]);
        int col = Integer.parseInt(split[7]);
        model.makeMark(row, col);

        this.getView().updateSquares();

        }
    }


