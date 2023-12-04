package it.unipv.po.recipefy;

import it.unipv.po.recipefy.Views.MainFrame.MainFrame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainFrame::new);
    }
}