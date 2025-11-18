package javaHomework.hw1118;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

public class GridBagLayoutWindows {

    private JFrame jframe;

    private String[] objText;

    private int[][] gbcParameter;

    private ArrayList<JComponent> GUIComponent;

    private JTextComponent[] JTextFields;

    private JTextField JTF_FilePathway = null;
    private JTextArea JTF_FileInfomation = null;

    private ActionListener[] jButtonActionListener;
    private ActionListener openFile = null;
    private ActionListener roadFileText = null;
    private ActionListener encode = null;
    private ActionListener decode = null;

    final int BOTH = GridBagConstraints.BOTH;
    final int VERTICAL = GridBagConstraints.VERTICAL;
    final int HORIZONTAL = GridBagConstraints.HORIZONTAL;
    final int NONE = GridBagConstraints.NONE;
    final int CENTER = GridBagConstraints.CENTER;
    final int EAST = GridBagConstraints.EAST;
    final int SOUTHEAST = GridBagConstraints.SOUTHEAST;
    final int SOUTH = GridBagConstraints.SOUTH;
    final int SOUTHWEST = GridBagConstraints.SOUTHWEST;
    final int WEST = GridBagConstraints.WEST;
    final int NORTHWEST = GridBagConstraints.NORTHWEST;
    final int NORTH = GridBagConstraints.NORTH;
    final int NORTHEAST = GridBagConstraints.NORTHEAST;

    public GridBagLayoutWindows() {

        jframe = new JFrame();

        objText =  new String[] {
            "路徑",
            "檔案資訊",
            "狀態列",
            "開啟檔案",
            "讀取內容",
            "加密",
            "解密"
        };

        gbcParameter = new int[][] {
            {0, 0, 1, 1, 0, 0, NONE, WEST},
            {0, 1, 1, 1, 0, 0, NONE, WEST},
            {0, 7, 5, 1, 1, 0, BOTH, WEST},
            {1, 0, 4, 1, 1, 0, BOTH, WEST},
            {1, 1, 4, 1, 1, 0, BOTH, WEST},
            {1, 6, 1, 1, 1, 0, BOTH, CENTER},
            {2, 6, 1, 1, 1, 0, BOTH, CENTER},
            {3, 6, 1, 1, 1, 0, BOTH, CENTER},
            {4, 6, 1, 1, 1, 0, BOTH, CENTER}
        };
        doJTextFields();
        doButtonActionListener();
    }

    public void run() {
        jframe.setSize(800, 300);
        jframe.setLayout(new GridBagLayout());
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for (int i = 0; i < 3; i++) {
            JLabel jlabel = new JLabel(objText[i]);
            GUIComponent.add(jlabel);
        }

        for (int i = 0; i < JTextFields.length; i++) {
            
        }
    }

    public void doJTextFields() {
        JTF_FilePathway = new JTextField("", 24);
        JTF_FileInfomation = new JTextArea("");
    }

    public void doButtonActionListener() {
        openFile = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("openFile");
            }
        };
        roadFileText = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("roadFileText");
            }
        };
        encode = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("encode");
            }
        };
        decode = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("decode");
            }
        };
    }

    private void addComponent(int i) {
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = gbcParameter[i][0];
        c.gridy = gbcParameter[i][1];
        c.gridwidth = gbcParameter[i][2];
    }

    public static void main(String[] args) {
        new GridBagLayoutWindows();
    }
}
