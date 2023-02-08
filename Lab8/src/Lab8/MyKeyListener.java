package Lab8;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;

public class MyKeyListener implements KeyListener {
	private JButton b11;
	private JButton b2;
	private JButton b3;
	private JButton b4;
	private JButton b5;
	private JButton b6;
	private JButton b7;
	private JButton b8;
	private JButton b9;
	private JButton b0;
	private JButton bplus;
	private JButton bminus;
	private JButton bmulti;
	private JButton bdiv;
	private JButton bpow;
	private JButton broot;
	private JButton bc;
	private JButton bchange;
	private JButton bequ;
	private JButton bdot;
	private Visual vis;
	private ActionEvent er;
	MyKeyListener(JButton bb1, JButton bb2, JButton bb3, JButton bb4, JButton bb5, JButton bb6, JButton bb7, JButton bb8, JButton bb9, JButton bb0, JButton bbplus, JButton bbminus, JButton bbmulti, JButton bbdiv, JButton bbpow, JButton bbroot, JButton bbequ, JButton bbc, JButton bbchange, JButton bbdot, Visual viss){
		b11 = bb1;
		b2 = bb2;
		b3 = bb3;
		b4 = bb4;
		b5 = bb5;
		b6 = bb6;
		b7 = bb7;
		b8 = bb8;
		b9 = bb9;
		b0 = bb0;
		bplus = bbplus;
		bminus = bbminus;
	    bmulti = bbmulti;
		bdiv = bbdiv;
		bpow = bbpow;
	    broot = bbroot;
		bc = bbc;
		bchange = bbchange;
	    bequ = bbequ;
		bdot = bbdot;
		vis = viss;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
        if (e.getKeyChar() == '1') {
            b11.doClick();
        	//vis.b1.doClick();
        } else if (e.getKeyChar() == '2') {
            b2.doClick();
        } else if (e.getKeyChar() == '3') {
            b3.doClick();
        } else if (e.getKeyChar() == '4') {
            b4.doClick();
        } else if (e.getKeyChar() == '5') {
            b5.doClick();
        } else if (e.getKeyChar() == '6') {
            b6.doClick();
        } else if (e.getKeyChar() == '7') {
            b7.doClick();
        } else if (e.getKeyChar() == '8') {
            b8.doClick();
        } else if (e.getKeyChar() == '9') {
            b9.doClick();
        } else if (e.getKeyChar() == '0') {
            b0.doClick();
        } else if (e.getKeyChar() == '-') {
            bminus.doClick();
        } else if (e.getKeyChar() == '+') {
            bplus.doClick();
        } else if (e.getKeyChar() == '*') {
            bmulti.doClick();
        } else if (e.getKeyChar() == '/') {
            bdiv.doClick();
        } else if (e.getKeyChar() == '=') {
            bequ.doClick();
        } else if (e.getKeyChar() == '^') {
            bpow.doClick();
        } else if (e.getKeyChar() == '.') {
            bdot.doClick();
        } else if (e.getKeyChar() == '^') {
            bpow.doClick();
        } else if (e.getKeyChar() == 'r') {
            broot.doClick();
        } else if (e.getKeyCode() == KeyEvent.VK_DELETE) {
            bc.doClick();
        }
    }

}
