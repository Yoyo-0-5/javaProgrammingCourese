package javaHomework.hw1118;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class GridBagLayoutWindows {

    private JFrame jframe;

    private String[] objText;

    private int[][] gbcParameter;

    private ArrayList<JComponent> GUIComponent;

    private JComponent[] jTextFields;

    private JTextField jTF_FilePathway = null;
    private JTextArea jTF_FileInformation = null;
    private JTextArea jTF_FileContent = null;

    private JScrollPane jSP_FileInformation = null;
    private JScrollPane jSP_FileContent = null;

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

        objText = new String[] {
                "路徑",
                "檔案資訊",
                "狀態列",
                "開啟檔案",
                "讀取內容",
                "加密",
                "解密"
        };

        // gbcParameter: gridx, gridy, gridwidth, gridheight, weightx, weighty, fill,
        // anchor
        gbcParameter = new int[][] {
                { 0, 0, 1, 1, 0, 0, NONE, WEST }, // label: 路徑
                { 0, 1, 1, 1, 0, 0, NONE, WEST }, // label: 檔案資訊
                { 0, 7, 1, 1, 0, 0, BOTH, WEST }, // label: 檔案內容
                { 1, 0, 4, 1, 1, 0, BOTH, WEST }, // 路徑的 TextField
                { 1, 1, 4, 5, 1, 1, BOTH, WEST }, // 檔案資訊的 TextArea
                { 1, 7, 4, 7, 1, 1, BOTH, WEST }, // 檔案內容的 TextArea
                { 1, 6, 1, 1, 1, 0, BOTH, CENTER }, // Button 開啟檔案
                { 2, 6, 1, 1, 1, 0, BOTH, CENTER }, // Button 讀取內容
                { 3, 6, 1, 1, 1, 0, BOTH, CENTER }, // Button 加密
                { 4, 6, 1, 1, 1, 0, BOTH, CENTER } // Button 解密
        };
        dojTextFields();
        doButtonActionListener();
        jTextFields = new JComponent[] { jTF_FilePathway, jSP_FileInformation, jSP_FileContent };
        jButtonActionListener = new ActionListener[] { openFile, roadFileText, encode, decode };
        GUIComponent = new ArrayList<JComponent>();
    }

    public void run() {
        jframe.setSize(800, 300);
        jframe.setLayout(new GridBagLayout());
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for (int i = 0; i < 3; i++) {
            JLabel jlabel = new JLabel(objText[i]);
            GUIComponent.add(jlabel);
        }

        for (int i = 0; i < jTextFields.length; i++) {
            GUIComponent.add(jTextFields[i]);
        }

        for (int i = 3; i < objText.length; i++) {
            JButton jbutton = new JButton(objText[i]);
            jbutton.addActionListener(jButtonActionListener[i - 3]);
            GUIComponent.add(jbutton);
        }

        for (int i = 0; i < GUIComponent.size(); i++) {
            addComponent(i);
        }

        jframe.setVisible(true);
    }

    public void dojTextFields() {
        jTF_FilePathway = new JTextField("", 24);
        jTF_FileInformation = new JTextArea("");
        jTF_FileContent = new JTextArea("");
        jSP_FileInformation = new JScrollPane(jTF_FileInformation);
        jSP_FileContent = new JScrollPane(jTF_FileContent);
    }

    public void doButtonActionListener() {
        openFile = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("openFile");
                JFileChooser fc = new JFileChooser();
                int returnVal = fc.showOpenDialog(jframe);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = fc.getSelectedFile();
                    jTF_FilePathway.setText(file.getAbsolutePath());
                } 
                else {
                    jTF_FilePathway.setText("Open command cancelled by user.");
                }
            }
        };
        roadFileText = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("roadFileText");
                File f = new File(jTF_FilePathway.getText());
                StringBuilder sb = new StringBuilder();
                sb.append(f.getName() + "檔案資訊如下\n");
                sb.append("==========================\n");
                sb.append("檔案長度: " + f.length() + " bytes\n");
                sb.append("檔案或目錄: " + (f.isFile() ? "檔案" : "非檔案") + "\n");
                sb.append("檔案或目錄: " + (f.isDirectory() ? "目錄" : "非目錄") + "\n");
                sb.append("是否可讀: " + (f.canRead() ? "可讀" : "不可讀") + "\n");
                sb.append("是否可寫: " + (f.canWrite() ? "可寫" : "不可寫") + "\n");
                sb.append("是否隱藏: " + (f.isHidden() ? "是" : "否") + "\n");
                sb.append("最後修改日期: " + new Date(f.lastModified()) + "\n");
                sb.append("檔案名: " + f.getName() + "\n");
                sb.append("檔案路徑: " + f.getPath() + "\n");
                sb.append("絕對路徑: " + f.getAbsolutePath() + "\n");
                jTF_FileInformation.setText(sb.toString());
                jTF_FileContent.setText(roadData(jTF_FilePathway.getText()).toString());
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
        c.gridheight = gbcParameter[i][3];
        c.weightx = gbcParameter[i][4];
        c.weighty = gbcParameter[i][5];
        c.fill = gbcParameter[i][6];
        c.anchor = gbcParameter[i][7];
        jframe.add(GUIComponent.get(i), c);
    }

    private StringBuffer roadData(String pathway) {
        StringBuffer sb = new StringBuffer();
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(pathway)));
            String text = "";
            while((text = br.readLine()) != null) {
                sb.append(text + "\n");
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb;
    }

    public static void main(String[] args) {
        new GridBagLayoutWindows().run();
    }
}
